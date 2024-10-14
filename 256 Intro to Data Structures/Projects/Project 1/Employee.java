/**
 * This class represents an Employee object which is a subclass of Person but also specifies the office, salary, and hire date of that person.
 * 
 * @author modified 8/30/24 by Katie Lieu
 * CMSC 256 Section 1
 */

package cmsc256;

import java.time.LocalDate;

public class Employee extends Person {
    private String office;
    private int salary;
    private LocalDate hireDate;

    /**
     * Default constructor - calls the Person default constructor and sets instance variables to default values
     */
    public Employee() {
        super();
        office = "Unassigned";
        salary = 0;
        hireDate = null;
    }

    /**
     * Parameterized constructor - sets instance variables to specified values
     * @param first     the first name
     * @param middle    the middle name
     * @param last      the last name
     * @param address   the address
     * @param phone     the phone number
     * @param email     the email address
     * @param office    the office number
     * @param salary    the salary
     * @param month     the month
     * @param day       the day
     * @param year      the year
     * @throws IllegalArgumentException     checks if salary is positive and throws an exception if not
     */
    public Employee(String first, String middle, String last, Address address, String phone, String email, String office, int salary, int month, int day, int year) throws IllegalArgumentException {
        super(first, middle, last, address, phone, email);
        
        this.office = office;
        
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
        
        hireDate = LocalDate.of(year, month, day);
    }

    /**
     * Getter method for office
     * @return office
     */
    public String getOffice() {
        return office;
    }

    /**
     * Getter method for salary
     * @return salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Getter method for hireDate
     * @return hireDate
     */
    public LocalDate getHireDate() {
        return hireDate;
    }

    /**
     * Setter method for office
     */
    public void setOffice(String office) {
        this.office = office;
    }

    /**
     * Setter method for salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Setter method for hireDate
     */
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    /**
     * Format the needed info and return as a String
     * @return String statement
     */
    public String toString() {
        String temp = super.toString() + "\nOffice: " + office + "\nSalary: $" + salary;
        if (!((hireDate) == null)) {
            temp += "\nDate Hired: " + hireDate.getMonthValue() + "/" + hireDate.getDayOfMonth() + "/" + hireDate.getYear();
        }
        return temp;
    }
}
