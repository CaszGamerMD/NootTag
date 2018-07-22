package me.caszgamermd.noottag.arena;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ArenaManager {

    private Arena arena;

    public ArenaManager() {
        loadArenas();
    }

    private void loadArenas() {
        HashMap<Integer, Location> region = new HashMap<>();
        region.put(0, new Location(Bukkit.getWorlds().get(0), 30, 100, 30));
        region.put(1, new Location(Bukkit.getWorlds().get(0), 45, 100, 45));
        region.put(2, new Location(Bukkit.getWorlds().get(0), -15025.864, 75, 7385));

        arena = new Arena("Arena Name", 0, null, 2, 16, true, region);
    }

    public Arena getArena() {
        return arena;
    }
}
