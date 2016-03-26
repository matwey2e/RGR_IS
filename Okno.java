/*
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
