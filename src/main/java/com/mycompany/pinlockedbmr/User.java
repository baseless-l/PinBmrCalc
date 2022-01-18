/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pinlockedbmr;
import java.io.Serializable;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



/**
 *
 * @author Kian Frawley
 */
public class User implements Serializable
{
    int PIN = 2000;
    int age = 25; //In years
    int weight = 160; //In pounds
    int height = 60; //In inches
    double BMR;
    Boolean gender = false; //False corrilates to male, true corrilates to female.
    String uname = "David";
    
    /**
    * No-arg constructor for user
    */
    public User()
    {
        this(0,0,0,false,"");
    }
    
    /**
    * Constructor for user class.
    * 
    * @param PIN PIN to access account.
    * @param age age of the user.
    * @param weight weight of the user.
    * @param gender gender of the user.
    * @param uname name of the user.
    */
    public User(int PIN,int age,int weight,Boolean gender,String uname)
    {
        
        
    
    };
    
    /**
    * Set method for data field PIN that takes a int as an argument
    * 
    * @param pin the users PIN. 
    **/
    public void setPIN(int pin)
    {
      this.PIN = pin;
    }
    
    /**
    * Set method for data field age that takes a int as an argument
    * 
    * @param age the users age. 
    **/
    public void setAge(int age)
    {
      this.age = age;
    }

    /**
    * Set method for data field weight that takes a int as an argument
    * 
    * @param weight the users weight. 
    **/
    public void setWeight(int weight)
    {
      this.weight = weight;
    }
    
    /**
    * Set method for data field gender that takes a boolean as an argument
    * 
    * @param gender the users Gender.     
    **/
    public void setGender(boolean gender)
    {
      this.gender = gender;
    }
    
    /**
    * Set method for data field BMR that takes a int as an argument
    * 
    * @param BMR the users BMR.     
    **/
    public void setBMR(double BMR)
    {
      this.BMR = BMR;
    }
    
    
    /**
    * Set method for data field uname that takes a string as an argument
    * 
    * @param uname the users name.     
    **/
    public void setuname(String uname)
    {
      this.uname = uname;
    }
    
    /**
    * Set method for data field height that takes a int as an argument
    * 
    * @param height the users height.     
    **/
    public void setHeight(int height)
    {
      this.height = height;
    }
    
    
    /**
    * Get method for data field uname.
    * 
    *@return uname Users name.     
    **/
    public String getUname()
    {
      return uname;
    }
    
    /**
    * Get method for data field gender.
    * 
    *@return gender Users gender.     
    **/
    public boolean getGender()
    {
      return gender;
    }
    
    /**
    * Get method for data field weight.
    * 
    *@return weight Users weight.     
    **/
    public int getWeight()
    {
      return weight;
    }
    
    /**
    * Get method for data field height.
    * 
    *@return height Users height.     
    **/
    public int getHeight()
    {
      return height;
    }
    
    /**
    * Get method for data field age.
    * 
    *@return age Users age.     
    **/
    public int getAge()
    {
      return age;
    }
    
    /**
    * Get method for data field PIN.
    * 
    *@return PIN Users PIN.     
    **/
    public int getPIN()
    {
      return PIN;
    }
    
