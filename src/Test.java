@FunctionalInterface
public interface Test {
 void test1();
 default void test2(){}
 default void  test3(){
	 
 }
 default int x(){
	return 0;
 }
}
