package tconstruct.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;

public class DamageSourceFireworkExplode extends DamageSource {

  public DamageSourceFireworkExplode(String s) {
    super(s);
    this.setDamageBypassesArmor();
  }

  public ChatMessageComponent getDeathMessage(EntityLivingBase par1EntityLivingBase) {
    return super.getDeathMessage(par1EntityLivingBase);
  }
}
