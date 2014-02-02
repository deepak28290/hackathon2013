
<!DOCTYPE html>
<%@page import="com.ebay.redis.repository.ItemData"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Business Casual Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="css/business-casual.css" rel="stylesheet">
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
            	<h2 class="intro-text text-center"><strong>My Items</strong> ( ${itemDataList.size()} )</h2>
            <hr>
          </div>
        
        
          <div class="col-lg-12">
				 <table class="table table-bordered">
				 <thead>
				 	<tr>
				 		<th>Item ID</th>
				 		<th>Title</th>
				 		<th>Category</th>
				 		<th>eBay Price</th>
				 		<th>My Price</th>
				 		<th>Profit %</th>
				 		<th>Action</th></tr>
				 </thead>
				 <tbody>


					<c:forEach items="${itemDataList}" var="itemData">
					    <tr>      
					        <td>${itemData.getItem_id()}</td>
					        <td>${itemData.getTitle()}</td>
					        <td>${itemData.getCategory()}</td>
					        <td>${itemData.getEbay_cost()}</td>
					        <td>${itemData.getMy_cost()}</td>
					        <td>${itemData.getProfit()}%</td>     
					 		<td>
						 	<div class="btn-group">
						 	  <a type="button" href="viewitem?itemid=${itemData.getItem_id()}" class="btn btn-default">View</a>
							  <a type="button" href="manageitem?itemid=${itemData.getItem_id()}" class="btn btn-primary">Edit</a>
							  <a type="button" href="#deleteTBD" class="btn btn-danger">Delete</a>
							</div>				 	
						 	</td>
					    </tr>
					</c:forEach>
					  

				 </tbody>
				</table>          

		</div>
          
           
        </div>
      </div>



    </div><!-- /.container -->
    
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
     	       <a href="http://www.ebay.com/" target="_blank">
            	    <img style="margin-left:130px;" src="img/ebay_new.png" class="art">
        	    </a>
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