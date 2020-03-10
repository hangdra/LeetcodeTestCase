package leetcode;



class Solution {

	static int MAX_INT = Integer.MAX_VALUE;
	static int MIN_INT = Integer.MIN_VALUE;
    public static int myAtoi(String str) {
        int default_val = 0;
        int result_val = default_val;
        Integer start_index = null;
        Integer end_index = null ;
        int str_l = str.length();
        if( str_l != 0) {
        	for (int i = 0 ;i<str_l;i++){
        		int charTmp = str.charAt(i); //may need to convert to int
        		if (start_index == null) {
        			if (charTmp == 43 || charTmp == 45 || (charTmp >= 48 && charTmp <= 57)){
        				start_index = i;
        				end_index = start_index ;
        			}else if (charTmp == 32){
        				continue;
        			}else{
        				break;
        			}
        		}else{
        			if (charTmp >= 48 && charTmp <= 57){
        				end_index = i;
        			}else{
        				break;
        			}
        		}
        	}
        }
//        System.out.println(start_index+" "+end_index +" "+str_l);
        if (start_index!= null && end_index!= null && start_index<end_index+1 && end_index+1 <= str_l){
        	String int_str_type = str.substring(start_index, end_index+1);
        	result_val = return_int_able_val(int_str_type);
        }
        //System.out.println(int_str_type);
//        result_val = Integer.parseInt(int_str_type);
        return result_val;
    }

    public static int return_int_able_val (String str_int){
    	char charTmp = str_int.charAt(0);
    	int l = str_int.length();
    	int start_inde = 0;
    	String symbol = "";
    	if (charTmp == 43 || charTmp == 45){
    		start_inde = start_inde + 1;
    		symbol = String.valueOf(charTmp);
    	}

    	for (int i = start_inde ; i < str_int.length() ; i ++ ){
    		if(str_int.charAt(i) == 48){
    			start_inde = start_inde + 1;
    			l--;
    		}else{
    			break;
    		}
    	}
    	if (!symbol.equals("")){
    		l--;
    	}
//    	System.out.println(start_inde +" " + str_int.length());
    	str_int =symbol + str_int.substring(start_inde,str_int.length());
//    	System.out.println(l);
    	if (l == 0 ){
    		return 0;
    	}
    	if (l>10){
    		if (charTmp == 45){
    			return MIN_INT;
    		}else{
    			return MAX_INT;
    		}
    	}else if (l == 10){
    		long lv = Long.parseLong(str_int);
    		if(lv > MAX_INT){
    			return MAX_INT;
    		}else if (lv < MIN_INT){
    			return MIN_INT;
    		}else{
    			return Integer.parseInt(str_int);
    		}
    	}else{
    		return Integer.parseInt(str_int);
    	}
    }


    public static void main(String[] args){
//    	System.out.println(Long.MAX_VALUE);
//    	System.out.println(MAX_INT);
//    	System.out.println(String.valueOf((int)"3".charAt(0)));
//    	System.out.println(myAtoi("4193 with words"));
//    	System.out.println(myAtoi("words and 987"));
//    	System.out.println(myAtoi("-91283472332"));
    	System.out.println(myAtoi("+"));
    	System.out.println(myAtoi("3.14159"));
    	System.out.println(myAtoi("  0000000000012345678"));
    	System.out.println(myAtoi("010"));

//    	System.out.println("0123456789".charAt(5) - "0123456789".charAt(3));
    }
}
