package Controller;

import Model.ToDoListItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainView extends JFrame {
    private JPanel panel1;
    private JTextField addTaskTextField;
    private JLabel titleLabel;
    private JList list1;
    private JLabel label1;
    private JButton addTaskButton;
    private JButton markCompleteButton;
    private JButton deleteTaskButton;

    DefaultListModel<String> listModel = new DefaultListModel<>(); // Create a DefaultListModel

    private ArrayList<ToDoListItem> listToDo = new ArrayList<>();

    private void setList() {
        ArrayList<ToDoListItem> newList = new ArrayList<>(listToDo);
        listModel.clear();
        for (ToDoListItem item : newList) {
            listModel.addElement(item.getListItem());
        }
        list1.setModel(listModel);

    }


    private void addItemToDo(String item) {
        ToDoListItem newItem = new ToDoListItem(item, false);
        listToDo.add(newItem);
        setList();
    }

    private void deleteItemToDo() {
        String selectedItem = (String) list1.getSelectedValue();
        System.out.println(selectedItem);
        ToDoListItem deleteItem = new ToDoListItem(selectedItem, false);
        if(selectedItem != null){
            for(int i = 0; i < listToDo.size(); i++){
                if(deleteItem.getListItem().equals(listToDo.get(i).getListItem())){
                    listToDo.remove(i);
                    break;
                }
            }
        }
        setList();
    }


    public MainView() {
        setList();
        setTitle("TaskIt");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1); // Set the content pane to the existing panel1
        pack();


        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newItem = addTaskTextField.getText();
                addItemToDo(newItem);

            }
        });
        deleteTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItemToDo();

            }
        });
    }
}


