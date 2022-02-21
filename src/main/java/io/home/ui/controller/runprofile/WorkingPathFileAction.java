package io.home.ui.controller.runprofile;

import io.home.ui.share.SwingHelper;
import io.home.ui.share.Resource;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Optional;

public class WorkingPathFileAction extends AbstractAction {
    private Document workingPathDocument;
    private Document fileDocument;

    public WorkingPathFileAction() {
        putValue(SMALL_ICON, IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CODE, Resource.ICON_SIZE));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Optional.of(SwingHelper.getText(fileDocument))
                .map(File::new)
                .map(File::getParent)
                .map(s -> SwingHelper.setText(workingPathDocument, s));

    }

    public void setWorkingPathDocument(Document workingPathDocument) {
        this.workingPathDocument = workingPathDocument;
    }

    public void setFileDocument(Document fileDocument) {
        this.fileDocument = fileDocument;
    }
}
