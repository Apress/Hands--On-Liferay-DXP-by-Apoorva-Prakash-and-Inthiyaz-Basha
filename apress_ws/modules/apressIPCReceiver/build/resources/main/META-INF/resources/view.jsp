<%@ include file="/init.jsp" %>

	<h5><liferay-ui:message key="apressipcreceiver.caption"/></h5>
	
	<h2>Received Message from Public Render Parameter :<div style="color:blue">  ${recievedMessage}</div></h2>

	<h2>Received Message from Session Parameter :<div style="color:red">  ${recievedSessionMessage}</div></h2>
	
	<h2>Received Message from Event Parameter : <div style="color:green"> ${message} </div></h2>