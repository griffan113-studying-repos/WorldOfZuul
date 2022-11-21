package util;

/**
 * Essa classe contém todos os comandos conhecidos no jogo,
 * ela é usada para reconhecer comandos conforme eles são digitados
 */

public class CommandWords {
    private static final String[] validCommands = {
            "go", "back", "quit", "help", "look", "inv", "pick", "drop", "show"
    };

    public boolean isCommand(String payload) {
        for (String validCommand : validCommands) {
            if (validCommand.equals(payload))
                return true;
        }

        return false;
    }

    public void showAll() {
        for (String command : validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
