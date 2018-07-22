package me.caszgamermd.noottag;

import me.caszgamermd.noottag.arena.ArenaManager;
import me.caszgamermd.noottag.commands.NootTagCommand;
import me.caszgamermd.noottag.commands.NootTagStaffCommand;
import me.caszgamermd.noottag.filesystem.ConfigurationManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NootTag extends JavaPlugin {

    @Override
    public void onEnable() {
        ArenaManager arenaManager = new ArenaManager();
        ConfigurationManager configurationManager = new ConfigurationManager(this);

        getCommand("noottag").setExecutor(new NootTagCommand());
        getCommand("noottagstaff").setExecutor(new NootTagStaffCommand());
    }

    @Override
    public void onDisable() {
    }

}