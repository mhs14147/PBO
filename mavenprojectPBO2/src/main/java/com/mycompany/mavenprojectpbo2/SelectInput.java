/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectpbo2;

/**
 *
 * @author ASUS
 */
import java.util.Scanner;

public class SelectInput implements Component{

    private String label;
    private int width;
    private String[] selection;
    private Input input;
    private String value;

    public SelectInput(String label, String[] selection, int width) {
        this.label = label;
        this.width = width;
        this.selection = selection;
        this.input = new Input("Pilihan ");
    }

    public void draw() {
        int labelLength = label.length() + 5;

        System.out.printf("| %-" + (width - selection.length + 2) + "s |\n", label);

        for (int i = 0; i < selection.length; i++) {
            System.out.printf("| [%d] %-" + (width - selection.length - 2) + "s |\n", i+1, selection[i]);
        } 
        
        input.draw();
    }


    private String repeat(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public int getValue() {
        value = input.getValue();
        try {
            int selectedIndex = Integer.parseInt(value);
            if (selectedIndex > 0 && selectedIndex <= selection.length) {
                return selectedIndex;
            } else {
                System.out.println("Input tidak valid. Masukkan nomor pilihan (1-" + selection.length + ")");
                return getValue();
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Masukkan nomor pilihan (1-" + selection.length + ")");
            return getValue(); 
        }
    }
}

