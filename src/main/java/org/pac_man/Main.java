package org.pac_man;

import javax.swing.*;

import org.pac_man.game.PacMan;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public interface Main {
    static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PacMan pacMan = new PacMan(165);
            JFrame frame = new JFrame(PacMan.TITLE);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.add(pacMan, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    pacMan.stop();
                }
            });
            pacMan.start();
        });
    }
}