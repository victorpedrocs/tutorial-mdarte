package org.andromda.presentation.bpm4struts;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

public class PageSessionObjectUtil{

	private static final String PAGES_SESSION_KEY = "pagesKeySession";

	public static void setPageSO(HttpServletRequest request, FormSessionObject pageSO){
		request.getSession().setAttribute(pageSO.SESSION_KEY, pageSO);
		setPageKey(request, pageSO.SESSION_KEY);
	}
	
	public static Object getPageForm(HttpServletRequest request, String pageKey){
		FormSessionObject formSessionObject = (FormSessionObject)request.getSession().getAttribute(pageKey);
		if(formSessionObject  != null){
			formSessionObject.resetCounter();
			return formSessionObject.getForm();
		}else
			return null;
	}
	
	public static void removeOldPagesSO(HttpServletRequest request){
		Collection pagesKey = getCollectionPagesKey(request);
		Collection deletePages = new ArrayList();
		Iterator it = pagesKey.iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			FormSessionObject formSessionObject = (FormSessionObject)request.getSession().getAttribute(key);
			if(formSessionObject != null && formSessionObject.getCounter() <= 0){
				deletePages.add(key);
			}
		}
		
		it = deletePages.iterator();
		
		while(it.hasNext()){
			String key = (String)it.next();
			pagesKey.remove(key);
			request.getSession().removeAttribute(key);
		}
	}
	
	public static void updatePagesSO(HttpServletRequest request){
		Collection pagesKey = getCollectionPagesKey(request);
		Collection deletePages = new ArrayList();
		Iterator it = pagesKey.iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			FormSessionObject formSessionObject = (FormSessionObject)request.getSession().getAttribute(key);
			if(formSessionObject != null){
				formSessionObject.decrementCounter();
				if(formSessionObject.getCounter() <= 0){
					deletePages.add(key);
				}
			}
		}
		
		it = deletePages.iterator();
		
		while(it.hasNext()){
			String key = (String)it.next();
			pagesKey.remove(key);
			request.getSession().removeAttribute(key);
		}
	}
	
	public static void decrementPages(HttpServletRequest request){
		Collection pagesKey = getCollectionPagesKey(request);
		Iterator it = pagesKey.iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			FormSessionObject formSessionObject = (FormSessionObject)request.getSession().getAttribute(key);
			if(formSessionObject != null)
				formSessionObject.decrementCounter();
		}
	}
	
	private static Collection getCollectionPagesKey(HttpServletRequest request){
		Collection pagesKey = (Collection)request.getSession().getAttribute(PAGES_SESSION_KEY);
		
		if(pagesKey == null){
			pagesKey = new ArrayList();
			request.getSession().setAttribute(PAGES_SESSION_KEY, pagesKey);
		}
		
		return pagesKey;
	}
	
	private static void setPageKey(HttpServletRequest request, String pageKey){
		Collection pagesKey = getCollectionPagesKey(request);
		if(!pagesKey.contains(pageKey)){
			pagesKey.add(pageKey);
		}
	}
}