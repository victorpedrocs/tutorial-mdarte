// license-header java merge-point
package br.mdarte.exemplo.academico.cd.crud;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public final class ManageEstudante extends DispatchAction
{
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.getSession().setAttribute("manageableForm", actionForm);
        return super.execute(mapping, actionForm, request, response);
    }

    public ActionForward create(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final br.mdarte.exemplo.academico.cd.crud.EstudanteForm form = (br.mdarte.exemplo.academico.cd.crud.EstudanteForm)actionForm;

        br.mdarte.exemplo.academico.ManageableServiceLocator.instance().getEstudanteManageableService().create(
            (StringUtils.isBlank(request.getParameter("matricula"))) ? null : form.getMatricula()
            , (StringUtils.isBlank(request.getParameter("nome"))) ? null : form.getNome()
            , (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("curso"))) ? null : form.getCurso()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward read(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final br.mdarte.exemplo.academico.cd.crud.EstudanteForm form = (br.mdarte.exemplo.academico.cd.crud.EstudanteForm)actionForm;

        final java.util.List list = br.mdarte.exemplo.academico.ManageableServiceLocator.instance().getEstudanteManageableService().read(
            (StringUtils.isBlank(request.getParameter("matricula"))) ? null : form.getMatricula()
            , (StringUtils.isBlank(request.getParameter("nome"))) ? null : form.getNome()
            , (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("curso"))) ? null : form.getCurso()
        );
        form.setManageableList(list);

        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = br.mdarte.exemplo.academico.ManageableServiceLocator.instance().getEstudanteManageableService().readBackingLists();
        form.setCursoBackingList((java.util.List)backingLists.get("curso"));

        return mapping.getInputForward();
    }

    public ActionForward preload(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final br.mdarte.exemplo.academico.cd.crud.EstudanteForm form = (br.mdarte.exemplo.academico.cd.crud.EstudanteForm)actionForm;

        final java.util.List list = br.mdarte.exemplo.academico.ManageableServiceLocator.instance().getEstudanteManageableService().readAll();
        form.setManageableList(list);


        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = br.mdarte.exemplo.academico.ManageableServiceLocator.instance().getEstudanteManageableService().readBackingLists();
        if (StringUtils.isNotBlank(request.getParameter("ref_Curso")))
        {
            form.setCurso(new java.lang.Long(request.getParameter("ref_Curso")));
        }
        form.setCursoBackingList((java.util.List)backingLists.get("curso"));

        return mapping.getInputForward();
    }

    protected ActionForward unspecified(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return preload(mapping, actionForm, request, response);
    }

    public ActionForward update(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final br.mdarte.exemplo.academico.cd.crud.EstudanteForm form = (br.mdarte.exemplo.academico.cd.crud.EstudanteForm) actionForm;

        br.mdarte.exemplo.academico.ManageableServiceLocator.instance().getEstudanteManageableService().update(
            (StringUtils.isBlank(request.getParameter("matricula"))) ? null : form.getMatricula()
            , (StringUtils.isBlank(request.getParameter("nome"))) ? null : form.getNome()
            , (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("curso"))) ? null : form.getCurso()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final br.mdarte.exemplo.academico.cd.crud.EstudanteForm form = (br.mdarte.exemplo.academico.cd.crud.EstudanteForm) actionForm;

        final java.lang.Long[] selectedRows = form.getSelectedRows();
        if (selectedRows != null && selectedRows.length > 0)
        {
            br.mdarte.exemplo.academico.ManageableServiceLocator.instance().getEstudanteManageableService().delete(selectedRows);
        }

        return preload(mapping, actionForm, request, response);
    }

    private void saveMaxResultsWarning(HttpServletRequest request)
    {
        final HttpSession session = request.getSession();

        ActionMessages messages = (ActionMessages)session.getAttribute(org.apache.struts.Globals.MESSAGE_KEY);
        if (messages == null)
        {
            messages = new ActionMessages();
            session.setAttribute(org.apache.struts.Globals.MESSAGE_KEY, messages);
        }
        messages.add("org.andromda.bpm4struts.warningmessages", new ActionMessage("maximum.results.fetched.warning", "250"));
    }

}
