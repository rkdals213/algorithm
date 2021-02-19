package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class BAEK_7785_S5_회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] names = new String[n][2];

        for (int i = 0; i < n; i++)
            names[i] = br.readLine().split(" ");

        HashMap<String, String> lists = new HashMap<String, String>();

        for (int i = 0; i < n; i++) {
            if (names[i][1].equals("enter"))
                lists.put(names[i][0], names[i][1]);
            else
                lists.remove(names[i][0]);
        }

        Set<String> keys = lists.keySet();
        Iterator<String> it = keys.iterator();

        String[] result = new String[lists.size()];

        int index = 0;
        while (it.hasNext()) {
            result[index] = it.next();
            index++;
        }

        Arrays.sort(result, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}





