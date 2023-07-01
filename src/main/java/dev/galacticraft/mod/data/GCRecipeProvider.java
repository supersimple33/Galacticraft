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
        buildExpansionCompressionPair(exporter, GCItems.LUNAR_SAPPHIRE, GCItems.LUNAR_SAPPHIRE_BLOCK, null, null);

        // Armor Sets
        buildArmorSet(exporter, GCItems.COMPRESSED_STEEL, GCItems.HEAVY_DUTY_HELMET, GCItems.HEAVY_DUTY_CHESTPLATE, GCItems.HEAVY_DUTY_LEGGINGS, GCItems.HEAVY_DUTY_BOOTS);
        buildArmorSet(exporter, GCItems.DESH_INGOT, GCItems.DESH_HELMET, GCItems.DESH_CHESTPLATE, GCItems.DESH_LEGGINGS, GCItems.DESH_BOOTS); // REVIEW: could also do COMPRESSED_DESH here?
//        buildArmorUpgrade(exporter, GCItems.TIER_3_ROCKET_SCHEMATIC, GCItems.COMPRESSED_TITANIUM, GCItems.DESH_HELMET, GCItems.DESH_CHESTPLATE, GCItems.DESH_LEGGINGS, GCItems.DESH_BOOTS,
//                GCItems.TITANIUM_HELMET, GCItems.TITANIUM_CHESTPLATE, GCItems.TITANIUM_LEGGINGS, GCItems.TITANIUM_BOOTS);
        // TODO: Uncomment once upgraded to 1.20

        // Decoration Variants
