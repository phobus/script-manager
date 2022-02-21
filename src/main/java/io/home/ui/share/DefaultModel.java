package io.home.ui.share;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class DefaultModel {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultModel.class);

    protected PropertyChangeSupport propertyChangeSupport;

    public DefaultModel() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        LOG.debug("{} add propertyChange listener {}", getClass().getSimpleName(), listener.getClass().getSimpleName());
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        LOG.debug("{} remove propertyChange listener {}", getClass().getSimpleName(), listener.getClass().getSimpleName());
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        LOG.debug("{} firePropertyChange: {}", getClass().getSimpleName(), propertyName);
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }

}
