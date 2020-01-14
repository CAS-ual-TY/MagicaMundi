package de.cas_ual_ty.magicamundi.datatype;

import java.util.List;

import de.cas_ual_ty.magicamundi.target.Target;
import de.cas_ual_ty.visibilis.datatype.DataType;

public class MMDataType
{
    public static final DataType<List<Target>> TARGETS_LIST = new DataType<>("targets_list", new float[] { 1F, 0.5F, 1F });
}
