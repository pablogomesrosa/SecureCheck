# SecureCheck - Protótipo funcional em Java Swing

Este projeto foi criado para estudantes iniciantes de Ciência da Computação (UC Algoritmos e Programação, 2º semestre). Ele reproduz as telas do Penpot em Java, usando apenas componentes simples do Swing e sem bibliotecas externas.

## Como abrir no IntelliJ IDEA

1. Extraia o arquivo `SecureCheckSwing.zip` em uma pasta do computador.
2. Abra o IntelliJ IDEA, escolha **Open** e selecione a pasta `SecureCheckSwing`.
3. Escolha um **JDK 17 ou superior** em **File > Project Structure > Project SDK** (se o IntelliJ pedir).
4. Abra `src/Main.java`. Se o IntelliJ não reconhecer o código, clique com o botão direito em `src` e escolha **Mark Directory as > Sources Root**.
5. Clique no triângulo verde ao lado de `public static void main` e escolha **Run 'Main.main()'**.

Você também pode executar o arquivo `SecureCheck.jar`, se tiver Java instalado. No Windows, também existe o atalho `Executar no Windows.bat`.

## O que funciona nesta versão

- **Abertura:** exibe o nome SecureCheck por um instante.
- **Home:** botões Materiais e Quiz levam às telas certas.
- **Estudos:** abre os cinco materiais; cada material tem leitura com rolagem, botão Voltar e botões de buscar vídeo e áudio.
- **Quiz:**
  - permite escolher **5 temas**;
  - permite escolher **de 1 a 10 questões**;
  - carrega perguntas de um banco de questões por tema;
  - permite marcar e desmarcar alternativas;
  - confirma a resposta, mostra correção e explicação, avança, volta, finaliza ou abandona com confirmação.
- **Resultado:** calcula os acertos reais e muda a cor do placar:
  - **verde** quando o usuário acerta **mais de 60%**;
  - **laranja** quando o usuário acerta **60% ou menos**.
- **Últimos quizzes:** resultados concluídos ficam salvos no arquivo `securecheck_historico.txt` na pasta pessoal do usuário. A tela mostra apenas o tema e o desempenho, sem data e hora.
- **Ajustes:**
  - **modo escuro** muda o tema da interface;
  - **modo fácil** troca os textos técnicos por uma linguagem mais simples;
  - **texto maior** aumenta as fontes;
  - **alto contraste** altera as cores para acessibilidade.
- **Menu inferior:** HOME, ESTUDOS, QUIZ e AJUSTES realmente navegam entre as telas.

## Ajustes pedidos e aplicados

Esta versão foi atualizada para atender aos novos pedidos do protótipo:

- o botão **Buscar áudio** ficou com a mesma cor rosa forte do botão **Buscar vídeo**;
- a tela de quiz agora tem **5 temas**:
  - Geral
  - Golpes digitais
  - Senhas e contas
  - Privacidade online
  - Navegação segura
- o campo **Número de questões** agora vai de **1 a 10**;
- o **modo fácil** passou a simplificar os textos dos materiais, perguntas e explicações;
- o botão **Dica** foi removido da tela de quiz em andamento;
- o botão **Questão anterior** fica em **roxo escuro e desativado** quando não existe questão anterior; quando existe, ele fica em **rosa forte** como os outros;
- as alternativas foram alinhadas em duas partes, com **letra** e **texto** lado a lado, como no PDF;
- todas as alternativas aparecem em **roxo escuro**;
- ao clicar, a alternativa escolhida fica em **rosa forte**;
- ao clicar novamente na mesma alternativa, ela é **desmarcada**;
- na tela de resultado, a cor do retângulo depende do desempenho;
- em **Últimos quizzes**, cada resultado também usa a regra visual dos **60%**: verde acima de 60% e laranja em 60% ou menos.

## O que veio do Penpot e o que foi completado