    /**
     * Get method for data field BMR
     * 
     * @return BMR users Base line metabolic rate, in calories.
     */
     public double getBMR()
     {
        return BMR;
     }
    /**
     * Method used to preform calculation that determines BMR data field.
     */
    public void calcBMR()
    {
    
        if(getGender() == true)//Meaning female. 
        {
            setBMR(655 + (4.35 * getWeight()) + (4.7 * getHeight()) - (4.7 * getAge()));
            System.out.println("Your Baseline metabolic rate is " + String.format("%.2f", getBMR()));
        }
        else //Meaning Male.
           setBMR(66 + (6.23 * getWeight()) + (12.7 * getHeight()) - (6.8 * getAge())); 
           System.out.println("Your Baseline metabolic rate is " + String.format("%.2f", getBMR()));
    }
    /**
     * Method to determine if the user is in a state of caloric deficit, maintance, or surplus.
     * 
     * @throws BmrException 
     */
    public void daliyIntake() throws BmrException
    {
        Scanner in = new Scanner(System.in);    
        
        System.out.println("Please enter you caloric intake for " + java.time.LocalDate.now() + '.');
        
        double c = Double.parseDouble(in.nextLine());
        
        if(getBMR() > 0.0)
        {
            if(getBMR() > c)
            {      
               System.out.println("You have eaten less then you BMR, You are in a caloric deficit of " + String.format("%.2f",(getBMR() - c)) + " calories!"); //If you do not format the result will have a binary rounding error.
            }    
            if(getBMR() < c)
            {
               System.out.println("You have eaten more then you BMR, You are in a caloric surplus of " + String.format("%.2f",-(getBMR() - c)) + " calories!"); 
            }
            if(getBMR() == c)
            {   
                System.out.println("You are in a state of caloric maintance!");
            }
        }
        else 
            throw new BmrException();
        }
       /**
        * Method used to edit users data fields.
        */
       public void editInfo()
       {
        int input; 
      
        Scanner in = new Scanner(System.in); 
        
           do 
           {   
              
           System.out.println(" ______________________________________");
           System.out.println("|What field would you like to edit.    |");
           System.out.println("|1.Edit BMR.                           |");
           System.out.println("|2.Edit Age.                           |");
           System.out.println("|3.Edit Weight.                        |");
           System.out.println("|4.Edit Height.                        |");
           System.out.println("|5.Edit PIN.                           |");
           System.out.println("|6.Edit Gender.                        |");
           System.out.println("|7.Edit Name.                         |");
           System.out.println("|0.Exit To Home.                       |");
           System.out.println("|______________________________________|");  
           
           input = in.nextInt();
           
           switch(input)
           {
               
               case 1:
                  System.out.println("Log your BMR below!");
                  setBMR(Double.parseDouble(in.next()));
                  System.out.println("Your BMR is now " + getBMR() + '!');
                  
                  break;
               
               case 2:  
                  System.out.println("Log your age below!");
                  setAge(Integer.parseInt((in.next())));
                  System.out.println("Your age is now " + getAge() + '!');
                   
                  break;
                  
                case 3:  
                  System.out.println("Log your weight below!");
                  setWeight(Integer.parseInt((in.next())));
                  System.out.println("Your weight is now " + getWeight() + '!');
                   
                  break; 
               
                case 4:  
                  System.out.println("Log your height below!");
                  setHeight(Integer.parseInt((in.next())));
                  System.out.println("Your Height is now " + getHeight() + '!');
                   
                  break;  
                
                case 5:  
                  System.out.println("Log your PIN below!");
                  setPIN(Integer.parseInt((in.next())));
                  System.out.println("Your PIN is now " + getPIN() + '!');
                   
                  break;  
                  
                case 6:  
                  System.out.println("Pick your Gender below!");
                  System.out.println(" ______________________ ");
                  System.out.println("|1.Male                |");
                  System.out.println("|2.Female              |");
                  System.out.println("|______________________|");
                    input  = in.nextInt();
                    
                   do{
                   
                        if(input == 1)
                        {
                            setGender(false); 
                            System.out.println("Your Gender is now male" + '!');
                            input = 3;
                        }
                        
                        if(input == 2)
                        {
                            setGender(true);
                            System.out.println("Your Gender is now female" + '!');
                            input = 3;
                        }
          
                   }while(input != 3);
                    

                  break;
                  
                case 7:
                  System.out.println("Log your name below!");
                  setuname(in.next());
                  System.out.println("Your name is now " + getUname() + '!');
                  
                  
               case 0:
                 
                 break;
               
               
           }    
           
           }while(input != 0);
       }
        
      /**
      * Method used to save user data fields to a file.
      */
      public void output()
      {
        
      }    
       
      /**
      * Method used to load user data fields from a file.
      */
      public void input()
      {
        
      }     
       
     /**
     * toString method for a user object, returns descriptive information
     * regarding user. 
     * 
     * @return string that contains user info. 
     */
     @Override 
     public String toString()
     {
         StringBuilder output = new StringBuilder();
         output.append("User PIN: ");
         output.append(getPIN());
         output.append("\n");
         output.append("User Age: ");
         output.append(getAge() + " Years");
         output.append("\n");
         output.append("User Weight: ");
         output.append(getWeight() + " lbs" );
         output.append("\n");
         output.append("User Height: ");
         output.append(getHeight() + " cm");
         output.append("\n");
         output.append("User BMR: ");
         output.append(String.format("%.2f", getBMR()) + " Calories");
         output.append("\n");
         output.append("User Gender: ");
            if(getGender() == true) 
                {
                 output.append("Female");
                }
            else 
                output.append("Male");
        output.append("\n");
        output.append("User Name: ");
        output.append(getUname());
        output.append("\n");
                 
         return output.toString();
     }
    }
    

  
    
    
    


