package Controller;

import DAO.GetTextFile;
import Model.ToDoListItem;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class MainView extends JFrame {

    static JMenuBar mb;

    static JMenu fileMenu;

    static JMenuItem newItem, openItem, saveItem, exitItem;

    private JPanel panel1;
    private JTextField addTaskTextField;
    private JLabel titleLabel;
    private JList list1;
    private JLabel label1;
    private JButton addTaskButton;
    private JButton markCompleteButton;
    private JButton deleteTaskButton;
    private JButton moveItemUp;
    private JButton moveItemDown;

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
        addTaskTextField.setText("");
        setList();
    }

    private void deleteItemToDo() {
        //String selectedItem = (String) list1.getSelectedValue();
        int i = list1.getSelectedIndex();
        //ToDoListItem deleteItem = new ToDoListItem(listToDo.get(i).getListItem(), listToDo.get(i).getComplete());
        if(!list1.isSelectionEmpty()) {
            listToDo.remove(listToDo.get(i));
            setList();
        }
    }

    private void moveItem(int index, int direction){
        ToDoListItem savedItem = new ToDoListItem(listToDo.get(index + direction).getListItem(),listToDo.get(index + direction).getComplete());
        ToDoListItem movingItem = new ToDoListItem(listToDo.get(index).getListItem(),listToDo.get(index).getComplete());

        if(index >=0 && index < listToDo.size()) {
            listToDo.get(index).setListItem(savedItem.getListItem());
            listToDo.get(index).setComplete(savedItem.getComplete());
            listToDo.get(index + direction).setListItem(movingItem.getListItem());
            listToDo.get(index + direction).setComplete(movingItem.getComplete());
            setList();
        }



    }


    public MainView() {
        mb = new JMenuBar();

        fileMenu = new JMenu("File");

        newItem = new JMenuItem("New List");
        openItem = new JMenuItem("Open List");
        saveItem = new JMenuItem("Save List");
        exitItem = new JMenuItem("Exit");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        mb.add(fileMenu);
        setJMenuBar(mb);


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
        addTaskTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    String newItem = addTaskTextField.getText();
                    addItemToDo(newItem);
                }
            }
        });

        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listToDo.clear();
                setList();
            }
        });

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GetTextFile openFile = new GetTextFile();
                    listToDo = openFile.getNewList();
                    setList();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        moveItemUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list1.getSelectedIndex();
                moveItem(index, -1);

            }
        });
        moveItemDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list1.getSelectedIndex();
                moveItem(index, 1);

            }
        });
    }
}


