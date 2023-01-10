package com.example;

import java.util.logging.Logger;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * demo java plugin
 */
public class Plugin extends JavaPlugin {
  private static final Logger LOGGER = Logger.getLogger("demo");

  public void onEnable() {
    LOGGER.info("demo enabled");

    this.getCommand("pumpkin").setExecutor(new PumpkinCommand());
    this.getCommand("switch").setExecutor(new SwitchItemCommand());
  }

  public void onDisable() {
    LOGGER.info("demo disabled");
  }

  public boolean onCommand(CommandSender sender, Command command, String commandname, String[] args) {

    return true;

  }
}
