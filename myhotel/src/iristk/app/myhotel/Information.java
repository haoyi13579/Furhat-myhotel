package iristk.app.myhotel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Information {
	
	Scanner scan = null;
	
	public ArrayList<String> readattr() {
		
		File file = new File("E:/furhatsdk/app/Myhotel/attractions.txt");
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
			s="The top 5 tourist attractions are"+" "+info.get(1)+", "+info.get(6)+", "+info.get(11)+", "+info.get(16)+" and "+info.get(21);
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
			s="�����ŵ�5��������"+" "+info.get(2)+", "+info.get(7)+", "+info.get(12)+", "+info.get(17)+" �� "+info.get(22);
		}
		
		return s;
	}
	
	public ArrayList<String> readtrans() {
		
		File file = new File("E:/furhatsdk/app/Myhotel/trans.txt");
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
	
	public String timeconfirm_CN(String date, String hour, String minute, String apm) {
		
		int hourint = Integer.valueOf(hour);
		int minint = Integer.valueOf(minute);
		String s;
		String datestring;
		
		if(date.equals("tomorrow")) {
			datestring="����";
		}else {
			datestring="����";
		}
		
		if(apm.equals("p.m.")) {
			hourint = hourint+12;
			if(minint ==0) {
				s="��ϣ���Ľ���ʱ���� "+datestring+ " "+hourint+"��������";
			}else {
				s= "��ϣ���Ľ���ʱ���� "+datestring+" "+hourint+"��"+minint+"�ֶ���";
			}
		}else {
			if(minint == 0) {
				s="��ϣ���Ľ���ʱ����"+datestring+ "���� "+hourint+"��������";
			}else{
				s= "��ϣ���Ľ���ʱ����"+datestring+"���� "+hourint+"��"+minint+"�ֶ���";
			}			

		}
						
		return s;
	}
	
	public String callroom(String text) {
		
		String[] list = null;
		String num = "";
		String s;
		int room;
		String roomstring="";
		
		for(int i=0;i<text.length();i++) {
			if(text.charAt(i)>=48 && text.charAt(i)<=57) {

				num=num+text.charAt(i);
			}			
		}
			
		list = text.split(" ");
		for(int p=0;p<list.length;p++) {
			if(list[p].equals("zero")||list[p].equals("o")) {
				roomstring=roomstring+"0 ";
			}
			if(list[p].equals("one")) {
				roomstring=roomstring+"1 ";
			}
			if(list[p].equals("two")) {
				roomstring=roomstring+"2 ";
			}
			if(list[p].equals("three")) {
				roomstring=roomstring+"3 ";
			}
			if(list[p].equals("four")) {
				roomstring=roomstring+"4 ";
			}
			if(list[p].equals("five")) {
				roomstring=roomstring+"5 ";
			}
			if(list[p].equals("six")) {
				roomstring=roomstring+"6 ";
			}
			if(list[p].equals("seven")) {
				roomstring=roomstring+"7 ";
			}
			if(list[p].equals("eight")) {
				roomstring=roomstring+"8 ";
			}
			if(list[p].equals("nine")) {
				roomstring=roomstring+"9 ";
			}
		}
		
		
		for(int j=0;j<num.length();j++) {
			roomstring += num.charAt(j)+" ";
		}
		
		if(roomstring == ""){
			s="Sorry";
		}else{
			s = "Your room number is ��"+roomstring+", is it correct?";
		}
		
		return s;
		
	}
	
	public String callroom_CN(String text) {
		
		String[] list = null;
		String num = "";
		String s;
		int room;
		String roomstring="";
		
		for(int i=0;i<text.length();i++) {
			if(text.charAt(i)>=48 && text.charAt(i)<=57) {

				num=num+text.charAt(i);
			}			
		}
			
		for(int p=0;p<text.length();p++) {
			if(text.charAt(p) == '��'||text.charAt(p) == '��') {
				roomstring=roomstring+"0 ";
			}
			if(text.charAt(p) == 'һ'||text.charAt(p) == 'Ҽ') {
				roomstring=roomstring+"1 ";
			}
			if(text.charAt(p) == '��'||text.charAt(p) == '��') {
				roomstring=roomstring+"2 ";
			}
			if(text.charAt(p) == '��'||text.charAt(p) == '��') {
				roomstring=roomstring+"3 ";
			}
			if(text.charAt(p) == '��'||text.charAt(p) == '��') {
				roomstring=roomstring+"4 ";
			}
			if(text.charAt(p) == '��') {
				roomstring=roomstring+"5 ";
			}
			if(text.charAt(p) == '��') {
				roomstring=roomstring+"6 ";
			}
			if(text.charAt(p) == '��') {
				roomstring=roomstring+"7 ";
			}
			if(text.charAt(p) == '��') {
				roomstring=roomstring+"8 ";
			}
			if(text.charAt(p) == '��') {
				roomstring=roomstring+"9 ";
			}
		}
		
		
		for(int j=0;j<num.length();j++) {
			roomstring += num.charAt(j)+" ";
		}
		
		if(roomstring == ""){
			s="Sorry";
		}else{
			s = "���ķ������ ��"+roomstring+"������";
		}
		
		return s;
		
	}
	
	public String getcallroomnum(String text) {
		String[] list=null;
		list = text.split(" ");
		String roomnum="";
		
		for(int i=0;i<text.length();i++) {
			if(text.charAt(i)>=48 && text.charAt(i)<=57) {

				roomnum=roomnum+text.charAt(i);
			}			
		}
		
		list = text.split(" ");
		for(int p=0;p<list.length;p++) {
			if(list[p].equals("zero")||list[p].equals("o")) {
				roomnum=roomnum+"0";
			}
			if(list[p].equals("one")) {
				roomnum=roomnum+"1";
			}
			if(list[p].equals("two")) {
				roomnum=roomnum+"2";
			}
			if(list[p].equals("three")) {
				roomnum=roomnum+"3";
			}
			if(list[p].equals("four")) {
				roomnum=roomnum+"4";
			}
			if(list[p].equals("five")) {
				roomnum=roomnum+"5";
			}
			if(list[p].equals("six")) {
				roomnum=roomnum+"6";
			}
			if(list[p].equals("seven")) {
				roomnum=roomnum+"7";
			}
			if(list[p].equals("eight")) {
				roomnum=roomnum+"8";
			}
			if(list[p].equals("nine")) {
				roomnum=roomnum+"9";
			}
		}
		
		return roomnum;
	}
	
	
	public String getcallroomnum_CN(String text) {
		String roomnum="";
		
		for(int i=0;i<text.length();i++) {
			if(text.charAt(i)>=48 && text.charAt(i)<=57) {

				roomnum=roomnum+text.charAt(i);
			}			
		}
		

		for(int p=0;p<text.length();p++) {
			if(text.charAt(p) == '��'||text.charAt(p) == '��') {
				roomnum=roomnum+"0 ";
			}
			if(text.charAt(p) == 'һ'||text.charAt(p) == 'Ҽ') {
				roomnum=roomnum+"1 ";
			}
			if(text.charAt(p) == '��'||text.charAt(p) == '��') {
				roomnum=roomnum+"2 ";
			}
			if(text.charAt(p) == '��'||text.charAt(p) == '��') {
				roomnum=roomnum+"3 ";
			}
			if(text.charAt(p) == '��'||text.charAt(p) == '��') {
				roomnum=roomnum+"4 ";
			}
			if(text.charAt(p) == '��') {
				roomnum=roomnum+"5 ";
			}
			if(text.charAt(p) == '��') {
				roomnum=roomnum+"6 ";
			}
			if(text.charAt(p) == '��') {
				roomnum=roomnum+"7 ";
			}
			if(text.charAt(p) == '��') {
				roomnum=roomnum+"8 ";
			}
			if(text.charAt(p) == '��') {
				roomnum=roomnum+"9 ";
			}
		}
		
		return roomnum;
	}
	
	
	public void addcsv(String date, String hour, String minute, String apm, String room) throws IOException {
		
		int hourint = Integer.valueOf(hour);
		int minint = Integer.valueOf(minute);
		String time="";
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
		
		if(minint<10) {
			minstring = "0"+minint;
		}else {
			minstring = ""+minint;
		}
		
		datestring = calldate.toString();
		time = hour+":"+minstring;
		
		
		String file = "E:/furhat_skills/morningcall.csv";

		BufferedWriter output=new BufferedWriter(new FileWriter(file,true));
		output.write(datestring+","+time+","+ room);
		output.newLine();
		output.flush(); // if do not use flush, the output file can not be written completely
		output.close();
	}

	

	
	

}
