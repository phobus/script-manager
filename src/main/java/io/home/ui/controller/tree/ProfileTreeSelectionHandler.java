package io.home.ui.controller.tree;

import io.home.ui.model.ProfileTreeNode;
import io.home.ui.view.MainWindowView;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.Document;
import javax.swing.tree.TreePath;
import java.util.Optional;

public class ProfileTreeSelectionHandler implements TreeSelectionListener {

    private Document fileDocument;
    private Document argumentsDocument;
    private Document environmentDocument;
    private Document workingPathDocument;

    private MainWindowView mainWindowView;

    @Override
    public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
        Optional.ofNullable(treeSelectionEvent.getNewLeadSelectionPath())
                .map(TreePath::getLastPathComponent)
                .map(o -> (ProfileTreeNode) o)
                .map(this::toggle)
                .orElseGet(() -> {
                    mainWindowView.hideRightPanel();
                    return false;
                });
    }

    private boolean toggle(ProfileTreeNode treeNode) {
        if (treeNode.isLeaf()) {
            mainWindowView.showRightPanel();
        } else {
            mainWindowView.hideRightPanel();
        }
        return true;
    }

    public void setFileDocument(Document fileDocument) {
        this.fileDocument = fileDocument;
    }

    public void setArgumentsDocument(Document argumentsDocument) {
        this.argumentsDocument = argumentsDocument;
    }

    public void setEnvironmentDocument(Document environmentDocument) {
        this.environmentDocument = environmentDocument;
    }

    public void setWorkingPathDocument(Document workingPathDocument) {
        this.workingPathDocument = workingPathDocument;
    }

    public void setMainWindowView(MainWindowView mainWindowView) {
        this.mainWindowView = mainWindowView;
    }
}
