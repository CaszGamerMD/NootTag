package me.caszgamermd.noottag;

import me.caszgamermd.noottag.arena.ArenaManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NootTag extends JavaPlugin {

    @Override
    public void onEnable() {
        ArenaManager arenaManager = new ArenaManager();
    }

    @Override
    public void onDisable() {
    }

}