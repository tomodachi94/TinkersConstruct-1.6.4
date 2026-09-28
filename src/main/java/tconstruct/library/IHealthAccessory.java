package tconstruct.library;

import net.minecraft.item.ItemStack;

public interface IHealthAccessory {
  boolean canEquipItem(ItemStack item, int slot);

  int getHealthBoost(ItemStack item);
}
