package twilightforest.structures.hollowtree;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.structures.StructureTFComponent;

import java.util.List;
import java.util.Random;

public abstract class StructureTFTreeComponent extends StructureTFComponent
{
	public StructureTFTreeComponent() {}

	public StructureTFTreeComponent(int i) {
		super(i);
	}

	public abstract boolean addComponentParts(World world, Random random, StructureBoundingBox sbb, boolean drawLeaves);

	/**
	 * Checks a potential branch bounding box to see if it intersects a leaf dungeon
	 */
	protected boolean branchIntersectsDungeon(StructureTFTreeComponent branch, List<StructureComponent> list)
	{
		for (StructureComponent component : list) {
			if (component instanceof ComponentTFHollowTreeLeafDungeon && component.getBoundingBox().intersectsWith(branch.getBoundingBox())) {
				return true;
			}
		}
		// did not find intersecting dungeon
		return false;
	}

	/**
	 * Puts a block only if leaves can go there.
	 */
	protected void placeLeafBlock(World world, IBlockState blockState, int x, int y, int z, StructureBoundingBox sbb) {
		final BlockPos pos = getBlockPosWithOffset(x, y, z);

		if (sbb.isVecInside(pos)) {
			IBlockState whatsThere = world.getBlockState(pos);

			if (whatsThere.getBlock().canBeReplacedByLeaves(whatsThere, world, pos) && whatsThere.getBlock() != blockState.getBlock()) {
				world.setBlockState(pos, blockState, 2);
			}
		}
	}
}
