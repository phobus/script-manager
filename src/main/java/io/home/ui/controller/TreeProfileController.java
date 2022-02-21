package io.home.ui.controller;

import io.home.service.NodeService;
import io.home.service.dto.NodeDto;
import io.home.ui.controller.tree.ProfileCellEditorHandler;
import io.home.ui.controller.tree.ProfileTreeSelectionHandler;
import io.home.ui.model.ProfileTreeNode;
import io.home.ui.view.panel.TreeProfileView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeSelectionModel;

public class TreeProfileController {

    private static final Logger LOG = LoggerFactory.getLogger(TreeProfileController.class);

    private DefaultTreeModel treeModel;
    private DefaultTreeSelectionModel treeSelectionModel;

    private ProfileTreeSelectionHandler profileTreeSelectionHandler;
    private ProfileCellEditorHandler profileCellEditorHandler;

    private TreeProfileView treeProfileView;

    private NodeService nodeService;

    public TreeProfileController() {
        profileTreeSelectionHandler = new ProfileTreeSelectionHandler();
        profileCellEditorHandler = new ProfileCellEditorHandler();

        treeProfileView = new TreeProfileView(this);
    }

    public void init() {
        treeSelectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        treeSelectionModel.addTreeSelectionListener(profileTreeSelectionHandler);

        treeProfileView.init();

        ProfileTreeNode root = nodeService.findAll();
        if (root == null) {
            NodeDto node = new NodeDto();
            node.setName("root");
            root = new ProfileTreeNode(node);
            nodeService.insert(node);
        }
        treeModel.setRoot(root);
//        treeModel.reload();
    }

    public DefaultTreeModel getTreeModel() {
        return treeModel;
    }

    public void setTreeModel(DefaultTreeModel treeModel) {
        this.treeModel = treeModel;
    }

    public DefaultTreeSelectionModel getTreeSelectionModel() {
        return treeSelectionModel;
    }

    public void setTreeSelectionModel(DefaultTreeSelectionModel treeSelectionModel) {
        this.treeSelectionModel = treeSelectionModel;
    }

    public TreeProfileView getTreeProfileView() {
        return treeProfileView;
    }

    public void setNodeService(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    public ProfileCellEditorHandler getProfileCellEditorHandler() {
        return profileCellEditorHandler;
    }

    public ProfileTreeSelectionHandler getProfileTreeSelectionHandler() {
        return profileTreeSelectionHandler;
    }
}
