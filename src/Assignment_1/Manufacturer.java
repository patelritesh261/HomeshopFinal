/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author ritesh
 */
public class Manufacturer {
    
    //Declare variable
    private String manufacuteName;
    private String address;
    private long phoneNumber;
    private String contact;
    Scanner get=new Scanner(System.in);
    //Constructor
    public Manufacturer (){}
    public Manufacturer (String manufacturerName, String address, long phoneNumber, String contact)
    {
        this.manufacuteName=manufacturerName;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.contact=contact;
    }
    
    //Accessor Methods
    public String getManufacturerName()
    {
        return this.manufacuteName;
    }
    public String getAddress()
    {
        return this.address;
    }
    public long getPhoneNumber()
    {
        return this.phoneNumber;
    }
    public String getContact()
    {
        return this.contact;
    }
    
    //Mutator Methods
    public void setManufacturerName(String manufacturerName)
    {
        this.manufacuteName=manufacturerName;
    }
    public void setAddress(String address)
    {
        this.address=address;
    }
    public void setPhoneNumber(long phoneNumber)
    {
        this.phoneNumber=phoneNumber;
    }
    public void setContact(String contact)
    {
        this.contact=contact;
    }
    
  //display all details
    @Override
    public String toString()
    {
        return "Details of Manufacture :---------------------------------------------------\n Manufacture Name:   "+getManufacturerName()+"\n Address:    "+getAddress()+"\n Phone Number:   "+getPhoneNumber()+"\n Contact:    "+getContact();
    }
}
