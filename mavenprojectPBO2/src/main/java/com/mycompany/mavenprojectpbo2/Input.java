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

public class Input implements Component {

    private String label;
    private Scanner input;
    private String value;

    public Input(String label) {
        this.label = label;
        this.input = new Scanner(System.in);
    }

    public void draw() {
        System.out.print("| " + label + " : ");
    }

    public String getValue() {
        value = input.nextLine();
        return value;
    }

    public int getValueInt() {
        while (!input.hasNextInt()) {
            System.out.print("Input tidak valid. Masukkan bilangan bulat: ");
            input.next();
        }
        int valueInt = input.nextInt();
        input.nextLine(); 
        return valueInt;
    }

    public double getValueDouble() {
        while (!input.hasNextDouble()) {
            System.out.print("Input tidak valid. Masukkan bilangan desimal: ");
            input.next();
        }
        double valueDouble = input.nextDouble();
        input.nextLine(); 
        return valueDouble;
    }
}
