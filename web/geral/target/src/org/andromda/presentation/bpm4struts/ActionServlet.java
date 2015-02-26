package org.andromda.presentation.bpm4struts;

/**
 * This servlet is designed to avoid Struts copying zeroes into those form
 * fields that take numerical values.
 *
 * It also takes care of properly setting the content type for the returned reponse.
 */
public class ActionServlet
    extends org.apache.struts.action.ActionServlet
{
    /**
     * Call the parent initializer and configure the converter not to
     * convert <code>null</code> numbers to the corresponding zero value.
     */
	
	private static java.util.Properties ports = new java.util.Properties();

	static{
		try{
			ports.load(new java.io.FileInputStream(new java.io.File((new java.net.URL(System.getProperty("jboss.server.config.url") + java.io.File.separator + "sistemaacademico-port.properties")).getFile())));

			if(ports.getProperty("https.port") == null || ports.getProperty("http.port") == null)
				throw new RuntimeException("error.port.configuration");

		}catch(java.io.IOException e){
			throw new RuntimeException("port.file.not.found");
		}
	}
	
    public void init(final javax.servlet.ServletConfig config)
        throws javax.servlet.ServletException
    {
        super.init(config);
		
		String aplicacaoPermiteUsoBackBrowser = ports.getProperty("aplicacao.permite.uso.back.browser");
		
		if (aplicacaoPermiteUsoBackBrowser == null || aplicacaoPermiteUsoBackBrowser.equals("false"))
			this.getServletContext().setAttribute("aplicacaoPermiteUsoBackBrowser", Boolean.FALSE);
        else
			this.getServletContext().setAttribute("aplicacaoPermiteUsoBackBrowser", Boolean.TRUE);

		this.getServletContext().setAttribute("httpsPort", ports.getProperty("https.port"));
        this.getServletContext().setAttribute("httpPort", ports.getProperty("http.port"));
        String ipLocal = ports.getProperty("jboss.ip.local");
		
        if (ipLocal == null || ipLocal.equals(""))
	        this.getServletContext().setAttribute("ipLocal", "127.0.0.1");
        else
	        this.getServletContext().setAttribute("ipLocal", ipLocal);
			
		String aplicacaoGerenciaTrocaDePortasString = ports.getProperty("troca.de.porta.gerenciada.pela.aplicacao");
		
		if (aplicacaoGerenciaTrocaDePortasString != null && aplicacaoGerenciaTrocaDePortasString.equals("false"))
	        this.getServletContext().setAttribute("aplicacaoGerenciaTrocaDePortas", Boolean.FALSE);
		else
	        this.getServletContext().setAttribute("aplicacaoGerenciaTrocaDePortas", Boolean.TRUE);

        trustAllHttpsCertificates();
        
        javax.net.ssl.HostnameVerifier hv = new javax.net.ssl.HostnameVerifier()
        {
            public boolean verify(String urlHostName, javax.net.ssl.SSLSession session)
            {
                System.out.println("Warning: URL Host: " + urlHostName + " vs. "
                        + session.getPeerHost());
                return true;
            }
        };
        
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(hv);

        org.apache.commons.beanutils.ConvertUtils.register(
            new org.apache.commons.beanutils.converters.LongConverter(null), java.lang.Long.class);
        org.apache.commons.beanutils.ConvertUtils.register(
            new org.apache.commons.beanutils.converters.IntegerConverter(null), java.lang.Integer.class);
        org.apache.commons.beanutils.ConvertUtils.register(
            new org.apache.commons.beanutils.converters.ShortConverter(null), java.lang.Short.class);
        org.apache.commons.beanutils.ConvertUtils.register(
            new org.apache.commons.beanutils.converters.DoubleConverter(null), java.lang.Double.class);
        org.apache.commons.beanutils.ConvertUtils.register(
            new org.apache.commons.beanutils.converters.FloatConverter(null), java.lang.Float.class);
    }

    public void doGet(
        final javax.servlet.http.HttpServletRequest request,
        final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException
    {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        super.doGet(request, response);
    }

    public void doPost(
        final javax.servlet.http.HttpServletRequest request,
        final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException
    {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        super.doPost(request, response);
    }
    
    private static void trustAllHttpsCertificates()
    {
 
    	try {
 
        javax.net.ssl.TrustManager[] trustAllCerts =
 
        new javax.net.ssl.TrustManager[1];
 
        javax.net.ssl.TrustManager tm = new miTM();
 
        trustAllCerts[0] = tm;
 
        javax.net.ssl.SSLContext sc;
		
			sc = javax.net.ssl.SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, null);
		
 
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(
 
        sc.getSocketFactory());
    	} catch (Exception e) {
			e.printStackTrace();
		}
 
    }
 
    public static class miTM implements javax.net.ssl.TrustManager,
            javax.net.ssl.X509TrustManager
    {
        public java.security.cert.X509Certificate[] getAcceptedIssuers()
        {
            return null;
        }
 
        public boolean isServerTrusted(
                java.security.cert.X509Certificate[] certs)
        {
            return true;
        }
 
        public boolean isClientTrusted(
                java.security.cert.X509Certificate[] certs)
        {
            return true;
        }
 
        public void checkServerTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException
        {
            return;
        }
 
        public void checkClientTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException
        {
            return;
        }
    }
}