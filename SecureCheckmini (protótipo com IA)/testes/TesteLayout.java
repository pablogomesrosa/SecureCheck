import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

// Testes de navegação e das alterações de layout; sem JUnit.
public class TesteLayout {
    static void check(boolean valor, String descricao) {
        if (!valor) throw new AssertionError(descricao);
        System.out.println("OK: " + descricao);
    }

    static JButton botao(Main app, String trecho) {
        for (Component c : app.tela.getComponents()) {
            if (c instanceof JButton && ((JButton)c).getText().contains(trecho)) return (JButton)c;
        }
        throw new AssertionError("Nao encontrou botao: " + trecho);
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("user.home", "/mnt/data/SecureCheckSwing/testes/_usuario_teste_layout");
        new File(System.getProperty("user.home")).mkdirs();
        SwingUtilities.invokeAndWait(() -> {
            Main app = new Main();
            app.modoEscuro = false; app.modoFacil = false; app.textoMaior = true; app.altoContraste = false;
            app.mostrarHome();
            check(botao(app,"Materiais").getBounds().equals(new Rectangle(46,347,256,70)), "home posicao penpot");
            app.mostrarEstudos();
            check(botao(app,"Como não cair").getBounds().equals(new Rectangle(20,210,310,70)), "estudos posicao penpot");
            app.mostrarMaterial(0);
            check(botao(app,"Buscar vídeo").getBackground().equals(botao(app,"Buscar áudio").getBackground()), "cores iguais video/audio");
            app.mostrarQuiz();
            JComboBox<?> combo=null;
            for(Component c: app.tela.getComponents()) if(c instanceof JComboBox) {combo=(JComboBox<?>)c;break;}
            check(combo!=null && combo.getItemCount()==5, "cinco temas");
            for (String t:Main.TEMAS) {
                app.tema=t;
                app.quantidade=10;
                app.iniciarQuiz();
                check(app.questoesAtuais.size()==10 && app.pagina.equals("questao"), "10 perguntas tema "+t);
                check(!botao(app,"Questão").isEnabled(), "anterior bloqueado na primeira questao");
                for (int i=0;i<app.questoesAtuais.size();i++) {
                    app.respostas[i] = app.questoesAtuais.get(i).correta;
                    app.confirmadas[i] = true;
                }
                check(app.contarAcertos()==10, "pontuacao correta "+t);
                app.questaoAtual=1;
                app.mostrarQuestao();
                check(botao(app,"Questão").isEnabled() && botao(app,"Questão").getBackground().equals(Main.ROSA), "anterior ativo rosa");
                app.quizEmAndamento=false;
            }
            app.tema="Privacidade online";
            app.quantidade=1;
            app.iniciarQuiz();
            check(!app.questoesAtuais.get(0).getEnunciado(true).equals(app.questoesAtuais.get(0).getEnunciado(false)), "modo facil simplifica enunciado");
            app.respostas[0]=-1; app.mostrarQuestao();
            JPanel opcao=null;
            for(Component c : app.tela.getComponents()) if(c instanceof JPanel && c.getBounds().equals(new Rectangle(20,400,310,36))) opcao=(JPanel)c;
            check(opcao!=null, "alternativa alinhada penpot");
            Component letra = opcao.getComponent(0);
            letra.dispatchEvent(new MouseEvent(letra,MouseEvent.MOUSE_CLICKED,System.currentTimeMillis(),0,10,10,1,false));
            check(app.respostas[0]==0,"marcar alternativa");
            JPanel opcao2=null;
            for(Component c : app.tela.getComponents()) if(c instanceof JPanel && c.getBounds().equals(new Rectangle(20,400,310,36))) opcao2=(JPanel)c;
            Component letra2=opcao2.getComponent(0);
            letra2.dispatchEvent(new MouseEvent(letra2,MouseEvent.MOUSE_CLICKED,System.currentTimeMillis(),0,10,10,1,false));
            check(app.respostas[0]==-1,"desmarcar alternativa");
            check(app.corDesempenho(6,10).equals(Main.LARANJA_RESULTADO) && app.corDesempenho(7,10).equals(Main.VERDE_RESULTADO), "regra acima 60 por cento");
            app.quizEmAndamento=false;
            app.historico.clear(); app.historico.add("16/10/2026 16:12;Geral;7;10");
            app.mostrarHistorico();
            check(app.pagina.equals("historico") && botao(app,"Voltar").getBounds().y==557, "historico reposicionado");
            app.mostrarAjustes();
            check(botao(app,"").getBounds()!=null, "ajustes sem erro");
            app.dispose();
        });
    }
}
