package _05_JavaBeans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BoundBean {
    private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private String text;

    public synchronized void setText(String newText) {
        String oldText = this.text;
        this.text = newText;
        changeSupport.firePropertyChange("text", oldText, newText);
    }

    public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
