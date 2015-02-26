package org.andromda.presentation.bpm4struts;

public class ForwardForm
    extends br.mdarte.exemplo.academico.accessControl.LoginFormImpl
    implements java.io.Serializable
{
    private String applicationName = "";
    private String modulo = "";
    private String path = "";

    public void setApplicationName(String applicationName)
    {
        this.applicationName = applicationName;
    }

    public void setModulo(String modulo)
    {
        this.modulo = modulo;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getApplicationName()
    {
        return this.applicationName;
    }

    public String getModulo()
    {
        return this.modulo;
    }

    public String getPath()
    {
        return this.path;
    }
}