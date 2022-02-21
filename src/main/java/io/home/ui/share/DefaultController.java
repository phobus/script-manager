package io.home.ui.share;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class DefaultController<M extends DefaultModel, V extends DefaultView<? extends DefaultController<M, V>>> implements PropertyChangeListener {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultController.class);

    protected M model;
    protected V view;

    public void registerModelAndView(M model, V view) {
//        LOG.debug("{} register {} {}", getClass().getSimpleName(), model.getClass().getSimpleName(), view.getClass().getSimpleName());
        this.model = model;
        this.view = view;
        model.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
//        LOG.debug("{} propertyChange {}", getClass().getSimpleName(), propertyChangeEvent.getPropertyName());
        view.propertyChange(propertyChangeEvent);
    }

    public M getModel() {
        return model;
    }

//    @Override
//    public void insertUpdate(DocumentEvent documentEvent) {
//        documentEvent(documentEvent);
//    }
//
//    @Override
//    public void removeUpdate(DocumentEvent documentEvent) {
//        documentEvent(documentEvent);
//    }
//
//    @Override
//    public void changedUpdate(DocumentEvent documentEvent) {
//
//    }
//
//    protected abstract void documentEvent(DocumentEvent documentEvent);
}
