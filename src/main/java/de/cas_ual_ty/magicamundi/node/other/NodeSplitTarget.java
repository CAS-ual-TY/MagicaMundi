package de.cas_ual_ty.magicamundi.node.other;

import de.cas_ual_ty.magicamundi.registries.MMDataTypes;
import de.cas_ual_ty.magicamundi.target.Target;
import de.cas_ual_ty.visibilis.node.ExecContext;
import de.cas_ual_ty.visibilis.node.Node;
import de.cas_ual_ty.visibilis.node.NodeType;
import de.cas_ual_ty.visibilis.node.field.Input;
import de.cas_ual_ty.visibilis.node.field.Output;
import de.cas_ual_ty.visibilis.registries.VDataTypes;
import de.cas_ual_ty.visibilis.util.VUtility;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class NodeSplitTarget extends Node
{
    public final Output<World> out1World;
    public final Output<Vec3d> out2Vector3d;
    public final Output<BlockPos> out3BlockPos;
    public final Input<Target> in1Target;
    
    protected World world;
    protected Vec3d vector3d;
    protected BlockPos blockPos;
    
    public NodeSplitTarget(NodeType<?> type)
    {
        super(type);
        this.addOutput(this.out1World = new Output<>(this, VDataTypes.WORLD, "out1"));
        this.addOutput(this.out2Vector3d = new Output<>(this, VDataTypes.VECTOR3D, "out2"));
        this.addOutput(this.out3BlockPos = new Output<>(this, VDataTypes.BLOCK_POS, "out3"));
        this.addInput(this.in1Target = new Input<>(this, MMDataTypes.TARGET, "in1"));
    }
    
    @Override
    public boolean doCalculate(ExecContext context)
    {
        Target target = this.in1Target.getValue();
        this.world = target.getWorld();
        this.vector3d = target.getPos();
        this.blockPos = target.getBlockPos();
        return true;
    }
    
    @Override
    public <O> O getOutputValue(Output<O> out)
    {
        return out == this.out1World ? VUtility.cast(this.world) : (out == this.out2Vector3d ? VUtility.cast(this.vector3d) : (out == this.out3BlockPos ? VUtility.cast(this.blockPos) : null));
    }
    
    @Override
    public float[] getColor()
    {
        return MMDataTypes.TARGET.getColor();
    }
    
    @Override
    public float[] getTextColor()
    {
        return MMDataTypes.TARGET.getTextColor();
    }
}
