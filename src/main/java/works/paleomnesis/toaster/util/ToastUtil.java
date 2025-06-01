package works.paleomnesis.toaster.util;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ToastUtil {

    public static void makeToast(Player player, Block block) {
        if (!(block.getState() instanceof Chest chest)) return;

        for (ItemStack item : chest.getInventory().getContents()) {
            if (item != null && item.getType() == Material.BREAD) {
                item.setType(Material.BAKED_POTATO);
                ItemMeta meta = item.getItemMeta();
                if (meta != null) {
                    meta.setDisplayName(ChatColor.GOLD + "Tost");
                    item.setItemMeta(meta);
                }
            }
        }

        double newHealth = Math.min(player.getHealth() + 2.0, player.getMaxHealth());
        player.setHealth(newHealth);

        player.sendMessage(ChatColor.YELLOW + "Tost yaptın! +1 can! 🍞🔥");

        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 1f, 1f);

        Location loc = block.getLocation().add(0.5, 1.0, 0.5);
        player.getWorld().spawnParticle(Particle.FLAME, loc, 20);
    }
}
