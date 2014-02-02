<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="main" />
	<title>Offline eCommerce</title>
	<res:cssSlot id="head-css" />
	<script>
	var ajaxResponse;
	var obj;
	function handleClick()
    {
		//js method to get ItemID from form 
		if(document.getElementById('item_id').value){
      
      var xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function() {
          if (xhr.readyState == 4) {
              ajaxResponse=xhr.responseText;
              insertResults(ajaxResponse);
          }
      }
      xhr.open('GET', 'http://localhost:8080/offl2410/firesults?itemid='+ document.getElementById('item_id').value+'&category=MOBILE' , true);
     // xhr.open('GET', 'http://localhost:8080/offl2410/firesults?itemid=asd' , true);
      xhr.send(null);
		}else{
			alert("Please Input Item ID");
		}
		
    }
	
	function insertResults(response){
		console.log(response.replace);
		if(response=="\"empty\""){
			alert("Item id not found");
		}else{
		//var obj = eval('(' + response + ')');
		obj=JSON.parse(JSON.parse(response));
		//console.log(typeof(JSON.parse(obj)));
		console.log(obj["item_url"]);
		document.getElementById("item1").innerHTML=obj["item_title"];
		document.getElementById("item1").href=obj["item_url"];
		document.getElementById("img1").src=obj["img_url"].split('---');
		document.getElementById("cost1").innerHTML="eBay COST       : Rs. ".concat(obj["cost"]);
		document.getElementById("location1").innerHTML="ITEM LOCATION  : ".concat(obj["location"]);
		document.getElementById("fi_results").style.visibility="visible";
		}
	}
	
	
	function sendToSellPage(){
		var e = document.getElementById("ddValue");
		var ddVal = e.options[e.selectedIndex].value;
		if(document.getElementById('my_item_cost').value){
		var xhr = new XMLHttpRequest();
	      xhr.onreadystatechange = function() {
	          if (xhr.readyState == 4) {
	              ajaxResponse=xhr.responseText;
	              alert(ajaxResponse);
	              window.location.replace("http://localhost:8080/offl2410/myitems");
	          }
	      }
	      xhr.open('GET', 'http://localhost:8080/offl2410/sell?itemid='+ obj["item_id"]+'&myCost='+document.getElementById('my_item_cost').value+'&category='+ddVal , true);
	     // xhr.open('GET', 'http://localhost:8080/offl2410/firesults?itemid=asd' , true);
	      xhr.send(null);
		}else{
			alert("plz provide your item cost details");
		}
		
	}
  </script>
	</script>
</head>
<body class="bg-wrapper" > <!-- style="background-color:Powderblue" -->
<!-- keep a common header-->
<h1>
Manage Items Page
</h2>	<br/><br/>
<div>
<form>
Item ID: <input type="text" name="itemid" id="item_id">&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit" onclick="handleClick();return false"><br>
</form>

</div>
<br/><br/><br/><br/><br/>
<div id="fi_results" style="visibility: hidden">
<div>
<a href="ebay.in" id="item1">ITEM NAME</a><br>
<img style="width: 400px;height: 400px;" src="" id="img1"/><br>
<div><span id="cost1" style="display:inline;float:left"></span></div><br>
<div id="location1"></div><br>
<form>
<span>My Cost: <input type="text" name="myCost" id="my_item_cost"></span><br/>
<span> Choose Category:  &nbsp;
<select id="ddValue">
  <option value="MOBILE">Mobile</option>
  <option value="ACCESSORIE">Accessories</option>
  <option value="APPLIANCES">Home Appliances</option>
</select>
</span><br/>
<input type="submit" value="Save Item" onclick="sendToSellPage();return false"><br/>
</form>
</div>

</div>
</body>
</html>