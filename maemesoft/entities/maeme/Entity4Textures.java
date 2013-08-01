package maemesoft.entities.maeme;

import java.io.File;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.texturepacks.TexturePackDefault;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import maemesoft.entities.maeme.particleEffects.ParticleEffects;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class Entity4Textures extends Entity3HasStats {
	public float maxScale = 1.25F;
	public float hoverTimer;
	public boolean alreadyInitialised = false;
	private ParticleEffects particleEffects;

	public Entity4Textures(World par1World) {
		super(par1World);
		dataWatcher.addObject(25, (short) 0); // shiny
		dataWatcher.addObject(26, (short) 0); // roasted
		dataWatcher.addObject(18, (short) 0); // red
	}

	protected void init(String name) {
		super.init(name);
		if (!worldObj.isRemote) {
			if (rand.nextFloat() < 1 / 8192f) {
				dataWatcher.updateObject(25, (short) 1);
			}
		}
		alreadyInitialised = true;

		if (worldObj.isRemote)
			particleEffects = ParticleEffects.getParticleEffects(this);
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {
		if (par1DamageSource.isFireDamage())
			dataWatcher.updateObject(26, (short) 1);
		return super.attackEntityFrom(par1DamageSource, par2);
	}

	boolean hasRoastedTexture = false;
	boolean checkedForRoastedTexture = false;

	@SideOnly(Side.CLIENT)
	@Override
	public String getTexture() {
		try {
			if (dataWatcher.getWatchableObjectShort(26) == (short) 1 && !checkedForRoastedTexture || hasRoastedTexture) {
				if (!checkedForRoastedTexture) {
					if (TexturePackDefault.class.getResourceAsStream("/maemesoft/texture/pokemon/roasted" + getName().toLowerCase() + ".png") != null)
						hasRoastedTexture = true;
					checkedForRoastedTexture = true;
				}
			}
			if (getIsShiny()
					&& Minecraft.getMinecraft().renderEngine.texturePack.getSelectedTexturePack().getResourceAsStream(
							"/maemesoft/texture/pokemon/shiny" + getName().toLowerCase() + ".png") != null)
				return "/maemesoft/texture/pokemon/shiny" + getName().toLowerCase() + ".png";
			else if (dataWatcher.getWatchableObjectShort(26) == (short) 1 && hasRoastedTexture) {
				return "/maemesoft/texture/pokemon/roasted" + getName().toLowerCase() + ".png";
			} else
				return "/maemesoft/texture/pokemon/" + getName().toLowerCase() + ".png";
		} catch (Exception e) {
			return "";
		}
	}

	public boolean getIsShiny() {
		return dataWatcher.getWatchableObjectShort(25) == (short) 1;
	}

	public void setIsShiny(boolean isShiny) {
		if (isShiny)
			dataWatcher.updateObject(25, (short) 1);
		else
			dataWatcher.updateObject(25, (short) 0);
	}

	public boolean getIsRed() {
		return dataWatcher.getWatchableObjectShort(18) == (short) 1;
	}

	public void setIsRed(boolean isRed) {
		if (isRed)
			dataWatcher.updateObject(18, (short) 1);
		else
			dataWatcher.updateObject(18, (short) 0);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (worldObj.isRemote)
			if (particleEffects != null)
				particleEffects.onUpdate();
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		super.writeEntityToNBT(nbt);
		nbt.setBoolean("IsShiny", dataWatcher.getWatchableObjectShort(25) == (short) 1);
		nbt.setBoolean("IsRoasted", dataWatcher.getWatchableObjectShort(26) == (short) 1);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		super.readEntityFromNBT(nbt);
		dataWatcher.updateObject(25, nbt.getBoolean("IsShiny") ? (short) 1 : (short) 0);
		dataWatcher.updateObject(26, nbt.getBoolean("IsRoasted") ? (short) 1 : (short) 0);
		alreadyInitialised = true;
	}
}