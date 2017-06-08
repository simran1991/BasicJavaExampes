package findarray2;

public class MyFindArray implements FindArray{

	@Override
	public int findArray(int[] parentArray, int[] subArray) {

		return findIndexOfFirstElemnt(parentArray,subArray);
		
	}
	
public int test(int[] parentArray, int[] subArray){
	for(int i=subArray.length-1;i>=0;i--){
		for(int j=parentArray.length-1;j>=0;j--){
			if(parentArray[j]==subArray[i]){
				break;
			}
		}
		
	}
	
	return 0;
	
}		 
		 
		
private int findIndexOfFirstElemnt(int[] parentArray, int[] subArray) {
/*	StringBuilder parent=new StringBuilder();	
	for(int i:parentArray){
		parent.append(i);		
	}
	StringBuilder child=new StringBuilder();
	for(int j:subArray){
		child.append(j);	
	}
	return parent.lastIndexOf(child.toString());
*/	
	
	int rightINdex=(parentArray.length-1)-(subArray.length-1);
	int fromIndex=parentArray.length-1;
	if(fromIndex>rightINdex){
		fromIndex=rightINdex;
	}
	int strLastIndex=subArray.length-1;
	int strLastVal=subArray[strLastIndex];
	
	int min=subArray.length-1;
	int i=min+fromIndex;
	startSearchForLastChar:
	while(true){
		while(i>=min && parentArray[i]!=strLastVal){
			i--;
		}
		if(i<min){
			return -1;
		}
		int j=i-1;
		int start=j-(subArray.length-1);
		int k=strLastIndex-1;
		while(j>start){
			if(parentArray[j--]!=subArray[k--]){
				i--;
				continue startSearchForLastChar;
			}
		}
		return start+1;
	}
	
}



public static void main(String[] args) {
	MyFindArray n=new MyFindArray();
	int[] ar1={5,6,7,8,6,7,8};
	int[] ar2={8,9,8};
	int j=2;
	int k=1;
	System.out.println(ar1[j--]+""+ar2[k--]);
	System.out.println(ar1[j]+""+ar2[k]);
	String s="simran";
	s.indexOf("ch");
	System.out.println(n.findArray(ar1,ar2));
}
}
