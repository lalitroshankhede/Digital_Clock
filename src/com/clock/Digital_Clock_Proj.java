package com.clock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Digital_Clock_Proj extends JFrame {

    private JLabel timeLabel;
    private JLabel dateLabel;

    public Digital_Clock_Proj() {
        initializeUI();
        setupTimer();
    }

    private void initializeUI() {
        setTitle("Digital Clock");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Create a panel to hold the time and date labels
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BorderLayout());

        // Create a label to display the time
        timeLabel = new JLabel();
        configureLabel(timeLabel, 60, Color.GREEN);

        // Create a label to display the date
        dateLabel = new JLabel();
        configureLabel(dateLabel, 20, Color.WHITE);

        // Add the time and date labels to the panel
        panel.add(timeLabel, BorderLayout.CENTER);
        panel.add(dateLabel, BorderLayout.SOUTH);

        // Set the panel's background color
        panel.setBackground(Color.BLACK);

        // Add the panel to the frame
        add(panel);
    }

    private void configureLabel(JLabel label, int fontSize, Color textColor) {
        label.setFont(new Font("Arial", Font.PLAIN, fontSize));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setForeground(textColor);
    }

    private void setupTimer() {
        // Use a Timer to update the time and date labels every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimeAndDate();
            }
        });
        timer.start();
    }

    private void updateTimeAndDate() {
        // Get the current time and format it
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormatter.format(calendar.getTime());

        // Get the current date and format it
        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE, MMM dd, yyyy");
        String date = dateFormatter.format(calendar.getTime());

       
        // Update the time and date labels
        timeLabel.setText(time);
        dateLabel.setText(date);
    }

    public static void main(String[] args) {
        Digital_Clock_Proj clock = new Digital_Clock_Proj();
        clock.setVisible(true);
    }
}
