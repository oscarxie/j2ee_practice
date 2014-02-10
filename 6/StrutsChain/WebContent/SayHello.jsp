<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>Say Hello</title>
    </head>
    <body>
            <s:form action="action">
            Msg: <s:textfield name="msg" />
            <s:submit />
        </s:form>
    </body>
</html>