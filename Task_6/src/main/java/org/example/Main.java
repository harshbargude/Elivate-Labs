package org.example;

import org.example.view.ToDoFrame;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(ToDoFrame::new);
    }
}