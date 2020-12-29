package exercises;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;

public final class GenericComparator implements Comparator<Object> {
    private String field;
    private int order;
    private String methodPrefix;

    public GenericComparator(String field, int order) {
        // this constructor assumes all your getter methods begin with get ex: getName()
        this.field = field;
        this.order = order;
        this.methodPrefix = "get";
    }

    public GenericComparator(String field, int order, String prefix) {
        // use this constructor if you want to change the method prefix
        this.field = field;
        this.order = order;
        this.methodPrefix = prefix;
    }

    @Override
    public int compare(Object one, Object two) {
        Method method = getMethod(one); // get the method object to invoke/call/execute
        Class type = method.getReturnType(); // get the return type to be compared

        try {
            if (type == Integer.class || type == int.class) {
                // call the getter method for both objects and multiply with order
                // this translates to one.getId().compareTo( two.getId() ) * order;
                // getId() being the Method object

                return ((Integer) method.invoke(one, null))
                                .compareTo((Integer) method.invoke(two, null))
                        * order;
            } else if (type == String.class) {
                return ((String) method.invoke(one, null))
                                .compareTo((String) method.invoke(two, null))
                        * order;
            }

            // deleted other primitive types for clarity, but same applies to Character, Long,
            // Double, Date, Calendar
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    private Method getMethod(Object object) {
        Method method = null;
        // get methods as Method array from the given object's class
        Method[] methods = object.getClass().getMethods();

        String methodName =
                methodPrefix
                        + Character.toUpperCase(field.charAt(0))
                        + field.substring(1, field.length());

        // iterate through and find the one given in the constructor
        for (Method method1 : methods) {
            if (methodName.equals(method1.getName())) {
                method = method1;
                break;
            }
        }
        return method;
    }
}
