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
        resumo.setForeground(new Color(219, 39, 119));
        resumo.setBounds(100, 50, 300, 300);
        add(resumo);

        JButton materiais= new JButton("Materiais");
        materiais.setFont(new Font("Arial", Font.BOLD, 25));
        materiais.setForeground(Color.white);
        materiais.setBackground(new Color(219, 39, 119));
        materiais.setBounds(100, 300, 300, 100);
        add(materiais);

        JButton quiz= new JButton("Quiz");
        quiz.setFont(new Font("Arial", Font.BOLD, 25));
        quiz.setForeground(Color.white);
        quiz.setBackground(new Color(219, 39, 119));
        quiz.setBounds(100, 430, 300, 100);
        add(quiz);
    }
}