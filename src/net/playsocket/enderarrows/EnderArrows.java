package net.playsocket.enderarrows;

import net.canarymod.Canary;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.inventory.recipes.CraftingRecipe;
import net.canarymod.api.inventory.recipes.RecipeRow;
import net.canarymod.chat.Colors;
import net.canarymod.commandsys.CommandDependencyException;
import net.canarymod.plugin.Plugin;

public class EnderArrows extends Plugin {

	@Override
	public void disable() {
		getLogman().logInfo(getName() + " v" + getVersion() + " disabled");
	}

	@Override
	public boolean enable() {
        Canary.hooks().registerListener(new EnderArrowsListener(), this);
        try {
			Canary.commands().registerCommands(new EnderArrowsCommands(), this, true);
		} catch (CommandDependencyException e) {
			e.printStackTrace();
		}
        
        Item itemResult = Canary.factory().getItemFactory().newItem(261);
        itemResult.setDisplayName(Colors.TURQUIOSE + "Ender Bow");
        itemResult.setLore(Colors.CYAN + "Turns regular arrows into Ender Arrows");
        itemResult.setAmount(1);
        Item itemBow = Canary.factory().getItemFactory().newItem(261);
        Item itemPearl = Canary.factory().getItemFactory().newItem(368);
		RecipeRow row1 = new RecipeRow("XXX", new Item[] {itemPearl});
		RecipeRow row2 = new RecipeRow("XYX", new Item[] {itemPearl, itemBow});
		RecipeRow row3 = new RecipeRow("XXX", new Item[] {itemPearl});
        CraftingRecipe recipe = new CraftingRecipe(itemResult, row1, row2, row3);
        Canary.getServer().addRecipe(recipe);
        
        getLogman().logInfo(getName() + " v"+ getVersion() + " by " + getAuthor() + " enabled");
        return true;
	}

}
