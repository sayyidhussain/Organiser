package com.madhanee.arranger;

import java.util.Arrays;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FolderOperations {
	Bifricator bifri;
	String[] files;
	String[] folders;
	public FolderOperations(Bifricator bifri) {
       this.bifri=bifri;
	}
	public void checkfile() {
		this.files=bifri.isfile();
	    this.folders=bifri.isfolder();
		System.out.println(Arrays.toString(files));
        System.out.println(Arrays.toString(folders));
	}
}
