package src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HostsWriter 
{
	public HostsWriter(Set<String>... set)
	{
		parseBlockList();
		int originalBlockListSize = URLS.size();
		System.out.println("Original block list size:\t" + originalBlockListSize);
		
		aggregateSets(set);
		aggregatedBlockListSize = URLS.size();
		System.out.println("Aggregated block list size:\t" + aggregatedBlockListSize);
				
		getMyBlockListSize(set);		
		
		System.out.println("Sites added by this effort:\t" + (aggregatedBlockListSize - originalBlockListSize));
		
		writeBlockListFile();
	}
	
	private void parseBlockList()
	{
		int emptyIPLength = emptyIP.length();

		Scanner scanner;
		try 
		{
			scanner = new Scanner(theBlockListFile);
			
			while(scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				
				if (line.matches(".*0\\.0\\.0\\.0.*"))
				{
					String link = line.substring(emptyIPLength + 1, line.length());
					URLS.add(link);
				}
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("Porn block list file not found.");
			System.err.println(e.getLocalizedMessage());
		}
	}
	
	private void writeBlockListFile()
	{
		String fileName = "hosts.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) 
		{
			writer.write("#------------------------------------[UPDATE]--------------------------------------\n"
					+ "# Title: The Block List Project\n"
					+ "# Expires: 1 day\n"
					+ "# Homepage: https://blocklist.site\n"
					+ "# Help: https://github.com/blocklistproject/lists/wiki/\n"
					+ "# License: https://unlicense.org\n"
					+ "# Total number of network filters: " + aggregatedBlockListSize + "\n"
					+ "#\n"
					+ "# EDITED TO INCLUDE MORE SITES BY PSYCHOBAGGER: https://github.com/Psychobagger/PornBlock\n"
					+ "#\n"
					+ "#------------------------------------[SUPPORT]-------------------------------------\n"
					+ "# You can support by:\n"
					+ "# - reporting false positives\n"
					+ "# - making a donation: https://paypal.me/blocklistproject\n"
					+ "#-------------------------------------[INFO]---------------------------------------\n"
					+ "#\n"
					+ "# Porn list\n"
					+ "#------------------------------------[FILTERS]-------------------------------------\n");
			
			List<String> tempList = new ArrayList<>(URLS);
			Collections.sort(tempList);
			
			for (String s : tempList)
			{
				writer.write(emptyIP + " " + s + "\n");
			}
			
			System.out.println("\nNew block list file generated: " + fileName);
		}
		catch (IOException e) 
		{
			System.err.println("Exception during file write.");
			System.err.println(e.getLocalizedMessage());
		}
	}
	
	private void aggregateSets(Set<String>... set)
	{
		for (int i = 0; i < set.length; i++)
		{
			URLS.addAll(set[i]);			
		}
	}
	
	private void getMyBlockListSize(Set<String>... set)
	{
		int counter = 0;
		for (int i = 0; i < set.length; i++)
		{
			counter += set[i].size();
		}
		
		System.out.println("My block list size:\t\t" + counter);
	}
	
	private int aggregatedBlockListSize;
	
	private Set<String> URLS = new HashSet<String>();
		
	private final String emptyIP = "0.0.0.0";
	
	// The BlockList porn file (https://github.com/blocklistproject/Lists/blob/master/porn.txt)
	private final File theBlockListFile = new File("porn.txt");
}