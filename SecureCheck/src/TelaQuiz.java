import javax.swing.*;
import java.awt.*;

public class TelaQuiz extends JPanel {

    private String temaSelecionado = "Geral";
    private int numeroQuestoesSelecionado = 5;

    public TelaQuiz() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        JPanel cabecalho = new JPanel();
        cabecalho.setBackground(Color.WHITE);
        cabecalho.setLayout(new BoxLayout(cabecalho, BoxLayout.Y_AXIS));

        JLabel titulo =new JLabel("Quiz");
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(new Color(219, 31, 119));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel descricao = createDescricao();

        cabecalho.setBorder(
                BorderFactory.createEmptyBorder(25, 10, 20, 10)
        );
        cabecalho.add(titulo);
        cabecalho.add(Box.createVerticalStrut(20));
        cabecalho.add(descricao);
        add(cabecalho, BorderLayout.NORTH);

        JPanel painelOpcoes = new JPanel();
        painelOpcoes.setLayout(new GridLayout(2, 2, 0, 10));
        painelOpcoes.setPreferredSize(new Dimension(450, 200));
        painelOpcoes.setPreferredSize(new Dimension(450, 200));

        JLabel tema= new JLabel(" Tema: ");
        tema.setBackground(Cores.ROXO);
        tema.setForeground(Color.WHITE);
        tema.setOpaque(true);
        tema.setFont(new Font("Arial", Font.PLAIN, 18));
        String[] temas = {"Geral", "Armadilhas digitais", "Vida online", "Família e seus dados",
                "Chaves de segurança", "Compras online"};

        JComboBox<String> menuTemas = new JComboBox<>(temas);
        menuTemas.setBackground(Cores.ROSA_CLARO);
        menuTemas.setForeground(Color.WHITE);
        menuTemas.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel textoNumero = new JLabel(" Número de questões:");
        textoNumero.setBackground(Cores.ROXO);
        textoNumero.setForeground(Color.WHITE);
        textoNumero.setOpaque(true);
        textoNumero.setFont(new Font("Arial", Font.PLAIN, 18));

        Integer[] NumeroPerguntas= {5, 10};
        JComboBox<Integer> menuNumeros= new JComboBox<>(NumeroPerguntas);
        menuNumeros.setBackground(Cores.ROSA_CLARO);
        menuNumeros.setForeground(Color.WHITE);
        menuNumeros.setFont(new Font("Arial", Font.PLAIN, 18));
        painelOpcoes.add(tema);
        painelOpcoes.add(menuTemas);
        painelOpcoes.add(textoNumero);
        painelOpcoes.add(menuNumeros);

        menuTemas.addActionListener(_ -> temaSelecionado = (String) menuTemas.getSelectedItem());
        menuNumeros.addActionListener(_ -> numeroQuestoesSelecionado = (Integer) menuNumeros.getSelectedItem());

        JButton iniciar= new JButton("Iniciar Quiz");
        iniciar.setFont(new Font("Arial", Font.BOLD, 20));
        iniciar.setBackground(Cores.ROSA_CLARO);
        iniciar.setForeground(Color.WHITE);
        iniciar.setPreferredSize(new Dimension(300, 100));
        iniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        iniciar.addActionListener(_ -> iniciarQuiz());

