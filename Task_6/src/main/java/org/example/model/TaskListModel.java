package org.example.model;


import javax.swing.*;

public class TaskListModel extends DefaultListModel<String> {

    public void addTask(String task) {
        if (task != null && !task.trim().isEmpty()) {
            addElement(task);
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < getSize()) {
            remove(index);
        }
    }
}