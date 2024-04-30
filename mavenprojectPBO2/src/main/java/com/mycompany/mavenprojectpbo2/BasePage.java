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

public abstract class BasePage {
    
    protected String title;
    protected int width;
    protected HLine hline;
    protected Space space;
    protected Label label;
    protected ArrayList<Component> components;

    public BasePage(String title, int width) {
        this.title = title;
        this.width = width;
        this.hline = new HLine(width);
        this.space = new Space(width);
        this.label = new Label(title.toUpperCase(), width);
        this.components = new ArrayList<>();
    }

    public void draw() {
        drawHeader();
        this.space.draw();
        drawContent();
        drawFooter();
    }

    public void drawHeader() {
        this.hline.draw();
        this.space.draw();
        this.label.draw();
        this.space.draw();
        this.hline.draw();
    }

    public void drawFooter() {
        this.space.draw();
        this.hline.draw();
    }

    protected abstract void drawContent();
}
