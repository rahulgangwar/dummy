package sapient;

import java.util.List;

public class EmployeeReader {
    public static void main(String args[]) {
        String filename = "/home/rahul.babu/Documents/employee.csv";
        System.out.println(new EmployeeReader().readEmployees(filename));
    }

    public List<Employee> readEmployees(String filename) {
        FileReader fileReader = FileReaderFactory.getFileReader(filename);
        List<Employee> employees = fileReader.read(filename);
        return employees;
    }
}
