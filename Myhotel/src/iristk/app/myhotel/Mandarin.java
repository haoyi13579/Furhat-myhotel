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
		
		String[] sarray= {"��ʷ","����","�Ļ�","�����"};
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

	
	
	
	
	
	
	
	
	
	
	
	
}
