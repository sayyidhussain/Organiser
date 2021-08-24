package com.madhanee.arranger;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

//For all folder related operations
public class FolderOperations {
	Bifurcator bifri;
	String[] files;
	String[] folders;
	String constant;
	Scanner sc;
	public String getConstant() {
		return constant;
	}
	public void setConstant(String constant) {
		this.constant = constant;
	}
	//To get class bifurcator using bean
	public FolderOperations(Bifurcator bifri) {
       this.bifri=bifri;
	}
	//Check file types inorder to find whether it is necessary to create folder
	public void checkfile(String path) {
		this.files=bifri.isfile();
	    this.folders=bifri.isfolder();
		System.out.println(Arrays.toString(files));
        System.out.println(Arrays.toString(folders));
        
        Boolean doccheck=false;
        Boolean piccheck=false;
        Boolean vidcheck=false;
        Boolean audcheck=false;
        for(int i=0;i<files.length;i++) {
        	if(!files[i].contains(constant)) {
	        	String val=files[i].substring(files[i].indexOf(".")+1);
	        	if(val.equals("pdf") || val.equals("docx")) {
	        		doccheck=true;
	        	}else 
	        	if(val.equals("png") || val.equals("jpg")) {
	        		piccheck=true;
	        	}else if(val.equals("mkv") || val.equals("mp4")){
	        		vidcheck=true;
	        	}else if(val.equals("flac") || val.equals("mp3")) {
	        		audcheck=true;
	        	}
        	}
        }
        checkfolder(doccheck,piccheck,vidcheck,audcheck,path);
        
	}
	public void checkfolder(boolean doccheck,boolean piccheck,boolean vidcheck,boolean audcheck,String path) {
		System.out.println(Arrays.toString(folders));
		System.out.println(foldermanager(doccheck,"Documents",path));
		System.out.println(foldermanager(piccheck,"Pictures",path));
		System.out.println(foldermanager(vidcheck,"Videos",path));
		System.out.println(foldermanager(audcheck,"Audios",path));
		
		System.out.println(doccheck+" "+piccheck+" "+vidcheck+" "+audcheck);
	}
	//TO create folder if folder not present
	public String foldermanager(boolean tocheck,String filetype,String path) {
		if(tocheck) {
			int check=checker(folders,filetype);
			//TO create folder if folder not present
			if(check==0) {
				File crfolder=new File(path+"/"+filetype);
				if(crfolder.mkdir()) {
					return filetype+" folder created ";
				}else {
					return "Unable to create folder "+filetype;
				}

			}
			return "Folder Already available";
		}
		return "No need to create folder";
	}
	//TO find whether the folder is present or not
	public int checker(String[] folder,String type) {
		for(String i:folder) {
			if(i.equals(type)) {
				return 1;
			}
		}
		return 0;
		
	}
	public void rename(String[] folders,String path) throws InterruptedException {
		for(String  o:folders) {
			if(o.contains("New Folder")) {
				System.out.println("We found a folder named "+o+" do you wish to rename it");
				 sc=new Scanner(System.in);
				 Thread.sleep(10000);
			}
		}
	}
}
