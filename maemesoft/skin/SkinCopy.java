package maemesoft.skin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
 
public class SkinCopy {
 
    static void fileCopy(String from, String to) throws Exception {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel in = null;
        FileChannel out = null;
         
        try{
            fis = new FileInputStream(from);
            fos = new FileOutputStream(to);
            in = fis.getChannel();
            out = fos.getChannel();
 
            //MappedByteBuffer를 사용하여 복사하는 방법
            /*
            MappedByteBuffer m = in.map(
                FileChannel.MapMode.READ_ONLY, 0, in.size());
            out.write(m);
            */
 
            //메모리를 사용하여 복사하는 방법
            in.transferTo(0, in.size(), out);
             
        }catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        } finally {
            if(out != null) out.close();
            if(in != null) in.close();
            if(fos != null) fos.close();
            if(fis != null) fis.close();
        }
    }
}