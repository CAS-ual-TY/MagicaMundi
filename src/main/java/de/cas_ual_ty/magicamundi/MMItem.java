package de.cas_ual_ty.magicamundi;

import de.cas_ual_ty.magicamundi.provider.MMDataProvider;
import de.cas_ual_ty.magicamundi.provider.MMNodeListProvider;
import de.cas_ual_ty.visibilis.Visibilis;
import de.cas_ual_ty.visibilis.print.NodeListProvider;
import de.cas_ual_ty.visibilis.print.item.ItemPrintClickable;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
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
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        
        if(worldIn.isRemote)
        {
            return new ActionResult<>(ActionResultType.PASS, itemstack);
        }
        
        if(this.getPrint(itemstack).executeEvent(Visibilis.MOD_ID, "right_click", new MMDataProvider(playerIn.getCommandSource())))
        {
            return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
        }
        else
        {
            return new ActionResult<>(ActionResultType.FAIL, itemstack);
        }
    }
    
    @Override
    public NodeListProvider getNodeList(ItemStack itemStack, int slot)
    {
        return new MMNodeListProvider();
    }
}
