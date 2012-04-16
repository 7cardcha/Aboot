package src;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public class Aboot extends JavaPlugin
{	 
	public static File file;
	public static FileConfiguration config;
	
	public static HashMap<String, Boolean> aboot = new HashMap<String, Boolean>();
	
	public void onEnable()
	{
		file = new File("AbootCFG.yml");
		if(!file.exists())
		{
			try 
			{
				file.createNewFile();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		config = YamlConfiguration.loadConfiguration(file);
		
		getServer().getPluginManager().registerEvents(new AbootEventHandler(), this);
	}

	public void onDisable()
	{
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[])
	{
		if(cmd.getName().equalsIgnoreCase("aboot"))
		{
			if(args.length == 0)
			{
				sender.sendMessage("Not enough arguments.");
			}
			else if(getServer().getPlayer(args[0]) == null)
			{
				sender.sendMessage("Player is not online.");
			}
			else
			{
				if(aboot.containsKey(args[0]))
				{
					aboot.remove(args[0]);
					sender.sendMessage("Aboot turned off for " + args[0] + ".");
				}
				else
				{
					aboot.put(args[0], true);
					sender.sendMessage("Aboot turned on for " + args[0] + ".");
				}
			}
			return true;
		}
		return false;
	}
	
}
