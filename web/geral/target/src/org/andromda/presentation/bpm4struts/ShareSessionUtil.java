package org.andromda.presentation.bpm4struts;

import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShareSessionUtil{

    private static final String SESSION_KEY = "sessionkey";

    public static String getCookieValue(HttpServletRequest request, String name) {
    	boolean found = false;
    	String result = null;
    	Cookie[] cookies = request.getCookies();
    	if (cookies!=null) {
        	int i = 0;
        	while (!found && i < cookies.length) {
            		if (cookies[i].getName().equals(name)) {
                		found=true;
                		result = cookies[i].getValue();
            		}
            		i++;
    	  	}
    	}
	return (result);
    }

    public static void setCookieValue(HttpServletResponse response, String value, String key){
    	Cookie ssocookie = new Cookie(key, value);
	ssocookie.setPath("/");
	response.addCookie(ssocookie);
    }
    
    public static void saveMapIntoContext(HttpServletRequest request, HttpServletResponse response, Map map, ServletContext context){
    	String sessionValue = getCookieValue(request, SESSION_KEY);
    	
    	if(sessionValue == null || sessionValue.equals(""))
    		sessionValue = request.getSession().getId();
    	
    	setCookieValue(response, sessionValue, SESSION_KEY);
    		
    	context.setAttribute(sessionValue, map);
    	
    }
    
    public static Map getMapFromContext(HttpServletRequest request, ServletContext context){
    	String sessionValue = getCookieValue(request, SESSION_KEY);
    	
    	if(sessionValue == null) return null;
    	Map map = (Map)context.getAttribute(sessionValue);
    	context.removeAttribute(sessionValue);	
    	return map;
    }	
}

