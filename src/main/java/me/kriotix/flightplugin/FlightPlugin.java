package me.kriotix.flightplugin;

import me.kriotix.flightplugin.commands.FlyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class FlightPlugin extends JavaPlugin{

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("fly").setExecutor(new FlyCommand(this));
    }

}
