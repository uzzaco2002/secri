package maemesoft.skin;

import java.io.*;
import java.net.*;
import java.util.*;

import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.entity.player.EntityPlayer;

public class HDSkinHandler {
	private static Minecraft mc1;
	private static String SkinURL;
	private static String CapeURL;
	
	private static Thread linkedThread;
	
	public static void initSkins(){
		if(linkedThread == null){
		System.out.println("HD Skins mod has started a new thread.");
		linkedThread = new SkinUpdateThread();
		}
	}
	
	
	public static void updateSkins(World world){
		List<EntityPlayer> players = world.playerEntities;
		for(EntityPlayer p : players){

			
		if(p.skinUrl!="http://home.maemesoft.wo.tc:25564/MinecraftSkins/" + p.username + ".png"){
				
			try{	
				
				
			SkinURL = "http://home.maemesoft.wo.tc:25564/MinecraftSkins/" + p.username + ".png";
		
			URL url = new URL(SkinURL);
		
			HttpURLConnection con = ((HttpURLConnection) url.openConnection());
			con.setConnectTimeout(1000);
			con.setRequestMethod("HEAD");
			try{
			int responseCode = con.getResponseCode();
				if  (responseCode ==200){

						p.skinUrl = SkinURL;

						
						p.worldObj.obtainEntitySkin(p);
						
					
					
				
				

				}else{
					SkinURL = "http://home.maemesoft.wo.tc:25564/MinecraftSkins/" + p.username + ".png";

						p.skinUrl = SkinURL;

						p.worldObj.obtainEntitySkin(p);
						
					
				}
			}catch (SocketTimeoutException ste){
				SkinURL = "http://home.maemesoft.wo.tc:25564/MinecraftSkins/" + p.username + ".png";

						p.skinUrl = SkinURL;

						p.worldObj.obtainEntitySkin(p);
						
				
			}
			}catch (IOException e){
				SkinURL = "http://home.maemesoft.wo.tc:25564/MinecraftSkins/" + p.username + ".png";

						p.skinUrl = SkinURL;

						p.worldObj.obtainEntitySkin(p);
						
				
			}
			
			
			
			p.cloakUrl = "http://home.maemesoft.wo.tc:25564/MinecraftCloaks/" + p.username + ".png";
			p.cloakUrl = p.cloakUrl;
			
			mc1 = ModLoader.getMinecraftInstance();;
			
			mc1.renderEngine.obtainImageData(p.cloakUrl, new ImageBufferDownload());
			
			
			}
		}
	}
	
	
	public static void forceUpdateSkins(World world){
		List<EntityPlayer> players = world.playerEntities;
		for(EntityPlayer p : players){
			
		
			
		if(p.skinUrl!="http://home.maemesoft.wo.tc:25564/MinecraftSkins/" + p.username + ".png"){
				
			try{	
				
				
			SkinURL = "http://home.maemesoft.wo.tc:25564/MinecraftSkins/" + p.username + ".png";
		
			URL url = new URL(SkinURL);
		
			HttpURLConnection con = ((HttpURLConnection) url.openConnection());
			con.setConnectTimeout(1000);
			con.setRequestMethod("HEAD");
			try{
			int responseCode = con.getResponseCode();
				if  (responseCode ==200){
		

						p.skinUrl = SkinURL;

						p.worldObj.releaseEntitySkin(p);
						p.worldObj.obtainEntitySkin(p);
						
					
					
				
				

				}else{
					SkinURL = "http://home.maemesoft.wo.tc:25564/MinecraftSkins/" + p.username + ".png";

						p.skinUrl = SkinURL;
						
						p.worldObj.releaseEntitySkin(p);
						p.worldObj.obtainEntitySkin(p);
						
					
					
				}
			}catch (SocketTimeoutException ste){
				SkinURL = "http://home.maemesoft.wo.tc:25564/MinecraftSkins/" + p.username + ".png";

						p.skinUrl = SkinURL;

						p.worldObj.releaseEntitySkin(p);
						p.worldObj.obtainEntitySkin(p);
						
				
			}
			}catch (IOException e){
				SkinURL = "http://home.maemesoft.wo.tc:25564/MinecraftSkins/" + p.username + ".png";

						p.skinUrl = SkinURL;

						p.worldObj.releaseEntitySkin(p);
						p.worldObj.obtainEntitySkin(p);
						
				
			}
			
			
			
			p.cloakUrl = "http://home.maemesoft.wo.tc:25564/MinecraftCloaks/" + p.username + ".png";
			p.cloakUrl = p.cloakUrl;
			
			mc1 = ModLoader.getMinecraftInstance();;
			
			mc1.renderEngine.obtainImageData(p.cloakUrl, new ImageBufferDownload());
			
			
			}else{
				p.worldObj.releaseEntitySkin(p);
				p.worldObj.obtainEntitySkin(p);
			}
		}
	}
	
}


