package Streams.EjercicioStreams.Documentation;

public class Employees {
    private int id;
    private String name;
    private String department;
    private Double salary;

    public Employees(int id, String name, String departament, Double salary) {
        this.id = id;
        this.name = name;
        this.department = departament;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nEmployee" +
                "\nName: " + name +
                "\nSalary: " + salary;
    }
}
