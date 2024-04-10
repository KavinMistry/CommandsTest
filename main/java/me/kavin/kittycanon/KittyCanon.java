package me.kavin.kittycanon;

import org.bukkit.plugin.java.JavaPlugin;

public final class KittyCanon extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(" --> Plugin is enabled <-- ");
        getServer().getPluginManager().registerEvents(new EntityListener(), this);
        getCommand("cat").setExecutor(new CatCanon());
        getCommand("kit").setExecutor(new Kit());
    }

    @Override
    public void onDisable() {
        getLogger().info(" --> plugin is disabled <--");

    }

    public static KittyCanon getInstance()
    {
        return getPlugin(KittyCanon.class);
    }
}