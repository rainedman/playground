/**
 * Created by wcao on 8/15/2016.
 */
public class QATester extends Employee {
    private static String typeEmployee = "QATester";
    private int allocation = 500;

    public QATester(String id) {
        this.id = id;
    }

    public int getAllocation() {
        return allocation;
    }

    public String getTypeEmployee() {
        return typeEmployee;
    }
}