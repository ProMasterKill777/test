package jutting.listener;

import jutting.BungeeHack;
import net.md_5.bungee.api.event.PlayerHandshakeEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class LoginListener implements Listener {
   @EventHandler
   public void onLogin(PlayerHandshakeEvent event) {
      event.getHandshake().setHost(BungeeHack.getIP());
   }
}
