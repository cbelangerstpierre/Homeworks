package com.company;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    public static void main(String[] args) {

        JTextField subject = new JTextField(10);
        JTextField homework = new JTextField(10);
        JTextField date = new JTextField(10);


        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setTitle("Homeworks");
        frame.setSize(new Dimension(500, 500));
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JFrame frame2 = createAddFrame(subject, homework, date);


        JButton button = new JButton("Add Homework");
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(Color.cyan);
        button.addActionListener(e -> {
            if (frame2.isVisible()) {
                hideWindow(frame2);
            } else {
                clearTextField(subject);
                clearTextField(homework);
                clearTextField(date);
                showWindow(frame2);
            }
        });

        frame.add(button);

        frame.setVisible(true);
    }

    private static JFrame createAddFrame(JTextField subject, JTextField homework, JTextField date) {
        JFrame frame2 = new JFrame("Add Homework");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(new Dimension(300, 300));
        frame2.setResizable(false);
        frame2.getContentPane().setBackground(Color.WHITE);
        frame2.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame2.setAlwaysOnTop(true);

        JLabel subjectText = new JLabel("Subject : ");
        JLabel homeworkText = new JLabel("Homework : ");
        JLabel dateText = new JLabel("Due date : ");

        JButton button = new JButton("Submit");
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(Color.green);
        button.addActionListener(e -> hideWindow(frame2));

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        panel1.add(subjectText);
        panel1.add(subject);
        panel2.add(homeworkText);
        panel2.add(homework);
        panel3.add(dateText);
        panel3.add(date);
        panel4.add(button);

        panel1.setBackground(null);
        panel2.setBackground(null);
        panel3.setBackground(null);
        panel4.setBackground(null);

        frame2.add(panel1);
        frame2.add(panel2);
        frame2.add(panel3);
        frame2.add(panel4);


        frame2.setLocationRelativeTo(null);
        return frame2;
    }

    private static void showWindow(JFrame frame) {
        frame.setVisible(true);
    }

    private static void hideWindow(JFrame frame) {
        frame.setVisible(false);
    }

    private static void clearTextField(JTextField textField) {
        textField.setText("");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
