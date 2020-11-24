package com.chinakalight.encrypt;

import java.io.*;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 6/24/2020
 */
public class RSAKeyPairGenerator {

    private PrivateKey privateKey;
    private PublicKey publicKey;

    private String privateKeyPath;
    private String publicKeyPath;

    public RSAKeyPairGenerator() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();

        this.privateKeyPath = "RSA/PrivateKey";
        this.publicKeyPath = "RSA/PublicKey";
    }


    private void writeToFile(String path, byte[] key) throws IOException {
        File f = new File(path);
        f.getParentFile().mkdirs();
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(key);
        fos.flush();
        fos.close();
    }

    public void writePrivateKeyToFile(String path) throws IOException {
        this.writePrivateKeyToFile(path, getPrivateKey().getEncoded());
    }

    private void writePrivateKeyToFile(String path, byte[] key) throws IOException {
        this.privateKeyPath = path;
        this.writeToFile(this.privateKeyPath, key);
    }

    public void writePublicKeyToFile(String path) throws IOException {
        this.writePublicKeyToFile( path, getPublicKey().getEncoded() );
    }

    private void writePublicKeyToFile(String path, byte[] key) throws IOException {
        this.publicKeyPath = path;
        this.writeToFile(this.publicKeyPath, key);
    }

    public void writePublicAndPrivateKeyToFile() throws IOException {
        this.writePrivateKeyToFile(this.privateKeyPath, getPrivateKey().getEncoded());
        this.writePublicKeyToFile(this.publicKeyPath, getPublicKey().getEncoded());
    }

    private PKCS8EncodedKeySpec readFromFile(String path) throws Exception {
        File f = new File(path);
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int)f.length()];
        dis.readFully(keyBytes);
        dis.close();
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        System.out.println("Listing the Providers");
        Arrays.stream(Security.getProviders()).forEach(eachProv -> {
            System.out.println(eachProv.getName());
        });
        return spec;
    }

    public PrivateKey readPrivateKeyFromFile(String path) throws Exception {
        PKCS8EncodedKeySpec spec = readFromFile(path);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    public PublicKey readPublicKeyFromFile(String path) throws Exception {
        PKCS8EncodedKeySpec spec = readFromFile(path);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec x509spec =
                new X509EncodedKeySpec(spec.getEncoded());
        System.out.println("==================================================\n" +
                "ENCODED-SPEC: " + Base64.getEncoder().encodeToString(x509spec.getEncoded()) +
                        "\n==================================================\n"
                );
        return kf.generatePublic(x509spec);
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

}

