package tconstruct.util;

import tconstruct.achievements.TAchievements;

import tconstruct.TConstruct;
import tconstruct.common.TContent;
import tconstruct.library.tools.AbilityHelper;
import tconstruct.util.player.TPlayerStats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.FakePlayer;
import cpw.mods.fml.common.ICraftingHandler;

public class TCraftingHandler implements ICraftingHandler
{

    @Override
    public void onCrafting (EntityPlayer player, ItemStack item, IInventory craftMatrix)
    {
        int itemID = item.getItem().itemID;
        if (!player.worldObj.isRemote)
        {
            if (itemID == TContent.toolStationWood.blockID && isRealPlayer(player))
            {
                TPlayerStats stats = TConstruct.playerTracker.getPlayerStats(player.username);
                NBTTagCompound tags = player.getEntityData().getCompoundTag("TConstruct");
                if (!tags.getBoolean("materialManual") || !stats.materialManual)
                {
                    stats.materialManual = true;
                    tags.setBoolean("materialManual", true);
                    AbilityHelper.spawnItemAtPlayer(player, new ItemStack(TContent.manualBook, 1, 1));
                }
            }
            if (itemID == TContent.smeltery.blockID || itemID == TContent.lavaTank.blockID)
            {
                if (isRealPlayer(player))
                {
                    TPlayerStats stats = TConstruct.playerTracker.getPlayerStats(player.username);
                    NBTTagCompound tags = player.getEntityData().getCompoundTag("TConstruct");
                    if (!tags.getBoolean("smelteryManual") || !stats.smelteryManual)
                    {
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
     * Machines that craft (autocrafters, Applied Energistics' Molecular Assembler, ...) use a fake
     * player. Don't give them the manuals: the book would be dropped where the fake player is,
     * usually the world spawn, again after every restart. Checking for this also avoids creating a
     * stats entry with no player for them.
     */
    private static boolean isRealPlayer (EntityPlayer player)
    {
        return player instanceof EntityPlayerMP && !(player instanceof FakePlayer);
    }

    @Override
    public void onSmelting (EntityPlayer player, ItemStack item)
    {
    }

}
