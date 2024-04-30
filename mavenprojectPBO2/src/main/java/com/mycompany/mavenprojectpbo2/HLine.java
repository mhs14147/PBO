/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectpbo2;

/**
 *
 * @author ASUS
 */
public class HLine implements Component{

    private int width;

    public HLine(int width) {
        this.width = width;
    }

    public void draw() {
        String line = "+";
        for (int i = 0; i < width; i++) {
            line += "=";
        }
        line += "+";
        System.out.println(line);
    }
}
