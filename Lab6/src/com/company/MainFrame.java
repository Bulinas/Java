package com.company;

import javax.swing.*;
import java.awt.*;


/**
 * Main fraim of the aplication
 * Here we configure and position the
 * elements of the aplication
 */

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
        add(configPanel, BorderLayout.SOUTH);
        add(controlPanel, BorderLayout.NORTH);

        //invoke the layout manager
        pack();
    }
}
