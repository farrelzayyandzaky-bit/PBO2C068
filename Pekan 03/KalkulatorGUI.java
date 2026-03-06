/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fzyynm
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KalkulatorGUI extends JFrame implements ActionListener {

    private JTextField layar;
    private double angka1, angka2, hasil;
    private String operator;

    public KalkulatorGUI() {
        // Judul jendela
        setTitle("Kalkulator Sederhana");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Layar
        layar = new JTextField();
        layar.setFont(new Font("Arial", Font.BOLD, 24));
        layar.setHorizontalAlignment(SwingConstants.RIGHT);
        layar.setEditable(false);
        add(layar, BorderLayout.NORTH);

        // Panel tombol
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        // Tombol angka dan operasi
        String[] tombol = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String t : tombol) {
            JButton btn = new JButton(t);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') {
            layar.setText(layar.getText() + cmd);
        } else if (cmd.equals("C")) {
            layar.setText("");
            angka1 = angka2 = hasil = 0;
            operator = "";
        } else if (cmd.equals("=")) {
            angka2 = Double.parseDouble(layar.getText());
            switch (operator) {
                case "+":
                    hasil = angka1 + angka2;
                    break;
                case "-":
                    hasil = angka1 - angka2;
                    break;
                case "*":
                    hasil = angka1 * angka2;
                    break;
                case "/":
                    if (angka2 != 0) {
                        hasil = angka1 / angka2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Error: Tidak bisa dibagi 0!");
                        return;
                    }
                    break;
            }
            layar.setText("" + hasil);
            operator = "";
        } else {
            if (!layar.getText().isEmpty()) {
                angka1 = Double.parseDouble(layar.getText());
                operator = cmd;
                layar.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new KalkulatorGUI();
    }
}
