package com.chinakalight.algo.basic1;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Base64;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 8/3/2020
 */
public class PracticeFile {
    public static void main1(String[] args) {
        String revenueCode = "12040037POUSY";
        revenueCode = "12040037";
//        revenueCode = "12040037POS";
//        String outcome = revenueCode.replaceAll("[^0-9]+([POS$]?)$", "");
        String outcome = revenueCode.replaceAll("[^0-9][^[^(POS)])]$", "");
        System.out.println(outcome);



    }

    public static void main2(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, SignatureException {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        Signature signature = Signature.getInstance("SHA256WithRSA");

        signature.initSign(keyPair.getPrivate(), secureRandom);

        byte[] data = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");
        signature.update(data);

        byte[] digitalSignature = signature.sign();


        Signature signature2 = Signature.getInstance("SHA256WithRSA");
        signature2.initVerify(keyPair.getPublic());

        signature2.update(data);

        boolean verified = signature2.verify(digitalSignature);

        System.out.println("verified = " + verified);
    }

    public static SecretKey generateSecretKey(){
        KeyGenerator keyGen = null;

        try{
            keyGen = KeyGenerator.getInstance("AES");
        }catch(NoSuchAlgorithmException e){

        }

        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();

        return secretKey;
    }

    public static void main(String[] args) {
        SecretKey secretKey = generateSecretKey();
        String encodedKey = Base64.getEncoder().encodeToString(
                secretKey.getEncoded()
        );
        System.out.println(encodedKey);
        System.out.println(encodedKey.length());
    }


}
