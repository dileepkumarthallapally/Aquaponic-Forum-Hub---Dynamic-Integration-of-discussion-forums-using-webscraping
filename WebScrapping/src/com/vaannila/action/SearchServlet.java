package com.vaannila.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


class ResultSet
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

@WebServlet("/searchservlet")
public class SearchServlet extends HttpServlet {

	static HashMap<String,String> Cats_Map_Aquaponic = new HashMap<String,String>();
	static HashMap<String,String> Cats_Map_Nation = new HashMap<String,String>();
	static HashMap<String,String> Cats_Map_Backyard = new HashMap<String,String>();
	
	
	
    private HashMap<String, String> Cats=new HashMap<String, String>(),Cats1,Cats2;
    private HashMap<String, String> DiscussionTexts=new HashMap<String, String>(),DiscussionTexts1,DiscussionTexts2;
    ArrayList<ResultSet> results = new ArrayList<ResultSet>();
    private HashMap<String, String> Replies=new HashMap<String, String>(),RepliesURL=new HashMap<String, String>(),Replies1,RepliesURL1,Replies2,RepliesURL2;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrepareMap();
        Scapper_theaquaponicsource scrap = new Scapper_theaquaponicsource();
    	main aquaponicNation = new main();
    	main2 backyardAquaponics = new main2();
    	String Categoryname=request.getParameter("Catname1");
    	String Search_Text=request.getParameter("LastName");
        if (request.getParameter("subname") != null) {
        	scrap.loadCategories_theaquaponicsource();
        	aquaponicNation.loadCategories_theaquaponicnation();
        	backyardAquaponics.loadCategories_backyardaquaponics();
        	System.out.println(Search_Text +" "+Categoryname);
    	
        Cats = scrap.FindDiscussions(Cats_Map_Aquaponic.get(Categoryname),Search_Text);
    	DiscussionTexts=scrap.getDiscussionTexts_theaquaponicsource();
    	RepliesURL=scrap.getReplliesURL_search();
    	Replies=scrap.getReplies_theaquaponicsource();
    	System.out.println("Backyard");
    	
    	Cats1=aquaponicNation.FindDiscussions(Cats_Map_Nation.get(Categoryname), Search_Text);
    	System.out.println("Done");
    	DiscussionTexts1=aquaponicNation.getSearched_Discussionby_theaquaponicnation();
    	Replies1=aquaponicNation.getRepllies_search();
    	
    	/*System.out.println(Search_Text +" "+Categoryname);
    	Cats2=backyardAquaponics.FindDiscussions(Cats_Map_Backyard.get(Categoryname), Search_Text);
    	DiscussionTexts2=backyardAquaponics.getSearched_Discussionby_theaquaponicnation();
    	Replies2=backyardAquaponics.getRepllies_search();
   	*/
    	Cats.putAll(Cats1);
    	//Cats.putAll(Cats2);
    	DiscussionTexts.putAll(DiscussionTexts1);
    	//DiscussionTexts.putAll(DiscussionTexts2);
    	Replies.putAll(Replies1);	
    	//Replies.putAll(Replies2);
    	
    	/*for (String it : Cats.keySet()) {
    		ResultSet st = new ResultSet();
    		st.setDisTitle(it);
    		st.setDisTitleURL(Cats.get(it));
    		st.setDisText(DiscussionTexts.get(it));
    		st.setReplyTitle(Replies.get(it));
    		st.setReplyURL(RepliesURL.get(it));
    		results.add(st);
    		}*/
        request.setAttribute("categories",Cats);
        request.setAttribute("DiscussionTexts",DiscussionTexts);
        request.setAttribute("RepliesURL",RepliesURL);
        request.setAttribute("Replies",Replies);
        request.setAttribute("resultset",results);
        request.setAttribute("Catname",Categoryname);
        }         request.getRequestDispatcher("Aqua.jsp").forward(request, response);
    }

	private void PrepareMap() {
		// TODO Auto-generated method stub
		String a[] = {"Fish","Plant","Commercial","Equipment","Uncategorized","General"};
		Cats_Map_Aquaponic.put(a[0],"Fish Topics");
		Cats_Map_Aquaponic.put(a[1],"Plant Topics");
		Cats_Map_Aquaponic.put(a[2],"Commercial Systems and Employment");
		Cats_Map_Aquaponic.put(a[3],"Media Topics");
		Cats_Map_Aquaponic.put(a[4],"Uncategorized");
		Cats_Map_Aquaponic.put(a[5],"Aquaponic Discussions");
		
		Cats_Map_Nation.put(a[0],"FISH AND CRUSTACEANS");
		Cats_Map_Nation.put(a[1],"EDIBLE PLANTS");
		Cats_Map_Nation.put(a[2],"COMMERCIAL SYSTEMS");
		Cats_Map_Nation.put(a[3],"EQUIPMENT");
		Cats_Map_Nation.put(a[4],"USEFUL INFORMATION");
		Cats_Map_Nation.put(a[5],"GENERAL AQUAPONICS DISCUSSION");
		
		Cats_Map_Backyard.put(a[0],"Fish");
		Cats_Map_Backyard.put(a[1],"Plants");
		Cats_Map_Backyard.put(a[2],"Commercial Systems");
		Cats_Map_Backyard.put(a[3],"Hardware");
		Cats_Map_Backyard.put(a[4],"General Banter");
		Cats_Map_Backyard.put(a[5],"General System Discussions");
		
	}

}