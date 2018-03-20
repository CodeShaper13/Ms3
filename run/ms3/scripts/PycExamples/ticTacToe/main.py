import com.codeshaper.ms3.api as ms3

def execute(world, sender):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.executor.Executor)
    
    # Make the board.
    for x in range(3):
        for y in range(3):
            x1 = int(sender.getX()) + x + 2
            y1 = int(sender.getY()) + y
            z1 = int(sender.getZ())
            world.setBlockState(ms3.blockList.STONE, 0, x1, y1, z1)
            world.setBlockState(ms3.blockList.WOODEN_BUTTON, 1, x1, y1, z1 + 1)
