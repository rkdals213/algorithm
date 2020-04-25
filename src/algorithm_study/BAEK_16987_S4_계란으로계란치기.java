package algorithm_study;

import java.util.ArrayList;
import java.util.Scanner;

public class BAEK_16987_S4_계란으로계란치기 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Point> list = new ArrayList<>();
		
		int N = s.nextInt();
		for (int i = 0; i < N; i++) {
			int h = s.nextInt();
			int d = s.nextInt();
			list.add(new Point(h,d));
		}
		for (int i = 0; i < list.size(); i++) {
			int damage1 = list.get(i).damage;
			int damage2 = list.get(i+1).damage;
			
			list.get(i).health -= damage2;
			list.get(i+1).health -= damage1;		
			
			if(list.get(i+1).health <= 0) {
				list.remove(i+1);
			}
			
			if(list.get(i).health <= 0) {
				list.remove(i);
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(list.get(i).health);
		}
		
		
	}
	
	static class Point{
		int health;
		int damage;
		public Point(int health, int damage) {
			super();
			this.health = health;
			this.damage = damage;
		}	
	}
}
