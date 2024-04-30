/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectpbo2;

/**
 *
 * @author ASUS
 * 
 */
import java.util.Scanner;

public class Label implements Component {

    private int width;
    String text;

    public Label(String text, int width) {
        this.text = text;
        this.width = width;
    }

    public void draw() {
        String line = "| ";
        int spaceCount = width - 2 - text.length();
        line += text;
        for (int i = 0; i < spaceCount; i++) {
            line += " ";
        }
        if (spaceCount > 0) {
            line += " ";
        }
        line += "|";
        System.out.println(line);
    }
}
