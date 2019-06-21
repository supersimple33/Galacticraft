package com.hrznstudio.galacticraft.blocks.machines.circuitfabricator;

import com.hrznstudio.galacticraft.Constants;
import com.hrznstudio.galacticraft.api.screen.MachineContainerScreen;
import com.hrznstudio.galacticraft.energy.GalacticraftEnergyType;
import com.hrznstudio.galacticraft.util.DrawableUtils;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.ChatFormat;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/StellarHorizons">StellarHorizons</a>
 */
public class CircuitFabricatorScreen extends MachineContainerScreen {

    private static final Identifier BACKGROUND = new Identifier(Constants.MOD_ID, Constants.ScreenTextures.getRaw(Constants.ScreenTextures.CIRCUIT_FABRICATOR_SCREEN));
    private static final Identifier CONFIG_TABS = new Identifier(Constants.MOD_ID, Constants.ScreenTextures.getRaw(Constants.ScreenTextures.MACHINE_CONFIG_TABS));
    private static final Identifier OVERLAY = new Identifier(Constants.MOD_ID, Constants.ScreenTextures.getRaw(Constants.ScreenTextures.OVERLAY));

    private static final int ENERGY_X = Constants.TextureCoordinates.ENERGY_LIGHT_X;
    private static final int ENERGY_Y = Constants.TextureCoordinates.ENERGY_LIGHT_Y;
    private static final int ENERGY_WIDTH = Constants.TextureCoordinates.OVERLAY_WIDTH;
    private static final int ENERGY_HEIGHT = Constants.TextureCoordinates.OVERLAY_HEIGHT;
    private static final int ENERGY_DIMMED_X = Constants.TextureCoordinates.ENERGY_DARK_X;
    private static final int ENERGY_DIMMED_Y = Constants.TextureCoordinates.ENERGY_DARK_Y;
    private static final int ENERGY_DIMMED_WIDTH = Constants.TextureCoordinates.OVERLAY_WIDTH;
    private static final int ENERGY_DIMMED_HEIGHT = Constants.TextureCoordinates.OVERLAY_HEIGHT;

    private static final int PROGRESS_X = 206;
    private static final int PROGRESS_Y = 0;
    private static final int PROGRESS_WIDTH = 50;
    private static final int PROGRESS_HEIGHT = 10;
    private static final int CONFIG_TAB_X = 0;
    private static final int CONFIG_TAB_Y = 69;
    private static final int CONFIG_TAB_WIDTH = 22;
    private static final int CONFIG_TAB_HEIGHT = 22;
    BlockPos blockPos;
    private int energyDisplayX;
    private int energyDisplayY;
    private int progressDisplayX;
    private int progressDisplayY;
    private World world;


    public CircuitFabricatorScreen(int syncId, BlockPos blockPos, PlayerEntity playerEntity) {
        super(new CircuitFabricatorContainer(syncId, blockPos, playerEntity), playerEntity.inventory, playerEntity.world, blockPos, new TranslatableComponent("ui.galacticraft-rewoven.circuit_fabricator.name"));
        this.blockPos = blockPos;
        this.world = playerEntity.world;
        this.containerHeight = 192;
    }

    @Override
    protected void drawBackground(float v, int mouseX, int mouseY) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.renderBackground();
        this.minecraft.getTextureManager().bindTexture(BACKGROUND);

        int leftPos = this.left;
        int topPos = this.top;

        energyDisplayX = leftPos + 10;
        energyDisplayY = topPos + 35;
        progressDisplayX = leftPos + 90;
        progressDisplayY = topPos + 82;

        //this.drawTexturedRect(...)
        this.blit(leftPos, topPos, 0, 0, this.containerWidth, this.containerHeight + 26);
        this.drawEnergyBufferBar();

