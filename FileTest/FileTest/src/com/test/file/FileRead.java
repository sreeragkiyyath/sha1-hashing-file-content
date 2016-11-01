package com.test.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class FileRead extends FileIn {

    public static byte[] read(File file) {
        byte[] data = null;
      
        if (file.exists()) {

            try {
                FileIn fis = new FileIn(file);
                data = new byte[fis.available()];
                
                fis.read(data,0,10);
                
                System.out.println(new String(data));
               
               fis.read(data, data.length - (10), data.length);
                
                System.out.println(data.length);
                fis.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileRead.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FileRead.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            JOptionPane.showMessageDialog(null, "FileNot Found !");
        }
        return data;
    }
    
}
