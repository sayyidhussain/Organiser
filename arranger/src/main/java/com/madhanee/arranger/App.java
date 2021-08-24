package com.madhanee.arranger;

import java.util.Arrays;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext con =new ClassPathXmlApplicationContext("config.xml");
        Bifurcator org=(Bifurcator)con.getBean("bifurc");
        Scanner sc=new Scanner(System.in);
        System.out.println("Kindly inculde '~!' to the filename for the files that you dont want to move");
        System.out.println("Please Enter directory or that need to organised");
        String path=sc.nextLine();
        org.bifri(path);
        FolderOperations folop=(FolderOperations)con.getBean("folop");
        folop.checkfile(path);
    }
}
