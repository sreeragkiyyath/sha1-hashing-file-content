/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.file;

import com.security.Security;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class Main {

    public static void main(String[] args) throws IOException {
        JFileChooser chooser = new JFileChooser();
        int showOpenDialog = chooser.showOpenDialog(chooser);
        if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
            try {
                FileIn file = new FileIn(chooser.getSelectedFile());
                byte[] header = Security.encrypt(file.readValueAtFirst(4));
                byte[] footer = Security.encrypt(file.readValueAtLast(4));
                byte[] body = file.read();
                
                System.out.println(new String(header));
                System.out.println(new String(body));
                System.out.println(new String(footer));
                //            FileIn file3 = new FileIn(chooser.getSelectedFile());
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
    }
}
