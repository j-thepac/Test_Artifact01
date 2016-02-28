package com.gradletest;

//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;

import com.library.GUI_Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.swing.*;

/**
 * Created by Guest on 2/21/2016.
 */
public class gradletest {

    public   static StringBuffer check_execution =new StringBuffer();
    public static String username;
    public static boolean bReporter_done=false;
    @BeforeSuite

    public void GUI(){

        GUI_Test gui_window;
        gui_window=new GUI_Test();
        gui_window.setVisible(true);
        do{
            if(gui_window.exit_execution==true)
            {
                System.out.println("Force exit in console");
                System.exit(0);
            }


            if(gui_window.start_execution==true){
                if(gui_window.bRun_Chrome==false && gui_window.bRun_Firefox==false && gui_window.bRun_IE==false ){
                    JOptionPane.showMessageDialog(null, "Select any browser");
                    gui_window.start_execution=false;
                    continue;
                }
                else if (gui_window.username.contentEquals("")){
                    JOptionPane.showMessageDialog(null, "enter username");
                    gui_window.start_execution=false;
                    continue;
                }
                else
                    break;
            }
        }while(1==1);

        bReporter_done=true;
        username=gui_window.username;

        if(gui_window.bRun_Firefox==true )
            check_execution=check_execution.append("firefox,");
        if(gui_window.bRun_Chrome==true )
            check_execution=check_execution.append("chrome,");
        if(gui_window.bRun_IE==true )
            check_execution=check_execution.append("ie,");


        gui_window.setVisible(false);
        gui_window.dispose();

    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }
}
