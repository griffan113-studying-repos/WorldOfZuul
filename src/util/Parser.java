package util;

import java.util.Scanner;

/**
 * O util.Parser (analisador) é um conjunto de comandos conhecidos.
 * Ele verifica a entrada do usuário em relação os comandos conhecidos
 * e se a entrada não for um dos comandos conhecidos, ele retorna uma mensagem de comando desconhecido.
 */
public class Parser {
    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
                if (tokenizer.hasNext()) {
                    word2 = word2.concat(" ").concat(tokenizer.next());
                }
            }
        }

        if (commands.isCommand(word1)) {
            return new Command(word1, word2);
        } else {
            return new Command(null, word2);
        }
    }

    public void showCommands() {
        commands.showAll();
    }
}
