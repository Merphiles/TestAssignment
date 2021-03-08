<!DOCTYPE html>
<html>
	<head>
        <meta charset="utf-8"/>
		<title>Example</title>
		<link rel="stylesheet" href="addrbook.css">
	</head>
	<body>
		<%@ page import="databeans.Entry" %>
		<% Entry[] list = (Entry[]) request.getAttribute("list"); %>

		<jsp:include page="Template.html" />
		
		<table>
<%
      for (int i=0; i<list.length; i++) {
          Entry e = list[i];
%>
			<tr>
				<td>
					<a href="idsearch?id=<%=e.getId()%>">
						<%=e.getCityName()%>, <%=e.getTemperature()%>
					</a>
				</td>
			</tr>
<%
      }
%>
		</table>
	</body>
</html>
