import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.prefs.Preferences;

/**
 * SecureCheck: protótipo funcional em Java Swing.
 * Feito para estudo, com código simples, sem bibliotecas externas.
 */
public class Main extends JFrame {

    static final Color ROXO = new Color(122, 23, 90);
    static final Color ROSA = new Color(200, 42, 124);
    static final Color ROXO_ESCURO = new Color(74, 10, 58);
    static final Color VERDE_RESULTADO = new Color(108, 177, 110);
    static final Color LARANJA_RESULTADO = new Color(186, 118, 118);

    static final String[] TEMAS = {
        "Geral",
        "Golpes digitais",
        "Senhas e contas",
        "Privacidade online",
        "Navegação segura"
    };

    static final String[] TITULOS_MATERIAIS = {
        "Como não cair em armadilhas digitais",
        "Como proteger sua vida online",
        "Protegendo sua família e seus dados",
        "A importância de atualizar suas chaves de segurança",
        "Como checar a segurança e os certificados de um site"
    };

    static final String[] TEXTOS_MATERIAIS = {
        "Você já reparou como a nossa vida inteira cabe dentro do celular hoje em dia? " +
        "Conversamos com amigos, pagamos contas e guardamos nossas melhores lembranças ali. " +
        "O problema é que, do mesmo jeito que a internet facilitou a nossa rotina, ela também abriu portas " +
        "para pessoas mal-intencionadas. E a maior arma desses golpistas não é um programa de computador " +
        "super avançado, mas sim a nossa própria distração ou curiosidade. Eles usam uma tática chamada " +
        "engenharia social, que nada mais é do que aquela velha conversa fiada para tentar nos enganar e nos " +
        "fazer entregar um segredo sem perceber.\n\n" +
        "Geralmente, essas armadilhas começam com mensagens alarmantes ou ofertas boas demais para ser verdade. " +
        "Antes de clicar em um link, confirme o remetente e procure o canal oficial da empresa. Nunca informe " +
        "senhas ou códigos recebidos por SMS a desconhecidos. Se alguém pedir um Pix urgente fingindo ser um " +
        "familiar, confirme por ligação ou de outro jeito seguro.",

        "Nossa vida online tem contas de e-mail, redes sociais e aplicativos importantes. Para protegê-los, " +
        "use senhas diferentes e difíceis de adivinhar. Uma frase longa pode ser mais fácil de lembrar do que " +
        "uma sequência curta.\n\n" +
        "Ative a verificação em duas etapas sempre que o serviço oferecer. Assim, mesmo que alguém descubra sua senha, " +
        "ainda precisará de outra confirmação. Evite compartilhar códigos de acesso. Se receber um aviso estranho sobre " +
        "sua conta, abra o aplicativo oficial em vez de entrar por um link da mensagem.",

        "Proteger dados também é um cuidado com as pessoas que convivem com você. Converse com crianças e familiares " +
        "sobre mensagens suspeitas, perfis falsos e pedidos inesperados de dinheiro.\n\n" +
        "Evite publicar informações pessoais sem necessidade, como documentos, endereço e detalhes da rotina. Faça cópias " +
        "de segurança de arquivos importantes e revise quem pode ver suas publicações. Se um parente pedir dinheiro por " +
        "um número novo, procure confirmar a identidade dele antes de transferir.",

        "Atualizações de segurança corrigem problemas que podem ser explorados por criminosos. Por isso, mantenha celular, " +
        "computador, navegador e aplicativos atualizados.\n\n" +
        "Também é importante trocar senhas que vazaram e revisar dispositivos conectados às suas contas. Quando disponível, " +
        "prefira autenticação em duas etapas. Não existe uma senha que fique segura para sempre, principalmente quando ela " +
        "é repetida em vários serviços.",

        "Antes de digitar dados em um site, confira o endereço completo. Golpistas podem criar páginas com nomes muito " +
        "parecidos com os de empresas conhecidas. Um cadeado na barra do navegador indica conexão criptografada, mas não " +
        "prova que a empresa ou loja seja confiável.\n\n" +
        "Se o site pedir dados demais, oferecer vantagens inacreditáveis ou pressionar você a agir imediatamente, desconfie. " +
        "Procure o endereço oficial, verifique a reputação da loja e não siga links enviados por desconhecidos."
    };

    static final String[] TEXTOS_MATERIAIS_FACEIS = {
        "Hoje quase tudo da nossa vida está no celular: conversa, foto, conta e até dinheiro. Isso é prático, mas também " +
        "faz muita gente cair em golpe. O golpe nem sempre depende de um programa complicado. Muitas vezes, ele depende " +
        "da pressa, da curiosidade ou do susto da vítima.\n\n" +
        "Por isso, desconfie de mensagens urgentes, promessas boas demais e pedidos de dinheiro. Antes de clicar em links " +
        "ou mandar dados, pare e confira se aquilo é verdadeiro. Se alguém disser que é um familiar e pedir Pix, confirme " +
        "por ligação ou por outro número confiável.",

        "Para cuidar melhor das suas contas, use senhas diferentes e não escolha senhas fáceis, como data de nascimento ou " +
        "123456. Uma boa ideia é usar uma frase que só faça sentido para você.\n\n" +
        "Também ative a confirmação em duas etapas. Assim, além da senha, o aplicativo pede uma segunda confirmação. Isso " +
        "dificulta muito a invasão. E lembre-se: nunca entregue código recebido por SMS ou aplicativo para outra pessoa.",

        "Privacidade não é exagero: é cuidado. Quanto menos informação pessoal você espalha, menor a chance de alguém usar " +
        "isso contra você ou sua família.\n\n" +
        "Converse com as pessoas da casa sobre golpes, mensagens estranhas e perfis falsos. Evite postar dados como endereço, " +
        "documentos ou rotina da família. Se aparecer um pedido de dinheiro ou documento, confira com calma antes de responder.",

        "Atualizar o celular e o computador é uma forma simples de proteção. Quando um aplicativo ou sistema pede atualização, " +
        "muitas vezes ele está corrigindo falhas de segurança.\n\n" +
        "Além disso, vale trocar senhas antigas e revisar quais aparelhos estão conectados nas suas contas. É um cuidado simples " +
        "que pode evitar muita dor de cabeça.",

        "Antes de colocar qualquer dado em um site, olhe com calma o endereço. Alguns golpes usam páginas muito parecidas com " +
        "as verdadeiras.\n\n" +
        "O cadeado ajuda, mas não garante que o site seja honesto. Desconfie de promoções milagrosas, mensagens que pressionam " +
        "você a agir rápido e páginas que pedem informação demais. Quando puder, entre no site oficial digitando o endereço por conta própria."
    };

    static class Questao {
        String tema;
        String enunciado;
        String enunciadoFacil;
        String[] alternativas;
        int correta;
        String explicacao;
        String explicacaoFacil;

        Questao(String tema, String enunciado, String enunciadoFacil,
                String[] alternativas, int correta, String explicacao, String explicacaoFacil) {
            this.tema = tema;
            this.enunciado = enunciado;
            this.enunciadoFacil = enunciadoFacil;
            this.alternativas = alternativas;
            this.correta = correta;
            this.explicacao = explicacao;
            this.explicacaoFacil = explicacaoFacil;
        }

        String getEnunciado(boolean facil) {
            return facil ? enunciadoFacil : enunciado;
        }

        String getExplicacao(boolean facil) {
            return facil ? explicacaoFacil : explicacao;
        }
    }

