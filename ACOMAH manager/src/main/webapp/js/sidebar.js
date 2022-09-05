var pin = false;

function pin_sidebar() {
	pin = !pin;
	if (pin) {
		document.querySelector("#pin").style.transform = "rotate(35deg)";
	} else {
		document.querySelector("#pin").style.transform = "rotate(0deg)";
	}
	
}

function w3_open() {
  document.getElementById("main").style.marginLeft = "15%";
  document.getElementById("topHeader").style.width = "85%";
  document.getElementById("sidebar").style.width = "15%";
  document.getElementById("sidebar").style.display = "block";
  document.getElementById("openNav").style.display = 'none';
}

function w3_close() {
	if (pin == false) {
		document.getElementById("main").style.marginLeft = "0%";
		document.getElementById("topHeader").style.width = "100%";
		document.getElementById("sidebar").style.display = "none";
		document.getElementById("openNav").style.display = "inline-block";
	}
}

function accordFunc(num) {
  var x = document.getElementById("menuAccord" + num);
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
    x.previousElementSibling.className += " w3-green";
  } else { 
    x.className = x.className.replace(" w3-show", "");
    x.previousElementSibling.className = 
    x.previousElementSibling.className.replace(" w3-green", "");
  }
}

