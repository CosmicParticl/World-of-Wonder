package net.msrandom.worldofwonder.world.gen.feature;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;

import java.util.Random;
import java.util.Set;

public abstract class WonderTree extends AbstractTreeFeature<BaseTreeFeatureConfig> {
    public final BaseTreeFeatureConfig config;
    protected final boolean sapling;
    protected final BlockState log;
    protected final BlockState leaves;

    @SuppressWarnings("ConstantConditions")
    public WonderTree(boolean sapling, Block log, Block leaves) {
        super(dynamic -> new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(log.getDefaultState()), new SimpleBlockStateProvider(leaves.getDefaultState())).build());
        config = createConfig(null);
        this.sapling = sapling;
        this.log = log.getDefaultState();
        this.leaves = leaves.getDefaultState();
    }

    @Override
    protected final boolean place(IWorldGenerationReader generationReader, Random rand, BlockPos pos, Set<BlockPos> p_225557_4_, Set<BlockPos> p_225557_5_, MutableBoundingBox p_225557_6_, BaseTreeFeatureConfig p_225557_7_) {
        return generationReader instanceof IBlockReader && ((IBlockReader) generationReader).getBlockState(pos.down()).getBlock() == Blocks.GRASS_BLOCK && place(generationReader, pos, rand);
    }

    public abstract boolean place(IWorldGenerationReader world, BlockPos pos, Random rand);
}
