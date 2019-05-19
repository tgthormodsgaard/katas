import java.util.List;

public interface Employee {

    String getName();

    EmployeeType getType();

    int getAllocation();

    List<? extends Employee> getEmployees();

    boolean hasEmployees();

    int managersAllotment();
}
