/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenprojectpbo2;


/**
 *
 * @author ASUS
 */
import java.util.Scanner;

public class MavenprojectPBO2 {

    public static void main(String[] args) throws Exception {
        DataPassword.loadCSVData();
        
        MainPage mainPage = new MainPage(50);
        mainPage.draw();
        
    }
}
