package net.playsocket.enderarrows;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.Colors;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.Command;
import net.canarymod.commandsys.CommandListener;

public class EnderArrowsCommands implements CommandListener {

	@Command(aliases = { "ebow" },
			description = "Convert a bow to an EnderBow",
			permissions = { "enderarrows.ebow" },
			toolTip = "/ebow",
			min = 1)
	public void ebowCMD(MessageReceiver caller, String[] split) {
		if (caller instanceof Player){
			Player player = (Player)caller;
			if (player.getItemHeld().getId() == 261){
				player.getItemHeld().setDisplayName(Colors.TURQUIOSE + "Ender Bow");
				player.getItemHeld().setLore(Colors.CYAN + "Turns regular arrows into Ender Arrows");
				player.notice("Ender Bow created");
			}
		}
		return;
	}

}