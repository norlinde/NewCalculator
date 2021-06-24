import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

        JFrame frame;
        JTextField textField;
        JButton[] numberButtons = new JButton[10];
        JButton[] functionButtons = new JButton[9];
        JButton addBut, subBut, mulBut, divBut;
        JButton decBut, equBut, delBut, clearBut;
        JButton negBut;


        JPanel jPanel;
        Font myFont = new Font("Verdana", Font.PLAIN, 20);

        double num1 = 0, num2 = 0, result = 0;
        char operator;


        public Calculator() {

            frame = new JFrame("Scientific Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(420, 550);
            frame.setLayout(null);
            textField = new JTextField();
            textField.setBounds(50, 25, 300, 50);
            textField.setFont(myFont);
            textField.setEditable(false);

            addBut = new JButton("+");
            subBut = new JButton("-");
            mulBut = new JButton("*");
            divBut = new JButton("/");
            decBut = new JButton("+");
            equBut = new JButton("=");
            delBut = new JButton("Delete");
            clearBut = new JButton("Clear");
            negBut = new JButton("(-)");

            functionButtons[0] = addBut;
            functionButtons[1] = subBut;
            functionButtons[2] = mulBut;
            functionButtons[3] = divBut;
            functionButtons[4] = decBut;
            functionButtons[5] = equBut;
            functionButtons[6] = delBut;
            functionButtons[7] = clearBut;
            functionButtons[8] = negBut;

            for (int i = 0; i < 9; i++) {
                functionButtons[i].addActionListener(this);
                functionButtons[i].setFont(myFont);
                functionButtons[i].setFocusable(false);
            }

            for (int i = 0; i < 10; i++) {
                numberButtons[i] = new JButton(String.valueOf(i));
                numberButtons[i].addActionListener(this);
                numberButtons[i].setFont(myFont);
                numberButtons[i].setFocusable(false);
            }
            negBut.setBounds(50, 430, 100, 50);
            delBut.setBounds(150, 430, 100, 50);
            clearBut.setBounds(250, 430, 100, 50);


            jPanel = new JPanel();
            jPanel.setBounds(50, 100, 300, 300);
            jPanel.setLayout(new GridLayout(4, 4, 10, 10));

            jPanel.add(numberButtons[1]);
            jPanel.add(numberButtons[2]);
            jPanel.add(numberButtons[3]);
            jPanel.add(addBut);
            jPanel.add(numberButtons[4]);
            jPanel.add(numberButtons[5]);
            jPanel.add(numberButtons[6]);
            jPanel.add(subBut);
            jPanel.add(numberButtons[7]);
            jPanel.add(numberButtons[8]);
            jPanel.add(numberButtons[9]);
            jPanel.add(mulBut);
            jPanel.add(decBut);
            jPanel.add(numberButtons[0]);
            jPanel.add(equBut);
            jPanel.add(divBut);

            frame.add(jPanel);
            frame.add(negBut);
            frame.add(delBut);
            frame.add(clearBut);
            frame.add(textField);
            frame.setVisible(true);
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decBut) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addBut) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");

        }
        if (e.getSource() == subBut) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulBut) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divBut) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == equBut) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;

            }
            textField.setText(String.valueOf(result));
            num1 = result;

        }
        if (e.getSource() == clearBut) {
            textField.setText("");
        }

        if (e.getSource() == delBut) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
            if (e.getSource() == negBut) {
                double temp = Double.parseDouble(textField.getText());
                temp *= -1;
                textField.setText(string.valueOf(temp));


            }

        }


    }}
