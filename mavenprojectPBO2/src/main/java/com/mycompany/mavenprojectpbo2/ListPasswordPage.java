/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectpbo2;

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;

public class ListPasswordPage extends BasePage {

    public ListPasswordPage(int width) {
        super("List Password", width);
    }

    @Override
    protected void drawContent() {
        ArrayList<PasswordStore> passData = DataPassword.passData;
        
        components.add(new Label("Terdapat " + passData.size() + " Tersimpan", width));
        components.add(new Label("------ ------", width));

        for (PasswordStore password : passData) {
            String name = password.getName();
            String username = password.getUsername();
            String category = password.getCategory();

            String formattedRow = String.format("| %-10s | %-10s | %-10s |", name, username, category);
            components.add(new Label(formattedRow, width));
        }

        for (Component c : components) {
            c.draw();
        }
    }
}