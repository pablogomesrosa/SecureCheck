import javax.swing.*;
import java.awt.*;

public class BarraNavegacao extends JPanel {

    public BarraNavegacao(Navegador navegador) {
        setLayout(new GridLayout(1, 4, 5, 0));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        setPreferredSize(new Dimension(0, 80));

        adicionarBotao(Navegador.HOME, navegador);
        adicionarBotao(Navegador.ESTUDOS, navegador);
        adicionarBotao(Navegador.QUIZ, navegador);
        adicionarBotao(Navegador.AJUSTES, navegador);
    }

    private void adicionarBotao(String nome, Navegador navegador) {
        JButton botao = Cores.criarBotao(nome, Cores.ROXO, 11);
        botao.addActionListener(e -> navegador.irPara(nome));
        add(botao);
    }
}