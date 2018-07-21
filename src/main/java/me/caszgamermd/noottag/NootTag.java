package me.caszgamermd.noottag;

import me.caszgamermd.noottag.arena.ArenaManager;
import me.caszgamermd.noottag.commands.NootTagCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class NootTag extends JavaPlugin {

    @Override
    public void onEnable() {
        ArenaManager arenaManager = new ArenaManager();

        getCommand("noottag").setExecutor(new NootTagCommand());
    }

    @Override
    public void onDisable() {
    }

}