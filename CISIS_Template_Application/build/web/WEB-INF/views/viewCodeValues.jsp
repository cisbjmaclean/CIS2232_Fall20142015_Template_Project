<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring:nestedPath path="menu">
    <form action="" method="post">
        <table>
            <tr>
                <td>Here are the code values for that code type.
                </td>
            </tr>
            <tr>
                <td>
                    ${message}

                </td>
            </tr>
            <c:forEach var="thisCode" items="${theCollection}"
                       varStatus="loopCounter">
                <tr>
                    <td><c:out value="${loopCounter.count}" /></td>
                    <td><c:out value="${thisCode.description}" /></td>

                </tr>

                <tr>
                    <td><form:input path="action" value=""/></td>
                    <td><form:label path="action" >${menu.action}</form:label> </td>

                    </tr>

            </c:forEach>

            <tr>
                <td>
                    <form:select path="action">
                        <form:option value="-" label="--Please Select"/>
                        <form:options items="${theCollection}" />
                    </form:select>
                </td>
            </tr>


            <tr><td><form:errors path="action"/></td></tr>

        </table>
    </form>
</spring:nestedPath>
