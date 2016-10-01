package net.blade1981m.yaksmod;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.blade1981m.yaksmod.reference.Parts;
import net.blade1981m.yaksmod.reference.Reference;
import net.blade1981m.yaksmod.util.LogHelper;
import net.blade1981m.yaksmod.util.RecipeHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import static net.minecraftforge.oredict.OreDictionary.doesOreNameExist;

/**
 * Created by blade1981m on 7/3/2016.
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = "after:*;")
public class YAKSMod {

    @Mod.Instance(Reference.MOD_ID)
    public static YAKSMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void  postInit(FMLPostInitializationEvent event) {
        if (Loader.isModLoaded("GalacticraftMars") && (Loader.isModLoaded("progressiveautomation"))) {
            LogHelper.info("Galacticraft and Progressive Automation detected. Removing Fragmented Carbon recipe");
            RecipeHelper.removeAnyRecipe(Parts.fragmentedCarbon);
            if(doesOreNameExist("dustCharcoal") && doesOreNameExist("dustCoal")) {
                ItemStack fragmentedCarbon4 = GameRegistry.findItemStack("GalacticraftMars", "item.carbonFragments", 4);
                ItemStack fragmentedCarbon8 = GameRegistry.findItemStack("GalacticraftMars", "item.carbonFragments", 8);
                LogHelper.info("Coal dust and Charcoal dust exist. Adding Fragmented Carbon recipe with Charcoal dust");
                GameRegistry.addRecipe(new ShapelessOreRecipe(fragmentedCarbon4,"dustCharcoal"));
                LogHelper.info("Adding Fragmented Carbon recipe with Coal dust");
                GameRegistry.addRecipe(new ShapelessOreRecipe(fragmentedCarbon8,"dustCoal"));
            }
            else{
                LogHelper.info("Coal dust and Charcoal dust do not both exist. Adding Fragmented Carbon recipe with Fuel Pellets");
                GameRegistry.addRecipe(new ShapelessOreRecipe(Parts.fragmentedCarbon,Parts.fuelPellets));
            }
        }
    }
}
