package com.madhanee.arranger;

import java.util.Arrays;

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
        org.bifri("C:\\Users\\HUSSAIN AHAMED\\Desktop\\New folder");
        System.out.println(Arrays.toString(org.isfile()));
        System.out.println(Arrays.toString(org.isfolder()));
    }
}
