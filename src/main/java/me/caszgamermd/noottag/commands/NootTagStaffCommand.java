package me.caszgamermd.noottag.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NootTagStaffCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            // TODO: PERMISSION NODES

            Player player = (Player) sender;

            if (args.length == 0) {
                // TODO: HELP MENU
                System.out.println("Staff Help Menu Recieved");
                return true;
            }

            if (args[0].equalsIgnoreCase("add")) {
                if (args.length == 1) {
                    /*
                    TODO: ADD ARENA TO LIST
                    Arena name should be foreced to lowercase
                    on save. There needs to be a check to validate
                    area does not exist already
                     */
                    System.out.println("Add Arena Command Recieved");
                }

                player.sendMessage("Specify Name of New Arena");
                return true;
            }

            if (args[0].equalsIgnoreCase("remove")) {
                if (args.length == 1) {
                    /*
                    TODO: REMOVE ARENA FROM LIST
                    Arena name should be foreced to lowercase
                    to be checked against the list of Arena.
                    There needs to be a check to validate
                    Arena existance
                     */
                    System.out.println("Remove Arena Command Recieved");
                }

                player.sendMessage("Specify Name of Arena to Delete");
                return true;
            }

            if (args[0].equalsIgnoreCase("set")) {

                System.out.println("Set Command Recieved");

                if (args.length == 1) {

                    // TODO: SET HELP MESSAGE
                    return true;

                }

                if (args[1].equalsIgnoreCase("region")) {
                    if (args.length == 4) {
                        /*
                        TODO: SET REGION
                        /noottagstaff||nts set aregion (arena name) (region point 1||2)
                         */
                        return true;
                    }
                    sender.sendMessage("Invalid Command Arguments");
                    return true;
                }

                if (args[1].equalsIgnoreCase("spawns")) {
                    if (args.length == 4) {
                        /*
                        TODO: SET REGION
                        /noottagstaff||nts set spawns (arena name) (spawn point 1-16)
                         */
                        return true;
                    }
                    sender.sendMessage("Invalid Command Arguments");
                    return true;
                }

                if (args[1].equalsIgnoreCase("lobbyspawn")) {
                    if (args.length == 3) {
                        /*
                        TODO: SET LOBBYSPAWN
                        /noottagstaff||nts set lobbyspawn (arena name)
                         */
                        return true;
                    }
                    sender.sendMessage("Invalid Command Arguments");
                    return true;
                }

                if (args[1].equalsIgnoreCase("min")) {
                    if (args.length == 4) {
                        /*
                        TODO: SET MINIMUM PLAYERS
                        /noottagstaff||nts set min (arena name) (min-players)
                         */
                        return true;
                    }
                    sender.sendMessage("Invalid Command Arguments");
                    return true;
                }

                if (args[1].equalsIgnoreCase("max")) {
                    if (args.length == 4) {
                        /*
                        TODO: SET MAXIMUM PLAYERS
                        /noottagstaff||nts set max (arena name) (max-players)
                         */
                        return true;
                    }
                    sender.sendMessage("Invalid Command Arguments");
                    return true;
                }

                player.sendMessage("Unknown Command");
                return true;

            }

            player.sendMessage("Unknown Command");
            return true;

        }

        sender.sendMessage("You Must Be A Player!");
        return true;

    }

}
