import java.util.List;

public class Developer implements Employee {

    private String name;

    private EmployeeType type;

    private int allocation;

    Developer(String name) {
        this.name = name;
        this.type = EmployeeType.DEVELOPER;
        this.allocation = 2000;
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

    @Override
    public List<Employee> getEmployees() {
        return null;
    }

    @Override
    public boolean hasEmployees() {
        return false;
    }

    @Override
    public int managersAllotment() {
        return this.allocation;
    }
}