    JPanel tela = new JPanel();
    Preferences preferencias = Preferences.userNodeForPackage(Main.class);
    File arquivoHistorico = new File(System.getProperty("user.home"), "securecheck_historico.txt");

    boolean modoEscuro;
    boolean modoFacil;
    boolean textoMaior;
    boolean altoContraste;

    String pagina = "home";
    String tema = "Geral";
    int quantidade = 2;
    int questaoAtual = 0;
    int[] respostas = new int[0];
    boolean[] confirmadas = new boolean[0];
    boolean quizEmAndamento = false;
    ArrayList<String> historico = new ArrayList<>();
    ArrayList<Questao> questoesAtuais = new ArrayList<>();
    Map<String, ArrayList<Questao>> bancoQuestoes = new LinkedHashMap<>();

    Main() {
        setTitle("SecureCheck - Projeto Java Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // A tela do Penpot foi adaptada para 350 x 720 pixels.
        // Os valores setBounds abaixo seguem as proporcoes da pagina original.
        tela.setPreferredSize(new Dimension(350, 720));
        tela.setLayout(null);
        setContentPane(tela);

        modoEscuro = preferencias.getBoolean("escuro", false);
        modoFacil = preferencias.getBoolean("facil", true);
        textoMaior = preferencias.getBoolean("maior", true);
        altoContraste = preferencias.getBoolean("contraste", false);

        iniciarBancoQuestoes();
        carregarHistorico();

        mostrarAbertura();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        Timer abertura = new Timer(900, e -> {
            if (pagina.equals("abertura")) mostrarHome();
        });
        abertura.setRepeats(false);
        abertura.start();
    }

    void iniciarBancoQuestoes() {
        for (int i = 1; i < TEMAS.length; i++) {
            bancoQuestoes.put(TEMAS[i], new ArrayList<>());
        }

        // Golpes digitais
        adicionarQuestao("Golpes digitais",
            "Um usuário recebe um e-mail aparentemente legítimo informando bloqueio da conta e solicitando a digitação da senha em um link externo. Esse cenário caracteriza:",
            "Chegou um e-mail assustando você e pedindo para clicar num link e digitar a senha. Que golpe é esse?",
            new String[]{"Phishing", "Backup", "Firewall", "Atualização"}, 0,
            "Phishing é quando o golpista finge ser uma empresa ou serviço confiável para roubar dados da vítima.",
            "Phishing é um golpe em que a pessoa finge ser confiável para pegar sua senha ou outros dados.");

        adicionarQuestao("Golpes digitais",
            "Uma mensagem é enviada por número desconhecido, mas utiliza a foto de um familiar e solicita uma transferência urgente via Pix. Essa situação descreve, principalmente, um caso de:",
            "Alguém usa a foto de um parente e pede dinheiro por um número novo. Isso costuma ser que tipo de golpe?",
            new String[]{"Ataque DDoS", "Roubo de identidade", "Formatação", "Cache"}, 1,
            "Nesse caso, o criminoso se passa por outra pessoa para enganar a vítima. Isso é falsidade ou roubo de identidade.",
            "Aqui o golpista finge ser outra pessoa para enganar você. Isso é roubo de identidade.");

        adicionarQuestao("Golpes digitais",
            "Uma mensagem promete um prêmio, mas diz que você precisa pagar uma pequena taxa antes de receber. O melhor a fazer é:",
            "Você ganhou um prêmio, mas pedem uma taxa para liberar. O que fazer?",
            new String[]{"Pagar logo", "Ignorar e desconfiar", "Enviar CPF primeiro", "Passar o cartão"}, 1,
            "Prêmios verdadeiros não costumam exigir pagamento antecipado. Isso é um sinal clássico de golpe.",
            "Se pedem dinheiro para liberar um prêmio, desconfie. O mais seguro é ignorar.");

        adicionarQuestao("Golpes digitais",
            "Uma pessoa liga dizendo ser do banco e pede o código que acabou de chegar por SMS. Você deve:",
            "Alguém liga falando que é do banco e pede o código do SMS. O que fazer?",
            new String[]{"Informar o código", "Passar só os últimos números", "Não informar e desligar", "Mandar por WhatsApp"}, 2,
            "Bancos não pedem código de verificação por telefone. Esse código pode permitir acesso à sua conta.",
            "Nunca passe código recebido no celular. Esse código pode dar acesso à sua conta.");

        adicionarQuestao("Golpes digitais",
            "Você recebe um SMS sobre uma encomenda com link para pagamento de taxa. Antes de tudo, o correto é:",
            "Chegou SMS dizendo que sua encomenda precisa de taxa e tem um link. O que fazer antes?",
            new String[]{"Clicar correndo", "Confirmar no site oficial da entrega", "Responder ao SMS", "Baixar um aplicativo qualquer"}, 1,
            "Mensagens de entrega falsas são comuns. O ideal é verificar diretamente no aplicativo ou site oficial da empresa.",
            "Esse tipo de golpe é comum. Confira a encomenda no app ou site oficial da transportadora.");

        adicionarQuestao("Golpes digitais",
            "Em um anúncio, uma loja vende um celular muito barato e só aceita pagamento por Pix imediato. Isso é sinal de:",
            "Uma loja oferece produto barato demais e quer Pix na hora. Isso pode ser sinal de quê?",
            new String[]{"Promoção normal", "Golpe ou fraude", "Atualização de preço", "Erro sem risco"}, 1,
            "Preço muito abaixo do normal, urgência e pagamento fora de plataformas seguras são indícios de fraude.",
            "Preço bom demais e pressão para pagar rápido podem indicar golpe.");

        adicionarQuestao("Golpes digitais",
            "Uma pessoa conhecida envia link estranho dizendo 'veja isso agora!'. A atitude mais segura é:",
            "Um amigo manda um link estranho e diz 'olha isso!'. O que é mais seguro fazer?",
            new String[]{"Abrir imediatamente", "Responder com senha", "Confirmar com a pessoa antes", "Repassar o link"}, 2,
            "Contas podem ser invadidas. Confirmar com a pessoa evita cair em links maliciosos.",
            "A conta do amigo pode ter sido roubada. Melhor confirmar antes de abrir.");

        adicionarQuestao("Golpes digitais",
            "Um suposto suporte técnico pede acesso remoto ao seu computador por telefone. O correto é:",
            "Alguém diz ser do suporte e quer mexer no seu computador à distância. O que fazer?",
            new String[]{"Permitir sem perguntar", "Recusar e buscar o suporte oficial", "Passar senha do e-mail", "Desativar o antivírus"}, 1,
            "Acesso remoto só deve ser concedido a canais oficiais e confiáveis, nunca a abordagens inesperadas.",
            "Não deixe desconhecidos entrarem no seu computador. Procure o suporte oficial da empresa.");

        adicionarQuestao("Golpes digitais",
            "Em uma rede social, um perfil recém-criado oferece investimento com lucro garantido. Isso deve ser visto como:",
            "Um perfil novo promete ganho fácil e garantido. Como olhar para isso?",
            new String[]{"Grande oportunidade", "Conteúdo educativo", "Possível golpe", "Apenas propaganda comum"}, 2,
            "Promessas de lucro garantido, sem risco e com urgência são fortes indícios de golpe financeiro.",
            "Quando prometem dinheiro fácil e garantido, o mais seguro é desconfiar.");

        adicionarQuestao("Golpes digitais",
            "Ao procurar emprego, um anúncio pede pagamento para garantir a vaga. O mais seguro é:",
            "Uma vaga de emprego pede dinheiro para liberar a contratação. O que fazer?",
            new String[]{"Pagar a taxa", "Enviar documento e senha", "Desconfiar e não pagar", "Transferir metade"}, 2,
            "Cobrar dinheiro para contratar alguém é prática suspeita e comum em golpes falsos de emprego.",
            "Empresa séria não costuma cobrar para contratar. O melhor é não pagar.");

        // Senhas e contas
        adicionarQuestao("Senhas e contas",
            "Considerando boas práticas de autenticação, qual das opções representa a senha mais robusta?",
            "Qual dessas senhas é melhor?",
            new String[]{"123456", "senha123", "Mar!nha-cafe-2026", "010203"}, 2,
            "Senhas longas, com mistura de caracteres e sem padrão óbvio, são mais seguras.",
            "Senhas maiores e menos óbvias são mais seguras.");

        adicionarQuestao("Senhas e contas",
            "Usar a mesma senha em vários sites é arriscado porque:",
            "Por que repetir a mesma senha em vários lugares é perigoso?",
            new String[]{"Deixa o login mais rápido", "Se uma vazar, várias contas ficam em risco", "Economiza memória do celular", "Facilita suporte técnico"}, 1,
            "Quando uma senha vaza, criminosos tentam usá-la em vários serviços. Isso amplia o dano.",
            "Se uma senha repetida vazar, o invasor pode entrar em várias contas suas.");

        adicionarQuestao("Senhas e contas",
            "A verificação em duas etapas serve para:",
            "A confirmação em duas etapas serve para quê?",
            new String[]{"Substituir a internet", "Adicionar uma camada extra de proteção", "Apagar cookies", "Aumentar a bateria"}, 1,
            "Ela exige uma segunda prova de identidade, como código no celular, além da senha.",
            "Ela pede mais uma confirmação além da senha, deixando a conta mais protegida.");

        adicionarQuestao("Senhas e contas",
            "Um gerenciador de senhas ajuda o usuário porque:",
            "Para que serve um gerenciador de senhas?",
            new String[]{"Cria e guarda senhas fortes", "Troca a tela do celular", "Bloqueia Wi-Fi", "Instala antivírus"}, 0,
            "Gerenciadores ajudam a criar senhas diferentes e fortes, sem que a pessoa precise decorar todas.",
            "Ele ajuda a guardar e criar senhas boas, sem você precisar lembrar de tudo sozinho.");

        adicionarQuestao("Senhas e contas",
            "Ao usar um computador público para entrar no e-mail, o ideal é:",
            "Você entrou no e-mail em computador de outra pessoa. O que fazer ao sair?",
            new String[]{"Só fechar a aba", "Deixar salvo para a próxima vez", "Sair da conta e não salvar senha", "Anotar a senha na mesa"}, 2,
            "Em computadores públicos ou compartilhados, é essencial encerrar a sessão e não salvar credenciais.",
            "Em computador emprestado, saia da conta e não salve a senha.");

        adicionarQuestao("Senhas e contas",
            "Se você receber um aviso de login desconhecido em sua conta, a melhor reação é:",
            "Chegou aviso de acesso estranho na sua conta. O que fazer primeiro?",
            new String[]{"Ignorar", "Trocar a senha e revisar dispositivos", "Apagar fotos", "Desligar o celular"}, 1,
            "Trocar a senha e revisar sessões ou dispositivos conectados ajuda a recuperar a segurança rapidamente.",
            "Troque a senha e veja se tem aparelho ou acesso estranho ligado na conta.");

        adicionarQuestao("Senhas e contas",
            "Qual atitude é correta em relação a códigos de autenticação recebidos por SMS?",
            "O que fazer com códigos de login recebidos por SMS?",
            new String[]{"Compartilhar com quem pedir", "Guardar em rede social", "Nunca compartilhar com terceiros", "Enviar ao suporte por mensagem"}, 2,
            "Esses códigos confirmam sua identidade. Se outra pessoa tiver acesso a eles, poderá entrar na sua conta.",
            "Esses códigos são pessoais. Se você passar para alguém, a pessoa pode entrar na sua conta.");

        adicionarQuestao("Senhas e contas",
            "Qual destas práticas ajuda mais a proteger uma conta importante?",
            "Qual hábito ajuda mais a proteger uma conta importante?",
            new String[]{"Usar senha curta e fácil", "Desativar notificações", "Atualizar senha vazada e ativar 2 etapas", "Mandar a senha para si mesmo por mensagem"}, 2,
            "Trocar senhas comprometidas e usar verificação em duas etapas melhora muito a segurança da conta.",
            "Se a senha vazou, troque. E ligue a confirmação em duas etapas para proteger melhor.");

        adicionarQuestao("Senhas e contas",
            "Perguntas de segurança como 'nome do pet' devem ser tratadas com cuidado porque:",
            "Por que perguntas como 'nome do pet' podem ser perigosas?",
            new String[]{"São sempre proibidas", "Podem ser descobertas em redes sociais", "Gastam internet", "Apagam a conta"}, 1,
            "Informações pessoais podem estar expostas em redes sociais e ser usadas para tentar recuperar sua conta.",
            "Muita gente posta esse tipo de informação na internet, então alguém pode adivinhar.");

        adicionarQuestao("Senhas e contas",
            "Se um site pedir troca urgente de senha por um link recebido no e-mail, o mais seguro é:",
            "Chegou um e-mail mandando trocar a senha por um link. O que é mais seguro?",
            new String[]{"Abrir o link direto", "Entrar no site ou app oficial por conta própria", "Enviar a senha antiga por resposta", "Ignorar toda mudança de senha para sempre"}, 1,
            "Quando há dúvida, o ideal é acessar o serviço pelo canal oficial, não pelo link da mensagem.",
            "Em vez de clicar no link, abra o aplicativo ou site oficial sozinho e veja se o aviso é real.");

        // Privacidade online
        adicionarQuestao("Privacidade online",
            "A publicação de fotos de uma viagem em tempo real pode ampliar riscos de exposição porque:",
            "Por que postar a viagem na hora pode ser perigoso?",
            new String[]{"Gasta bateria", "Mostra que a casa pode estar vazia", "Faz perder seguidores", "Bloqueia o GPS"}, 1,
            "Mostrar sua localização e ausência em tempo real pode expor sua rotina e sua residência.",
            "Postar na hora pode mostrar que você não está em casa.");

        adicionarQuestao("Privacidade online",
            "Ao instalar um aplicativo de lanterna, ele pede acesso aos contatos e ao microfone. O melhor é:",
            "Um app simples pede acesso demais. O que fazer?",
            new String[]{"Aceitar tudo", "Negar ou procurar outro aplicativo", "Dar acesso e esquecer", "Mandar para amigos"}, 1,
            "Permissões devem ser coerentes com a função do aplicativo. Pedidos excessivos merecem desconfiança.",
            "Se o app pede coisa que não precisa, melhor negar ou usar outro app.");

        adicionarQuestao("Privacidade online",
            "Uma boa prática nas redes sociais é:",
            "Qual é uma boa atitude nas redes sociais?",
            new String[]{"Deixar tudo público sem revisar", "Revisar configurações de privacidade", "Postar documentos pessoais", "Aceitar qualquer perfil"}, 1,
            "Configurações de privacidade ajudam a limitar quem vê seus dados e suas publicações.",
            "Revisar quem pode ver seus posts ajuda a proteger sua vida pessoal.");

        adicionarQuestao("Privacidade online",
            "Se um perfil falso usa sua foto e seu nome, o correto é:",
            "Criaram um perfil falso com seu nome. O que fazer?",
            new String[]{"Ignorar para sempre", "Denunciar à plataforma e avisar conhecidos", "Enviar senha ao perfil", "Curtir o perfil"}, 1,
            "Denunciar ajuda a remover o perfil e avisar conhecidos evita que outras pessoas caiam no golpe.",
            "Denuncie o perfil falso e avise as pessoas para ninguém cair.");

        adicionarQuestao("Privacidade online",
            "Compartilhar foto de documentos em grupo de mensagens é arriscado porque:",
            "Por que é ruim mandar foto de documento em qualquer grupo?",
            new String[]{"Deixa a imagem bonita", "Pode expor dados pessoais e facilitar fraudes", "Melhora o sinal", "Ativa vírus automaticamente"}, 1,
            "Documentos contêm informações pessoais que podem ser usadas em fraudes ou roubos de identidade.",
            "Documento tem dados importantes. Se cair na mão errada, pode virar problema.");

        adicionarQuestao("Privacidade online",
            "Qual atitude ajuda a proteger crianças e idosos de golpes online?",
            "O que ajuda a proteger crianças e idosos na internet?",
            new String[]{"Não conversar sobre o tema", "Orientar sobre mensagens suspeitas e pedidos de dinheiro", "Passar senhas para todos", "Deixar tudo aberto"}, 1,
            "Educação digital e conversa frequente ajudam a evitar golpes e decisões por impulso.",
            "Conversar e explicar os golpes ajuda muito a evitar problemas.");

        adicionarQuestao("Privacidade online",
            "Ao fazer um cadastro, o ideal é informar:",
            "Quando for se cadastrar, o melhor é passar: ",
            new String[]{"Todos os dados possíveis", "Somente os dados necessários", "Dados inventados em tudo", "A senha do banco"}, 1,
            "Quanto menos dados pessoais você compartilhar sem necessidade, menor será sua exposição.",
            "Passe só o que realmente for necessário.");

        adicionarQuestao("Privacidade online",
            "Antes de aceitar solicitação de amizade de um perfil desconhecido, o melhor é:",
            "Recebeu pedido de amizade de alguém que você não conhece. O que fazer?",
            new String[]{"Aceitar logo", "Verificar se o perfil parece verdadeiro", "Enviar CPF", "Passar número do cartão"}, 1,
            "Perfis falsos são usados para coleta de dados, golpes e aproximação maliciosa.",
            "Perfis falsos existem. Antes de aceitar, confira se a conta parece real.");

        adicionarQuestao("Privacidade online",
            "Qual informação deve ser tratada com mais cuidado ao postar na internet?",
            "Qual dado pessoal merece mais cuidado ao postar?",
            new String[]{"Endereço residencial", "Cor favorita", "Filme preferido", "Time de futebol"}, 0,
            "Endereço é um dado sensível, pois pode expor sua localização e sua segurança física.",
            "Endereço de casa é algo muito pessoal e pode trazer risco.");

        adicionarQuestao("Privacidade online",
            "Fazer backup de fotos e documentos importantes é útil porque:",
            "Por que fazer cópia de segurança é bom?",
            new String[]{"Ocupa espaço à toa", "Ajuda a recuperar arquivos se algo acontecer", "Aumenta golpes", "Desliga o antivírus"}, 1,
            "Backups permitem recuperar arquivos em caso de perda, roubo do aparelho ou falha técnica.",
            "Se você perder o aparelho ou apagar algo sem querer, o backup ajuda a recuperar.");

        // Navegação segura
        adicionarQuestao("Navegação segura",
            "Ao acessar serviços financeiros online, a conduta mais segura é:",
            "Para entrar no site do banco, o que é mais seguro?",
            new String[]{"Entrar por qualquer link recebido", "Digitar o endereço oficial ou usar o app", "Usar link de rede social", "Abrir anúncio aleatório"}, 1,
            "Acessar pelo canal oficial reduz o risco de cair em páginas falsas.",
            "Usar o app ou digitar o endereço oficial é bem mais seguro.");

        adicionarQuestao("Navegação segura",
            "Um cadeado no navegador indica principalmente que:",
            "Quando aparece um cadeado no navegador, isso quer dizer principalmente que:",
            new String[]{"O site é sempre honesto", "A conexão é protegida", "O produto é barato", "O site não tem anúncios"}, 1,
            "O cadeado mostra que a comunicação é criptografada, mas não garante que o site seja confiável.",
            "O cadeado ajuda, mas não prova que o site é honesto. Ele mostra mais a proteção da conexão.");

        adicionarQuestao("Navegação segura",
            "Se o navegador mostrar aviso de certificado inválido, o ideal é:",
            "O navegador avisou que o site não é seguro. O que fazer?",
            new String[]{"Ignorar sempre", "Continuar por curiosidade", "Sair e verificar se o endereço está correto", "Digitar senha mesmo assim"}, 2,
            "Avisos de certificado podem indicar risco de fraude, erro de configuração ou interceptação da conexão.",
            "Se o navegador avisa perigo, o melhor é sair e conferir o endereço com calma.");

        adicionarQuestao("Navegação segura",
            "Baixar programas somente de sites oficiais é importante porque:",
            "Por que é melhor baixar programas no site oficial?",
            new String[]{"Fica mais bonito", "Reduz risco de arquivos adulterados", "Economiza bateria", "Aumenta a fonte"}, 1,
            "Fontes oficiais diminuem a chance de instalar versões modificadas com malware.",
            "Baixar do lugar certo reduz a chance de pegar programa alterado ou malicioso.");

        adicionarQuestao("Navegação segura",
            "Uma extensão de navegador deve ser instalada quando:",
            "Quando vale instalar uma extensão no navegador?",
            new String[]{"Qualquer uma", "For conhecida, necessária e confiável", "Vier em anúncio piscando", "Pedir muitas permissões"}, 1,
            "Extensões podem acessar dados de navegação. Por isso, devem ser escolhidas com cuidado.",
            "Extensão pode ver muita coisa do seu navegador. Então escolha só as confiáveis.");

        adicionarQuestao("Navegação segura",
            "Em um Wi‑Fi público, é melhor evitar:",
            "No Wi‑Fi público, o que é melhor evitar?",
            new String[]{"Ler notícias", "Acessar contas sensíveis sem cuidado", "Usar fone de ouvido", "Abaixar brilho da tela"}, 1,
            "Redes públicas podem oferecer mais risco. Evite operações importantes sem proteção adequada.",
            "Wi‑Fi público pede mais cuidado. Evite entrar em contas muito importantes sem necessidade.");

        adicionarQuestao("Navegação segura",
            "Qual endereço parece mais confiável para o site oficial de uma loja chamada SuperCompra?",
            "Qual endereço parece o mais certo para a loja SuperCompra?",
            new String[]{"supercompra-ofertas-gratis.biz", "supercompra.com.br", "supercompra.seguro.ru", "promo-supercompra.click"}, 1,
            "Endereços simples, coerentes e ligados ao domínio oficial da marca tendem a ser mais confiáveis.",
            "O endereço oficial costuma ser mais simples e direto.");

        adicionarQuestao("Navegação segura",
            "Pop-ups dizendo 'seu computador está com vírus, clique aqui agora' devem ser tratados com:",
            "Apareceu janela dizendo que seu computador está cheio de vírus e manda clicar. Como tratar isso?",
            new String[]{"Confiança total", "Cuidado e desconfiança", "Obrigação de pagamento", "Sinal de atualização oficial"}, 1,
            "Pop-ups alarmistas são usados para assustar o usuário e induzi-lo a instalar algo ou pagar por golpe.",
            "Essas janelas costumam assustar para fazer você clicar. O melhor é desconfiar.");

        adicionarQuestao("Navegação segura",
            "Manter o navegador atualizado ajuda porque:",
            "Por que atualizar o navegador é importante?",
            new String[]{"Muda a cor do ícone", "Corrige falhas e melhora a segurança", "Cria senha automática", "Apaga o histórico do banco"}, 1,
            "Atualizações corrigem vulnerabilidades e reduzem o risco de exploração por sites maliciosos.",
            "Atualizar o navegador corrige falhas e ajuda na proteção.");

        adicionarQuestao("Navegação segura",
            "Se um site usar contagem regressiva e pressão para você comprar 'agora ou nunca', o melhor é:",
            "Se o site faz pressão para você decidir correndo, o melhor é:",
            new String[]{"Comprar sem pensar", "Parar, analisar e verificar a confiança do site", "Passar o cartão logo", "Compartilhar com todo mundo"}, 1,
            "Urgência artificial é uma técnica comum para impedir que a pessoa pense e verifique se a oferta é segura.",
            "Pressão e correria são sinais para você parar e conferir melhor.");
    }

    void adicionarQuestao(String tema, String enunciado, String enunciadoFacil,
                          String[] alternativas, int correta,
                          String explicacao, String explicacaoFacil) {
        bancoQuestoes.get(tema).add(new Questao(tema, enunciado, enunciadoFacil, alternativas, correta, explicacao, explicacaoFacil));
    }

    void mostrarAbertura() {
        prepararTela("abertura");
        texto("SecureCheck", 0, 324, 350, 80, 39, true, destaque());
        tela.revalidate();
        tela.repaint();
    }

    Color fundo() {
        if (altoContraste) return Color.BLACK;
        return modoEscuro ? new Color(31, 24, 35) : Color.WHITE;
    }

    Color destaque() {
        return altoContraste ? Color.YELLOW : ROSA;
    }

    Color corFaixa() {
        return altoContraste ? Color.BLACK : ROXO;
    }

    Color corBotao() {
        return altoContraste ? Color.YELLOW : ROSA;
    }

    Color corTexto() {
        return altoContraste ? Color.WHITE : (modoEscuro ? Color.WHITE : ROXO);
    }

    int tamanho(int valor) {
        if (!textoMaior) return valor;
        if (valor <= 19) return valor + 2;
        return valor + 1;
    }

    void prepararTela(String nome) {
        pagina = nome;
        tela.removeAll();
        tela.setBackground(fundo());
    }

    void finalizarTela(String menuAtivo) {
        criarMenu(menuAtivo);
        tela.revalidate();
        tela.repaint();
    }

    JLabel texto(String conteudo, int x, int y, int largura, int altura,
                 int fonte, boolean negrito, Color cor) {
        JLabel label = new JLabel(conteudo, SwingConstants.CENTER);
        label.setFont(new Font("Arial", negrito ? Font.BOLD : Font.PLAIN, tamanho(fonte)));
        label.setForeground(cor);
        label.setBounds(x, y, largura, altura);
        tela.add(label);
        return label;
    }

    void titulo(String nome) {
        // O nome dos temas pode ser maior que "Geral". Diminuir a fonte
        // evita cortar "Privacidade online", sem alterar a largura da tela.
        int fonte = 41;
        while (fonte > 20) {
            Font teste = new Font("Arial", Font.BOLD, tamanho(fonte));
            if (getFontMetrics(teste).stringWidth(nome) <= 326) break;
            fonte--;
        }
        texto(nome, 9, 9, 332, 65, fonte, true, destaque());
    }

    JButton botao(String nome, int x, int y, int largura, int altura,
                  Color cor, int fonte, Runnable acao) {
        JButton b = new JButton(nome);
        b.setFont(new Font("Arial", Font.PLAIN, tamanho(fonte)));
        b.setBackground(cor);
        b.setForeground(altoContraste && cor.equals(Color.YELLOW) ? Color.BLACK : Color.WHITE);
        b.setOpaque(true);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setMargin(new Insets(1, 2, 1, 2));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b.setBounds(x, y, largura, altura);
        b.addActionListener(e -> acao.run());
        tela.add(b);
        return b;
    }

    JLabel faixa(String nome, int x, int y, int largura, int altura, int fonte) {
        JLabel f = texto(nome, x, y, largura, altura, fonte, false, Color.WHITE);
        f.setOpaque(true);
        f.setBackground(corFaixa());
        if (altoContraste) {
            f.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        }
        return f;
    }

    JScrollPane blocoLeitura(String conteudo, int x, int y, int largura, int altura,
                             int tamanhoLetra, boolean negrito) {
        JTextArea area = new JTextArea(conteudo);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font("Arial", negrito ? Font.BOLD : Font.PLAIN, tamanho(tamanhoLetra)));
        area.setBackground(altoContraste ? Color.BLACK : new Color(158, 31, 101));
        area.setForeground(Color.WHITE);
        area.setMargin(new Insets(9, 5, 8, 5));
        area.setCaretPosition(0);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(x, y, largura, altura);
        scroll.setBorder(altoContraste ? BorderFactory.createLineBorder(Color.YELLOW, 2) : null);
        scroll.getViewport().setBackground(area.getBackground());
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        tela.add(scroll);
        return scroll;
    }

