package net.andlius.andliusitemsmod.item;

import net.andlius.andliusitemsmod.AndliusItemsMod;
import net.andlius.andliusitemsmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup NIKKIUM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AndliusItemsMod.MOD_ID, "nikkium"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.nikkium"))
                    .icon(() -> new ItemStack(ModItems.PERFECT_NIKKI)).entries((displayContext, entries) -> {
                        entries.add(ModItems.PERFECT_NIKKI);
                        entries.add(ModItems.PERFECTNIKKIUM_INGOT);

                        entries.add(ModItems.METAL_DETECTOR);

                        entries.add(ModItems.PERFECTNIKKIUM_PICKAXE);

                        entries.add(ModBlocks.PERFECTNIKKIUM_BLOCK);
                        entries.add(ModBlocks.EVENIKKIUM_BLOCK);

                        entries.add(ModBlocks.PERFECTNIKKIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PERFECTNIKKIUM_ORE);

                    }).build());


    public static void registerItemGroups() {
        AndliusItemsMod.LOGGER.info("Registering Item Groups for " + AndliusItemsMod.MOD_ID);
    }
}
