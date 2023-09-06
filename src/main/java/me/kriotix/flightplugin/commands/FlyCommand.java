package me.kriotix.flightplugin.commands;

import me.kriotix.flightplugin.FlightPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {

    //Keeps track of flying players for toggling
    private ArrayList<Player> flyingPlayerList = new ArrayList<>();
    private FlightPlugin plugin;
    public FlyCommand(FlightPlugin plugin){
        this.plugin = plugin;
    }

    //The command itself
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
       //Won't activate if not a player
        if (!(commandSender instanceof Player))
            return true;

        //Assigns the associated player to a player variable
        Player player = (Player) commandSender;

        //Won't be used if no permission
        if (!player.hasPermission("flightplugin.fly")) {
            player.sendMessage("You do not have permission.");
            return true;
        }

        //If not currently flying
        if (!flyingPlayerList.contains(player)) {

            //Turns on the fly
            player.setAllowFlight(true);
            player.sendMessage("Flight enabled.");

            //Adds to the flying players list
            flyingPlayerList.add(player);
        }

        //If already flying
        else {

            //Disables flight
            player.setAllowFlight(false);
            player.sendMessage("Flight disabled.");

            //Removed from flying player list
            flyingPlayerList.remove(player);
        }
        return true;
    }
}
