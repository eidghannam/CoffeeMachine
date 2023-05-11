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
public class WasteTray implements Serializable{
     private int clean_counter=0;

    public WasteTray() {
    }

     
    public int getClean_counter() {
        return clean_counter;
    }

    public void setClean_counter(int clean_counter) {
        this.clean_counter = clean_counter;
    }
    
    public boolean isClean(){
        
        if(this.clean_counter <=4)
            return true;
        else
            return false;
    }
    
    public void cleanWasteTray(){
        this.clean_counter=0;
    }
}
