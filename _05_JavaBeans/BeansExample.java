package _05_JavaBeans;


import java.beans.PropertyChangeEvent;

public class BeansExample {
    public static void reactToBoundPropertyChange(PropertyChangeEvent evt) {
        System.out.println("Property changed: " + evt.getPropertyName() +
                ", Old Value: " + evt.getOldValue() +
                ", New Value: " + evt.getNewValue());
    }

    public static void main(String[] args) {
        // Bounded bean
        BoundBean bean = new BoundBean();
        bean.addPropertyChangeListener(BeansExample::reactToBoundPropertyChange);

        bean.setText("Hello");
        bean.setText("World");
    }
}
