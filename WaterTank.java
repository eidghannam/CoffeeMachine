/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author sky
 * 
 */

public class WaterTank {
    private final int tank_capacity=500;
    private int level;
    
    public WaterTank(int level){
        this.level=level;
    }
     public WaterTank(){
     
     }

    public int getTank_capacity() {
        return tank_capacity;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void fill(int amount)throws WaterTankOverflowException{
       
            if(this.level+amount>tank_capacity)
                throw new WaterTankOverflowException("water Tank overflow");
            else
                this.level +=amount;
        
    }
    
    public void withdraw(int amount)throws NoEnoughWaterException{
        
            if(this.level-amount <0)
            throw new NoEnoughWaterException("No Enough Water");
        else
            this.level -=amount;
        
       
    }
}
