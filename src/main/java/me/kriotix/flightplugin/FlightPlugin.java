package me.kriotix.flightplugin;

import me.kriotix.flightplugin.commands.FlyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class FlightPlugin extends JavaPlugin{

    @Override
    public void onEnable() {
        // Registering the commmand
        getCommand("fly").setExecutor(new FlyCommand(this));
    }

}
