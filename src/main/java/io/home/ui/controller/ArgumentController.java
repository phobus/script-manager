package io.home.ui.controller;

import io.home.ui.view.dialog.ArgumentView;

import javax.swing.text.Document;

public class ArgumentController {

    private Document argumentsDocument;

    private ArgumentView argumentView;

    public ArgumentController() {
        argumentView = new ArgumentView(this);
    }

    public void init() {
    }

    public Document getArgumentsDocument() {
        return argumentsDocument;
    }

    public void setArgumentsDocument(Document argumentsDocument) {
        this.argumentsDocument = argumentsDocument;
    }

    public ArgumentView getArgumentView() {
        return argumentView;
    }
}
