<%@page import="javax.management.MBeanServer"%>
<%@page import="javax.management.MBeanServerFactory"%>
<%@page import="javax.management.ObjectName"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>

<% 
	try {

	boolean serverJbossEncontrado = false;
	MBeanServer server = null;
	for (Iterator i = MBeanServerFactory.findMBeanServer(null).iterator(); i.hasNext(); ) {
		server = (MBeanServer) i.next();
		if (server.getDefaultDomain().equals("jboss")) {
			serverJbossEncontrado = true;
			break;
		}
	}
	
	if (!serverJbossEncontrado)
		throw new IllegalStateException("No 'jboss' MBeanServer found!");

	String query = "jboss.web:type=Connector,*";
	Set matches = server.queryNames(new ObjectName( query ), null );
	Iterator it = matches.iterator();

	String portaHttp = null;
	String portaHttps = null;
	
	while( it.hasNext() ) {  
		 ObjectName objName = (ObjectName) it.next();
		 
		 String scheme = (String) server.getAttribute(objName, "scheme");
		 String protocol = (String) server.getAttribute(objName, "protocol");			 
		 Integer port = (Integer) server.getAttribute(objName, "port");			 
			 
		 if (protocol != null && protocol.startsWith("HTTP"))
		 {
			 if (scheme != null && scheme.equals("http"))
				 portaHttp = port.toString();
			 else if (scheme != null && scheme.equals("https"))
				 portaHttps = port.toString();
		 }
	 }

	if (request.getServerPort() != 80) {
		pageContext.setAttribute("remoteURL", request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort());
	} else {
		pageContext.setAttribute("remoteURL", request.getScheme() + "://" + request.getServerName());   
	}
	
	
	String ipLocal = (String) session.getServletContext().getAttribute("ipLocal");
	if (request.getScheme().equals("http")) {
		pageContext.setAttribute("localURL", request.getScheme() + "://" + ipLocal + ":" + portaHttp);
	} else {
		pageContext.setAttribute("localURL", request.getScheme() + "://" + ipLocal + ":" + portaHttps);
	}
	
	
	} catch (Exception e) { throw new RuntimeException(e); }
%>
        
<% 
pageContext.setAttribute("layout", org.andromda.presentation.bpm4struts.LayoutConfiguration.instance().getLayoutConfiguration());   
pageContext.setAttribute("layoutPath",pageContext.getAttribute("remoteURL") + "/sistemaacademico/layout/" + pageContext.getAttribute("layout"));
pageContext.setAttribute("localLayoutPath",pageContext.getAttribute("localURL") + "/sistemaacademico/layout/" + pageContext.getAttribute("layout"));
%>