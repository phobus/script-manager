package io.home.ui.controller.runprofile;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;

public class EnvironmentChangeAction extends AbstractAction {
    private Document environmentDocument;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public void setEnvironmentDocument(Document environmentDocument) {
        this.environmentDocument = environmentDocument;
    }
}
