package DAO;

import Model.ToDoListItem;

import java.io.*;
import java.util.ArrayList;

public class GetTextFile {

    File file = new File("src/test.txt");

    ArrayList<ToDoListItem> newList = new ArrayList<>();

    String lineRead;

    Boolean isComplete;

    BufferedReader br = new BufferedReader(new FileReader(file));
    public GetTextFile() throws IOException {
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
