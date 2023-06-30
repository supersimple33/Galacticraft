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
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

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
        buildExpansionCompressionPair(exporter, GCItems.METEORIC_IRON_NUGGET, GCItems.METEORIC_IRON_INGOT);
        buildExpansionCompressionPair(exporter, GCItems.DESH_NUGGET, GCItems.DESH_INGOT);
        buildExpansionCompressionPair(exporter, GCItems.LEAD_NUGGET, GCItems.LEAD_INGOT);
        buildExpansionCompressionPair(exporter, GCItems.ALUMINUM_NUGGET, GCItems.ALUMINUM_INGOT);
        buildExpansionCompressionPair(exporter, GCItems.TIN_NUGGET, GCItems.TIN_INGOT);
        buildExpansionCompressionPair(exporter, GCItems.TITANIUM_NUGGET, GCItems.TITANIUM_INGOT);
    }

    private void build3x3Compression(Consumer<FinishedRecipe> exporter, Item input, Item result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .define('I', input)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .unlockedBy(getHasName(input), has(input))
                .save(exporter);
    }

    private void build9Expansion(Consumer<FinishedRecipe> exporter, Item input, Item result) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, 9)
                .requires(input, 1)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter);
    }

    private void buildExpansionCompressionPair(Consumer<FinishedRecipe> exporter, Item expansionVariant, Item compressedVariant) {
        build3x3Compression(exporter, expansionVariant, compressedVariant);
        build9Expansion(exporter, compressedVariant, expansionVariant);
    }

}
