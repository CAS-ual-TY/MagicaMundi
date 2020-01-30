package de.cas_ual_ty.magicamundi.provider;

import java.util.ArrayList;

import de.cas_ual_ty.magicamundi.registries.MMNodeTypes;
import de.cas_ual_ty.visibilis.node.Node;
import de.cas_ual_ty.visibilis.print.NodeListProviderBase;

public class MMNodeListProvider extends NodeListProviderBase
{
    public MMNodeListProvider()
    {
        super();
        MMNodeListProvider.mmNodes(this.list);
    }
    
    public static void mmNodes(ArrayList<Node> list)
    {
        list.add(MMNodeTypes.SELEKTOR_SENDER.instantiate());
        
        list.add(MMNodeTypes.SORTER_ENTITY.instantiate());
        list.add(MMNodeTypes.SORTER_LIVING_ENTITY.instantiate());
        list.add(MMNodeTypes.SORTER_PLAYER.instantiate());
        
        list.add(MMNodeTypes.EFFECT_FIRE.instantiate());
    }
}
