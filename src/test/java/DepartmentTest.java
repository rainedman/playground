import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by wcao on 8/15/2016.
 */
public class DepartmentTest {
    @Test(expected = Exception.class)
    public void testAddEmployeeWithMutipleManager() throws Exception {
        Manager m1 = new Manager("1m1");
        Manager m2 = new Manager("2m1");
        Developer d1 = new Developer("d1");
        m2.addEmployee(d1);
        m1.addEmployee(d1);
        Assert.fail("has manager already");
    }

    @Test
    public void testAddEmployeeWithSingleManager() throws Exception {
        Manager m1 = new Manager("1m1");
        Developer d1 = new Developer("d1");
        Developer d2 = new Developer("d2");
        m1.addEmployee(d1);
        m1.addEmployee(d2);
        assertEquals(2, m1.getEmployees().size());
    }

    @Test
    public void testAddEmployeeWithChangeManager() throws Exception {
        Manager m1 = new Manager("1m1");
        Developer d1 = new Developer("d1");
        m1.addEmployee(d1);
        m1.removeEmployee(d1);
        m1.addEmployee(d1);
        assertEquals(1, m1.getEmployees().size());
    }

    @Test
    public void testGetAnyManagerExpense() throws Exception {
        Department d = new Department();
        Manager m1 = new Manager("1m1");
        Manager m2 = new Manager("2m1");
        Developer d1 = new Developer("d1");
        Developer d2 = new Developer("d2");
        QATester t1 = new QATester("t1");
        QATester t2 = new QATester("t2");
        m2.addEmployee(t1);
        m2.addEmployee(t2);
        m2.addEmployee(d1);
        m1.addEmployee(m2);
        m1.addEmployee(d2);
        d.addEmployee(m1);
        assertEquals(2300, d.getSingleEmployeeExpense("2m1"));
        assertEquals(3600, d.getSingleEmployeeExpense("1m1"));
    }

    @Test
    public void testGetAnySingleDeveloperOrQATesterExpense() throws Exception {
        Department d = new Department();
        Manager m1 = new Manager("1m1");
        Manager m2 = new Manager("2m1");
        Developer d1 = new Developer("d1");
        Developer d2 = new Developer("d2");
        QATester t1 = new QATester("t1");
        QATester t2 = new QATester("t2");
        m2.addEmployee(t1);
        m2.addEmployee(t2);
        m2.addEmployee(d1);
        m1.addEmployee(m2);
        m1.addEmployee(d2);
        d.addEmployee(m1);
        assertEquals(1000, d.getSingleEmployeeExpense("d2"));
        assertEquals(1000, d.getSingleEmployeeExpense("d1"));
        assertEquals(500, d.getSingleEmployeeExpense("t1"));
        assertEquals(500, d.getSingleEmployeeExpense("t2"));
    }

    @Test
    public void testGetDepartmentExpense() throws Exception {
        Department d = new Department();
        Manager m1 = new Manager("1m1");
        Manager m2 = new Manager("2m1");
        Manager m3 = new Manager("3m1");
        Developer d1 = new Developer("d1");
        Developer d2 = new Developer("d2");
        Developer d3 = new Developer("d3");
        QATester t1 = new QATester("t1");
        QATester t2 = new QATester("t2");
        QATester t3 = new QATester("t3");
        m3.addEmployee(d3);
        m2.addEmployee(t1);
        m2.addEmployee(t2);
        m2.addEmployee(d1);
        m1.addEmployee(m2);
        m1.addEmployee(d2);
        m1.addEmployee(t3);
        d.addEmployee(m1);
        d.addEmployee(m3);
        assertEquals(5400, d.getDepartmentExpense());
        assertEquals(3000, d.getDepartmentExpense("Developer"));
        assertEquals(1500, d.getDepartmentExpense("QATester"));
    }

    @Test
    public void testGetDepartmentExpense1() throws Exception {
        Department d = new Department();
        Manager m1 = new Manager("1m1");
        Manager m2 = new Manager("2m1");
        Developer d1 = new Developer("d1");
        QATester t1 = new QATester("t1");
        m2.addEmployee(d1);
        m2.addEmployee(t1);
        m1.addEmployee(m2);
        d.addEmployee(m1);
        assertEquals(2100, d.getDepartmentExpense());
    }

    @Test
    public void testGetTotalEmployeeTypeExpense() throws Exception {
        Department d = new Department();
        Manager m1 = new Manager("1m1");
        Manager m2 = new Manager("2m1");
        Manager m3 = new Manager("3m1");
        Developer d1 = new Developer("d1");
        Developer d2 = new Developer("d2");
        Developer d3 = new Developer("d3");
        QATester t1 = new QATester("t1");
        QATester t2 = new QATester("t2");
        QATester t3 = new QATester("t3");
        m3.addEmployee(d3);
        m2.addEmployee(t1);
        m2.addEmployee(t2);
        m2.addEmployee(d1);
        m1.addEmployee(m2);
        m1.addEmployee(d2);
        m1.addEmployee(t3);
        d.addEmployee(m1);
        d.addEmployee(m3);
        assertEquals(3000, d.getDepartmentExpense("Developer"));
        assertEquals(1500, d.getDepartmentExpense("QATester"));
        assertEquals(900, d.getDepartmentExpense("Manager"));
    }

    @Test
    public void testGetNoEmployeeExistExpense() throws Exception {
        Department d = new Department();
        Manager m1 = new Manager("1m1");
        Manager m2 = new Manager("2m1");
        Manager m3 = new Manager("3m1");
        Developer d1 = new Developer("d1");
        Developer d2 = new Developer("d2");
        Developer d3 = new Developer("d3");
        QATester t1 = new QATester("t1");
        QATester t2 = new QATester("t2");
        QATester t3 = new QATester("t3");
        m3.addEmployee(d3);
        m2.addEmployee(t1);
        m2.addEmployee(t2);
        m2.addEmployee(d1);
        m1.addEmployee(m2);
        m1.addEmployee(d2);
        m1.addEmployee(t3);
        d.addEmployee(m1);
        d.addEmployee(m3);
        assertEquals(0, d.getSingleEmployeeExpense("mm11"));
    }

     @Test
    public void testGetNoEmployeeExistEfdxpense()  {
        String sss= "      fdfs  fdsf  ";
         Department d = new Department();
         d.preintStr(sss);
     }
}