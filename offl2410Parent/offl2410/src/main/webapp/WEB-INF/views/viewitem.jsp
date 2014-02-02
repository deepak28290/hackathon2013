
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav>


    <div class="container">

      <div class="row">
        <div class="box">
          <div class="col-lg-12">
            <hr>
            <h2 class="intro-text text-center"><strong>${itemData.getTitle()}</strong></h2>
            <hr>
          </div>
          <div class="col-md-6">



			<div id="carousel-example-generic" class="carousel slide">
			  <!-- Indicators -->
			  <ol class="carousel-indicators">
			    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
			    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
			    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
			  </ol>

			  <!-- Wrapper for slides -->
			  <div class="carousel-inner">
			    <div class="item active">
			      <img style="height : 300px" class="img-responsive " src="${itemData.getImg_url()}" >
			      <div class="carousel-caption">
			        Slide 1
			      </div>
			    </div>
			    <div class="item">
			      <img style="height : 300px" class="img-responsive " src="${itemData.getImg_url1()}" > 
			      <div class="carousel-caption">
			        Slide 1
			      </div>
			    </div>
			    <div class="item">
			      <img style="height : 300px" class="img-responsive " src="${itemData.getImg_url2()}" >
			      <div class="carousel-caption">
			        Slide 1
			      </div>
			    </div>
			
			  </div>

			  <!-- Controls -->
			  <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
			    <span class="icon-prev"></span>
			  </a>
			  <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
			    <span class="icon-next"></span>
			  </a>
			</div>



          </div>
          
          
          <div class="col-md-6">
          	<p> Nominal Price : Just <strong class="text-success">Rs ${itemData.getMy_cost()}</strong> Only.</p>
          	<p> Delivery within one week </p>
            <p><a href="printinvoice?itemid=${itemData.getItem_id()}" target="_blank"  class="btn btn-lg btn-primary">Print Invoice</a></p>
          </div>
          <div class="clearfix"></div>
        </div>
      </div>

      <div class="row">
        <div class="box">
          <div class="col-lg-12">
            <hr>
            <h2 class="intro-text text-center">  <strong>Similar Items </strong></h2>
            <hr> 
          </div>
          
          <div class="row">
			 
			<c:forEach items="${relatedItemDataList}" var="itemData">
			
			  <div class="col-sm-6 col-md-3">
			    <div class="thumbnail">
			      <img class="img-responsive" src="${itemData.getImg_url()}">
			      <div class="caption">
			        <h3>${itemData.getTitle()}</h3>
			        <p><a href="viewitem?itemid=${itemData.getItem_id()}" class="btn btn-primary">View Item</a></p>
			      </div>
			    </div>
			  </div>
			  
			</c:forEach>
			  
  	
		 </div>
          
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
		interval: 2500
	  })
	</script>
  </body>
</html>