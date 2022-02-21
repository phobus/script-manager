package io.home.ui.share;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyChangeEvent;

//public abstract class DefaultView<C extends DefaultController<? extends DefaultModel, ? extends DefaultView<C>>> {
public abstract class DefaultView<C extends DefaultController<?, ?>> {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultView.class);

    protected final C controller;

    protected DefaultView(C controller) {
        this.controller = controller;
    }

    public void propertyChange(PropertyChangeEvent e) {
        LOG.debug("{} from '{}' to '{}'", getClass().getSimpleName(), e.getOldValue(), e.getNewValue());
        modelPropertyChange(e);
    }

    public abstract void modelPropertyChange(final PropertyChangeEvent e);
}
