package algorithm_study;

import java.util.Scanner;

public class BAEK_9625_B1_BABBA {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		int [] lista = new int [k];
		int [] listb = new int [k];
		if(k>1) {
			lista[0] = 0;
			listb[0] = 1;
			lista[1] = 1;
			listb[1] = 1;
			for (int i = 2; i < k; i++) {
				lista[i] = lista[i-1] + lista[i-2];
				listb[i] = listb[i-1] + listb[i-2];
			}
			
			System.out.println(lista[k-1] + " " + listb[k-1]);
		}else {
			System.out.println("0 1");
		}
		
	}

}
