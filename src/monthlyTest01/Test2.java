package monthlyTest01;

public class Test2 {

	public static void main(String[] args) {

		int[]  su=  {34,55, 27, 67, 45, 82, 68, 99, 77, 18};
		int aver = 0;
		int sum = 0;
		for (int i = 0; i < su.length; i++) {
			sum += su[i];
		}
		
		aver = sum / su.length;
		System.out.print(aver + " ");

		int [] temp = new int [su.length];
		
		for (int i = 0; i < temp.length; i++) {
			if (su[i] >= aver) {
				temp[i] = su[i] - aver;
			}else
				temp[i] = aver - su[i];
			
		}
		int min = Integer.MAX_VALUE;
		int index = 99;
		for (int i = 0; i < temp.length; i++) {
			if(temp[i] < min) {
				min = temp[i];
				index = i;
			}
		}
		System.out.println(su[index]);
		
		
	}
}
