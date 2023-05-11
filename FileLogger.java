/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author sky
 */
public class FileLogger implements Logger,Serializable{
   private File file;

    public FileLogger() {
    }

    public FileLogger(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
   
    /**
     *
     * @param msg
     */
    @Override
    public void log(String msg){
       
        try {
            FileWriter fr=new FileWriter(this.file,true);
            fr.write(msg);
            fr.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
           java.util.logging.Logger.getLogger(FileLogger.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
