import javax.swing.*;
import java.awt.*;

public class TelaSplash extends JPanel {

    public TelaSplash() {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);

        JLabel logo = new JLabel("SecureCheck");
        logo.setFont(new Font("Arial", Font.BOLD, 48));
        logo.setForeground(new Color(219, 39, 119));
        add(logo);
    }
}