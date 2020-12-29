package zzz;

import java.io.*;

public class Main {

    public String first;
    private static String third;
    private String second;

    static class Inner implements Serializable {
        public String name;
        public static String surname;

        public Inner(String name) {
            this.name = name;
            surname = "babu";
        }
    }

    private static final String filename = "D://text.ser";

    public static void main(String[] args) throws IOException {
        //        writeObject(new Inner("rahul"));
        Inner employee = readObject();
        System.out.println("Deserialized Employee : " + employee.name);
        System.out.println("Deserialized Employee : " + Inner.surname);
    }

    static void writeObject(Inner employee) {
        try {
            System.out.println("Serialising : " + employee);
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employee);
            oos.close();
            System.out.println("Writing to file complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Inner readObject() {
        Inner employee = null;
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            employee = (Inner) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
