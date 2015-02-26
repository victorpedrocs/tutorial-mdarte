<%@ page session="true" isErrorPage="true" %>
<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>


<html:html lang="true">
	<head>
		<title><bean:message key="error.${param.code}.title"/></title>
		<html:base/>
		<meta http-equiv="Content-Type" content="text/html; charset:utf-8" />
<%-- uncomment this to enable the browser 'favorites' icons
		<link rel="shortcut icon" href="my-custom-image.ico"></link>
		<link rel="icon" type="image/gif" href="my-custom-image.gif"></link>
--%>
		<c:import url="${localLayoutPath}/conf/include-stylesheets.jsp"/>
		<c:import url="${localLayoutPath}/conf/include-javascripts.jsp"/>
	</head>

	<body>
		<div id="wrap">
<!-- Begin page content -->
			<div class="container">
				<%@ include file="/menu/menu-open.jsp" %>
				<div class="page-header">
					<h1><bean:message key="error.${param.code}.title"/></h1>
				</div>
				
				<div id="error-content">
					<p class="lead">
						Message: <br/><bean:message key="error.${param.code}.message"/><br/><hr/>
					<p class="lead">
						<logic:messagesPresent message="true" property="org.andromda.bpm4struts.errormessages">
							<html:messages id="error" message="true" property="org.andromda.bpm4struts.errormessages">
								Error: <br/>${error}<br/><hr/>
							</html:messages> 
						</logic:messagesPresent>
						<logic:messagesPresent message="true" property="org.andromda.bpm4struts.warningmessages">
							<html:messages id="warning" message="true" property="org.andromda.bpm4struts.warningmessages">
								Warning: <br/>${warning}<br/><hr/>
							</html:messages>
						</logic:messagesPresent>
						
						<%  Exception e = (Exception)request.getSession().getAttribute(org.apache.struts.Globals.EXCEPTION_KEY); 
							request.getSession().removeAttribute(org.apache.struts.Globals.EXCEPTION_KEY);
							if(e != null) {
								java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
								java.io.PrintStream ps = new java.io.PrintStream(baos);
								e.printStackTrace(ps);
								String stackTrace = baos.toString();
								request.getSession().getServletContext().getContext("/sistemaacademico").setAttribute("stackTrace", stackTrace);
							}
						%>
					<p class="lead">
						Stacktrace:
						<div class="error">
							<pre><%=(String)request.getSession().getServletContext().getContext("/sistemaacademico").getAttribute("stackTrace")%></pre>
						</div>
					</p>
				</div>
			</div>
			
			<div id="footer">
				<div class="container">
					<p class="muted credit">&copy; MDArte.</p>
				</div>
			</div>
		</div>
	</body>
</html:html>
