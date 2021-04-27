package dev.galacticraft.mod.recipe;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;

public interface CraftingRecipe extends Recipe<CraftingInventory> {

    default RecipeType<? extends CraftingRecipe> getType() {
        return GalacticraftRecipe.POTION_TYPE;
    }

}
