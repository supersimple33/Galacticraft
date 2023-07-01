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

package dev.galacticraft.mod.data.tag;

import dev.galacticraft.mod.content.item.GCItems;
import dev.galacticraft.mod.tag.GCTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class GCItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public GCItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture, new GCBlockTagProvider(output, completableFuture));
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.tag(ItemTags.AXES)
                .add(this.reverseLookup(GCItems.HEAVY_DUTY_AXE))
                .add(this.reverseLookup(GCItems.DESH_AXE))
                .add(this.reverseLookup(GCItems.TITANIUM_AXE));
        this.tag(ItemTags.HOES)
                .add(this.reverseLookup(GCItems.HEAVY_DUTY_HOE))
                .add(this.reverseLookup(GCItems.DESH_HOE))
                .add(this.reverseLookup(GCItems.TITANIUM_HOE));
        this.tag(ItemTags.PICKAXES)
                .add(this.reverseLookup(GCItems.HEAVY_DUTY_PICKAXE))
                .add(this.reverseLookup(GCItems.DESH_PICKAXE))
                .add(this.reverseLookup(GCItems.TITANIUM_PICKAXE));
        this.tag(ItemTags.SHOVELS)
                .add(this.reverseLookup(GCItems.HEAVY_DUTY_SHOVEL))
                .add(this.reverseLookup(GCItems.DESH_SHOVEL))
                .add(this.reverseLookup(GCItems.TITANIUM_SHOVEL));
        this.tag(ItemTags.SWORDS)
                .add(this.reverseLookup(GCItems.HEAVY_DUTY_SWORD))
                .add(this.reverseLookup(GCItems.DESH_SWORD))
                .add(this.reverseLookup(GCItems.TITANIUM_SWORD));

        this.tag(ConventionalItemTags.FOODS)
                .add(this.reverseLookup(GCItems.CANNED_BEEF)).add(this.reverseLookup(GCItems.CANNED_DEHYDRATED_CARROT))
                .add(this.reverseLookup(GCItems.CANNED_DEHYDRATED_MELON)).add(this.reverseLookup(GCItems.CANNED_DEHYDRATED_APPLE))
                .add(this.reverseLookup(GCItems.CANNED_DEHYDRATED_POTATO))
                .add(this.reverseLookup(GCItems.MOON_BERRIES))
                .add(this.reverseLookup(GCItems.CHEESE_CURD)).add(this.reverseLookup(GCItems.CHEESE_SLICE))
                .add(this.reverseLookup(GCItems.BURGER_BUN)).add(this.reverseLookup(GCItems.GROUND_BEEF))
                .add(this.reverseLookup(GCItems.BEEF_PATTY)).add(this.reverseLookup(GCItems.CHEESEBURGER));

        this.tag(GCTags.ALUMINUM_INGOTS)
                .add(this.reverseLookup(GCItems.ALUMINUM_INGOT));
        this.tag(GCTags.RAW_ALUMINUM_ORES)
                .add(this.reverseLookup(GCItems.RAW_ALUMINUM));
        this.tag(GCTags.LEAD_INGOTS)
                .add(this.reverseLookup(GCItems.LEAD_INGOT));
        this.tag(GCTags.RAW_LEAD_ORES)
                .add(this.reverseLookup(GCItems.RAW_LEAD));
        this.tag(GCTags.SILICONS)
                .add(this.reverseLookup(GCItems.RAW_SILICON));
        this.tag(GCTags.TIN_INGOTS)
                .add(this.reverseLookup(GCItems.TIN_INGOT));
        this.tag(GCTags.RAW_TIN_ORES)
                .add(this.reverseLookup(GCItems.RAW_TIN));
        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS); //fixme
        //        "galacticraft:legacy_music_disc_mars",
        //        "galacticraft:legacy_music_disc_mimas",
        //        "galacticraft:legacy_music_disc_orbit",
        //        "galacticraft:legacy_music_disc_spacerace"

        this.tag(GCTags.DECORATION_BLOCKS)
                .add(this.reverseLookup(GCItems.ALUMINUM_DECORATION)).add(this.reverseLookup(GCItems.ALUMINUM_DECORATION_SLAB)).add(this.reverseLookup(GCItems.ALUMINUM_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.ALUMINUM_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.DETAILED_ALUMINUM_DECORATION)).add(this.reverseLookup(GCItems.DETAILED_ALUMINUM_DECORATION_SLAB)).add(this.reverseLookup(GCItems.DETAILED_ALUMINUM_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.DETAILED_ALUMINUM_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.BRONZE_DECORATION)).add(this.reverseLookup(GCItems.BRONZE_DECORATION_SLAB)).add(this.reverseLookup(GCItems.BRONZE_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.BRONZE_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.DETAILED_BRONZE_DECORATION)).add(this.reverseLookup(GCItems.DETAILED_BRONZE_DECORATION_SLAB)).add(this.reverseLookup(GCItems.DETAILED_BRONZE_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.DETAILED_BRONZE_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.COPPER_DECORATION)).add(this.reverseLookup(GCItems.COPPER_DECORATION_SLAB)).add(this.reverseLookup(GCItems.COPPER_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.COPPER_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.DETAILED_COPPER_DECORATION)).add(this.reverseLookup(GCItems.DETAILED_COPPER_DECORATION_SLAB)).add(this.reverseLookup(GCItems.DETAILED_COPPER_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.DETAILED_COPPER_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.DARK_DECORATION)).add(this.reverseLookup(GCItems.DARK_DECORATION_SLAB)).add(this.reverseLookup(GCItems.DARK_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.DARK_DECORATION_WALL))
