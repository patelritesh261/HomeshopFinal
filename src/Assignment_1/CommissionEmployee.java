/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_1;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ritesh
 */
public class CommissionEmployee extends Employee {
    private double grossSale;
    private double commisionRate;
    Scanner get=new Scanner(System.in);
    boolean b=true;
    //constructor
    public CommissionEmployee(){}
    public CommissionEmployee(double grossSale, double commisionRate, String firstName, String lastName, int age, String position, Date dateOfHire, String address, long phoneNumber, String status, double payRate) {
        super(firstName, lastName, age, position, dateOfHire, address, phoneNumber, status, payRate);
        this.grossSale = grossSale;
        this.commisionRate = commisionRate;
    }
    //Accessor Methods
    public double getGrossSale() {
        return this.grossSale;
    }

    public double getCommisionRate() {
        return this.commisionRate;
    }
    //Murator methods
    public void setGrossSale(double grossSale) {
        this.grossSale = grossSale;
    }

    public void setCommisionRate(double commisionRate) {
        this.commisionRate = commisionRate;
    }
    
    //calculate salary
    @Override
    public double earning()
    {
        double calculate;
        calculate=(168*super.getPayRate())+ (grossSale*(commisionRate/100));
        return calculate;
    }
    //return all commission emolyee details
     @Override
    public String toString(){
    
        return super.toString()+
                "\n Gross Sales:    "+getGrossSale()+
                "\n Commision Rate:    "+getCommisionRate()+
                "\n---------------------------------------\nTotal Salary: "+earning();
    }
    
}


