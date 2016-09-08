package com.encuestas.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtils {


  public static String encodeMd5String(String value) {
    String data = "";

    MessageDigest digester;
    try {
      digester = MessageDigest.getInstance("MD5");
      digester.update(value.getBytes());
      byte[] hash = digester.digest();
      StringBuffer hexString = new StringBuffer();
      for (int i = 0; i < hash.length; i++) {
        if ((0xff & hash[i]) < 0x10) {
          hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
        } else {
          hexString.append(Integer.toHexString(0xFF & hash[i]));
        }
      }
      data = hexString.toString();
    } catch (NoSuchAlgorithmException e) {}
    return data;
  }
}
