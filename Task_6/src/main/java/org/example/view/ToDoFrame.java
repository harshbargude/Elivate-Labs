package org.example.view;

import org.example.controller.ToDoController;

import javax.swing.*;
import java.awt.*;

public class ToDoFrame extends JFrame {
    private JTextField taskInput;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JButton addButton, deleteButton;

    public ToDoFrame() {
        super("To-Do List App");

        taskInput = new JTextField(20);
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Task");

        JPanel inputPanel = new JPanel();
        inputPanel.add(taskInput);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        new ToDoController(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JTextField getTaskInput() {
        return taskInput;
    }

    public DefaultListModel<String> getTaskListModel() {
        return taskListModel;
    }

    public JList<String> getTaskList() {
        return taskList;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
}
