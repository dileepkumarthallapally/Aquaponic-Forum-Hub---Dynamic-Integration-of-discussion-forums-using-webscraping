

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;




public class main {
	 private static Document doc_discussion_text;
	  static Document doc;
	  static String appendURL ;
	static Document new_doc, new_doc2;
	static HashMap<String, String>Repllies_search = new HashMap<String, String>();
	static HashMap<String, String>Texts_search = new HashMap<String, String>();
	static HashMap<String, String>Cats = new HashMap<String, String>();
	static ArrayList<String>Texts = new ArrayList<String>();
	static ArrayList<String>Texts1 = new ArrayList<String>();
	
	static HashMap<String, String> Searched_Discussionby_theaquaponicnation = new HashMap<String, String>();
		static HashMap<String, String> Categories_theaquaponicsource = new HashMap<String, String>();
		static HashMap<String, String> Discussions_theaquaponicnation = new HashMap<String, String>();
		
		static HashMap<String, String> Discussionby_theaquaponicnation = new HashMap<String, String>();
		static HashMap<String, String> Replies_theaquaponicnation = new HashMap<String, String>();
		private static HashMap<String, String> ReplliesURL_search =  new HashMap<String,String>();
	
		//static ArrayList<String> Cats =new ArrayList<String>();
		static HashMap<String, String> Categories_theaquaponicnation = new HashMap<String, String>();

		public static void main(String[] args) throws IOException {
			loadCategories_theaquaponicnation();
			FindDiscussions("Category name","Search text");
		}

		private static void loadCategories_theaquaponicnation() throws IOException {
			// TODO Auto-generated method stub
			doc = Jsoup.connect("http://aquaponicsnation.com/forums/forum/10-aquaponics/").get();
			Elements eles = doc.select("table.ipb_table");
			for (Element ele2 : eles.select("a")) {
				if(!ele2.select("a[href^=http://aquaponicsnation.com/forums/forum]").attr("href").toString().isEmpty())
				Categories_theaquaponicnation.put(ele2.select("a[href^=http://aquaponicsnation.com/forums/forum]").text(), ele2.select("a[href^=http://aquaponicsnation.com/forums/forum]").attr("href").toString());
				}
			
			
		}

