package com.cubloc.servermanager;

import org.bukkit.entity.Player;

import com.cubloc.servermanager.files.FilesManager;
import com.cubloc.servermanager.files.RanksFile;
import com.cubloc.servermanager.grades.GradesManager;

public class ServerPlayer {

	private Player player;

	public ServerPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void createAccount() {
		ServerManager.Log("Création du compte de " + player.getName() + "...");
		try {
			if(!hasAccount()){
				RanksFile.getFile().createSection(getPlayer().getUniqueId().toString());
				RanksFile.getFile().set(getPlayer().getUniqueId().toString(), GradesManager.Joueur.getModerationLevel());
				
				new FilesManager().saveFiles();
			}
			ServerManager.Log("Création du compte de " + player.getName() + " terminée avec succès!");
		} catch (Exception exception) {
			ServerManager.Log("Une erreur est survenue lors de la création du compte de "+getPlayer().getName());
			exception.printStackTrace();
		}

	}

	public boolean hasAccount() {
		if (RanksFile.getFile().contains(getPlayer().getUniqueId().toString())) {
			return true;
		}
		return false;
	}

	public void setRank(GradesManager grade) {
		try {
			if(hasAccount()){
				
				RanksFile.getFile().set(getPlayer().getUniqueId().toString(), grade.getModerationLevel());
				
				new FilesManager().saveFiles();
			}
		} catch (Exception exception) {
			ServerManager.Log("Une erreur est survenue lors de la création du compte de "+getPlayer().getName());
			exception.printStackTrace();
		}
	}
	
	public Integer getModerationLevel(){
		return RanksFile.getFile().getInt(getPlayer().getUniqueId().toString());
	}

}
