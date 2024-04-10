package me.kavin.kittycanon;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatCanon implements CommandExecutor, TabExecutor
{
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings)
    {
        if(!(commandSender instanceof Player))
        {
            commandSender.sendMessage(" You ain't him dawg ");
            return true;
        }

        boolean isBlack = false;

        if(strings.length > 1)
            return false;


        Player player = (Player) commandSender;
        Cat cat = player.getWorld().spawn(player.getLocation(), Cat.class);

        if(strings.length == 1 && strings[0].equalsIgnoreCase("black"))
        {
            cat.setCatType(Cat.Type.BLACK);
        }

        cat.setMetadata("KittyCanon", new FixedMetadataValue(KittyCanon.getInstance(), true));
        cat.setCustomNameVisible(true);

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings)
    {
        if(strings.length == 1)
            return Arrays.asList("black");

        return new ArrayList<>();
    }
}
