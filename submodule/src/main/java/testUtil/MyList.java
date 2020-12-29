package testUtil;

import java.util.AbstractList;

public class MyList extends AbstractList<String> {

    private MathUtil mathUtil;

    MyList() {
        this(new MathUtil());
        System.out.println();
    }

    public MyList(MathUtil mathUtil) {
        this.mathUtil = mathUtil;
    }

    @Override
    public String get(final int index) {
        System.out.println("MyList.get");
        return mathUtil.get(index);
    }

    @Override
    public int size() {
        System.out.println("MyList.size");
        return mathUtil.size();
    }

    public String message() {
        System.out.println("MyList.message");
        return mathUtil.message();
    }

    public void printMessage(String message) {
        System.out.println("MyList.printMessage");
        mathUtil.printMessage(message);
    }
}
