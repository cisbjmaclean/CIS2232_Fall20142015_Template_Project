<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<spring:nestedPath path="thisCode">
    <form action="editCodeValue" method="post">
            <h2><fmt:message key="label.edit.code.value"/>&nbsp;${thisCode.codeTypeId}
            </h2>
            <table>
                <tr>
                    <td><fmt:message key="label.description"/></td>
                    <td><form:input path="description" value="${thisCode.description}"/>
                    </td>

                </tr>          
                <tr>
                    <td><fmt:message key="label.description.short"/></td>
                    <td><form:input path="description" value="${thisCode.descriptionShort}"/>
                    </td>

                </tr>          


                <tr>
                    <td colspan="2">
                        <input type="submit" value="Update"/>
                    </td>
                </tr>
            </table>
        </body>
    </form>
</spring:nestedPath>
