package me.caszgamermd.noottag.utils;

import org.bukkit.entity.Player;

public enum PlayerState {

    INLOBBY,
    INGAME;

    private static PlayerState state;

    public static void setState(PlayerState state)
    {
        PlayerState.state = state;
    }

    public static boolean isState(PlayerState state, Player player)
    {
        return PlayerState.state == state;
    }

    public static PlayerState getState()
    {
        return state;
    }
}
