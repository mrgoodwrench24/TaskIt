package DAO;

import Model.ToDoListItem;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class GetTextFile {

    File file;

    ArrayList<ToDoListItem> newList = new ArrayList<>();

    String lineRead;

    Boolean isComplete;

    public GetTextFile(File file) {
        this.file = file;
    }

    public void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((lineRead = br.readLine()) != null) {
            String[] partsOfLine = lineRead.split("::");
            String taskName = partsOfLine[0];
            String status = partsOfLine[1];
            status.toLowerCase();

            if (status.equals("complete")) {
                isComplete = true;
            } else {
                isComplete = false;
            }
            ToDoListItem todoItem = new ToDoListItem(taskName, isComplete);
            newList.add(todoItem);
        }
        br.close();
    }

    public ArrayList<ToDoListItem> getNewList() {
        return newList;
    }

    public void writeFile(ArrayList<ToDoListItem> itemList, File outputFile) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        for (ToDoListItem item : itemList) {
            String taskName = item.getListItem();
            Boolean isComplete = item.getComplete();
            String status = "";
            if (item.getComplete() == true) {
                status = "complete";
            } else {
                status = "not complete";
            }
            String line = taskName + "::" + status;
            bw.write(line);
            bw.newLine(); // Add a new line after each item
        }
        bw.close();
    }
}
