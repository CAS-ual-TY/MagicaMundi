package de.cas_ual_ty.magicamundi.registries;

import java.util.List;

import de.cas_ual_ty.magicamundi.MagicaMundi;
import de.cas_ual_ty.magicamundi.target.Target;
import de.cas_ual_ty.visibilis.datatype.DataType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = MagicaMundi.MOD_ID, bus = Bus.MOD)
@ObjectHolder(MagicaMundi.MOD_ID)
public class MMDataTypes
{
    public static final DataType<List<Target>> TARGETS_LIST = null;
    
    @SuppressWarnings("unchecked")
    @SubscribeEvent
    public static void register(RegistryEvent.Register<DataType<?>> event)
    {
        IForgeRegistry<DataType<?>> registry = event.getRegistry();
        
        registry.register(new DataType<List<Target>>(new float[] { 1F, 0.5F, 1F }, (length) -> new List[length]).setRegistryName(MagicaMundi.MOD_ID, "targets_list"));
    }
}
