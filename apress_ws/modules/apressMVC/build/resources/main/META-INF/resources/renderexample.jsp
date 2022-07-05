<%@ include file="/init.jsp" %>

<portlet:renderURL var="landingURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>
<div style="padding: 15px">
	<div style="color:green"><h1>Rendering Page of Apress MVC Portlet</h1></div>
	<p>
		<a href="<%= landingURL %>"><h3>Go to Landing Page</h3></a>
	</p>
</div>

	