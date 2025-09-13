package net.andlius.andliusitemsmod;

import net.andlius.andliusitemsmod.block.ModBlocks;
import net.andlius.andliusitemsmod.item.ModItemGroups;
import net.andlius.andliusitemsmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AndliusItemsMod implements ModInitializer {
	public static final String MOD_ID = "andliusitemsmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
        ModBlocks.registerModBlocks();
	}
}