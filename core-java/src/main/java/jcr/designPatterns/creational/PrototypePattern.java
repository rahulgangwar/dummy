package jcr.designPatterns.creational;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Prototype design pattern is used when the Object creation is a costly affair
 * and requires a lot of time and resources and you have a similar object already existing.
 *
 * Suppose we have an Object that loads data from database.
 * Now we need to modify this data in our program multiple times,
 * so it’s not a good idea to create the Object using new keyword and load all the data again from database.
 * The better approach would be to clone the existing object into a new object and then do the data manipulation.
 */
public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee emps = new Employee();
        emps.populateData();
        System.out.println("Emps List: " + emps.getBankDetails());

        for (int i = 0; i < 5; i++) {
            // Use the clone method to get the Employee object
            Employee empsNew = (Employee) emps.clone();
            List<String> list = empsNew.getBankDetails();
            list.remove("bank1");
            list.add("Pankaj-" + i);
            System.out.println("EmpsNew List: " + list);
        }
    }

    private static class Employee implements Cloneable {
        private List bankDetails;

        Employee() {}

        Employee(List bankDetails) {
            this.bankDetails = bankDetails;
        }

        public Employee populateData() {
            this.bankDetails = Arrays.asList("bank1", "bank2");
            return this;
        }

        public List getBankDetails() {
            return this.bankDetails;
        }

        public Employee clone() {
            Employee employee = new Employee();
            List newBankDetails = new ArrayList();
            this.getBankDetails().forEach(x -> newBankDetails.add(x));
            return new Employee(newBankDetails);
        }
    }
}
