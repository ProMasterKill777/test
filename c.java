import jutting.BungeeHack;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class c implements Listener {
   @EventHandler
   public void onPreLogin(PreLoginEvent event) {
      event.getConnection().setUniqueId(BungeeHack.getUUID());
   }
}
