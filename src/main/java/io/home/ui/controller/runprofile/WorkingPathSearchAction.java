package io.home.ui.controller.runprofile;

import io.home.ui.share.SwingHelper;
import io.home.ui.share.Resource;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.io.File;

public class WorkingPathSearchAction extends AbstractAction {
    private Document workingPathDocument;

    public WorkingPathSearchAction() {

        putValue(SMALL_ICON, IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SEARCH, Resource.ICON_SIZE));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showSaveDialog(null);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            SwingHelper.setText(workingPathDocument, fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    public void setWorkingPathDocument(Document workingPathDocument) {
        this.workingPathDocument = workingPathDocument;
    }
}
