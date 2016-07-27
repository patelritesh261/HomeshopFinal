/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_1;


import java.util.Scanner;

/**
 *
 * @author ritesh
 */
public class Product {
    //declare variable
    private int productId;
    private String productName;
    private String category;
    private String description,partNum,manufacturer;
    private double productCost,productPrice,productMarkup;
    private int minimumInventory;
    Manufacturer MN;
    Scanner get=new Scanner(System.in);
    //Constructor
     public Product()
    {
       
        
        
    }
    public Product( String productName, String category, String description, String partNum, 
            double productCost, double productPrice, double productMarkup,
            int minimumInventory,String manufacturerName, String address, long phoneNumber, String contact)
    {
        productId=ServiceClass.getpdId();
        
        this.productName=productName;
        this.category=category;
        
        this.description=description;
        this.partNum=partNum;
        this.productCost=productCost;
        this.productPrice=productPrice;
        this.productMarkup=productMarkup;
        this.minimumInventory=minimumInventory;
        MN=new Manufacturer(manufacturerName, address, phoneNumber, contact);
    }
    
    //Accesor Methods

   

    public String getProductName() {
        return this.productName;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPartNum() {
        return this.partNum;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public double getProductCost() {
        return this.productCost;
    }

    public double getProductPrice() {
        return this.productPrice;
    }

    public double getProductMarkup() {
        return this.productMarkup;
    }

    public int getMinimumInventory() {
        return this.minimumInventory;
    }

   //Murator Methods

  

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPartNum(String partNum) {
        this.partNum = partNum;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductMarkup(double productMarkup) {
        this.productMarkup = productMarkup;
    }

    public void setMinimumInventory(int minimumInventory) {
        this.minimumInventory = minimumInventory;
    }
   
    @Override
     public String toString(){
         System.out.println("Would you like to display details of Manufacture (Y/N):");
         
         String msg="";
         msg= "Details of Product\n------------------------------------------------------------------------------\n Product ID:    "+productId+"\n Product Name:   "+getProductName()+"\n Product Category:   "+getCategory()+"\n Manufacture :\n "+MN.toString()+"\n Product Description:    "+getDescription()+"\n Product Part Name:   "+getPartNum()+"\n Product Cost:    "+getProductCost()+"\n Product Price:   "+getProductPrice()+"\n Product Markup: "+getProductMarkup()+"\n Minimum Inventory: "+getMinimumInventory();
           /*  String str=  get.nextLine().trim().toUpperCase();
             if( str.equals("Y"))
             {
                 
                 msg= "Details of Product\n------------------------------------------------------------------------------\n Product ID:    "+productId+"\n Product Name:   "+getProductName()+"\n Product Category:   "+getCategory()+"\n Manufacture :\n "+MN.toString()+"\n Product Description:    "+getDescription()+"\n Product Part Name:   "+getPartNum()+"\n Product Cost:    "+getProductCost()+"\n Product Price:   "+getProductPrice()+"\n Product Markup: "+getProductMarkup()+"\n Minimum Inventory: "+getMinimumInventory();
                
             }
             else if(str.equals("N"))
             {
                
                 msg= "Details of Product\n------------------------------------------------------------------------------\n Product ID:    "+productId+"\n Product Name:   "+getProductName()+"\n Product Category:   "+getCategory()+"\n Manufacture Name: "+MN.getManufacturerName()+"\n Product Description:    "+getDescription()+"\n Product Part Name:   "+getPartNum()+"\n Product Cost:    "+getProductCost()+"\n Product Price:   "+getProductPrice()+"\n Product Markup: "+getProductMarkup()+"\n Minimum Inventory: "+getMinimumInventory();
                 
             }*/
            
             
         
      
     return msg;
     }

    
    
}
