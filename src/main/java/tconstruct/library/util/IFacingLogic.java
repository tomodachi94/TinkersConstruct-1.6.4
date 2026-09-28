package tconstruct.library.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.common.ForgeDirection;

public interface IFacingLogic {
  byte getRenderDirection();

  ForgeDirection getForgeDirection();

  @Deprecated
  void setDirection(int side);

  @Deprecated
  void setDirection(float yaw, float pitch, EntityLivingBase player);

  /** This will be added next version
   * public void setDirection(int side, float yaw, float pitch, EntityLivingBase player); */
}
