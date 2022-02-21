package io.home.ui.controller.runprofile;

import io.home.ui.share.Resource;
import io.home.ui.view.dialog.EnvironmentView;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EnvironmentDetailAction extends AbstractAction {

    private EnvironmentView environmentView;

    public EnvironmentDetailAction() {
        putValue(SMALL_ICON, IconFontSwing.buildIcon(GoogleMaterialDesignIcons.OPEN_IN_NEW, Resource.ICON_SIZE));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        environmentView.dialog();
    }

    public void setEnvironmentView(EnvironmentView environmentView) {
        this.environmentView = environmentView;
    }
}
