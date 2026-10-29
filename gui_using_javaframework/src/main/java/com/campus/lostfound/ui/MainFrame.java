package com.campus.lostfound.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    
    public MainFrame(){
        setTitle("Campus Lost and Found Portal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to the Campus Lost and Found Portal!");
        mainPanel.add(welcomeLabel);
        add(mainPanel);
    }
}
