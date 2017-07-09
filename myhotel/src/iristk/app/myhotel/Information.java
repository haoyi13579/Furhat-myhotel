package iristk.app.myhotel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Information {
	
	Scanner scan = null;
	
	public ArrayList<String> readattr() {
		
		File file = new File("E:/IrisTK/app/myhotel/attractions.txt");
		ArrayList<String> info = new ArrayList<String>();
		int i=0;
		
		try{
			scan = new Scanner(file);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		while(scan.hasNextLine()){
			 info.add(scan.nextLine());
		}
		
		return info;
	
	}
	
	public String recommend (ArrayList<String> info, String type) {
		
		ArrayList<String> attr = new ArrayList<String>();
		String s= "You can visit";
		for(int i=0;i<info.size();i++){
			if(info.get(i).equals(type)) {
				attr.add(info.get(i+1));
			}
		}
		
		for (int j=0;j<attr.size();j++){
			if(j<attr.size()-1) {
				s=s+" "+attr.get(j)+",";
			}
			else {
				s= s+" and "+attr.get(j)+".";
			}
			
		}
		
		return s;
		
	} 
	
	public String detail(ArrayList<String> info, Object name) {
		
		String namestring = name.toString();
		String det = null;
		for(int i=0;i<info.size();i++){
			if(info.get(i).equals(namestring)) {
				det = info.get(i+1);
			}
		}
		
		return det;
	
	}
	
	public String popular(ArrayList<String> info) {
		ArrayList<String> popu = new ArrayList<String>();
		int num = info.size()/3;
		String s = null;
		if(num<5) {
			for(int i=0;i<num;i++){
				popu.add(info.get(3*i+1));
			}
			s="The top"+num+"tourist attractions are";
			
			for(int j=0;j<num;j++) {
				if(j<num-1){
					s=s+" "+popu.get(j)+",";
				}
				else{
					s=s+" and "+popu.get(j)+".";
				}
				
			}
		}
		else {
			s="The top 5 tourist attractions are"+" "+info.get(1)+", "+info.get(4)+", "+info.get(7)+", "+info.get(10)+" and "+info.get(13);
		}
		
		return s;
	}
	
	public ArrayList<String> readtrans() {
		
		File file = new File("E:/IrisTK/app/myhotel/transportation.txt");
		ArrayList<String> info = new ArrayList<String>();
		
		try{
			scan = new Scanner(file);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		while(scan.hasNextLine()){
			 info.add(scan.nextLine());
		}
		
		return info;
	
	}
	
	public String transdetail(ArrayList<String> info, Object name) {
		
		String s = null;
		String namestring = name.toString();
		
		for(int i=0; i<info.size();i++) {
			if(info.get(i).equals(namestring)) {
				s=info.get(i+1);
			}
		}
		
		return s;
		
	}
	
	public String findroom(String text) {
		
		ArrayList<String> list = new ArrayList<String>();
		String num = "";
		int room;
		String s = null;
		
		for(int i=0;i<text.length();i++) {
			if(text.charAt(i)>=48 && text.charAt(i)<=57) {

				num=num+text.charAt(i);
			}			
		}
		
		if(num == ""){
			s="Sorry, I didn't get that";
		}else{
			room = Integer.parseInt(num);
			if(room>=199 && room<300) {
				s="It is on the second floor";
			}else if(room>=300 && room<400) {
				s= "It is on the third floor";
			}else if(room>=400 && room<500){
				s= "It is on the forth floor";
			}else {
				s="Sorry, I didn't get that";
			}
		}
		
		return s;
		
	}
	

	

	
	

}
