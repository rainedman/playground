/**
 * Created by wcao on 8/15/2016.
 */
public  class Developer extends  Employee {
    private static String typeEmployee = "Developer";
    private int allocation = 1000;

    public String getTypeEmployee() {
        return typeEmployee;
    }

    public Developer(String id) {
        this.id = id;
    }

    public int getAllocation() {
        return allocation;
    }
}
