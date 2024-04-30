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

public class InputPage extends BasePage {
    private Input inputJudul, inputUsername, inputPassword;
    private SelectInput pilSelect;

    public InputPage(int width) {
        super("Inputan Password", width);

        components.add(new HLine(width));
        components.add(new Space(width));
        components.add(new Label("Inputan Password Baru", width));
        components.add(new Space(width));
        components.add(new HLine(width));
        components.add(new Space(width));

        inputJudul = new Input("Judul Password ");
        inputUsername = new Input("Username ");
        inputPassword = new Input("Password ");
        
        String [] pilihan = {"Belum Kategori", "Aplikasi Web", "Aplikasi Mobile", "Akun Lainnya"};
        pilSelect = new SelectInput("Kategori ", pilihan, width);
        components.add(pilSelect);
    }

    @Override
    protected void drawContent() {
         for (int i = 0; i < components.size() - 3; i++) { // -3 untuk tidak menggambar input fields dan select input
        components.get(i).draw();
    }

        inputJudul.draw();
    String name = inputJudul.getValue();

    inputUsername.draw();
    String username = inputUsername.getValue();

    inputPassword.draw();
    String password = inputPassword.getValue();

    pilSelect.draw();
    int category = pilSelect.getValue();

        try {
            PasswordStore newPassword = new PasswordStore(name, username, password, category);
            DataPassword.passData.add(newPassword);
            System.out.println("Input Password berhasil dibuat");
        } catch (Exception e) {
            System.out.println("Gagal membuat password baru: " + e.getMessage());
        }
        
        new MainPage(width).draw();
    }
}