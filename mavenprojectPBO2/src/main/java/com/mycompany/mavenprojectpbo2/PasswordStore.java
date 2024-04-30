/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectpbo2;

import com.mycompany.mavenprojectpbo2.Encryptor;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class PasswordStore {

    public String name, username;
    private String password, hashkey;
    private double score;
    private int category;

    public static final int UNCATEGORIZED = 0;
    public static final int CAT_WEBAPP = 1;
    public static final int CAT_MOBILEAPP = 2;
    public static final int CAT_OTHER = 3;

    public PasswordStore(String name, String username, String plainPass, int category) throws Exception {
        try {
            this.name = name;
            this.username = username;
            generateKey();
            setPassword(plainPass);
            setCategory(category);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PasswordStore(String name, String username, String encPass,
        int category, String hashKey, double score){
        this.name = name;
        this.username = username;
        this.password = encPass;
        this.category = category;
        this.hashkey = hashKey;
        this.score = score;
    }

    public void setPassword(String plainPass) throws NoSuchAlgorithmException, Exception {
        this.password = Encryptor.encrypt(plainPass, hashkey);
        calculateScore(plainPass);
    }


    public void setCategory(int category) {
        if (category >= 0 && category <= 3) {
            this.category = category;
        } else {
            this.category = UNCATEGORIZED;
        }
    }

    public String getCategory() {
        switch (category) {
            case 1:
                return "Belum terkategori";
            case 2:
                return "Aplikasi web";
            case 3:
                return "Aplikasi mobile";
            case 4:
                return "Akun lainnya";
            default:
                return "";
        }
    }
    
    public int getCategoryCode(){
        return this.category;
    }
    
    public double getScore(){
        return this.score;
    }
    
    public String getHashkey(){
        return this.hashkey;
    }
    
    public String getEncPassword(){
        return this.password;
    }
    
    public String getName() {
            return name;
        }
    
    public String getUsername() {
            return username;
        }
    
    public String getPassword(){
        try {
    return Encryptor.decrypt(this.password, this.hashkey);
    } catch (Exception ex) {
    Logger.getLogger(PasswordStore.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }

    private void calculateScore(String plainPass){
        double len = plainPass.length();
        if(len > 15){
        this.score = 10;
    } else {
        this.score = (len / 15) * 10;
        }
    }

    private void generateKey() throws NoSuchAlgorithmException {
        hashkey = Encryptor.generateKey();
    }
    
    @Override
    public String toString() {
        return this.username+" - "+this.password+" - "+this.hashkey+" - "
        + String.format("%,.2f", this.score);
    }

}
