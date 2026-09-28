package tconstruct.items.armor;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import tconstruct.library.TConstructRegistry;

public class Glove extends Item {
  public Glove(int par1) {
    super(par1);
    this.setCreativeTab(TConstructRegistry.materialTab);
  }

  @Override
  public void registerIcons(IconRegister iconRegister) {
    itemIcon = iconRegister.registerIcon("tinker:armor/dirthand");
  }
}
