/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.file;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileIn {

    private FileInputStream fileInputStream = null;
    private byte[] data = null;
    FileIn(File file) throws IOException {
        try {
            fileInputStream = new FileInputStream(file);
            data = new byte[fileInputStream.available()];
            fileInputStream.read(data);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public byte[] readValueAt(int startpos, int stop) throws IOException {
        ByteArrayBuffer bb = new ByteArrayBuffer(data);
        InputStream is = bb.newInputStream();
        byte[] b = new byte[1];
        int l = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while (is.read(b) != -1) {
            l++;
            if (startpos <= l && l <= stop) {
                bos.write(b);
            }
        }
        return bos.toByteArray();
    }

    public byte[] readValueAtLast(int limit) throws IOException {
        return readValueAt(data.length - (limit-1), data.length + 1);
    }

    public byte[] readValueAtFirst(int limit) throws IOException {
        return readValueAt(0, limit);
    }
    public byte[] read() throws IOException {
        return data;
    }
    
}
