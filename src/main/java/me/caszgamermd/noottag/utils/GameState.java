package me.caszgamermd.noottag.utils;

public enum GameState {

    WAITING,
    INLOBBY,
    INGAME;

    private static GameState state;

    public static void setState(GameState state)
    {
        GameState.state = state;
    }

    public static boolean isState(GameState state)
    {
        return GameState.state == state;
    }

    public static GameState getState()
    {
        return state;
    }

}
