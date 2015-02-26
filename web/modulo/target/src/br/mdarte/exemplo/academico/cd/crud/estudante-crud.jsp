<%@ include file="/taglib-imports.jspf" %>
<tiles:insert definition="main.layout">

    <tiles:put name="title" type="string">
        <bean:message key="estudante.page.title"/>
    </tiles:put>

    <tiles:put name="style" type="string">
        <link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/layout/default-manageable.css"/>"></link>
        <link rel="stylesheet" type="text/css" media="all" href="<html:rewrite page="/layout/default-calendar.css"/>"/>
    </tiles:put>

    <tiles:put name="javascript" type="string">
        <script type="text/javascript" src="<html:rewrite action="/calendar"/>"></script>
        <script type="text/javascript">
        //<!--
            function setSelect(multi, form, name, value)
            {
                var select = form.elements[name];
                var options = select.options;

                // for browser compatibility's sake we go through the options ourselves
                for (var i=0; i<options.length; i++)
                {
                    if (multi)
                    {
                        // Array.indexOf is defined in Javascript 1.5, not before
                        options[i].selected = arrayContainsElement(value,options[i].value);
                    }
                    else
                    {
                        if (options[i].value == value)
                        {
                            select.selectedIndex = i;
                            break;
                        }
                    }

                }
            }

            function arrayContainsElement(array, element)
            {
              var containsElement = false;
              for (var i=0; i<array.length && !containsElement; i++) containsElement = (array[i] == element);
              return containsElement;
            }

            function setAction(crud) { document.forms['manageEstudanteForm'].elements['crud'].value = crud; }

            function enableUpdate(enabled) { document.getElementById("updateButton").disabled = !enabled; }

            var selectionCount = 0;

            function verifyEnableDelete(checkbox)
            {
                if (checkbox.checked) selectionCount++; else selectionCount--;
                document.getElementById("deleteButton").disabled = (selectionCount < 1);
            }

            function clearFields(form)
            {
                form.reset();
                enableUpdate(false);
                setFields("","","","",form);
            }

            function setFields(matricula,nome,id,curso,form)
            {
                form.elements["matricula"].value = matricula;
                form.elements["nome"].value = nome;
                form.elements["id"].value = id;
                setSelect(false,form,"curso",curso);
            }
        //-->
        </script>
    </tiles:put>

    <tiles:put name="body" type="string">

        <div>
            <h1><bean:message key="estudante.page.title"/></h1>
        </div>
		
        <html:form styleId="manageEstudanteForm" action="/Estudante/Manage" method="post" enctype="multipart/form-data">
            <input type="hidden" name="crud" value=""/>
            <div id="criteria">
                <c:if test="${!empty manageableForm}">
                    <table>
                        <tr>
                            <td><nobr><bean:message key="estudante.matricula"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="matricula" styleClass="criteriaField" styleId="matricula"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="estudante.nome"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="nome" styleClass="criteriaField" styleId="nome"/>
                            </td>
                        </tr>
                    <html:hidden name="manageableForm" property="id"/>
                        <tr>
                            <td>
                                    <nobr><html:link action="/Curso/Manage"><bean:message key="estudante.curso"/></html:link> <div class="important">*</div></nobr>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.cursoBackingList}">
                                        <select name="curso" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="curso">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.cursoBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.curso}">
                                                        <option value="${valueLabel[0]}" selected="selected">${valueLabel[1]}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${valueLabel[0]}">${valueLabel[1]}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </table>

                    <input type="submit" id="readButton" class="button" value="<bean:message key="button.read"/>" onclick="this.form.elements['id'].value='';setAction('read');"/>
                    <input type="submit" id="createButton" class="button" value="<bean:message key="button.create"/>" onclick="setAction('create');"/>
                    <input type="submit" id="deleteButton" class="button" value="<bean:message key="button.delete"/>" disabled="disabled" onclick="setAction('delete');"/>
                    <input type="submit" id="updateButton" class="button" value="<bean:message key="button.update"/>" disabled="disabled" onclick="setAction('update');return validateUpdate();"/>
                    <input type="button" id="clearButton" class="button" value="<bean:message key="button.clear"/>" onclick="clearFields(this.form);"/>
                </c:if>

<div id="entitySwitcher">
    <nobr>
        <bean:message key="select.other.entity"/>
        <select onchange="document.location=this.options[this.selectedIndex].value+'?ref_Estudante='+this.form.elements['id'].value;">
            <option value="<html:rewrite page="/Curso/Manage.do"/>"><bean:message key="curso"/><bean:message key="referencing.entity.marker"/></option>
            <option selected="selected" value="<html:rewrite page="/Estudante/Manage.do"/>"><bean:message key="estudante"/></option>
        </select>
    </nobr>
</div>

            </div>

            <div id="manageableList" class="table">
                <c:if test="${!empty manageableForm.manageableList}">
                    <display:table name="${manageableForm.manageableList}" id="row" requestURI="${pageContext.request.requestURI}"
                            export="true" pagesize="15" sort="list">
                        <display:column media="html" sortable="false">
                            <nobr>
                                <input type="radio" name="_copy" onclick="enableUpdate(true);setFields('<formatting:escape language="javascript">${row.matricula}</formatting:escape>','<formatting:escape language="javascript">${row.nome}</formatting:escape>','<formatting:escape language="javascript">${row.id}</formatting:escape>','<formatting:escape language="javascript">${row.curso}</formatting:escape>',this.form);"/>
                                <input type="checkbox" name="selectedRows" value="${row.id}" onclick="verifyEnableDelete(this);"/>
                            </nobr>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="matricula"
                            titleKey="estudante.matricula"/>
                        <display:column media="html"
                            headerClass="matricula" paramId="matricula" maxLength="36"
                            sortProperty="matricula" sortable="false"
                            titleKey="estudante.matricula"><nobr>${row.matricula}</nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="nome"
                            titleKey="estudante.nome"/>
                        <display:column media="html"
                            headerClass="nome" paramId="nome" maxLength="36"
                            sortProperty="nome" sortable="false"
                            titleKey="estudante.nome"><nobr>${row.nome}</nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="cursoLabel"
                            titleKey="estudante.curso"/>
                        <display:column media="html"
                            headerClass="curso" paramId="curso" maxLength="36"
                            sortProperty="cursoLabel" sortable="false"
                            titleKey="estudante.curso"><nobr>${row.cursoLabel}</nobr></display:column>
                    </display:table>
                </c:if>
            </div>

        </html:form>

        <div id="pageHelpSection">
            <blockquote>
                <a href="" id="pageHelp" style="display:inline;" onclick="openWindow('<html:rewrite action="/Estudante/ManageHelp"/>','onlinehelp',true,false,760,540); return false;">
                    <bean:message key="online.help.href"/>
                </a>
                <html:img page="/layout/help.gif" style="display:inline;"/>
            </blockquote>
        </div>

    </tiles:put>

</tiles:insert>

