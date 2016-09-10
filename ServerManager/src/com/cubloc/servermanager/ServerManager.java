package com.cubloc.servermanager;

import org.bukkit.plugin.java.JavaPlugin;

import com.cubloc.servermanager.commands.CommandsManager;
import com.cubloc.servermanager.events.EventsManager;
import com.cubloc.servermanager.files.FilesManager;

public class ServerManager extends JavaPlugin {

	public static ServerManager instance;

	@Override
	public void onEnable() {
		instance = this;

		new EventsManager(this).registerListeners();
		new CommandsManager().registerCommands();

		new FilesManager().setupFiles();
		new FilesManager().saveFiles();
		
	}

	@Override
	public void onDisable() {

		new FilesManager().saveFiles();
	}

	public static ServerManager getInstance() {
		
		return instance;
	}

	public static void Log(String message) {
		if (message != null) {
			
			System.out.println("[ServerManager] " + message);
		}
	}

}
