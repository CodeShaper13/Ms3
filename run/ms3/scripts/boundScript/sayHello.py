import com.codeshaper.ms3.api as ms3
import sys

def execute(world, sender):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.executor.Executor)
    
    zombie = sender.asEntity()
    assert isinstance(zombie, ms3.entity.Zombie)
    
    # Prints out the second argument.
    print str(zombie.getProperty("boundScript", "prefix")) + ": " + sys.argv[1]