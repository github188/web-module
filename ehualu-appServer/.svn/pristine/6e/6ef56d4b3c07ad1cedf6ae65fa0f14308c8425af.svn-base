package com.ehualu.rise.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class SessionContext {
	private static final Map<String, HashMap> ctx = new HashMap<String, HashMap>();
	
	private static final Map<String,HttpSession> sessionctx = new HashMap<String,HttpSession>();

	private SessionContext() {
	}

	public static void addCache(String phone,HashMap map) {
		ctx.put(phone, map);
	}

	public static void removeCache(String phone) {
		ctx.remove(phone);
	}

	public static HashMap getCache(String phone) {
		return ctx.get(phone);
	}
	
	public static void addSession(String phone,HttpSession session) {
		sessionctx.put(phone, session);
	}

	public static void removeSession(String phone) {
		sessionctx.remove(phone);
	}

	public static HttpSession getSession(String phone) {
		return sessionctx.get(phone);
	}
}
