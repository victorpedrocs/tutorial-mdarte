<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="estudante"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="estudante"/></h1>
        <p>
            <bean:message key="estudante.online.help"/>
        </p>
        <h2><bean:message key="estudante.matricula"/></h2>
        <p>
            <bean:message key="estudante.matricula.online.help"/>
        </p>
        <h2><bean:message key="estudante.nome"/></h2>
        <p>
            <bean:message key="estudante.nome.online.help"/>
        </p>
        <h2><bean:message key="estudante.curso"/></h2>
        <p>
            <bean:message key="estudante.curso.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>