- O PDF tem **14 páginas**, mas várias delas são variações da mesma tela de quiz, correção e resultado.
- O protótipo mostra **duas perguntas completas**. Para permitir quiz por tema e escolha de até 10 questões, foi criado um **banco novo de perguntas didáticas**, mantendo o assunto do aplicativo.
- O Penpot mostra os **títulos de cinco materiais**, mas o texto de leitura completo aparece só parcialmente no primeiro. Por isso, os demais materiais foram completados com **textos de apoio**.
- O arquivo recebido não traz URLs reais de vídeos e audiobooks. Por isso, os botões **Buscar vídeo** e **Buscar áudio** abrem uma pesquisa no YouTube. Depois, o grupo pode substituir pelas URLs reais.
- A interface usa **350 x 720 pixels**, posicionamento com `setBounds()` e componentes básicos do Swing, para ficar compatível com o nível de estudo da turma.

## Roteiro sugerido para estudar o código

Procurem estes métodos em `src/Main.java`:

1. `main()` - inicia o programa.
2. `mostrarHome()`, `mostrarEstudos()`, `mostrarQuiz()` e `mostrarQuestao()` - montam as telas.
3. `botao()`, `texto()`, `faixa()` e `criarMenu()` - criam componentes reutilizáveis.
4. `iniciarBancoQuestoes()` e `adicionarQuestao()` - montam o banco de perguntas.
5. `iniciarQuiz()`, `confirmarOuAvancar()` e `contarAcertos()` - controlam a lógica do quiz.
6. `salvarResultado()` e `carregarHistorico()` - gravam e leem dados simples em arquivo.
7. `mostrarAjustes()` - controla as opções de acessibilidade com variáveis booleanas.

## Ideias para continuar o projeto

- Trocar os textos demonstrativos pelos materiais finais do grupo.
- Adicionar mais perguntas em cada tema.
- Criar mais temas ou carregar perguntas de um arquivo externo.
- Trocar as pesquisas do YouTube por links reais de vídeos e audiobooks.
- Separar as classes (`Questao`, `TelaQuiz`, `Historico`) em arquivos diferentes quando vocês estudarem orientação a objetos com mais profundidade.

## Arquivos principais

- `src/Main.java` - código-fonte completo.
- `SecureCheck.jar` - versão já compilada para executar com Java.
- `Executar no Windows.bat` - atalho opcional para executar o JAR.
- `compilado/` - classes compiladas.

Não é preciso banco de dados, API, Maven ou Gradle.

## Revisão visual para ficar mais parecido com o Penpot

As dimensões das páginas do Penpot foram medidas no PDF, e as telas Swing foram
ajustadas para reproduzi-las na janela fixa de **350 x 720 pixels**.

- **Home:** texto introdutório mais alto, botões com a largura, altura e espaçamento
  proporcionalmente equivalentes ao desenho original.
- **Estudos:** os cinco cartões têm **310 x 70 pixels** e foram colocados nas
  alturas proporcionais do PDF, mantendo o espaço entre eles.
- **Material:** título maior, bloco de leitura abaixo dele, botão Voltar próximo
  à posição do Penpot. Os dois botões extras de áudio e vídeo ficam entre a
  leitura e o Voltar, pois são funcionalidades pedidas depois do protótipo.
- **Quiz:** campos Tema e Número de questões reposicionados, botões mais baixos
  e proporcionais. Temas compridos aparecem em duas linhas no seletor.
- **Questões:** bloco do enunciado, quatro faixas de respostas e botões inferiores
  reposicionados. Alternativas longas quebram em até duas linhas, sem cortar texto.
- **Resultado e histórico:** blocos e botão Voltar alinhados ao PDF.
- **Ajustes:** blocos com as alturas e intervalos da página original.

O código usa `setBounds(x, y, largura, altura)` para deixar claro para o grupo
como cada posição do Penpot se transforma em código. O resultado é uma adaptação
aproximada do layout, pois fontes e componentes do Swing podem variar conforme
o sistema operacional. Nenhuma funcionalidade da versão anterior foi removida.
