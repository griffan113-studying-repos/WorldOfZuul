package generators;


import game.Item;
import game.Room;

public class RoomGenerator {
    private static Room execute() {
        Room outside, theater, pub, lab, office, dungeon;
        Item book, pistol, magical_staff, magical_key, bazooka;

        book = new Item(1, "Book", 1);
        pistol = new Item(2, "Pistol", 1);
        magical_staff = new Item(3, "Magical Staff", 2);
        magical_key = new Item(4, "Magical Key", 2);
        bazooka = new Item(4, "Bazooka", 5);

        pistol.setRequiredItem(magical_staff);

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        dungeon = new Room("in the dungeon");

        // initialise room exits
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("east", theater);
        outside.setItem(magical_staff);
        outside.setItem(bazooka);

        theater.setExit("west", outside);
        theater.setItem(book);
        theater.setRequiredItem(magical_staff);

        lab.setExit("north", outside);
        lab.setExit("east", office);
        lab.setExit("west", dungeon);
        lab.setItem(magical_key);
        lab.setHasTrap(true);

        pub.setExit("east", outside);
        pub.setItem(pistol);

        office.setExit("west", dungeon);

        dungeon.setExit("west", outside);
        dungeon.setHasTreasure(true);


    }
}
