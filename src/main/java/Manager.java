import java.util.ArrayList;

/**
 * Created by wcao on 8/15/2016.
 */
public class Manager extends Employee {
    private static String typeEmployee = "Manager";
    private int allocation = 300;
    private ArrayList<Employee> list = new ArrayList<>();

    public Manager(String id) {
        this.id = id;
        this.allocation = 300;
    }

    public ArrayList<Employee> getEmployees() {
        return list;
    }

    public int getAllocation() {
        return allocation;
    }

    public String getTypeEmployee() {
        return typeEmployee;
    }

    public void addEmployee(Employee e) throws Exception {
        list.add(e);
        if (null == e.getManager()) {
            e.setManager(this);
        } else {
            throw new Exception("has manager already");
        }
    }

    public void removeEmployee(Employee e) throws Exception {
        if (list.contains(e)) {
            list.remove(e);
            e.removeManager();
        }
    }

    public int getTotalAllocation() {
        int expense = this.getAllocation();
            ArrayList<Employee> list = getEmployees();
            for (Employee employee2 : list) {
                expense = expense + employee2.getTotalAllocation();
            }
        return expense;
    }

    public int getTotalAllocation(String type) {
        int expense = 0;
        if (getTypeEmployee().equalsIgnoreCase(type)){
            expense = this.getAllocation();
        }
        ArrayList<Employee> list = getEmployees();
        for (Employee employee2 : list) {
            expense = expense + employee2.getTotalAllocation(type);
        }
        return expense;
    }
}
