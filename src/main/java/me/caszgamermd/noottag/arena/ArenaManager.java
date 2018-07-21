package me.caszgamermd.noottag.arena;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ArenaManager {

    private Map<Integer, Arena> arenas;

    public ArenaManager() {
        arenas = new HashMap<>();

        loadArenas();
    }

    private void loadArenas() {
        HashMap<UUID, Long> players = new HashMap<>();
        HashMap<Integer, Location> region = new HashMap<>();

        players.put(UUID.randomUUID(), System.currentTimeMillis());
        region.put(0, new Location(Bukkit.getWorlds().get(0), 30, 100, 30));
        region.put(1, new Location(Bukkit.getWorlds().get(0), 45, 100, 45));

        arenas.put(arenas.size(), new Arena("Arena Name", arenas.size(), players, 2, 16, true, region));

        System.out.println(getArena("Arena Name"));
    }

    public Optional<Arena> getArena(String arenaName) {
        Map.Entry<Integer, Arena> map = arenas.entrySet().stream().filter(entry -> entry.getValue().getArenaName().equalsIgnoreCase(arenaName)).findFirst().orElse(null);

        try {
            return Optional.ofNullable(map.getValue());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Arena> getArena(int arenaID) {
        Map.Entry<Integer, Arena> map = arenas.entrySet().stream().filter(entry -> entry.getValue().getId() == arenaID).findFirst().orElse(null);

        try {
            return Optional.ofNullable(map.getValue());
        } catch (Exception e) {
            return Optional.empty();
        }

    }

    public Optional<Arena> getArena(UUID uuid) {
        Map.Entry<Integer, Arena> map = arenas.entrySet().stream().filter(entry -> entry.getValue().getPlayers().containsKey(uuid)).findFirst().orElse(null);

        try {
            return Optional.ofNullable(map.getValue());
        } catch (Exception e) {
            return Optional.empty();
        }
    }


}
