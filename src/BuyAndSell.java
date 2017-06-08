import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class BuyAndSell {
static int[] max_diff=new int[9];
static int[] max_diff_day=new int[9];

public void tansact(int[] arr){
	//when price in min

	for(int i=0;i<arr.length;i++){
		for (int j=i+1;j<arr.length;j++){
			if(arr[j]>arr[i]){
				if((arr[j]-arr[i])>max_diff[i] ){
					max_diff[i]=arr[j]-arr[i];
					max_diff_day[i]=j;
				}
			}
		}
	}
}


public static void main(String[] args) {
	
	/*int [] prices={7,12,5,3,11,6,10,2,9};
	
	BuyAndSell b=new BuyAndSell();
	
	
	b.tansact(prices);
	int largest=0;
	Integer largetINdex=null;
	for(int x=0;x<max_diff.length;x++){
		System.out.println("max difference on trancation on day : "+x+" is "+max_diff[x]);
	}
	for(int x=0;x<max_diff.length;x++){
		if(max_diff[x]>largest && max_diff[x]!=0){
			largetINdex=x;
			largest=max_diff[x];
		}
	}
	System.out.println("buy stock on "+largetINdex);
	System.out.println("sel stock on "+max_diff_day[largetINdex]);
	*/
	ArrayList<String> test=new ArrayList<>();
	test.add("simran.jpg");
	test.add("umesh.pptx");
	test.add("simran.jpg");
	test.add("simran(1).jpg");
	test.add("simran(2).lxs");
	test.add("simr.jpg an(2).jpg");
	test.add("simran(3).jpg");
	test.add("simrandsf.xls");
	test.add("simran(sdf.pdf");
	test.add("simr.jpg an(2).jpg");

	
	File folder=new File("C:\\Users\\simranjit.singh\\Desktop\\testFolder");
	if(folder.isDirectory()){
		
	}
	
	HashSet<String> entry=new HashSet<>();
	StringBuffer name=null;
	for (String a:test) {
		
	name=new StringBuffer(a);
		int count=1;
		while(!entry.add(name.toString())){
			if(name.lastIndexOf("(")>0 && name.lastIndexOf(")")>0 && name.lastIndexOf(")")+1==name.lastIndexOf("."))
			name.replace(name.indexOf("("),name.indexOf(")")+1,"");
			name.insert(name.lastIndexOf("."),"("+count+")");
			count++;
		}
		
		System.out.println("adding"+name);
	}
	for(String a:entry){
		System.out.println("val is "+a);
	}
	
	

}
	
}


