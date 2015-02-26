package org.andromda.presentation.bpm4struts;

/**
 * This servlet is designed to avoid Struts copying zeroes into those form
 * fields that take numerical values.
 */
public final class ActionServletImpl extends ActionServlet {

    /**
     * Call the parent initializer and configure the converter not to convert
     * <code>null</code> numbers to the corresponding zero value.
     */
    public void init( javax.servlet.ServletConfig config ) throws javax.servlet.ServletException {
        super.init( config );

    }
}

