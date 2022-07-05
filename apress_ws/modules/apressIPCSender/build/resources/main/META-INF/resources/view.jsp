<%@ include file="/init.jsp" %>

<div style="padding: 15px">
	<h3><liferay-ui:message key="apressipcsender.caption"/></h3>
	
	
	<portlet:actionURL name="passMessage" var="passMessageURL" />
	
	<aui:form name="ipcForm" action="${passMessageURL}" method="post">
		<aui:input name="inputMessage" type="text" label=" Pass Message as Parameter"></aui:input>
		<aui:button type="submit"></aui:button>
	</aui:form>
	
	
	<portlet:actionURL name="producerevent" var="producerURL" />
	
	<aui:form name="ipcsessionForm" action="${producerURL}" method="post">
		<aui:input name="sessionmessage" type="text" label=" Pass Message for Event"></aui:input>
		<aui:button type="submit"></aui:button>
	</aui:form>

</div>