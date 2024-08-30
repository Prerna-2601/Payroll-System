import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee[name=" + name + ",id=" + id + ",Salary=" + calculateSalary() + "]";
    }

    // Mark as static to access from main method
    static class FullTimeEmployee extends Employee {
        private double monthlySalary;

        public FullTimeEmployee(String name, int id, double monthlySalary) {
            super(name, id);
            this.monthlySalary = monthlySalary;
        }

        @Override
        public double calculateSalary() {
            return monthlySalary;
        }
    }

    // Mark as static to access from main method
    static class PartTimeEmployee extends Employee {
        private int hoursWorked;
        private double hourlyRate;

        public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
            super(name, id);
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        @Override
        public double calculateSalary() {
            return hourlyRate * hoursWorked;
        }
    }

    // Mark as static to access from main method
    static class PayrollSystem {
        private ArrayList<Employee> employeeList;

        public PayrollSystem() {
            employeeList = new ArrayList<>();
        }

        public void addEmployee(Employee employee) {
            employeeList.add(employee);
        }

        public void removeEmployee(int id) {
            Employee employeeToRemove = null;
            for (Employee employee : employeeList) {
                if (employee.getId() == id) {
                    employeeToRemove = employee;
                    break;
                }
            }

            if (employeeToRemove != null) {
                employeeList.remove(employeeToRemove);
            }
        }

        public void displayEmployees() {
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        }
    }
}

public class main { 
    public static void main(String[] args) {
        Employee.PayrollSystem payrollSystem = new Employee.PayrollSystem();
        Employee.FullTimeEmployee emp1 = new Employee.FullTimeEmployee("vikas", 1, 700000);
        Employee.PartTimeEmployee emp2 = new Employee.PartTimeEmployee("alexander", 2, 40, 20);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();
        System.out.println("Removing Employee with ID 2");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employee Details:");
        payrollSystem.displayEmployees();
    }
}
