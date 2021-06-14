package com.madhanee.arranger;

import java.io.File;
import java.util.Arrays;


public class FolderOperations {
	Bifricator bifri;
	String[] files;
	String[] folders;
	String constant;
	public String getConstant() {
		return constant;
	}
	public void setConstant(String constant) {
		this.constant = constant;
	}
	public FolderOperations(Bifricator bifri) {
       this.bifri=bifri;
	}
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
	public String foldermanager(boolean tocheck,String filetype,String path) {
		if(tocheck) {
			int check=checker(folders,filetype);
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
	public int checker(String[] folder,String type) {
		for(String i:folder) {
			if(i.equals(type)) {
				return 1;
			}
		}
		return 0;
		
	}
}
