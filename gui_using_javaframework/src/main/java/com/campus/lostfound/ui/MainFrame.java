package com.campus.lostfound.ui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Component;
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

    private void configureLayout(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    }

    private void configureCardBorder(JPanel panel) {
        panel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(java.awt.Color.GRAY),
                        BorderFactory.createEmptyBorder(15, 15, 15, 15)));
    }

    private void configureCardValue(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 28));
    }

    private void configureCardTitle(JLabel label) {
        label.setFont(new Font("Arial", Font.PLAIN, 16));
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

        navigationPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        mainPanel.setLayout(new BorderLayout(10, 10));

        JLabel welcomeLabel = new JLabel("Welcome to the Campus Lost and Found Portal!");
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        headerPanel.add(welcomeLabel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        mainPanel.add(navigationPanel, BorderLayout.WEST);

        JPanel lostItemCard = new JPanel();
        JPanel foundItemCard = new JPanel();
        JPanel claimedItemCard = new JPanel();
        JPanel unclaimedItemCard = new JPanel();

        JLabel lostItemTitle = new JLabel("Lost Items");
        JLabel lostItemValue = new JLabel("12");

        JLabel foundItemTitle = new JLabel("Found Items");
        JLabel foundItemValue = new JLabel("10");

        JLabel claimedItemTitle = new JLabel("Claimed Items");
        JLabel claimedItemValue = new JLabel("8");

        JLabel unclaimedItemTitle = new JLabel("Unclaimed Items");
        JLabel unclaimedItemValue = new JLabel("14");

        JPanel[] cardPanels = {
                lostItemCard, foundItemCard, claimedItemCard, unclaimedItemCard
        };
        JLabel[] cardTitles = {
                lostItemTitle, foundItemTitle, claimedItemTitle, unclaimedItemTitle
        };

        JLabel[] cardValues = {
                lostItemValue, foundItemValue, claimedItemValue, unclaimedItemValue
        };

        for (int i = 0; i < cardPanels.length; i++) {
            cardPanels[i].add(cardTitles[i]);
            cardPanels[i].add(cardValues[i]);
        }

        contentPanel.setLayout(new GridLayout(2, 2, 10, 10));

        for (JPanel panels : cardPanels) {
            configureLayout(panels);
            configureCardBorder(panels);
        }

        for (JLabel value : cardValues) {
            configureCardValue(value);
            value.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        for (JLabel title : cardTitles) {
            configureCardTitle(title);
            title.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for(JPanel panel : cardPanels){
            contentPanel.add(panel);
        }

        mainPanel.add(contentPanel, BorderLayout.CENTER);
        add(mainPanel);
    }
}
