package com.cubloc.servermanager.files;

import com.cubloc.servermanager.ServerManager;

public class FilesManager {

	public void setupFiles() {

		try {
			ServerManager.Log("Installation des fichiers de configuration en cours...");

			RanksFile.setupFile();

			ServerManager.Log("Installation des fichiers de configuration terminée avec succès!");
		} catch (Exception exception) {

			ServerManager.Log("Une erreur est survenue lors de l'installation des fichiers de configuration.");
			exception.printStackTrace();
		}

	}

	public void saveFiles() {
		
		try{
			ServerManager.Log("Sauvegarde des fichiers de configuration en cours...");
			
			RanksFile.ranks.save(RanksFile.ranksFile);
			
			ServerManager.Log("Sauvegarde des fichiers terminée avec succès!");
		}catch (Exception exception) {
			ServerManager.Log("Une erreur est survenue lors de la sauvegarde des fichiers de configuration. Détails:");
			exception.printStackTrace();
		}
		
	}
}
