package com.cubloc.servermanager.grades;

import java.util.HashMap;

import org.bukkit.ChatColor;

public enum GradesManager {
	
	Administrateur(10, "§cAdministrateur", "§c[Admin] ", ChatColor.RED),
	Développeur(9, "§2Développeur", "§2[Développeur] ", ChatColor.DARK_GREEN),
	Responsable_Modérateur(8, "§6Responsable modérateur", "§6[Resp. Mod] ", ChatColor.GOLD),
	Modérateur(7, "§6Modérateur", "§6[Mod] ", ChatColor.GOLD),
	Helper(6, "§3Helper", "§3[Helper] ", ChatColor.DARK_AQUA),
	Ami(5, "§dAmi", "§dAmi", ChatColor.LIGHT_PURPLE),
	Staff(4, "§2Staff", "§2[Staff] ", ChatColor.DARK_GREEN),
	VIP_Plus(3, "§bVIP+", "§b[VIP+] ", ChatColor.AQUA),
	VIP(2, "§eVIP", "§e[VIP] ", ChatColor.YELLOW),
	Joueur(1, "§7Joueur", "§7", ChatColor.GRAY);
	
	int moderationLevel;
	String nom, prefix;
	ChatColor couleur;
	
	static HashMap<Integer, GradesManager> LEVEL_MAP = new HashMap<Integer, GradesManager>();
	
	private GradesManager(int moderationLevel, String nom, String prefix, ChatColor couleur) {
		this.moderationLevel = moderationLevel;
		this.nom = nom;
		this.prefix = prefix;
		this.couleur = couleur;
	}
	
	static {
		for(GradesManager gradesManager : values()){
			LEVEL_MAP.put(gradesManager.moderationLevel, gradesManager);
		}
	}
	  
	public String getName() {
		return nom;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public int getModerationLevel() {
		return moderationLevel;
	}
	
	public ChatColor getColor() {
		return couleur;
	}
	
	public GradesManager getFromLevel(int moderationLevel){
		
		return LEVEL_MAP.get(moderationLevel);
	}
}
