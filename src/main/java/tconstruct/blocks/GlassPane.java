package tconstruct.blocks;

import net.minecraft.block.material.Material;
import tconstruct.library.TConstructRegistry;

public class GlassPane extends PaneBase {
  static String blockTextures[] = {"glass_clear", "soulglass", "soulglass_clear"};

  public GlassPane(int id) {
    super(id, Material.glass, "glass/", blockTextures);
    this.setHardness(0.3F);
    this.setStepSound(soundGlassFootstep);
    this.setUnlocalizedName("tconstruct.glasspane");
    this.setCreativeTab(TConstructRegistry.blockTab);
  }
}
