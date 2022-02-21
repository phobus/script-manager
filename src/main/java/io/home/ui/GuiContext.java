package io.home.ui;

import io.home.infrastructure.NodeObjectDbRepository;
import io.home.infrastructure.ProfileObjectDbRepository;
import io.home.service.ConverterService;
import io.home.service.NodeService;
import io.home.service.ProfileService;
import io.home.service.RunService;
import io.home.ui.controller.*;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;

public class GuiContext implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(GuiContext.class);

    @Override
    public void run() {
        LOG.info("Starting");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            LOG.error("Error setLookAndFeel", ex);
        }

        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("objectdb:/home/neganix/.scriptcommand/storage.odb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        NodeObjectDbRepository nodeRepository = new NodeObjectDbRepository();
        nodeRepository.setEntityManager(entityManager);

        ProfileObjectDbRepository profileRepository = new ProfileObjectDbRepository();
        profileRepository.setEntityManager(entityManager);

        NodeService nodeService = new NodeService();
        nodeService.setNodeRepository(nodeRepository);
        nodeService.setProfileRepository(profileRepository);

        ProfileService profileService = new ProfileService();
        profileService.setProfileRepository(profileRepository);

//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("objectdb:/home/neganix/.scriptcommand/storage.odb");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        entityManager.flush();
//        entityManager.clear();
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        entityManagerFactory.close();

        ConverterService converterService = new ConverterService();
        RunService runService = new RunService();
        runService.start();

        Document fileDocument = new PlainDocument();
        Document argumentsDocument = new PlainDocument();
        Document environmentDocument = new PlainDocument();
        Document workingPathDocument = new PlainDocument();

        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode();
        DefaultTreeModel treeModel = new DefaultTreeModel(treeNode);
        DefaultTreeSelectionModel treeSelectionModel = new DefaultTreeSelectionModel();

        DefaultTableModel tableModel = new DefaultTableModel();
        DefaultTableColumnModel tableColumnModel = new DefaultTableColumnModel();
        ListSelectionModel listSelectionModel = tableColumnModel.getSelectionModel();

        MainWindowController mainController = new MainWindowController();
        TreeProfileController treeProfileController = new TreeProfileController();
        ArgumentController argumentController = new ArgumentController();
        EnvironmentController environmentController = new EnvironmentController();
        RunProfileController runProfileController = new RunProfileController();

        treeProfileController.setTreeModel(treeModel);
        treeProfileController.setTreeSelectionModel(treeSelectionModel);
        treeProfileController.setNodeService(nodeService);
        treeProfileController.getProfileTreeSelectionHandler().setFileDocument(fileDocument);
        treeProfileController.getProfileTreeSelectionHandler().setWorkingPathDocument(workingPathDocument);
        treeProfileController.getProfileTreeSelectionHandler().setArgumentsDocument(argumentsDocument);
        treeProfileController.getProfileTreeSelectionHandler().setEnvironmentDocument(environmentDocument);
        treeProfileController.getProfileTreeSelectionHandler().setMainWindowView(mainController.getMainWindowView());
        treeProfileController.getProfileCellEditorHandler().setTreeSelectionModel(treeSelectionModel);
        treeProfileController.getProfileCellEditorHandler().setNodeService(nodeService);
        treeProfileController.init();

        argumentController.setArgumentsDocument(argumentsDocument);
        argumentController.getArgumentView().setFrame(mainController.getMainWindowView().getFrame());
        argumentController.init();

        environmentController.setTableModel(tableModel);
        environmentController.setTableColumnModel(tableColumnModel);
        environmentController.setListSelectionModel(listSelectionModel);
        environmentController.getEnvironmentView().setFrame(mainController.getMainWindowView().getFrame());
        environmentController.init();

        runProfileController.getArgumentDetailAction().setArgumentView(argumentController.getArgumentView());
        runProfileController.getEnvironmentChangeAction().setEnvironmentDocument(environmentDocument);
        runProfileController.getEnvironmentDetailAction().setEnvironmentView(environmentController.getEnvironmentView());
        runProfileController.getWorkingPathFileAction().setFileDocument(fileDocument);
        runProfileController.getWorkingPathFileAction().setWorkingPathDocument(workingPathDocument);
        runProfileController.getWorkingPathHomeAction().setWorkingPathDocument(workingPathDocument);
        runProfileController.getWorkingPathSearchAction().setWorkingPathDocument(workingPathDocument);
        runProfileController.getRunProfileAction().setFileDocument(fileDocument);
        runProfileController.getRunProfileAction().setArgumentsDocument(argumentsDocument);
        runProfileController.getRunProfileAction().setWorkingPathDocument(workingPathDocument);
        runProfileController.getRunProfileAction().setEnvironmentDocument(environmentDocument);
        runProfileController.setFileDocument(fileDocument);
        runProfileController.setArgumentsDocument(argumentsDocument);
        runProfileController.setEnvironmentDocument(environmentDocument);
        runProfileController.setWorkingPathDocument(workingPathDocument);
        runProfileController.init();

        mainController.getMainWindowHandler().setRunService(runService);
        mainController.getNewProfileAction().setTreeModel(treeModel);
        mainController.getNewProfileAction().setTreeSelectionModel(treeSelectionModel);
        mainController.getNewProfileAction().setNodeService(nodeService);
        mainController.getNewProfileAction().setProfileService(profileService);
        mainController.getNewFolderAction().setTreeModel(treeModel);
        mainController.getNewFolderAction().setTreeSelectionModel(treeSelectionModel);
        mainController.getNewFolderAction().setNodeService(nodeService);
        mainController.getRemoveNodeAction().setTreeModel(treeModel);
        mainController.getRemoveNodeAction().setTreeSelectionModel(treeSelectionModel);
        mainController.getRemoveNodeAction().setNodeService(nodeService);
        mainController.init();

        mainController.getMainWindowView().setLeftPanel(treeProfileController.getTreeProfileView().getPanel());
        mainController.getMainWindowView().setRightPanel(runProfileController.getRunProfileView().getPanel());
        mainController.getMainWindowView().show();
        mainController.getMainWindowView().hideRightPanel();
    }
}