    void criarMenu(String ativo) {
        String[] nomes = {"HOME", "ESTUDOS", "QUIZ", "AJUSTES"};
        int[] xs = {0, 69, 175, 238};
        int[] larguras = {69, 106, 63, 112};
        for (int i = 0; i < nomes.length; i++) {
            String nome = nomes[i];
            JButton b = new JButton(nome);
            boolean selecionado = nome.equals(ativo);
            b.setFont(new Font("Arial", selecionado ? Font.BOLD : Font.PLAIN, tamanho(20)));
            b.setForeground(selecionado ? destaque() : corTexto());
            b.setBackground(fundo());
            b.setOpaque(true);
            b.setBorder(BorderFactory.createEmptyBorder());
            b.setFocusPainted(false);
            b.setMargin(new Insets(0, 0, 0, 0));
            b.setCursor(new Cursor(Cursor.HAND_CURSOR));
            b.setBounds(xs[i], 676, larguras[i], 44);
            b.addActionListener(e -> {
                if (!podeSairDoQuiz()) return;
                if (nome.equals("HOME")) mostrarHome();
                if (nome.equals("ESTUDOS")) mostrarEstudos();
                if (nome.equals("QUIZ")) mostrarQuiz();
                if (nome.equals("AJUSTES")) mostrarAjustes();
            });
            tela.add(b);
        }
    }

