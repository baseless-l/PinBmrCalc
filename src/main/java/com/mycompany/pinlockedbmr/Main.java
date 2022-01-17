/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.pinlockedbmr;
import java.util.InputMismatchException; 
import java.util.Scanner;
/**
 *
 * @author Kian Frawley
 * @version 0.03
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int guess;
        int pick;
        
        Scanner in = new Scanner(System.in);
        
       try
       {
          
        
           User u1 = new User();
           do
           {
                System.out.println("Please Enter Access PIN.");
                //System.out.println("──▄▀▀▀▄───────────────");
                //System.out.println("──█──────█───────────────");
                //System.out.println("─███████─────────▄▀▀▄─");
                //System.out.println("░███─▀─██░░█▀█▀▀▀▀█░░█░");
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
                 System.out.println(u1.toString());
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
       catch(Exception ex)
       {
           System.out.println(ex);
       }
       
       }
    }
    

