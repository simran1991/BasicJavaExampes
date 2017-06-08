package findarray2;

import java.util.HashMap;
import java.util.Map;

public class MapDecoder {
	
	private static final String sep="";
	public Map<String,String> decode(String s){
		
		//first split all with &
		Map<String,String> result=new HashMap<String, String>();
		if(s.isEmpty()){
			return result;
		}
		String[] list=s.split("&");
		 
		for(String a:list){
			String [] list1=a.split("=");
			if(list1[0].contentEquals("")){
				result.put("", "");
			}else if(list1.length==1){
				result.put(list1[0],"");
			}else{
				result.put(list1[0],list1[1]);
			}
			
		}
		
		return result;
		
	} 
	
	public static void main(String[] args) {
		String s="=1&two=&three=3&=4";
		MapDecoder m=new MapDecoder();
		Map<String,String> result=m.decode(s);
		for(String k:result.keySet()){
			System.out.println("key is*"+k+"*value is*"+result.get(k));
		}
		
	}
}
