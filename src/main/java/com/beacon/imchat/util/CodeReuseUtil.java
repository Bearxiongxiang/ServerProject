package com.beacon.imchat.util;

import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

/** 
 * 代码复用模块
 * @author Tina
 * @date Mar 8, 2017 6:42:44 PM 
 * @version V1.0 
 */
public class CodeReuseUtil {

    /** -------- 毫秒转化类型 --------- */
	public static final int CONVERT_DAY = 0;
	public static final int CONVERT_HOUR = 1;
	public static final int CONVERT_MINUTE = 2;
	public static final int CONVERT_SECOND = 3;

    /** -------- 参数值检测后异常类型 --------- */
	public static final int DEFAULT_EMPTY_UNDEFINED = 0;
	public static final int DEFAULT_EMPTY = 1;
	public static final int UNDEFINED = 2;

	/**
	 * 检查请求参数是否缺省或值为空
	 * @param paramValue 参数值数组
	 * @param paramKey 参数名数组
	 * @return String 返回存在缺省或值为空的参数名
	 */ 
	public static String checkParam(String[] paramValue,String[] paramKey){
		String emptyStr = "";
		for (int i = 0; i < paramKey.length; i++) {
			if (paramValue[i] == null || paramValue[i].trim().equals("")) {
				if (!emptyStr.equals("")) {
					emptyStr = emptyStr + "、";
				}
				emptyStr = emptyStr + paramKey[i];
			}
		}
		if (!emptyStr.equals("")) {
			emptyStr = errParam(DEFAULT_EMPTY,emptyStr);
		}
		return emptyStr;
	}

	/**  
	 * 参数值存在问题时，拼接返回相关提示 
	 * @param tag 返回语句选择CodeReuse.DEFAULT_EMPTY_UNDEFINED / CodeReuse.DEFAULT_EMPTY / CodeReuse.UNDEFINED
	 * @param param 存在问题的参数名
	 * @return String
	 */ 
	public static String errParam(int tag,String param){
		if (tag == DEFAULT_EMPTY_UNDEFINED) {
			return "参数 ' " + param + " ' 可能缺省/值为空/值未定义，请参考API文档！";
		}else if (tag == DEFAULT_EMPTY) {
			return "参数 ' " + param + " ' 可能缺省/值为空，请参考API文档！";
		}else{
			return "参数 ' " + param + " ' 值未定义，请参考API文档！";
		}
	}
	
	/**
	 * 将毫秒转换成天/时/分/秒等类型
	 * @param msec 毫秒
	 * @param type 指定转换类型
	 * @return long
	 */
	public static double convertMsec(long msec,int type) {
		double second = msec / 1000d;
		double minute = second / 60;
		double hour = minute / 60;
		double day = hour / 24;
		if (type == CONVERT_DAY) return formatTwoDecimal(day);
		else if (type == CONVERT_HOUR) return formatTwoDecimal(hour);
		else if (type == CONVERT_MINUTE) return formatTwoDecimal(minute);
		else return formatTwoDecimal(second);
	}
	
	/**
	 * 获取时间差的毫秒数
	 * @param begin 时间段的开始
	 * @param end	时间段的结束
	 * @return	long
	 */
	public static long getMsec(Date begin, Date end) {
		return end.getTime() - begin.getTime();
	}
	
	/**  
	 * 四舍五入，保留两位小数
	 * @param num 数值
	 * @return double
	 */ 
	public static double formatTwoDecimal(double num){
		return ((double)Math.round(num*100)/100);
	}

	/**
	 * 四舍五入，保留两位小数
	 * @param num 数值
	 * @return float
	 */
	public static float formatFloatTwoDecimal(float num){
		return ((float)Math.round(num*100)/100);
	}
	
	/**  
	 * 返回小写的系统类型
	 * @return String
	 */ 
	public static String getSystem(){
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		return os.toLowerCase();
	}

    /** 将文件转成base64 字符串 */
    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }
}


