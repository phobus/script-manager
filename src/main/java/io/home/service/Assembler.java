package io.home.service;

import io.home.model.Node;
import io.home.model.Profile;
import io.home.service.dto.NodeDto;
import io.home.ui.model.ProfileTreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Assembler {

    public ProfileTreeNode toResource(List<Node> nodes) {
        Map<Long, NodeDto> dtos = new HashMap<>();
        Map<Long, ProfileTreeNode> treeNodes = new HashMap<>();
        ProfileTreeNode root = null;
        for (Node model : nodes) {
            NodeDto node = dtos.getOrDefault(model.getId(), toResource(model));
            ProfileTreeNode treeNode = treeNodes.getOrDefault(model.getId(), new ProfileTreeNode(node));
            if (model.getParent() != null) {
                NodeDto parent = dtos.getOrDefault(model.getParent().getId(), toResource(model.getParent()));
                parent.getChildren().add(node);
                node.setParent(parent);
                dtos.put(parent.getId(), parent);

                ProfileTreeNode parentTreeNode = treeNodes.getOrDefault(model.getParent().getId(), new ProfileTreeNode(parent));
                parentTreeNode.add(treeNode);
                treeNode.setParent(parentTreeNode);
                treeNodes.put(parent.getId(), parentTreeNode);
            } else {
                root = treeNode;
            }
            dtos.put(node.getId(), node);
            treeNodes.put(node.getId(), treeNode);
        }
        return root;
    }

//    public NodeDto toResource(List<Node> nodes) {
//        Map<Long, NodeDto> temp = new HashMap<>();
//        NodeDto root = null;
//        for (Node n : nodes) {
//            NodeDto node = temp.getOrDefault(n.getId(), toResource(n));
//            if (n.getParent() != null) {
//                NodeDto parent = temp.getOrDefault(n.getParent().getId(), toResource(n.getParent()));
//                parent.getChildren().add(node);
//                node.setParent(parent);
//                temp.put(parent.getId(), parent);
//            } else {
//                root = node;
//            }
//            temp.put(node.getId(), node);
//        }
//        return root;
//    }

    public NodeDto toResource(Node node) {
        return new NodeDto(node.getId(), node.getName(), Optional.ofNullable(node.getProfile()).map(Profile::getId).orElse(null));
    }

    public void toModel() {
    }
}
