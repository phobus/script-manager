package io.home.ui.controller.runprofile;

import io.home.model.Profile;
import io.home.ui.share.SwingHelper;
import io.home.ui.share.Resource;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;

public class RunProfileAction extends AbstractAction {

    private Document fileDocument;
    private Document argumentsDocument;
    private Document environmentDocument;
    private Document workingPathDocument;

    public RunProfileAction() {
        putValue(SMALL_ICON, IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PLAY_ARROW, Resource.ICON_SIZE));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Profile profile = new Profile();
        String file = SwingHelper.getText(fileDocument);
        String arguments = SwingHelper.getText(argumentsDocument);
        String environment = SwingHelper.getText(environmentDocument);
        String workingPath = SwingHelper.getText(workingPathDocument);
        System.out.println(file);
        System.out.println(arguments);
        System.out.println(environment);
        System.out.println(workingPath);
    }

    public void setFileDocument(Document fileDocument) {
        this.fileDocument = fileDocument;
    }

    public void setArgumentsDocument(Document argumentsDocument) {
        this.argumentsDocument = argumentsDocument;
    }

    public void setEnvironmentDocument(Document environmentDocument) {
        this.environmentDocument = environmentDocument;
    }

    public void setWorkingPathDocument(Document workingPathDocument) {
        this.workingPathDocument = workingPathDocument;
    }
}
