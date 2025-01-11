package _05_JavaBeans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;

public class BeansExample {
    public static void reactToBoundPropertyChange(PropertyChangeEvent evt) {
        System.out.println("Property changed: " + evt.getPropertyName() + ", Old Value: " + evt.getOldValue() + ", New Value: " + evt.getNewValue());
    }

    public static void reactToVetoablePropertyChange(PropertyChangeEvent evt) throws PropertyVetoException {
        if (evt.getNewValue().equals("Invalid")) {
            throw new PropertyVetoException("Invalid value not allowed: ", evt);
        } else {
            System.out.println("Property changed: " + evt.getPropertyName() + ", Old Value: " + evt.getOldValue() + ", New Value: " + evt.getNewValue());
        }
    }

    public static void main(String[] args) {
        // Bounded bean
        BoundBean bean = new BoundBean();
        bean.addPropertyChangeListener(BeansExample::reactToBoundPropertyChange);

        bean.setText("Hello");
        bean.setText("World");

        // Constrained bean
        ConstrainedBean constrainedBean = new ConstrainedBean();
        constrainedBean.addVetoableChangeListener(BeansExample::reactToVetoablePropertyChange);
        try {
            constrainedBean.setText("valid");
            constrainedBean.setText("Invalid");
        } catch (PropertyVetoException e) {
            e.getMessage();
        }
    }
}
