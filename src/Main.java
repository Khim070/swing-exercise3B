import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    JFrame frame;
    JLabel firstnumber, secondnumber, resultnumber;
    JTextField txtfirstnumber, txtsecondnumber, txtresultnumber;
    JButton btnplus, btnsub, btnmul, btndevide, btnequal, btnclear;

    String sign;
    public static void main(String[] args) {
        new Main().calculator();
    }
    public void calculator() {
        txtfirstnumber = new JTextField();
        txtsecondnumber = new JTextField();
        txtresultnumber = new JTextField();
        txtresultnumber.setEditable(false);
        frame = new JFrame("Swing Calculator");
        firstnumber = new JLabel("First number:");
        firstnumber.setHorizontalAlignment(JLabel.CENTER);
        firstnumber.setVerticalAlignment(JLabel.CENTER);
        secondnumber = new JLabel("Second number:");
        secondnumber.setHorizontalAlignment(JLabel.CENTER);
        secondnumber.setVerticalAlignment(JLabel.CENTER);
        resultnumber = new JLabel("Result number:");
        resultnumber.setHorizontalAlignment(JLabel.CENTER);
        resultnumber.setVerticalAlignment(JLabel.CENTER);
        btnplus = new JButton("+");
        btnsub = new JButton("-");
        btndevide = new JButton("/");
        btnmul = new JButton("*");
        btnequal = new JButton("=");
        btnclear = new JButton("Clear");

        frame.add(firstnumber);
        frame.add(txtfirstnumber);
        frame.add(secondnumber);
        frame.add(txtsecondnumber);
        frame.add(resultnumber);
        frame.add(txtresultnumber);
        frame.add(btnplus);
        frame.add(btnsub);
        frame.add(btnmul);
        frame.add(btndevide);
        frame.add(btnequal);
        frame.add(btnclear);

        btnplus.addActionListener(this);
        btnsub.addActionListener(this);
        btnmul.addActionListener(this);
        btndevide.addActionListener(this);
        btnequal.addActionListener(this);
        btnclear.addActionListener(this);

        frame.setLayout(new GridLayout(6,2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        double result = 0;
        double num1, num2;
        if(e.getSource() == btnplus){
            sign = "+";
        }else if(e.getSource() == btnsub){
            sign = "-";
        }else if(e.getSource() ==  btnmul){
            sign = "*";
        }else if(e.getSource() == btndevide){
            sign = "/";
        }else if(e.getSource() == btnequal){
            num1 = Double.parseDouble(txtfirstnumber.getText());
            num2 = Double.parseDouble(txtsecondnumber.getText());
            switch(sign){
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if(num2 != 0){
                        result = num1 / num2;
                    }else{
                        JOptionPane.showMessageDialog(null,"The number cannot devide by zero");
                    }
                    break;
            }
            txtresultnumber.setText(String.valueOf(result));
        }else if(e.getSource() == btnclear){
            num1 = 0;
            num2 = 0;
            result = 0;
            txtfirstnumber.setText("");
            txtsecondnumber.setText("");
            txtresultnumber.setText("");
        }
    }
}