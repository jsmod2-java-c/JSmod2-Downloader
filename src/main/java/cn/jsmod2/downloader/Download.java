package cn.jsmod2.downloader;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Download {


    public static void main(String[] args) {

        try{
            String file = Download.class.getProtectionDomain().getCodeSource().getLocation().getFile();
            file = file.substring(0,file.lastIndexOf("/")+1);
            String url1 = "http://plugins.noyark.net/web/jsmod2.jar";
            URL url = new URL(url1);
            URLConnection connection = url.openConnection();
            InputStream stream = connection.getInputStream();
            FileOutputStream stream1 = new FileOutputStream(file+"/jsmod2.jar");
            byte[] buffer = new byte[1204];
            int byteRead;
            int have = 0;
            int total = 0;
            while ((byteRead = stream.read(buffer))!=-1){
                total += stream.available();
                have += byteRead;
                System.out.println("Downloading the JSmod2 ["+have+"/"+total+"]");
                stream1.write(buffer,0,byteRead);
            }
            System.out.println("Download Successfully");
            stream1.close();
            stream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
