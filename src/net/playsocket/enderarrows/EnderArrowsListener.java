package net.playsocket.enderarrows;

import net.canarymod.api.entity.Arrow;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.Colors;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.entity.ProjectileHitHook;
import net.canarymod.plugin.PluginListener;

public class EnderArrowsListener implements PluginListener {
	
	@HookHandler
	public void onProjectileHit(ProjectileHitHook hook) {
		if (hook.getProjectile() instanceof Arrow){
			Arrow arrow = (Arrow)hook.getProjectile();
			if (arrow.getOwner().isPlayer()){
					Player player = (Player)arrow.getOwner();
					if (player.getItemHeld() != null && player.getItemHeld().getDisplayName().equals(Colors.TURQUIOSE + "Ender Bow")){
						if (player.hasPermission("enderarrows.use")){
							player.teleportTo(arrow.getX(), arrow.getY(), arrow.getZ());
					}
				}
			}
		}
	}

}
