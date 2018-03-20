<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.select > option {
   background: color;
}
</style>

<script >
/* $(document).ready(function() {
    $('#dropdown1').change(function() {
        var selectedValue = $(this).val();
        var servletUrl = 'cities?value=' + selectedValue;

        $.getJSON(servletUrl, function(options) {
            var dropdown2 = $('#dropdown2');
            $('>option', dropdown2).remove(); // Clean old options first.
            if (options) {
                $.each(opts, function(key, value) {
                    dropdown2.append($('<option/>').val(key).text(value));
                });
            } else {
                dropdown2.append($('<option/>').text("Please select dropdown1"));
            }
        });
    });
}); */
var xmlHttp;
function showState(str){
	if(typeof XMLHttpRequest !== "undefined"){
		xmlHttp = new XMLHttpRequest();
		
	}
	else if(window.ActiveXObject){
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xmlHttp === null){
		alert("Browser does not support XMLHttpRequest")
		return;
	}
	var url = "state/";
	url += "?id="+str;
	console.log("Url formed :"+url);
	xmlHttp.onreadystatechange = stateChange;
	xmlHttp.open("GET",url,true);
	xmlHttp.send(null);
}


function stateChange(){
	if(xmlHttp.readyState === 4 || xmlHttp.readyState === "complete"){
		document.getElementById("state").innerHTML = xmlHttpp.responseText;
	}
}


function showCity(str){
	if(typeof XMLHttpRequest !== "undefined"){
		xmlHttp = new XMLHttpRequest();
		
	}
	else if(window.ActiveXObject){
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xmlHttp === null){
		alert("Browser does not support XMLHttpRequest")
		return;
	}
	var url = "city.obj";
	url += "?state_id="+str;
	console.log("Url formed :"+url);
	xmlHttp.onreadystatechange = stateChange1;
	xmlHttp.open("GET",url,true);
	xmlHttp.send(null);
}

function stateChange1(){
	if(xmlHttp.readyState === 4 || xmlHttp.readyState === "complete"){
		document.getElementById("city").innerHTML = xmlHttp.responseText;
	} 
}

</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/dropDown.obj" method="get">

 
<select id="state" name="states" onchange="showCity(this.value)">
    <c:forEach var="state" items="${dropDownList}">
    	<option value="${state.id}">${state.stateName}</option>
    </c:forEach>
    
</select>

<select id="city">
      <c:forEach var="city" items="${cityList}">
    	<option value="${city}">${city}</option>
    </c:forEach>
</select>

<input type="submit" value="Submit" name="action">
</form>

</body>
</html>