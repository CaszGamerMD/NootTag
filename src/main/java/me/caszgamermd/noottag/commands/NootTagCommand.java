package me.caszgamermd.noottag.commands;

import me.caszgamermd.noottag.arena.ArenaManager;
import me.caszgamermd.noottag.utils.PlayerState;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NootTagCommand implements CommandExecutor {

    // Inline Comments (//) Represent Pseudocode Lines

    private ArenaManager arenaManager;

    public NootTagCommand(ArenaManager arenaManager) {
        this.arenaManager = arenaManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            System.out.println("Player Not In Right World");
            return true;
        }

        Player player = (Player) sender;

        World world = player.getWorld(); //

        Location lobby = new Location(world, -15019, 85, 7385); //
        Location spawn = new Location(world, -15003, 78, 7434); //

        if (player.getWorld().getName().equalsIgnoreCase("world")) {

            System.out.println("World world confirmed"); //

            if (args.length == 0) {
                // TODO HELP MENU?
                System.out.println("Help Command Received"); //
                return true;
            }

            if (args[0].equalsIgnoreCase("join")) {

                if (PlayerState.isState(PlayerState.INLOBBY, player)) {
                    player.sendMessage("Your Already In A Lobby"); //
                    return true;
                }
                if (PlayerState.isState(PlayerState.INGAME, player)) {
                    player.sendMessage("Your Already In A Game!"); //
                    return true;
                }

                player.teleport(lobby); //
                arenaManager.getArena().addPlayer(player.getUniqueId());
                player.sendMessage("You were teleported to the LOBBY!"); //
                return true;

            }

            if (args[0].equalsIgnoreCase("leave")) {

                if (PlayerState.isState(PlayerState.INLOBBY, player)) {
                    player.sendMessage("You Left The LOBBY!"); //
                    player.teleport(spawn); //
                    arenaManager.getArena().removePlayer(player.getUniqueId());
                    return true;
                }

                if (PlayerState.isState(PlayerState.INGAME, player)) {
                    player.sendMessage("You Left The GAME!"); //
                    player.teleport(spawn); //
                    arenaManager.getArena().removePlayer(player.getUniqueId());
                    return true;
                }

                player.sendMessage("You aren't in Noot Tag."); //
                return true;
            }

            player.sendMessage("Unknown Command"); //
            return true;
        }
        return true;
    }
}
