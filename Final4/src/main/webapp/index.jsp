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
	xhttp.open("GET", "listele.mlk",true);
	xhttp.send();
	
}
function update(ogrencino,ad,vize,finall,ortalama){
	
}

</script>
</head>
<body onload="getDepoList();">
<form action="ekle.mlk" method="post">
<input type="text" name="ad" placeholder="Ad" required="required">
<input type="number" name="vize" placeholder="Vize" required="required">
<input type="number" name="finall" placeholder="Final" required="required">
<input type="text" name="ortalama" placeholder="Ortalama" required="required">
<input type="submit" name="tip" value="Ekle">

</form >


<div id="kayitlar"></div>

</body>
</html>