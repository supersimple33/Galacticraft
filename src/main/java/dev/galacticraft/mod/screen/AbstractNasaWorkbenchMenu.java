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

package dev.galacticraft.mod.screen;

import javax.management.MBeanAttributeInfo;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

/**
 * @author <a href="https://github.com/TeamGalacticraft">TeamGalacticraft</a>
 */
public abstract class AbstractNasaWorkbenchMenu extends AbstractContainerMenu { // I think this is the right superclass? // statics?
    protected final RecipeType<? extends Recipe> recipeType;
    protected final int menuHeight;
    protected final CraftingContainer craftSlots;
    protected final Inventory inventory;

    protected AbstractNasaWorkbenchMenu(int syncId, Inventory inv, MenuType<? extends AbstractNasaWorkbenchMenu> rocketWorkbenchMenu, int menuHeight, int craftSlots, RecipeType<? extends Recipe> recipeType) { // THIS ONLY EXECUTES ON SERVER WE CAN SAFELY CAST PLAYER TO SERVERPLAYER
        // I think we need to communicate with the server here?d
        super(rocketWorkbenchMenu, syncId);

        this.menuHeight = menuHeight;
        this.recipeType = recipeType;
        this.craftSlots = new CraftingContainer(this, craftSlots, 1);
        this.inventory = inv;

        // Connect Inventory
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(inv, i, 0 + 8 + i * 18, this.menuHeight - 24));
        }
        for (int i = 2; i >= 0; --i) { // we are gonna make this work irregardless of size
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inv, j + (i + 1) * 9, 0 + 8 + j * 18, this.menuHeight - 82 + i * 18));
            }
        }
    }

    protected abstract boolean validForBlueprintSpot(int index, ItemStack stack); // int index or Slot slot?

    @Override
    public boolean stillValid(Player player) {
        // TODO Auto-generated method stub
        // return true; // should do up call to protected static AbstractNasaWorkbenchMenu.stillValid
        return this.craftSlots.stillValid(player); // not great here?
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) { // null check for slot needed?
            ItemStack itemStack2 = slot.getItem();
            itemStack = itemStack2.copy();
            if (index <= 35) { // technically should not hardcode this since other mods may change inventory size
                // Guard
                if (this.validForBlueprintSpot(index, itemStack2) && !this.moveItemStackTo(itemStack2, this.craftSlots.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemStack2, 0, this.craftSlots.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return itemStack;
    }
}
