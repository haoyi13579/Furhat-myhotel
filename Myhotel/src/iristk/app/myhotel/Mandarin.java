package iristk.app.myhotel;

public class Mandarin {
	
	public int language(String text) {
		
		String[] sarray= {"����","��ͨ��"};
		int index;
		int returnint = 0;
		
		for(int i=0;i<sarray.length;i++) {
			index= text.indexOf(sarray[i]);
			if(index != -1) {
				returnint = 2;
				break;
			} 
		}		
		return returnint;		
	}
	
	public int attraction(String text) {
		
		String[] sarray= {"����","���ξ���","����","�۹�"};
		int index;
		int returnint = 0;
		
		for(int i=0;i<sarray.length;i++) {
			index= text.indexOf(sarray[i]);
			if(index != -1) {
				returnint = 2;
				break;
			} 
		}		
		return returnint;		
	}
	
	public int nature(String text) {
		
		String[] sarray= {"��Ȼ","�羰","��Ȼ��"};
		int index;
		int returnint = 0;
		
		for(int i=0;i<sarray.length;i++) {
			index= text.indexOf(sarray[i]);
			if(index != -1) {
				returnint = 3;
				break;
			} 
		}		
		return returnint;		
	}
	
	public int history(String text) {
		
		String[] sarray= {"��ʷ","����","�Ļ�"};
		int index;
		int returnint = 0;
		
		for(int i=0;i<sarray.length;i++) {
			index= text.indexOf(sarray[i]);
			if(index != -1) {
				returnint = 4;
				break;
			} 
		}		
		return returnint;		
	}
	
	public int popular(String text) {
		
		String[] sarray= {"����","�ܻ�ӭ","���","���쾰��"};
		int index;
		int returnint = 0;
		
		for(int i=0;i<sarray.length;i++) {
			index= text.indexOf(sarray[i]);
			if(index != -1) {
				returnint = 5;
				break;
			} 
		}		
		return returnint;		
	}
	
	public int transportation(String text) {
		
		String[] sarray= {"��ͨ","���з�ʽ","����","��ôȥ"};
		int index;
		int returnint = 0;
		
		for(int i=0;i<sarray.length;i++) {
			index= text.indexOf(sarray[i]);
			if(index != -1) {
				returnint = 2;
				break;
			} 
		}		
		return returnint;		
	}
	
	public String attrname(String text) {
		
		String[] garden = {"����˹��ֲ��԰","ֲ��԰"};
		String[] countrypark = {"�������幫԰","�����","���"};
		String[] riverpark = {"���ĸ��޷�԰","���Ĺ�԰","���޷�԰"};
		String[] art = {"���ĸ��޷����������","���������","���ĸ��޷����","���Ĳ����","���޷����"};
		String[] riverside = {"�ӱ������","�ӱ�","�ӱ�"};
		String[] cathedral = {"����˹������","����"};
		int index;
		String returnstring = "a";
		

		for(int i=0;i<garden.length;i++) {
			index= text.indexOf(garden[i]);
			if(index != -1) {
				returnstring = "Glasgow Botanic Gardens";
				break;
			} 
		}
		
		for(int i=0;i<countrypark.length;i++) {
			index= text.indexOf(countrypark[i]);
			if(index != -1) {
				returnstring = "Pollok Country Park";
				break;
			} 
		}
		
		for(int i=0;i<riverpark.length;i++) {
			index= text.indexOf(riverpark[i]);
			if(index != -1) {
				returnstring = "Kelvingrove Park";
				break;
			} 
		}
		
		for(int i=0;i<art.length;i++) {
			index= text.indexOf(art[i]);
			if(index != -1) {
				returnstring = "Kelvingrove Art Gallery and Museum";
				break;
			} 
		}
		
		for(int i=0;i<riverside.length;i++) {
			index= text.indexOf(riverside[i]);
			if(index != -1) {
				returnstring = "Riverside Museum";
				break;
			} 
		}
		
		for(int i=0;i<cathedral.length;i++) {
			index= text.indexOf(cathedral[i]);
			if(index != -1) {
				returnstring = "Glasgow Cathedral";
				break;
			} 
		}
				
		return returnstring;		
	}

	
	public int room(String text) {
		
		String[] sarray= {"����","ס����","����","����","�Է�","ʳ��"};
		int index;
		int returnint = 0;
		
		for(int i=0;i<sarray.length;i++) {
			index= text.indexOf(sarray[i]);
			if(index != -1) {
				returnint = 2;
				break;
			} 
		}		
		return returnint;		
	}
	
