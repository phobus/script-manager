package io.home.ui.view.dialog;

import io.home.ui.controller.ArgumentController;
import io.home.ui.controller.RunProfileController;

import javax.swing.*;
import java.awt.*;

public class ArgumentView {

    private final ArgumentController controller;

    private JTextArea textArea;
    private JFrame frame;

    public ArgumentView(ArgumentController controller) {
        this.controller = controller;
    }

    public void initListeners() {
        textArea.setDocument(controller.getArgumentsDocument());
    }

    public JDialog dialog() {
        JDialog dialog = new JDialog(frame, "Arguments", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.add(panel());
        initListeners();
        dialog.pack();
        dialog.setLocationByPlatform(true);
        dialog.setVisible(true);

        return dialog;
    }

    protected JPanel panel() {
        JPanel panel = new JPanel(new BorderLayout());
        textArea = new JTextArea(10, 40);
        panel.add(textArea);
        return panel;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

}
