package algorithm_study;

public class Pro_Line_CodingTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String answer_sheet = "4132315142";
		String [] sheets = {"3241523133","4121314445","3243523133","4433325251","2412313253"};
		String answer_sheet1 = "53241";
		String [] sheets1 = {"53241", "42133", "53241", "14354"};
		String answer_sheet2 = "24551";
		String [] sheets2 = {"24553", "24553", "24553", "24553"};
		System.out.println(solution(answer_sheet, sheets));
		System.out.println(solution(answer_sheet1, sheets1));
		System.out.println(solution(answer_sheet2, sheets2));

	}
	static public int solution(String answer_sheet, String[] sheets) {
		int answer = -1;
		
		char [][] answer_temp = new char [sheets.length][sheets[0].length()]; 
		for (int i = 0; i < sheets.length; i++) {
			for (int j = 0; j < sheets[0].length(); j++) {
				if(sheets[i].charAt(j) != answer_sheet.charAt(j)) {
					answer_temp[i][j] = sheets[i].charAt(j);
				}else {
					answer_temp[i][j] = '0';
				}
			}
		}
		
		for (int i = 0; i < answer_temp.length-1; i++) {
			
			for (int j = i+1; j < answer_temp.length; j++) {
				int count = 0;
				int maxlength = 0;
				int maxtemp = 0;
				for (int k = 0; k < answer_temp[0].length; k++) {					
					if(answer_temp[i][k] != '0' && answer_temp[j][k] != '0' && answer_temp[i][k] == answer_temp[j][k]) {
						count++;
						maxtemp++;
					}else if(answer_temp[i][k] == '0' || answer_temp[j][k] == '0' || answer_temp[i][k] != answer_temp[j][k]){
						
						maxtemp = 0;
					}
					maxlength = Math.max(maxtemp, maxlength);
				}
				int a = (int) (count + Math.pow(maxlength, 2));
				answer = Math.max(answer, a);
			}
			
		}
		
		return answer;
	}
	
		
}
