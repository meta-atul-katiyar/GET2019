<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Spring MVC File Upload</title>
    </head>
    <body>
        <h2>Submitted Files</h2>
        <table> 
                <tr>
                    <td>OriginalFileName:</td>
                    <td>${file.originalFilename}</td>
                </tr>
                <tr>
                    <td>Type:</td>
                    <td>${file.contentType}</td>
                </tr>
        </table>
    </body>
</html>