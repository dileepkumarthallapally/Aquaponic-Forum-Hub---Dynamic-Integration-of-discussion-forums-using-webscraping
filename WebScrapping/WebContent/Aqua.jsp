<!DOCTYPE html> 
<html>

<head>
  <title>AQUAPONICS</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
<link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
</head>

<body>
  <div id="main">
    
    <header>
	  <div id="strapline">
	    <div id="welcome_slogan">
	      <h3>AQUAPONICS</h3>
	    </div><!--close welcome_slogan-->
      </div><!--close strapline-->	  
	  <nav>
	    <div id="menubar">
          <ul id="nav">
            <li ><a href="index.html">Home</a></li>
            <li class="current"><a href="AquaHome.jsp">Search</a></li>
            <li><a href="testimonials.html">Forums</a></li>
            <li><a href="projects.html">About Us</a></li>
          </ul>
        </div><!--close menubar-->	
      </nav>
    </header>
    
	<div id="site_content">
  
	  <div class="sidebar_container">       
		<div class="sidebar">
          <div class="sidebar_item">
            <div id="Search"><h3><gcse:search></gcse:search></h3></div>      
          </div><!--close sidebar_item--> 
        </div><!--close sidebar-->     		
			
        <div class="sidebar">
          <div class="sidebar_item">
<div id="social">
           <p>
&nbsp;&nbsp;<p><b>Share</b></p>	
<a href="https://plus.google.com/share?url=aquaponicforumhub.html" target="_blank"><img src="http://www.simplesharebuttons.com/images/somacro/google.png" alt="Google" height="45" width="55"/></a>&nbsp;&nbsp;
<a href="http://www.facebook.com/sharer.php?u=aquaponicforumhub.html" target="_blank"><img src="http://www.simplesharebuttons.com/images/somacro/facebook.png" alt="Facebook" height="34" width="45"/></a>&nbsp;&nbsp;
<a href="http://twitter.com/share?url=aquaponicforumhub.html" target="_blank"><img src="images/Twitter-icon.png" alt="Twitter" height="45" width="55"/></a>
<a href="mailto:?Subject=aquaponicforumhub.html"><img src="http://www.simplesharebuttons.com/images/somacro/email.png" alt="Email" height="45" width="55"/></a>
</p></div>
          </div><!--close sidebar_item--> 
        </div><!--close sidebar-->
       </div><!--close sidebar_container-->	

      <div class="slideshow">
	    <ul class="slideshow">
          <li class="show"><img width="680" height="250" src="images/fish2.jpg"/></li>
          <li><img width="680" height="250" src="images/fish.jpg"/></li>
<li><img width="680" height="250" src="images/fish3.jpg"/></li>
        </ul> 
	  </div>
	  <div id="content">
        <div class="content_item">
<div id="fishtopics">
<center>
<table border="1">
<tr>
<%
out.println("<td id='tr'><h2>"+request.getAttribute("Catname")+"</h2></b>");
%>

</td>
</tr>
<%@page import = "java.util.*" %>
<%
final class ResultSet
{
	String DisTitle,DisTitleURL,ReplyTitle,ReplyURL,DisText;

	/**
	 * @return the disTitle
	 */
	public String getDisTitle() {
		return DisTitle;
	}

	/**
	 * @param disTitle the disTitle to set
	 */
	public void setDisTitle(String disTitle) {
		DisTitle = disTitle;
	}

	/**
	 * @return the disTitleURL
	 */
	public String getDisTitleURL() {
		return DisTitleURL;
	}

	/**
	 * @param disTitleURL the disTitleURL to set
	 */
	public void setDisTitleURL(String disTitleURL) {
		DisTitleURL = disTitleURL;
	}

	/**
	 * @return the replyTitle
	 */
	public String getReplyTitle() {
		return ReplyTitle;
	}

	/**
	 * @param replyTitle the replyTitle to set
	 */
	public void setReplyTitle(String replyTitle) {
		ReplyTitle = replyTitle;
	}

