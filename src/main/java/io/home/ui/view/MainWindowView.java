package io.home.ui.view;

import io.home.ui.controller.MainWindowController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainWindowView {

    public static final String APP_TITTLE = "FrameDemo";

    private JFrame frame;

    private JSplitPane splitPane;

    private MainWindowController controller;

    private JPanel rightPanel;

    public MainWindowView(MainWindowController controller) {
        this.controller = controller;
    }

    public void init() {
        frame = frame();
    }

    public void show() {
        frame.pack();
        frame.setMinimumSize(frame.getSize());
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        hideRightPanel();
    }

    public void showRightPanel() {
        this.splitPane.setRightComponent(rightPanel);
    }

    public void hideRightPanel() {
        JPanel hidePanel = new JPanel();
        hidePanel.setPreferredSize(rightPanel.getPreferredSize());
        this.splitPane.setRightComponent(hidePanel);
    }

    public JFrame frame() {
        frame = new JFrame(APP_TITTLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(contentPane());
        frame.addWindowListener(controller.getMainWindowHandler());
        return frame;
    }

    private JToolBar toolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        JButton newProfileButton = new JButton(controller.getNewProfileAction());
        newProfileButton.setFocusPainted(false);
        toolBar.add(newProfileButton);

        JButton newFolderButton = new JButton(controller.getNewFolderAction());
        newFolderButton.setFocusPainted(false);
        toolBar.add(newFolderButton);

        JButton removeNodeButton = new JButton(controller.getRemoveNodeAction());
        removeNodeButton.setFocusPainted(false);
        toolBar.add(removeNodeButton);

        return toolBar;
    }

    public JPanel contentPane() {
        JPanel contentPane = new JPanel(new BorderLayout());
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setBorder(new EmptyBorder(4, 4, 4, 4));
        contentPane.add(toolBar(), BorderLayout.NORTH);
        contentPane.add(splitPane, BorderLayout.CENTER);
        return contentPane;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setLeftPanel(JScrollPane leftPanel) {
        this.splitPane.setLeftComponent(leftPanel);
    }

    public void setRightPanel(JPanel rightPanel) {
        this.splitPane.setRightComponent(rightPanel);
        this.rightPanel = rightPanel;
    }
}
