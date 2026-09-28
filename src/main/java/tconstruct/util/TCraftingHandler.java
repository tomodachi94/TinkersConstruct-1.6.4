package tconstruct.util;

import cpw.mods.fml.common.ICraftingHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.FakePlayer;
import tconstruct.TConstruct;
import tconstruct.achievements.TAchievements;
import tconstruct.common.TContent;
import tconstruct.library.tools.AbilityHelper;
import tconstruct.util.player.TPlayerStats;

public class TCraftingHandler implements ICraftingHandler {

  @Override
  public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
    int itemID = item.getItem().itemID;
    if (!player.worldObj.isRemote) {
      if (itemID == TContent.toolStationWood.blockID && isRealPlayer(player)) {
        TPlayerStats stats = TConstruct.playerTracker.getPlayerStats(player.username);
        NBTTagCompound tags = player.getEntityData().getCompoundTag("TConstruct");
        if (!tags.getBoolean("materialManual") || !stats.materialManual) {
          stats.materialManual = true;
          tags.setBoolean("materialManual", true);
          AbilityHelper.spawnItemAtPlayer(player, new ItemStack(TContent.manualBook, 1, 1));
        }
      }
      if (itemID == TContent.smeltery.blockID || itemID == TContent.lavaTank.blockID) {
        if (isRealPlayer(player)) {
          TPlayerStats stats = TConstruct.playerTracker.getPlayerStats(player.username);
          NBTTagCompound tags = player.getEntityData().getCompoundTag("TConstruct");
          if (!tags.getBoolean("smelteryManual") || !stats.smelteryManual) {
            stats.smelteryManual = true;
            tags.setBoolean("smelteryManual", true);
            AbilityHelper.spawnItemAtPlayer(player, new ItemStack(TContent.manualBook, 1, 2));
          }
        }
        player.addStat(TAchievements.achievements.get("tconstruct.smelteryMaker"), 1);
      }
    }
  }

  /**
   * Determines whether a "player" is a real player or a fake player.
   * Fake players are used for things like machines and sometimes need
   * to be treated differently from real players.
   * @see net.minecraftforge.common.FakePlayer
   * @return <code>true</code> if the player is real; <code>false</code> otherwise.
   */
  private static boolean isRealPlayer(EntityPlayer player) {
    return player instanceof EntityPlayerMP && !(player instanceof FakePlayer);
  }

  @Override
  public void onSmelting(EntityPlayer player, ItemStack item) {}
}
