package util;

/**
 * Esta classe contém informações sobre um comando emitido pelo usuário.
 * Um comando atualmente consiste em duas strings: uma palavra de comando e uma segunda
 * palavra (por exemplo, se o comando for "take map", então as duas strings
 * obviamente são "take" e "map").
 */

public class Command {
    private final String commandWord;
    private final String secondWord;

    public Command(String firstWord, String secondWord) {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public boolean isUnknown() {
        return (commandWord == null);
    }

    public boolean hasSecondWord() {
        return (secondWord != null);
    }
}
