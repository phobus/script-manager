package io.home.ui.view.dialog;

import io.home.ui.controller.EnvironmentController;
import io.home.ui.share.Resource;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EnvironmentView {

    private final EnvironmentController controller;

    private JFrame frame;

    private JButton addButton;
    private JButton removeButton;
    private JButton copyButton;
    private JButton pasteButton;
    private JTable table;


    public EnvironmentView(EnvironmentController controller) {
        this.controller = controller;
    }

    public void initListeners() {
        table.setModel(controller.getTableModel());

//        addButton.setAction();
//        removeButton.setAction();
//        copyButton.setAction();
    }

    public JDialog dialog() {
        JDialog dialog = new JDialog(frame, "Environment", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.add(panel());
        initListeners();
        dialog.pack();
        dialog.setLocationByPlatform(true);
        dialog.setVisible(true);
        dialog.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent var1) {
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                System.out.println(table);
            }
        });
        return dialog;
    }


    private Component panel() {
        JPanel panel = new JPanel(new BorderLayout());
//        panel.setBorder(BorderFactory.createTitledBorder("Login Panel"));
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
//        JPanel toolBar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        addButton = new JButton(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.ADD, Resource.ICON_SIZE));
        addButton.setFocusPainted(false);

        toolBar.add(addButton);

        removeButton = new JButton(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.REMOVE, Resource.ICON_SIZE));
        removeButton.setFocusPainted(false);

        toolBar.add(removeButton);

        copyButton = new JButton(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CONTENT_COPY, Resource.ICON_SIZE));
        copyButton.setFocusPainted(false);

        toolBar.add(copyButton);

        pasteButton = new JButton(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CONTENT_PASTE, Resource.ICON_SIZE));
        pasteButton.setFocusPainted(false);
        pasteButton.addActionListener(controller::onPasteButton);
        toolBar.add(pasteButton);

        table = new JTable();
        table.setAutoCreateColumnsFromModel(true);
        JScrollPane tableScroll = new JScrollPane(table);

        panel.add(toolBar, BorderLayout.NORTH);
        panel.add(tableScroll, BorderLayout.CENTER);

        return panel;
    }

//    @Override
//    public void modelPropertyChange(PropertyChangeEvent e) {
//        if (RunProfileController.MODEL_ENVIRONMENT.equals(e.getPropertyName())) {
//            if (!environmentText.getText().equals(e.getNewValue())) {
//                environmentText.setText(e.getNewValue().toString());
//            }
//            controller.setEnvironment((String) e.getNewValue());
//        }
//    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTable getTable() {
        return table;
    }
}
