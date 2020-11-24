package com.chinakalight.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 7/6/2020
 */
public class EncryptionExecution {
    public static void main(String[] args) throws Exception {

        RSAKeyPairGenerator keyPairGenerator = new RSAKeyPairGenerator();

        String privateKeyEncodedString = Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded());
        System.out.println("BEFORE WRITING TO FILE:\nPRIVATE-KEY: \n" + privateKeyEncodedString);
        String publicKeyEncodedString = Base64.getEncoder().encodeToString(keyPairGenerator.getPublicKey().getEncoded());
        System.out.println("PUBLIC-KEY: \n" + publicKeyEncodedString);

        keyPairGenerator.writePublicAndPrivateKeyToFile();
        PrivateKey tempPrivateKey = keyPairGenerator.readPrivateKeyFromFile("RSA/PrivateKey");
        PublicKey tempPublicKey = keyPairGenerator.readPublicKeyFromFile("RSA/PublicKey");

        String retrievedFromFilePrivateKey = Base64.getEncoder().encodeToString(tempPrivateKey.getEncoded());
        System.out.println("FROM FILE:\nPRIVATE-KEY: \n" + retrievedFromFilePrivateKey);
        String retrievedFromFilePublicKey = Base64.getEncoder().encodeToString(tempPublicKey.getEncoded());
        System.out.println("PUBLIC-KEY: \n" + retrievedFromFilePublicKey);

        System.out.println("\n\nPUBLIC-KEY-SAME: " + publicKeyEncodedString.equals(retrievedFromFilePublicKey));
        System.out.println("PRIVATE-KEY-SAME: " + privateKeyEncodedString.equals(retrievedFromFilePrivateKey));

        RSAEncryptionDecryption rsaEncryptionDecryption = new RSAEncryptionDecryption();
//
//        String originalAESSecretKey = "AES_SECRET_KEY_SAMPLE";
//        System.out.println("ORIGINAL-SECRET-KEY:::::::::::: \n" + originalAESSecretKey);
//        String rsaEncryptedSecretKey = rsaEncryptionDecryption.encryptWithPrivate(keyPairGenerator.getPrivateKey(), originalAESSecretKey);
//
//        System.out.println("\nENCRYPTED:::::::::::::::\n" + rsaEncryptedSecretKey);
//        String rsaDecryptedSecretKey = rsaEncryptionDecryption.decryptWithPublic(keyPairGenerator.getPublicKey(), rsaEncryptedSecretKey);
//        System.out.println("\nDECRYPTED:::::::::::::::\n" + rsaDecryptedSecretKey);


        String originalString = "DATA for AES TO ENCRYPT HERE BEFORE SENDING";
        System.out.println("ORIGINAL-DATA: " + originalString );
        String aesKeyStringBeforeEncryption = "aesEnc88783onKey";
        String aesKeyStringBeforeEncryptionIVSpec = "IVSpec88783onKey";
//        String combinedSpecIVSpec = aesKeyStringBeforeEncryption + "|" + aesKeyStringBeforeEncryptionIVSpec
        System.out.println("Original String to encrypt - " + aesKeyStringBeforeEncryption);
        String encryptedString = encrypt(originalString, initVector, aesKeyStringBeforeEncryption );
        System.out.println("Encrypted String -| " + encryptedString);

        // =============================PRIVATE ==>> PUBLIC ====================================================
        System.out.println("=============================PRIVATE ==>> PUBLIC ====================================================");
        System.out.println("ORIGINAL-SECRET-KEY:::::::::::: \n" + aesKeyStringBeforeEncryption);
        String newlyRsaEncryptedSecretKey = rsaEncryptionDecryption.encryptWithPrivate(keyPairGenerator.getPrivateKey(), aesKeyStringBeforeEncryption);

        System.out.println("\nENCRYPTED:::::::::::::::\n" + newlyRsaEncryptedSecretKey);
        String newlyRsaDecryptedSecretKey = rsaEncryptionDecryption.decryptWithPublic(keyPairGenerator.getPublicKey(), newlyRsaEncryptedSecretKey);
        System.out.println("\nDECRYPTED:::::::::::::::\n" + newlyRsaDecryptedSecretKey);
        System.out.println(" =================================================================================");
        //
        //
        System.out.println("  =============================PUBLIC ==>> PRIVATE ==================================================== ");
        System.out.println("ORIGINAL-SECRET-KEY:::::::::::: \n" + aesKeyStringBeforeEncryption);
        String newlyRsaEncryptedSecretKey1 = rsaEncryptionDecryption.encryptWithPublic(keyPairGenerator.getPublicKey(), aesKeyStringBeforeEncryption);

        System.out.println("\nENCRYPTED:::::::::::::::\n" + newlyRsaEncryptedSecretKey);
        String newlyRsaDecryptedSecretKey1 = rsaEncryptionDecryption.decryptWithPrivate(keyPairGenerator.getPrivateKey(), newlyRsaEncryptedSecretKey1);
        System.out.println("\nDECRYPTED:::::::::::::::\n" + newlyRsaDecryptedSecretKey);
        System.out.println(" ================================================================================= ");

        System.out.println("PUBLIC =>PRIVATE:  USING -DECRYPTED AES Secret Key using RSA!");
//        String encryptedAesKeyStringAfterEncryption =
        String decryptedString = decrypt(encryptedString, initVector, newlyRsaDecryptedSecretKey1);
        System.out.println("After decryption -| " + decryptedString);


        System.out.println("PRIVATE =>PUBLIC:  USING -DECRYPTED AES Secret Key using RSA!");
//        String encryptedAesKeyStringAfterEncryption =
        decryptedString = decrypt(encryptedString, initVector, newlyRsaDecryptedSecretKey);
        System.out.println("After decryption -| " + decryptedString);


    }


    private static  String key = "aesEncryptionKey";
    private static  String initVector = "encryptionIntVec";

    public static String encrypt(String value, String initVectorH, String aesSecretKey) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVectorH.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(aesSecretKey.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void encryptFile(String originalFilePath, String toBeEncryptedOutputFilePath) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            processFile(cipher, originalFilePath, toBeEncryptedOutputFilePath);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String decrypt(String encrypted, String initVectorH, String aesSecretKey) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVectorH.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(aesSecretKey.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void decryptFile(String encryptedFilePath, String decryptedFilePath) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            processFile(cipher, encryptedFilePath, decryptedFilePath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static private void processFile(Cipher ci,String inFile,String outFile)
            throws javax.crypto.IllegalBlockSizeException,
            javax.crypto.BadPaddingException,
            java.io.IOException
    {
        try (FileInputStream in = new FileInputStream(inFile);
             FileOutputStream out = new FileOutputStream(outFile)) {
            byte[] ibuf = new byte[1024];
            int len;
            while ((len = in.read(ibuf)) != -1) {
                byte[] obuf = ci.update(ibuf, 0, len);
                if ( obuf != null ) out.write(obuf);
            }
            byte[] obuf = ci.doFinal();
            if ( obuf != null ) out.write(obuf);
        }
    }

//    public static void main(String[] args) {
//        String originalString = "passwordLight";
//        System.out.println("Original String to encrypt - " + originalString);
//        String encryptedString = encrypt(originalString);
//        System.out.println("Encrypted String - " + encryptedString);
//        String decryptedString = decrypt(encryptedString);
//        System.out.println("After decryption - " + decryptedString);
//    }

}