        this.drawProgressBar();
        this.drawConfigTabs();
    }

    @Override
    public void render(int mouseX, int mouseY, float v) {
        super.render(mouseX, mouseY, v);
        DrawableUtils.drawCenteredString(this.minecraft.textRenderer, new TranslatableComponent("block.galacticraft-rewoven.circuit_fabricator").getText(), (this.width / 2), this.top + 5, ChatFormat.DARK_GRAY.getColor());
        this.drawMouseoverTooltip(mouseX, mouseY);
    }

    private void drawEnergyBufferBar() {
        float currentEnergy = (float) ((CircuitFabricatorBlockEntity) world.getBlockEntity(blockPos)).getEnergy().getCurrentEnergy();
        float maxEnergy = (float) ((CircuitFabricatorBlockEntity) world.getBlockEntity(blockPos)).getEnergy().getMaxEnergy();
        float energyScale = (currentEnergy / maxEnergy);

        //this.drawTexturedReact(...)
        this.minecraft.getTextureManager().bindTexture(OVERLAY);
        this.blit(energyDisplayX, energyDisplayY, ENERGY_DIMMED_X, ENERGY_DIMMED_Y, ENERGY_DIMMED_WIDTH, ENERGY_DIMMED_HEIGHT);
        this.blit(energyDisplayX, (energyDisplayY - (int) (ENERGY_HEIGHT * energyScale)) + ENERGY_HEIGHT, ENERGY_X, ENERGY_Y, ENERGY_WIDTH, (int) (ENERGY_HEIGHT * energyScale));
    }

    private void drawProgressBar() {
        float progress = (float) ((CircuitFabricatorBlockEntity) world.getBlockEntity(blockPos)).getProgress();
        float maxProgress = (float) ((CircuitFabricatorBlockEntity) world.getBlockEntity(blockPos)).getMaxProgress();
        float progressScale = (progress / maxProgress);

        this.minecraft.getTextureManager().bindTexture(BACKGROUND);
        this.blit(progressDisplayX, progressDisplayY, PROGRESS_X, PROGRESS_Y, (int) (PROGRESS_WIDTH * progressScale), PROGRESS_HEIGHT);
    }

    @Override
    public void drawMouseoverTooltip(int mouseX, int mouseY) {
        super.drawMouseoverTooltip(mouseX, mouseY);
        if (mouseX >= energyDisplayX && mouseX <= energyDisplayX + ENERGY_WIDTH && mouseY >= energyDisplayY && mouseY <= energyDisplayY + ENERGY_HEIGHT) {
            List<String> toolTipLines = new ArrayList<>();
            toolTipLines.add(new TranslatableComponent("ui.galacticraft-rewoven.machine.status", ((CircuitFabricatorBlockEntity) world.getBlockEntity(blockPos)).status.toString()).setStyle(new Style().setColor(ChatFormat.GRAY)).getFormattedText());
            toolTipLines.add("\u00A76" + new TranslatableComponent("ui.galacticraft-rewoven.machine.current_energy", new GalacticraftEnergyType().getDisplayAmount(((CircuitFabricatorBlockEntity) world.getBlockEntity(blockPos)).getEnergy().getCurrentEnergy()).setStyle(new Style().setColor(ChatFormat.BLUE))).getFormattedText() + "\u00A7r");
            toolTipLines.add("\u00A7c" + new TranslatableComponent("ui.galacticraft-rewoven.machine.max_energy", new GalacticraftEnergyType().getDisplayAmount(((CircuitFabricatorBlockEntity) world.getBlockEntity(blockPos)).getEnergy().getMaxEnergy())).getFormattedText() + "\u00A7r");

            this.renderTooltip(toolTipLines, mouseX, mouseY);
        }
        if (mouseX >= this.left - 22 && mouseX <= this.left && mouseY >= this.top + 2 && mouseY <= this.top + (22 + 2)) {
            this.renderTooltip("\u00A77" + new TranslatableComponent("ui.galacticraft-rewoven.tabs.side_config").getText(), mouseX, mouseY);
        }
    }
}
