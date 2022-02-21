package io.home.ui.controller.mainwindow;

import io.home.service.NodeService;
import io.home.service.dto.NodeDto;
import io.home.ui.model.ProfileTreeNode;
import io.home.ui.share.Resource;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;

public class NewFolderAction extends AbstractAction {

    private DefaultTreeModel treeModel;
    private NodeService nodeService;
    private DefaultTreeSelectionModel treeSelectionModel;

    public NewFolderAction() {
        putValue(SMALL_ICON, IconFontSwing.buildIcon(GoogleMaterialDesignIcons.ADD_CIRCLE, Resource.ICON_SIZE2));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) treeModel.getRoot();
        NodeDto rootDto = (NodeDto) rootNode.getUserObject();

        NodeDto nodeDto = new NodeDto();
        nodeDto.setName("new folder");
        nodeDto.setParent(rootDto);
        nodeService.insert(nodeDto);

        DefaultMutableTreeNode node = new ProfileTreeNode(nodeDto);
        treeModel.insertNodeInto(node, rootNode, rootNode.getChildCount());

        TreePath treePath = new TreePath(node.getPath());
        treeSelectionModel.setSelectionPath(treePath);
    }

    public void setTreeModel(DefaultTreeModel treeModel) {
        this.treeModel = treeModel;
    }

    public void setNodeService(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    public void setTreeSelectionModel(DefaultTreeSelectionModel treeSelectionModel) {
        this.treeSelectionModel = treeSelectionModel;
    }
}
