package _05_JavaBeans;

import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class ConstrainedBean {
    VetoableChangeSupport vetoSupport = new VetoableChangeSupport(this);
    private String text;

    public synchronized void setText(String newText) throws PropertyVetoException {
        String oldText = this.text;
        vetoSupport.fireVetoableChange("text", oldText, newText);
        this.text = newText;
    }

    public synchronized void addVetoableChangeListener(VetoableChangeListener listener) {
        vetoSupport.addVetoableChangeListener(listener);
    }

    public synchronized void removeVetoableChangeListener(VetoableChangeListener listener) {
        vetoSupport.removeVetoableChangeListener(listener);
    }
}
