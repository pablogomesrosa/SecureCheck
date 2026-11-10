import javax.swing.*;
import java.awt.*;

public class TelaQuiz extends JPanel {

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

        JLabel tema= new JLabel("Tema: ");
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

        JButton iniciar= new JButton("Iniciar Quiz");
        iniciar.setFont(new Font("Arial", Font.BOLD, 20));
        iniciar.setBackground(Cores.ROSA_CLARO);
        iniciar.setForeground(Color.WHITE);
        iniciar.setPreferredSize(new Dimension(300, 100));
        iniciar.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel centralizar= new JPanel(new FlowLayout(FlowLayout.CENTER));
        centralizar.setBackground(Color.WHITE);
        centralizar.add(painelOpcoes);
        centralizar.add(iniciar);
        add(centralizar, BorderLayout.CENTER);
    }
}