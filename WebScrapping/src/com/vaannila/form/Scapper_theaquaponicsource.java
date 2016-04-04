package com.vaannila.form;

import org.apache.struts.action.ActionForm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scapper_theaquaponicsource extends ActionForm {

	private static final long serialVersionUID = -473562596852452021L;
	
	private String message;
	private static Document doc_discussion_text;
	  static Document doc;
	  static String appendURL ;
	static Document new_doc;
	static HashMap<String, String>Cats = new HashMap<String, String>();
		static HashMap<String, String> Categories_theaquaponicsource = new HashMap<String, String>();
		static HashMap<String, String> Discussions_theaquaponicsource = new HashMap<String, String>();
		static HashMap<String, String> Replies_theaquaponicsource = new HashMap<String, String>();
		public static void main(String[] args) throws IOException {
			loadCategories_theaquaponicsource();
			FindDiscussions("Category name","Search text");
		}

		private static void loadCategories_theaquaponicsource() throws IOException {
			// TODO Auto-generated method stub
			doc = Jsoup.connect("http://community.theaquaponicsource.com/forum?page=1").get();
			Elements eles = doc.select("table.categories");
			for (Element ele2 : eles.select("a")) {
				if(!ele2.select("a[href^=http://community.theaquaponicsource.com/forum/categories]").attr("href").toString().isEmpty())
				Categories_theaquaponicsource.put(ele2.select("a[href^=http://community.theaquaponicsource.com/forum/categories]").text(), ele2.select("a[href^=http://community.theaquaponicsource.com/forum/categories]").attr("href").toString());
				}
			doc = Jsoup.connect("http://community.theaquaponicsource.com/forum?page=2").get();
			eles = doc.select("table.categories");
			for (Element ele2 : eles.select("a")) {
				if(!ele2.select("a[href^=http://community.theaquaponicsource.com/forum/categories]").attr("href").toString().isEmpty())
				Categories_theaquaponicsource.put(ele2.select("a[href^=http://community.theaquaponicsource.com/forum/categories]").text(), ele2.select("a[href^=http://community.theaquaponicsource.com/forum/categories]").attr("href").toString());
				}
			
		}

		private static HashMap<String, String> FindDiscussions(String Category, String Search_text) {
			// TODO Auto-generated method stub
			for (String string2 : Categories_theaquaponicsource.keySet()) {
				System.out.println(string2 +" : "+ Categories_theaquaponicsource.get(string2));
			}
			String urls= Categories_theaquaponicsource.get("Uncategorized");
			try {
				new_doc=Jsoup.connect(urls).get();
				Elements No_of_pages = new_doc.select("ul.pagination").select("a[href^="+urls);
				ArrayList<String> page_nos =new ArrayList<String>();
				for (Element element : No_of_pages) {
					page_nos.add(element.text());
					String url = element.attr("href");
					System.out.println(url);
					String mydata = url;
					Pattern pattern = Pattern.compile("(.*)(page=)[0-9]");
					Matcher matcher = pattern.matcher(mydata);
					
					if (matcher.find())
					{
					    appendURL = matcher.group(1)+"page=";
					}
				}
				
				int size = Integer.parseInt(page_nos.get(page_nos.size()-2));
				System.out.println(size);
			for(int i=0;i<size;i++)
			{
				
				
				Elements category_element = new_doc.select("table.categories");
				
				for (Element ele3 : category_element.select("a")) {
					String url=ele3.select("a[href^=http://community.theaquaponicsource.com/forum/topics]").attr("href");
					
					if(url.isEmpty())
						continue;
					Elements e = new_doc.getElementsByClass("small");
					for (Element element : e) {
						if(!e.text().contains("Started"))
						{
							System.out.println(e.text());
						}
						
					}
					String discussion_title =ele3.select("a[href^=http://community.theaquaponicsource.com/forum/topics]").text();
					String Disc_link = ele3.select("a[href^=http://community.theaquaponicsource.com/forum/topics]").attr("href");
					System.out.println(discussion_title);
					System.out.println("Match :"+discussion_title.contains("Reply"));
					if(discussion_title.contains("Reply"))
					Replies_theaquaponicsource.put(discussion_title,Disc_link);
					else
					Discussions_theaquaponicsource.put(discussion_title,Disc_link);
					
					
					doc_discussion_text=Jsoup.connect(url).get();
					
					
				}
				new_doc = Jsoup.connect(appendURL+(i+1)).get();
			
			} 
			
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SearchCategories("advice Thank you Fish Tilapia");
					}

		private static HashMap<String,String> SearchCategories(String search_text) {
			// TODO Auto-generated method stub
			Cats.clear();
			ArrayList<String> splitedSearchtext = spliter(search_text);
			for (String string : Discussions_theaquaponicsource.keySet()) {
			String str = string;
			ArrayList<String> splitedDistext = spliter(str); //split on word boundries
			System.out.println(splitedDistext);
			
			System.out.println("Dis:"+ splitedDistext);
			System.out.println("Search: "+splitedSearchtext);
			splitedDistext.retainAll(splitedSearchtext);
			if(splitedDistext.size()>0) //search array for word
			{
				Cats.put(string,Discussions_theaquaponicsource.get(string));
				System.out.println(" \n\n Macthed: "+string+"\n\n");
			}
			
		}
			return Cats;
		}

		private static ArrayList<String> spliter(String search_text) {
			// TODO Auto-generated method stub
			StringTokenizer st = new StringTokenizer(search_text);
			ArrayList<String> a = new ArrayList<>();
			while(st.hasMoreTokens())
				a.add(st.nextToken());
			return a;
		}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
}