	public int weather(String text) {
		
		String[] sarray= {"����","�¶�","����","��ѩ","����","����","��ѩ"};
		int index;
		int returnint = 0;
		
		for(int i=0;i<sarray.length;i++) {
			index= text.indexOf(sarray[i]);
			if(index != -1) {
				returnint = 2;
				break;
			} 
		}		
		return returnint;		
	}
	
	public int morningcall(String text) {
		
		String[] sarray= {"�������","���ѷ���"};
		int index;
		int returnint = 0;
		
		for(int i=0;i<sarray.length;i++) {
			index= text.indexOf(sarray[i]);
			if(index != -1) {
				returnint = 2;
				break;
			} 
		}		
		return returnint;		
	}
	
	
	public int number(String text) {
		String[] number = new String[60];
		String num="";
		int temp;
		int index;
		int returnint=111;
		for(int i=0;i<60;i++) {
			number[i] = String.valueOf(i);
		}
		
		for(int i=0;i<text.length();i++) {
			if(text.charAt(i)>=48 && text.charAt(i)<=57) {

				num=num+text.charAt(i);
			}			
		}
		
		
		if(num.equals("")) {
			returnint = 111;
		}else {
			temp = Integer.parseInt(num);
			if(temp>59) { 
				returnint = 99; 
			} else {
				returnint = temp;
			}
		}
		
		
//		for(int j=0;j<number.length;j++) {
//			index = text.indexOf(number[j]);
//			if(index != -1) {
//				returnint = j;
//			}
//		}
		
		return returnint;		
	}
	
	public int clock(String text) {
		
		String[] sarray= {"����"};
		int index;
		int returnint = 0;
		
		for(int i=0;i<sarray.length;i++) {
			index= text.indexOf(sarray[i]);
			if(index != -1) {
				returnint = 2;
				break;
			} 
		}		
		return returnint;		
	}
	
	public int half(String text) {
		
		String[] sarray= {"���"};
		int index;
		int returnint = 0;
		
		for(int i=0;i<sarray.length;i++) {
			index= text.indexOf(sarray[i]);
			if(index != -1) {
				returnint = 2;
				break;
			} 
		}		
		return returnint;		
	}
	
	public String apm(String text) {
		
		String[] morningarray= {"����","����"};
		String[] eveningarray= {"����","����","����"};
		int index;
		int index2;
		String returnstring = "b";
		
		for(int i=0;i<morningarray.length;i++) {
			index= text.indexOf(morningarray[i]);
			if(index != -1) {
				returnstring = "a.m.";
				break;
			} 
		}
		
		for(int i=0;i<eveningarray.length;i++) {
			index2= text.indexOf(eveningarray[i]);
			if(index2 != -1) {
				returnstring = "p.m.";
				break;
			} 
		}
		
		return returnstring;
	}
	
	public String calldate(String text) {
		
		String[] tomorrow= {"����"};
		String[] today= {"����"};
		int index;
		int index2;
		String returnstring = "c";
		
		for(int i=0;i<tomorrow.length;i++) {
			index= text.indexOf(tomorrow[i]);
			if(index != -1) {
				returnstring = "tomorrow";
				break;
			} 
		}
		
		for(int i=0;i<today.length;i++) {
			index2= text.indexOf(today[i]);
			if(index2 != -1) {
				returnstring = "today";
				break;
			} 
		}
		
		return returnstring;
	}
	
	
	
	
	
	
	
	public int yesno(String text) {
		
		String[] yesarray= {"��","��","û��","��Ҫ","����","��","��"};
		String[] noarray= {"����","����","����","����Ҫ","������","���","û��","����","��"};
		int index;
		int index2;
		int returnint = 0;
		
		for(int i=0;i<yesarray.length;i++) {
			index= text.indexOf(yesarray[i]);
			if(index != -1) {
				returnint = 66;
				break;
			} 
		}
		
		for(int i=0;i<noarray.length;i++) {
			index2= text.indexOf(noarray[i]);
			if(index2 != -1) {
				returnint = 88;
				break;
			} 
		}
		
		if(returnint==88) {	returnint = 88; }
		
		if(returnint==66) { returnint = 66; }
		
		return returnint;		
	}
	
	public int no(String text) {
		
		String[] sarray= {"����","����","����","����Ҫ","������","���","û��"};
		int index;
		int returnint = 0;
		
		for(int i=0;i<sarray.length;i++) {
			index= text.indexOf(sarray[i]);
			if(index != -1) {
				returnint = 88;
				break;
			} 
		}		
		return returnint;		
	}
	
	
	
	
}