	/**
	 * @return the replyURL
	 */
	public String getReplyURL() {
		return ReplyURL;
	}

	/**
	 * @param replyURL the replyURL to set
	 */
	public void setReplyURL(String replyURL) {
		ReplyURL = replyURL;
	}

	/**
	 * @return the disText
	 */
	public String getDisText() {
		return DisText;
	}

	/**
	 * @param disText the disText to set
	 */
	public void setDisText(String disText) {
		DisText = disText;
	}
}
	
 HashMap<String, String> Cats = (HashMap) request.getAttribute("categories");
 HashMap<String, String> DiscussionTexts=(HashMap)request.getAttribute("DiscussionTexts");
 HashMap<String, String> Replies=(HashMap)request.getAttribute("Replies");
 HashMap<String, String> RepliesURL = (HashMap)request.getAttribute("RepliesURL");
 ArrayList<ResultSet> results = new ArrayList<ResultSet>();
 if(!Cats.isEmpty())
 {
	 String st1 ="";
for (String it : Cats.keySet()) {
    		ResultSet st = new ResultSet();
    		st.setDisTitle(it);
    		st.setDisTitleURL(Cats.get(it));
    		st.setDisText(DiscussionTexts.get(it));
    		
    		st1 ="";
    		st1 = Replies.get(it);
    		if(st1==null){
    		st.setReplyTitle("Reply by Mark Twain");
    		}else{
    			st.setReplyTitle(st1);
    		}
    		st.setReplyURL(RepliesURL.get(it));
    		results.add(st);
		}
 }
	 
//ArrayList<ResultSet> results =  (ArrayList) request.getAttribute("resultset");
if(!results.isEmpty()){
for(int i =0;i < results.size();i++)
{
	
	out.println("<tr>");
	out.println("<td id='td'><h9><u>"+results.get(i).getDisTitle()+"</u></h9>");
	out.println("<br>");
	out.println(results.get(i).getDisText());
	out.println("<a href="+results.get(i).getDisTitleURL()+">View More</a>");
	out.println("<br> Recent Activity: ");
	out.println("<a href="+results.get(i).getReplyURL()+">"+results.get(i).getReplyTitle()+"</a>");
	out.println("</td>");
	out.println("</tr>");
}
}
else
{
	out.println("<tr>");
out.println("<td id='td'>");
out.println("<h3>Sorry!!!!! No Search results Found</h3>");
out.println("</td>");
out.println("</tr>");
	}
%>

</table><br>
<button type="button" class="btn btn-primary btn-lg btn-center btn-bottom active">Back</button>
</center>
</div>


	    </div><!--close content_item-->
      </div><!--close content-->   
	</div><!--close site_content-->  	
    <footer>
 <a href="index.html">Home</a> | <a href="AquaHome.jsp">Search</a> | <a href="about.html">About</a> | <a href="projects.html">Contact Us</a> <br/><br/>
   </footer>
    
    <!-- <footer>
	  <a href="index.html">Home</a> | <a href="ourwork.html">Our Work</a> | <a href="testimonials.html">Testimonials</a> | <a href="projects.html">Projects</a> | <a href="contact.html">Contact</a><br/><br/>
	  <a href="http://fotogrph.com">Images</a> |  <a href="http://www.heartinternet.co.uk/web-hosting/">Web Hosting</a>  | website template by <a href="http://www.freehtml5templates.co.uk">Free HTML5 Templates</a>
    </footer>   -->
  </div><!--close main-->
  
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/image_slide.js"></script>
   <script>
(function() {
  var cx = '017643444788069204610:4gvhea_mvga'; // Insert your own Custom Search engine ID here
  var gcse = document.createElement('script'); gcse.type = 'text/javascript'; gcse.async = true;
  gcse.src = (document.location.protocol == 'https' ? 'https:' : 'http:') +
      '//www.google.com/cse/cse.js?cx=' + cx;
  var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(gcse, s);
})();
</script>
</body>
</html>
