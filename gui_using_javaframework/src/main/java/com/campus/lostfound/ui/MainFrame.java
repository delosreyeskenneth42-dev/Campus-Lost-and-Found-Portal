package com.campus.lostfound.ui;

import java.awt.BorderLayout;
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
        mainPanel.setLayout(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome to the Campus Lost and Found Portal!");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);
        JLabel lostItemLabel = new JLabel("Find lost items and report found belongings.");
        lostItemLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(lostItemLabel, BorderLayout.CENTER);
        add(mainPanel);

    }
}
