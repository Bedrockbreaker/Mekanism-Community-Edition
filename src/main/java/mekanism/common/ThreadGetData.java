package mekanism.common;

import java.util.List;

import mekanism.common.util.MekanismUtils;
import cpw.mods.fml.relauncher.FMLInjectionData;

/**
 * Thread used to retrieve data from the Mekanism server.
 * @author AidanBrady
 *
 */
public class ThreadGetData extends Thread
{
	public ThreadGetData()
	{
		setDaemon(true);
		start();
	}

	@Override
	public void run()
	{
		List<String> ret = MekanismUtils.getHTML("https://raw.githubusercontent.com/Thorfusion/Mekanism-1.7.10-Community-Edition/1.7.10/Mekanism.txt");
		
		Mekanism.latestVersionNumber = "null";
		Mekanism.recentNews = "null";
		
		for(String s : ret)
		{
			String[] text = s.split(":");
			
			if(text.length == 3 && !text[0].contains("UTF-8") && !text[0].contains("HTML") && !text[0].contains("http"))
			{
				if(Version.get(text[0]) != null && Version.get(text[0]).equals(Version.get((String)FMLInjectionData.data()[4])))
				{
					Mekanism.latestVersionNumber = text[1];
					Mekanism.recentNews = text[2];
					
					break;
				}
			}
		}
	}
}
