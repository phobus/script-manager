package io.home.ui.controller;

import io.home.ui.controller.runprofile.*;
import io.home.ui.view.panel.RunProfileView;

import javax.swing.text.Document;

public class RunProfileController {

    private Document fileDocument;
    private Document argumentsDocument;
    private Document environmentDocument;
    private Document workingPathDocument;

    private ArgumentDetailAction argumentDetailAction;
    private EnvironmentChangeAction environmentChangeAction;
    private EnvironmentDetailAction environmentDetailAction;
    private WorkingPathFileAction workingPathFileAction;
    private WorkingPathHomeAction workingPathHomeAction;
    private WorkingPathSearchAction workingPathSearchAction;
    private RunProfileAction runProfileAction;

    private RunProfileView runProfileView;

    public RunProfileController() {
        argumentDetailAction = new ArgumentDetailAction();
        environmentChangeAction = new EnvironmentChangeAction();
        environmentDetailAction = new EnvironmentDetailAction();
        workingPathFileAction = new WorkingPathFileAction();
        workingPathHomeAction = new WorkingPathHomeAction();
        workingPathSearchAction = new WorkingPathSearchAction();
        runProfileAction = new RunProfileAction();

        runProfileView = new RunProfileView(this);
    }

    public void init() {
        runProfileView.init();
    }

    public Document getFileDocument() {
        return fileDocument;
    }

    public void setFileDocument(Document fileDocument) {
        this.fileDocument = fileDocument;
    }

    public Document getArgumentsDocument() {
        return argumentsDocument;
    }

    public void setArgumentsDocument(Document argumentsDocument) {
        this.argumentsDocument = argumentsDocument;
    }

    public Document getEnvironmentDocument() {
        return environmentDocument;
    }

    public void setEnvironmentDocument(Document environmentDocument) {
        this.environmentDocument = environmentDocument;
    }

    public Document getWorkingPathDocument() {
        return workingPathDocument;
    }

    public void setWorkingPathDocument(Document workingPathDocument) {
        this.workingPathDocument = workingPathDocument;
    }

    public ArgumentDetailAction getArgumentDetailAction() {
        return argumentDetailAction;
    }

    public EnvironmentChangeAction getEnvironmentChangeAction() {
        return environmentChangeAction;
    }

    public EnvironmentDetailAction getEnvironmentDetailAction() {
        return environmentDetailAction;
    }

    public WorkingPathFileAction getWorkingPathFileAction() {
        return workingPathFileAction;
    }

    public WorkingPathHomeAction getWorkingPathHomeAction() {
        return workingPathHomeAction;
    }

    public WorkingPathSearchAction getWorkingPathSearchAction() {
        return workingPathSearchAction;
    }

    public RunProfileAction getRunProfileAction() {
        return runProfileAction;
    }

    public RunProfileView getRunProfileView() {
        return runProfileView;
    }
}