		private static HashMap<String,String> FindDiscussions(String Category, String search_text) {
			// TODO Auto-generated method stub
			for (String string2 : Categories_theaquaponicnation.keySet()) {
				System.out.println(string2 +" : "+ Categories_theaquaponicnation.get(string2));
			}
			String urls= Categories_theaquaponicnation.get("GENERAL AQUAPONICS DISCUSSION");
			try {
				new_doc=Jsoup.connect(urls).get();
				Elements No_of_pages = new_doc.select("ul.pagination").select("a[href^="+urls);
				ArrayList<String> page_nos =new ArrayList<String>();
				//int size = 17;
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
					Elements else2 = new_doc.select("div.pagination.clearfix.left");
				
				//Elements eles1 = doc.select("ul.ipsList_inline").select("li#anonymous_element_1.pagejump.clickable.pj0688074001");
					//String url1=i2.select("a[href=#]").text();
					Elements size1=else2.select("a[href=#]") ;
						 
					System.out.println("dhjd"+size1.text());	
					System.out.println(size1.text().substring(10,12));
					
					
					int size = Integer.parseInt(size1.text().substring(10, 12));
					
					boolean b=true;
					int k=0;
					int l=0;
					String discussionTitle="";
			for(int i=0;i<=size;i++)
			{
				
				
				Elements category_element = new_doc.select("td.col_f_content");
				
				for (Element ele3 : category_element.select("a")) {
					String url=ele3.select("a[href^=http://aquaponicsnation.com/forums/topic]").attr("href");
					System.out.println(url);
					if(url.isEmpty())
						continue;
					
					String discussion_title =ele3.select("a[href^=http://aquaponicsnation.com/forums/topic]").text();
					String Disc_link = ele3.select("a[href^=http://aquaponicsnation.com/forums/topic]").attr("href");
					System.out.println("Discussion Link : "+Disc_link);
					System.out.println("Discussion title: "+discussion_title);
					Elements e = new_doc.select("span.desc.lighter.blend_links");
					for (Element element : e) {
						if(element.text().contains("Started"))
						{
							Texts.add(element.text());
							//System.out.println("hdjdj"+ element.text());
						}
					}
					Elements e1 = new_doc.select("ul.last_post.ipsType_small");
					for (Element element : e1) {
						
							Texts1.add(element.text());
							//System.out.println("hdjdj"+ element.text());
						
					}
					Discussions_theaquaponicnation.put(discussion_title,Disc_link);
					Discussionby_theaquaponicnation.put(discussion_title, Texts.get(k++));
					Replies_theaquaponicnation.put(discussion_title,Texts1.get(l++));
					discussionTitle=discussion_title;
					
					
					doc_discussion_text=Jsoup.connect(url).get();
					
					
				}
				new_doc = Jsoup.connect(appendURL+(i)).get();
			
				b=true;
				Texts.clear();
				Texts1.clear();
				k=0;
					} 
			
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SearchCategories(search_text);
			
		}
			
		public HashMap<String, String> getReplliesURL_search() {
				return ReplliesURL_search;
			}

			/**
			 * @param replliesURL_search the replliesURL_search to set
			 */
			public static void setReplliesURL_search(
					HashMap<String, String> replliesURL_search) {
				ReplliesURL_search = replliesURL_search;
			}

			/**
			 * @return the discussionTexts_theaquaponicsource
			 */
			 HashMap<String, String> getDiscussionTexts_theaquaponicsource() {
				return Texts_search;
			}

			/**
			 * @return the replies_theaquaponicsource
			 */
			
			/**
			 * @param discussionTexts_theaquaponicsource the discussionTexts_theaquaponicsource to set
			 */
			public static void setDiscussionTexts_theaquaponicsource(
					HashMap<String, String> discussionTexts_theaquaponicsource) {
				Discussionby_theaquaponicnation = discussionTexts_theaquaponicsource;
			}

			private static HashMap<String,String> SearchCategories(String search_text) {
				// TODO Auto-generated method stub
				Cats.clear();
				ArrayList<String> splitedSearchtext = spliter(search_text);
				for (String string : Discussions_theaquaponicnation.keySet()) {
				String str = string;
				ArrayList<String> splitedDistext = spliter(str); //split on word boundries
				splitedDistext.retainAll(splitedSearchtext);
				if(splitedDistext.size()>0) //search array for word
				{
					Cats.put(string,Discussions_theaquaponicnation.get(string));
					Searched_Discussionby_theaquaponicnation.put(string, "This discussion about "+ string+" was "+ Discussionby_theaquaponicnation.get(string));
					ReplliesURL_search.put(string,Replies_theaquaponicnation.get(string));
					
					
				}
				
			}
				return Cats;
			}

			public static HashMap<String, String> getRepllies_search() {
				return Repllies_search;
			}

			public static void setRepllies_search(HashMap<String, String> repllies_search) {
				Repllies_search = repllies_search;
			}

			public static HashMap<String, String> getSearched_Discussionby_theaquaponicnation() {
				return Searched_Discussionby_theaquaponicnation;
			}

			public static void setSearched_Discussionby_theaquaponicnation(
					HashMap<String, String> searched_Discussionby_theaquaponicnation) {
				Searched_Discussionby_theaquaponicnation = searched_Discussionby_theaquaponicnation;
			}

			private static ArrayList<String> spliter(String search_text) {
				// TODO Auto-generated method stub
				StringTokenizer st = new StringTokenizer(search_text);
				ArrayList<String> a = new ArrayList<>();
				while(st.hasMoreTokens())
					a.add(st.nextToken());
				return a;
			}
}
			
			
			
			
			
			
			
			
		


