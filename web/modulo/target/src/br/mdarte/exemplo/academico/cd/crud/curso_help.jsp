<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="curso"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="curso"/></h1>
        <p>
            <bean:message key="curso.online.help"/>
        </p>
        <h2><bean:message key="curso.codigo"/></h2>
        <p>
            <bean:message key="curso.codigo.online.help"/>
        </p>
        <h2><bean:message key="curso.nome"/></h2>
        <p>
            <bean:message key="curso.nome.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>

