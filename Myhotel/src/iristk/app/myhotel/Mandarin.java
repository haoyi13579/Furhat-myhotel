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
		
		String[] sarray= {"历史","人文","文化","博物馆"};
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
	
	
	
	
	
	public int yes(String text) {
		
		String[] sarray= {"对","是","没错","需要","可以","有"};
		int index;
		int returnint = 0;
		
		for(int i=0;i<sarray.length;i++) {
			index= text.indexOf(sarray[i]);
			if(index != -1) {
				returnint = 66;
				break;
			} 
		}		
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
