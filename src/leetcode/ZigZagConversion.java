package leetcode;


import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
	public static void main(String[] args) {
		String k = "PAYPALISHIRING";
		System.out.println(convert2(k, 3).equals("PAHNAPLSIIGYIR"));
		System.out.println(convert2(k, 4).equals("PINALSIGYAHRPI"));
		System.out.println(convert2("ABC", 5));

		// String[] kk ={"1","2","3"};
		// kk[1]=kk[1]+"5";
		// String[] kk =new String[3];
		// System.out.println(kk[1]==null);
		// System.out.println(kk[1]);
		// char k ='k';
		// String kkk = "dfd";
		// String bb = kkk+k;
		// System.out.println(bb);
	}

	public static String convert(String s, int numRows) {
		int lenOfs = s.length();
		int lenOfOneLoop = 2 * numRows - 2;
		if (lenOfOneLoop == 0) {
			return s;
		}
		String[] rows = new String[numRows];
		int loops = (lenOfs + lenOfOneLoop - 1) / lenOfOneLoop;
		for (int i = 0; i < numRows; i++) {
			rows[i] = "";
		}

		// calculate basic position
		int[] firstLoopRowPos = new int[numRows];
		int[] firstLoopAcossPos = new int[numRows];
		for (int i = 0; i < lenOfOneLoop; i++) {
			if (i < numRows) {
				firstLoopRowPos[i] = i;
			} else {
				firstLoopAcossPos[2 * numRows - i - 2] = i;
			}
		}
		boolean over = false;
		for (int i = 0; i < loops && !over; i++) {
			for (int j = 0; j < numRows; j++) {
				int pos = firstLoopRowPos[j] + lenOfOneLoop * i;
				if (pos < lenOfs) {
					rows[j] = rows[j] + String.valueOf(s.charAt(pos));
					// this will also be ok
					// rows[j]=rows[j]+s.charAt(pos);
				} else {
					over = true;
				}
				if (j != 0 && j != numRows - 1) {
					int pos2 = firstLoopAcossPos[j] + lenOfOneLoop * i;
					if (pos2 < lenOfs) {
						rows[j] = rows[j] + String.valueOf(s.charAt(pos2));
					} else {
						over = true;
					}
				}
			}
		}
		String rs = "";
		for (int i = 0; i < numRows; i++) {
			rs = rs + rows[i];
		}
		return rs;
	}

	public static String convert2(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		boolean goingDown = false;
		List<StringBuilder> ls = new ArrayList<StringBuilder>();
		for (int i = 0; i < numRows; i++) {
			ls.add(new StringBuilder());
		}
		int cursor = 0;
		for (char c : s.toCharArray()) {
			ls.get(cursor).append(c);
			if (cursor == 0 || cursor == numRows - 1) {
				goingDown = !goingDown;
			}
			cursor += goingDown ? 1 : -1;
		}
		StringBuilder rs = new StringBuilder();
		for (int i = 0; i < ls.size(); i++) {
			rs.append(ls.get(i));
		}
		return rs.toString();
	}
}
