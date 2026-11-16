import javax.swing.*;
import java.awt.*;
import java.awt.event.ContainerEvent;

public class TemaEscuro {

    private static final Color FUNDO_ESCURO = new Color(30, 30, 30);
    private static boolean escuroAtivo = false;
    private static boolean ouvinteRegistrado = false;

    public static void alternar(boolean ativar) {
        escuroAtivo = ativar;
        registrarOuvinteAutomatico();
        aplicarEmTodasJanelas();
    }

    private static void registrarOuvinteAutomatico() {
        if (ouvinteRegistrado) return;
        ouvinteRegistrado = true;

        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (escuroAtivo && event instanceof ContainerEvent) {
                ContainerEvent ce = (ContainerEvent) event;
                if (ce.getID() == ContainerEvent.COMPONENT_ADDED && ce.getChild() instanceof Container) {
                    SwingUtilities.invokeLater(() -> {
                        pintarComponentes((Container) ce.getChild(), true);
                        ce.getChild().repaint();
                    });
                }
            }
        }, AWTEvent.CONTAINER_EVENT_MASK);
    }

    private static void aplicarEmTodasJanelas() {
        Color novaCor = escuroAtivo ? FUNDO_ESCURO : Color.WHITE;

        for (Window janela : Window.getWindows()) {
            janela.setBackground(novaCor);
            if (janela instanceof JFrame) {
                ((JFrame) janela).getContentPane().setBackground(novaCor);
            }
            pintarComponentes(janela, escuroAtivo);
            janela.repaint();
        }
    }

    private static void pintarComponentes(Container container, boolean ativar) {
        Color novaCor = ativar ? FUNDO_ESCURO : Color.WHITE;

        if (!(container instanceof JComboBox) && !(container instanceof JLabel)) {
            Color bg = container.getBackground();
            if (ativar && ehCorClara(bg)) {
                container.setBackground(novaCor);
            } else if (!ativar && FUNDO_ESCURO.equals(bg)) {
                container.setBackground(novaCor);
            }
        }

        for (Component c : container.getComponents()) {
            if (!(c instanceof JComboBox) && !(c instanceof JLabel)) {
                Color bg = c.getBackground();
                if (ativar && ehCorClara(bg)) {
                    c.setBackground(novaCor);
                    if (ehCorEscura(c.getForeground())) {
                        c.setForeground(Color.WHITE);
                    }
                } else if (!ativar && FUNDO_ESCURO.equals(bg)) {
                    c.setBackground(novaCor);
                    if (Color.WHITE.equals(c.getForeground())) {
                        c.setForeground(Color.BLACK);
                    }
                }
            }

            if (c instanceof JLabel) {
                Color corTextoAlvo = ativar ? Color.BLACK : Color.WHITE;
                if (corTextoAlvo.equals(c.getForeground()) && !c.isOpaque()) {
                    c.setForeground(ativar ? Color.WHITE : Color.BLACK);
                }
            }

            if (c instanceof Container && !(c instanceof JComboBox)) {
                pintarComponentes((Container) c, ativar);
            }
        }
    }

    private static boolean ehCorClara(Color c) {
        if (c == null) return false;
        return Color.WHITE.equals(c) || (c.getRed() > 220 && c.getGreen() > 220 && c.getBlue() > 220);
    }

    private static boolean ehCorEscura(Color c) {
        if (c == null) return false;
        return Color.BLACK.equals(c) || (c.getRed() < 50 && c.getGreen() < 50 && c.getBlue() < 50);
    }
}