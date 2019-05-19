import java.util.List;

public class Department {

    private List<Manager> managers;

    Department(List<Manager> managers) {
        this.managers = managers;
    }

    public List<Manager> getDapartmentManagers() {
        return this.managers;
    }

}
