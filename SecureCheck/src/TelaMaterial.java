import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaMaterial extends JPanel {

    public TelaMaterial(String tituloTexto, String conteudo, Navegador navegador) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(0, 20, 0, 20));

        JLabel titulo = new JLabel(tituloTexto);
        titulo.setFont(new Font("Arial", Font.BOLD, 34));
        titulo.setForeground(new Color(219, 39, 119));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setVerticalAlignment(SwingConstants.CENTER);
        titulo.setPreferredSize(new Dimension(0, 190));
        titulo.setBorder(new EmptyBorder(18, 0, 12, 0));
        add(titulo, BorderLayout.NORTH);

        Color corCaixa = new Color(162, 32, 103);

        JTextArea texto = new JTextArea(conteudo);
        texto.setFont(new Font("Arial", Font.PLAIN, 18));
        texto.setForeground(Color.WHITE);
        texto.setBackground(corCaixa);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);
        texto.setEditable(false);
        texto.setFocusable(false);
        texto.setBorder(new EmptyBorder(12, 12, 12, 12));
        texto.setCaretPosition(0);

        JScrollPane rolagem = new JScrollPane(
                texto,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        rolagem.setBorder(null);
        rolagem.setBackground(corCaixa);
        rolagem.getViewport().setBackground(corCaixa);
        rolagem.getVerticalScrollBar().setUnitIncrement(16);

        JPanel caixaTexto = new JPanel(new BorderLayout());
        caixaTexto.setBackground(corCaixa);
        caixaTexto.add(rolagem, BorderLayout.CENTER);
        add(caixaTexto, BorderLayout.CENTER);

        JButton voltar = new JButton("Voltar");
        voltar.setFont(new Font("Arial", Font.PLAIN, 28));
        voltar.setForeground(Color.WHITE);
        voltar.setBackground(new Color(124, 20, 92));
        voltar.setFocusPainted(false);
        voltar.setBorderPainted(false);
        voltar.setOpaque(true);
        voltar.setPreferredSize(new Dimension(0, 58));
        voltar.addActionListener(e -> {
            navegador.irPara(Navegador.ESTUDOS);
        });

        JPanel rodape = new JPanel(new BorderLayout());
        rodape.setBackground(Color.WHITE);
        rodape.setBorder(new EmptyBorder(12, 0, 18, 0));
        rodape.add(voltar, BorderLayout.CENTER);
        add(rodape, BorderLayout.SOUTH);
    }
}
