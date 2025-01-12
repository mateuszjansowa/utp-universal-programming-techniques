package _05_JavaBeans.Introspection;

import _05_JavaBeans.AdvancedExample.Counter;

import java.beans.*;

public class IntrospectionDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo info = Introspector.getBeanInfo(Counter.class);

        System.out.println("Właściwości: ");
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println("- " + pd.getName());
        }

        System.out.println("\nMetody: ");
        for (MethodDescriptor md : info.getMethodDescriptors()) {
            System.out.println("- " + md.getMethod());
        }
    }
}
