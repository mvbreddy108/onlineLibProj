function show(str) {
	window.alert("entered");
  var xhttp; 
  var x=document.getElementById("dep").value;
  if (str == "0"&&x=="0") {
   window.alert("please fill the details");
    return;
  }
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
	  window.alert("please wait");
    if (this.readyState == 4 && this.status == 200) {
    document.getElementById("sub").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "subject?dep="+x+"&sem="+str, true);
  xhttp.send();
}
function download(str) {
	  var xhttp1; 
	  var x=str;
  window.alert(str);
  xhttp1 = new XMLHttpRequest();
  xhttp1.onreadystatechange = function() {
	  window.alert("entetred");
    if (this.readyState == 4 && this.status == 200) {
    	window.alert("file is getting downloaded");
    	alert(xhttp1.responseText);
    }
  };
  xhttp1.open("GET", "downlod?loc="+str, true);
  xhttp1.send();
}
