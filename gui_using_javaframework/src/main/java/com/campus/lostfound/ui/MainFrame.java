package com.campus.lostfound.ui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.CardLayout;

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

    private JPanel createDashboardCard(String title, String value) {
        JPanel card = new JPanel();

        JLabel titleLabel = new JLabel(title);
        JLabel valueLabel = new JLabel(value);

        configureCardValue(valueLabel);
        valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        configureCardTitle(titleLabel);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(titleLabel);
        card.add(valueLabel);

        configureLayout(card);
        configureCardBorder(card);

        return card;
    }

    private JPanel createRecentItemRow(String title, String status) {
        JPanel row = new JPanel();

        JLabel titleLabel = new JLabel(title);
        JLabel statusLabel = new JLabel(status);

        row.setLayout(new BorderLayout());
        row.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        row.add(titleLabel, BorderLayout.WEST);
        row.add(statusLabel, BorderLayout.EAST);

        row.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, row.getPreferredSize().height));

        return row;
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

        CardLayout cardLayout = new CardLayout();
        JPanel screenPanel = new JPanel(cardLayout);

        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.Y_AXIS));

        JButton dashboardButton = new JButton("Dashboard");
        JButton browseButton = new JButton("Browse Items");
        JButton reportLostButton = new JButton("Report Lost Item");
        JButton reportFoundButton = new JButton("Report Found Item");

        browseButton.addActionListener(e -> {
            cardLayout.show(screenPanel, "browse");
        });

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

        JPanel lostItemCard = createDashboardCard("Lost Items", "12");
        JPanel foundItemCard = createDashboardCard("Found Items", "8");
        JPanel claimedItemCard = createDashboardCard("Claimed Items", "6");
        JPanel unclaimedItemCard = createDashboardCard("Unclaimed Items", "14");

        contentPanel.setLayout(new BorderLayout());

        JPanel[] cardPanelLists = {
                lostItemCard, foundItemCard, claimedItemCard, unclaimedItemCard
        };

        JPanel cardsPanel = new JPanel();
        JPanel recentItemsPanel = new JPanel();
        JPanel recentItemsListPanel = new JPanel();

        cardsPanel.setLayout(new GridLayout(2, 2, 10, 10));
        recentItemsPanel.setLayout(new BorderLayout());
        recentItemsListPanel.setLayout(new BoxLayout(recentItemsListPanel, BoxLayout.Y_AXIS));

        JPanel item1 = createRecentItemRow("Black Wallet", "Found");
        JPanel item2 = createRecentItemRow("Blue Backpack", "Lost");
        JPanel item3 = createRecentItemRow("Water Bottle", "Found");

        recentItemsListPanel.add(Box.createVerticalStrut(10));
        recentItemsListPanel.add(item1);
        recentItemsListPanel.add(Box.createVerticalStrut(10));

        recentItemsListPanel.add(item2);
        recentItemsListPanel.add(Box.createVerticalStrut(10));

        recentItemsListPanel.add(item3);

        JLabel recentItemsTitle = new JLabel("Recent Items");

        recentItemsTitle.setBorder(
                BorderFactory.createEmptyBorder(0, 0, 10, 0));
        recentItemsPanel.add(recentItemsTitle, BorderLayout.NORTH);
        recentItemsPanel.add(recentItemsListPanel, BorderLayout.CENTER);

        for (JPanel panel : cardPanelLists) {
            cardsPanel.add(panel);
        }

        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        contentPanel.add(cardsPanel, BorderLayout.NORTH);
        contentPanel.add(recentItemsPanel, BorderLayout.CENTER);

        screenPanel.add(contentPanel, "dashboard");

        JPanel browsePanel = new JPanel();
        browsePanel.add(new JLabel("Browse Items Screen"));

        screenPanel.add(browsePanel, "browse");

        mainPanel.add(screenPanel, BorderLayout.CENTER);
        add(mainPanel);
    }
}
