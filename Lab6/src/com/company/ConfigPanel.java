package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

/**
 *  This is the bar in the bottom part of the apllicaton
 *  You can switch sides and colors with it
 */

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        label = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        //create the colorCombo, containing the values: Random and Black
        String colors[] =  {"Random", "Black"};
        colorCombo = new JComboBox(colors);

        add(label); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);

    }

    public int getSides(){
        return (int)(sidesField.getValue());
    }

    public String getColor(){
        return colorCombo.getSelectedItem().toString();
    }
}
