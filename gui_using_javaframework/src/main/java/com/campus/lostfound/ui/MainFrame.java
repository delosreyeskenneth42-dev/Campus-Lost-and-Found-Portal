package com.campus.lostfound.ui;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Campus Lost and Found Portal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        JPanel headerPanel = new JPanel();
        JPanel contentPanel = new JPanel();
        
        mainPanel.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to the Campus Lost and Found Portal!");
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        headerPanel.add(welcomeLabel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        JLabel lostItemLabel = new JLabel("Find lost items and report found belongings.");
        lostItemLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPanel.add(lostItemLabel);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        add(mainPanel);
    }
}
