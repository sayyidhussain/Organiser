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
        Bifricator org=(Bifricator)con.getBean("bifurc");
        Scanner sc=new Scanner(System.in);
        String path=sc.nextLine();
        org.bifri(path);
        System.out.println(Arrays.toString(org.isfile()));
        System.out.println(Arrays.toString(org.isfolder()));
        FolderOperations folop=(FolderOperations)con.getBean("folop");
        folop.checkfile();
    }
}
