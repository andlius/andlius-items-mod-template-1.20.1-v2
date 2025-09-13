package net.andlius.andliusitemsmod.datagen;

import net.andlius.andliusitemsmod.block.ModBlocks;
import net.andlius.andliusitemsmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.EVENIKKIUM_BLOCK);
        addDrop(ModBlocks.PERFECTNIKKIUM_BLOCK);

        addDrop(ModBlocks.PERFECTNIKKIUM_ORE, copperLikeOreDrops(ModBlocks.PERFECTNIKKIUM_ORE, ModItems.PERFECT_NIKKI));
        addDrop(ModBlocks.DEEPSLATE_PERFECTNIKKIUM_ORE, copperLikeOreDrops(ModBlocks.DEEPSLATE_PERFECTNIKKIUM_ORE, ModItems.PERFECT_NIKKI));
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return dropsWithSilkTouch(drop, (LootPoolEntry.Builder<?>)this.applyExplosionDecay(drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(2.0F, 5.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
