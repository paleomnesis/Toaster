package works.paleomnesis.toaster.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import works.paleomnesis.toaster.util.ToastUtil;

public class ToastListener implements Listener {

    @EventHandler
    public void onChestIgnite(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();
        Player player = event.getPlayer();
        ItemStack handItem = player.getInventory().getItemInMainHand();

        if (block == null || block.getType() != Material.CHEST) return;
        if (handItem == null || handItem.getType() != Material.FLINT_AND_STEEL) return;
        if (!(block.getState() instanceof Chest chest)) return;

        Inventory inv = chest.getInventory();

        boolean hasBread = false;

        for (ItemStack item : inv.getContents()) {
            if (item == null) continue;

            if (item.getType() == Material.BREAD) {
                hasBread = true;
            } else {
                return;
            }
        }

        if (hasBread) {
            ToastUtil.makeToast(player, block);
        }
    }
}
