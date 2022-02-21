package io.home.ui.view.panel;

import io.home.ui.controller.RunProfileController;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class RunProfileView {

    private final RunProfileController controller;

    private JPanel panel;

    private JTextField nameText;
    private JTextField pathText;
    private JTextField argumentsText;
    private JTextField workingPathText;
    private JTextField environmentText;

    private JButton showArgumentButton;
    private JButton runProfileButton;

    private JButton workingPathHomeButton;
    private JButton workingPathFileButton;
    private JButton workingPathSearchButton;

    private JButton showEnvironmentButton;

    public RunProfileView(RunProfileController controller) {
        this.controller = controller;
    }

    public void init() {
        panel = panel();
    }

    public JPanel getPanel() {
        return panel;
    }

    public JPanel panel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;

        JPanel filePanel = filePanel();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        panel.add(filePanel, constraints);

        JPanel argumentPanel = settingsPanel();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        panel.add(argumentPanel, constraints);

        JPanel workingPathPanel = runProfilePanel();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        panel.add(workingPathPanel, constraints);

        JPanel row3 = new JPanel();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        panel.add(row3, constraints);

        return panel;
    }

    private JPanel filePanel() {
        JPanel panelFile = new JPanel(new BorderLayout());
        panelFile.setBorder(BorderFactory.createTitledBorder("File"));

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel nameLabel = new JLabel("Name:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(0, 0, 5, 5);
        panel.add(nameLabel, constraints);

        nameText = new JTextField("Name value");
        nameText.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 0);
        panel.add(nameText, constraints);
        constraints.weightx = 0.0;

        JLabel pathLabel = new JLabel("Path:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(0, 0, 5, 5);
        panel.add(pathLabel, constraints);

        pathText = new JTextField("Path value");
        pathText.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 0);
        panel.add(pathText, constraints);

        panelFile.add(panel);
        return panelFile;
    }

    private JPanel settingsPanel() {
        JPanel settingsPanel = new JPanel(new GridBagLayout());
        settingsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        GridBagConstraints constraints = new GridBagConstraints();

        argumentPanel(settingsPanel, constraints);
        workingPathPanel(settingsPanel, constraints);
        environmentPanel(settingsPanel, constraints);

        return settingsPanel;
    }

    private void argumentPanel(JPanel settingsPanel, GridBagConstraints constraints) {
        constraints.gridy = 0;

        JLabel argumentsLabel = new JLabel("Arguments:");
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(0, 0, 5, 5);
        settingsPanel.add(argumentsLabel, constraints);

        argumentsText = new JTextField(controller.getArgumentsDocument(), null, 0);
        constraints.gridx = 1;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 0);
        constraints.weightx = 1.0;
        settingsPanel.add(argumentsText, constraints);
        constraints.weightx = 0.0;

        showArgumentButton = new JButton(controller.getArgumentDetailAction());
        showArgumentButton.setMargin(new Insets(0, 4, 0, 4));
        showArgumentButton.setFocusable(false);
        constraints.gridx = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        settingsPanel.add(showArgumentButton, constraints);
    }

    private void workingPathPanel(JPanel settingsPanel, GridBagConstraints constraints) {
        constraints.gridy = 1;

        JLabel workingPathLabel = new JLabel("Working path:");
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(0, 0, 5, 5);
        settingsPanel.add(workingPathLabel, constraints);

        workingPathText = new JTextField(controller.getWorkingPathDocument(), null, 30);
        constraints.gridx = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 0);
        constraints.weightx = 1.0;
        settingsPanel.add(workingPathText, constraints);
        constraints.weightx = 0.0;

        workingPathHomeButton = new JButton(controller.getWorkingPathHomeAction());
        workingPathHomeButton.setMargin(new Insets(0, 4, 0, 4));
        workingPathHomeButton.setFocusable(false);
        constraints.gridx = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        settingsPanel.add(workingPathHomeButton, constraints);

        workingPathFileButton = new JButton(controller.getWorkingPathFileAction());
        workingPathFileButton.setMargin(new Insets(0, 4, 0, 4));
        workingPathFileButton.setFocusable(false);
        constraints.gridx = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        settingsPanel.add(workingPathFileButton, constraints);

        workingPathSearchButton = new JButton(controller.getWorkingPathSearchAction());
        workingPathSearchButton.setMargin(new Insets(0, 4, 0, 4));
        workingPathSearchButton.setFocusable(false);
        constraints.gridx = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        settingsPanel.add(workingPathSearchButton, constraints);
    }

    private void environmentPanel(JPanel settingsPanel, GridBagConstraints constraints) {
        constraints.gridy = 2;

        JLabel environmentLabel = new JLabel("Environment:");
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(0, 0, 5, 5);
        settingsPanel.add(environmentLabel, constraints);

        environmentText = new JTextField(controller.getEnvironmentDocument(), null, 0);
        constraints.gridx = 1;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 0);
        settingsPanel.add(environmentText, constraints);

        showEnvironmentButton = new JButton(controller.getEnvironmentDetailAction());
        showEnvironmentButton.setMargin(new Insets(0, 4, 0, 4));
        showEnvironmentButton.setFocusable(false);
        constraints.gridx = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        settingsPanel.add(showEnvironmentButton, constraints);
    }

    private JPanel runProfilePanel() {
        JPanel runProfilePanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        runProfileButton = new JButton(controller.getRunProfileAction());
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.insets = new Insets(10, 0, 10, 5);
        runProfilePanel.add(runProfileButton, constraints);
        return runProfilePanel;
    }

    public void modelPropertyChange(final PropertyChangeEvent e) {
//        if (RunProfileController.MODEL_FILE.equals(e.getPropertyName())) {
//            File file = (File) e.getNewValue();
//            nameText.setText(file.getName());
//            pathText.setText(file.getParent());
//        } else if (RunProfileController.MODEL_ARGUMENTS.equals(e.getPropertyName())) {
//            if (!argumentsText.getText().equals(e.getNewValue())) {
//                argumentsText.setText(e.getNewValue().toString());
//            }
//        } else if (RunProfileController.MODEL_WORKING_PATH.equals(e.getPropertyName())) {
//            if (!workingPathText.getText().equals(e.getNewValue())) {
//                workingPathText.setText(e.getNewValue().toString());
//            }
//        } else if (RunProfileController.MODEL_ENVIRONMENT.equals(e.getPropertyName())) {
//            if (!environmentText.getText().equals(e.getNewValue())) {
//                environmentText.setText(e.getNewValue().toString());
//            }
//        }
    }
}
