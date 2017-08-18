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

	
	
	
	
	
	
	
	
	
	
	
	
}
