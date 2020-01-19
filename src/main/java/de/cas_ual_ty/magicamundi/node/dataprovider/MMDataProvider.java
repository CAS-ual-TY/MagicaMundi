package de.cas_ual_ty.magicamundi.node.dataprovider;

import de.cas_ual_ty.magicamundi.target.Target;
import de.cas_ual_ty.visibilis.node.dataprovider.DataProvider;
import net.minecraft.command.CommandSource;

public class MMDataProvider extends DataProvider
{
    public MMDataProvider(CommandSource commandSender)
    {
        super(commandSender);
    }
    
    public Target getSource()
    {
        return null;
    } // TODO
    
    public Target getLatestSender()
    {
        return null;
    } // TODO
}
