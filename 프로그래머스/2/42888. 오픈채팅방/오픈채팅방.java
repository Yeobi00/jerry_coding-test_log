import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nicknames = new HashMap<>();
        
        List<String> result = new ArrayList<>();
        
        for (String r: record) {
            StringTokenizer st = new StringTokenizer(r);
            String cmd = st.nextToken();
            String uid = st.nextToken();
            
            if (!cmd.equals("Leave")) {
                nicknames.put(uid, st.nextToken());  
            }
        }
        
        for (String r: record) {
            StringTokenizer st = new StringTokenizer(r);
            String cmd = st.nextToken();
            String uid = st.nextToken();
            String nickname = nicknames.get(uid);
            
            StringBuilder sb = new StringBuilder(nickname);
            sb.append("님이 ");
            
            switch (cmd) {
                case "Enter":
                    sb.append("들어왔습니다.");
                    break;
                case "Leave":
                    sb.append("나갔습니다.");
                    break;
                case "Change":
                    continue;
            }
            
            result.add(sb.toString());
        }
        
        return result.toArray(new String[0]);
    }
}