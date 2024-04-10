package me.kavin.kittycanon;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kit implements CommandExecutor, TabExecutor
{
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings)
    {

        if(!(commandSender instanceof Player))
        {
            commandSender.sendMessage(" Nah bro u ain't human ");
            return true;
        }

        if(strings.length > 1)
            return false;

        if(strings.length == 1 && strings[0].equalsIgnoreCase("gang"))
        {
            Player player = (Player) commandSender;

            ItemStack x = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemStack a1 = new ItemStack(Material.DIAMOND_HELMET, 1);
            ItemStack a2 = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
            ItemStack a3 = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
            ItemStack a4 = new ItemStack(Material.DIAMOND_BOOTS, 1);
            x.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 255);
            a1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 255);
            a2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 255);
            a3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 255);
            a4.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 255);
            player.getInventory().addItem(x);
            player.getEquipment().setHelmet(a1);
            player.getInventory().setChestplate(a2);
            player.getInventory().setLeggings(a3);
            player.getInventory().setBoots(a4);
            player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 1f, 1f );
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings)
    {
        if(strings.length == 1)
            return Arrays.asList("gang");

        return new ArrayList<>();
    }
}
