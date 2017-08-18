package iristk.app.myhotel;

public class Mandarin {
	
	public int language(String text) {
		
		String[] sarray= {"中文","普通话"};
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
		
		String[] sarray= {"景点","旅游景点","好玩","观光"};
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
		
		String[] sarray= {"自然","风景","自然类"};
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
		
		String[] sarray= {"历史","人文","文化"};
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
		
		String[] sarray= {"热门","受欢迎","最好","网红景点"};
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
		
		String[] sarray= {"交通","出行方式","坐车","怎么去"};
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
		
		String[] garden = {"格拉斯哥植物园","植物园"};
		String[] countrypark = {"波洛克乡村公园","波洛克","乡村"};
		String[] riverpark = {"凯文葛罗夫公园","凯文公园","葛罗夫公园"};
		String[] art = {"凯文葛罗夫艺术博物馆","艺术博物馆","凯文葛罗夫博物馆","凯文博物馆","葛罗夫博物馆"};
		String[] riverside = {"河滨博物馆","河边","河滨"};
		String[] cathedral = {"格拉斯哥大教堂","教堂"};
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
		
		String[] sarray= {"房间","住哪里","餐厅","健身","吃饭","食堂"};
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
		
		String[] sarray= {"天气","温度","下雨","下雪","晴天","有雨","有雪"};
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
		
		String[] sarray= {"叫早服务","叫醒服务"};
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
		
		String[] sarray= {"点整"};
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
		
		String[] sarray= {"点半"};
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
		
		String[] morningarray= {"早上","上午"};
		String[] eveningarray= {"下午","晚上","傍晚"};
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
		
		String[] tomorrow= {"明天"};
		String[] today= {"今天"};
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
		
		String[] yesarray= {"对","是","没错","需要","可以","有","想"};
		String[] noarray= {"不对","不是","错了","不需要","不可以","错的","没有","不想","不"};
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
		
		String[] sarray= {"不对","不是","错了","不需要","不可以","错的","没有"};
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
