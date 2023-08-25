package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JPanel panel1;
    private JLabel label1;
    private JButton button1;

    public MainView(){
        setTitle("TaskIt");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1); // Set the content pane to the existing panel1
        pack();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText("Boogity Boogity Boogity");
            }
        });

    }



}
