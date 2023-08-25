package Model;

public class ToDoListItem {
    private String listItem;

    private Boolean isComplete = false;

    public ToDoListItem(String listItem, Boolean isComplete) {
        this.listItem = listItem;
        this.isComplete = isComplete;
    }

    public String getListItem() {
        return listItem;
    }

    public void setListItem(String listItem) {
        this.listItem = listItem;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }
}
