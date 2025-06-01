package works.paleomnesis.toaster;

import org.bukkit.plugin.java.JavaPlugin;
import works.paleomnesis.toaster.listener.ToastListener;


public class Toaster extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new ToastListener(), this);
    }

    @Override
    public void onDisable() {
    }
}
