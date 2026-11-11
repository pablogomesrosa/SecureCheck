import javax.swing.*;
import java.awt.*;

public class TelaAjustes extends JPanel {

    private static final Color FUNDO_NOME = new Color(122, 23, 90);
    private static final Color COR_DESLIGADO = new Color(74, 10, 58);
    private static final Color COR_LIGADO = new Color(200, 42, 124);

    public TelaAjustes() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        JLabel titulo = new JLabel("Ajustes");
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(COR_LIGADO);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
        add(titulo, BorderLayout.NORTH);
        JPanel lista = new JPanel();
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));
        lista.setBackground(Color.WHITE);
        lista.add(Box.createVerticalGlue());
        lista.add(criarLinha("Modo escuro", false));
        lista.add(Box.createVerticalStrut(25));
        lista.add(criarLinha("Modo fácil", true));
        lista.add(Box.createVerticalStrut(25));
        lista.add(criarLinha("Texto maior", true));
        lista.add(Box.createVerticalStrut(25));
        lista.add(criarLinha("<html><center>Modo de alto<br>contraste</center></html>", false));
        lista.add(Box.createVerticalGlue());
        add(lista, BorderLayout.CENTER);
    }

    private JPanel criarLinha(String nome, boolean comecaLigado) {
        JPanel linha = new JPanel(new BorderLayout());
        Dimension tamanho = new Dimension(430, 100);
        linha.setPreferredSize(tamanho);
        linha.setMaximumSize(tamanho);
        linha.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel rotulo = new JLabel(nome, SwingConstants.CENTER);
        rotulo.setFont(new Font("Arial", Font.PLAIN, 28));
        rotulo.setForeground(Color.WHITE);
        rotulo.setBackground(FUNDO_NOME);
        rotulo.setOpaque(true);
        linha.add(rotulo, BorderLayout.CENTER);
        JButton botao = new JButton();
        botao.setFont(new Font("Arial", Font.PLAIN, 20));
        botao.setForeground(Color.WHITE);
        botao.setPreferredSize(new Dimension(170, 100));
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);
        mudarEstado(botao, comecaLigado);

        botao.addActionListener(_ -> {
            boolean estaLigado = botao.getText().equals("Ligado");
            mudarEstado(botao, !estaLigado);
        });

        linha.add(botao, BorderLayout.EAST);
        return linha;
    }

    private void mudarEstado(JButton botao, boolean ligado) {
        if (ligado) {
            botao.setText("Ligado");
            botao.setBackground(COR_LIGADO);
        } else {
            botao.setText("Desligado");
            botao.setBackground(COR_DESLIGADO);
        }
    }
}