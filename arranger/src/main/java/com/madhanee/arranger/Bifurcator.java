package com.madhanee.arranger;

import java.io.File;
//To bifurcate file and folders in the given path
public class Bifurcator {
	 File infol; 
	public void bifri(String path) {
		File infol=new File(path);
		this.infol=infol;
	}
	public String[] isfolder() {
		File infile=this.infol;
		String[] fold= infile.list((File dir,String name)-> new File(dir,name).isDirectory());
		return fold;
	}
	public String[] isfile() {
		File infile=this.infol;
		String[] file= infile.list((File dir,String name)-> new File(dir,name).isFile());
		return file;
	}
}
