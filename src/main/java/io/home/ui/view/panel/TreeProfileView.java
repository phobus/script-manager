package io.home.ui.view.panel;

import io.home.ui.controller.TreeProfileController;
import io.home.ui.controller.tree.ProfileTreeCellEditor;
import io.home.ui.controller.tree.ProfileTreeCellRenderer;

import javax.swing.*;
import java.awt.*;

public class TreeProfileView {

    private final TreeProfileController controller;
    private JScrollPane panel;
    private JTree tree;

    public TreeProfileView(TreeProfileController controller) {
        this.controller = controller;
    }

    public JScrollPane getPanel() {
        return panel;
    }

    public JTree getTree() {
        return tree;
    }

    public void init() {
        tree = tree();
        panel = treeScroll(tree);
    }

    public JTree tree() {
        JTree tree = new JTree(controller.getTreeModel());
        tree.setSelectionModel(controller.getTreeSelectionModel());
        tree.setCellRenderer(new ProfileTreeCellRenderer());
        ProfileTreeCellEditor treeCellEditor = new ProfileTreeCellEditor(tree, tree.getCellRenderer());
        treeCellEditor.addCellEditorListener(controller.getProfileCellEditorHandler());
        tree.setCellEditor(treeCellEditor);
        tree.setEditable(true);
        tree.setDragEnabled(true);
        tree.setDropMode(DropMode.ON_OR_INSERT);
        tree.setTransferHandler(new TreeTransferHandler());
        //        tree.setCellRenderer(new FileTreeCellRenderer());
        //tree.setVisibleRowCount(15);
        //tree.setSelectionInterval(0, 0);
        //new Thread(new CreateChildNodes(file, rootNode)).start();
//        new CreateChildNodes(file, rootNode).run();
        tree.expandRow(0);
        tree.setRootVisible(false);
        tree.setShowsRootHandles(true);
        return tree;
    }

    public JScrollPane treeScroll(JTree tree) {
        JScrollPane treeScroll = new JScrollPane(tree);
        Dimension preferredSize = treeScroll.getPreferredSize();
        Dimension dimension = new Dimension(300, (int) preferredSize.getHeight());
        treeScroll.setPreferredSize(dimension);
        return treeScroll;
    }
}
