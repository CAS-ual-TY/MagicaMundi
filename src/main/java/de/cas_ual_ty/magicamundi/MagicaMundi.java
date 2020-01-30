package de.cas_ual_ty.magicamundi;

import de.cas_ual_ty.magicamundi.registries.MMDataTypes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MagicaMundi.MOD_ID)
public class MagicaMundi
{
    public static final String MOD_ID = "magicamundi";
    
    public MagicaMundi instance;
    
    public MagicaMundi()
    {
        this.instance = this;
        
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
    }
    
    public void setup(FMLCommonSetupEvent event)
    {
        MMDataTypes.addConverters();
    }
    
    public static void warn(String s)
    {
        System.err.println(s);
    }
}
