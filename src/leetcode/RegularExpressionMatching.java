
public class RegularExpressionMatching {

	public static boolean isMatch(String s, String p) {
		int p_len = p.length();
		int s_len = s.length();
		if (p_len == 0)
			return s_len == 0;

		boolean first_match = s_len > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

		if (p.length() >= 2 && p.charAt(1) == '*') {
			return isMatch(s, p.substring(2)) || first_match && isMatch(s.substring(1), p.substring(2))
					|| first_match && isMatch(s.substring(1), p);
		} else {
			return first_match && isMatch(s.substring(1), p.substring(1));
		}

	}

	public static void main(String[] args) {

		String s = "aab";
		String p = "c*a*b";
		// System.out.println(isMatch(s, p));
		//
		// s = "ab";
		// p = ".*";
		// System.out.println(isMatch(s, p));
		//
		// s = "mississippi";
		// p = "mis*is*p*i";
		// System.out.println(isMatch(s, p));
		//
		// s = "a";
		// p = "";
		// System.out.println(isMatch(s, p));
		//
		// s = "aa";
		// p = "a";
		// System.out.println(isMatch(s, p));
		//
		// s = "aaa";
		// p = "aa";
		// System.out.println(isMatch(s, p));
		//
		// s = "ab";
		// p = ".*c";
		// System.out.println(isMatch(s, p));
		//
		// s = "aaa";
		// p = "aaaa";
		// System.out.println(isMatch(s, p));
		//
		// s = "aaa";
		// p = "a*a";
		// System.out.println(isMatch(s, p));
		//
		// s = "abc";
		// p = "a*bc";
		// System.out.println(isMatch(s, p));
		//
		// s = "a";
		// p = "ab*";
		// System.out.println(isMatch(s, p));


		s = "aaaaaaaaaaaaab";
		p = "a*a*a*a*a*a*a*a*a*a*c";
		System.out.println(isMatch(s, p));


	}

}
