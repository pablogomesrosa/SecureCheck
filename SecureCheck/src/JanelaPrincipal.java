import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame implements Navegador {

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel areaTelas = new JPanel(cardLayout);

    public JanelaPrincipal() {
        setTitle("SecureCheck");
        setSize(485, 794);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        areaTelas.add(new TelaHome(this), HOME);
        areaTelas.add(new TelaEstudos(), ESTUDOS);
        areaTelas.add(new TelaQuiz(), QUIZ);
        areaTelas.add(new TelaAjustes(), AJUSTES);

        add(areaTelas, BorderLayout.CENTER);
        add(new BarraNavegacao(this), BorderLayout.SOUTH);
    }
    public void irPara(String tela) {
        cardLayout.show(areaTelas, tela);
    }
}