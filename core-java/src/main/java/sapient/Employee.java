package sapient;

public class Employee implements Comparable<Employee> {
    private Long id;
    private Long salary;
    private String location;

    public Employee(Long id, Long salary, String location) {
        this.id = id;
        this.salary = salary;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", salary=" + salary + ", location=" + location + "]";
    }

    @Override
    public int compareTo(Employee o) {
        return (int) (o.id - this.id);
    }
}
