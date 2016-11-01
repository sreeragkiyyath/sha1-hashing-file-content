package com.security;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Security {

   

    public static byte[] encrypt(byte[] data) throws Exception {
        java.security.MessageDigest d = null;
        d = java.security.MessageDigest.getInstance("SHA-1");
        d.reset();
        d.update(data);
        return d.digest();
    }
}
