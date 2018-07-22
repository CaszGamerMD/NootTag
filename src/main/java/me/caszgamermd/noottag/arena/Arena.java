package me.caszgamermd.noottag.arena;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Arena {

    private String arenaName;
    private int id, minPlayers, maxPlayers;
    private boolean isStarted, activated;
    private HashMap<UUID, Long> players;
    private HashMap<Integer, Location> region;
    private UUID tagged;

    public Arena(String arenaName, int id, HashMap<UUID, Long> players, int minPlayers, int maxPlayers, boolean activated, HashMap<Integer, Location> region) {
        this.arenaName = arenaName;
        this.id = id;
        this.players = players == null ? new HashMap<UUID, Long>() : players;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.activated = activated;
        this.region = region == null ? new HashMap<Integer, Location>() : region;

        isStarted = true;
        tagged = null;
    }

    public boolean canJoin() {
        if (isStarted || players.size() + 1 > maxPlayers) {
            return false;
        }

        return true;
    }

    public void setStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }

    public void setTagged(UUID tagged) {
        this.tagged = tagged;
    }

    public void addPlayer(UUID uuid) {
        players.put(uuid, 0L);
        Bukkit.getPlayer(uuid).teleport(region.get(2));
    }

    public void removePlayer(UUID uuid) {
        players.remove(uuid);
        int x = ThreadLocalRandom.current().nextInt(0, 15); // THIS IS SUPPOSED TO BE A SPAWN LOCATION
        int z = ThreadLocalRandom.current().nextInt(0, 15);
        int y = Bukkit.getWorlds().get(0).getHighestBlockYAt(x, z);

        Bukkit.getPlayer(uuid).teleport(new Location(Bukkit.getWorlds().get(0), x, y, z));
    }

    public String getArenaName() {
        return arenaName;
    }

    public int getId() {
        return id;
    }

    public HashMap<UUID, Long> getPlayers() {
        return players;
    }

    public UUID getTagged() {
        return tagged;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public boolean isActivated() {
        return activated;
    }

    public HashMap<Integer, Location> getRegion() {
        return region;
    }
}
