import javax.swing.*;
import java.awt.*;

public class Cores {

    public static final Color ROXO = new Color(72, 32, 128);
    public static final Color ROSA = new Color(219, 39, 119);

    public Cores() {
    }

    public static JButton criarBotao(String texto, Color fundo, int tamanhoFonte) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
        botao.setBackground(fundo);
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setOpaque(true);
        botao.setBorderPainted(false);
        return botao;
    }
}