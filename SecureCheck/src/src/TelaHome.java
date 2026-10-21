import javax.swing.*;
import java.awt.*;

public class TelaHome extends JPanel {

    public TelaHome(Navegador navegador) {
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JLabel titulo = new JLabel("SecureCheck");
        titulo.setFont(new Font("Arial", Font.BOLD, 48));
        titulo.setForeground(Cores.ROSA);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel(
                "<html><div style='text-align:center; width:280px'>"
                        + "Explore os materiais para aprender ou divirta-se testando seus conhecimentos nos quizzes!"
                        + "</div></html>");
        subtitulo.setFont(new Font("Arial", Font.BOLD, 20));
        subtitulo.setForeground(Cores.ROSA);
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitulo.setMaximumSize(subtitulo.getPreferredSize());

        JButton btnMateriais = botaoGrande("Materiais");
        btnMateriais.addActionListener(e -> navegador.irPara(Navegador.ESTUDOS));

        JButton btnQuiz = botaoGrande("Quiz");
        btnQuiz.addActionListener(e -> navegador.irPara(Navegador.QUIZ));

        add(titulo);
        add(subtitulo);
        add(Box.createVerticalStrut(50));
        add(Box.createVerticalStrut(70));
        add(btnMateriais);
        add(Box.createVerticalStrut(30));
        add(btnQuiz);
    }

    public JButton botaoGrande(String texto) {
        JButton botao = Cores.criarBotao(texto, Cores.ROSA, 24);
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
        Dimension tamanho = new Dimension(300, 100);
        botao.setPreferredSize(tamanho);
        botao.setMaximumSize(tamanho);
        return botao;
    }
}