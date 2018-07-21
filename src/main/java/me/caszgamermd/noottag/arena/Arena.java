package me.caszgamermd.noottag.arena;

import javax.xml.stream.Location;
import java.util.HashMap;
import java.util.UUID;

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
        this.players = players;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.activated = activated;
        this.region = region;

        isStarted = true;
        tagged = null;
    }

    public void setStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }

    public void setTagged(UUID tagged) {
        this.tagged = tagged;
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
