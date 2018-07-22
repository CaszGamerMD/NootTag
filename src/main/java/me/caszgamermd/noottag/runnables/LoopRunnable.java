package me.caszgamermd.noottag.runnables;

import me.caszgamermd.noottag.arena.Arena;
import me.caszgamermd.noottag.filesystem.ConfigurationManager;
import me.caszgamermd.noottag.utils.GameState;
import org.bukkit.Bukkit;

public class LoopRunnable implements Runnable {

    private Arena arena;
    private ConfigurationManager configurationManager;

    private int countdown;
    private int internalRunnableCounter;

    public LoopRunnable(Arena arena, ConfigurationManager configurationManager) {
        this.arena = arena;
        this.configurationManager = configurationManager;

        countdown = 0;
        internalRunnableCounter = 0;
    }

    @Override
    public void run() {
        if (arena.getPlayers().isEmpty() || arena.getPlayers().size() < arena.getMinPlayers()) {
            if (arena.getPlayers().size() > 0) {
                int waitingFor = arena.getMinPlayers() - arena.getPlayers().size();

                if (internalRunnableCounter % 10 == 0) {
                    arena.getPlayers().keySet().forEach((key) -> {
                        Bukkit.getPlayer(key).sendMessage("Waiting for " + waitingFor + " players");
                    });

                    internalRunnableCounter = 0;
                }

                internalRunnableCounter += 1;
            }

            GameState.setState(GameState.WAITING);
            return;
        }

        GameState.setState(GameState.INLOBBY);

        switch (GameState.getState()) {
            case WAITING:
                countdown = 0;
                break;
            case INLOBBY:
                arena.getPlayers().keySet().forEach((key) -> {
                    Bukkit.getPlayer(key).sendMessage("Tag starts in " + countdown + " seconds"); //
                });

                countdown -= 1;
                break;
            case INGAME:
                break;
        }


    }
}
