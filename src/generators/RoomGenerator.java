package generators;

import game.Item;
import game.Room;

public class RoomGenerator {
    public static Room execute() {
        Room cave_entrance = new Room("in the entrance of a strange cave");
        Room forest = new Room("in the forest");
        Room jungle = new Room("in the jungle");
        Room underground_jungle = new Room("in the underground jungle");
        Room underground_corruption = new Room("in the underground corruption");
        Room underground_mushroom = new Room("in the underground mushroom");
        Room underground_crimson = new Room("in the underground crimson");
        Room underground_desert = new Room("in the underground desert");
        Room underground_cabin = new Room("in the underground cabin");
        Room mini_biomes = new Room("in the underground mini biomes");
        Room ice = new Room("in the ice biome");
        Room hive = new Room("in the hive biome");
        Room mines = new Room("in the mines biome");
        Room oasis = new Room("in the oasis biome");
        Room pyramid = new Room("in a egyptian pyramid");
        Room trivia = new Room("in the trivia");
        Room desert = new Room("in a vaste desert");
        Room dungeon = new Room("in the entrance of a macabre dungeon");
        Room mushroom = new Room("in the mushroom biome");
        Room the_sacred = new Room("in the sacred biome");
        Room living_tree = new Room("in the living tree");
        Room jungle_crypt = new Room("in the jungle crypt biome");
        Room shiny_slime = new Room("in the shiny biome");
        Room heart_shrine = new Room("in the heart biome");
        Room floating_islands = new Room("in the floating islands");
        Room ruined_house = new Room("in a ruined house");
        Room heaven = new Room("in the heaven");
        Room sky_treasure = new Room("in the sky treasure");
        Room snow = new Room("in the snow biome");
        Room hybrid_biomes = new Room("in the hybrid biome");
        Room gemstone_cave = new Room("in the gemstone cave biome");
        Room living_mahogany_tree = new Room("in the living mahogany tree");
        Room hallowed_deserts = new Room("in the hallowed deserts");
        Room moss_chamber = new Room("in the moss chamber biome");
        Room campsite = new Room("in the campsite biome");
        Room cave_of_the_spiders = new Room("in the cave of the spiders");
        Room flower_patch = new Room("in the flower patch");
        Room thin_ice_patch = new Room("in the thin ice patch");
        Room hell = new Room("in the hell!");
        Room hell_treasure = new Room("in the hell treasure");
        Room corrupted = new Room("in the corrupted biome");
        Room death_trap = new Room("in the death trap");
        Room treasure_room = new Room("in the treasure room");

        Item ichor_torch  = new Item(1, "ichor_torch", 1);
        Item copper_shortsword = new Item(2, "copper_shortsword", 2);
        Item rich_mahogany_helmet = new Item(3, "rich_mahogany helmet", 1);
        Item leg_rich_mahogany = new Item(4, "leg_rich_mahogany", 1);
        Item rich_mahogany_breastplate = new Item(5, "leg_rich_mahogany", 2);
        Item stardust_leg = new Item(6, "stardust_leg", 4);
        Item bee_knees_bow = new Item(7, "bee_knees_bow", 2);
        Item stardust_helmet = new Item(8, "stardust_helmet", 3);
        Item zenith_sword = new Item(9, "zenith_sword", 3);
        Item stardust_breastplate = new Item(10, "stardust_breastplate", 1);
        Item gold_ring = new Item(11, "gold_ring", 1);
        Item gold_key = new Item(12, "gold_key", 1);

        stardust_leg.setRequiredItem(gold_key);
        stardust_breastplate.setRequiredItem(gold_key);
        stardust_helmet.setRequiredItem(gold_key);
        zenith_sword.setRequiredItem(gold_key);
        bee_knees_bow.setRequiredItem(gold_key);

        treasure_room.setHasTreasure(true);
        death_trap.setHasTrap(true);

        cave_entrance.setExit("east", forest);

        forest.setItem(ichor_torch);
        forest.setExit("south", underground_jungle);
        forest.setExit("north", jungle);
        forest.setExit("east", desert);
        forest.setExit("west", cave_entrance);

        jungle.setExit("east", dungeon);
        jungle.setExit("north", death_trap);

        desert.setExit("west", forest);
        desert.setExit("north", dungeon);

        corrupted.setRequiredItem(gold_ring);
        corrupted.setItem(rich_mahogany_breastplate);
        corrupted.setExit("north", shiny_slime);
        corrupted.setExit("west", dungeon);

        dungeon.setExit("west", jungle);
        dungeon.setExit("south", desert);
        dungeon.setExit("north", mushroom);
        dungeon.setExit("east", corrupted);

        mushroom.setExit("west", death_trap);
        mushroom.setExit("south", dungeon);
        mushroom.setExit("north", the_sacred);
        mushroom.setExit("east", shiny_slime);

        the_sacred.setRequiredItem(gold_ring);
        the_sacred.setExit("south", mushroom);
        the_sacred.setExit("east", living_tree);

        living_tree.setExit("west", the_sacred);
        living_tree.setExit("east", jungle_crypt);

        jungle_crypt.setExit("west", living_tree);
        jungle_crypt.setExit("south", heart_shrine);
        jungle_crypt.setExit("east", floating_islands);

        floating_islands.setExit("south", ruined_house);
        floating_islands.setExit("north", heaven);
        floating_islands.setExit("west", jungle_crypt);

        ruined_house.setExit("north", floating_islands);
        ruined_house.setExit("east", snow);
        ruined_house.setExit("south", hybrid_biomes);

        snow.setExit("west", ruined_house);
        snow.setExit("east", living_mahogany_tree);

        living_mahogany_tree.setItem(gold_ring);
        living_mahogany_tree.setExit("west", snow);
        living_mahogany_tree.setExit("south", gemstone_cave);

        gemstone_cave.setItem(gold_ring);
        gemstone_cave.setExit("north", living_mahogany_tree);
        gemstone_cave.setExit("west", hybrid_biomes);

        hybrid_biomes.setExit("north", ruined_house);
        hybrid_biomes.setExit("south", hallowed_deserts);
        hybrid_biomes.setExit("east", gemstone_cave);
        hybrid_biomes.setExit("west", death_trap);

        hallowed_deserts.setExit("north", hybrid_biomes);
        hallowed_deserts.setExit("east", moss_chamber);

        moss_chamber.setExit("west", hallowed_deserts);
        moss_chamber.setExit("south", campsite);

        campsite.setExit("north", moss_chamber);
        campsite.setExit("south", thin_ice_patch);
        campsite.setExit("east", cave_of_the_spiders);

        cave_of_the_spiders.setRequiredItem(gold_ring);
        cave_of_the_spiders.setItem(stardust_helmet);
        cave_of_the_spiders.setExit("west", campsite);
        cave_of_the_spiders.setExit("south", death_trap);

        thin_ice_patch.setExit("west", flower_patch);
        thin_ice_patch.setExit("north", campsite);
        thin_ice_patch.setExit("south", hell);
        thin_ice_patch.setExit("east", death_trap);

        flower_patch.setExit("east", thin_ice_patch);

        hell.setExit("north", thin_ice_patch);
        hell.setExit("west", treasure_room);
        hell.setExit("south", hell_treasure);

        hell_treasure.setItem(gold_key);
        hell_treasure.setItem(bee_knees_bow);
        hell_treasure.setExit("north", hell);

        heaven.setRequiredItem(gold_ring);
        heaven.setExit("south", floating_islands);
        heaven.setExit("east", sky_treasure);

        sky_treasure.setItem(zenith_sword);
        sky_treasure.setExit("west", heaven);

        shiny_slime.setExit("west", mushroom);
        shiny_slime.setExit("south", corrupted);
        shiny_slime.setExit("east", heart_shrine);

        heart_shrine.setExit("north", jungle_crypt);
        heart_shrine.setExit("west", shiny_slime);

        underground_jungle.setExit("north", forest);
        underground_jungle.setExit("east", underground_corruption);

        underground_corruption.setRequiredItem(gold_ring);
        underground_corruption.setItem(copper_shortsword);
        underground_corruption.setExit("west", underground_jungle);
        underground_corruption.setExit("south", underground_mushroom);

        underground_mushroom.setExit("north", underground_corruption);
        underground_mushroom.setExit("east", trivia);
        underground_mushroom.setExit("west", underground_crimson);
        underground_mushroom.setExit("south", ice);

        trivia.setItem(gold_key);
        trivia.setExit("west", underground_mushroom);

        underground_crimson.setExit("west", death_trap);
        underground_crimson.setExit("east", underground_mushroom);

        ice.setItem(leg_rich_mahogany);
        ice.setExit("west", mini_biomes);
        ice.setExit("north", underground_mushroom);

        mini_biomes.setExit("east", ice);
        mini_biomes.setExit("south", mines);

        mines.setExit("north", mini_biomes);
        mines.setExit("east", underground_desert);

        underground_desert.setExit("west", mines);
        underground_desert.setExit("south", pyramid);
        underground_desert.setExit("east", oasis);

        pyramid.setExit("north", underground_desert);
        pyramid.setExit("west", underground_cabin);
        pyramid.setExit("south", treasure_room);

        underground_cabin.setRequiredItem(gold_ring);
        underground_cabin.setExit("east", pyramid);

        oasis.setExit("west", underground_desert);
        oasis.setExit("south", death_trap);
        oasis.setExit("north", hive);

        hive.setRequiredItem(gold_ring);
        hive.setItem(rich_mahogany_helmet);
        hive.setExit("south", oasis);

        return cave_entrance;
    }
}
