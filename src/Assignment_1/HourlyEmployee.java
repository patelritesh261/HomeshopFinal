/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ritesh
 */
public class HourlyEmployee extends Employee{
    private double totalHours;
    boolean b=true;
    Scanner get=new Scanner(System.in);
    //Declare variables
    public HourlyEmployee()  {
        
    }

    public HourlyEmployee(String firstName, String lastName, int age, String position, Date dateOfHire, String address, long phoneNumber, String status, double payRate,double totalHours) {
        super(firstName, lastName, age, position, dateOfHire, address, phoneNumber, status, payRate);
        this.totalHours=totalHours;
    }
    //Accessor Method
    public double getTotalHours() {
        return this.totalHours;
    }
    //Murator Method
    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }

    /**
     *
     * @return
     */
    //Calculate salary
    @Override
    public double earning()
    {
        double calculate;
        calculate=totalHours*super.getPayRate();
        return calculate;
    }
    //Display all details of hourly employee
    @Override
    public String toString(){
    
        return super.toString()+
                "\n Total Hours:\t\t"+getTotalHours()+
                "\n---------------------------------------\nTotal Salary:\t\t"+earning();
    }
   
}
