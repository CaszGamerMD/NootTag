package me.caszgamermd.noottag.arena;

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
        // LOADING ARENAS FROM CONFIG
    }

    public Optional<Arena> getArena(String arenaName) {
        Map.Entry<Integer, Arena> map = arenas.entrySet().stream().filter(entry -> entry.getValue().getArenaName().equalsIgnoreCase(arenaName)).findFirst().orElse(null);
        return Optional.ofNullable(map.getValue());
    }

    public Optional<Arena> getArena(int arenaID) {
        Map.Entry<Integer, Arena> map = arenas.entrySet().stream().filter(entry -> entry.getValue().getId() == arenaID).findFirst().orElse(null);
        return Optional.ofNullable(map.getValue());
    }

    public Optional<Arena> getArena(UUID uuid) {
        Map.Entry<Integer, Arena> map = arenas.entrySet().stream().filter(entry -> entry.getValue().getPlayers().containsKey(uuid)).findFirst().orElse(null);
        return Optional.ofNullable(map.getValue());
    }


}
