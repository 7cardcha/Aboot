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
	
	public static File file1;
	public static FileConfiguration config1;
	
	public static HashMap<String, Boolean> aboot = new HashMap<String, Boolean>();
	public static boolean abootAll;
	
	public static HashMap<String, Boolean> aussie = new HashMap<String, Boolean>();
	public static boolean aussieAll;
	
	
	public void onEnable()
	{
		loadConfig();
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
		
		if(cmd.getName().equalsIgnoreCase("aussie"))
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
				if(aussie.containsKey(args[0]))
				{
					aussie.remove(args[0]);
					sender.sendMessage("Aussie turned off for " + args[0] + ".");
				}
				else
				{
					aussie.put(args[0], true);
					sender.sendMessage("Aussie turned on for " + args[0] + ".");
				}
			}
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("abootall"))
		{
			abootAll = !abootAll;
			
			if(abootAll)
			{
				sender.sendMessage("Aboot enabled for everybody.");
			}
			else
			{
				sender.sendMessage("Aboot disabled for everybody.");
			}
			
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("aussieall"))
		{
			aussieAll = !aussieAll;
			
			if(aussieAll)
			{
				sender.sendMessage("Aussie enabled for everybody.");
			}
			else
			{
				sender.sendMessage("Aussie disabled for everybody.");
			}
			
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("abootreload"))
		{
			
			loadConfig();
			
			sender.sendMessage("Config reloaded. (If it didn't then check the console for a load error.)");
		
			return true;
		}
		return false;
	}
	
	public static void loadConfig()
	{
		file = new File("AbootCFGCanada.yml");
		if(!file.exists())
		{
			try 
			{
				file.createNewFile();
			} catch (IOException e) 
			{
				System.out.println("!!!!Failed to load canada config for Aboot!!!!");
				e.printStackTrace();
			}
		}
		
		config = YamlConfiguration.loadConfiguration(file);
		
		file1 = new File("AbootCFGAussie.yml");
		if(!file1.exists())
		{
			try 
			{
				file1.createNewFile();
			} 
			catch (IOException e) 
			{
				System.out.println("!!!!Failed to load aussie config for Aboot!!!!");
				e.printStackTrace();
			}
		}
		config1 = YamlConfiguration.loadConfiguration(file1);
		
	}
	
}
