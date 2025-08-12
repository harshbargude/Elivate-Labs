package org.example.controller;


import org.example.view.ToDoFrame;

import javax.swing.*;

public class ToDoController {
    private final ToDoFrame view;

    public ToDoController(ToDoFrame view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.getAddButton().addActionListener(e -> addTask());
        view.getDeleteButton().addActionListener(e -> deleteTask());
    }

    private void addTask() {
        String task = view.getTaskInput().getText();
        if (!task.trim().isEmpty()) {
            view.getTaskListModel().addElement(task);
            view.getTaskInput().setText("");
        } else {
            JOptionPane.showMessageDialog(view, "Task cannot be empty");
        }
    }

    private void deleteTask() {
        int selectedIndex = view.getTaskList().getSelectedIndex();
        if (selectedIndex != -1) {
            view.getTaskListModel().remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(view, "Please select a task to delete");
        }
    }
}
