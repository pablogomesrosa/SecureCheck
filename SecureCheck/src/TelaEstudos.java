import javax.swing.*;
import java.awt.*;

public class TelaEstudos extends JPanel {

    public TelaEstudos(Navegador navegador) {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        JPanel cabecalho = new JPanel();
        cabecalho.setBackground(Color.WHITE);
        cabecalho.setLayout(new BoxLayout(cabecalho, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Estudos");
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(new Color(219, 39, 119));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel descricao = new JLabel(
            "<html><center>Explore os materiais no seu<br>" +
            "ritmo, com opções de vídeos e<br>" +
            "audiobooks!</center></html>"
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

        JPanel listaMateriais = new JPanel();
        listaMateriais.setLayout(
            new BoxLayout(listaMateriais, BoxLayout.Y_AXIS)
        );
        listaMateriais.setBackground(Color.WHITE);
        listaMateriais.setBorder(
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        );

        JButton material1 = criarBotaoMaterial(
            "<html><center>Como não cair em<br>" +
            "armadilhas digitais</center></html>"
        );

        JButton material2 = criarBotaoMaterial(
            "<html><center>Como proteger sua<br>" +
            "vida online</center></html>"
        );

        material1.addActionListener(e -> {
            navegador.irPara(Navegador.MATERIAL_1);
        });

        material2.addActionListener(e -> {
            navegador.irPara(Navegador.MATERIAL_2);
        });

        JButton material3 = criarBotaoMaterial(
                "<html><center>Protegendo sua família <br>" +
                        "e seus dados</center></html>"
        );

        JButton material4 = criarBotaoMaterial(
                "<html><center>A importância de atualizar<br>" +
                        "suas chaves de segurança</center></html>"
        );

        material3.addActionListener(e -> {
            navegador.irPara(Navegador.MATERIAL_3);
        });

        material4.addActionListener(e -> {
            navegador.irPara(Navegador.MATERIAL_4);
        });

        listaMateriais.add(material1);
        listaMateriais.add(Box.createVerticalStrut(12));
        listaMateriais.add(material2);
        listaMateriais.add(Box.createVerticalStrut(12));
        listaMateriais.add(material3);
        listaMateriais.add(Box.createVerticalStrut(12));
        listaMateriais.add(material4);

        add(listaMateriais, BorderLayout.CENTER);
    }

    private JButton criarBotaoMaterial(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.PLAIN, 22));
        botao.setForeground(Color.WHITE);
        botao.setBackground(new Color(162, 32, 103));
        botao.setPreferredSize(new Dimension(420, 76));
        botao.setMaximumSize(new Dimension(420, 76));
        botao.setMinimumSize(new Dimension(420, 76));
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);
        return botao;
    }
}
