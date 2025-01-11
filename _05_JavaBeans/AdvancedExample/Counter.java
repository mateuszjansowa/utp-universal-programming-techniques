package _05_JavaBeans.AdvancedExample;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeSupport;

public class Counter {
    private int count = 0;
    private final PropertyChangeSupport propertyChange = new PropertyChangeSupport(this);
    private final VetoableChangeSupport vetoableChange = new VetoableChangeSupport(this);

    public int getCount() {
        return count;
    }

    public void setCount(int newCount) throws PropertyVetoException {
        int oldCount = count;
        vetoableChange.fireVetoableChange("count", oldCount, newCount);
        count = newCount;
        propertyChange.firePropertyChange("count", oldCount, newCount);
    }

    public void increment() throws PropertyVetoException {
        setCount(count + 1);
    }

    public void decrement() throws PropertyVetoException {
        setCount(count - 1);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChange.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChange.removePropertyChangeListener(listener);
    }
}
