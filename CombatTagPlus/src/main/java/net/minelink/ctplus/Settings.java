package net.minelink.ctplus;

import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;

import java.util.ArrayList;
import java.util.List;

public final class Settings {

    private final CombatTagPlus plugin;

    public Settings(CombatTagPlus plugin) {
        this.plugin = plugin;
        load();
    }

    public void load() {
        Configuration defaults = plugin.getConfig().getDefaults();
        defaults.set("disabled-worlds", new ArrayList<>());
        defaults.set("disabled-commands", new ArrayList<>());
    }

    public int getConfigVersion() {
        return plugin.getConfig().getInt("config-version", 0);
    }

    public int getLatestConfigVersion() {
        return plugin.getConfig().getDefaults().getInt("config-version", 0);
    }

    public boolean isOutdated() {
        return getConfigVersion() < getLatestConfigVersion();
    }

    public int getTagDuration() {
        return plugin.getConfig().getInt("tag-duration", 15);
    }

    public String getTagMessage() {
        String message = plugin.getConfig().getString("tag-message");
        return message != null ? ChatColor.translateAlternateColorCodes('&', message) : null;
    }

    public boolean playEffect() {
        return plugin.getConfig().getBoolean("play-effect");
    }

    public int getNpcDespawnTime() {
        return plugin.getConfig().getInt("npc-despawn-time", 60);
    }

    public int getNpcDespawnTicks() {
        return getNpcDespawnTime() * 20;
    }

    public String getKillMessage() {
        String message = plugin.getConfig().getString("kill-message");
        return message != null ? ChatColor.translateAlternateColorCodes('&', message) : null;
    }

    public boolean useBarApi() {
        return plugin.getConfig().getBoolean("barapi");
    }

    public List<String> getDisabledWorlds() {
        return plugin.getConfig().getStringList("disabled-worlds");
    }

    public List<String> getDisabledCommands() {
        return plugin.getConfig().getStringList("disabled-commands");
    }

}
