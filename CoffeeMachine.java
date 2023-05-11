/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author sky
 */
public class CoffeeMachine implements Serializable{
    private WaterTank waterTank;
    private BeansTank beansTank;
    private WasteTray wasteTray;
    private Logger logger;
    int[][] BeansShots ={{7,7},{14,14}};     //{{Espresso Single,Amrecano Single},{Espresso Double,Amricano Double}}
    int[][] WaterShots={{30,170},{60,220}};  //{{Espresso Single,Amrecano Single},{Espresso Double,Amrecano Double}}
    private  int cupCounter=0;
    private  int cleanCounter=0;

    public int getCupCounter() {
        return cupCounter;
    }

    public void setCupCounter(int cupCounter) {
        this.cupCounter = cupCounter;
    }

    public int getCleanCounter() {
        return cleanCounter;
    }

    public void setCleanCounter(int cleanCounter) {
        this.cleanCounter = cleanCounter;
    }
    

    public WasteTray getWasteTray() {
        return wasteTray;
    }

    public void setWasteTray(WasteTray wasteTray) {
        this.wasteTray = wasteTray;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
    //WaterTank wt=new WaterTank();
    
    public CoffeeMachine(int waterLevel,int arabica_level,int robusta_level,Logger logger){
        this.waterTank=new WaterTank(waterLevel);
        this.beansTank=new BeansTank(arabica_level,robusta_level);
        this.wasteTray=new WasteTray();
        this.logger=logger;
        this.cupCounter=0;
        this.cleanCounter=0;
    }
    
    public void  Start() throws EmptyMachineException,EmptyBeansTankException,EmptyWaterTankException{
        
        if(this.waterTank.getLevel()==0 && this.beansTank.getTotal_beans()==0)
        {
            throw new EmptyMachineException("EmptyMachineException");
        }
        else if(this.waterTank.getLevel()>0 && this.beansTank.getTotal_beans()==0)
        {
            throw new EmptyBeansTankException("the machine is out of beans!!, please add some coffee beans");
        }
        else if(this.waterTank.getLevel()==0 && this.beansTank.getTotal_beans()>0)
        {
            throw new EmptyWaterTankException("the machine is out of water!!, please add some water");
        }
        else
        {
            //System.out.println("the machine is ready to start");
        }
           
        
    }
    public void setCoffee(int typeNum)throws NoEnoughBeansException,NoEnoughWaterException{
        
       switch(typeNum)
       {
           case 1:
               if(this.beansTank.getTotal_beans()<BeansShots[0][0])
                   throw new NoEnoughBeansException("no enoguh beans");
               else
                   beansTank.withdrawBeans(BeansShots[0][0]);
               
               if(this.waterTank.getLevel()<WaterShots[0][0])
                   throw new NoEnoughWaterException("no enough water");
               else
                   waterTank.withdraw(WaterShots[0][0]);
               
               this.logger.log("espresso Single\n");
               this.cupCounter++;
               break;
           case 2:
               if(this.beansTank.getTotal_beans()<BeansShots[0][1])
                   throw new NoEnoughBeansException("no enoguh beans");
               else
                   beansTank.withdrawBeans(BeansShots[0][1]);
               
               if(this.waterTank.getLevel()<WaterShots[0][1])
                   throw new NoEnoughWaterException("no enough water");
               else
                   waterTank.withdraw(WaterShots[0][1]);
               this.logger.log("Amricano Single\n");
               this.cupCounter++;
               break;
           case 3:
               if(this.beansTank.getTotal_beans()<BeansShots[1][0])
                   throw new NoEnoughBeansException("no enoguh beans");
               else
                   beansTank.withdrawBeans(BeansShots[1][0]);
               
               if(this.waterTank.getLevel()<WaterShots[1][0])
                   throw new NoEnoughWaterException("no enough water");
               else
                   waterTank.withdraw(WaterShots[1][0]);
               this.logger.log("espresso Double\n");
               this.cupCounter++;
               break;
           case 4:
              if(this.beansTank.getTotal_beans()<BeansShots[1][1])
                   throw new NoEnoughBeansException("no enoguh beans");
               else
                   beansTank.withdrawBeans(BeansShots[1][1]);
              
               if(this.waterTank.getLevel()<WaterShots[1][1])
                   throw new NoEnoughWaterException("no enough water");
               else
                   waterTank.withdraw(WaterShots[1][1]);
               this.logger.log("Amricano Double\n");
               this.cupCounter++;
               break;
       }
       this.wasteTray.setClean_counter(this.wasteTray.getClean_counter()+1);
       
       
    }
    public double amountOfCaffeine(int typeNum){
        double caffeine_content_arabica=0.012;
        double caffeine_content_robusta=0.022;
        double amountOfcaff=0;
        switch(typeNum)
        {
            case 1:
                amountOfcaff=(this.beansTank.getArabicaRatio()*BeansShots[0][0]*caffeine_content_arabica)+(this.beansTank.getRobustacaRatio()*BeansShots[0][0]*caffeine_content_robusta);
                return amountOfcaff;
            case 2:
                amountOfcaff=(this.beansTank.getArabicaRatio()*BeansShots[0][1]*caffeine_content_arabica)+(this.beansTank.getRobustacaRatio()*BeansShots[0][1]*caffeine_content_robusta);
                return amountOfcaff;
            case 3:
                amountOfcaff=(this.beansTank.getArabicaRatio()*BeansShots[1][0]*caffeine_content_arabica)+(this.beansTank.getRobustacaRatio()*BeansShots[1][0]*caffeine_content_robusta);
                return amountOfcaff;
            case 4:
                amountOfcaff=(this.beansTank.getArabicaRatio()*BeansShots[1][1]*caffeine_content_arabica)+(this.beansTank.getRobustacaRatio()*BeansShots[1][1]*caffeine_content_robusta);
                return amountOfcaff;
        }
        return 0;
        
    }
    
    public WaterTank getWaterTank() {
        return waterTank;
    }

    public void setWaterTank(WaterTank waterTank) {
        this.waterTank = waterTank;
    }

    public BeansTank getBeansTank() {
        return beansTank;
    }

    public void setBeansTank(BeansTank beansTank) {
        this.beansTank = beansTank;
    }
    
}
