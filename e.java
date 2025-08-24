import jutting.BungeeHack;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class e implements Listener {
   @EventHandler
   public void onConnect(ServerConnectEvent event) {
      event.getPlayer().setDisplayName(BungeeHack.getName());
   }
}
