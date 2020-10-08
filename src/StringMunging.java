package src;

public class StringMunging 
{
	public String removeSiteDirectory(String url) 
	{
		int a = url.indexOf('/');			
		
		if (a != -1 && !url.startsWith("reddit") && !url.startsWith("pinterest"))
		{
			url = url.substring(0, a);					
		}
		
		return url;
	}
	
	public String removeURLPrepend(String url) 
	{
		url = url.replaceAll("htt(p|ps)://(www.)?", "");
		return url;
	}
	
	// TODO not used
	public String removeIndexingAndJSFunctions(String url, char a)
	{
		int index = url.indexOf(a);
		
		if (index != -1)
		{
			url = url.substring(0, a);
		}
		
		return url;
	}
}