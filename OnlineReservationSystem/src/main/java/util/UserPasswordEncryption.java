package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserPasswordEncryption {
    public String passwordEncryption(String password) {
        StringBuilder buildPW = new StringBuilder();
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.digest(password.getBytes());
            byte[] passwordAsBytes = messageDigest.digest();

            for (byte passwordAsByte : passwordAsBytes) {
                buildPW.append(Integer.toString(passwordAsByte & 0xff + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException nsae) {
            System.err.println(nsae.getMessage());
        }
        return String.valueOf(buildPW);
    }
}
