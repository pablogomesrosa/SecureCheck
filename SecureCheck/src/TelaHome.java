import javax.swing.*;
import java.awt.*;

public class TelaHome extends JPanel {

    public TelaHome() {
        setLayout(null);
        setBackground(Color.WHITE);
        JLabel logo= new JLabel("SecureCheck");
        logo.setFont(new Font("Arial", Font.BOLD, 48));
        logo.setForeground(new Color(219, 39, 119));
        logo.setBounds(100, 5, 400, 50);
        add(logo);

        JLabel resumo= new JLabel("<html><center>Explore os materiais para aprender ou divirta-se" +
                " testando seus conhecimentos nos quizzes!</center></html>");
        resumo.setFont(new Font("Arial", Font.BOLD, 20));
        resumo.setForeground(new Color(140, 28, 96));
        resumo.setBounds(100, 50, 300, 300);
        add(resumo);

        JButton btmateriais = new JButton("Materiais");
        btmateriais.setFont(new Font("Arial", Font.BOLD, 25));
        btmateriais.setForeground(Color.white);
        btmateriais.setBackground(new Color(219, 39, 119));
        btmateriais.setBounds(100, 300, 295, 85);
        add(btmateriais);

        JButton btquiz= new JButton("Quiz");
        btquiz.setFont(new Font("Arial", Font.BOLD, 25));
        btquiz.setForeground(Color.white);
        btquiz.setBackground(new Color(219, 39, 119));
        btquiz.setBounds(100, 430, 295, 85);
        add(btquiz);
    }
}
