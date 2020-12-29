package sapient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReader extends FileReader {

    private static final String SEPERATOR = ",";

    @Override
    public List<Employee> read(String filename) {
        try {
            employees =
                    Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8).stream()
                            .skip(1)
                            .map(this::getEmployee11)
                            .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println("");
        } catch (IOException e) {
            System.out.println("");
        }
        return employees;
    }

    public Employee getEmployee11(String line) {
        String[] data = line.split(SEPERATOR);
        Employee employee = null;
        try {
            employee = new Employee(Long.parseLong(data[0]), Long.parseLong(data[1]), data[2]);
        } catch (Exception ex) {
            System.out.println(String.format("Error while converting line:%s to employee", line));
            throw ex;
        }
        return employee;
    }
}
