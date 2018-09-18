import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlListItem;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebScrap {
	public static void main(String[] args) {
		
		String baseUrl = "https://www.apartments.com/dallas-tx/?bb=6_4xqq6l1J8v6pgivB";
		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		try {
			String searchUrl = baseUrl;
			HtmlPage page = client.getPage(searchUrl);
//			System.out.println(page.asXml());
			List<Item> itemList = new ArrayList<>();
			List<?> placardDiv = page.getByXPath("//*[@class=\"placardContainer\"]/li");
			if(!placardDiv.isEmpty())
			{
				for(Object obj : placardDiv)
				{
					HtmlElement placardContainer = (HtmlElement)obj;
					System.out.println(placardContainer.getDescendants());
					if(placardContainer != null)
					{
						Item item = new Item();
						HtmlAnchor anchor = (HtmlAnchor)placardContainer.getFirstByXPath("//a[@class='placardTitle']");
						if(anchor != null)
						{
							item.setPlacardTitle(anchor.getAttribute("title"));
						}
						item.setPlacardHref(anchor.getHrefAttribute());
						List<?> imageDivsList = placardContainer.getByXPath("//div[@class='item']");
						if(!imageDivsList.isEmpty())
						{
							List<String> imageList = new ArrayList<>();
							for(Object ob : imageDivsList)
							{
								HtmlDivision imageDiv = (HtmlDivision)ob;
								String imageUrl = imageDiv.getAttribute("data-img");
								imageList.add(imageUrl);
							}
							item.setImageUrl(imageList);
						}
						itemList.add(item);
					}
				}
				ObjectMapper mapper = new ObjectMapper();
				for(Item i : itemList)
				{
					String jsonString = mapper.writeValueAsString(i);
					System.out.println(jsonString);
				}
				client.close();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
