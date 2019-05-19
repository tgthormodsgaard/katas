import java.util.List;

public class Manager implements Employee {

    private String name;

    private EmployeeType type;

    private int allocation;

    private List<Employee> employees;

    Manager(String name, List<Employee> employees) {
        this.name = name;

        this.type = EmployeeType.MANAGER;

        this.allocation = 600;

        this.employees = employees;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public EmployeeType getType() {
        return this.type;
    }

    @Override
    public int getAllocation() {
        return this.allocation;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public boolean hasEmployees() {
        return !employees.isEmpty();
    }

    public int managersAllotment() {
        int allotmentTotal = this.allocation;
        for(Employee employee: this.employees) {
            if(EmployeeType.MANAGER.equals(employee.getType())) {
                allotmentTotal += employee.managersAllotment();
            } else {
                allotmentTotal += employee.getAllocation();
            }
        }
        return allotmentTotal;
    }
}
