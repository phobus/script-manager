package io.home.ui.controller.runprofile;

import io.home.ui.share.Resource;
import io.home.ui.view.dialog.ArgumentView;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ArgumentDetailAction extends AbstractAction {

    private ArgumentView argumentView;

    public ArgumentDetailAction() {
        putValue(SMALL_ICON, IconFontSwing.buildIcon(GoogleMaterialDesignIcons.OPEN_IN_NEW, Resource.ICON_SIZE));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        argumentView.dialog();
    }

    public void setArgumentView(ArgumentView argumentView) {
        this.argumentView = argumentView;
    }
}