    boolean podeSairDoQuiz() {
        if (!quizEmAndamento) return true;
        int escolha = JOptionPane.showConfirmDialog(this,
            "O quiz ainda não terminou. Deseja abandoná-lo?\nAs respostas não serão salvas.",
            "Abandonar quiz?", JOptionPane.YES_NO_OPTION);
        if (escolha == JOptionPane.YES_OPTION) {
            quizEmAndamento = false;
            return true;
        }
        return false;
    }

    String textoHome() {
        if (modoFacil) {
            return "<html><center>Aprenda pelos materiais<br>ou teste o que sabe<br>nos quizzes!</center></html>";
        }
        return "<html><center>Explore os materiais para aprender<br>ou divirta-se testando seus<br>conhecimentos nos quizzes!</center></html>";
    }

    String textoEstudos() {
        if (modoFacil) {
            return "<html><center>Veja os materiais com calma,<br>com opção de vídeo e áudio!</center></html>";
        }
        return "<html><center>Explore os materiais no seu<br>ritmo, com opções de vídeos e<br>audiobooks!</center></html>";
    }

    String textoQuizIntro() {
        if (modoFacil) {
            return "<html><center>Escolha um tema, diga quantas<br>perguntas quer responder e<br>faça o quiz!</center></html>";
        }
        return "<html><center>Escolha um tema, defina a<br>quantidade de perguntas e teste<br>seus conhecimentos!</center></html>";
    }

