import Controller.MainView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainView mainView = new MainView();
            mainView.setSize(600,500);
            mainView.setVisible(true); // Display the MainView window
        });
    }
}
