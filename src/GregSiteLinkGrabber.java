package src;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GregSiteLinkGrabber 
{
	public void getURLSFromPage(String fileName)
	{
		try
		{						
			File input = new File(fileName);
			htmlPage = Jsoup.parse(input, "UTF-8", "http://example.com/");
		}
		catch (Exception e)
		{
			System.err.println("General exception when trying to read a porn html file.");
			System.err.println(e.getLocalizedMessage());
		}
		
		// all of these porn aggregate sites use the same code, buy and large, so this class is found pretty much everywhere.
		// its a bit strange, to be frank. the sites themselves are nearly identical. it is likely that these sites are owned by a single entity.
		Elements urls = htmlPage.getElementsByClass("html-attribute-value html-external-link");	
		
		for (Element e : urls)
		{
			if (!e.getElementsByAttribute("href").text().contains("tblop") && !e.getElementsByAttribute("href").text().contains("google") 
					&& !e.getElementsByAttribute("href").text().contains("amzn") && !e.getElementsByAttribute("href").text().contains("youtube")
					&& !e.getElementsByAttribute("href").text().contains("discord") && !e.getElementsByAttribute("href").text().contains("bing")
					&& !e.getElementsByAttribute("href").text().contains("bit.ly") && !e.getElementsByAttribute("href").text().contains("mozilla")
					&& !e.getElementsByAttribute("href").text().contains("twitter") && !e.getElementsByAttribute("href").text().contains("html")
					&& !e.getElementsByAttribute("href").text().contains("mailto:"))
			{
				String url = e.getElementsByAttribute("href").text();
				
				url = munger.removeURLPrepend(url);
				
				if (url.charAt(0) == '.')
				{
					url = url.substring(1, url.length());
				}
				
				url = munger.removeSiteDirectory(url);
				
				// TODO 4chan dont remove last slash (/s/, /gif/)
			
				if (url.matches(".+\\..+") && !url.contains("="))
				{					
					URLS.add(url);
				}
			}
		}
		
		System.out.println("Finished parsing an HTML page. Number of sites (just HTML) now at: " + URLS.size());
	}
	
	public Set<String> getURLS()
	{
		return URLS;
	}
	
	private Set<String> URLS = new HashSet<String>();
	private Document htmlPage;
	
	private StringMunging munger = new StringMunging();
}

// TODO online grabbing instead of local file (slow, probably need thread pool)
//String fileNameFixed = fileName;
//
//fileNameFixed = fileNameFixed.substring(10, fileName.length());
//fileNameFixed = fileNameFixed.replaceAll("\\.html", "");
//
//fileNameFixed = URLEncoder.encode(fileNameFixed, "UTF-8");
//
//URL url = new URL("http://www." + fileNameFixed);
//
//System.out.println(url);
//
//htmlPage = Jsoup.parse(url, 10000);

// regex broken
//if (!url.isEmpty() && url.matches(".*[^,;?=@#].*") && !url.startsWith("/") && !url.startsWith(".") && !url.contains(" ") && !url.contains("#"))
//[a-zA-Z0-9-]+\\.[a-zA-Z0-9-]+
//.+\\..+
//([a-zA-Z0-9-]+\\.[a-zA-Z0-9-]+)+