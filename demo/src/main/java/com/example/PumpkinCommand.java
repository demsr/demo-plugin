package com.example;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PumpkinCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Here we need to give items to our player

            ItemStack pumpkins = new ItemStack(Material.PUMPKIN, 20);

            // Set the amount of the ItemStack

            player.getInventory().addItem(pumpkins);
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }

}
