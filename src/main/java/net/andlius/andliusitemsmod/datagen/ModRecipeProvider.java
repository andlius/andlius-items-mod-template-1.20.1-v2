package net.andlius.andliusitemsmod.datagen;

import net.andlius.andliusitemsmod.block.ModBlocks;
import net.andlius.andliusitemsmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> NIKKIUM_SMELTABLES = List.of(ModItems.PERFECT_NIKKI,
            ModBlocks.PERFECTNIKKIUM_ORE, ModBlocks.DEEPSLATE_PERFECTNIKKIUM_ORE);


    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, NIKKIUM_SMELTABLES, RecipeCategory.MISC, ModItems.PERFECTNIKKIUM_INGOT,
                0.7f, 200, "perfectnikkium");
        offerBlasting(exporter, NIKKIUM_SMELTABLES, RecipeCategory.MISC, ModItems.PERFECTNIKKIUM_INGOT,
                0.7f, 100, "perfectnikkium");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PERFECTNIKKIUM_INGOT, RecipeCategory.DECORATIONS,
                ModBlocks.PERFECTNIKKIUM_BLOCK);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.EVENIKKIUM_BLOCK, 1)
                .pattern("pnp")
                .pattern("nnn")
                .pattern("pnp")
                .input('p', ModItems.PERFECTNIKKIUM_INGOT)
                .input('n', ModItems.PERFECT_NIKKI)
                .criterion(hasItem(ModItems.PERFECT_NIKKI), conditionsFromItem(ModItems.PERFECT_NIKKI))
                .criterion(hasItem(ModItems.PERFECTNIKKIUM_INGOT), conditionsFromItem(ModItems.PERFECTNIKKIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.EVENIKKIUM_BLOCK)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PERFECTNIKKIUM_PICKAXE, 1)
                .pattern("ppp")
                .pattern(" s ")
                .pattern(" s ")
                .input('p', ModItems.PERFECTNIKKIUM_INGOT)
                .input('s', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.PERFECTNIKKIUM_INGOT), conditionsFromItem(ModItems.PERFECTNIKKIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PERFECTNIKKIUM_PICKAXE)));


    }
}
