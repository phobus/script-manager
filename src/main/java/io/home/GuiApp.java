package io.home;

import io.home.ui.GuiContext;

import javax.swing.*;

public class GuiApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GuiContext());
    }

}
