package me.caszgamermd.noottag.arena;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ArenaManager {

    private Map<Integer, Arena> arenas;

    public ArenaManager() {
        arenas = new HashMap<>();

        loadArenas();
    }

    private void loadArenas() {
        // LOADING ARENAS FROM CONFIG
    }

    public Arena getArena(String arenaName) {
        return (Arena) arenas.entrySet().stream().filter(entry -> entry.getValue().getArenaName().equalsIgnoreCase(arenaName)).findFirst().orElse(null);
    }

    public Arena getArena(int arenaID) {
        return (Arena) arenas.entrySet().stream().filter(entry -> entry.getValue().getId() == arenaID).findFirst().orElse(null);
    }

    public Arena getArena(UUID uuid) {
        return (Arena) arenas.entrySet().stream().filter(entry -> entry.getValue().getPlayers().containsKey(uuid)).findFirst().orElse(null);
    }


}
