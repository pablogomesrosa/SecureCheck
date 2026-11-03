import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URI;

public class TelaMaterial extends JPanel {

    public TelaMaterial(String tituloTexto, String conteudo, String urlVideo, String urlAudiobook, Navegador navegador) {
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

        JButton voltar = criarBotaoRodape("Voltar", 28, 58);
        voltar.addActionListener(_ -> navegador.irPara(Navegador.ESTUDOS));

        JButton video = criarBotaoRodape("Video", 24, 52);
        video.addActionListener(_ -> abrirLink(urlVideo));

        JButton audiobook = criarBotaoRodape("Audiobook", 24, 52);
        audiobook.addActionListener(_ -> abrirLink(urlAudiobook));

        JPanel linhaMidia = new JPanel(new GridLayout(1, 2, 10, 0));
        linhaMidia.setBackground(Color.WHITE);
        linhaMidia.add(video);
        linhaMidia.add(audiobook);

        JPanel rodape = new JPanel(new GridLayout(2, 1, 0, 10));
        rodape.setBackground(Color.WHITE);
        rodape.setBorder(new EmptyBorder(12, 0, 18, 0));
        rodape.add(voltar);
        rodape.add(linhaMidia);
        add(rodape, BorderLayout.SOUTH);
    }

    private void abrirLink(String url) {
        if (url == null || url.isBlank()) {
            JOptionPane.showMessageDialog(this,
                    "Este conteúdo ainda não está disponível.",
                    "Em breve", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            if (!Desktop.isDesktopSupported()
                    || !Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                throw new UnsupportedOperationException("Navegador não suportado");
            }

            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Não foi possível abrir o link no navegador.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JButton criarBotaoRodape(String texto, int tamanhoFonte, int altura) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.PLAIN, tamanhoFonte));
        botao.setForeground(Color.WHITE);
        botao.setBackground(new Color(124, 20, 92));
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);
        botao.setPreferredSize(new Dimension(0, altura));
        return botao;
    }
}