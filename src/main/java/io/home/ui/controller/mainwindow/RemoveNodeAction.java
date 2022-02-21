package io.home.ui.controller.mainwindow;

import io.home.service.NodeService;
import io.home.service.dto.NodeDto;
import io.home.ui.model.ProfileTreeNode;
import io.home.ui.share.Resource;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.util.Optional;

public class RemoveNodeAction extends AbstractAction {

    private DefaultTreeModel treeModel;
    private DefaultTreeSelectionModel treeSelectionModel;
    private NodeService nodeService;

    public RemoveNodeAction() {
        putValue(SMALL_ICON, IconFontSwing.buildIcon(GoogleMaterialDesignIcons.REMOVE_CIRCLE, Resource.ICON_SIZE2));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Optional.ofNullable(treeSelectionModel.getSelectionPath())
                .map(TreePath::getLastPathComponent)
                .map(o -> {
                    treeModel.removeNodeFromParent((MutableTreeNode) o);
                    return true;
                });
        Optional.ofNullable(treeSelectionModel.getSelectionPath())
                .map(TreePath::getLastPathComponent)
                .map(o -> (ProfileTreeNode) o)
                .map(ProfileTreeNode::getUserObject)
                .map(o -> (NodeDto) o)
                .map(nodeService::remove);
    }

    public void setTreeModel(DefaultTreeModel treeModel) {
        this.treeModel = treeModel;
    }

    public void setTreeSelectionModel(DefaultTreeSelectionModel treeSelectionModel) {
        this.treeSelectionModel = treeSelectionModel;
    }

    public void setNodeService(NodeService nodeService) {
        this.nodeService = nodeService;
    }
}
