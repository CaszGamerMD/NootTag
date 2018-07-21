package me.caszgamermd.noottag.commands;

import me.caszgamermd.noottag.utils.PlayerState;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NootTagCommand implements CommandExecutor {

    // Inline Comments (//) Represent Pseudocode Lines

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            World world = player.getWorld(); //
            Location lobby = new Location(world, -15019, 85, 7385); //
            Location spawn = new Location(world, -15003, 78, 7434); //

            if (player.getWorld().getName().equalsIgnoreCase("world")) {

                System.out.println("World world confirmed");

                if (args.length == 0) {
                    // TODO HELP MENU?
                    System.out.println("Help Command Received"); //
                    return true;
                }

                if (args[0].equalsIgnoreCase("join")) {
                    player.teleport(lobby); //
                    if (PlayerState.isState(PlayerState.INLOBBY, player)) {
                        player.sendMessage("Your Already In A Lobby"); //
                        return true;
                    }

                    if (PlayerState.isState(PlayerState.INGAME, player)) {
                        player.sendMessage("Your Already In A Game!"); //
                        return true;
                    }

                    player.sendMessage("You were teleported to the LOBBY!"); //
                    return true;

                }

                if (args[0].equalsIgnoreCase("leave")) {
                    player.teleport(spawn); //
                    if (PlayerState.isState(PlayerState.INLOBBY, player)) {
                        player.sendMessage("You Left The LOBBY!"); //
                        return true;
                    }

                    if (PlayerState.isState(PlayerState.INGAME, player)) {
                        player.sendMessage("You Left The GAME!"); //
                        return true;
                    }
                    return true;
                }

                player.sendMessage("Unknown Command"); //
                return true;
            }

            System.out.println("Player Not In Right World");
            return true;

        }
        return true;
    }
}
