import java.util.ArrayList;

/**
 * Created by wcao on 8/15/2016.
 */
public class Department {
    ArrayList<Employee>  list = new ArrayList<>();

    public void addEmployee(Manager m) {
        list.add(m);
    }

    public int getSingleEmployeeExpense(String id) {
        Employee employee = getEmployee(id, list);
        if ( employee != null) {
            return employee.getTotalAllocation();
        }
        return 0;
    }

    public int getDepartmentExpense() {
        int expense = 0;
        for (Employee employee : list) {
            expense = expense + employee.getTotalAllocation();
        }
        return expense;
    }

    public int getDepartmentExpense(String type) {
        int expense = 0;
        for (Employee employee : list) {
            expense = expense + employee.getTotalAllocation(type);
        }
        return expense;
    }


    private Employee getEmployee(String id, ArrayList<Employee> list) {
        Employee employeeWant;
        for (Employee employee : list) {
            if (employee.getId().equalsIgnoreCase(id)) {
                return employee;
            } else if (employee.getEmployees() != null) {
                employeeWant = getEmployee(id, employee.getEmployees());
                if (employeeWant != null) {
                    return employeeWant;
                }
            }
        }
        return null;
    }
}
