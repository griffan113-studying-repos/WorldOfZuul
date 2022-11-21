package game;

/**
 * Um game.Item pode ser carregado por um jogador e também pode estar presente dentro de uma sala (game.Room)
 */
public class Item {

    private int id;

    private String description;

    private String name;

    private int weight;

    private Item requiredItem;

    public Item(int id, String name, String description, int weight) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.weight = weight;
    }

    public Item(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item getRequiredItem() {
        return requiredItem;
    }

    public void setRequiredItem(Item requiredItem) {
        this.requiredItem = requiredItem;
    }
}