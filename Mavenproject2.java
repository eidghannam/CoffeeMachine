/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject2;

import java.util.Scanner;

/**
 *
 * @author sky
 */
public class Mavenproject2 {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
       CoffeeMachine Cmachine=new CoffeeMachine(500,200,300);
       int choice;
       System.out.println("1- add water");
       System.out.println("2- add coffee");
       System.out.println("3- Start");
       System.out.print("enter your choice : ");
       System.out.println("");
       choice=input.nextInt();
       
       while(choice !=5){
       switch(choice){
           case 1:
               System.out.print("enter the amount of water to be add : ");
               int addedWater=input.nextInt();
               try{
               //Cmachine.addWater(addedWater);
               Cmachine.getWaterTank().fill(addedWater);
              
               }
               catch(WaterTankOverflowException ex){
                   System.out.println(ex.getMessage());
                   Cmachine.getWaterTank().setLevel(Cmachine.getWaterTank().getTank_capacity());
               }
               break;
           case 2:
               System.out.print("enter the amount of arabica coffee beans to be added : ");
               int arabica=input.nextInt();
               System.out.print("enter the amount of robusta coffee beans to be added : ");
               int robusta=input.nextInt();
               try{
               Cmachine.getBeansTank().addBeans(arabica, robusta);
              
               }
               catch(BeansTankOverflowException ex){
                   System.out.println(ex.getMessage());
               }
               break;
           case 3:
               if(Cmachine.isIs_clean()==true)
               {
                 try{
                 Cmachine.Start();
                 }
                    catch(EmptyMachineException ex ){
                        System.out.println(ex.getMessage());
                        System.out.print("enter the amount of water you want to add : ");
                       int water_to_add=input.nextInt();
                       try{
                       Cmachine.getWaterTank().fill(water_to_add);
                       }
                       catch(WaterTankOverflowException ex1){
                           System.out.println(ex1.getMessage());
                           Cmachine.getWaterTank().setLevel(Cmachine.getWaterTank().getTank_capacity());
                       }
                       System.out.print("enter the amount of arabica beans to add : ");
                       int arabica_beans_to_add=input.nextInt();
                       System.out.print("enter the amount of robusta beans to add : ");
                       int robusta_beans_to_add=input.nextInt();
                       try{
                       Cmachine.getBeansTank().addBeans(arabica_beans_to_add, robusta_beans_to_add);
                       }
                       catch(BeansTankOverflowException ex2){
                           System.out.println(ex2.getMessage());
                           Cmachine.getBeansTank().setTotal_beans(Cmachine.getBeansTank().getTank_capacity());
                       }
                    }
                    catch(EmptyBeansTankException ex){
                        System.out.println(ex.getMessage());
                        System.out.print("enter the amount of arabica beans to add : ");
                       int arabica_beans_to_add=input.nextInt();
                       System.out.print("enter the amount of robusta beans to add : ");
                       int robusta_beans_to_add=input.nextInt();
                       try{
                       Cmachine.getBeansTank().addBeans(arabica_beans_to_add, robusta_beans_to_add);
                       }
                       catch(BeansTankOverflowException ex1){
                           System.out.println(ex1.getMessage());
                           Cmachine.getBeansTank().setTotal_beans(Cmachine.getBeansTank().getTank_capacity());
                       }
                    }
                    catch(EmptyWaterTankException ex){
                        System.out.println(ex.getMessage());
                        System.out.print("enter the amount of water you want to add : ");
                       int water_to_add=input.nextInt();
                       try{
                       Cmachine.getWaterTank().fill(water_to_add);
                       }
                       catch(WaterTankOverflowException ex1){
                           System.out.println(ex1.getMessage());
                           Cmachine.getWaterTank().setLevel(Cmachine.getWaterTank().getTank_capacity());
                       }
                    }
                   System.out.println("1- Espresso Single");
                   System.out.println("2- Amrecano Single");
                   System.out.println("3- Espresso Double");
                   System.out.println("4- Amrecano Double");
                   System.out.print(" enter your choice : ");
                   int coffeChoice=input.nextInt();
                   try{
                   Cmachine.setCoffee(coffeChoice);
                   System.out.println("the amount of caffeine in the cup is : "+Cmachine.amountOfCaffeine(coffeChoice)+" grams");
                   System.out.println("the remaining coffee : "+Cmachine.getBeansTank().getTotal_beans());
                   System.out.println("the remaining water : "+Cmachine.getWaterTank().getLevel());
                   }
                   catch(NoEnoughBeansException ex){
                       System.out.println(ex.getMessage());
                       System.out.print("enter the amount of arabica beans to add : ");
                       int arabica_beans_to_add=input.nextInt();
                       System.out.print("enter the amount of robusta beans to add : ");
                       int robusta_beans_to_add=input.nextInt();
                       try{
                       Cmachine.getBeansTank().addBeans(arabica_beans_to_add, robusta_beans_to_add);
                       }
                       catch(BeansTankOverflowException ex1){
                           System.out.println(ex1.getMessage());
                           Cmachine.getBeansTank().setTotal_beans(Cmachine.getBeansTank().getTank_capacity());
                       }
                   }
                   catch(NoEnoughWaterException ex){
                       System.out.println(ex.getMessage());
                       System.out.print("enter the amount of water you want to add : ");
                       int water_to_add=input.nextInt();
                       try{
                       Cmachine.getWaterTank().fill(water_to_add);
                       }
                       catch(WaterTankOverflowException ex1){
                           System.out.println(ex1.getMessage());
                           Cmachine.getWaterTank().setLevel(Cmachine.getWaterTank().getTank_capacity());
                       }
                   }
                   break;
                }
               else
               {
                   System.out.println("the machine need to clean!! ,please press any button to clean the machine ");
                   char clean=input.next().charAt(0);
                   Cmachine.clean_waste_tray(clean);
               }
       }
           
       System.out.println("");
       System.out.print("enter your choice : ");
       choice=input.nextInt();
       }
       
    }
}
