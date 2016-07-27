/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author ritesh
 */
public class Input {

    //Declare employee variables
    private String firstName, lastName, address, status, position, search_employee, search_product;
    private int empId, age;
    private long phoneNumber;
    private Date dateOfHire;
    private double payRate, totalHours, grossSale, commisionRate;
    boolean b = true;
    //Declare product variables
    private String productId;
    private String productName;
    private String category;
    private String description, partNum, manufacturer;
    private double productCost, productPrice, productMarkup;
    private int minimumInventory;
    //Declare manufacture variables
    private String manufacuteName;
    private String contact;
    Scanner get = new Scanner(System.in);
    ArrayList<Employee> emps = new ArrayList<>();
    ArrayList<Product> pds = new ArrayList<>();

    //constructor
    public Input() {
    }

    public void product_employee() {
        b = true;

        int option;

        while (b) {
            // option for employee or product
            System.out.println("1.\tAdd/Search Employee\n2.\tAdd/Search Product\nEnter your option:");
            try {
                option = Integer.parseInt(get.nextLine());

                if (option == 1) {
                    //add or search employee
                    add_search_employee();
                    b = false;
                } else if (option == 2) {
                    //add or search product
                    add_search_product();
                    b = false;
                } else {
                    System.out.println("Enter value 1 or 2 for options:");
                    b = true;
                }
            } catch (Exception e) {
                System.out.println("Enter value 1 or 2 for options:");
                b = true;
            }

        }
    }

    private void add_search_employee() {
        b = true;

        int option;

        while (b) {

            System.out.println("1.\tAdd Employee\n2.\tSearch Employee\n3.\tDisplay Employee List\nEnter your option:");
            try {
                option = Integer.parseInt(get.nextLine());

                if (option == 1) {
                    // add employee method
                    add_employee();
                    b = false;
                } else if (option == 2) {
                    // search employee method
                    search_employee();
                    b = false;
                } else if (option == 3) {
                    // display employee method
                    display_employee();
                    b = false;
                } else {
                    System.out.println("Enter value 1 or 2 for options:");
                    b = true;
                }
            } catch (Exception e) {
                System.out.println("Enter value 1 or 2 for options:");
                b = true;
            }

        }
    }

    private void add_employee() {
        b = true;

        int option;

        while (b) {

            System.out.println("1.\tHourly Employee\n2.\tSalary Employee\n3.\tCommission Employee\nEnter your option:");
            try {
                option = Integer.parseInt(get.nextLine());
                //method for basic 
                basic_info();
                
                if (option == 1) {
                    hourly_employee();
                    b = false;
                } else if (option == 2) {
                    salary_employee();
                    b = false;
                } else if (option == 3) {
                    commission_employee();
                    b = false;
                } else {
                    System.out.println("Enter value between 1 and 3 for options:");
                    b = true;
                }
            } catch (Exception e) {
                System.out.println("Enter value between 1 and 3 for options:");
                b = true;
            }

        }
    }

    private void search_employee() {
        b = true;

        int option;

        while (b) {

            System.out.println("1.\tFirst Name\n2.\tLast Name\n3.\tEmployee ID\nEnter your option for searching:");
            try {
                option = Integer.parseInt(get.nextLine());

                
                if (option == 1) {
                    System.out.println("Enter First Name:");
                    search_employee = get.nextLine();
                    search_data(search_employee);
                    b = false;
                } else if (option == 2) {
                    System.out.println("Enter Last Name:");
                    search_employee = get.nextLine();
                    search_data(search_employee);
                    b = false;
                } else if (option == 3) {
                    System.out.println("Enter Employee ID:");
                    search_employee = get.nextLine();
                    search_data(search_employee);
                    b = false;
                } else {
                    System.out.println("Enter value between 1 and 3 for options:");
                    b = true;
                }
            } catch (Exception e) {
                System.out.println("Enter value between 1 and 3  for options:");
                b = true;
            }

        }
    }

