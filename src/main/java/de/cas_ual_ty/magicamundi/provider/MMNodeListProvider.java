package de.cas_ual_ty.magicamundi.provider;

import java.util.ArrayList;

import de.cas_ual_ty.magicamundi.registries.MMNodeTypes;
import de.cas_ual_ty.visibilis.node.Node;
import de.cas_ual_ty.visibilis.print.provider.NodeListProviderBase;

public class MMNodeListProvider extends NodeListProviderBase
{
    public MMNodeListProvider()
    {
        super();
        MMNodeListProvider.mmNodes(this.list);
    }
    
    public static void mmNodes(ArrayList<Node> list)
    {
        list.add(MMNodeTypes.SELECTOR_SENDER.instantiate());
        
        list.add(MMNodeTypes.SORTER_ENTITY.instantiate());
        list.add(MMNodeTypes.SORTER_LIVING_ENTITY.instantiate());
        list.add(MMNodeTypes.SORTER_PLAYER.instantiate());
        list.add(MMNodeTypes.SORTER_BLOCK.instantiate());
        
        list.add(MMNodeTypes.EFFECT_FIRE.instantiate());
        
        list.add(MMNodeTypes.TARGET_TO_PLAYER_OPTIONAL.instantiate());
        list.add(MMNodeTypes.ITERATE_TARGETS_LIST.instantiate());
        list.add(MMNodeTypes.SPLIT_TARGET.instantiate());
    }
}
