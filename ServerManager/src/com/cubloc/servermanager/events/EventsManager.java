package com.cubloc.servermanager.events;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class EventsManager {

	Plugin plugin;

	public EventsManager(Plugin plugin) {
		this.plugin = plugin;
	}

	public void registerListeners() {
		PluginManager pluginManager = Bukkit.getPluginManager();

		pluginManager.registerEvents(new JoinListener(), plugin);
		pluginManager.registerEvents(new QuitListener(), plugin);
	}

}
