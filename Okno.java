﻿/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okno;

 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Okno {
    private JTextField pField;
    private JLabel pLabel;
    private JLabel kmLabel;
    private JTextField tField;
    private JTextField tField2;
    private JLabel tLabel;
    private JLabel tLabel2;
    private JLabel litersLabel;
    private JLabel litersLabel2;
    private JTextField prField;
    private JLabel prLabel;
    private JLabel rurLabel;
    private JButton calcButton;
    private JLabel resultLabel;
    private JFrame mainFrame;
    
    Okno() {
        pLabel = new JLabel("Ширина подоконника");
        pField = new JTextField("0");
        pField.setHorizontalAlignment(JTextField.RIGHT);
        kmLabel = new JLabel("м");
        tLabel = new JLabel("Ширина окна");
        tField = new JTextField("0");
        tField.setHorizontalAlignment(JTextField.RIGHT);
        litersLabel = new JLabel("м");
        
        tLabel2 = new JLabel("Высота окна");
        tField2 = new JTextField("0");
        tField2.setHorizontalAlignment(JTextField.RIGHT);
        litersLabel2 = new JLabel("м");
        
        prLabel = new JLabel("Количество створок");
        prField = new JTextField("0");
        prField.setHorizontalAlignment(JTextField.RIGHT);
        rurLabel = new JLabel("шт");
        calcButton = new JButton("Рассчитать");
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double p = Double.parseDouble(pField.getText());
                    double t = Double.parseDouble(tField.getText());
                    double t2 = Double.parseDouble(tField2.getText());
                    double pr = Double.parseDouble(prField.getText());
                    double plat = p*1000+t*t2*5000*(1+pr/5);
                    plat=Math.rint(100.0 * plat) / 100.0;
                    resultLabel.setText("<html>Стоимость окна составит <font style='color: red; font-weight: bold;'>" + plat + "</font> рублей.</html>");
                }
                catch ( NumberFormatException nfe ) {
                    resultLabel.setText("Проверьте введённые данные");
                }
            }
        });
	resultLabel = new JLabel("Введите данные для рассчёта");
        
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.insets = new Insets(5, 5, 5, 5);
        
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.ipadx = 90;
        constraints.gridy = 0;
        layout.setConstraints(pLabel, constraints);
        constraints.gridy = 1;
        layout.setConstraints(tLabel, constraints);
        constraints.gridy = 2;
        layout.setConstraints(tLabel2, constraints);
        constraints.gridy = 3;
        layout.setConstraints(prLabel, constraints);
        
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.ipadx = 50;
        constraints.gridy = 0;
        layout.setConstraints(pField, constraints);
        constraints.gridy = 1;
        layout.setConstraints(tField, constraints);
        constraints.gridy = 2;
        layout.setConstraints(tField2, constraints);
        constraints.gridy = 3;
        layout.setConstraints(prField, constraints);
        
	constraints.gridx = 2;
        constraints.ipadx = 0;
        constraints.gridy = 0;
        layout.setConstraints(kmLabel, constraints);
        constraints.gridy = 1;
        layout.setConstraints(litersLabel, constraints);
        constraints.gridy = 2;
        layout.setConstraints(litersLabel2, constraints);
        constraints.gridy = 3;
        layout.setConstraints(rurLabel, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.anchor = GridBagConstraints.EAST;
        layout.setConstraints(calcButton, constraints);
        
        constraints.gridy = 5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        layout.setConstraints(resultLabel, constraints);

	mainFrame = new JFrame("Расчет оконной конструкции");
        mainFrame.setSize(600, 450);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(layout);
        
        mainFrame.add(pLabel);
        mainFrame.add(tLabel);
        mainFrame.add(tLabel2);
        mainFrame.add(prLabel);
        mainFrame.add(pField);
        mainFrame.add(tField);
        mainFrame.add(tField2);
        mainFrame.add(prField);
        mainFrame.add(kmLabel);
        mainFrame.add(litersLabel);
        mainFrame.add(litersLabel2);
        mainFrame.add(rurLabel);
        mainFrame.add(calcButton);
        mainFrame.add(resultLabel);
        
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Okno();
            }
        });
    }
 
}
