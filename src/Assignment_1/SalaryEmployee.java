/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_1;

import java.util.Date;

/**
 *
 * @author ritesh
 */
public class SalaryEmployee extends Employee {
    private double days=30.00;
    public SalaryEmployee(){
       
    }
    public SalaryEmployee(String firstName, String lastName, int age, String position, Date dateOfHire, String address, long phoneNumber, String status, double payRate) {
        super(firstName, lastName, age, position, dateOfHire, address, phoneNumber, status, payRate);
       
    }

   
    
    @Override
    public double earning()
    {
        double calculate;
        calculate=days*8*super.getPayRate();
        return calculate;
    }
    @Override
    public String toString(){
    
        return super.toString()+
                "\n---------------------------------------\nTotal Salary: "+earning();
    }
}
