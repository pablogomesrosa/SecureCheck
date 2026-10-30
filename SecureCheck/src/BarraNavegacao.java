import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BarraNavegacao extends JPanel {

    private final Map<String, JButton> botoesInferiores = new HashMap<>();

    public BarraNavegacao(Navegador navegador) {
        setLayout(new GridLayout(1, 4, 5, 0));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        setPreferredSize(new Dimension(0, 80));

        criarBotao(Navegador.HOME, navegador);
        criarBotao(Navegador.ESTUDOS, navegador);
        criarBotao(Navegador.QUIZ, navegador);
        criarBotao(Navegador.AJUSTES, navegador);

        destacarBotao(Navegador.HOME);
    }

    private void criarBotao(String nomeDaTela, Navegador navegador) {
        JButton BotaoSelecionado = Cores.criarBotao(nomeDaTela, Cores.ROXO, 20);

        BotaoSelecionado.addActionListener(e -> {
            navegador.irPara(nomeDaTela);
        });

        botoesInferiores.put(nomeDaTela, BotaoSelecionado);
        add(BotaoSelecionado);
    }

    public void destacarBotao(String telaAtual) {
        botoesInferiores.forEach((nomeDaTela, BotaoSelecionado) -> {
            if (nomeDaTela.equals(telaAtual)) {
                BotaoSelecionado.setForeground(Cores.ROSA_CLARO);
            } else {
                BotaoSelecionado.setForeground(Cores.ROSA);
            }
        });
    }
}