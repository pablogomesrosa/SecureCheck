import javax.swing.*;
import java.awt.*;

public class Cores {

    public static final Color ROXO = new Color(72, 32, 128);
    public static final Color ROSA = new Color(124, 20, 92);
    public static final Color ROSA_CLARO = new Color(221, 118, 170);

    private Cores() {
    }

    public static JButton criarBotao(String texto, Color white, int tamanhoFonte) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial" , Font.BOLD, 15));
        botao.setBackground(Color.white);
        botao.setForeground(Cores.ROSA);
        botao.setFocusPainted(false);
        botao.setOpaque(true);
        botao.setBorderPainted(false);
        return botao;
    }
}