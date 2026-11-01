import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame implements Navegador {


    private static final String TEXTO_MATERIAL_1 =
            "COMO NÃO CAIR EM ARMADILHAS DIGITAIS\n\n" +

                    "Você já reparou como a nossa vida inteira cabe dentro do celular hoje em dia? Conversamos com amigos, pagamos contas, fazemos compras, estudamos e guardamos nossas melhores lembranças ali. A internet facilitou muito a nossa rotina, mas também abriu portas para pessoas mal-intencionadas, que procuram maneiras de enganar os usuários e conseguir informações pessoais ou dinheiro.\n\n" +

                    "Muitas pessoas imaginam que os golpes digitais acontecem apenas por meio de programas de computador muito avançados. Porém, nem sempre é assim. Em diversas situações, a principal ferramenta dos golpistas é a própria confiança, distração ou curiosidade das vítimas. Eles utilizam uma técnica chamada engenharia social, que consiste em manipular pessoas por meio de conversas, mensagens e situações falsas para convencê-las a fazer algo que pode prejudicá-las.\n\n" +

                    "COMO FUNCIONA A ENGENHARIA SOCIAL?\n\n" +

                    "A engenharia social acontece quando alguém tenta conquistar a confiança de outra pessoa para conseguir alguma vantagem. O golpista pode se passar por um funcionário de banco, um parente, um amigo ou até mesmo por uma empresa conhecida. Para isso, utiliza informações que parecem verdadeiras e cria histórias capazes de convencer a vítima.\n\n" +

                    "Uma estratégia muito comum é provocar um sentimento de urgência. Por exemplo, a pessoa recebe uma mensagem dizendo que sua conta bancária será bloqueada caso não clique imediatamente em um link. Com medo de perder o acesso à conta, ela pode agir sem pensar e acabar fornecendo seus dados pessoais.\n\n" +

                    "Outra estratégia é despertar a curiosidade, oferecendo prêmios, descontos muito grandes ou oportunidades que parecem boas demais para serem verdade. O objetivo é fazer com que a vítima clique em um link ou forneça informações sem verificar se a situação é verdadeira.\n\n" +

                    "GOLPES DIGITAIS MAIS COMUNS\n\n" +

                    "1. PHISHING\n\n" +

                    "O phishing é um golpe em que criminosos enviam mensagens falsas para tentar roubar informações pessoais, senhas e dados bancários. Essas mensagens podem chegar por e-mail, SMS ou aplicativos como WhatsApp. Muitas vezes, elas imitam a aparência de empresas conhecidas, bancos ou serviços que utilizamos.\n\n" +

                    "Imagine receber um e-mail informando que sua senha expirou e que você precisa acessar um link para recuperar sua conta. A página aberta pode parecer exatamente igual à página verdadeira, mas, na realidade, foi criada para roubar suas informações. Por isso, nunca informe suas senhas em páginas abertas por links suspeitos.\n\n" +

                    "2. GOLPE DO FALSO FAMILIAR\n\n" +

                    "Nesse golpe, uma pessoa entra em contato pelo WhatsApp utilizando um número desconhecido e uma foto de perfil de alguém conhecido. Ela diz que trocou de número e inventa uma situação de emergência para pedir dinheiro emprestado.\n\n" +

                    "Por parecer uma pessoa da família ou um amigo, a vítima pode acreditar na história e realizar uma transferência sem verificar a identidade de quem está conversando. Antes de enviar qualquer quantia, entre em contato com a pessoa pelo número antigo ou por outro meio conhecido para confirmar se o pedido é verdadeiro.\n\n" +

                    "3. FALSAS PROMOÇÕES E PRÊMIOS\n\n" +

                    "Você já recebeu uma mensagem dizendo que ganhou um celular, um prêmio ou um desconto especial, mesmo sem ter participado de nenhum sorteio? Esse pode ser um golpe. Os criminosos utilizam ofertas muito atraentes para chamar a atenção e fazer as pessoas acessarem sites falsos ou compartilharem informações pessoais.\n\n" +

                    "Desconfie de promoções que exigem pagamentos antecipados, dados bancários ou o envio de códigos recebidos por SMS. Sempre procure a oferta no site ou perfil oficial da empresa antes de acreditar nela.\n\n" +

                    "4. FALSO ATENDIMENTO OU SUPORTE TÉCNICO\n\n" +

                    "Outro golpe acontece quando alguém se apresenta como funcionário de uma empresa, banco ou serviço de tecnologia. Essa pessoa pode dizer que identificou um problema na sua conta e que precisa da sua senha, de um código de confirmação ou até mesmo do acesso remoto ao seu aparelho.\n\n" +

                    "O objetivo é conseguir controle sobre suas contas ou dispositivos. Nunca compartilhe senhas e códigos de segurança com pessoas que entram em contato inesperadamente. Quando precisar de atendimento, procure os canais oficiais da empresa.\n\n" +

                    "COMO IDENTIFICAR UMA POSSÍVEL ARMADILHA?\n\n" +

                    "Existem alguns sinais que podem ajudar você a reconhecer uma tentativa de golpe:\n\n" +

                    "- Mensagens que exigem uma resposta imediata ou ameaçam bloquear sua conta.\n" +
                    "- Links com endereços estranhos ou diferentes dos sites oficiais.\n" +
                    "- Pedidos de senhas, códigos de confirmação ou informações bancárias.\n" +
                    "- Ofertas muito vantajosas, com prêmios ou descontos difíceis de acreditar.\n" +
                    "- Pessoas desconhecidas que pedem dinheiro ou inventam situações de emergência.\n" +
                    "- Mensagens com erros de escrita, informações confusas ou remetentes suspeitos.\n\n" +

                    "É importante lembrar que uma mensagem bem escrita e com uma aparência profissional também pode ser falsa. Por isso, não confie apenas na aparência: procure confirmar as informações antes de tomar qualquer atitude.\n\n" +

                    "ATITUDES PARA SE PROTEGER\n\n" +

                    "A melhor maneira de evitar golpes é desenvolver o hábito de verificar as informações antes de agir. Ao receber uma mensagem suspeita, não clique imediatamente nos links e não abra arquivos enviados por desconhecidos.\n\n" +

                    "Se alguém pedir dinheiro, mesmo utilizando a foto de uma pessoa conhecida, confirme o pedido por uma ligação ou outro canal de comunicação. Nunca compartilhe senhas ou códigos recebidos no celular, pois eles podem permitir que outra pessoa acesse suas contas.\n\n" +

                    "Também é importante utilizar senhas fortes, ativar a verificação em duas etapas e manter os aplicativos atualizados. Essas medidas ajudam a dificultar o acesso de pessoas não autorizadas às suas informações.\n\n" +

                    "E SE VOCÊ CAIR EM UM GOLPE?\n\n" +

                    "Se perceber que compartilhou uma senha ou informação importante, altere a senha da conta afetada o mais rápido possível, utilizando o site ou aplicativo oficial. Se houver movimentação financeira suspeita, entre em contato imediatamente com seu banco pelos canais oficiais e informe o ocorrido.\n\n" +

                    "Também é importante guardar mensagens, comprovantes e outras evidências do golpe, bloquear e denunciar os contatos suspeitos e procurar orientação pelos canais apropriados. Não tenha vergonha de pedir ajuda: qualquer pessoa pode ser vítima de uma tentativa de fraude.\n\n" +

                    "CONCLUSÃO\n\n" +

                    "A internet é uma ferramenta muito importante e pode facilitar diversas atividades do nosso dia a dia. Entretanto, precisamos utilizá-la com atenção e responsabilidade. Os golpistas estão sempre procurando novas maneiras de enganar as pessoas, mas pequenas atitudes podem fazer uma grande diferença.\n\n" +

                    "Antes de clicar, compartilhar informações ou transferir dinheiro, pare por alguns instantes e verifique se a situação é verdadeira. Desconfiar de mensagens suspeitas não significa deixar de confiar nas pessoas, mas sim aprender a proteger seus dados, seu dinheiro e sua segurança.\n\n" +

                    "Lembre-se: na internet, pensar antes de agir é uma das melhores formas de proteção!";



    private static final String TEXTO_MATERIAL_2 =
            "COMO PROTEGER SUA VIDA ONLINE\n\n" +

                    "Hoje em dia, utilizamos a internet para praticamente tudo. Conversamos com amigos, estudamos, trabalhamos, fazemos compras, assistimos a vídeos e até resolvemos questões bancárias pelo celular. Com tantas atividades acontecendo no ambiente digital, acabamos armazenando muitas informações pessoais em aplicativos, sites e dispositivos.\n\n" +

                    "Mas você já parou para pensar no que aconteceria se alguém conseguisse acessar suas contas sem sua autorização? Poderia descobrir suas conversas, visualizar fotografias, acessar informações bancárias ou até se passar por você para enganar outras pessoas.\n\n" +

                    "Por isso, proteger sua vida online é muito importante. A segurança digital não depende apenas de programas e ferramentas tecnológicas. Ela também começa com os nossos hábitos e com os cuidados que temos ao utilizar a internet.\n\n" +

                    "1. CRIE SENHAS FORTES E DIFERENTES\n\n" +

                    "A senha é uma das principais formas de proteger nossas contas. Ela funciona como uma chave que permite o acesso às nossas informações. Quando utilizamos senhas muito simples, como datas de nascimento, nomes de familiares ou sequências como 123456, facilitamos o trabalho de quem tenta descobrir nossos dados.\n\n" +

                    "Uma senha forte deve ser difícil de adivinhar e, de preferência, conter uma combinação de letras maiúsculas, letras minúsculas, números e símbolos. Outra boa estratégia é utilizar uma frase longa que seja fácil para você lembrar, mas difícil para outras pessoas descobrirem.\n\n" +

                    "Também é muito importante não utilizar a mesma senha em todos os sites. Imagine que alguém descubra a senha do seu e-mail. Se você utilizar exatamente a mesma senha em suas redes sociais e em outros serviços, essa pessoa poderá tentar acessar todas essas contas.\n\n" +

                    "Para facilitar a organização, você pode utilizar um gerenciador de senhas confiável. Essa ferramenta ajuda a guardar suas senhas com mais segurança, evitando que você precise decorar todas elas.\n\n" +

                    "2. ATIVE A VERIFICAÇÃO EM DUAS ETAPAS\n\n" +

                    "A verificação em duas etapas, também conhecida como autenticação de dois fatores, é uma camada extra de proteção para suas contas.\n\n" +

                    "Normalmente, para entrar em uma conta, basta informar a senha. Quando a verificação em duas etapas está ativada, o serviço também solicita uma segunda confirmação, como um código temporário ou uma aprovação pelo aplicativo autenticador.\n\n" +

                    "Isso significa que, mesmo que alguém descubra sua senha, ainda poderá encontrar uma barreira adicional para conseguir acessar sua conta. Sempre que possível, ative esse recurso principalmente no e-mail, nas redes sociais e nos serviços financeiros.\n\n" +

                    "3. MANTENHA SEUS DISPOSITIVOS ATUALIZADOS\n\n" +

                    "Atualizar o celular, o computador e os aplicativos não serve apenas para receber novos recursos ou mudar a aparência dos programas. Muitas atualizações também corrigem falhas que poderiam ser utilizadas por criminosos para acessar informações ou prejudicar o funcionamento dos dispositivos.\n\n" +

                    "Por isso, procure manter o sistema operacional e os aplicativos atualizados. Sempre que possível, ative as atualizações automáticas e utilize aplicativos obtidos em lojas oficiais ou diretamente nos sites dos desenvolvedores.\n\n" +

                    "Também evite instalar programas desconhecidos ou arquivos recebidos de fontes que você não conhece. Alguns deles podem conter programas maliciosos, capazes de prejudicar o aparelho ou coletar informações sem autorização.\n\n" +

                    "4. TENHA CUIDADO COM O QUE COMPARTILHA NAS REDES SOCIAIS\n\n" +

                    "As redes sociais são ótimas ferramentas para compartilhar momentos e manter contato com outras pessoas. Porém, nem tudo precisa ser publicado.\n\n" +

                    "Informações como endereço, telefone, documentos, localização em tempo real e detalhes da sua rotina podem ser utilizadas por pessoas mal-intencionadas. Uma publicação aparentemente simples pode revelar onde você mora, trabalha ou estuda e até indicar quando sua casa está vazia.\n\n" +

                    "Antes de publicar alguma coisa, pense se aquela informação realmente precisa ser compartilhada. Evite divulgar documentos pessoais e dados bancários. Também revise as configurações de privacidade para controlar quem pode visualizar suas publicações e informações pessoais.\n\n" +

                    "Lembre-se de que uma publicação pode ser copiada ou compartilhada por outras pessoas, mesmo que você a apague posteriormente.\n\n" +

                    "5. TENHA CUIDADO AO UTILIZAR REDES WI-FI PÚBLICAS\n\n" +

                    "Redes Wi-Fi públicas, encontradas em locais como praças, aeroportos, restaurantes e cafeterias, podem ser bastante úteis quando estamos fora de casa. Entretanto, é importante ter cuidado ao utilizá-las.\n\n" +

                    "Algumas redes podem ser falsas e ter sido criadas para atrair usuários e tentar obter informações. Antes de se conectar, confirme se aquela rede realmente pertence ao estabelecimento. Evite acessar serviços bancários ou realizar operações importantes em redes que não sejam confiáveis.\n\n" +

                    "Quando precisar acessar informações sensíveis, prefira utilizar uma conexão confiável, como sua rede doméstica ou os dados móveis do celular. Também desative a conexão automática a redes Wi-Fi desconhecidas.\n\n" +

                    "6. VERIFIQUE SE OS SITES SÃO CONFIÁVEIS\n\n" +

                    "Antes de informar dados pessoais, senhas ou informações de pagamento em um site, verifique se você está acessando o endereço correto.\n\n" +

                    "Golpistas podem criar páginas falsas muito parecidas com sites verdadeiros. Por isso, observe o endereço do site e tenha cuidado com letras trocadas, nomes diferentes ou endereços enviados por mensagens suspeitas.\n\n" +

                    "A presença de HTTPS e do símbolo de cadeado no navegador indica que a conexão utiliza criptografia, mas isso não garante que o site seja verdadeiro ou confiável. Um site falso também pode utilizar HTTPS. Portanto, verifique sempre o endereço e a origem da página.\n\n" +

                    "7. CUIDE DAS PERMISSÕES DOS APLICATIVOS\n\n" +

                    "Muitos aplicativos solicitam acesso à câmera, ao microfone, à localização, aos contatos e aos arquivos do aparelho. Algumas dessas permissões são necessárias para o funcionamento do aplicativo, mas outras podem não ter relação com a atividade que ele realiza.\n\n" +

                    "Por exemplo, um aplicativo simples de calculadora provavelmente não precisa acessar sua localização ou seus contatos. Por isso, procure revisar as permissões concedidas e permita apenas os acessos realmente necessários.\n\n" +

                    "Essa atitude ajuda a controlar quais informações os aplicativos podem acessar e reduz a exposição dos seus dados pessoais.\n\n" +

                    "8. FAÇA CÓPIAS DE SEGURANÇA DOS SEUS ARQUIVOS\n\n" +

                    "Imagine perder seu celular ou ter seu computador danificado e descobrir que todas as suas fotografias, documentos e arquivos importantes desapareceram. Para evitar esse problema, é importante realizar cópias de segurança, também conhecidas como backups.\n\n" +

                    "O backup consiste em guardar uma cópia dos arquivos importantes em outro local, como um serviço de armazenamento em nuvem confiável ou um dispositivo externo. Assim, caso algo aconteça com o aparelho original, você terá uma maneira de recuperar suas informações.\n\n" +

                    "Procure realizar cópias de segurança regularmente e proteger também as contas utilizadas para armazená-las.\n\n" +

                    "9. NÃO COMPARTILHE INFORMAÇÕES DE SEGURANÇA\n\n" +

                    "Senhas, códigos de confirmação e códigos de recuperação são informações pessoais que devem ser mantidas em segredo. Mesmo que alguém diga ser funcionário de um banco, de uma empresa ou até uma pessoa conhecida, nunca compartilhe esses dados por mensagens ou ligações inesperadas.\n\n" +

                    "Também tenha cuidado ao permitir que outra pessoa utilize seu aparelho ou acesse suas contas. Quando precisar utilizar um computador público ou compartilhado, evite salvar senhas e lembre-se de sair da sua conta ao terminar.\n\n" +

                    "O QUE FAZER PARA COMEÇAR A SE PROTEGER?\n\n" +

                    "Você não precisa mudar todos os seus hábitos de uma só vez. Comece com atitudes simples: troque senhas fracas, ative a verificação em duas etapas, atualize seus dispositivos e revise as configurações de privacidade das redes sociais.\n\n" +

                    "Também procure conversar com familiares e amigos sobre segurança digital. Muitas pessoas ainda não conhecem os riscos existentes na internet e podem se beneficiar dessas orientações.\n\n" +

                    "CONCLUSÃO\n\n" +

                    "Proteger sua vida online significa cuidar das suas informações, da sua privacidade e da sua segurança enquanto utiliza a internet. Pequenas atitudes, quando praticadas diariamente, podem reduzir bastante os riscos de golpes, invasões e exposição de dados pessoais.\n\n" +

                    "A tecnologia está presente em muitas partes da nossa rotina e não precisamos deixar de utilizá-la por medo. O mais importante é aprender a utilizá-la com responsabilidade, atenção e conhecimento.\n\n" +

                    "Lembre-se: sua segurança digital começa com as escolhas que você faz todos os dias!";


    private final CardLayout cardLayout = new CardLayout();
    private final JPanel areaTelas = new JPanel(cardLayout);
    private final BarraNavegacao barraNavegacao;

    public JanelaPrincipal() {
        setTitle("SecureCheck");
        setSize(485, 794);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        areaTelas.add(new TelaSplash(), "SPLASH");
        areaTelas.add(new TelaHome(this), HOME);
        areaTelas.add(new TelaEstudos(this), ESTUDOS);
        areaTelas.add(new TelaMaterial(
            "<html><center>Como não cair<br>em armadilhas<br>digitais</center></html>",
            TEXTO_MATERIAL_1,
            this
        ), MATERIAL_1);
        areaTelas.add(new TelaMaterial(
            "<html><center>Como proteger sua<br>vida online</center></html>",
            TEXTO_MATERIAL_2,
            this
        ), MATERIAL_2);
        areaTelas.add(new TelaQuiz(), QUIZ);
        areaTelas.add(new TelaAjustes(), AJUSTES);

        add(areaTelas, BorderLayout.CENTER);

        barraNavegacao = new BarraNavegacao(this);
        add(barraNavegacao, BorderLayout.SOUTH);

        cardLayout.show(areaTelas, "SPLASH");
        barraNavegacao.setVisible(false);

        Timer temporizador = new Timer(2000, e -> {
            irPara(HOME);
            barraNavegacao.setVisible(true);
            revalidate();
            repaint();
        });

        temporizador.setRepeats(false);
        temporizador.start();
    }

    @Override
    public void irPara(String tela) {
        cardLayout.show(areaTelas, tela);

        if (tela.equals(MATERIAL_1) || tela.equals(MATERIAL_2)) {
            barraNavegacao.destacarBotao(ESTUDOS);
        } else {
            barraNavegacao.destacarBotao(tela);
        }
    }
}