//        generateBuildingBlockVariants(exporter, GCItems.ALUMINUM_DECORATION, GCItems.ALUMINUM_DECORATION_SLAB, GCItems.ALUMINUM_DECORATION_STAIRS, GCItems.ALUMINUM_DECORATION_WALL, "decoration/aluminum/");
//        generateBuildingBlockVariants(exporter, GCItems.DETAILED_ALUMINUM_DECORATION, GCItems.DETAILED_ALUMINUM_DECORATION_SLAB, GCItems.DETAILED_ALUMINUM_DECORATION_STAIRS, GCItems.DETAILED_ALUMINUM_DECORATION_WALL, "decoration/aluminum/");
//        generateBuildingBlockVariants(exporter, GCItems.BRONZE_DECORATION, GCItems.BRONZE_DECORATION_SLAB, GCItems.BRONZE_DECORATION_STAIRS, GCItems.BRONZE_DECORATION_WALL, "decoration/bronze/");
//        generateBuildingBlockVariants(exporter, GCItems.DETAILED_BRONZE_DECORATION, GCItems.DETAILED_BRONZE_DECORATION_SLAB, GCItems.DETAILED_BRONZE_DECORATION_STAIRS, GCItems.DETAILED_BRONZE_DECORATION_WALL, "decoration/bronze/");
//        generateBuildingBlockVariants(exporter, GCItems.COPPER_DECORATION, GCItems.COPPER_DECORATION_SLAB, GCItems.COPPER_DECORATION_STAIRS, GCItems.COPPER_DECORATION_WALL, "decoration/copper/");
//        generateBuildingBlockVariants(exporter, GCItems.DETAILED_COPPER_DECORATION, GCItems.DETAILED_COPPER_DECORATION_SLAB, GCItems.DETAILED_COPPER_DECORATION_STAIRS, GCItems.DETAILED_COPPER_DECORATION_WALL, "decoration/copper/");
//        generateBuildingBlockVariants(exporter, GCItems.DARK_DECORATION, GCItems.DARK_DECORATION_SLAB, GCItems.DARK_DECORATION_STAIRS, GCItems.DARK_DECORATION_WALL, "decoration/dark/");
//        generateBuildingBlockVariants(exporter, GCItems.IRON_DECORATION, GCItems.IRON_DECORATION_SLAB, GCItems.IRON_DECORATION_STAIRS, GCItems.IRON_DECORATION_WALL, "decoration/iron/");
//        generateBuildingBlockVariants(exporter, GCItems.DETAILED_IRON_DECORATION, GCItems.DETAILED_IRON_DECORATION_SLAB, GCItems.DETAILED_IRON_DECORATION_STAIRS, GCItems.DETAILED_IRON_DECORATION_WALL, "decoration/iron/");
//        generateBuildingBlockVariants(exporter, GCItems.METEORIC_IRON_DECORATION, GCItems.METEORIC_IRON_DECORATION_SLAB, GCItems.METEORIC_IRON_DECORATION_STAIRS, GCItems.METEORIC_IRON_DECORATION_WALL, "decoration/meteoric_iron/");
//        generateBuildingBlockVariants(exporter, GCItems.DETAILED_METEORIC_IRON_DECORATION, GCItems.DETAILED_METEORIC_IRON_DECORATION_SLAB, GCItems.DETAILED_METEORIC_IRON_DECORATION_STAIRS, GCItems.DETAILED_METEORIC_IRON_DECORATION_WALL, "decoration/meteoric_iron/");
//        generateBuildingBlockVariants(exporter, GCItems.STEEL_DECORATION, GCItems.STEEL_DECORATION_SLAB, GCItems.STEEL_DECORATION_STAIRS, GCItems.STEEL_DECORATION_WALL, "decoration/steel/");
//        generateBuildingBlockVariants(exporter, GCItems.DETAILED_STEEL_DECORATION, GCItems.DETAILED_STEEL_DECORATION_SLAB, GCItems.DETAILED_STEEL_DECORATION_STAIRS, GCItems.DETAILED_STEEL_DECORATION_WALL, "decoration/steel/");
//        generateBuildingBlockVariants(exporter, GCItems.TIN_DECORATION, GCItems.TIN_DECORATION_SLAB, GCItems.TIN_DECORATION_STAIRS, GCItems.TIN_DECORATION_WALL, "decoration/tin/");
//        generateBuildingBlockVariants(exporter, GCItems.DETAILED_TIN_DECORATION, GCItems.DETAILED_TIN_DECORATION_SLAB, GCItems.DETAILED_TIN_DECORATION_STAIRS, GCItems.DETAILED_TIN_DECORATION_WALL, "decoration/tin/");
//        generateBuildingBlockVariants(exporter, GCItems.TITANIUM_DECORATION, GCItems.TITANIUM_DECORATION_SLAB, GCItems.TITANIUM_DECORATION_STAIRS, GCItems.TITANIUM_DECORATION_WALL, "decoration/titanium/");
//        generateBuildingBlockVariants(exporter, GCItems.DETAILED_TITANIUM_DECORATION, GCItems.DETAILED_TITANIUM_DECORATION_SLAB, GCItems.DETAILED_TITANIUM_DECORATION_STAIRS, GCItems.DETAILED_TITANIUM_DECORATION_WALL, "decoration/titanium/");
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

    private void generateBuildingBlockVariants(Consumer<FinishedRecipe> exporter, Item base, Item block, Item slab, Item stair, Item wall, String prefix) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, block, 1)
                .define('S', Items.STONE)
                .define('B', base)
                .pattern("SS")
                .pattern("SS")
                .pattern(" B")
                .unlockedBy(getHasName(base), has(base))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(block).withPrefix(prefix));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, slab, 6)
                .define('I', block)
                .pattern("III")
                .unlockedBy(getHasName(block), has(block))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(slab).withPrefix(prefix));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stair, 4)
                .define('I', block)
                .pattern("I  ")
                .pattern("II ")
                .pattern("III")
                .unlockedBy(getHasName(block), has(block))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(stair).withPrefix(prefix));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, wall, 6)
                .define('I', block)
                .pattern("III")
                .pattern("III")
                .unlockedBy(getHasName(block), has(block))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(wall).withPrefix(prefix));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(block), RecipeCategory.BUILDING_BLOCKS, slab, 2)
                .unlockedBy("has_item", has(block))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(slab).withPrefix(prefix).withSuffix("_sc"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(block), RecipeCategory.BUILDING_BLOCKS, stair)
                .unlockedBy("has_item", has(block))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(stair).withPrefix(prefix).withSuffix("_sc"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(block), RecipeCategory.BUILDING_BLOCKS, wall, 1)
                .unlockedBy("has_item", has(block))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(wall).withPrefix(prefix).withSuffix("_sc"));
    }
}
