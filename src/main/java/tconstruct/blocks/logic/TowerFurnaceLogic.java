package tconstruct.blocks.logic;

import tconstruct.library.blocks.AdaptiveInventoryLogic;
import tconstruct.library.util.IActiveLogic;
import tconstruct.library.util.IFacingLogic;
import tconstruct.library.util.IMasterLogic;

// Not actually abstract
public abstract class TowerFurnaceLogic extends AdaptiveInventoryLogic
    implements IActiveLogic, IFacingLogic, IMasterLogic {}
