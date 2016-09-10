package com.cubloc.servermanager.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.cubloc.servermanager.ServerPlayer;

public class JoinListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		ServerPlayer serverPlayer = new ServerPlayer(player);
		
		serverPlayer.createAccount();
	}
}