    Color corDesempenho(int acertos, int total) {
        if (altoContraste) return Color.YELLOW;
        if (total <= 0) return LARANJA_RESULTADO;
        double porcentagem = (double) acertos / total;
        return porcentagem > 0.60 ? VERDE_RESULTADO : LARANJA_RESULTADO;
    }

    void mostrarHome() {
        prepararTela("home");
        titulo("SecureCheck");
        texto(textoHome(), 14, 187, 322, 89, 19, false, corTexto());
        botao("Materiais", 46, 347, 256, 70, corBotao(), 31, this::mostrarEstudos);
        botao("Quiz", 46, 436, 256, 70, corBotao(), 31, this::mostrarQuiz);
        finalizarTela("HOME");
    }

    void mostrarEstudos() {
        prepararTela("estudos");
        titulo("Estudos");
        texto(textoEstudos(), 14, 96, 322, 83, 19, false, corTexto());
        String[] nomes = {
            "<html><center>Como não cair em<br>armadilhas digitais</center></html>",
            "<html><center>Como proteger sua<br>vida online</center></html>",
            "<html><center>Protegendo sua família<br>e seus dados</center></html>",
            "<html><center>A importância de atualizar<br>suas chaves de segurança</center></html>",
            "<html><center>Como checar a segurança<br>e os certificados de um site</center></html>"
        };
        int[] posicoesY = {210, 300, 384, 468, 557};
        for (int i = 0; i < nomes.length; i++) {
            final int indice = i;
            botao(nomes[i], 20, posicoesY[i], 310, 70, corFaixa(), 19,
                () -> mostrarMaterial(indice));
        }
        finalizarTela("ESTUDOS");
    }

