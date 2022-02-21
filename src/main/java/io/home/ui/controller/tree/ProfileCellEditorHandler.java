package io.home.ui.controller.tree;

import io.home.service.NodeService;
import io.home.service.dto.NodeDto;
import io.home.ui.model.ProfileTreeNode;

import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;
import java.util.Optional;

public class ProfileCellEditorHandler implements CellEditorListener {

    private DefaultTreeSelectionModel treeSelectionModel;
    private NodeService nodeService;

    @Override
    public void editingStopped(ChangeEvent changeEvent) {
        Optional.ofNullable(treeSelectionModel.getSelectionPath())
                .map(TreePath::getLastPathComponent)
                .map(o -> (ProfileTreeNode) o)
                .map(ProfileTreeNode::getUserObject)
                .map(o -> (NodeDto) o)
                .map(nodeService::update);
    }

    @Override
    public void editingCanceled(ChangeEvent changeEvent) {

    }

    public void setTreeSelectionModel(DefaultTreeSelectionModel treeSelectionModel) {
        this.treeSelectionModel = treeSelectionModel;
    }

    public void setNodeService(NodeService nodeService) {
        this.nodeService = nodeService;
    }
}
