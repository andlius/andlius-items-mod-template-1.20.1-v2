package net.andlius.andliusitemsmod.item;

import net.andlius.andliusitemsmod.AndliusItemsMod;
import net.andlius.andliusitemsmod.item.custom.MetalDetectorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PERFECT_NIKKI = registerItem("perfect_nikki", new Item(new FabricItemSettings()));
    public static final Item PERFECTNIKKIUM_INGOT =registerItem("perfectnikkium_ingot", new Item(new FabricItemSettings()));

    public static final Item METAL_DETECTOR =registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));

    public static final Item PERFECTNIKKIUM_PICKAXE =registerItem("perfectnikkium_pickaxe",
            new PickaxeItem(ModToolMaterial.PERFECTNIKKIUM, 8, 4f, new FabricItemSettings()));


    private static void addItemsToIngredientTabIItemGroup(FabricItemGroupEntries entries) {
        entries.add(PERFECT_NIKKI);
        entries.add(PERFECTNIKKIUM_INGOT);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AndliusItemsMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        AndliusItemsMod.LOGGER.info("Registering Mod Items for " + AndliusItemsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabIItemGroup);
    }
}
