package iristk.app.myhotel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Information {
	
	Scanner scan = null;
	
	public ArrayList<String> readattr() {
		
		File file = new File("E:/furhatsdk/app/Myhotel/attractions.txt");
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
	
	public String recommend_CN (ArrayList<String> info, String type) {
		
		ArrayList<String> attr = new ArrayList<String>();
		String s= "You can visit";
		for(int i=0;i<info.size();i++){
			if(info.get(i).equals(type)) {
				attr.add(info.get(i+2));
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
				det = info.get(i+2);
			}
		}
		
		return det;
	
	}
	
	public String detail_CN(ArrayList<String> info, Object name) {
		
		String namestring = name.toString();
		String det = null;
		for(int i=0;i<info.size();i++){
			if(info.get(i).equals(namestring)) {
				det = info.get(i+3);
			}
		}
		
		return det;
	
	}
	
	public String popular(ArrayList<String> info) {
		ArrayList<String> popu = new ArrayList<String>();
		int num = info.size()/5;
		String s = null;
		if(num<5) {
			for(int i=0;i<num;i++){
				popu.add(info.get(5*i+1));
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
	
	public String popular_CN(ArrayList<String> info) {
		ArrayList<String> popu = new ArrayList<String>();
		int num = info.size()/5;
		String s = null;
		if(num<5) {
			for(int i=0;i<num;i++){
				popu.add(info.get(5*i+2));
			}
			s="�����ŵ�"+num+"�������ǣ�";
			
			for(int j=0;j<num;j++) {
				if(j<num-1){
					s=s+" "+popu.get(j)+",";
				}
				else{
					s=s+" �� "+popu.get(j)+".";
				}
				
			}
		}
		else {
			s="�����ŵ�5��������"+" "+info.get(1)+", "+info.get(4)+", "+info.get(7)+", "+info.get(10)+" �� "+info.get(13);
		}
		
		return s;
	}
	
	public ArrayList<String> readtrans() {
		
		File file = new File("transportation.txt");
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
	
	public String transdetail_CN(ArrayList<String> info, Object name) {
		
		String s = null;
		String namestring = name.toString();
		
		for(int i=0; i<info.size();i++) {
			if(info.get(i).equals(namestring)) {
				s=info.get(i+2);
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
			s="Sorry";
		}else{
			room = Integer.parseInt(num);
			if(room>=199 && room<300) {
				s="It is on the second floor";
			}else if(room>=300 && room<400) {
				s= "It is on the third floor";
			}else if(room>=400 && room<500){
				s= "It is on the forth floor";
			}else if(room>=500) {
				s= "Sorry we do not have this room";
			}else {
				s="Sorry, I didn't get that";
			}
		}
		
		return s;
		
	}
	
	public String findroom_CN(String text) {
		
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
			s="Sorry";
		}else{
			room = Integer.parseInt(num);
			if(room>=199 && room<300) {
				s="��Ҫ�ҵķ����ڶ�¥��";
			}else if(room>=300 && room<400) {
				s= "��Ҫ�ҵķ�������¥��";
			}else if(room>=400 && room<500){
				s= "��Ҫ�ҵķ�������¥��";
			}else if(room>=500) {
				s= "��Ǹ����û����Ҫ�ҵķ��䡣";
			}else {
				s="��Ǹ����û�������˵�Ļ���";
			}
		}
		
		return s;
		
	}
	
	public String timeconfirm(String date, String hour, String minute, String apm) {
		
		int hourint = Integer.valueOf(hour);
		int minint = Integer.valueOf(minute);
		String s;
		if(apm.equals("p.m.")) {
			hourint = hourint+12;
			if(minint ==0) {
				s="Your morning call is "+date+ " "+hourint+" o'clock, is it correct?";
			}else {
				s= "Your morning call is "+date+" "+hourint+" "+minint+", is it correct?";
			}
		}else {
			if(minint == 0) {
				s="Your morning call is "+date+ " "+hourint+" o'clock, a.m., is it correct?";
			}else{
				s= "Your morning call is "+date+" "+hourint+" "+minint+", a.m., is it correct?";
			}			

		}
						
		return s;
	}
	
	public String callroom(String text) {
		
		ArrayList<String> list = new ArrayList<String>();
		String num = "";
		String s;
		int room;
		String roomstring="";
		
		for(int i=0;i<text.length();i++) {
			if(text.charAt(i)>=48 && text.charAt(i)<=57) {

				num=num+text.charAt(i);
			}			
		}
		
		for(int j=0;j<num.length();j++) {
			roomstring += num.charAt(j)+" ";
		}
		
		if(num == ""){
			s="Sorry";
		}else{
			s = "Your room is "+roomstring+", is it correct?";
		}
		
		return s;
		
	}
	
	
	public void addcsv(String date, String hour, String minute, String apm) {
		
		int hourint = Integer.valueOf(hour);
		int minint = Integer.valueOf(minute);
		String datestring;
		String minstring;
		if(apm.equals("p.m.")) {
			hourint = hourint+12;
		}
		LocalDate localdate = LocalDate.now();
		LocalDate calldate;
		if(date.equals("today")) {
			if(apm.equals("p.m.") && hourint==12) {
				calldate = localdate.plusDays(1);
			}else {
				calldate = localdate;
			}
		}else {
			calldate = localdate.plusDays(1);
		}
		
		if(minint==0) {
			
		}
		
	}

	

	
	

}