//                .add(this.reverseLookup(GCItems.DETAILED_DARK_DECORATION)).add(this.reverseLookup(GCItems.DETAILED_DARK_DECORATION_SLAB)).add(this.reverseLookup(GCItems.DETAILED_DARK_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.DETAILED_DARK_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.IRON_DECORATION)).add(this.reverseLookup(GCItems.IRON_DECORATION_SLAB)).add(this.reverseLookup(GCItems.IRON_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.IRON_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.DETAILED_IRON_DECORATION)).add(this.reverseLookup(GCItems.DETAILED_IRON_DECORATION_SLAB)).add(this.reverseLookup(GCItems.DETAILED_IRON_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.DETAILED_IRON_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.METEORIC_IRON_DECORATION)).add(this.reverseLookup(GCItems.METEORIC_IRON_DECORATION_SLAB)).add(this.reverseLookup(GCItems.METEORIC_IRON_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.METEORIC_IRON_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.DETAILED_METEORIC_IRON_DECORATION)).add(this.reverseLookup(GCItems.DETAILED_METEORIC_IRON_DECORATION_SLAB)).add(this.reverseLookup(GCItems.DETAILED_METEORIC_IRON_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.DETAILED_METEORIC_IRON_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.STEEL_DECORATION)).add(this.reverseLookup(GCItems.STEEL_DECORATION_SLAB)).add(this.reverseLookup(GCItems.STEEL_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.STEEL_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.DETAILED_STEEL_DECORATION)).add(this.reverseLookup(GCItems.DETAILED_STEEL_DECORATION_SLAB)).add(this.reverseLookup(GCItems.DETAILED_STEEL_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.DETAILED_STEEL_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.TIN_DECORATION)).add(this.reverseLookup(GCItems.TIN_DECORATION_SLAB)).add(this.reverseLookup(GCItems.TIN_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.TIN_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.DETAILED_TIN_DECORATION)).add(this.reverseLookup(GCItems.DETAILED_TIN_DECORATION_SLAB)).add(this.reverseLookup(GCItems.DETAILED_TIN_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.DETAILED_TIN_DECORATION_WALL));

        this.tag(ItemTags.SLABS)
                .add(this.reverseLookup(GCItems.ALUMINUM_DECORATION_SLAB)).add(this.reverseLookup(GCItems.DETAILED_ALUMINUM_DECORATION_SLAB))
                .add(this.reverseLookup(GCItems.BRONZE_DECORATION_SLAB)).add(this.reverseLookup(GCItems.DETAILED_BRONZE_DECORATION_SLAB))
                .add(this.reverseLookup(GCItems.COPPER_DECORATION_SLAB)).add(this.reverseLookup(GCItems.DETAILED_COPPER_DECORATION_SLAB))
                .add(this.reverseLookup(GCItems.DARK_DECORATION_SLAB))
                .add(this.reverseLookup(GCItems.IRON_DECORATION_SLAB)).add(this.reverseLookup(GCItems.DETAILED_IRON_DECORATION_SLAB))
                .add(this.reverseLookup(GCItems.METEORIC_IRON_DECORATION_SLAB)).add(this.reverseLookup(GCItems.DETAILED_METEORIC_IRON_DECORATION_SLAB))
                .add(this.reverseLookup(GCItems.STEEL_DECORATION_SLAB)).add(this.reverseLookup(GCItems.DETAILED_STEEL_DECORATION_SLAB))
                .add(this.reverseLookup(GCItems.TIN_DECORATION_SLAB)).add(this.reverseLookup(GCItems.DETAILED_TIN_DECORATION_SLAB));

        this.tag(ItemTags.STAIRS)
                .add(this.reverseLookup(GCItems.ALUMINUM_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.DETAILED_ALUMINUM_DECORATION_STAIRS))
                .add(this.reverseLookup(GCItems.BRONZE_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.DETAILED_BRONZE_DECORATION_STAIRS))
                .add(this.reverseLookup(GCItems.COPPER_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.DETAILED_COPPER_DECORATION_STAIRS))
                .add(this.reverseLookup(GCItems.DARK_DECORATION_STAIRS))
                .add(this.reverseLookup(GCItems.IRON_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.DETAILED_IRON_DECORATION_STAIRS))
                .add(this.reverseLookup(GCItems.METEORIC_IRON_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.DETAILED_METEORIC_IRON_DECORATION_STAIRS))
                .add(this.reverseLookup(GCItems.STEEL_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.DETAILED_STEEL_DECORATION_STAIRS))
                .add(this.reverseLookup(GCItems.TIN_DECORATION_STAIRS)).add(this.reverseLookup(GCItems.DETAILED_TIN_DECORATION_STAIRS));

        this.tag(ItemTags.WALLS)
                .add(this.reverseLookup(GCItems.ALUMINUM_DECORATION_WALL)).add(this.reverseLookup(GCItems.DETAILED_ALUMINUM_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.BRONZE_DECORATION_WALL)).add(this.reverseLookup(GCItems.DETAILED_BRONZE_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.COPPER_DECORATION_WALL)).add(this.reverseLookup(GCItems.DETAILED_COPPER_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.DARK_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.IRON_DECORATION_WALL)).add(this.reverseLookup(GCItems.DETAILED_IRON_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.METEORIC_IRON_DECORATION_WALL)).add(this.reverseLookup(GCItems.DETAILED_METEORIC_IRON_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.STEEL_DECORATION_WALL)).add(this.reverseLookup(GCItems.DETAILED_STEEL_DECORATION_WALL))
                .add(this.reverseLookup(GCItems.TIN_DECORATION_WALL)).add(this.reverseLookup(GCItems.DETAILED_TIN_DECORATION_WALL));

        this.tag(ConventionalItemTags.ORES)
                .addTag(GCTags.RAW_ALUMINUM_ORES).addTag(GCTags.RAW_LEAD_ORES).addTag(GCTags.RAW_TIN_ORES);
        // TODO: fill in ^^
    }
}
