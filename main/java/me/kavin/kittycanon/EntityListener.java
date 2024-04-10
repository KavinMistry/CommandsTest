package me.kavin.kittycanon;

import org.bukkit.entity.Cat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EntityListener implements Listener
{

    @EventHandler
    public void PlayerTouchCat(PlayerInteractEntityEvent event)
    {
        if(event.getRightClicked() instanceof Cat)
        {
            Player player = event.getPlayer();
            Cat cat = (Cat) event.getRightClicked();
            Cat.Type x = cat.getCatType();
            if(x == Cat.Type.BLACK && cat.hasMetadata("KittyCanon"))
            {
                cat.getWorld().createExplosion(cat.getLocation(), 1F);
                event.getPlayer().getWorld().strikeLightning(event.getPlayer().getLocation());
            }
        }
    }

}