    private void basic_info() {
        b = true;

        System.out.println("Enter details of employee\nFirst Name : ");
        firstName = get.nextLine();
        System.out.println("Last Name : ");
        lastName = get.nextLine();

        while (b) {
            try {
                System.out.println("Age : ");
                age = Integer.parseInt(get.nextLine());
                b = false;
            } catch (NumberFormatException e) {
                System.out.println("Enter Integer Value");
                b = true;
            }
        }
        b = true;
        System.out.println("Position : ");
        position = get.nextLine();
        while (b) {
            Date doh = null;
            try {
                System.out.println("Date of hire (DD/MM/YYYY) : ");
                doh = new SimpleDateFormat("ddMMyyyy").parse(get.nextLine().replaceAll("/", ""));
                dateOfHire = doh;
                b = false;
            } catch (ParseException e) {
                System.out.println("Enter Date Format in DD/MM/YYYY");
                b = true;
            }
        }
        b = true;

        System.out.println("Address : ");
        address = get.nextLine();
        //check validation for input data
        while (b) {
            try {
                System.out.println("Phone Number : ");
                phoneNumber = Long.parseLong(get.nextLine());
                b = false;
            } catch (Exception e) {
                System.out.println("Enter Integer Value ");
                b = true;
            }
        }
        b = true;

        System.out.println("Status : ");
        status = get.nextLine();
        while (b) {
            try {
                System.out.println("Pay Rate : ");
                payRate = Double.parseDouble(get.nextLine());
                b = false;
            } catch (Exception e) {
                System.out.println("Enter Paty Rate in Decimal");
                b = true;
            }
        }
    }

    private void hourly_employee() {
        b = true;
        while (b) {
            try {
                System.out.println("Total Hours : ");
                totalHours = Double.parseDouble(get.nextLine());
                HourlyEmployee HE;
                HE = new HourlyEmployee(firstName, lastName, age, position, dateOfHire, address, phoneNumber, status, payRate, totalHours);
                emps.add(HE);
                choose_option();
                //add_search_employee();
                b = false;
            } catch (Exception e) {
                System.out.println("Enter Hours in Decimal");
                b = true;
            }
        }
    }

    private void salary_employee() {
        SalaryEmployee SE;
        SE = new SalaryEmployee(firstName, lastName, age, position, dateOfHire, address, phoneNumber, status, payRate);
        emps.add(SE);
        choose_option();
    }

    private void commission_employee() {
        //check validation for input data
        b = true;
        while (b) {
            try {
                System.out.println("Gross Sales: ");
                grossSale = Double.parseDouble(get.nextLine());
                b = false;
            } catch (Exception e) {
                System.out.println("Enter Gross Sales in Double");
                b = true;
            }
        }
        //check validation for input data
        b = true;
        while (b) {
            try {
                System.out.println("Commision Rate(%):   ");
                commisionRate = Double.parseDouble(get.nextLine());
                b = false;
            } catch (Exception e) {
                System.out.println("Enter commision rate in double");
                b = true;
            }
        }
        CommissionEmployee CE;
        CE = new CommissionEmployee(grossSale, commisionRate, firstName, lastName, age, position, dateOfHire, address, phoneNumber, status, payRate);
        emps.add(CE);
        choose_option();
    }

    private void display_employee() {
        System.out.println(emps);
        choose_option();
    }

    private void search_data(String search_employee) {
        //itretor for searching data
        Iterator<Employee> Iemps = emps.iterator();
        while (Iemps.hasNext()) {
            String stremp = Iemps.next().toString();
            if (stremp.contains(search_employee)) {
                System.out.print(stremp);
            } else {
                
            }
        }
        choose_option();
    }

    private void choose_option() {
        b = true;

        String option;

        while (b) {

            System.out.println("\nDo you want to continue (Y/N):");
            try {
                option = get.nextLine().toUpperCase();

                if (option.equals("Y")) {
                    product_employee();
                    b = false;
                } else if (option.equals("N")) {

                    b = false;
                } else {
                    System.out.println("Enter value Y or N as input.");
                    b = true;
                }
            } catch (Exception e) {
                System.out.println("Enter value Y or N as input.");
                b = true;
            }

        }

    }

