package net.msrandom.worldofwonder.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockDandelionFluff extends Block {
    public BlockDandelionFluff() {
        super(Block.Properties.create(Material.WOOL).hardnessAndResistance(0.8f).sound(SoundType.CLOTH));
    }

    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        super.onFallenUpon(worldIn, pos, entityIn, fallDistance * 0.5f);
    }
}
