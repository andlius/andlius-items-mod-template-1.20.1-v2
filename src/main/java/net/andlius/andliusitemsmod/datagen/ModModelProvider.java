package net.andlius.andliusitemsmod.datagen;

import net.andlius.andliusitemsmod.block.ModBlocks;
import net.andlius.andliusitemsmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EVENIKKIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PERFECTNIKKIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PERFECTNIKKIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PERFECTNIKKIUM_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PERFECT_NIKKI, Models.GENERATED);
        itemModelGenerator.register(ModItems.PERFECTNIKKIUM_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);


        itemModelGenerator.register(ModItems.PERFECTNIKKIUM_PICKAXE, Models.HANDHELD);
    }
}
