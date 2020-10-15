package com.chinakalight.encrypt2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileOutputStream;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;


/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 7/7/2020
 */
public class AesEncyrpt {

    private  String key;
    private  String initVector;
    private PublicKey pubKey;
    private PrivateKey privateKey;

    private final SecretKey skey;
    private final IvParameterSpec ivspec;

    public AesEncyrpt(){
        //Generate AES_ENCRYPTION SECRET KEY
        KeyGenerator kgen = null;
        try {
            kgen = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        kgen.init(128);
        skey = kgen.generateKey();
//        this.key = Base64.getEncoder().encodeToString(skey.getEncoded());
        this.key = Base64.getEncoder().encodeToString(skey.getEncoded());
        this.key = this.key.substring(this.key.length() - 16);

        SecureRandom secureRandom = new SecureRandom();
        byte[] iv = new byte[128/8];
        secureRandom.nextBytes(iv);
        ivspec = new IvParameterSpec(iv);
        this.initVector = Base64.getEncoder().encodeToString(ivspec.getIV());
        this.initVector = this.initVector.substring(this.initVector.length() - 16);

        this.key = "I Will Come Home";
        this.initVector = "Where are you so";

        System.out.println(Arrays.toString(skey.getEncoded()));
        System.out.println(Arrays.toString(ivspec.getIV()));
    }

    public AesEncyrpt(String aesKey){
        //Generate AES_ENCRYPTION SECRET KEY
        KeyGenerator kgen = null;
        try {
            kgen = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        kgen.init(128);
        skey = kgen.generateKey();
        this.key = skey.toString();

        SecureRandom secureRandom = new SecureRandom();
        byte[] iv = new byte[128/8];
        secureRandom.nextBytes(iv);
        ivspec = new IvParameterSpec(iv);
        this.initVector = ivspec.toString();
    }

    public void loadRSAPrivateKey(String pvtKeyFilePath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] bytes = Files.readAllBytes(Paths.get(pvtKeyFilePath));
        PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        privateKey = kf.generatePrivate(ks);
    }

    public void loadRSAPublicKey(String pubKeyFilePath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] bytes = Files.readAllBytes(Paths.get(pubKeyFilePath));
        PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        pubKey = kf.generatePublic(ks);
    }

    public void encryptSaveSecretKey(String toBeEncrptedAesSecretKeyFilePath) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        FileOutputStream out = new FileOutputStream(toBeEncrptedAesSecretKeyFilePath + ".enc");
        {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, this.pubKey ); // Encrypt using B's public key
            byte[] b = cipher.doFinal(this.skey.getEncoded());
            out.write(b);
        }

        out.write(this.ivspec.getIV());
    }

    public String encrypt(String value) {
        try {
            System.out.println("INIT_VECTOR::::: " + initVector);
            System.out.println("KEY::::: " + key);
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void encryptFile(String originalFilePath, String toBeEncryptedOutputFilePath) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
//            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

            processFileEncryption2(cipher, originalFilePath, toBeEncryptedOutputFilePath);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String decrypt(String encrypted) {
        try {
            System.out.println("KEY-LENGTH: " + key.length());
            System.out.println("initVec-LENGTH: " + initVector.length());
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void decryptFile(String encryptedFilePath, String decryptedFilePath) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
//            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            processFileEncryption2(cipher, encryptedFilePath, decryptedFilePath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void processFileEncryption(Cipher ci, String inFile, String outFile)
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

    private void processFileEncryption2(Cipher ci, String inFile, String outFile)
            throws AesCryptoException
    {
        File inputFile = new File(inFile);
        File outputFile = new File(outFile);
       /* if(outputFile.exists()){
//            outputFile.renameTo(new File(outputFile.getAbsolutePath() + String.valueOf(new SecureRandom().nextInt())));
            outputFile.delete();
        }*/
//        outputFile = new File(outFile);

        try(FileInputStream in = new FileInputStream(inputFile);
            FileOutputStream out = new FileOutputStream(outputFile)){
            System.out.println("INT-MAX: " + Integer.MAX_VALUE);
            byte[] ibuf = new byte[(int)inputFile.length()];
            int len;
            while ((len = in.read(ibuf)) != -1) {
                byte[] obuf = ci.update(ibuf, 0, len);
                if ( obuf != null ) out.write(obuf);
            }
            byte[] obuf = ci.doFinal(ibuf);
            if ( obuf != null ) out.write(obuf);
        }catch ( BadPaddingException
                | IllegalBlockSizeException | IOException ex ){
            throw new AesCryptoException("Error encrpting/decrpting file", ex);
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        AesEncyrpt aesEncyrpt = new AesEncyrpt();
        String originalString = "passwordLight343";
        System.out.println("Original String to encrypt - " + originalString);
        String encryptedString = aesEncyrpt.encrypt(originalString);
        System.out.println("Encrypted String - " + encryptedString);
        String decryptedString = aesEncyrpt.decrypt(encryptedString);
        System.out.println("After decryption - " + decryptedString);

        String originalFilePath = "C:\\Users\\Light Chinaka\\Documents\\files\\b\\Tuesday 24th September 2019 - Daily report.pdf";
        String toBeEncryptedOutputFilePath = "C:\\Users\\Light Chinaka\\Desktop\\Tuesday-24th-September-2019-DailyReport.pdf.encrypted";
        String deEncryptedOutputFilePath = "C:\\Users\\Light Chinaka\\Desktop\\Decrypted.pdf";
//
//        String originalFilePath = "C:\\Users\\Light Chinaka\\Desktop\\empty-file.txt";
//        String toBeEncryptedOutputFilePath = "C:\\Users\\Light Chinaka\\Desktop\\empty-file.txt.encrypted";
//        String deEncryptedOutputFilePath = "C:\\Users\\Light Chinaka\\Desktop\\empty-file.decrypted.txt";

        aesEncyrpt.encryptFile( originalFilePath, toBeEncryptedOutputFilePath );
        aesEncyrpt.decryptFile( toBeEncryptedOutputFilePath, deEncryptedOutputFilePath );



        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(Files.readAllBytes(Paths.get(toBeEncryptedOutputFilePath)));
        byte[] digest = md.digest();
        String myChecksum = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        System.out.println("MD5-Digest: " + myChecksum);

    }
}

class AesCryptoException extends Exception {

    public AesCryptoException() {
    }

    public AesCryptoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
