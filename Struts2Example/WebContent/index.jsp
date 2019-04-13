<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body>
    <h1>Struts 2 Hello World Example</h1>

    <s:form action="sayHi">
        <s:textfield name="name" label="Nhập tên" />
        <s:submit value="Click" />
    </s:form>

</body>
</html>