package game;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * Uma game.Room (sala) representa uma localização no cenário do jogo.
 * Ela é conectada com outras salas do jogo. Existem quatro direções possíveis: norte, sul, leste e oeste.
 * A sala possui uma referência da sala vizinha ou ela é nula se não há saída naquela direção
 */
public class Room {
    private final String description;

    private final HashMap<String, Room> exits;

    private final HashMap<Integer, Item> items;

    private Item requiredItem;

    private boolean hasTrap;

    private boolean hasTreasure;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        items = new HashMap<>();
        hasTrap = false;
        hasTreasure = false;
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public HashMap<Integer, Item> getItems() {
        return items;
    }

    public void setItem(Item item) {
        items.put(item.getId(), item);
    }

    public void removeItem(Item item) {
        items.remove(item.getId(), item);
    }

    public String getLongDescription() {
        return "-> You are " + description + ".\n" + getExitString() + ".\n" + getItemString();
    }

    public String getExitString() {
        StringBuilder returnString = new StringBuilder("Exits:");
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString.append(" ").append(exit);
        }
        return returnString.toString();
    }

    public String getItemString() {
        StringBuilder returnString = new StringBuilder("game.Room items:");
        Collection<Item> keys = items.values();
        for (Item item : keys) {
            returnString.append(" ").append(item.getName());
        }
        return returnString.toString();
    }

    public Item getRequiredItem() {
        return requiredItem;
    }

    public void setRequiredItem(Item requiredItem) {
        this.requiredItem = requiredItem;
    }

    public boolean hasTrap() {
        return hasTrap;
    }

    public void setHasTrap(boolean hasTrap) {
        this.hasTrap = hasTrap;
    }

    public boolean hasTreasure() {
        return hasTreasure;
    }

    public void setHasTreasure(boolean hasTreasure) {
        this.hasTreasure = hasTreasure;
    }
}
