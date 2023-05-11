/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

import java.io.Serializable;

/**
 *
 * @author sky
 */
public class BeansTank implements Serializable{
    private int arabica_beans;
    private int robusta_beans;
    private int total_beans;
    private final int tank_capacity=500;

    public int getTotal_beans() {
        return total_beans;
    }

    public void setTotal_beans(int total_beans) {
        this.total_beans = total_beans;
    }
    public int getTank_capacity() {
        return tank_capacity;
    }
    public BeansTank(int arabica_beans,int robusta_beans){
        this.arabica_beans=arabica_beans;
        this.robusta_beans=robusta_beans;
        this.total_beans=arabica_beans+robusta_beans;
        
    }
    
    public BeansTank(){
        
    }
    public void addBeans(int arabica_beans_to_add,int robusta_beans_to_add) throws BeansTankOverflowException{
       
        if(arabica_beans_to_add+this.total_beans>this.tank_capacity)
            throw new BeansTankOverflowException("beans tank overflow");
        else
             this.arabica_beans += arabica_beans_to_add;
        
        if(robusta_beans_to_add+this.total_beans>this.tank_capacity)
            throw new BeansTankOverflowException("beans tank overflow");
        else
            this.robusta_beans += robusta_beans_to_add;
        this.total_beans += (arabica_beans_to_add+robusta_beans_to_add);
       
    }
        
    
    
    public double getArabicaRatio(){
        return (double) this.arabica_beans/this.total_beans;
    }
    
    public double getRobustacaRatio(){
        return (double) this.robusta_beans/this.total_beans;
    }

    public void withdrawBeans(int amount) throws NoEnoughBeansException{
       
            if(this.total_beans-amount<0)
               throw new NoEnoughBeansException("No Enough Beans");
            else
               this.total_beans -=amount;
        
       }
}
