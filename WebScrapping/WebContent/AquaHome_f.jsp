<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Aquaponics Home</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

<div id="header">
<h1><p class="text-center">AQUAPONICS FORUM HUB</p></h1>
</div>

<div>
<div id="nav">
Content About Aquaponics<br>
jhgdj<br>hg<br>
Content About Aquaponics<br>
jhgdj<br>hg<br>
Content About Aquaponics<br>
jhgdj<br>hg<br>
Content About Aquaponics<br>
jhgdj<br>hg<br>
Content About Aquaponics<br>
jhgdj<br>hg<br>
Content About Aquaponics<br>
jhgdj<br>hg<br>

</div> 

<center>
 
<div class="m">
 
<form name="register" method="post" action="${pageContext.request.contextPath}/UserText.search">
 <fieldset>
<div class="a"> <div class="l">Categories</div>&nbsp;<div class="r"><select class="btn btn-default btn-lg">
  <option value="Basic">Basic and Useful Info</option>
  <option value="Fish">Fish Topics</option>
  <option value="Plant">Plant Topics</option>
  <option value="Water">Water Topics</option>
<option value="Media">Media Topics</option>
</select></div></div>
 
<div class="a"> <div class="l">Title</div>&nbsp;<div class="r"><input type="text" class="btn btn-default btn-lg" name="LastName" value="Enter Word"></div></div>
 
<div class="a"> <div class="l">&nbsp;</div> <div class="r"><button id="submitbtn" value="Submit" name="subname" type="submit" class="btn btn-primary btn-lg btn-center btn-bottom active">Submit</button></div></div>
 
<div class="a"></div>
</fieldset>
 
</form>
 
</div>
 
</center>

<div id="fishtopics">
<center>
<table>
<tr>
<td id="tr"><b>Fish Topics</b>
</td>
</tr>
<%-- <%@page import = "java.util.*" %>
<%
HashMap<String,String> cats = (HashMap) request.getAttribute("categories");
for(String st:cats.keySet())
{
	out.println("<tr>");
	out.println("<td id='td'>"+st);
	out.println("<br>");
	out.println("Discussion Text Here");
	out.println("<br>hfuyg<a href="+cats.get(st)+">View More</a>");
	out.println("</td>");
	out.println("<tr>");
	
}
%> --%>
<tr>
<td id="td"><a href="fishtopics.html">Fish Topic Title 2</a>
<br>
This isthe brief description of the fish topic2.In the next page you can view the full topic<a href="google.html">View More</a>
</td>
</tr><tr>
<td id="td"><a href="fishtopics.html">Fish Topic Title 3</a>
<br>
Fish Topics
<a href="google.html">View More</a>
</td>
</tr><tr>
<td id="td"><a href="fishtopics.html">Fish Topic Title 4</a>
<br>
This isthe brief description of the fish topic4.In the next page you can view the full topic<br>jhdfughfdiuhfgjfdhu<a href="google.html">View More</a>
</td>
</tr><tr>
<td id="td"><a href="fishtopics.html">Fish Topic Title 5</a>
<br>
This isthe brief description of the fish topic5.In the next page you can view the full topic<a href="google.html">View More</a>
</td>
</tr>
</table><br>
<button type="button" class="btn btn-primary btn-lg btn-center btn-bottom active">Back</button>
</center>
</div>



<div id="discussions">
<center>
<table>
<tr>
<td><div id="tr"><b>Discussions</b></div>
</td>
</tr>

<tr>
<td><div id="td"><b>Fish Topics1</b></div>
<br>
<div id="post">Posted on May2006 by Person</div>
<div id="detdesc">
this is the discussion for the for the fist topic.
hscghdhuf<br>
nughujhbik<br>
hfuyhgjuhujhbjk<br>
hfygjbjhiuhnkjikhbjn<br>
bfgj
njdhbj<br>
jhvufhdb<br>
hgfyusgd<br>
abcdefgh<br>
qwertyui<br>
hgy
<br>
</div>
</td>
</tr>

<tr>
<td>&nbsp;&nbsp;
<a href="https://www.facebook.com"><img src="img/flike.jpg" alt="Facebook" height="34" width="55"/></a>&nbsp;&nbsp;&nbsp;
<a href="https://www.twitter.com"><img src="img/Twitter-icon.png" alt="Twitter" height="55" width="55"/></a>
</td>
</tr>
</table>
</center>

<div id="Replies">
<center>
<table>
<tr>
<td><div id="tr"><b>Replies to this Discussion</b></div>
</td>
</tr>

<tr>

<td><div id="postrep">Replied on May2006 by Person</div>
<div id="rep">
this is the reply for the for the fist topic.
hscghdhuf<br>
nughujhbik<br>
hfuyhgjuhujhbjk<br>
hfygjbjhiuhnkjikhbjn<br>
hscghdhuf<br>
nughujhbik<br>
hfuyhgjuhujhbjk<br>
hfygjbjhiuhnkjikhbjn<br>
<br>
</div>
</td>
</tr>

<tr>
<td>&nbsp;&nbsp;
<a href="https://www.facebook.com"><img src="img/flike.jpg" alt="Facebook" height="34" width="55"/></a>&nbsp;&nbsp;&nbsp;
<a href="https://www.twitter.com"><img src="img/Twitter-icon.png" alt="Twitter" height="55" width="55"/></a>
</td>
</tr>
<br>
</table>
</br></br>
<button type="button" class="btn btn-primary btn-lg btn-center btn-bottom active">Back</button>
</center>
</div>
</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>