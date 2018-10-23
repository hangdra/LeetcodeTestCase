package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String st ="ac";
//		System.out.println(st.length());
		System.out.println(longestPalindrome(st));
	}
//method one
//	public static String longestPalindrome(String s) {
//		if(s.length()==0) {
//			return "";
//		}
//		Map<Character,List<Integer>> map = new HashMap<Character,List<Integer>>();	
//		int maxLong = 1;
//		String maxLongStr = s.substring(0, 1);
//		for(int cursor = 0 ;cursor<s.length();cursor++) {
//			if (map.containsKey(s.charAt(cursor))) {
//				List<Integer> lt = map.get(s.charAt(cursor));
//				for(Integer cursorT:lt) {
//					String stemp = s.substring(cursorT, cursor+1);
//					int maxLongTemp = stemp.length();
//					if(isPalindrome(stemp)) {
//						if(maxLongTemp>maxLong) {
//							maxLong = maxLongTemp;
//							maxLongStr = stemp;
//						}
//						break;
//					}
//				}
//				lt.add(cursor);
//			}else {
//				List<Integer> lt = new ArrayList<Integer>();
//				lt.add(cursor);
//				map.put(s.charAt(cursor), lt);
//			}
//		}
//		return maxLongStr;
//	}
//	
//	public static boolean isPalindrome(String s) {
//		int l = s.length();
//		for(int i = 0;i<l/2;i++) {
//			if(s.charAt(i)!=s.charAt(l-1-i)) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	//method two
	private static int ps=0;
	private static int max_l=-1;
	public static String longestPalindrome(String s) {
		if(s.length()<2) {
			return s;
		}
		for (int i = 0;i<s.length()-1;i++) {
			palindromeExtend(s,i,i);
			palindromeExtend(s,i,i+1);
		}
		return s.substring(ps, ps+max_l);
	}
	
	public static void palindromeExtend(String s,int si,int ei) {
		
		while(si>=0 && ei <=s.length()-1&&( s.charAt(si)==s.charAt(ei))) {
			
//			System.out.println("si:"+si+" ei:"+ei+" si:"+s.charAt(si)+" ei:"+s.charAt(ei));
			si--;ei++;
		}
		if(ei-si-1>max_l) {
			max_l = ei-si-1;
			ps = si+1;
		}
	}
	
}
