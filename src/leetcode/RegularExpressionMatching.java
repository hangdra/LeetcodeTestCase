package leetcode;

public class RegularExpressionMatching {
	
	public static boolean isMatch(String s,String p){
		int p_len = p.length();
		int s_len = s.length();

		if (p_len==0 || s_len == 0 ){
			return false;
		}
		boolean first_match = (s.charAt(0) == p.charAt(0) || p.charAt(0)=='.');
		if (p.length()>=2 && p.charAt(1)=='*'){
				return isMatch(s,p.substring(2)) || first_match && isMatch(s.substring(1),p.substring(1)) ;
		}else{ 
			return first_match && isMatch(s.substring(1), p.substring(1));
		}

		
	}
	public static Integer pCursorNextSoft(String partten,int last_index,boolean last_match,boolean ignoire_symbol){
		int p_l = partten.length();
		if (partten.charAt(last_index) == '*' && last_match){
			if (ignoire_symbol){
				return last_index+1;
			}else{
				return last_index;
			}
		}else if(partten.charAt(last_index) == '*' && !last_match && last_index + 1 < p_l){
			return last_index+1;
		}else if(partten.charAt(last_index) != '*' && last_index + 1 < p_l){
			return last_index+1;
		}else{
			return null;
		}
	}
	
	
	
	public static Character char_at(String partten,int index){
		int p_l = partten.length();
		if (index < p_l){
			if (partten.charAt(index) == '*'){
				if (index-1>=0){
					return partten.charAt(index-1);
				}else{
					return null;
				}
			}else{
				return partten.charAt(index);
			}
		}else{
			return null;
		}
	}
	
	public static boolean match_x(char able_char,char now_char){
//		System.out.println(able_char + " "+ now_char);
		if (able_char == '.' || able_char == now_char){
			return true;
		}else{
			return false;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "aab";
		String p = "c*a*b";
//		System.out.println(isMatch(s,p));
//		
//		s = "ab";
//		p = ".*";
//		System.out.println(isMatch(s,p));
//		
//		s = "mississippi";
//		p = "mis*is*p*i";
//		System.out.println(isMatch(s,p));
//		
//		s = "a";
//		p = "";
//		System.out.println(isMatch(s,p));
//		
//		s ="aa";
//		p = "a";
//		System.out.println(isMatch(s,p));
//		
//		s ="aaa";
//		p = "aa";
//		System.out.println(isMatch(s,p));
//		
//
//		s ="ab";
//		p =".*c";
//		System.out.println(isMatch(s,p));
//		
//		s ="aaa";
//		p ="aaaa";
//		System.out.println(isMatch(s,p));
//		
		 
//		s ="aaa";
//		p ="a*a";
//		System.out.println(isMatch(s,p));
		System.out.println("123".substring(1));
	}

}