    private void add_search_product() {
        b = true;

        int option;

        while (b) {

            System.out.println("1.\tAdd Product\n2.\tSearch Product\n3.\tDisplay Product List\nEnter your option:");
            try {
                option = Integer.parseInt(get.nextLine());

                if (option == 1) {
                    add_product();
                    b = false;
                } else if (option == 2) {
                    search_product_option();
                    b = false;
                } else if (option == 3) {
                    display_product();
                    b = false;
                } else {
                    System.out.println("Enter value 1 or 2 for options:");
                    b = true;
                }
            } catch (Exception e) {
                System.out.println("Enter value 1 or 2 for options:");
                b = true;
            }

        }
    }

    private void add_product() {
        System.out.println("Enter details of Product :\n------------------------------------------------------------\n Product Name:");
        productName = get.nextLine();
        System.out.println(" Category:");
        category = get.nextLine();
        System.out.println("For Manufacturer:");
        System.out.println("Enter details of Manufacture\n-----------------------------------------------------------------\nManufacture Name:");
        manufacuteName = get.nextLine();
        System.out.println("Address:");
        address = get.nextLine();
        System.out.println("Phone Number:");
        phoneNumber = Long.parseLong(get.nextLine());
        System.out.println("Contact:");
        contact = get.nextLine();
        System.out.println("-----------------------------------------------------------\n Description:");
        description = get.nextLine();
        System.out.println(" Part Name:");
        partNum = get.nextLine();

        b = true;
        while (b) {
            try {
                System.out.println(" Product Cost:");
                productCost = Double.parseDouble(get.nextLine());
                b = false;
            } catch (Exception e) {
                System.out.println("Enter product cost rate in decimal");
                b = true;
            }
        }

        b = true;
        while (b) {
            try {
                System.out.println(" Product Price:");
                productPrice = Double.parseDouble(get.nextLine());
                b = false;
            } catch (Exception e) {
                System.out.println("Enter product price in decimal");
                b = true;
            }
        }
        b = true;
        while (b) {
            try {
                System.out.println(" Product Markup:");
                productMarkup = Double.parseDouble(get.nextLine());
                b = false;
            } catch (Exception e) {
                System.out.println("Enter product markup in decimal");
                b = true;
            }
        }
        b = true;
        while (b) {
            try {
                System.out.println(" Minimum Inventory");
                minimumInventory = Integer.parseInt(get.nextLine());
                b = false;
            } catch (Exception e) {
                System.out.println("Enter minimum inventory in integer");
                b = true;
            }
        }
        Product PD = new Product(productName, category, description, partNum,
                productCost, productPrice, productMarkup, minimumInventory, manufacuteName, address, phoneNumber, contact);
        pds.add(PD);
        choose_option();
    }

    private void search_product(String search_ptoduct) {
        Iterator<Product> Iemps = pds.iterator();
        while (Iemps.hasNext()) {
            String stremp = Iemps.next().toString();
            if (stremp.contains(search_ptoduct)) {
                System.out.print(stremp);
            } else {
                
            }
        }
        choose_option();
    }

    private void display_product() {
        System.out.println(pds);
        choose_option();
    }

    private void search_product_option() {
        b = true;

        int option;

        while (b) {

            System.out.println("1.\tProdact Name\n2.\tCategory\n3.\tProduct ID\nEnter your option for searching:");
            try {
                option = Integer.parseInt(get.nextLine());

                
                if (option == 1) {
                    System.out.println("Enter Product Name:");
                    search_product = get.nextLine();
                    search_product(search_product);
                    b = false;
                } else if (option == 2) {
                    System.out.println("Enter Category Name:");
                    search_product = get.nextLine();
                    search_product(search_product);
                    b = false;
                } else if (option == 3) {
                    System.out.println("Enter Product ID:");
                    search_product = get.nextLine();
                    search_product(search_product);
                    b = false;
                } else {
                    System.out.println("Enter value between 1 and 3 for options:");
                    b = true;
                }
            } catch (Exception e) {
                System.out.println("Enter value between 1 and 3  for options:");
                b = true;
            }

        }
    }
}

