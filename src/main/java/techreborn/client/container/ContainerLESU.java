/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2017 TechReborn
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

package techreborn.client.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import reborncore.client.gui.slots.BaseSlot;
import reborncore.common.container.RebornContainer;
import techreborn.config.ConfigTechReborn;
import techreborn.tiles.lesu.TileLesu;

public class ContainerLESU extends RebornContainer {

	public int euOut;
	public int storedEu;
	public int euChange;
	public int connectedBlocks;
	public double euStorage;
	EntityPlayer player;
	TileLesu tile;

	public ContainerLESU(TileLesu tileaesu, EntityPlayer player) {
		tile = tileaesu;
		this.player = player;

		// input
		this.addSlotToContainer(new BaseSlot(tileaesu.inventory, 0, 116, 23));
		this.addSlotToContainer(new BaseSlot(tileaesu.inventory, 1, 116, 59));

		int i;

		for (i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new BaseSlot(player.inventory, j + i * 9 + 9, 8 + j * 18, 115 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i) {
			this.addSlotToContainer(new BaseSlot(player.inventory, i, 8 + i * 18, 173));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for (int i = 0; i < this.listeners.size(); i++) {
			IContainerListener IContainerListener = this.listeners.get(i);
			if (this.euOut != tile.getMaxOutput()) {
				IContainerListener.sendProgressBarUpdate(this, 0, (int) tile.getMaxOutput());
			}
			if (this.storedEu != tile.getEnergy()) {
				IContainerListener.sendProgressBarUpdate(this, 1, (int) tile.getEnergy());
			}
			if (this.euChange != tile.getEuChange() && tile.getEuChange() != -1) {
				IContainerListener.sendProgressBarUpdate(this, 2, (int) tile.getEuChange());
			}
			if (this.connectedBlocks != tile.connectedBlocks) {
				IContainerListener.sendProgressBarUpdate(this, 3, tile.connectedBlocks);
			}
		}
	}

	@Override
	public void addListener(IContainerListener crafting) {
		super.addListener(crafting);
		crafting.sendProgressBarUpdate(this, 0, (int) tile.getMaxOutput());
		crafting.sendProgressBarUpdate(this, 1, (int) tile.getEnergy());
		crafting.sendProgressBarUpdate(this, 2, (int) tile.getEuChange());
		crafting.sendProgressBarUpdate(this, 3, tile.connectedBlocks);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void updateProgressBar(int id, int value) {
		if (id == 0) {
			this.euOut = value;
		} else if (id == 1) {
			this.storedEu = value;
		} else if (id == 2) {
			this.euChange = value;
		} else if (id == 3) {
			this.connectedBlocks = value;
		} else if (id == 4) {
			this.euStorage = value;
		}
		this.euStorage = ((connectedBlocks + 1) * TileLesu.storagePerBlock);
	}

}
