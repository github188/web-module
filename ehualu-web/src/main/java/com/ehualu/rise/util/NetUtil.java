package com.ehualu.rise.util;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class NetUtil {

    public static String getRemoteAddress(HttpServletRequest request) {  
        String ip = request.getHeader("x-forwarded-for");  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }  
    
    public static String fetchHttpReqContent(HttpServletRequest req) throws IOException{
    	char[] buf = new char[1024];
		BufferedReader reader = req.getReader();
		int len = 0;
		StringBuffer sb = new StringBuffer("");
		while((len = reader.read(buf)) != -1){
			sb.append(buf, 0, len);
		}
		return sb.toString();
    }
	
}
