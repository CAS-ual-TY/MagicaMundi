package de.cas_ual_ty.magicamundi;

import de.cas_ual_ty.magicamundi.provider.MMDataProvider;
import de.cas_ual_ty.magicamundi.provider.MMNodeListProvider;
import de.cas_ual_ty.visibilis.Visibilis;
import de.cas_ual_ty.visibilis.print.item.ItemPrintClickable;
import de.cas_ual_ty.visibilis.print.provider.NodeListProvider;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class MMItem extends ItemPrintClickable
{
    public MMItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public boolean isEditable(ItemStack itemStack, CommandSource source)
    {
        return true;
    }
    
    @Override
    public boolean executeEvent(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        return this.getPrint(playerIn.getHeldItem(handIn)).executeEvent(Visibilis.MOD_ID, "right_click", new MMDataProvider(playerIn.getCommandSource()));
    }
    
    @Override
    public NodeListProvider getNodeList(ItemStack itemStack, int slot)
    {
        return new MMNodeListProvider();
    }
}
