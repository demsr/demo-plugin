package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class SwitchItemCommand implements CommandExecutor {

    private static final Logger LOGGER = Logger.getLogger("demo");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Here we need to give items to our player

            PlayerInventory playerInventory = player.getInventory();

            int indexA = 0;
            int indexB = 0;

            Map<Enchantment, Integer> enchmap;
            ItemStack handItem = playerInventory.getItem(EquipmentSlot.HAND);

            LOGGER.info("HAND: " + handItem);

            for (int i = 0; i <= 60; i++) {

                ItemStack itemStack = playerInventory.getItem(i);

                if (itemStack != null) {

                    enchmap = itemStack.getEnchantments();

                    for (Map.Entry<Enchantment, Integer> entry : enchmap.entrySet()) {
                        LOGGER.info("Enchantment " + Enchantment.getByKey(entry.getKey().getKey()) + " on index "
                                + String.valueOf(i));
                    }

                    if (itemStack.getType() == Material.DIAMOND_PICKAXE
                            && itemStack.containsEnchantment(Enchantment.SILK_TOUCH)) {

                        LOGGER.info("SILK_TOUCH FOUND ON " + String.valueOf(i));
                        indexA = i;
                    }

                    if (itemStack.getType() == Material.DIAMOND_PICKAXE
                            && itemStack.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
                        LOGGER.info("LOOT_BONUS_BLOCKS FOUND ON " + String.valueOf(i));
                        indexB = i;
                    }
                }

            }
            LOGGER.info("indexA " + String.valueOf(indexA) + "indexB " + String.valueOf(indexB));
            if (indexA > 0 && indexB > 0) {
                LOGGER.info("SWITCH INV INDEXES ");
                ItemStack iA = playerInventory.getItem(indexA);
                ItemStack iB = playerInventory.getItem(indexB);

                playerInventory.setItem(indexA, iB);
                playerInventory.setItem(indexB, iA);

            }

        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }

}
