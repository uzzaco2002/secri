package maemesoft.entities.maeme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.world.World;
import maemesoft.Maeme;
import maemesoft.client.ServerStorageDisplay;
import maemesoft.client.models.objHandling.ModelObj;
import maemesoft.client.models.objHandling.Object3D;
import maemesoft.enums.EnumPokemon;

public abstract class Entity2HasModel extends Entity1Base {

	@SideOnly(Side.CLIENT)
	ModelBase model;
	@SideOnly(Side.CLIENT)
	public float animationNum1 = 0f;
	@SideOnly(Side.CLIENT)
	public int animationCounter = 0;
	@SideOnly(Side.CLIENT)
	public int animationIncrement = 2;
	@SideOnly(Side.CLIENT)
	public int animationLimit = 360;
	@SideOnly(Side.CLIENT)
	public int animationCounter2 = 0;
	@SideOnly(Side.CLIENT)
	public int animationIncrement2 = 3;
	@SideOnly(Side.CLIENT)
	public int animationLimit2 = 360;

	public Entity2HasModel(World par1World) {
		super(par1World);
	}

	protected void init(String name) {
		super.init(name);
		oldName = name;
	}

	public void evolve(String evolveTo) {
		if (!EnumPokemon.hasPokemon(evolveTo))
			return;
		setName(evolveTo);
	}

	@SideOnly(Side.CLIENT)
	public ModelBase getModel(){
		if (model ==null) loadModel();
		return model;
	}

	@SideOnly(Side.CLIENT)
	void loadModel() {
		if (Maeme.proxy.getModels().length == 0)
			return;
		int n = ((Entity3HasStats) this).baseStats.nationalPokedexNumber;
		if (Maeme.proxy.getModels()[n] != null) {
			Object mod = Maeme.proxy.getModels()[n];
			if (mod instanceof ModelBase)
				model = (ModelBase) mod;
		} else {
			ModelBase m = Maeme.proxy.loadModel(getName());
			Maeme.proxy.getModels()[n] = m;
			model = m;
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean transformed;
	@SideOnly(Side.CLIENT)
	String transformedModel;
	@SideOnly(Side.CLIENT)
	public void transform(String transformedModel) {
		transformed = true;
		this.transformedModel = transformedModel;
		ModelBase m = Maeme.proxy.loadModel(transformedModel);
		model = m;
	}

	String oldName;

	public float getScaleFactor() {
		return getGrowth().scaleValue * getBossMode().scaleFactor;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (worldObj.isRemote && !oldName.equals(getName())) {
			isInitialised = false;
			((Entity3HasStats) this).getBaseStats(getName());
			model = null;
			oldName = getName();
		}
		if (worldObj.isRemote) {
			animationCounter = animationCounter + animationIncrement;
			if (animationCounter >= animationLimit)
				animationCounter = 0;
			animationCounter2 = animationCounter2 + animationIncrement2;
			if (animationCounter2 >= animationLimit2)
				animationCounter2 = 0;
		}

	}
}