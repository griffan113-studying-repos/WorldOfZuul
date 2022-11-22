import game.Item;
import game.Player;
import game.Room;
import generators.RoomGenerator;
import util.Command;
import util.Parser;

/**
 * Essa classe principal cria e inicializa todas as outras,
 * ela cria todas as salas, inicia o parser (analisador) e inicia o jogo.
 * Ela também avalia e executa os comandos que o analisador retorna.
 */

public class Game {
    private final Parser parser;

    private Player player;

    private boolean finished;

    public Game() {
        player = new Player();
        createRooms();
        parser = new Parser();
        finished = false;
    }

    private void createRooms() {
        Room firstRoom = RoomGenerator.execute();

        player.walk(firstRoom);
    }

    public void play() {
        printWelcome();

        while (!finished) {
            Command command = parser.getCommand();
            processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, awesome adventure game");
        System.out.println("with the scenario based on Terraria!");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        player.printInfo();
    }

    private void processCommand(Command command) {
        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return;
        }

        String commandWord = command.getCommandWord();
        switch (commandWord) {
            case "help" -> printHelp();
            case "go" -> goRoom(command);
            case "quit" -> finished = quit(command);
            case "look" -> player.printInfo();
            case "back" -> goBack(command);
            case "inv" -> player.showInventory();
            case "pick" -> pickItem(command);
            case "drop" -> dropItem(command);
            case "show" -> showItem(command);
        }
    }

    private void printHelp() {
        System.out.println("You wander over a undiscovered land,");
        System.out.println("find the treasure and try not die!");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = null;
        if (direction.equals("north")) {
            nextRoom = player.getCurrentRoom().getExit("north");
        }
        if (direction.equals("east")) {
            nextRoom = player.getCurrentRoom().getExit("east");
        }
        if (direction.equals("south")) {
            nextRoom = player.getCurrentRoom().getExit("south");
        }
        if (direction.equals("west")) {
            nextRoom = player.getCurrentRoom().getExit("west");
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            if (nextRoom.hasTrap()) {
                System.out.println("(X) You just walked into a death trap");
                finished = true;

                return;
            }

            if (nextRoom.hasTreasure()) {
                System.out.println("(V) You just walked into a room with the treasure. You won!");
                finished = true;

                return;
            }

            player.walk(nextRoom);
            player.printInfo();
        }
    }

    public void pickItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Pick what?");
            return;
        }

        player.pick(command.getSecondWord());
    }

    public void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }

        player.drop(command.getSecondWord());
    }

    public void showItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Show what?");
            return;
        }

        player.show(command.getSecondWord());
    }

    private void goBack(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Back what?");
            return;
        }

        player.walkBackward();
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}
