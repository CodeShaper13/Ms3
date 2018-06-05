import sys
import random

import com.codeshaper.ms3.api as ms3

"""When run, randomly creates a Zombie attack.  First arg is chance for each player to be attacked, 0-100, default is 100."""

def execute(world, sender):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.executor.Executor)
    
    x = sender.getX()
    y = sender.getY()
    z = sender.getZ()
    r = 256
    
    attackChance = 100
        
    if len(sys.argv) >= 2:
        attackChance = sys.argv[1]
        assert isinstance(attackChance, int)
            
    # Look for players to spawn a swarm for.
    playerList = world.getAllEntites(x - r, y - r, z - r, x + r, y + r, z + r, ms3.entityList.PLAYER)
    for player in playerList:
        assert isinstance(player, ms3.entity.Player)
        
        if True: #random.randint(1, 100) > attackChance:
            distance = 10
            spawnedCount = 0
            for pos in ((distance, 0, 90), (0, distance, 180), (-distance, 0, 270), (0, -distance, 0)):
            
                # Find the ground
                x1 = (int)(player.getX() + pos[0])
                y1 = (int)(player.getY() - 2)
                z1 = (int)(player.getZ() + pos[1])
            
                # Search for a free spot on the y axis
                i = 0
                for j in range(10):
                    block = world.getBlockState(x1, y1 + i + 2, z1)[0]
                    if block not in [ms3.blocks.AIR]:
                        if i < 0:
                            i = abs(i)
                        else:
                            i = -(abs(i) + 1)
                    else:
                        # Summon the Zombie
                        zombie = world.spawnEntity(ms3.entityList.ZOMBIE, x1, y1 + i, z1, None)
                        assert isinstance(zombie, ms3.entity.Zombie)
            
                        zombie.setSlotContents(ms3.equipmentSlot.FEET, ms3.itemStack(ms3.items.LEATHER_BOOTS))
                        zombie.setSlotContents(ms3.equipmentSlot.LEGS, ms3.itemStack(ms3.items.LEATHER_LEGGINGS))
                        zombie.setSlotContents(ms3.equipmentSlot.CHEST, ms3.itemStack(ms3.items.LEATHER_CHESTPLATE))
                        zombie.setSlotContents(ms3.equipmentSlot.HEAD, ms3.itemStack(ms3.items.LEATHER_HELMET))
                        zombie.setNoAi(True)
                        zombie.setInvulnerable(True)
                        zombie.setIsBaby(False) # Make sure they're all adults.
                        zombie.bindScript("examples/zombieAttack/risingZombie.py", [])
                        zombie.setRotation(pos[2], 0) # Face the player
                                
                        zombie.setProperty("zombieAttackTimer", 40)
                    
                        spawnedCount += 1
                    
                        break;
        
            if spawnedCount > 0:
                world.playSound(ms3.sounds.ENTITY_ZOMBIE_AMBIENT, ms3.soundCategories.HOSTILE, player.getX(), player.getY(), player.getZ(), 5, 1)
        
        