        JPanel centralizar= new JPanel(new FlowLayout(FlowLayout.CENTER));
        centralizar.setBackground(Color.WHITE);
        centralizar.add(painelOpcoes);
        centralizar.add(iniciar);
        add(centralizar, BorderLayout.CENTER);
    }

    private static JLabel createDescricao() {
        JLabel descricao = new JLabel(
                "<html><center>Escolha um tema, defina a <br>" +
                        "quantidade de perguntas e teste<br>" +
                        "seus conhecimentos!</center></html>"
        );
        descricao.setFont(new Font("Arial", Font.PLAIN, 20));
        descricao.setForeground(new Color(140, 28, 96));
        descricao.setHorizontalAlignment(SwingConstants.CENTER);
        descricao.setAlignmentX(Component.CENTER_ALIGNMENT);
        descricao.setPreferredSize(new Dimension(440, 80));
        descricao.setMaximumSize(new Dimension(440, 80));
        return descricao;
    }

    private static final int TEMA = 0, ENUNCIADO = 1, CORRETA = 2, EXPLICACAO = 3, PRIMEIRA_ALTERNATIVA = 4;
    private static final String[][] QUESTOES = {
            {"Geral",
                    "Qual atitude representa um dos princípios mais importantes da segurança digital, considerando os cuidados apresentados nos materiais?",
                    "1",
                    "Gabarito: B) Verificar informações e situações suspeitas antes de agir.",
                    "Confiar em mensagens que utilizam a identidade visual de empresas conhecidas.",
                    "Verificar informações e situações suspeitas antes de clicar, compartilhar dados ou realizar transferências.",
                    "Utilizar a mesma senha em diferentes serviços para facilitar o acesso.",
                    "Evitar todas as atividades realizadas pela internet.",
                    "Compartilhar códigos de confirmação quando solicitado por alguém conhecido."},
            {"Geral",
                    "Uma pessoa recebe uma mensagem informando que sua conta será bloqueada caso não acesse imediatamente um link. Qual comportamento é mais adequado?",
                    "3",
                    "Gabarito: D) Procurar o serviço por seus canais oficiais e confirmar se existe algum problema.",
                    "Clicar no link para evitar o bloqueio.",
                    "Responder à mensagem solicitando mais informações.",
                    "Encaminhar o link para familiares verificarem.",
                    "Procurar o serviço por seus canais oficiais e confirmar se existe algum problema.",
                    "Informar seus dados para comprovar que é a titular da conta."},
            {"Geral",
                    "Por que utilizar senhas diferentes para cada serviço é uma medida importante?",
                    "0",
                    "Gabarito: A) Porque reduz o risco de comprometimento de outras contas caso uma senha seja descoberta.",
                    "Porque impede que uma senha comprometida seja utilizada automaticamente para acessar outras contas que tenham a mesma combinação.",
                    "Porque elimina a necessidade de utilizar autenticação em duas etapas.",
                    "Porque permite que todas as contas sejam recuperadas por um único código.",
                    "Porque impede que os dispositivos precisem receber atualizações.",
                    "Porque torna desnecessário verificar atividades desconhecidas nas contas."},
            {"Geral",
                    "Qual alternativa apresenta uma combinação de práticas recomendadas pelos materiais para proteger informações digitais?",
                    "2",
                    "Gabarito: C) Manter os dispositivos atualizados, utilizar senhas fortes e ativar a verificação em duas etapas.",
                    "Compartilhar senhas com familiares e evitar cópias de segurança.",
                    "Utilizar redes Wi-Fi públicas para operações bancárias e salvar todos os dados de acesso.",
                    "Manter os dispositivos atualizados, utilizar senhas fortes e ativar a verificação em duas etapas.",
                    "Instalar aplicativos recebidos por mensagens e permitir todas as permissões solicitadas.",
                    "Confiar em páginas que apresentam cadeado, independentemente do endereço."},
            {"Geral",
                    "Uma pessoa perdeu o celular e percebeu que ele armazenava fotografias e documentos importantes. Qual medida preventiva teria ajudado a recuperar esses arquivos?",
                    "4",
                    "Gabarito: E) Realizar cópias de segurança regularmente em um local confiável.",
                    "Manter todos os arquivos exclusivamente na memória do aparelho.",
                    "Compartilhar os documentos com contatos desconhecidos.",
                    "Desativar as atualizações automáticas do dispositivo.",
                    "Utilizar a mesma senha em todos os serviços de armazenamento.",
                    "Realizar cópias de segurança regularmente em um local confiável."},
            {"Geral",
                    "Qual é o principal risco de compartilhar códigos de confirmação recebidos por SMS ou aplicativos?",
                    "0",
                    "Gabarito: A) A pessoa que recebe o código pode utilizá-lo indevidamente para acessar ou confirmar operações.",
                    "A pessoa que recebe o código pode utilizá-lo para tentar acessar ou confirmar operações em suas contas.",
                    "O aparelho deixa de receber atualizações automaticamente.",
                    "O código passa a funcionar como uma cópia de segurança dos arquivos.",
                    "A conexão com a internet fica permanentemente desprotegida.",
                    "As configurações de privacidade das redes sociais são apagadas."},
            {"Geral",
                    "Por que a presença de HTTPS e do símbolo de cadeado não deve ser considerada uma garantia absoluta de confiança em um site?",
                    "3",
                    "Gabarito: D) Porque páginas falsas também podem utilizar HTTPS, sendo necessário verificar o endereço e a origem do site.",
                    "Porque esses recursos indicam que o site não possui informações sobre a empresa.",
                    "Porque o HTTPS funciona apenas em aplicativos de bancos.",
                    "Porque o cadeado significa que o site está em processo de atualização.",
                    "Porque páginas falsas também podem utilizar HTTPS, sendo necessário verificar o endereço e a origem do site.",
                    "Porque sites protegidos por HTTPS não podem receber pagamentos digitais."},
            {"Geral",
                    "Uma pessoa percebe que forneceu sua senha em uma página suspeita. Qual deve ser uma de suas primeiras providências?",
                    "1",
                    "Gabarito: B) Alterar a senha comprometida pelo canal oficial e verificar atividades desconhecidas.",
                    "Aguardar para verificar se alguém acessará a conta.",
                    "Alterar a senha comprometida pelo site ou aplicativo oficial e verificar atividades desconhecidas.",
                    "Compartilhar a senha com um familiar para que ele acompanhe a conta.",
                    "Apagar todas as mensagens recebidas, sem tomar outras providências.",
                    "Utilizar a mesma senha em outro serviço para facilitar a recuperação."},
            {"Geral",
                    "Qual situação demonstra uma preocupação adequada com a privacidade digital?",
                    "2",
                    "Gabarito: C) Revisar as configurações de privacidade e avaliar quais informações realmente precisam ser compartilhadas.",
                    "Publicar documentos pessoais para facilitar a identificação.",
                    "Divulgar a localização em tempo real para todos os seguidores.",
                    "Revisar as configurações de privacidade e avaliar quais informações realmente precisam ser compartilhadas.",
                    "Manter todas as permissões dos aplicativos ativadas permanentemente.",
                    "Compartilhar fotografias de familiares sem considerar a privacidade deles."},
            {"Geral",
                    "Qual afirmação representa corretamente a relação entre segurança digital e comportamento dos usuários?",
                    "4",
                    "Gabarito: E) A segurança depende tanto dos recursos tecnológicos quanto dos hábitos e decisões de cada pessoa.",
                    "A segurança depende exclusivamente de programas instalados no computador.",
                    "Apenas pessoas que realizam compras online precisam se preocupar com proteção digital.",
                    "Utilizar a internet com segurança significa evitar qualquer compartilhamento de informações.",
                    "A proteção digital é necessária somente quando ocorre uma tentativa de invasão.",
                    "A segurança depende tanto dos recursos tecnológicos quanto dos hábitos e decisões de cada pessoa."},
            {"Armadilhas digitais",
                    "O que caracteriza a engenharia social no ambiente digital?",
                    "2",
                    "Gabarito: C) A manipulação de pessoas por meio de conversas e situações falsas para conseguir alguma vantagem.",
                    "A utilização de programas para atualizar automaticamente os dispositivos.",
                    "A criação de cópias de segurança de informações pessoais.",
                    "A manipulação de pessoas por meio de conversas e situações falsas para conseguir alguma vantagem.",
                    "A instalação de aplicativos em lojas oficiais.",
                    "A utilização de mecanismos de autenticação para proteger contas."},
            {"Armadilhas digitais",
                    "Uma pessoa recebe um e-mail aparentemente enviado por seu banco, informando que sua senha expirou e que precisa acessar um link para recuperá-la. Qual golpe pode estar sendo praticado?",
                    "3",
                    "Gabarito: D) Phishing.",
                    "Backup fraudulento.",
                    "Bloqueio automático de dispositivo.",
                    "Compartilhamento indevido de arquivos.",
                    "Phishing.",
                    "Atualização de certificado digital."},
            {"Armadilhas digitais",
                    "Qual é a principal finalidade de um golpe de phishing?",
                    "0",
                    "Gabarito: A) Roubar informações pessoais, senhas ou dados bancários por meio de mensagens e páginas falsas.",
                    "Roubar informações pessoais, senhas ou dados bancários por meio de mensagens e páginas falsas.",
                    "Melhorar a proteção das contas por meio de códigos temporários.",
                    "Criar cópias de segurança de arquivos armazenados na nuvem.",
                    "Atualizar os aplicativos instalados no celular.",
                    "Verificar a identidade de usuários em sites oficiais."},
            {"Armadilhas digitais",
                    "Uma pessoa recebe uma mensagem de um número desconhecido com a fotografia de seu irmão. O remetente afirma que trocou de número e precisa de dinheiro urgentemente. O que deve ser feito antes de qualquer transferência?",
                    "4",
                    "Gabarito: E) Entrar em contato com o familiar por um canal conhecido para confirmar o pedido.",
                    "Enviar uma pequena quantia para confirmar se o pedido é verdadeiro.",
                    "Solicitar uma fotografia atual do documento do familiar pelo mesmo número.",
                    "Confiar na fotografia de perfil, pois ela demonstra a identidade do remetente.",
                    "Realizar a transferência e depois confirmar com a família.",
                    "Entrar em contato com o familiar pelo número antigo ou por outro meio conhecido."},
            {"Armadilhas digitais",
                    "Uma mensagem informa que determinada pessoa ganhou um celular em um sorteio do qual nunca participou, mas precisa pagar uma taxa para receber o prêmio. Qual sinal de alerta está presente?",
                    "1",
                    "Gabarito: B) A exigência de pagamento antecipado para liberar um prêmio inesperado.",
                    "A utilização de uma mensagem com linguagem formal.",
                    "A exigência de pagamento antecipado para liberar um prêmio inesperado.",
                    "A apresentação de informações sobre o funcionamento do aparelho.",
                    "A possibilidade de consultar o site oficial da empresa.",
                    "A utilização de um aplicativo de mensagens conhecido."},
            {"Armadilhas digitais",
                    "Um suposto funcionário de suporte técnico entra em contato inesperadamente e solicita a senha e um código de confirmação para corrigir um problema na conta. Qual é a atitude correta?",
                    "3",
                    "Gabarito: D) Não compartilhar as informações e procurar atendimento pelos canais oficiais da empresa.",
                    "Fornecer somente o código, mantendo a senha em segredo.",
                    "Compartilhar os dados caso o funcionário conheça seu nome completo.",
                    "Permitir o acesso remoto ao aparelho para agilizar o atendimento.",
                    "Não compartilhar as informações e procurar atendimento pelos canais oficiais da empresa.",
                    "Enviar uma fotografia da tela para comprovar o problema."},
            {"Armadilhas digitais",
                    "Qual alternativa apresenta um conjunto de sinais que pode indicar uma tentativa de golpe?",
                    "0",
                    "Gabarito: A) Mensagens com urgência, links estranhos, pedidos de códigos e ofertas difíceis de acreditar.",
                    "Mensagens com urgência, links estranhos, pedidos de códigos e ofertas difíceis de acreditar.",
                    "Avisos de atualização obtidos diretamente no aplicativo oficial.",
                    "Confirmações de compra consultadas no aplicativo do banco.",
                    "Mensagens de familiares confirmadas por uma ligação conhecida.",
                    "Orientações de segurança encontradas nos canais oficiais de uma empresa."},
            {"Armadilhas digitais",
                    "Por que uma mensagem bem escrita e com aparência profissional ainda pode representar uma ameaça?",
                    "2",
                    "Gabarito: C) A aparência não comprova sua autenticidade, sendo necessário verificar a origem e as informações.",
                    "Porque mensagens profissionais são sempre enviadas por criminosos.",
                    "Porque mensagens falsas não podem utilizar nomes de empresas conhecidas.",
                    "Porque a aparência da mensagem não comprova sua autenticidade, sendo necessário verificar a origem e as informações.",
                    "Porque mensagens com boa escrita não podem ser denunciadas.",
                    "Porque somente mensagens com erros de português podem ser golpes."},
            {"Armadilhas digitais",
                    "Ao perceber que caiu em um golpe e compartilhou informações importantes, qual conjunto de providências está de acordo com o material de estudo?",
                    "4",
                    "Gabarito: E) Alterar a senha, contatar o banco quando necessário e guardar as evidências do golpe.",
                    "Continuar utilizando a conta normalmente e apagar as mensagens recebidas.",
                    "Aguardar uma nova tentativa de contato antes de tomar qualquer atitude.",
                    "Bloquear o aparelho e deixar de utilizar todos os serviços digitais permanentemente.",
                    "Compartilhar o ocorrido em redes sociais, sem guardar evidências.",
                    "Alterar a senha pelo canal oficial, contatar o banco se houver movimentação suspeita e guardar as evidências."},
            {"Armadilhas digitais",
                    "Um criminoso afirma que a conta de uma vítima será bloqueada em poucos minutos, tentando fazê-la clicar rapidamente em um link. Qual estratégia de manipulação está sendo utilizada?",
                    "3",
                    "Gabarito: D) Provocação de urgência para fazer a vítima agir sem verificar a situação.",
                    "Recuperação de conta por autenticação.",
                    "Criação de um backup automático.",
                    "Verificação de identidade por certificado digital.",
                    "Provocação de urgência para fazer a vítima agir sem verificar a situação.",
                    "Atualização de permissões de aplicativos."},
            {"Vida online",
                    "Qual característica deve estar presente em uma senha forte, de acordo com o material de estudo?",
                    "3",
                    "Gabarito: D) Combinar letras maiúsculas, letras minúsculas, números e símbolos, sendo difícil de adivinhar.",
                    "Ser formada apenas pelo nome do usuário.",
                    "Utilizar uma data de nascimento fácil de lembrar.",
                    "Repetir uma sequência numérica simples.",
                    "Combinar letras maiúsculas, letras minúsculas, números e símbolos, sendo difícil de adivinhar.",
                    "Ser igual à senha utilizada no e-mail para facilitar o acesso."},
            {"Vida online",
                    "Qual é a função de um gerenciador de senhas confiável?",
                    "0",
                    "Gabarito: A) Armazenar e organizar diferentes senhas com segurança.",
                    "Armazenar e organizar diferentes senhas com segurança, reduzindo a necessidade de memorizar todas elas.",
                    "Compartilhar automaticamente as senhas com todos os contatos.",
                    "Substituir a necessidade de proteger as contas.",
                    "Desativar a autenticação em duas etapas.",
                    "Permitir que todos os serviços utilizem uma única senha."},
            {"Vida online",
                    "Como funciona a verificação em duas etapas?",
                    "2",
                    "Gabarito: C) Exige uma segunda confirmação além da senha.",
                    "Solicita que o usuário informe duas vezes a mesma senha.",
                    "Substitui todas as senhas por uma pergunta de segurança.",
                    "Exige uma segunda confirmação, como um código temporário ou aprovação por aplicativo autenticador, além da senha.",
                    "Permite o acesso à conta sem qualquer identificação.",
                    "Solicita que o usuário utilize dois dispositivos simultaneamente em todas as situações."},
            {"Vida online",
                    "Por que é importante manter o sistema operacional e os aplicativos atualizados?",
                    "1",
                    "Gabarito: B) Porque muitas atualizações corrigem falhas de segurança.",
                    "Porque as atualizações eliminam a necessidade de senhas fortes.",
                    "Porque muitas atualizações corrigem falhas que poderiam ser exploradas para acessar informações ou prejudicar os dispositivos.",
                    "Porque todos os aplicativos passam a funcionar sem conexão com a internet.",
                    "Porque as atualizações impedem qualquer tentativa de engenharia social.",
                    "Porque os arquivos pessoais deixam de precisar de backup."},
            {"Vida online",
                    "Uma pessoa costuma publicar fotografias que mostram seu endereço, localização em tempo real e horários em que sai de casa. Qual é o principal risco desse comportamento?",
                    "4",
                    "Gabarito: E) Pessoas mal-intencionadas podem utilizar essas informações para conhecer sua rotina e localização.",
                    "O aparelho pode deixar de receber notificações.",
                    "As publicações podem impedir o funcionamento dos aplicativos.",
                    "As redes sociais podem apagar automaticamente suas fotografias.",
                    "As senhas de todos os serviços serão alteradas.",
                    "Pessoas mal-intencionadas podem utilizar essas informações para conhecer sua rotina e sua localização."},
            {"Vida online",
                    "Qual cuidado é recomendado ao utilizar uma rede Wi-Fi pública?",
                    "0",
                    "Gabarito: A) Confirmar a origem da rede e evitar operações importantes em conexões não confiáveis.",
                    "Confirmar se a rede pertence ao estabelecimento e evitar operações importantes em conexões não confiáveis.",
                    "Acessar livremente serviços bancários, desde que a rede tenha um nome conhecido.",
                    "Salvar todas as senhas no navegador para facilitar o acesso.",
                    "Ativar a conexão automática para qualquer rede disponível.",
                    "Desconsiderar a origem da rede quando ela não exige senha."},
            {"Vida online",
                    "Uma pessoa encontra um site com cadeado e HTTPS, mas percebe que o endereço possui letras diferentes do endereço oficial da empresa. O que deve considerar?",
                    "2",
                    "Gabarito: C) HTTPS protege a conexão, mas não comprova que o site é verdadeiro.",
                    "O cadeado garante que a empresa é verdadeira.",
                    "O HTTPS elimina qualquer possibilidade de fraude.",
                    "O endereço pode ser falso, pois HTTPS protege a conexão, mas não comprova a honestidade do site.",
                    "O site deve ser confiável se abrir corretamente no navegador.",
                    "O endereço não precisa ser verificado quando existe HTTPS."},
            {"Vida online",
                    "Um aplicativo simples de calculadora solicita acesso à localização e aos contatos do celular. Qual atitude é mais adequada?",
                    "3",
                    "Gabarito: D) Revisar as permissões e permitir somente os acessos necessários.",
                    "Autorizar todas as permissões para evitar falhas.",
                    "Permitir os acessos apenas se o aplicativo apresentar uma boa aparência.",
                    "Compartilhar os contatos para melhorar o desempenho da calculadora.",
                    "Revisar as permissões e permitir somente os acessos realmente necessários.",
                    "Desativar o bloqueio de tela para facilitar o funcionamento do aplicativo."},
            {"Vida online",
                    "Qual é a principal finalidade de realizar backups dos arquivos pessoais?",
                    "1",
                    "Gabarito: B) Manter cópias dos arquivos em outro local para possibilitar sua recuperação.",
                    "Permitir que outras pessoas acessem os documentos armazenados.",
                    "Manter cópias dos arquivos em outro local para possibilitar sua recuperação em caso de perda ou dano ao aparelho original.",
                    "Substituir a necessidade de atualizar os dispositivos.",
                    "Eliminar permanentemente os arquivos do dispositivo principal.",
                    "Evitar que o usuário precise utilizar senhas em serviços digitais."},
            {"Vida online",
                    "Ao utilizar um computador público ou compartilhado para acessar uma conta, qual comportamento é recomendado?",
                    "4",
                    "Gabarito: E) Evitar salvar senhas e sair da conta ao terminar de utilizá-la.",
                    "Salvar a senha no navegador para não precisar digitá-la novamente.",
                    "Manter a conta aberta para facilitar o próximo acesso.",
                    "Compartilhar a sessão com outros usuários do computador.",
                    "Utilizar a mesma senha em todos os serviços acessados.",
                    "Evitar salvar senhas e sair da conta ao terminar de utilizá-la."},
            {"Família e seus dados",
                    "Por que a segurança digital deve ser uma preocupação de todos os integrantes da família?",
                    "2",
                    "Gabarito: C) Porque os dados de um familiar podem ser utilizados para acessar informações, aplicar golpes ou se passar pela vítima.",
                    "Porque somente os adultos podem sofrer golpes financeiros.",
                    "Porque apenas os dispositivos utilizados para trabalho armazenam informações importantes.",
                    "Porque os dados de um familiar podem ser utilizados para acessar informações, aplicar golpes ou se passar pela vítima.",
                    "Porque todos os familiares precisam utilizar a mesma senha.",
                    "Porque a segurança dos dispositivos depende exclusivamente de quem os comprou."},
            {"Família e seus dados",
                    "Qual medida ajuda a proteger celulares e computadores utilizados pelos integrantes da família?",
                    "3",
                    "Gabarito: D) Utilizar mecanismos de bloqueio, como senha, reconhecimento facial ou impressão digital.",
                    "Manter os aparelhos desbloqueados dentro de casa.",
                    "Compartilhar uma única conta de usuário entre todos os integrantes.",
                    "Desativar o bloqueio automático para facilitar o acesso.",
                    "Utilizar mecanismos de bloqueio, como senha, reconhecimento facial ou impressão digital.",
                    "Guardar todas as senhas em um arquivo sem proteção."},
            {"Família e seus dados",
                    "Qual deve ser o principal objetivo ao orientar crianças e adolescentes sobre segurança na internet?",
                    "0",
                    "Gabarito: A) Ensinar a reconhecer situações de risco e procurar ajuda de um adulto de confiança.",
                    "Ensinar a reconhecer situações de risco e procurar ajuda de um adulto de confiança quando algo parecer estranho.",
                    "Impedir permanentemente qualquer utilização de jogos e redes sociais.",
                    "Permitir que compartilhem informações pessoais com qualquer pessoa conhecida online.",
                    "Substituir todas as conversas familiares por ferramentas de controle parental.",
                    "Incentivar o compartilhamento de localização para facilitar o contato com desconhecidos."},
            {"Família e seus dados",
                    "Uma criança recebe uma mensagem de uma pessoa desconhecida solicitando seu endereço e o nome da escola onde estuda. Como os responsáveis devem orientá-la?",
                    "4",
                    "Gabarito: E) Não compartilhar essas informações e procurar um adulto de confiança.",
                    "Responder somente o nome da escola.",
                    "Enviar as informações se a pessoa utilizar uma fotografia conhecida.",
                    "Compartilhar os dados apenas quando a conversa parecer amigável.",
                    "Pedir que outro colega responda à mensagem.",
                    "Não compartilhar essas informações e procurar um adulto de confiança para relatar a situação."},
            {"Família e seus dados",
                    "Um criminoso utiliza a fotografia de um familiar em um número desconhecido e afirma que está enfrentando uma emergência financeira. Qual procedimento ajuda a evitar esse golpe?",
                    "1",
                    "Gabarito: B) Confirmar a identidade por uma ligação para um número conhecido.",
                    "Confiar na fotografia e realizar a transferência.",
                    "Confirmar a identidade por uma ligação para um número que a família já conhece.",
                    "Solicitar que o remetente envie outro pedido de dinheiro.",
                    "Compartilhar o pedido em redes sociais antes de transferir.",
                    "Enviar os dados bancários para confirmar a identidade do familiar."},
            {"Família e seus dados",
                    "Por que é importante verificar fotografias antes de publicá-las nas redes sociais?",
                    "2",
                    "Gabarito: C) Porque imagens podem revelar informações privadas da família.",
                    "Porque todas as fotografias publicadas são automaticamente transformadas em documentos públicos.",
                    "Porque fotografias não podem ser compartilhadas por outras pessoas.",
                    "Porque imagens podem revelar endereço, escola, documentos ou localização de familiares.",
                    "Porque publicar fotografias impede a realização de backups.",
                    "Porque as redes sociais utilizam as imagens para alterar as senhas dos usuários."},
            {"Família e seus dados",
                    "Em uma residência, vários integrantes utilizam o mesmo computador. Qual prática é recomendada pelo material?",
                    "0",
                    "Gabarito: A) Utilizar contas de usuário separadas.",
                    "Utilizar contas de usuário separadas para que cada pessoa mantenha seus próprios arquivos e configurações.",
                    "Compartilhar a mesma conta e a mesma senha para facilitar a organização.",
                    "Desativar as proteções do computador para evitar conflitos entre usuários.",
                    "Armazenar todos os documentos em uma única pasta pública.",
                    "Manter o computador permanentemente desbloqueado."},
            {"Família e seus dados",
                    "Qual é a finalidade de utilizar recursos de controle parental quando necessário?",
                    "3",
                    "Gabarito: D) Auxiliar na definição de limites adequados e na proteção dos mais jovens.",
                    "Substituir completamente a orientação dos responsáveis.",
                    "Permitir que crianças conversem livremente com desconhecidos.",
                    "Impedir que os responsáveis conversem com os filhos sobre internet.",
                    "Auxiliar na definição de limites adequados para o uso da tecnologia e na proteção dos mais jovens.",
                    "Eliminar a necessidade de revisar as permissões dos aplicativos."},
            {"Família e seus dados",
                    "Uma família deseja evitar a perda de fotografias, vídeos e documentos importantes armazenados nos celulares. Qual medida deve adotar?",
                    "4",
                    "Gabarito: E) Criar uma rotina de cópias de segurança e verificar se os arquivos podem ser recuperados.",
                    "Manter todos os arquivos somente nos aparelhos utilizados diariamente.",
                    "Enviar os arquivos para contatos diferentes por mensagens.",
                    "Desativar as contas de armazenamento em nuvem.",
                    "Realizar backups apenas depois de perder algum arquivo.",
                    "Criar uma rotina de cópias de segurança em serviços confiáveis ou dispositivos externos e verificar se os arquivos podem ser recuperados."},
            {"Família e seus dados",
                    "Qual comportamento contribui para criar um ambiente familiar mais seguro digitalmente?",
                    "1",
                    "Gabarito: B) Conversar regularmente sobre golpes, privacidade e proteção de dados.",
                    "Evitar que familiares contem quando recebem mensagens suspeitas.",
                    "Conversar regularmente sobre golpes, privacidade e proteção de dados, incentivando todos a relatar situações estranhas.",
                    "Permitir que somente uma pessoa conheça os riscos existentes na internet.",
                    "Compartilhar códigos de confirmação entre os integrantes da família.",
                    "Considerar desnecessárias as orientações de segurança para pessoas mais jovens."},
            {"Chaves de segurança",
                    "De acordo com o material, o que são chaves de segurança?",
                    "3",
                    "Gabarito: D) Recursos utilizados para proteger o acesso a contas, dispositivos, sistemas e informações pessoais.",
                    "Exclusivamente os códigos enviados por SMS para confirmar pagamentos.",
                    "Apenas dispositivos físicos utilizados para desbloquear computadores.",
                    "Arquivos utilizados para armazenar fotografias e documentos pessoais.",
                    "Recursos utilizados para proteger o acesso a contas, dispositivos, sistemas e informações pessoais.",
                    "Ferramentas destinadas somente à recuperação de arquivos apagados."},
            {"Chaves de segurança",
                    "Uma pessoa descobre que a senha utilizada em um serviço foi exposta em um vazamento de dados. Qual providência é recomendada?",
                    "0",
                    "Gabarito: A) Alterar imediatamente a senha comprometida e verificar se ela também foi utilizada em outros serviços.",
                    "Alterar imediatamente a senha comprometida e verificar se ela também foi utilizada em outros serviços.",
                    "Manter a senha até que apareça alguma atividade suspeita.",
                    "Desativar a verificação em duas etapas para facilitar o acesso.",
                    "Compartilhar a senha com um familiar para acompanhar possíveis invasões.",
                    "Excluir somente o aplicativo do serviço, sem alterar as credenciais."},
            {"Chaves de segurança",
                    "Qual é a função de uma chave de recuperação?",
                    "2",
                    "Gabarito: C) Ajudar a recuperar o acesso a uma conta quando os métodos tradicionais não podem ser utilizados.",
                    "Substituir permanentemente todas as senhas de uma pessoa.",
                    "Permitir que qualquer usuário acesse uma conta sem autorização.",
                    "Ajudar a recuperar o acesso a uma conta quando a senha ou os métodos tradicionais de autenticação não podem ser utilizados.",
                    "Realizar automaticamente cópias de segurança dos dispositivos.",
                    "Confirmar pagamentos realizados por cartão de crédito."},
            {"Chaves de segurança",
                    "Uma pessoa troca de celular, mas o aparelho antigo continua aparecendo na lista de dispositivos autorizados de sua conta. Qual atitude deve tomar?",
                    "4",
                    "Gabarito: E) Remover o aparelho antigo da lista de dispositivos autorizados.",
                    "Manter o dispositivo antigo autorizado para facilitar futuras atualizações.",
                    "Compartilhar a conta com o novo proprietário do aparelho.",
                    "Desativar todas as formas de autenticação.",
                    "Alterar somente o nome do dispositivo, sem revisar os acessos.",
                    "Remover o aparelho antigo da lista de dispositivos autorizados."},
            {"Chaves de segurança",
                    "Qual alternativa descreve corretamente a verificação em duas etapas?",
                    "1",
                    "Gabarito: B) Uma proteção que acrescenta uma segunda confirmação ao acesso.",
                    "Um recurso que exige duas senhas iguais para liberar o acesso.",
                    "Uma proteção que acrescenta uma segunda confirmação, como código temporário, aprovação por aplicativo autenticador ou chave física.",
                    "Um procedimento que permite acessar a conta sem informar credenciais.",
                    "Uma ferramenta que substitui a necessidade de atualizar senhas comprometidas.",
                    "Um mecanismo utilizado exclusivamente para armazenar códigos de recuperação."},
            {"Chaves de segurança",
                    "Como as chaves de recuperação devem ser armazenadas?",
                    "3",
                    "Gabarito: D) Em um local seguro, separado do dispositivo utilizado diariamente.",
                    "Em mensagens enviadas para vários contatos.",
                    "Em arquivos desprotegidos na área de trabalho.",
                    "Em publicações privadas nas redes sociais.",
                    "Em um local seguro, separado do dispositivo utilizado diariamente, sem compartilhá-las por mensagens ou ligações.",
                    "Junto com a senha em qualquer aplicativo desconhecido."},
            {"Chaves de segurança",
                    "Qual é a função dos certificados digitais mencionados no material?",
                    "0",
                    "Gabarito: A) Ajudar a verificar identidades e estabelecer conexões seguras entre sistemas.",
                    "Ajudar a verificar identidades e estabelecer conexões seguras entre sistemas.",
                    "Armazenar todas as senhas utilizadas pelo usuário.",
                    "Substituir os mecanismos de bloqueio de celulares.",
                    "Impedir que arquivos pessoais sejam apagados.",
                    "Gerar automaticamente códigos de recuperação para qualquer conta."},
            {"Chaves de segurança",
                    "Uma pessoa utiliza diversos serviços digitais e deseja administrar suas credenciais de maneira mais organizada. Qual ferramenta é indicada pelo material?",
                    "2",
                    "Gabarito: C) Um gerenciador de senhas confiável.",
                    "Um aplicativo de mensagens sem proteção.",
                    "Um arquivo de texto compartilhado com familiares.",
                    "Um gerenciador de senhas confiável.",
                    "Uma rede Wi-Fi pública com acesso automático.",
                    "Um aplicativo desconhecido recebido por mensagem."},
            {"Chaves de segurança",
                    "Qual alternativa apresenta uma rotina adequada de verificação da segurança das contas?",
                    "4",
                    "Gabarito: E) Verificar senhas, dispositivos conectados, métodos de recuperação e avisos de segurança.",
                    "Trocar todas as senhas diariamente, independentemente de qualquer motivo.",
                    "Conferir somente se as contas continuam abrindo normalmente.",
                    "Manter dispositivos antigos conectados para evitar novas autenticações.",
                    "Ignorar avisos de segurança quando não houver problemas aparentes.",
                    "Verificar senhas, dispositivos conectados, métodos de recuperação e avisos de segurança dos serviços."},
            {"Chaves de segurança",
                    "Uma pessoa acredita que precisa trocar todas as suas senhas constantemente, mesmo quando não existe nenhum sinal de comprometimento. Qual orientação corresponde ao material de estudo?",
                    "1",
                    "Gabarito: B) Não é necessário trocar todas as senhas constantemente sem motivo; a alteração deve ocorrer quando houver uma razão para isso.",
                    "Todas as senhas devem ser alteradas diariamente.",
                    "Não é necessário trocar todas as senhas constantemente sem motivo; a alteração é importante quando houver suspeita de comprometimento, exposição ou recomendação do serviço.",
                    "As senhas nunca devem ser alteradas depois de criadas.",
                    "Somente senhas utilizadas em redes sociais precisam ser modificadas.",
                    "A troca de senhas deve ocorrer apenas quando o usuário perder o dispositivo."},
            {"Compras online",
                    "Antes de realizar uma compra em uma loja virtual desconhecida, qual atitude é recomendada?",
                    "2",
                    "Gabarito: C) Pesquisar a reputação da loja e verificar as informações da empresa.",
                    "Comprar imediatamente se o preço for inferior ao de outras lojas.",
                    "Confiar exclusivamente nos depoimentos publicados dentro do próprio site.",
                    "Pesquisar a reputação da loja, consultar avaliações em outras fontes e verificar as informações da empresa.",
                    "Realizar o pagamento antes de conferir os dados da loja.",
                    "Considerar desnecessária a verificação das formas de contato."},
            {"Compras online",
                    "Uma loja anuncia um produto muito procurado por um preço extremamente abaixo do praticado em outros estabelecimentos. Além disso, apresenta um contador indicando que a oferta terminará em poucos minutos. Qual é a atitude mais adequada?",
                    "4",
                    "Gabarito: E) Comparar os preços e desconfiar da oferta antes de realizar a compra.",
                    "Comprar rapidamente para não perder a oportunidade.",
                    "Realizar o pagamento por Pix para garantir o desconto.",
                    "Compartilhar a oferta com familiares antes de comprar.",
                    "Desconsiderar o preço das outras lojas, pois promoções sempre apresentam grandes diferenças.",
                    "Comparar os preços e desconfiar da oferta, pois o desconto exagerado e a pressão pelo tempo podem ser estratégias para induzir uma compra precipitada."},
            {"Compras online",
                    "Qual é a melhor prática para acessar o site de uma loja antes de realizar uma compra?",
                    "0",
                    "Gabarito: A) Digitar o endereço diretamente no navegador ou utilizar o aplicativo oficial.",
                    "Digitar o endereço diretamente no navegador ou utilizar o aplicativo oficial obtido em uma fonte confiável.",
                    "Utilizar qualquer link recebido em grupos de mensagens.",
                    "Acessar somente por anúncios que prometem descontos exclusivos.",
                    "Confiar em endereços que tenham nomes parecidos com o da loja original.",
                    "Escolher o primeiro resultado sem verificar o endereço."},
            {"Compras online",
                    "Por que o cartão virtual pode ser uma opção interessante para compras online?",
                    "3",
                    "Gabarito: D) Porque pode gerar números temporários ou específicos para compras online.",
                    "Porque impede que o consumidor precise conferir o valor da compra.",
                    "Porque elimina a possibilidade de qualquer fraude.",
                    "Porque permite compartilhar os dados do cartão sem riscos.",
                    "Porque pode gerar números temporários ou específicos para compras online, reduzindo os riscos em caso de vazamento de dados.",
                    "Porque substitui a necessidade de acompanhar as movimentações bancárias."},
            {"Compras online",
                    "Ao realizar um pagamento por Pix, o consumidor percebe que o nome do recebedor não tem relação com a loja em que está comprando. O que deve fazer?",
                    "1",
                    "Gabarito: B) Interromper a operação e confirmar os dados por outro canal.",
                    "Confirmar a transferência, pois o nome do recebedor pode ser ignorado.",
                    "Interromper a operação e confirmar os dados por outro canal antes de realizar o pagamento.",
                    "Enviar o comprovante para a loja e aguardar a confirmação.",
                    "Realizar um segundo Pix de valor menor para testar a conta.",
                    "Compartilhar o código de confirmação bancária com o vendedor."},
            {"Compras online",
                    "Qual informação deve ser conferida antes de efetuar o pagamento de um boleto?",
                    "4",
                    "Gabarito: E) O nome do beneficiário, o valor, a data e o banco emissor.",
                    "Somente a aparência visual do documento.",
                    "Apenas o nome da empresa que enviou a mensagem.",
                    "Exclusivamente a data em que o boleto foi recebido.",
                    "Somente o valor informado no anúncio da compra.",
                    "O nome do beneficiário, o valor, a data e o banco emissor."},
            {"Compras online",
                    "Uma pessoa recebe um QR Code de pagamento enviado por um desconhecido. Qual cuidado deve adotar antes de confirmar a operação?",
                    "2",
                    "Gabarito: C) Conferir os dados exibidos no aplicativo e desconfiar de códigos suspeitos.",
                    "Pagar imediatamente se o código abrir corretamente no aplicativo.",
                    "Confiar no QR Code caso ele esteja acompanhado de uma imagem de uma empresa conhecida.",
                    "Conferir os dados exibidos no aplicativo e desconfiar de códigos enviados por desconhecidos ou apresentados em situações inesperadas.",
                    "Ignorar o nome do recebedor, pois o QR Code identifica automaticamente a loja.",
                    "Compartilhar o código com outras pessoas para que realizem o pagamento."},
            {"Compras online",
                    "Durante uma negociação em uma plataforma de classificados, o vendedor recebe uma imagem de comprovante de pagamento enviada pelo comprador. O que deve fazer antes de entregar o produto?",
                    "0",
                    "Gabarito: A) Confirmar diretamente no aplicativo do banco se o dinheiro realmente entrou na conta.",
                    "Confirmar diretamente no aplicativo do banco se o dinheiro realmente entrou na conta.",
                    "Entregar o produto assim que receber a imagem do comprovante.",
                    "Considerar o pagamento confirmado se a imagem apresentar o logotipo do banco.",
                    "Compartilhar seus dados bancários completos com o comprador.",
                    "Excluir a conversa para evitar exposição de informações."},
            {"Compras online",
                    "Por que é importante guardar anúncios, comprovantes, notas fiscais e conversas relacionadas a uma compra online?",
                    "3",
                    "Gabarito: D) Porque esses registros podem servir como evidências em caso de reclamação.",
                    "Para permitir que outras pessoas utilizem os dados do pedido.",
                    "Para substituir a necessidade de acompanhar a entrega.",
                    "Para evitar que a loja precise fornecer atendimento.",
                    "Porque esses registros podem servir como evidências caso seja necessário realizar uma reclamação.",
                    "Porque os comprovantes impedem automaticamente qualquer fraude."},
            {"Compras online",
                    "Uma pessoa percebe que realizou um pagamento para uma loja falsa e suspeita que seus dados financeiros foram expostos. Qual conjunto de providências está de acordo com o material?",
                    "1",
                    "Gabarito: B) Entrar em contato com o banco ou operadora, guardar evidências e proteger os dados expostos.",
                    "Aguardar a entrega do produto antes de procurar ajuda.",
                    "Entrar em contato imediatamente com o banco ou operadora do cartão pelos canais oficiais, guardar evidências e avaliar a necessidade de alterar senhas ou bloquear o cartão.",
                    "Apagar todas as conversas e comprovantes para evitar exposição.",
                    "Realizar outro pagamento para tentar recuperar o primeiro valor.",
                    "Entrar em contato exclusivamente com o perfil que realizou a venda."}
    };
    private static final Color ROXO_ESCURO = new Color(74, 10, 58);
    private static final Color BLOCO = new Color(162, 32, 103);
    private static final Color ACERTO = new Color(109, 178, 107);
    private static final Color ERRO = new Color(178, 107, 107);
    private static final Color DESEMPENHO_BAIXO = new Color(222, 140, 60);
    private static final int LARGURA_TEXTO = 426;

    private Component cabecalhoOriginal, opcoesOriginal;
    private JPanel telaQuestoes;
    private java.util.List<String[]> questoesAtuais;
    private int atual;
    private boolean emResultado;
    private int[] respostas;
    private boolean[] confirmadas;

    private final JLabel tituloQuestoes = new JLabel("", SwingConstants.CENTER);
    private final JLabel barraQuestao = new JLabel("", SwingConstants.CENTER);
    private final JPanel conteudoQuestao = new JPanel(new BorderLayout(0, 12));
    private final JButton botaoAnterior = Cores.criarBotao("");
    private final JButton botaoPrincipal = Cores.criarBotao("");
    private final JButton botaoAbandonar = Cores.criarBotao("");

    private void iniciarQuiz() {
        questoesAtuais = new java.util.ArrayList<>(java.util.Arrays.stream(QUESTOES)
                .filter(q -> q[TEMA].equalsIgnoreCase(temaSelecionado)).toList());
        java.util.Collections.shuffle(questoesAtuais);
        questoesAtuais = questoesAtuais.subList(0, Math.min(numeroQuestoesSelecionado, questoesAtuais.size()));
        atual = 0;
        respostas = new int[questoesAtuais.size()];
        java.util.Arrays.fill(respostas, -1);
        confirmadas = new boolean[questoesAtuais.size()];

        BorderLayout layout = (BorderLayout) getLayout();
        cabecalhoOriginal = layout.getLayoutComponent(BorderLayout.NORTH);
        opcoesOriginal = layout.getLayoutComponent(BorderLayout.CENTER);
        if (telaQuestoes == null) telaQuestoes = criarTelaQuestoes();
        tituloQuestoes.setText("Tema: " + temaSelecionado);
        mostrarQuestao();

        remove(cabecalhoOriginal);
        remove(opcoesOriginal);
        add(telaQuestoes, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void voltarParaOpcoes() {
        remove(telaQuestoes);
        add(cabecalhoOriginal, BorderLayout.NORTH);
        add(opcoesOriginal, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private JPanel criarTelaQuestoes() {
        JPanel tela = painel(new BorderLayout());
        tituloQuestoes.setFont(fonte(Font.BOLD, 28));
        tituloQuestoes.setForeground(new Color(219, 31, 119));
        tituloQuestoes.setBorder(BorderFactory.createEmptyBorder(25, 10, 20, 10));
        tela.add(tituloQuestoes, BorderLayout.NORTH);

        barraQuestao.setOpaque(true);
        barraQuestao.setBackground(ROXO_ESCURO);
        barraQuestao.setForeground(Color.WHITE);
        barraQuestao.setFont(fonte(Font.PLAIN, 20));
        barraQuestao.setPreferredSize(new Dimension(0, 38));

        conteudoQuestao.setBackground(Color.WHITE);
        conteudoQuestao.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        tela.add(conteudoQuestao, BorderLayout.CENTER);

        JPanel rodape = painel(new GridLayout(1, 3, 8, 0));
        rodape.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 10));
        rodape.setPreferredSize(new Dimension(0, 75));
        for (JButton botao : new JButton[]{botaoAnterior, botaoPrincipal, botaoAbandonar}) {
            botao.setFont(fonte(Font.BOLD, 13));
            botao.setForeground(Color.WHITE);
            rodape.add(botao);
        }
        tela.add(rodape, BorderLayout.SOUTH);

        botaoAbandonar.setText(duasLinhas("Abandonar quiz"));
        botaoAbandonar.setBackground(Cores.ROSA_CLARO);
        botaoAnterior.addActionListener(_ -> {
            if (atual > 0) {
                atual--;
                mostrarQuestao();
            }
        });
        botaoPrincipal.addActionListener(_ -> aoClicar());
        botaoAbandonar.addActionListener(_ -> voltarParaOpcoes());
        return tela;
    }

    private void mostrarQuestao() {
        String[] q = questoesAtuais.get(atual);
        int quantidade = q.length - PRIMEIRA_ALTERNATIVA;
        emResultado = false;
        botaoAnterior.setVisible(true);
        botaoAbandonar.setVisible(true);
        barraQuestao.setText(String.format("Questão %02d", atual + 1));

        JPanel corpo;
        if (!confirmadas[atual]) {
            corpo = painel(new GridLayout(quantidade, 1, 0, 8));
            for (int i = 0; i < quantidade; i++) corpo.add(criarAlternativa(q, i));
        } else {
            JButton escolhida = criarAlternativa(q, respostas[atual]);
            escolhida.setPreferredSize(new Dimension(0, 62));
            String explicacao = q[EXPLICACAO].isBlank()
                    ? "Gabarito: " + (char) ('A' + correta(q)) + ") " + q[PRIMEIRA_ALTERNATIVA + correta(q)]
                    : q[EXPLICACAO];
            JPanel resultado = painel(new BorderLayout(0, 8));
            resultado.add(escolhida, BorderLayout.NORTH);
            resultado.add(criarBloco(explicacao, Font.PLAIN, 14), BorderLayout.CENTER);
            corpo = painel(new BorderLayout());
            corpo.add(resultado, BorderLayout.NORTH);
        }
        montarConteudo(criarBloco(q[ENUNCIADO], Font.BOLD, 15), corpo);
        atualizarBotoes();
    }

    private void montarConteudo(Component abaixoDaBarra, Component corpo) {
        JPanel topo = painel(new BorderLayout(0, 12));
        topo.add(barraQuestao, BorderLayout.NORTH);
        topo.add(abaixoDaBarra, BorderLayout.CENTER);
        conteudoQuestao.removeAll();
        conteudoQuestao.add(topo, BorderLayout.NORTH);
        if (corpo != null) conteudoQuestao.add(corpo, BorderLayout.CENTER);
        conteudoQuestao.revalidate();
        conteudoQuestao.repaint();
    }

    private JPanel criarBloco(String texto, int estilo, int tamanho) {
        JTextArea area = new JTextArea(texto);
        area.setFont(fonte(estilo, tamanho));
        area.setForeground(Color.WHITE);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setEditable(false);
        area.setFocusable(false);
        area.setOpaque(false);
        area.setSize(LARGURA_TEXTO, Short.MAX_VALUE);

        JPanel bloco = new JPanel(new BorderLayout());
        bloco.setBackground(BLOCO);
        bloco.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        bloco.add(area, BorderLayout.CENTER);
        bloco.setPreferredSize(new Dimension(LARGURA_TEXTO + 24, area.getPreferredSize().height + 24));
        return bloco;
    }

    private JButton criarAlternativa(String[] q, int indice) {
        Color cor = confirmadas[atual] ? (indice == correta(q) ? ACERTO : ERRO)
                : respostas[atual] == indice ? Cores.ROSA_CLARO : Cores.ROSA;

        JLabel letra = new JLabel(String.valueOf((char) ('A' + indice)), SwingConstants.CENTER);
        letra.setFont(fonte(Font.PLAIN, 22));
        letra.setForeground(Color.WHITE);
        letra.setPreferredSize(new Dimension(60, 0));

        int maior = java.util.Arrays.stream(q, PRIMEIRA_ALTERNATIVA, q.length).mapToInt(String::length).max().getAsInt();
        JLabel texto = new JLabel("<html>" + escapar(q[PRIMEIRA_ALTERNATIVA + indice]) + "</html>");
        texto.setFont(fonte(Font.PLAIN, maior > 160 ? 13 : maior > 120 ? 14 : 16));
        texto.setForeground(Color.WHITE);

        JButton linha = Cores.criarBotao("");
        linha.setLayout(new BorderLayout());
        linha.setMargin(new Insets(0, 0, 0, 0));
        linha.setBackground(cor);
        linha.add(letra, BorderLayout.WEST);
        linha.add(texto, BorderLayout.CENTER);
        if (!confirmadas[atual]) {
            linha.addActionListener(_ -> {
                respostas[atual] = respostas[atual] == indice ? -1 : indice;
                mostrarQuestao();
            });
        }
        return linha;
    }

    private void aoClicar() {
        if (emResultado) {
            voltarParaOpcoes();
        } else if (!confirmadas[atual]) {
            if (respostas[atual] >= 0) {
                confirmadas[atual] = true;
                mostrarQuestao();
            }
        } else if (atual < questoesAtuais.size() - 1) {
            atual++;
            mostrarQuestao();
        } else {
            mostrarResultado();
        }
    }

    private void mostrarResultado() {
        emResultado = true;
        int total = questoesAtuais.size();
        int acertos = (int) java.util.stream.IntStream.range(0, total)
                .filter(i -> respostas[i] == correta(questoesAtuais.get(i))).count();

        JLabel placar = new JLabel("Você obteve " + acertos + (acertos == 1 ? " acerto" : " acertos") + " de " + total, SwingConstants.CENTER);
        placar.setOpaque(true);
        placar.setBackground(acertos * 100 > 60 * total ? ACERTO : DESEMPENHO_BAIXO);
        placar.setForeground(Color.WHITE);
        placar.setFont(fonte(Font.PLAIN, 20));
        placar.setPreferredSize(new Dimension(0, 50));

        barraQuestao.setText("Resultado");
        botaoAnterior.setVisible(false);
        botaoAbandonar.setVisible(false);
        botaoPrincipal.setText(duasLinhas("Voltar"));
        botaoPrincipal.setBackground(Cores.ROSA_CLARO);
        montarConteudo(placar, null);
    }

    private void atualizarBotoes() {
        botaoAnterior.setText(duasLinhas("Questão anterior"));
        botaoAnterior.setBackground(atual > 0 ? Cores.ROSA_CLARO : ROXO_ESCURO);
        if (!confirmadas[atual]) {
            botaoPrincipal.setText(duasLinhas("Selecionar alternativa"));
            botaoPrincipal.setBackground(respostas[atual] >= 0 ? Cores.ROSA_CLARO : ROXO_ESCURO);
        } else {
            botaoPrincipal.setText(duasLinhas(atual < questoesAtuais.size() - 1 ? "Próxima questão" : "Finalizar questão"));
            botaoPrincipal.setBackground(Cores.ROSA_CLARO);
        }
    }

    private static int correta(String[] q) { return Integer.parseInt(q[CORRETA]); }

    private static Font fonte(int estilo, int tamanho) { return new Font("Arial", estilo, tamanho); }

    private static JPanel painel(LayoutManager layout) {
        JPanel painel = new JPanel(layout);
        painel.setBackground(Color.WHITE);
        return painel;
    }

    private static String duasLinhas(String texto) {
        return "<html><center>" + texto.replace(" ", "<br>") + "</center></html>";
    }

    private static String escapar(String texto) {
        return texto.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}