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
        while((lineRead = br.readLine()) != null){
            String[] partsOfLine = lineRead.split("::");
            String taskName = partsOfLine[0];
            String status = partsOfLine[1];
            status.toLowerCase();

            if(status.equals("complete")){
                isComplete = true;
            }
            else{
                isComplete = false;
            }
            ToDoListItem todoItem = new ToDoListItem(taskName, isComplete);
            newList.add(todoItem);
        }
    }

    public ArrayList<ToDoListItem> getNewList() {
        return newList;
    }
}
