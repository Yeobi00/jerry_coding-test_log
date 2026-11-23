import java.util.*;

class Solution {
    static final int LAST = 23 * 60 + 59;
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> inTime = new HashMap<>();
        Map<String, Integer> total = new TreeMap<>();
        
        for (String r: records) {
            StringTokenizer st = new StringTokenizer(r);
            String time = st.nextToken();
            String num = st.nextToken();
            String inOut = st.nextToken();
            
            if (inOut.equals("IN")) {
                inTime.put(num, time);
            } else {
                int diff = toMin(time) - toMin(inTime.get(num));
                total.put(num, total.getOrDefault(num, 0) + diff);
                inTime.remove(num);
            }
        }
        
        for (Map.Entry<String, String> e: inTime.entrySet()) {
            String num = e.getKey();
            int diff = LAST - toMin(e.getValue());
            total.put(num, total.getOrDefault(num, 0) + diff);
        }
        
        int[] result = new int[total.size()];
        int i = 0;
        for (int v: total.values()) {
            result[i++] = fare(v, fees);
        }
        
        return result;
    }
        
    int toMin(String t) {
        String[] p = t.split(":");
        return Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
    }
    
    int fare(int minutes, int[] fees) {
        if (minutes <= fees[0]) return fees[1];
        int units = (minutes - fees[0] + fees[2] - 1) / fees[2];
        return fees[1] + units * fees[3];
    }
}