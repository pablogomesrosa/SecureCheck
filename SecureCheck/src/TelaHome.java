import javax.swing.*;
import java.awt.*;

public class TelaHome extends JPanel {

    public TelaHome(Navegador navegador) {
        setLayout(new GridBagLayout());

        GridBagConstraints posicao = new GridBagConstraints();
        posicao.gridx = 0;
        posicao.weightx = 1;
        posicao.anchor = GridBagConstraints.CENTER;
        setBackground(Color.WHITE);
        JLabel logo= new JLabel("SecureCheck");
        logo.setFont(new Font("Arial", Font.BOLD, 48));
        logo.setForeground(new Color(219, 39, 119));
        posicao.gridy = 0;
        posicao.insets = new Insets(10, 0, 60, 0);
        add(logo, posicao);

        JLabel resumo= new JLabel("<html><center>Explore os materiais para aprender ou divirta-se" +
                " testando seus conhecimentos nos quizzes!</center></html>");
        resumo.setFont(new Font("Arial",Font.PLAIN, 20));
        resumo.setForeground(new Color(140, 28, 96));
        resumo.setPreferredSize(new Dimension(300, 130));
        resumo.setHorizontalAlignment(SwingConstants.CENTER);

        posicao.gridy = 1;
        posicao.insets = new Insets(0, 0, 40, 0);
        add(resumo, posicao);

        JButton btmateriais = new JButton("Materiais");
        btmateriais.setFont(new Font("Arial", Font.PLAIN, 40));
        btmateriais.setForeground(Color.white);
        btmateriais.setBackground(new Color(219, 39, 119));
        btmateriais.setPreferredSize(new Dimension(295, 85));
        posicao.gridy = 2;
        posicao.insets = new Insets(0, 0, 35, 0);
        add(btmateriais, posicao);
        btmateriais.addActionListener(e -> {
            navegador.irPara(Navegador.ESTUDOS);
        });

        JButton btquiz= new JButton("Quiz");
        btquiz.setFont(new Font("Arial",Font.PLAIN, 40));
        btquiz.setForeground(Color.white);
        btquiz.setBackground(new Color(219, 39, 119));
        btquiz.setPreferredSize(new Dimension(295, 85));
        posicao.gridy = 3;
        posicao.insets = new Insets(0, 0, 0, 0);
        add(btquiz, posicao);
        posicao.gridy = 4;
        posicao.weighty = 1;
        add(Box.createVerticalGlue(), posicao);
        btquiz.addActionListener(e -> {
            navegador.irPara(Navegador.QUIZ);
        });
    }
}
