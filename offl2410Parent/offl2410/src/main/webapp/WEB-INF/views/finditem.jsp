
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>About - Business Casual Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="css/business-casual.css" rel="stylesheet">
    
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
      xhr.open('GET', 'http://localhost:8080/offl2410/firesults?itemid='+ document.getElementById('item_id').value , true);
     // xhr.open('GET', 'http://localhost:8080/offl2410/firesults?itemid=asd' , true);
      xhr.send(null);
		}else{
			alert("Please Input Item ID");
		}
		
    }
	
	function insertResults(response){
		//var obj = eval('(' + response + ')');
		obj=JSON.parse(JSON.parse(response));
		//console.log(typeof(JSON.parse(obj)));
		console.log(obj["item_url"]);
		document.getElementById("item1").innerHTML=obj["item_title"];
		document.getElementById("item1").href=obj["item_url"];
		document.getElementById("img1").src=obj["img_url"];
		document.getElementById("cost1").innerHTML="eBay COST       : Rs. ".concat(obj["cost"]);
		//document.getElementById("location1").innerHTML="ITEM LOCATION  : ".concat(obj["location"]);
		document.getElementById("fi_results").style.visibility="visible";
	}
	
	
	function sendToSellPage(){
		if(document.getElementById('my_item_cost').value){
		var xhr = new XMLHttpRequest();
	      xhr.onreadystatechange = function() {
	          if (xhr.readyState == 4) {
	              ajaxResponse=xhr.responseText;
	              insertResults(ajaxResponse);
	          }
	      }
	      xhr.open('GET', 'http://localhost:8080/offl2410/sell?itemid='+ obj["item_id"]+'myCost='+document.getElementById('my_item_cost').value , true);
	     // xhr.open('GET', 'http://localhost:8080/offl2410/firesults?itemid=asd' , true);
	      xhr.send(null);
		}else{
			alert("plz provide your item cost details");
		}
		
	}
  </script>
    
    
    
  </head>

  <body>
  
    <div class="brand">Business Casual</div>
    <div class="address-bar">The Plaza | 5483 Start Bootstrap Ave. | Beverly Hills, California 26892 | 555.519.2013</div>

    <nav class="navbar navbar-default" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.html">Business Casual</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav">
            <li><a href="deals">Deals</a></li>
            <li><a href="manageitem">Manage Item</a></li>
            <li><a href="myitems">My Items</a></li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav>


    <div class="container">

      <div class="row">
        <div class="box">
          <div class="col-lg-12">

            <hr>
            <h2 class="intro-text text-center"> <strong>Manage Items Page</strong>
 			</h2>
            <h2 class="intro-text text-center"> 
            <form>
				   <input type="text" name="itemid" id="item_id">&nbsp;&nbsp;&nbsp;&nbsp;<input class="btn btn-primary" type="submit" value="Find Item" onclick="handleClick();return false"><br>
			</form>
			</h2>
			<hr>
          </div>
          
          <div id="fi_results" style="visibility: hidden">
          
 
          <div class="col-md-6">

			<div>
			<a href="ebay.in" id="item1">ITEM NAME</a><br>
			<img class="img-responsive img-thumbnail" src="" id="img1"/><br>
			</div>



          </div>
          
          
          <div class="col-md-6">

			<div>
				<div><span id="cost1" style="display:inline;float:left"></span></div><br>
				
			<div id="location1"></div><br>
				<form>
				<span>My Cost: <input type="text" name="myCost" id="my_item_cost"></span>
				<input class="btn btn-primary" type="submit" value="Save Item" onclick="sendToSellPage();return false"><br/>
				</form>
			</div>


          </div>
          
          </div>
          
          <div class="clearfix"></div>
        </div>
      </div>



    </div><!-- /.container -->
    
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <p>Copyright &copy; Company 2013</p>
          </div>
        </div>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- Make sure to add jQuery - download the most recent version at http://jquery.com/ -->
        <script src="js/jquery-2.0.3.js"></script>
    <script src="js/bootstrap.js"></script>
    <script>
	  // Activates the Carousel
	  $('.carousel').carousel({
		interval: 5000
	  })
	</script>
  </body>
</html>