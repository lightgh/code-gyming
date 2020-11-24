package com.chinakalight.encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 7/18/2020
 */
public class RSAEncryptionDecryption {

    private PrivateKey privateKey;
    private PublicKey publicKey;

    public RSAEncryptionDecryption(){
    }

    public String decryptWithPrivate(PrivateKey privateKey, String encryptedMessage){
        this.privateKey = privateKey;

        String decryptedMessage = null;

        try{
            decryptedMessage = decrypt(privateKey, encryptedMessage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return decryptedMessage;
    }

    public String decryptWithPublic(PublicKey publicKey, String encryptedMessage){
        this.publicKey = publicKey;

        String decryptedMessage = null;

        try{
            decryptedMessage = decrypt(publicKey, encryptedMessage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return decryptedMessage;
    }

    public String encryptWithPublic(PublicKey publicKey, String originalMessage){
        this.publicKey = publicKey;
        String encryptedMessage = null;

        try{
            encryptedMessage = encrypt(publicKey, originalMessage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return encryptedMessage;
    }

    public String encryptWithPrivate(PrivateKey privateKey, String originalMessage){
        this.privateKey = privateKey;
        String encryptedMessage = null;

        try{
            encryptedMessage = encrypt(privateKey, originalMessage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return encryptedMessage;
    }


    private String encrypt(PrivateKey privateKey, String msg) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        Cipher encrypt=Cipher.getInstance("RSA/ECB/PKCS1Padding");
// init with the *public key*!
        encrypt.init(Cipher.ENCRYPT_MODE, privateKey);
// encrypt with known character encoding, you should probably use hybrid cryptography instead
        byte[] encryptedMessage = encrypt.doFinal(msg.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedMessage);
    }

    private String encrypt(PublicKey publicKey, String msg) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        Cipher encrypt=Cipher.getInstance("RSA/ECB/PKCS1Padding");
// init with the *public key*!
        encrypt.init(Cipher.ENCRYPT_MODE, publicKey);
// encrypt with known character encoding, you should probably use hybrid cryptography instead
        byte[] encryptedMessage = encrypt.doFinal(msg.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedMessage);
    }

    private String decrypt(PublicKey publicKey, String encryptedMessage) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        Cipher decrypt=Cipher.getInstance("RSA/ECB/PKCS1Padding");
        decrypt.init(Cipher.DECRYPT_MODE, publicKey);
        String decryptedMessage = new String(decrypt.doFinal(Base64.getDecoder().decode(encryptedMessage)), StandardCharsets.UTF_8);
        return decryptedMessage;
    }

    private String decrypt(PrivateKey privateKey, String encryptedMessage) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        Cipher decrypt=Cipher.getInstance("RSA/ECB/PKCS1Padding");
        decrypt.init(Cipher.DECRYPT_MODE, privateKey);
        String decryptedMessage = new String(decrypt.doFinal(Base64.getDecoder().decode(encryptedMessage)), StandardCharsets.UTF_8);
        return decryptedMessage;
    }
}
