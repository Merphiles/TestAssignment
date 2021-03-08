<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>Lookup Example</title>
    </head>
    <body>
		<jsp:include page="Template.html" />

		<table>
		    <tr>
				<td> City Name: </td>
				<td> ${entry.cityName} </td>
			</tr>
			<tr>
				<td> City Temperature: </td>
				<td> ${entry.temperature} </td>
			</tr>
			<tr>
				<td> Time Zone: </td>
				<td> ${entry.timeZone} </td>
			</tr>
		</table>
	</body>
</html>
