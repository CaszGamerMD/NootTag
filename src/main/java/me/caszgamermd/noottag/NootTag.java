package me.caszgamermd.noottag;

import me.caszgamermd.noottag.arena.ArenaManager;
import me.caszgamermd.noottag.commands.NootTagCommand;
import me.caszgamermd.noottag.commands.NootTagStaffCommand;
import me.caszgamermd.noottag.filesystem.ConfigurationManager;
import me.caszgamermd.noottag.runnables.LoopRunnable;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class NootTag extends JavaPlugin {

    @Override
    public void onEnable() {
        ArenaManager arenaManager = new ArenaManager();
        ConfigurationManager configurationManager = new ConfigurationManager(this);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new LoopRunnable(arenaManager.getArena(), configurationManager), 0, 20L);

        getCommand("noottag").setExecutor(new NootTagCommand(arenaManager));
        getCommand("noottagstaff").setExecutor(new NootTagStaffCommand());
    }

    @Override
    public void onDisable() {

    }

}