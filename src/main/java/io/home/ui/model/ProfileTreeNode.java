package io.home.ui.model;

import io.home.service.dto.NodeDto;

import javax.swing.tree.DefaultMutableTreeNode;

public class ProfileTreeNode extends DefaultMutableTreeNode {

    public ProfileTreeNode(NodeDto node) {
        super(node);
    }

    @Override
    public void setUserObject(Object userObject) {
        if (userObject instanceof String) {
            setName((String) userObject);
        } else if (userObject instanceof NodeDto) {
            super.setUserObject(userObject);
        }
    }

    public void setName(String name) {
        if (getUserObject() != null) {
            ((NodeDto) getUserObject()).setName(name);
        }
    }

    public String getName() {
        String name = null;
        if (getUserObject() != null) {
            name = ((NodeDto) getUserObject()).getName();
        }
        return name;
    }

    @Override
    public boolean isLeaf() {
        return ((NodeDto) getUserObject()).getProfileId() != null;
    }
}
