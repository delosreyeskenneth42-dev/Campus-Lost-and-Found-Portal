package com.campus.lostfound.ui;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JButton;

public class MainFrame extends JFrame {

    private void configureButton(JButton button) {
        button.setMaximumSize(new Dimension(200, 40));
    }

    public MainFrame() {
        setTitle("Campus Lost and Found Portal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        JPanel headerPanel = new JPanel();
        JPanel contentPanel = new JPanel();
        JPanel navigationPanel = new JPanel();

        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.Y_AXIS));

        JButton dashboardButton = new JButton("Dashboard");
        JButton browseButton = new JButton("Browse Items");
        JButton reportLostButton = new JButton("Report Lost Item");
        JButton reportFoundButton = new JButton("Report Found Item");

        configureButton(dashboardButton);
        configureButton(browseButton);
        configureButton(reportLostButton);
        configureButton(reportFoundButton);

        navigationPanel.add(dashboardButton);
        navigationPanel.add(Box.createVerticalStrut(10));

        navigationPanel.add(browseButton);
        navigationPanel.add(Box.createVerticalStrut(10));

        navigationPanel.add(reportLostButton);
        navigationPanel.add(Box.createVerticalStrut(10));

        navigationPanel.add(reportFoundButton);

        mainPanel.setLayout(new BorderLayout(10, 10));

        JLabel welcomeLabel = new JLabel("Welcome to the Campus Lost and Found Portal!");
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        headerPanel.add(welcomeLabel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        mainPanel.add(navigationPanel, BorderLayout.WEST);

        JLabel searchLabel = new JLabel("Search Items");
        JLabel reportLostLabel = new JLabel("Report Lost Item");
        JLabel reportFoundLabel = new JLabel("Report Found Item");
        JLabel browseLabel = new JLabel("Browse Items");

        contentPanel.setLayout(new GridLayout(2, 2, 10, 10));

        contentPanel.add(searchLabel);
        contentPanel.add(reportLostLabel);
        contentPanel.add(reportFoundLabel);
        contentPanel.add(browseLabel);

        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        mainPanel.add(contentPanel, BorderLayout.CENTER);
        add(mainPanel);
    }
}
