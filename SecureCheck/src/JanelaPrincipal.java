import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame implements Navegador {

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
        areaTelas.add(new TelaEstudos(), ESTUDOS);
        areaTelas.add(new TelaQuiz(), QUIZ);
        areaTelas.add(new TelaAjustes(), AJUSTES);

        add(areaTelas, BorderLayout.CENTER);

// Primeiro cria a barra e adiciona na janela
        barraNavegacao = new BarraNavegacao(this);
        add(barraNavegacao, BorderLayout.SOUTH);

// Só depois usa a barra
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
    public void irPara(String tela) {
        cardLayout.show(areaTelas, tela);
        barraNavegacao.destacarBotao(tela);

    }
}