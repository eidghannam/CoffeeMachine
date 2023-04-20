/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author sky
 */
public class CoffeeMachine {
    private WaterTank waterTank;
    private BeansTank beansTank;
    int[][] BeansShots ={{7,7},{14,14}};     //{{Espresso Single,Amrecano Single},{Espresso Double,Amricano Double}}
    int[][] WaterShots={{30,170},{60,220}};  //{{Espresso Single,Amrecano Single},{Espresso Double,Amrecano Double}}
    private boolean is_clean;
    private int clean_counter=0;

    public boolean isIs_clean() {
        return (clean_counter<=4);
    }

    public void setIs_clean(boolean is_clean) {
        this.is_clean = is_clean;
    }

    public int getClean_counter() {
        return clean_counter;
    }

    public void setClean_counter(int clean_counter) {
        this.clean_counter = clean_counter;
    }
    
    
    
    
    public CoffeeMachine(int waterLevel,int arabica_level,int robusta_level){
        this.waterTank=new WaterTank(waterLevel);
        this.beansTank=new BeansTank(arabica_level,robusta_level);
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
            System.out.println("the machine is ready to start");
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
               break;
       }
       clean_counter++;
       
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
    /*public void addCoffeeBeans(int arabica,int robusta)throws BeansTankOverflowException{
        this.beansTank.addBeans(arabica, robusta);
    }*/
    
   /* public void addWater(int amount) throws WaterTankOverflowException{
        this.waterTank.fill(amount);
    }*/
    public void clean_waste_tray(char clean){
       if(clean != '0')
           this.clean_counter=0;
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
