package com.jokerbase.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringUtils {
	
	
	public static String toPath(String date){
		StringBuffer result = new StringBuffer();
		result.append(File.separator);
		result.append(date.substring(0,4));
		result.append(File.separator);
		result.append(date.substring(4,6));
		result.append(File.separator);
		result.append(date.substring(6,8));
		result.append(File.separator);
		result.append(date.substring(8));
		result.append(File.separator);
		return result.toString();
	}
	
	public static boolean isNullorBlank(final String str) {
		boolean isNorB = false;
		if (null == str || 0 >= str.length() || str.equals("null")) {
			isNorB = true;
		}
		return isNorB;
	} 
	/**
	 * 
	 * <p>作者:lht</p> 
	 * <p>功能描述:字符串不为空或空格</p>
	 * <p>创建时间:2012-7-28下午5:03:33</p>
	 * <p>@param str
	 * <p>@return</p>
	 * <p>修改:</p>
	 */
	public static boolean stringIsNull(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}

	public static List<Integer> stringArrayToIntegerList(String[] source){
		List<Integer> list = new ArrayList<Integer>();
		if(source != null && source.length > 0){
			for(String s : source){
				list.add(new Integer(s));
			}
		}
		return list;
	}
	
	/**
	 * 判断字符串是否为数字
	 */
	public static boolean isNumeric(String str){
	     Pattern pattern = Pattern.compile("[0-9]*");
	     return pattern.matcher(str).matches();   
	}
	/**
	 * 判断字符串是否为数字(整数或者小数)
	 */
	public static boolean isNumericOrDouble(String str){
	     Pattern pattern = Pattern.compile("[0-9]*|[0-9]*\\.[0-9]*");
	     return pattern.matcher(str).matches();   
	}
	
	/**
	 * 票据单号验证专用
	 * 检验是否符合票据号段输入的规则
	 * @param num 号码
	 * @param type 票据类型
	 * @return
	 */
	public static boolean checkReceiptNo(int num,int type){
		switch (type){
			case 0://聚优课外辅导协议
				if(num%20==0)
					return true;
				return false;
			case 1://聚优一对一收费凭证
				if(num%25==0)
					return true;
				return false;
			case 2://巨人学校收费凭证
				if(num%25==0)
					return true;
				return false;
			case 3://巨人学校个人业务凭证
				if(num%50==0)
					return true;
				return false;
			case 4://巨人学校听课证
				if(num%100==0)
					return true;
				return false;
			case 5://巨人学校营员证
				if(num%1==0)
					return true;
				return false;
			default:return false;
		}
	}
	/**
	 * 票据类型的单位 ；票据验证专用
	 * @param num
	 * @param type
	 * @return
	 */
	public static int divEndToStart(int num,int type){
		switch (type){
			case 0://聚优课外辅导协议
				return num/20;
			case 1://聚优一对一收费凭证
				return num/25;
			case 2://巨人学校收费凭证
				return num/25;
			case 3://巨人学校个人业务凭证
				return num/50;
			case 4://巨人学校听课证
				return num/100 * 100;
			case 5://巨人学校营员证
				return num/1;
			default:return 0;
		}
	}
	
	public static void main(String[] args){
		
		System.out.println(StringUtils.isNumericOrDouble("080.2"));
	}
}
