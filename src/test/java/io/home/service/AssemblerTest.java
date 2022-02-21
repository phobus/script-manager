package io.home.service;

import io.home.model.Node;
import io.home.service.dto.NodeDto;
import io.home.ui.model.ProfileTreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class AssemblerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void toResource() {
        Assembler assembler = new Assembler();
        Node root = new Node(0L, "root", null);
        Node child1 = new Node(1L, "child1", root);
        Node child2 = new Node(2L, "child2", root);
        Node child2child1 = new Node(10L, "child2child1", child2);
        root.getChildren().add(child1);
        root.getChildren().add(child2);
        List<Node> nodes = Arrays.asList(root, child1, child2, child2child1);

        ProfileTreeNode nodeMap = assembler.toResource(nodes);

        System.out.println(nodeMap);
    }
}