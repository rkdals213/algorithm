package monthlyTest01;
import java.util.Arrays;

public class Test3 {


	public void execute(String msg) {
             // 구현 하세요.
		int [] temp = new int [10];
		for (int i = 0; i < msg.length(); i++) {
			temp[(int)(msg.charAt(i))-'0'] += 1;
		}
	for (int i = 0; i < temp.length; i++) {
		if(temp[i] == 0) {
			continue;
		}else {
			System.out.println(i + " : " + temp[i]);
		}
	}
		
		
		
		
		
		
		
	}
	public static void main(String[] args) {
		Test3 c=new Test3();
		c.execute("5329053995535987827332679340558347453272569584"); 
		c.execute("122333444455555666666"); 
	}
}
