package io.home.ui.controller;

import io.home.service.ConverterService;
import io.home.ui.view.dialog.EnvironmentView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;

public class EnvironmentController {

    private static final Logger LOG = LoggerFactory.getLogger(EnvironmentController.class);

    private Document environmentDocument;

    private DefaultTableModel tableModel;
    private DefaultTableColumnModel tableColumnModel;
    private ListSelectionModel listSelectionModel;

    private ConverterService converterService;

    private EnvironmentView environmentView;

    public EnvironmentController() {
        environmentView = new EnvironmentView(this);
    }

    public void init() {
        listSelectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

//    @Override
//    public void propertyChange(PropertyChangeEvent e) {
//        if (RunProfileController.MODEL_ENVIRONMENT.equals(e.getPropertyName())) {
//            TableModelListener[] tableModelListener = tableModel.getTableModelListeners();
//            LOG.info("TableModelListener {}", Arrays.toString(tableModelListener));
//        }
//    }

//    public void onAddButton(ActionEvent actionEvent) {
//        tableModel.insertRow(tableModel.getRowCount(), new String[]{"", ""});
//        view.getTable().clearSelection();
//        int i = tableModel.getRowCount() - 1;
//        view.getTable().addRowSelectionInterval(i, i);
//    }
//
//    public void onRemoveButton(ActionEvent actionEvent) {
//        int[] selection = view.getTable().getSelectedRows();
//        if (selection.length == 0) {
//            return;
//        }
//
//        for (int i = 0; i < selection.length; i++) {
//            tableModel.removeRow(selection[i] - i);
//        }
//
//        if (tableModel.getRowCount() == 0) {
//            return;
//        }
//
//        int i = 0;
//        if (selection[0] != 0) {
//            i = selection[0] - 1;
//        }
//        view.getTable().addRowSelectionInterval(i, i);
//
//    }

    public void onCopyButton(ActionEvent actionEvent) {

    }

    public void onPasteButton(ActionEvent actionEvent) {

    }

    public void setEnvironment(String environment) {
        Vector<Vector<String>> vector = tableModel.getDataVector();
        Map<String, String> environmentMap = vector.stream()
                .filter(o -> o.get(0) != null && !o.get(0).trim().isEmpty())
                .collect(Collectors.toMap(v -> v.get(0), v -> v.get(1)));
        String oldValue = converterService.environmentToString(environmentMap);
        if (oldValue.equals(environment)) {
            return;
        }

        Vector<Vector<String>> model = new Vector<>();
        for (Map.Entry<String, String> e : converterService.environmentToMap(environment).entrySet()) {
            Vector<String> v = new Vector<>();
            v.add(e.getKey());
            v.add(e.getValue());
            model.add(v);
        }
        Vector<String> columns = new Vector<>();
        columns.add("Name");
        columns.add("Value");
        tableModel.setDataVector(model, columns);
    }

    public void onTableChange(TableModelEvent tableModelEvent) {
        LOG.debug("onTableChange {}", tableModelEvent);
        Vector<Vector<String>> vector = tableModel.getDataVector();
        Map<String, String> environmentMap = vector.stream()
                .filter(o -> o.get(0) != null && !o.get(0).trim().isEmpty())
                .collect(Collectors.toMap(v -> v.get(0), v -> v.get(1)));
        String environment = converterService.environmentToString(environmentMap);
//        model.setEnvironment(environment);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public DefaultTableColumnModel getTableColumnModel() {
        return tableColumnModel;
    }

    public void setTableColumnModel(DefaultTableColumnModel tableColumnModel) {
        this.tableColumnModel = tableColumnModel;
    }

    public ListSelectionModel getListSelectionModel() {
        return listSelectionModel;
    }

    public void setListSelectionModel(ListSelectionModel listSelectionModel) {
        this.listSelectionModel = listSelectionModel;
    }

    public void setConverterService(ConverterService converterService) {
        this.converterService = converterService;
    }

    public EnvironmentView getEnvironmentView() {
        return environmentView;
    }
}
