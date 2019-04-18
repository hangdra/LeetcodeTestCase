
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String ts = "abbac";
		System.out.println(lengthOfLongestSubstring(ts));
	}

    public static int lengthOfLongestSubstring(String s) {
		int max_l = 0;
        int max_l_each = 0;
        int max_index_last = -1;
        Map<Character,Integer> se = new HashMap<Character,Integer>();
        for(int i =0;i<s.length();i++) {
        	char c = s.charAt(i);
        	if(se.containsKey(c)) {
        		if (se.get(c)>max_index_last) {
        			max_index_last = se.get(c);
        		}
        	}
        	max_l_each = i-max_index_last;
        	if(max_l_each>max_l) {
    			max_l = max_l_each;
    		}
        	se.put(c, i);
        }
        return max_l;
    }
}
