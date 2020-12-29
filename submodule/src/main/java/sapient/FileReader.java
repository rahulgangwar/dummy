package sapient;

import java.util.List;

public abstract class FileReader {
    public List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public abstract List<Employee> read(String filename);
}
