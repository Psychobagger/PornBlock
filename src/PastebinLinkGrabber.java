package src;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PastebinLinkGrabber 
{
	public PastebinLinkGrabber()
	{
		try
		{
			getURLsFromPastebinBody();			
		}
		catch (SocketTimeoutException e)
		{
			System.err.println("Socket timeout. Pastebin connection may be bad. Just try again.");
			System.err.println(e.getLocalizedMessage());
		}
		catch(IOException e)
		{
			System.err.println("General IO exception grabbing Pastebin links.");
			System.err.println(e.getLocalizedMessage());
		}
	}
	
	public Set<String> getURLS()
	{
		return URLS;
	}
	
	private void getURLsFromPastebinBody() throws IOException
	{
		for (int i = 0; i < pastebins.length; i++)
		{
			URL url = new URL(pastebins[i]);
			htmlPage = Jsoup.parse(url, timeout);
			
			Elements e = htmlPage.getElementsByClass("textarea");
			
			List<String> separatedLinks = separateLinks(e.text());
		
			for (String s : separatedLinks)
			{
				if (!s.equals("ignoreme"))
				{					
					URLS.add(s);				
				}
			}
		}
	}
	
	private List<String> separateLinks(String bodyOfLinks)
	{		
		String[] workingArray = bodyOfLinks.split("\n");
						
		for (int i = 0; i < workingArray.length; i++)
		{			
			// This is necessary... sigh
			workingArray[i] = workingArray[i].trim();
			
			if (!workingArray[i].matches(".*htt(p|ps)://(www.)?.*"))
			{
				workingArray[i] = "ignoreme";
			}
			
			workingArray[i] = munger.removeURLPrepend(workingArray[i]);
			workingArray[i] = munger.removeSiteDirectory(workingArray[i]);
		}
		
		List<String> separatedLinks = Arrays.asList(workingArray);
			
		System.out.println("Finished parsing a pastebin page.");
		
		return separatedLinks;
	}
	
	private Document htmlPage;
	private int timeout = 10000;
	
	private Set<String> URLS = new HashSet<String>();
	
	private StringMunging munger = new StringMunging();
	
	// TODO last link is formatted weird, gotta account for it. just a bunch of subreddits.
	private final String[] pastebins = {"https://pastebin.com/cyHuPqUY", "https://pastebin.com/3BVtwqct", 
			"https://pastebin.com/k2mwPPTb", "https://pastebin.com/kxpt4dCN", 
			"https://pastebin.com/4Df1xamN", "https://pastebin.com/M0JwJfus", 
			"https://pastebin.com/DGQUPCaq", "https://pastebin.com/NSfQSyb3",
			"https://pastebin.com/XMdmd3yt", "https://pastebin.com/G9HtkQXd",
			"https://pastebin.com/i2gDEZtM", /*"https://pastebin.com/rqWDZepV"*/};
}