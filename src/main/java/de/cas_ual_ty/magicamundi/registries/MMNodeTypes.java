package de.cas_ual_ty.magicamundi.registries;

import de.cas_ual_ty.magicamundi.MagicaMundi;
import de.cas_ual_ty.magicamundi.node.selektor.Selektor;
import de.cas_ual_ty.magicamundi.node.sorter.SorterSimple;
import de.cas_ual_ty.magicamundi.target.TargetEntity;
import de.cas_ual_ty.visibilis.node.Node;
import de.cas_ual_ty.visibilis.node.NodeType;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = MagicaMundi.MOD_ID, bus = Bus.MOD)
@ObjectHolder(MagicaMundi.MOD_ID)
public class MMNodeTypes
{
    public static final NodeType<Node> SELEKTOR_SENDER = null;
    
    public static final NodeType<Node> SORTER_ENTITY = null;
    public static final NodeType<Node> SORTER_LIVING_ENTITY = null;
    public static final NodeType<Node> SORTER_PLAYER = null;
    
    @SubscribeEvent
    public static void register(RegistryEvent.Register<NodeType<?>> event)
    {
        IForgeRegistry<NodeType<?>> registry = event.getRegistry();
        
        registry.register(new NodeType<>(Selektor.createTypeSelektor((data, list) ->
        {
            if(data.getCommandSender().getEntity() instanceof LivingEntity)
            {
                list.add(new TargetEntity(data.getCommandSender().getEntity()));
            }
        })).setRegistryName(MagicaMundi.MOD_ID, "selektor_sender"));
        
        registry.register(new NodeType<>(SorterSimple.createSorterSimple((data, target) ->
        {
            return target instanceof TargetEntity;
        })).setRegistryName(MagicaMundi.MOD_ID, "sorter_entity"));
        
        registry.register(new NodeType<>(SorterSimple.createSorterSimple((data, target) ->
        {
            return target instanceof TargetEntity && ((TargetEntity)target).isLivingEntity();
        })).setRegistryName(MagicaMundi.MOD_ID, "sorter_living_entity"));
        
        registry.register(new NodeType<>(SorterSimple.createSorterSimple((data, target) ->
        {
            return target instanceof TargetEntity && ((TargetEntity)target).isPlayerEntity();
        })).setRegistryName(MagicaMundi.MOD_ID, "sorter_player"));
    }
}
