package com.cubloc.servermanager.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class RanksFile {

	private static File f = new File("plugins/ServerManager");
	public static FileConfiguration ranks;
	public static File ranksFile;

	public static void setupFile() {
		if ((!f.exists()) || (f == null)) {
			f.mkdir();
		}
		ranksFile = new File("plugins/ServerManager", "Ranks.yml");
		if (!ranksFile.exists()) {
			try {
				ranksFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Impossible de générer le fichier Ranks.yml");
			}
		}
		ranks = YamlConfiguration.loadConfiguration(ranksFile);
	}
	
	public static FileConfiguration getFile(){
		
		return ranks;
	}
}
