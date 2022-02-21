package io.home.ui.controller;

import io.home.ui.controller.mainwindow.MainWindowHandler;
import io.home.ui.controller.mainwindow.NewFolderAction;
import io.home.ui.controller.mainwindow.NewProfileAction;
import io.home.ui.controller.mainwindow.RemoveNodeAction;
import io.home.ui.view.MainWindowView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainWindowController {

    private static final Logger LOG = LoggerFactory.getLogger(MainWindowController.class);

    private MainWindowHandler mainWindowHandler;
    private NewFolderAction newFolderAction;
    private NewProfileAction newProfileAction;
    private RemoveNodeAction removeNodeAction;

    private MainWindowView mainWindowView;

    public MainWindowController() {
        mainWindowHandler = new MainWindowHandler();
        newFolderAction = new NewFolderAction();
        newProfileAction = new NewProfileAction();
        removeNodeAction = new RemoveNodeAction();

        mainWindowView = new MainWindowView(this);
    }

    public void init() {
        mainWindowView.init();
    }

    public MainWindowHandler getMainWindowHandler() {
        return mainWindowHandler;
    }

    public NewFolderAction getNewFolderAction() {
        return newFolderAction;
    }

    public NewProfileAction getNewProfileAction() {
        return newProfileAction;
    }

    public RemoveNodeAction getRemoveNodeAction() {
        return removeNodeAction;
    }

    public MainWindowView getMainWindowView() {
        return mainWindowView;
    }
}
