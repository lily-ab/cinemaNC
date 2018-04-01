<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>MovieMovie</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Movie List</h1>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Genre</th>
            <th>Starts</th>
            <th>Ends</th>
        </tr>
        <c: forEach  items="${movies}" var ="person">
            <tr>
                <td>${movies.name}</td>
                <td>${movies.genre}</td>
                <td>${movies.dateOfStart}</td>
                <td>${movies.dateOfFinish}</td>
            </tr>
        </c:forEach >
    </table>
</div>
</body>

</html>