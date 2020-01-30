package de.cas_ual_ty.magicamundi.registries;

import de.cas_ual_ty.magicamundi.MMItem;
import de.cas_ual_ty.magicamundi.MagicaMundi;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = MagicaMundi.MOD_ID, bus = Bus.MOD)
@ObjectHolder(MagicaMundi.MOD_ID)
public class MMItems
{
    public static final MMItem SPELL = null;
    
    @SubscribeEvent
    public static void register(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();
        
        registry.register(new MMItem(new Properties()).setRegistryName(MagicaMundi.MOD_ID, "spell"));
    }
}
