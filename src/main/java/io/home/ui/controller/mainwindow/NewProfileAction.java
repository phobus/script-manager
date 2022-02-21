package io.home.ui.controller.mainwindow;

import io.home.service.NodeService;
import io.home.service.ProfileService;
import io.home.service.dto.NodeDto;
import io.home.service.dto.ProfileDto;
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
import java.io.File;

public class NewProfileAction extends AbstractAction {

    private DefaultTreeModel treeModel;
    private DefaultTreeSelectionModel treeSelectionModel;

    private ProfileService profileService;
    private NodeService nodeService;

    public NewProfileAction() {
        putValue(SMALL_ICON, IconFontSwing.buildIcon(GoogleMaterialDesignIcons.INSERT_DRIVE_FILE, Resource.ICON_SIZE2));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.showSaveDialog(null);
        File file = fileChooser.getSelectedFile();
        if (file != null && !file.isDirectory()) {
            createProfile(file);
        }
    }

    protected void createProfile(File file) {
        DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) treeModel.getRoot();
        NodeDto rootDto = (NodeDto) rootNode.getUserObject();

        ProfileDto profile = new ProfileDto();
        profile.setFile(file);
        profileService.save(profile);

        NodeDto nodeDto = new NodeDto();
        nodeDto.setName(file.getName());
        nodeDto.setParent(rootDto);
        nodeDto.setProfileId(profile.getId());
        nodeService.insert(nodeDto);

        DefaultMutableTreeNode node = new ProfileTreeNode(nodeDto);
        treeModel.insertNodeInto(node, rootNode, rootNode.getChildCount());

        TreePath treePath = new TreePath(node.getPath());
        treeSelectionModel.setSelectionPath(treePath);
    }

    public void setTreeModel(DefaultTreeModel treeModel) {
        this.treeModel = treeModel;
    }

    public void setTreeSelectionModel(DefaultTreeSelectionModel treeSelectionModel) {
        this.treeSelectionModel = treeSelectionModel;
    }

    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }

    public void setNodeService(NodeService nodeService) {
        this.nodeService = nodeService;
    }
}
