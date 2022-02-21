package io.home.ui.controller.runprofile;

import io.home.ui.share.SwingHelper;
import io.home.ui.share.Resource;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;

public class WorkingPathHomeAction extends AbstractAction {
    private Document workingPathDocument;

    public WorkingPathHomeAction() {

        putValue(SMALL_ICON, IconFontSwing.buildIcon(GoogleMaterialDesignIcons.HOME, Resource.ICON_SIZE));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        SwingHelper.setText(workingPathDocument, System.getProperty("user.home"));
    }

    public void setWorkingPathDocument(Document workingPathDocument) {
        this.workingPathDocument = workingPathDocument;
    }
}
