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
	
	
	
	
	
	public int yes(String text) {
		
		String[] sarray= {"��","��","û��","��Ҫ","����","��"};
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
