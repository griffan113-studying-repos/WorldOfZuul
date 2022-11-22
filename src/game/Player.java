package game;

import game.Item;
import game.Room;

import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A classe game.Player contém todas as ações possíveis do jogador
 */
public class Player {
    private Room currentRoom;

    private HashMap<Integer, Item> inventory;

    private Stack<Room> walkedRooms;

    private int itemsTotalWeight;

    private final int maxWeight;

    public Player() {
        inventory = new HashMap<>();
        walkedRooms = new Stack<>();
        maxWeight = 10;
    }

    public void pick(String itemName) {
        Item itemToPick = null;

        for (Item roomItem : currentRoom.getItems().values()) {
            if (roomItem.getName().equalsIgnoreCase(itemName)) itemToPick = roomItem;
        }

        try {
            int itemId = itemToPick.getId(); // This may produce null exception, this way we know that the item does not exist

            Item requiredItem = itemToPick.getRequiredItem();

            if (requiredItem != null) {
                if (!has(requiredItem)) {
                    System.out.println("(X) You don't have the required item: " + requiredItem.getName());

                    return;
                }
            }

            if (itemsTotalWeight + itemToPick.getWeight() >= maxWeight) {
                System.out.println("This item weights " + itemToPick.getWeight() + ", as you already weights a total of " + itemsTotalWeight + " it's too heavy for you");
                return;
            }

            inventory.put(itemId, itemToPick);
            itemsTotalWeight += itemToPick.getWeight();
            currentRoom.removeItem(itemToPick);
            System.out.println("You've picked up " + itemToPick.getName() + "!");
            showSimpleInventory();
        } catch (Exception ignored) {
            System.out.println("Could not find this item...");
        }
    }

    public void drop(String itemName) {
        Item itemToDrop = null;

        for (Item invItem : inventory.values()) {
            if (invItem.getName().equalsIgnoreCase(itemName)) itemToDrop = invItem;
        }

        try {
            int itemId = itemToDrop.getId(); // This may produce null exception, this way we know that the item does not exist

            inventory.remove(itemId, itemToDrop);
            currentRoom.setItem(itemToDrop);
            System.out.println("You've dropped " + itemToDrop.getName() + "!");
            showSimpleInventory();
        } catch (Exception ignored) {
            System.out.println("You don't have this item...");
        }
    }

    public void walk(Room room) {
        Item roomRequiredItem = room.getRequiredItem();

        if (roomRequiredItem != null) {
            if (!has(roomRequiredItem)) {
                System.out.println("(X) You don't have the required item: " + roomRequiredItem.getName());

                return;
            }
        }

        walkedRooms.push(room);

        currentRoom = room;
    }

    public void walkBackward() {
        if (walkedRooms.empty() || walkedRooms.size() == 1) {
            System.out.println("You don't have rooms to come back!");
            return;
        }

        currentRoom = walkedRooms.get(walkedRooms.size() - 2); // "-2" because the get() method starts in zero
        walkedRooms.pop();
        System.out.println(currentRoom.getLongDescription());
    }

    public boolean has(Item item) {
        AtomicBoolean has = new AtomicBoolean(false);

        inventory.forEach((key, value) -> {
            if (value.getName().equalsIgnoreCase(item.getName())) has.set(true);
        });

        return has.get();
    }

    public void show(String itemName) {
        Item itemToShow = null;

        for (Item invItem : inventory.values()) {
            if (invItem.getName().equalsIgnoreCase(itemName)) itemToShow = invItem;
        }

        try {
            int itemId = itemToShow.getId(); // This may produce null exception, this way we know that the item does not exist

            String leftAlignFormat = "| %-15s | %-4d |%n";

            System.out.format("+------------------------+%n");
            System.out.printf("| %-10s | %4s |%n", "ITEM", "WEIGHT");
            System.out.format("+------------------------+%n");
            System.out.format(leftAlignFormat, itemToShow.getName(), itemToShow.getWeight());
            System.out.format("+------------------------+%n");
        } catch (Exception ignored) {
            System.out.println("You don't have this item...");
        }
    }

    public void showInventory() {
        if (inventory.isEmpty()) return;

        String leftAlignFormat = "| %-15s | %-4d |%n";

        System.out.format("+------------------------+%n");
        System.out.printf("      INVENTORY           %n");
        System.out.format("+------------------------+%n");

        System.out.printf("| %-10s | %4s |%n", "ITEM", "WEIGHT");
        System.out.format("+------------------------+%n");

        inventory.forEach((key, value) -> {
            System.out.format(leftAlignFormat, value.getName(), value.getWeight());
        });

        System.out.format("+------------------------+%n");
    }

    public void printInfo() {
        System.out.println(currentRoom.getLongDescription());
    }

    public void showSimpleInventory() {
        StringBuilder returnString = new StringBuilder("Inventory:");
        Collection<Item> keys = inventory.values();
        for (Item item : keys) {
            returnString.append(" ").append(item.getName());

            if (keys.size() > 1) returnString.append(", ");
        }

        System.out.println(returnString);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public HashMap<Integer, Item> getItemsFound() {
        return inventory;
    }

    public void setItemsFound(HashMap<Integer, Item> itemsFound) {
        this.inventory = itemsFound;
    }

    public Stack<Room> getWalkedRooms() {
        return walkedRooms;
    }

    public void setWalkedRooms(Stack<Room> walkedRooms) {
        this.walkedRooms = walkedRooms;
    }
}