    void mostrarMaterial(int indice) {
        prepararTela("material");
        String tituloMaterial = TITULOS_MATERIAIS[indice];
        String[] nomes = {
            "<html><center>Como não cair<br>em armadilhas<br>digitais</center></html>",
            "<html><center>Como proteger<br>sua vida online</center></html>",
            "<html><center>Protegendo sua<br>família e seus dados</center></html>",
            "<html><center>A importância de atualizar<br>suas chaves de segurança</center></html>",
            "<html><center>Como checar a segurança<br>e os certificados de um site</center></html>"
        };
        // Titulo maior como no Penpot; para nomes extensos, fonte um pouco menor.
        texto(nomes[indice], 9, 8, 332, 168, indice == 0 ? 36 : 30, true, destaque());
        String conteudo = modoFacil ? TEXTOS_MATERIAIS_FACEIS[indice] : TEXTOS_MATERIAIS[indice];
        blocoLeitura(conteudo, 20, 191, 310, 337, 15, false);
        // Estes dois botões extras ocupam a folga entre o material e "Voltar".
        botao("Buscar vídeo", 20, 535, 149, 38, corBotao(), 15,
            () -> pesquisarNaInternet(tituloMaterial + " segurança digital explicação"));
        botao("Buscar áudio", 181, 535, 149, 38, corBotao(), 15,
            () -> pesquisarNaInternet(tituloMaterial + " audiobook podcast"));
        botao("Voltar", 20, 584, 310, 36, corFaixa(), 24, this::mostrarEstudos);
        finalizarTela("ESTUDOS");
    }

