/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.pinlockedbmr;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.InputMismatchException; 
import java.util.Scanner;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 *
 * @author Kian Frawley
 * @version 0.05, 0.05 adds the ability to save user info from instance to instance.
 */
public class Main   
{
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int guess;
        int pick;

        Scanner in = new Scanner(System.in);
        
       try
       {
           // Should Load User info.
           User u1 = null;
           FileInputStream fileIn = new FileInputStream("User.ser");
           ObjectInputStream inObj = new ObjectInputStream(fileIn);
           u1 = (User)inObj.readObject();
           inObj.close();
           fileIn.close();
           //
           do
           {
                System.out.println("Please Enter Access PIN.");
                //System.out.println("───▄▀▀▀▄──────────────────────────────");
                //System.out.println("───█──────█──────────────────────────────");
                //System.out.println("──███████─────────────────▄▀▀▄─");
                //System.out.println("░███─███░░█▀█▀▀▀▀█░░█░");
                //System.out.println("░███▄███░░▀░▀░░░░░▀▀░░");
                
                guess = Integer.parseInt(in.nextLine());
                 
           }while(u1.getPIN() != guess);   
           

           do{
           System.out.println(" ______________________________________");
           System.out.println("|Hello and Welcome to CalTracker v0.03|");
           System.out.println("|What would you like to do toady?     |");
           System.out.println("|1.Calculate BMR.                     |");
           System.out.println("|2.Log Daliy Caloric Intake.          |");
           System.out.println("|3.Display User Info.                 |");
           System.out.println("|4.Edit User info.                    |");
           System.out.println("|5.Save User info.                    |");
           System.out.println("|0.End Application.                   |");
           System.out.println("|_____________________________________|");
           
           pick = Integer.parseInt(in.nextLine());
             
           switch(pick)
           {
               case 1:
                u1.calcBMR();
                break;
                
               case 2:
                u1.daliyIntake();
                break;
               
               case 3:
                System.out.println(u1);
                break;
                
               case 4:
                   u1.editInfo();
                break; 
               
               case 5:
                FileOutputStream fileOut = new FileOutputStream("User.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(u1);
                System.out.println("Data has been saved!!");
                out.close();
                fileOut.close();
                break;
                
               case 0:
                 System.out.println("Goodbye");
                 break;
           }
           
          
           }while(pick != 0);
       }
       
       
       
       catch(BmrException ex)
       {
         System.out.println(ex);
       }
       catch(InputMismatchException ex)
       {
           System.out.println(ex);
       }
       
       catch(FileNotFoundException ex)
       {
           System.out.println(ex);
       }
       
      catch(IOException ex)
        {
            System.out.println("File read/write error!");
        }
       
       catch(Exception ex)
       {
           System.out.println(ex);
       }  
    }
}
