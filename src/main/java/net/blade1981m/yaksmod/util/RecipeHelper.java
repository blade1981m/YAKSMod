package net.blade1981m.yaksmod.util;

import com.google.common.base.Preconditions;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;

import java.util.List;

/**
 * Created by blade1981m on 7/3/2016.
 */

public class RecipeHelper {

    public static void removeShapelessRecipe (ItemStack resultItem)
    {
        Preconditions.checkNotNull(resultItem);
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
        for (int i = 0; i < recipes.size(); i++)
        {
            IRecipe tmpRecipe = recipes.get(i);

            if (tmpRecipe instanceof ShapelessRecipes)
            {
                ShapelessRecipes recipe = (ShapelessRecipes) tmpRecipe;
                ItemStack recipeResult = recipe.getRecipeOutput();
                if (ItemStack.areItemStacksEqual(resultItem, recipeResult))
                {

                    recipes.remove(i--);
                }
            }
        }
    }

    public static void removeAnyRecipe (ItemStack resultItem)
    {
        Preconditions.checkNotNull(resultItem);
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
        for (int i = 0; i < recipes.size(); i++)
        {
            IRecipe tmpRecipe = recipes.get(i);
            ItemStack recipeResult = tmpRecipe.getRecipeOutput();
            if(recipeResult != null && recipeResult.isItemEqual(resultItem)){
                recipes.remove(i--);
            }
        }
    }
}