    void pesquisarNaInternet(String busca) {
        try {
            String pesquisa = URLEncoder.encode(busca, StandardCharsets.UTF_8);
            String url = "https://www.youtube.com/results?search_query=" + pesquisa;
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                JOptionPane.showMessageDialog(this, "Abra no navegador:\n" + url);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this,
                "Não foi possível abrir o navegador. Confira sua conexão e tente novamente.");
        }
    }

    void mostrarQuiz() {
        prepararTela("quiz");
        titulo("Quiz");
        texto(textoQuizIntro(), 9, 94, 332, 88, 19, false, corTexto());

        faixa("Tema:", 19, 207, 187, 70, 24);
        JComboBox<String> escolhaTema = new JComboBox<>(TEMAS);
        escolhaTema.setSelectedItem(tema);
        escolhaTema.setFont(new Font("Arial", Font.PLAIN, tamanho(18)));
        // Temas longos ficam em duas linhas, dentro da largura do Penpot.
        escolhaTema.setRenderer((lista, valor, indice, selecionado, foco) -> {
            String rotulo = valor == null ? "" : valor;
            if (rotulo.equals("Golpes digitais")) rotulo = "Golpes<br>digitais";
            if (rotulo.equals("Senhas e contas")) rotulo = "Senhas e<br>contas";
            if (rotulo.equals("Privacidade online")) rotulo = "Privacidade<br>online";
            if (rotulo.equals("Navegação segura")) rotulo = "Navegação<br>segura";
            JLabel item = new JLabel("<html><center>" + rotulo + "</center></html>", SwingConstants.CENTER);
            item.setOpaque(true);
            item.setFont(new Font("Arial", Font.PLAIN, tamanho(17)));
            item.setBackground(selecionado ? corFaixa() : corBotao());
            item.setForeground(altoContraste && !selecionado ? Color.BLACK : Color.WHITE);
            item.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
            return item;
        });
        escolhaTema.setBackground(corBotao());
        escolhaTema.setForeground(altoContraste ? Color.BLACK : Color.WHITE);
        escolhaTema.setFocusable(false);
        escolhaTema.setBounds(206, 207, 124, 70);
        escolhaTema.addActionListener(e -> tema = (String) escolhaTema.getSelectedItem());
        tela.add(escolhaTema);

        faixa("<html><center>Número de<br>questões:</center></html>", 19, 285, 187, 70, 24);
        Integer[] numeros = {1,2,3,4,5,6,7,8,9,10};
        JComboBox<Integer> escolhaQuantidade = new JComboBox<>(numeros);
        escolhaQuantidade.setSelectedItem(quantidade);
        escolhaQuantidade.setFont(new Font("Arial", Font.PLAIN, tamanho(22)));
        escolhaQuantidade.setRenderer((lista, valor, indice, selecionado, foco) -> {
            JLabel numero = new JLabel(String.valueOf(valor), SwingConstants.CENTER);
            numero.setOpaque(true);
            numero.setFont(new Font("Arial", Font.PLAIN, tamanho(22)));
            numero.setBackground(selecionado ? corFaixa() : corBotao());
            numero.setForeground(altoContraste && !selecionado ? Color.BLACK : Color.WHITE);
            return numero;
        });
        escolhaQuantidade.setBackground(corBotao());
        escolhaQuantidade.setForeground(altoContraste ? Color.BLACK : Color.WHITE);
        escolhaQuantidade.setFocusable(false);
        escolhaQuantidade.setBounds(206, 285, 124, 70);
        escolhaQuantidade.addActionListener(e -> quantidade = (Integer) escolhaQuantidade.getSelectedItem());
        tela.add(escolhaQuantidade);

        botao("Iniciar quiz", 19, 408, 311, 36, corBotao(), 25, this::iniciarQuiz);
        botao("Últimos quizzes", 19, 456, 311, 36, corFaixa(), 24, this::mostrarHistorico);
        finalizarTela("QUIZ");
    }

    ArrayList<Questao> obterQuestoesDoTema(String temaEscolhido) {
        ArrayList<Questao> base = new ArrayList<>();
        if (temaEscolhido.equals("Geral")) {
            for (int i = 1; i < TEMAS.length; i++) {
                base.addAll(bancoQuestoes.get(TEMAS[i]));
            }
        } else {
            base.addAll(bancoQuestoes.get(temaEscolhido));
        }
        return base;
    }

    void iniciarQuiz() {
        ArrayList<Questao> base = obterQuestoesDoTema(tema);
        if (base.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não há perguntas cadastradas para esse tema ainda.");
            return;
        }
        Collections.shuffle(base);
        questoesAtuais = new ArrayList<>();
        for (int i = 0; i < quantidade && i < base.size(); i++) {
            questoesAtuais.add(base.get(i));
        }
        respostas = new int[questoesAtuais.size()];
        confirmadas = new boolean[questoesAtuais.size()];
        for (int i = 0; i < respostas.length; i++) respostas[i] = -1;
        questaoAtual = 0;
        quizEmAndamento = true;
        mostrarQuestao();
    }

    void mostrarQuestao() {
        prepararTela("questao");
        Questao q = questoesAtuais.get(questaoAtual);
        titulo("Tema: " + tema);
        faixa(String.format("Questão %02d", questaoAtual + 1), 19, 85, 312, 37, 24);
        blocoLeitura(q.getEnunciado(modoFacil), 19, 143, 312, 235, 13, true);

        if (!confirmadas[questaoAtual]) {
            for (int i = 0; i < 4; i++) {
                final int alternativa = i;
                boolean selecionada = respostas[questaoAtual] == i;
                criarAlternativa(i, q.alternativas[i], 400 + 46 * i, selecionada, () -> {
                    if (respostas[questaoAtual] == alternativa) {
                        respostas[questaoAtual] = -1;
                    } else {
                        respostas[questaoAtual] = alternativa;
                    }
                    mostrarQuestao();
                });
            }
        } else {
            int marcada = respostas[questaoAtual];
            boolean acertou = marcada == q.correta;
            criarAlternativaResultado(marcada, q.alternativas[marcada], 400,
                altoContraste ? Color.YELLOW : (acertou ? VERDE_RESULTADO : LARANJA_RESULTADO));
            String mensagem = acertou
                ? (modoFacil ? "Você acertou!\n\n" : "Resposta correta!\n\n") + q.getExplicacao(modoFacil)
                : (modoFacil ? "Você errou. A certa era: " : "Não foi dessa vez! Correta: ") +
                    q.alternativas[q.correta] + ".\n\n" + q.getExplicacao(modoFacil);
            blocoLeitura(mensagem, 20, 436, 310, 114, 14, false);
        }

        if (questaoAtual == 0) {
            JButton anterior = botao("<html><center>Questão<br>anterior</center></html>", 19, 604, 88, 36,
                altoContraste ? Color.BLACK : ROXO_ESCURO, 16, () -> {});
            anterior.setEnabled(false);
            anterior.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            anterior.setForeground(Color.WHITE);
            if (altoContraste) {
                anterior.setBorderPainted(true);
                anterior.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
            }
        } else {
            botao("<html><center>Questão<br>anterior</center></html>", 19, 604, 88, 36,
                corBotao(), 16, () -> {
                    questaoAtual--;
                    mostrarQuestao();
                });
        }

        String proximo = !confirmadas[questaoAtual]
            ? "<html><center>Selecionar<br>alternativa</center></html>"
            : (questaoAtual == questoesAtuais.size() - 1
                ? "<html><center>Finalizar<br>quiz</center></html>"
                : "<html><center>Próxima<br>questão</center></html>");

        botao(proximo, 116, 604, 114, 36, corBotao(), 15, this::confirmarOuAvancar);
        botao("<html><center>Abandonar<br>quiz</center></html>", 239, 604, 91, 36,
            corBotao(), 14, () -> {
                if (podeSairDoQuiz()) mostrarQuiz();
            });
        finalizarTela("QUIZ");
    }

    // Ajusta automaticamente as palavras maiores para que caibam na faixa.
    // A letra continua alinhada e a caixa continua com 36 pixels de altura.
    JComponent textoDaAlternativa(String conteudo, Color fundoOpcao, Color textoOpcao) {
        int larguraDisponivel = 229;
        Font fonte = new Font("Arial", Font.PLAIN, tamanho(21));
        if (getFontMetrics(fonte).stringWidth(conteudo) < larguraDisponivel - 9) {
            JLabel rotulo = new JLabel(conteudo);
            rotulo.setFont(fonte);
            rotulo.setForeground(textoOpcao);
            rotulo.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            return rotulo;
        }

        JTextArea rotulo = new JTextArea(conteudo);
        rotulo.setEditable(false);
        rotulo.setLineWrap(true);
        rotulo.setWrapStyleWord(true);
        rotulo.setBackground(fundoOpcao);
        rotulo.setForeground(textoOpcao);
        rotulo.setMargin(new Insets(1, 6, 0, 2));
        for (int tamanhoFonte = tamanho(17); tamanhoFonte >= 11; tamanhoFonte--) {
            rotulo.setFont(new Font("Arial", Font.PLAIN, tamanhoFonte));
            rotulo.setSize(larguraDisponivel, 36);
            if (rotulo.getPreferredSize().height <= 36) break;
        }
        rotulo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return rotulo;
    }

    void criarAlternativa(int indice, String textoAlternativa, int y, boolean selecionada, Runnable acao) {
        JPanel linha = new JPanel(new BorderLayout());
        linha.setBounds(20, y, 310, 36);
        Color fundoOpcao = altoContraste ? (selecionada ? Color.YELLOW : Color.BLACK)
                                         : (selecionada ? ROSA : ROXO_ESCURO);
        Color textoOpcao = altoContraste && selecionada ? Color.BLACK : Color.WHITE;
        linha.setBackground(fundoOpcao);
        linha.setCursor(new Cursor(Cursor.HAND_CURSOR));
        if (altoContraste) linha.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));

        JLabel letra = new JLabel(String.valueOf((char) ('A' + indice)), SwingConstants.CENTER);
        letra.setPreferredSize(new Dimension(75, 36));
        letra.setFont(new Font("Arial", Font.PLAIN, tamanho(23)));
        letra.setForeground(textoOpcao);

        JComponent opcao = textoDaAlternativa(textoAlternativa, fundoOpcao, textoOpcao);
        opcao.setToolTipText(textoAlternativa);
        linha.add(letra, BorderLayout.WEST);
        linha.add(opcao, BorderLayout.CENTER);

        MouseAdapter clique = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { acao.run(); }
        };
        linha.addMouseListener(clique);
        letra.addMouseListener(clique);
        opcao.addMouseListener(clique);
        tela.add(linha);
    }

    void criarAlternativaResultado(int indice, String textoAlternativa, int y, Color cor) {
        JPanel linha = new JPanel(new BorderLayout());
        linha.setBounds(20, y, 310, 36);
        linha.setBackground(cor);
        if (altoContraste) linha.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));

        JLabel letra = new JLabel(String.valueOf((char) ('A' + indice)), SwingConstants.CENTER);
        letra.setPreferredSize(new Dimension(75, 36));
        letra.setFont(new Font("Arial", Font.PLAIN, tamanho(23)));
        letra.setForeground(altoContraste ? Color.BLACK : Color.WHITE);

        JComponent opcao = textoDaAlternativa(textoAlternativa, cor,
            altoContraste ? Color.BLACK : Color.WHITE);
        opcao.setToolTipText(textoAlternativa);
        linha.add(letra, BorderLayout.WEST);
        linha.add(opcao, BorderLayout.CENTER);
        tela.add(linha);
    }

    void confirmarOuAvancar() {
        if (!confirmadas[questaoAtual]) {
            if (respostas[questaoAtual] == -1) {
                JOptionPane.showMessageDialog(this, "Escolha uma alternativa antes de continuar.");
                return;
            }
            confirmadas[questaoAtual] = true;
            mostrarQuestao();
            return;
        }
        if (questaoAtual + 1 < questoesAtuais.size()) {
            questaoAtual++;
            mostrarQuestao();
        } else {
            quizEmAndamento = false;
            salvarResultado();
            mostrarResultado();
        }
    }

    int contarAcertos() {
        int acertos = 0;
        for (int i = 0; i < questoesAtuais.size(); i++) {
            if (respostas[i] == questoesAtuais.get(i).correta) acertos++;
        }
        return acertos;
    }

    void mostrarResultado() {
        prepararTela("resultado");
        titulo("Tema: " + tema);
        faixa("Resultado", 19, 85, 312, 37, 24);
        int acertos = contarAcertos();
        double porcentagem = questoesAtuais.isEmpty() ? 0 : ((double) acertos / questoesAtuais.size());
        Color corPlacar = corDesempenho(acertos, questoesAtuais.size());
        JLabel placar = faixa("Você obteve " + acertos + " " +
            (acertos == 1 ? "acerto" : "acertos") + " de " + questoesAtuais.size(),
            19, 137, 311, 36, 20);
        placar.setBackground(corPlacar);
        if (altoContraste) placar.setForeground(Color.BLACK);

        String mensagem;
        if (modoFacil) {
            if (porcentagem > 0.60) {
                mensagem = "Parabéns! Você foi bem no quiz e já entendeu boa parte desse tema. Continue praticando para ficar ainda melhor!";
            } else {
                mensagem = "Você terminou o quiz. Ainda tem coisa para revisar, mas isso faz parte. Leia os materiais de novo e tente mais uma vez!";
            }
        } else {
            if (porcentagem > 0.60) {
                mensagem = "Parabéns! Você se saiu muito bem no quiz e mostrou que já sabe bastante sobre o tema. Continue praticando para dominar o conteúdo por completo.";
            } else {
                mensagem = "Você concluiu o quiz. O resultado mostra que ainda vale revisar os materiais e continuar treinando para reforçar o aprendizado.";
            }
        }

        blocoLeitura(mensagem, 19, 191, 311, 124, 17, true);
        botao("Voltar", 19, 373, 311, 36, corFaixa(), 25, this::mostrarQuiz);
        finalizarTela("QUIZ");
    }

    void mostrarHistorico() {
        prepararTela("historico");
        texto("Últimos quizzes", 4, 10, 342, 70, 34, true, destaque());
        if (historico.isEmpty()) {
            texto("<html><center>Você ainda não finalizou nenhum quiz.<br>Faça o primeiro para ver seu resultado aqui!</center></html>",
                16, 207, 318, 120, 18, false, corTexto());
        } else {
            JPanel lista = new JPanel();
            lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));
            lista.setBackground(fundo());
            for (int i = historico.size() - 1; i >= 0; i--) {
                String[] partes = historico.get(i).split(";");
                if (partes.length != 4) continue;
                int acertos = Integer.parseInt(partes[2]);
                int total = Integer.parseInt(partes[3]);
                JPanel item = new JPanel(new BorderLayout());
                item.setMaximumSize(new Dimension(310, 69));
                item.setPreferredSize(new Dimension(310, 69));
                item.setBackground(corDesempenho(acertos, total));
                item.setBorder(BorderFactory.createEmptyBorder(7, 8, 7, 8));
                JLabel descricao = new JLabel("<html>" + partes[1] + "</html>");
                descricao.setForeground(altoContraste ? Color.BLACK : Color.WHITE);
                descricao.setFont(new Font("Arial", Font.PLAIN, tamanho(16)));
                JLabel placar = new JLabel("<html><center>" + partes[2] + " " +
                    ("1".equals(partes[2]) ? "acerto" : "acertos") + "<br>de " + partes[3] +
                    "</center></html>");
                placar.setForeground(altoContraste ? Color.BLACK : Color.WHITE);
                placar.setFont(new Font("Arial", Font.PLAIN, tamanho(19)));
                item.add(descricao, BorderLayout.WEST);
                item.add(placar, BorderLayout.EAST);
                if (altoContraste) item.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
                lista.add(item);
                lista.add(Box.createVerticalStrut(8));
            }
            JScrollPane scroll = new JScrollPane(lista);
            scroll.setBounds(19, 207, 311, 336);
            scroll.setBorder(null);
            scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            tela.add(scroll);
        }
        botao("Voltar", 19, 557, 311, 36, corFaixa(), 25, this::mostrarQuiz);
        finalizarTela("QUIZ");
    }

    void salvarResultado() {
        String data = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
        historico.add(data + ";" + tema + ";" + contarAcertos() + ";" + questoesAtuais.size());
        gravarArquivoHistorico();
    }

    void gravarArquivoHistorico() {
        try (PrintWriter escrita = new PrintWriter(new FileWriter(arquivoHistorico))) {
            for (String linha : historico) escrita.println(linha);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Não foi possível salvar o histórico neste computador.");
        }
    }

    void carregarHistorico() {
        if (!arquivoHistorico.exists()) return;
        try (BufferedReader leitura = new BufferedReader(new FileReader(arquivoHistorico))) {
            String linha;
            while ((linha = leitura.readLine()) != null) {
                if (linha.split(";").length == 4) historico.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Não foi possível ler o histórico: " + e.getMessage());
        }
    }

    void mostrarAjustes() {
        prepararTela("ajustes");
        titulo("Ajustes");
        criarOpcao("Modo escuro", 179, modoEscuro, "escuro");
        criarOpcao("Modo fácil", 268, modoFacil, "facil");
        criarOpcao("Texto maior", 357, textoMaior, "maior");
        criarOpcao("<html><center>Modo de alto<br>contraste</center></html>", 446, altoContraste, "contraste");
        finalizarTela("AJUSTES");
    }

    void criarOpcao(String nome, int y, boolean ligada, String chave) {
        faixa(nome, 20, y, 187, 70, 24);
        JButton b = botao("", 207, y, 123, 70,
            ligada ? corBotao() : (altoContraste ? Color.BLACK : ROXO_ESCURO), 19, () -> {
                if (chave.equals("escuro")) {
                    modoEscuro = !modoEscuro;
                    preferencias.putBoolean("escuro", modoEscuro);
                }
                if (chave.equals("facil")) {
                    modoFacil = !modoFacil;
                    preferencias.putBoolean("facil", modoFacil);
                }
                if (chave.equals("maior")) {
                    textoMaior = !textoMaior;
                    preferencias.putBoolean("maior", textoMaior);
                }
                if (chave.equals("contraste")) {
                    altoContraste = !altoContraste;
                    preferencias.putBoolean("contraste", altoContraste);
                }
                mostrarAjustes();
            });
        if (altoContraste) b.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        b.setToolTipText(nome + (ligada ? ": ativado" : ": desativado"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
