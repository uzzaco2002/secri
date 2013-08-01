package maemesoft.skin;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import net.minecraft.entity.player.EntityPlayerMP;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import cpw.mods.fml.common.network.Player;

public class SkinUpload {
 
 public static final void simpleSendFileToFTP(String targetUrl , String id , String pwd , String port , String realSaveLocation , String fname , String player) throws Exception {
  File file = new File("C:/Users/Ha/Desktop/birth/" + fname + ".png");
  File fileto = new File("C:/Users/Ha/Desktop/birth/" + player + ".png");
  file.renameTo(fileto);
  FTPClient client = null;
  BufferedInputStream bis = null;
  try {
   client = new FTPClient();
   /*
   FTPClientConfig config = new FTPClientConfig();  
   config.setServerLanguageCode("ko");
   config.setDefaultDateFormatStr("MM월 d일 HH:mm");
   config.setRecentDateFormatStr("MM웡 d일 HH:mm");
   client.configure(config);
   */
   client.setControlEncoding("euc-kr");
   client.connect(targetUrl , Integer.parseInt(port));
   int resultCode = client.getReplyCode();
   
   if(FTPReply.isPositiveCompletion(resultCode) == false){
    throw new Exception("FTP 서버에 연결할 수 없습니다.");
   }
   else {
    client.setSoTimeout(5000);
    boolean isLogin = client.login(id, pwd);
    if(isLogin == false) {
     throw new Exception("FTP 서버에 로그인 할 수 없습니다.");
    }
    client.setFileType(FTP.BINARY_FILE_TYPE);
    
    String[] locArr = realSaveLocation.split("/");
    String savaLoc = "";
    
    for(int i =0 ; i<locArr.length ; i++) {
     savaLoc = savaLoc + locArr[i] + "/";
     client.makeDirectory(savaLoc);
    }
    
    bis = new BufferedInputStream(new FileInputStream(fileto));
    boolean  isSuc = client.storeFile(savaLoc+fileto.getName(), bis);
    fileto.renameTo(file);
    //System.out.println("파일 전송 성공여부 : "+isSuc);
    if(isSuc == false) {
     throw new Exception("파일 업로드에 실패 하였습니다.");
    }
    /*
    FTPFile[] list =  client.listFiles();
    for(int i=0 ; i<list.length ; i++) {
     try{
     System.out.println(list[i].toString());
     }catch (Exception e) {
     }
    }
    */
    client.logout();
   }
  } catch (Exception e) {
   e.printStackTrace();
   throw e;
  }
  finally {
   
   if(bis != null) {
    try {bis.close(); } catch (Exception e) { } 
   }
   if(client != null && client.isConnected()) {
    try { client.disconnect(); } catch (Exception e) {}
   }
  }
  
 }
 
}