package io.home.ui.controller.mainwindow;

import io.home.service.RunService;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindowHandler extends WindowAdapter {

    private RunService runService;

    @Override
    public void windowClosed(WindowEvent windowEvent) {
        runService.stop();
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
    }

    public void setRunService(RunService runService) {
        this.runService = runService;
    }
}
