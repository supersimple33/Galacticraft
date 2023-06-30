/*
 * Copyright (c) 2019-2023 Team Galacticraft
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.galacticraft.mod.data;

import dev.galacticraft.mod.content.item.GCItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class GCRecipeProvider extends FabricRecipeProvider {

    public GCRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, GCItems.ROCKET_LAUNCH_PAD, 9)
                .define('C', GCItems.COMPRESSED_IRON)
                .define('I', Items.IRON_BLOCK)
                .pattern("CCC")
                .pattern("III")
                .unlockedBy(getHasName(Items.IRON_BLOCK), has(Items.IRON_BLOCK))
                .save(exporter);

        // Nuggets <-> Ingots
        buildExpansionCompressionPair(exporter, GCItems.METEORIC_IRON_NUGGET, GCItems.METEORIC_IRON_INGOT, null, "_from_nuggets");
        buildExpansionCompressionPair(exporter, GCItems.DESH_NUGGET, GCItems.DESH_INGOT, null, "_from_nuggets");
        buildExpansionCompressionPair(exporter, GCItems.LEAD_NUGGET, GCItems.LEAD_INGOT, null, "_from_nuggets");
        buildExpansionCompressionPair(exporter, GCItems.ALUMINUM_NUGGET, GCItems.ALUMINUM_INGOT, null, "_from_nuggets");
        buildExpansionCompressionPair(exporter, GCItems.TIN_NUGGET, GCItems.TIN_INGOT, null, "_from_nuggets");
        buildExpansionCompressionPair(exporter, GCItems.TITANIUM_NUGGET, GCItems.TITANIUM_INGOT, null, "_from_nuggets");

        // Ingots <-> Blocks
        buildExpansionCompressionPair(exporter, GCItems.METEORIC_IRON_INGOT, GCItems.METEORIC_IRON_BLOCK, "_from_block", null);
        buildExpansionCompressionPair(exporter, GCItems.DESH_INGOT, GCItems.DESH_BLOCK, "_from_block", null);
        buildExpansionCompressionPair(exporter, GCItems.LEAD_INGOT, GCItems.LEAD_BLOCK, "_from_block", null);
        // skips aluminum and tin blocks
        buildExpansionCompressionPair(exporter, GCItems.TITANIUM_INGOT, GCItems.TITANIUM_BLOCK, "_from_block", null);

        // Armor Sets
        buildArmorSet(exporter, GCItems.COMPRESSED_STEEL, GCItems.HEAVY_DUTY_HELMET, GCItems.HEAVY_DUTY_CHESTPLATE, GCItems.HEAVY_DUTY_LEGGINGS, GCItems.HEAVY_DUTY_BOOTS);
        buildArmorSet(exporter, GCItems.DESH_INGOT, GCItems.DESH_HELMET, GCItems.DESH_CHESTPLATE, GCItems.DESH_LEGGINGS, GCItems.DESH_BOOTS); // REVIEW: could also do COMPRESSED_DESH here?
//        buildArmorUpgrade(exporter, GCItems.TIER_3_ROCKET_SCHEMATIC, GCItems.COMPRESSED_TITANIUM, GCItems.DESH_HELMET, GCItems.DESH_CHESTPLATE, GCItems.DESH_LEGGINGS, GCItems.DESH_BOOTS,
//                GCItems.TITANIUM_HELMET, GCItems.TITANIUM_CHESTPLATE, GCItems.TITANIUM_LEGGINGS, GCItems.TITANIUM_BOOTS);
        // TODO: Uncomment once upgraded to 1.20


    }

    private void build3x3Compression(Consumer<FinishedRecipe> exporter, Item input, Item result,
                                     @Nullable String suffix) {
        ShapedRecipeBuilder recipe = ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .define('I', input)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .unlockedBy(getHasName(input), has(input));
        if (suffix != null) {
            recipe.save(exporter, RecipeBuilder.getDefaultRecipeId(result).withSuffix(suffix));
        } else {
            recipe.save(exporter);
        }
    }

    private void build9Expansion(Consumer<FinishedRecipe> exporter, Item input, Item result,
                                 @Nullable String suffix) {
        ShapelessRecipeBuilder recipe = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, 9)
                .requires(input, 1)
                .unlockedBy(getHasName(input), has(input));
        if (suffix != null) {
            recipe.save(exporter, RecipeBuilder.getDefaultRecipeId(result).withSuffix(suffix));
        } else {
            recipe.save(exporter);
        }
    }

    private void buildExpansionCompressionPair(Consumer<FinishedRecipe> exporter, Item expansionVariant,
                                               Item compressedVariant, @Nullable String suffixExpansion,
                                               @Nullable String suffixCompressed) {
        build3x3Compression(exporter, expansionVariant, compressedVariant, suffixCompressed);
        build9Expansion(exporter, compressedVariant, expansionVariant, suffixExpansion);
    }

    private void buildArmorSet(Consumer<FinishedRecipe> exporter, Item base, Item helmet, Item chestplate, Item leggings, Item boots) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmet, 1)
                .define('I', base)
                .pattern("III")
                .pattern("I I")
                .unlockedBy(getHasName(base), has(base))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(helmet).withPrefix("armor/"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, chestplate, 1)
                .define('I', base)
                .pattern("I I")
                .pattern("III")
                .pattern("III")
                .unlockedBy(getHasName(base), has(base))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(chestplate).withPrefix("armor/"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, leggings, 1)
                .define('I', base)
                .pattern("III")
                .pattern("I I")
                .pattern("I I")
                .unlockedBy(getHasName(base), has(base))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(leggings).withPrefix("armor/"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, boots, 1)
                .define('I', base)
                .pattern("I I")
                .pattern("I I")
                .unlockedBy(getHasName(base), has(base))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(boots).withPrefix("armor/"));
    }

    private void buildArmorUpgrade(Consumer<FinishedRecipe> exporter, Item template, Item upgrade, Item baseHelmet,
                                   Item baseChestplate, Item baseLeggings, Item baseBoots, Item upgradeHelmet,
                                   Item upgradeChestplate, Item upgradeLeggings, Item upgradeBoots) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseHelmet), Ingredient.of(upgrade), RecipeCategory.COMBAT, upgradeHelmet)
                .unlocks("has_upgrade", has(upgrade))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(upgradeHelmet).withPrefix("armor/"));
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseChestplate), Ingredient.of(upgrade), RecipeCategory.COMBAT, upgradeChestplate)
                .unlocks("has_upgrade", has(upgrade))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(upgradeChestplate).withPrefix("armor/"));
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseLeggings), Ingredient.of(upgrade), RecipeCategory.COMBAT, upgradeLeggings)
                .unlocks("has_upgrade", has(upgrade))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(upgradeLeggings).withPrefix("armor/"));
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseBoots), Ingredient.of(upgrade), RecipeCategory.COMBAT, upgradeBoots)
                .unlocks("has_upgrade", has(upgrade))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(upgradeBoots).withPrefix("armor/"));
    }
}
