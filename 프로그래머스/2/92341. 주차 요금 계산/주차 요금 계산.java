import java.util.*;

class Solution {
    static int baseHour;
    static int baseFee;
    static int unitHour;
    static int unitFee;
    
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
                int diff = calculate(inTime.get(num), time);
                total.put(num, total.getOrDefault(num, 0) + diff);
                inTime.remove(num);
            }
        }
        
        for (Map.Entry<String, String> e: inTime.entrySet()) {
            String k = e.getKey();
            String t = e.getValue();
            
            int diff = calculate(t, "23:59");
            total.put(k, total.getOrDefault(k, 0) + diff);
        }
        
        baseHour = fees[0];
        baseFee = fees[1];
        unitHour = fees[2];
        unitFee = fees[3];
        
        int[] result = new int[total.size()];
        int i = 0;
        for (int v: total.values()) {
            result[i++] = fare(v);
        }
        
        return result;
    }
    
    int calculate(String inTime, String outTime) {
        StringTokenizer st = new StringTokenizer(outTime, ":");
        int out = 60 * Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        st = new StringTokenizer(inTime, ":");
        int in = 60 * Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        return out - in;
    }
    
    int fare(int time) {
        int fee = 0;
        
        fee += baseFee;
        
        if (time > baseHour) {
            fee += ((time - baseHour - 1) / unitHour + 1) * unitFee;
        }
        
        return fee;
    }
}