package io.home.ui.controller.tree;

import io.home.ui.model.ProfileTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class ProfileTreeCellRenderer extends DefaultTreeCellRenderer {

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

        if (value instanceof ProfileTreeNode) {
            ProfileTreeNode treeNode = (ProfileTreeNode) value;
            setText(treeNode.getName());
        }

        return this;
    }
}
