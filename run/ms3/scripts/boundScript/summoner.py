import com.codeshaper.ms3.api as ms3

def execute(world, sender):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.executor.Executor)
    
    zombie = world.spawnEntity(ms3.entityList.ZOMBIE, 3, 5, 3)
    assert isinstance(zombie, ms3.entity.Zombie)
    
    zombie.bindScript("boundScript/sayHello.py", ["Hello"]) # Pass an empty list or None for no args.
    zombie.bindScript("boundScript/sayHello.py", ["World!"])
    
    zombie.setProperty("boundScript", "prefix", 123);