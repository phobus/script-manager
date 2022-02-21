package io.home.ui.controller.tree;

import io.home.ui.model.ProfileTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class ProfileTreeCellEditor extends DefaultTreeCellEditor {

    public ProfileTreeCellEditor(JTree tree, TreeCellRenderer treeCellRenderer) {
        super(tree, (DefaultTreeCellRenderer) treeCellRenderer);
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
        if (value instanceof ProfileTreeNode) {
            ProfileTreeNode treeNode = (ProfileTreeNode) value;
            value = treeNode.getName();
        }
        return super.getTreeCellEditorComponent(tree, value, isSelected, expanded, leaf, row);
    }
}
