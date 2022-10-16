import java.util.*;
public class Employees
{
    public int empId;
    public String name;
    public String address;
    // public static Employees[] employeesArray;
    public static ArrayList<Employees> employeesArray = new ArrayList<Employees>();
    public static void main (String args[]) {
        String [] names={"hana","peter","helen","peterson","patrick"};
        int [] ids={1,34,67,87,22};
        String [] address={"ABC street","new valley","silver street","Goldcliff Circle","829 Haven Lane"};
        for(int i = 0; i < names.length; i++){
            Employees Obj = new Employees();
            // if()
            Obj.empId = ids[i];
            Obj.name = names[i];
            Obj.address = address[i];

            employeesArray.add(Obj);

        }
        Collections.sort(employeesArray, Employees.EmpIdComparator);

        System.out.println("In order of ids");
        for (Employees element: employeesArray) {
            System.out.println(element.empId+ " Name:: " + element.name + " From:: "+ element.address);
        }
        
        Collections.sort(employeesArray, Employees.NameComparator);
        System.out.println("In order of names");
        for (Employees element: employeesArray) {
            System.out.println(element.empId+ " Name:: " + element.name + " From:: "+ element.address);
        }

        Collections.sort(employeesArray, Employees.AddressComparator);
        System.out.println("In order of address");
        for (Employees element: employeesArray) {
            System.out.println(element.empId+ " Name:: " + element.name + " From:: "+ element.address);
        }
        
        // Employee hana = new Employee();
        // Employee peter = new Employee();
        // Employee helen = new Employee();
        // Employee peterson = new Employee();
        // Employee patrick = new Employee();
    }
        public static Comparator<Employees> EmpIdComparator = new Comparator<Employees>() {

            public int compare(Employees s1, Employees s2) {
            int EmployeeEmpId1 = s1.empId;
            int EmployeeEmpId2 = s2.empId;

            //ascending order
            return EmployeeEmpId1 - EmployeeEmpId2;

            //descending order
            //return EmployeeEmpId2.compareTo(EmployeesEmpId1);
            }};
        public static Comparator<Employees> NameComparator = new Comparator<Employees>() {

            public int compare(Employees s1, Employees s2) {
            String EmployeeName1 = s1.name.toUpperCase();
            String EmployeeName2 = s2.name.toUpperCase();

            //ascending order
            return EmployeeName1.compareTo(EmployeeName2);

            //descending order
            //return EmployeeName2.compareTo(EmployeesName1);
            }};
        public static Comparator<Employees> AddressComparator = new Comparator<Employees>() {

            public int compare(Employees s1, Employees s2) {
            String EmployeeAddress1 = s1.address.toUpperCase();
            String EmployeeAddress2 = s2.address.toUpperCase();

            //ascending order
            return EmployeeAddress1.compareTo(EmployeeAddress2);

            //descending order
            //return EmployeeAddress2.compareTo(EmployeesAddress1);
            }};
}