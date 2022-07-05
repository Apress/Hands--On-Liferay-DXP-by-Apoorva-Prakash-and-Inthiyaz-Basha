<%@ include file="/init.jsp" %>
<div style="padding: 15px; color:green"><h1>Landing Page of Apress MVC Portlet</h1></div>

<div style="padding: 15px">
	<h1><div style="color:blue"> Portlet Mode example Section </div></h1>

	<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
	
	<portlet:renderURL var="normalWindowURL" windowState="<%=LiferayWindowState.NORMAL.toString()%>"/>
	<portlet:renderURL var="maximizedWindowURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>"/>
	<portlet:renderURL var="minimizedWindowURL" windowState="<%=LiferayWindowState.MINIMIZED.toString()%>"/>
	<portlet:renderURL var="popupWindowURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>"/>
	<portlet:renderURL var="exclusiveWindowURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>"/>
	<table>
	  <tr>
	    <th>Normal Window</th>
	    <th>Maximized Window</th>
	    <th>Minimized Window</th>
	    <th>Pop Up Window</th>
	    <th>Exclusive View Window</th>
	  </tr>
	  <tr>
	    <td><a href="<%=normalWindowURL.toString() %>">normalWindowURL now</a></td>
	    <td><a href="<%=maximizedWindowURL.toString() %>">maximizedWindowURL now</a></td>
	    <td><a href="<%=minimizedWindowURL.toString() %>">minimizedWindowURL now</a></td>
	    <td><a href="<%=popupWindowURL.toString() %>">popupWindowURL now</a></td>
	    <td><a href="<%=exclusiveWindowURL.toString() %>">exclusiveWindowURL now</a></td>
	  </tr>
	</table>
</div>

<div style="padding: 15px">
	<h1><div style="color:blue"> MVC Command's Section </div></h1>
	<portlet:renderURL var="renderCommandURL">
		<portlet:param name="mvcRenderCommandName" value="/apressmvcrendercommand" />
	</portlet:renderURL>
	<table>
	  <tr>
	    <th>MVC Render Command</th>
	    <th>MVC Action Command</th>
	    <th>MVC Resource Command</th>
	  </tr>
	  <tr>
	    <td><h3><a href="<%= renderCommandURL %>">Go to Render Commad Page</a></h3></td>
	    <td>
	    	<h3><a href="<portlet:actionURL name="/apressmvcactioncommand" />">
	    	<div style="color:green"> Go to Action Commad Class</div></a>
	    	</h3>
	    </td>
	    <td>
	    	<h3><a href="<portlet:resourceURL id="/apressmvcresourcecommand" />">
	    	<div style="color:red"> Resource Command URL to Download File </div></a>
	    	</h3>
	    </td>
	  </tr>
	</table>
</div>

<div style="padding: 15px">
	<h1><div style="color:blue"> Portlet URL's Section </div></h1>
	<portlet:renderURL var="renderURL">
		<portlet:param name="mvcPath" value="/renderexample.jsp" />
	</portlet:renderURL>
	<portlet:actionURL name="firstAction" var="actionURL" />
	<table>
	  <tr>
	    <th>Render URL</th>
	    <th>Action URL</th>
	    <th>Resource URL</th>
	  </tr>
	  <tr>
	    <td><h4><a href="<%= renderURL %>">Go to Render Page</a></h4></td>
	    <td>
	    	<h4><a href="<%= actionURL %>"><div style="color:green">Test your First Action</div></a></h4>
	    	<h4><a href="<portlet:actionURL name="secondAction" />">Test your Second Action</a></h4>
	    	<h4><a href="<portlet:actionURL><portlet:param name="javax.portlet.action" value="nameForMoreActionsMethod" />
	    		</portlet:actionURL>">
				<div style="color:red">Do Something More Actions</div></a>
			</h4>
	    </td>
	    <td><h4><a href="<portlet:resourceURL id="resourceURL" />"><div style="color:green"> Resource URL</div></a></h4></td>
	  </tr>
	</table>
</div>	

<style>
	table{
	  border: 2px solid green;
	  border-collapse: collapse;
	}
	th, td {
	  border: 2px dotted blue;
	  border-collapse: collapse;
	  padding: 10px;
	}
</style>