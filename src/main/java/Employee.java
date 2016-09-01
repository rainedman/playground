import java.util.ArrayList;

/**
 * Created by wcao on 8/15/2016.
 */
public abstract class  Employee {
    //String typeEmployee;
    private Manager manager;
    String id;
    private ArrayList<Employee> list;

    abstract int getAllocation() ;

    abstract String getTypeEmployee() ;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void removeManager(){
        setManager(null);
    }

    public String getId() {
       return id;
    }

    public ArrayList<Employee> getEmployees() {
        return list;
    }

    public int getTotalAllocation() {
        return this.getAllocation();
    }

    public int getTotalAllocation(String type) {
        if (this.getTypeEmployee().equalsIgnoreCase(type)){
            return this.getAllocation();
        }else return 0;
    }
}
