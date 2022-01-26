<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function getDepoList(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	       // Typical action to be performed when the document is ready:
	       document.getElementById("kayitlar").innerHTML = xhttp.responseText;
	    }
	};
	xhttp.open("GET", "listele.mlk", true);
	xhttp.send();
	
}
function update(id,ad,adet,fiyat){
	document.getElementById('did').value=id;
	document.getElementById('dad').value=ad;
	document.getElementById('dadet').value=adet;
	document.getElementById('dfiyat').value=fiyat;
}

</script>
</head>
<body onload="getDepoList();">
<form action="guncelle.mlk" method="post">
<input id="did" type="number" name="id" placeholder="Id" required="required" >
<input id="dad" type="text" name="ad" placeholder="Ad" required="required">
<input id="dadet" type="number" name="adet" placeholder="Adet" required="required">
<input id="dfiyat" type="text" name="fiyat" placeholder="Fiyat" required="required">
<input type="submit" value="Guncelle">
</form>

<div id="kayitlar"></div>


</body>
</html>
