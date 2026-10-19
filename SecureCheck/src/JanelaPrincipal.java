import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {

    private CardLayout cartas = new CardLayout();
    private JPanel container = new JPanel(cartas);

    public JanelaPrincipal() {
        super("SecureCheck");
        setSize(500,800 );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        container.add(new TelaSplash(), "splash");
        container.add(new TelaHome(), "home");
        add(container);

        cartas.show(container, "splash");

        javax.swing.Timer timer = new javax.swing.Timer(3000, e -> {
            cartas.show(container, "home");
        });
        timer.setRepeats(false);
        timer.start();
    }
}