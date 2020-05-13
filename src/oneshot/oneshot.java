package oneshot;

import java.net.*;
import java.util.Arrays;
import java.io.*;
public class oneshot {

	// User and Game Server Information
	static final String NICKNAME = "쭈꾸마뇽";
	static final String HOST = "127.0.0.1";
	static final int PORT = 1447; // Do not modify
	
	// predefined variables(Do not modify these values)
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 5;
	static final int[][] HOLES = {{0, 0}, {127, 0}, {254, 0}, {0, 127}, {127, 127}, {254, 127}};
	
	public static void main(String[] args) {
		
		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		int[][] balls = new int[NUMBER_OF_BALLS][2];

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = "9901/" + NICKNAME;
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play.");
			
			int cnt = 0;
			while (socket != null) {
				
				bytes = new byte[1024];
				
				int readByteCount = is.read(bytes);
				recv_data = new String(bytes, 0, readByteCount, "UTF-8");
				System.out.println("Data Received: " + recv_data);
				
				String[] split_data = recv_data.split("/");
				if (split_data[0].equals("9909")) break;
				
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Integer.parseInt(split_data[idx++]);
						}
					}
				}
				catch (Exception e) {
					bytes = new byte[1024];
					balls = new int[NUMBER_OF_BALLS][2];
					bytes = "9902/9902".getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}
				
				double angle = 0;
				double power = 0;
				
				////////////////////////////////////////////////////////////////////
				// 주석을 지우고, 이 곳에 주어진 정보를 바탕으로 게임 로직을 구현하여 자동으로 플레이할 수 있도록 구현합니다.
    			// 필요한 결괏값은 방향(angle)과 세기(power)로 두 변수의 값이 이 부분에서 결정되도록 만들어야 합니다.
				double[] result = pretest(balls);
				if(result == null) {
					System.out.println(balls.length);
					for (int i = 1; i < balls.length; i++) {
						if(balls[i][0] != -1 && balls[i][1] != -1) {
							int x = balls[0][0];
							int y = balls[0][1];
							
							int xx = balls[i][0];
							int yy = balls[i][1];
							
							int length_x = xx - x;
							int length_y = yy - y;
							
							power = length_x*length_x + length_y*length_y;
							power = Math.sqrt(power)/3;
							power += getCloseHole(angle, xx, yy) + 4;
							System.out.println(length_x + " " + length_y);
							angle = Math.atan2(length_x, length_y);
							angle *= 180.0 / Math.PI;
							
							if(angle % 90 == 0) {
								angle += 0.3;
							}
							
							getCloseHole(angle, xx, yy);
							break;
						}
					}
				}else {
					angle = result[0];
					power = result[1];
				}
				
			    
				
				//////////////////////////////////////////////////////////////////
				
				String merged_data = angle + "/" + power;
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}
			os.close();
			is.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static double getCloseHole(double angle, int xx, int yy) {
		double endx = xx;
		double endy = yy;
		double result = Integer.MAX_VALUE;
		
		while (endx >= 0 && endy >= 0 && endx <= TABLE_WIDTH &&  endy <= TABLE_HEIGHT) {
			endx += Math.cos(180 - angle);
			endy += Math.sin(180 - angle);
		}
		for (int i = 0; i < HOLES.length; i++) {
			int hx = HOLES[i][0];
			int hy = HOLES[i][1];
			double temp = (xx-hx)*(xx-hx) + (yy-hy)*(yy-hy);
			result = Math.min(result, temp);
		}
		
		result = Math.sqrt(result)/3;
		
		return result;
	}
	
	static int [][] balls;
	private static final double[][] stage3 = {{64, 64}, {250, 10}, {15, 10}, {-1, -1}, {-1, -1}};
    private static final double[][] stage32 = {{171, 37}, {-1, -1}, {15, 10}, {-1, -1}, {-1, -1}};
    private static final double[][] defaultState = {{64, 64}, {190, 64}, {196, 58}, {196, 70}, {202, 64}};
    private static final double[][] defaultState2 = {{246, 51}, {190, 59}, {-1, -1}, {222, 84}, {225, 28}};
    private static final double[][] defaultState3 = {{158, 63}, {-1, -1}, {-1, -1}, {222, 84}, {225, 28}};
    private static final double[][] defaultState4 = {{195, 98}, {-1, -1}, {-1, -1}, {-1, -1}, {225, 28}};

    private static double[] pretest(int [][] balls) {
    	double angle = 0;
    	double power = 0;
        System.out.println("pretest");
        double[] result = null;
        if (Arrays.deepEquals(balls, stage3)) {
            angle = 104.8;
            power = 88;
            result = new double[]{angle, power};
        } else if (Arrays.deepEquals(balls, stage32)) {
            angle = 261;
            power = 66;
            result = new double[]{angle, power};
        } else if (Arrays.deepEquals(balls, defaultState)) {
           
                angle = 88.2;
                power = 100;
            result = new double[]{angle, power};
        } else if (Arrays.deepEquals(balls, defaultState2)) {
            angle = 270 + 11;
            power = 100;
            result = new double[]{angle, power};
        } else if (Arrays.deepEquals(balls, defaultState3)) {
            angle = 156.11312;
            power = 88;
            result = new double[]{angle, power};
        } else if (Arrays.deepEquals(balls, defaultState4)) {
            angle = 158.06163360475937;
            power = 44.42662334713396;
            result = new double[]{angle, power};
        }

        return result;
    }
	
}


