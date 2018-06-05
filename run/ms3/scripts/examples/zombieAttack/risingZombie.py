import com.codeshaper.ms3.api as ms3

"""Bound to a rising zombie to update it's position and state."""

def execute(world, sender):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.executor.Executor)
    
    zombie = sender.asEntity();    
    assert isinstance(zombie, ms3.entity.Zombie)
    
    timer = zombie.getProperty("zombieAttackTimer")
    if timer == None:
        print "Property not found!"
    else:    
        if timer < 0:
            zombie.setNoAi(False)
            zombie.setInvulnerable(False)
            zombie.clearAllBoundScripts() # Removes this script.
        else:
            x = zombie.getX()
            y = zombie.getY()
            z = zombie.getZ()
            blockState = world.getBlockState(int(x), int(y) - 1, int(z))
            blockId = ms3.blockUtils.getIdFromName(blockState[0])
            
            zombie.setPosition(x, y + 0.05, z)
            
            if blockState[0] != ms3.blocks.AIR:
                world.spawnParticle(ms3.particleType.BLOCK_CRACK, x, y, z, 25, 0, 0.5, 0, 1, ms3.particleType.getParamCode(blockId, blockState[1]))
        
        timer -= 1

        zombie.setProperty("zombieAttackTimer", timer);
