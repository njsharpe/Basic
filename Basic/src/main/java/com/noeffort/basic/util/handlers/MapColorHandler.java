package com.noeffort.basic.util.handlers;

import com.noeffort.basic.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MapColorHandler
{
    private static final Minecraft minecraft = Minecraft.getMinecraft();

    public static void registerColorHandlers()
    {
        final BlockColors blockColors = minecraft.getBlockColors();
        final ItemColors itemColors = minecraft.getItemColors();

        registerBlockColorHandlers(blockColors);
        registerItemColorHandlers(blockColors, itemColors);
    }

    private static void registerBlockColorHandlers(final BlockColors blockColors)
    {
        final IBlockColor grassColorHandler = (state, blockAccess, pos, tintIndex) ->
        {
            if (blockAccess != null && pos != null)
            {
                return BiomeColorHelper.getGrassColorAtPos(blockAccess, pos);
            }

            return ColorizerGrass.getGrassColor(0.75D, 0.8D);
        };

        blockColors.registerBlockColorHandler(grassColorHandler, BlockInit.GRASSES);
        blockColors.registerBlockColorHandler(grassColorHandler, BlockInit.LEAVES);
    }

    private static void registerItemColorHandlers(final BlockColors blockColors, final ItemColors itemColors)
    {
        final IItemColor itemBlockColorHandler = (stack, tintIndex) ->
        {
            final IBlockState state = ((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
            return blockColors.colorMultiplier(state, null, null, tintIndex);
        };

        itemColors.registerItemColorHandler(itemBlockColorHandler, BlockInit.GRASSES);
        itemColors.registerItemColorHandler(itemBlockColorHandler, BlockInit.LEAVES);
    }
}
