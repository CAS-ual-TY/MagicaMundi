package de.cas_ual_ty.magicamundi.registries;

import java.util.LinkedList;
import java.util.List;

import de.cas_ual_ty.magicamundi.MagicaMundi;
import de.cas_ual_ty.magicamundi.target.Target;
import de.cas_ual_ty.magicamundi.target.TargetEntity;
import de.cas_ual_ty.visibilis.datatype.DataType;
import de.cas_ual_ty.visibilis.registries.VDataTypes;
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
    public static final DataType<Target> TARGET = null;
    
    @SuppressWarnings("unchecked")
    @SubscribeEvent
    public static void register(RegistryEvent.Register<DataType<?>> event)
    {
        IForgeRegistry<DataType<?>> registry = event.getRegistry();
        
        registry.register(new DataType<List<Target>>(new float[] { 1F, 0.25F, 1F }, (length) -> new List[length]).setRegistryName(MagicaMundi.MOD_ID, "targets_list"));
        registry.register(new DataType<>(new float[] { 1F, 0.5F, 1F }, (length) -> new Target[length]).setRegistryName(MagicaMundi.MOD_ID, "target"));
    }
    
    // Called from FMLCommonSetupEvent
    public static void addConverters()
    {
        MMDataTypes.TARGET.registerConverter(VDataTypes.PLAYER, TargetEntity::new);
        MMDataTypes.TARGETS_LIST.registerConverter(MMDataTypes.TARGET, (target) ->
        {
            List<Target> list = new LinkedList<>();
            list.add(target);
            return list;
        });
        VDataTypes.VECTOR3D.registerConverter(MMDataTypes.TARGET, (target) -> target.getPos());
        VDataTypes.BLOCK_POS.registerConverter(MMDataTypes.TARGET, (target) -> target.getBlockPos());
        MMDataTypes.TARGET.registerConverter(VDataTypes.PLAYER, (player) -> new TargetEntity(player));
    }
}
