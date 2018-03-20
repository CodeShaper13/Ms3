import com.codeshaper.ms3.api as ms3

def execute(world, sender):
    assert isinstance(world, pyapi.world.World)
    assert isinstance(sender, pyapi.executor.Executor)
    
    zombie = world.spawnEntity(pyapi.entityList.ZOMBIE, 3, 5, 3)
    assert isinstance(zombie, pyapi.entity.Zombie)
    
    zombie.bindScript("PycExamples/boundScript/sayHello.py", ["Hello"]) # Pass an empty list or None for no args.
    zombie.bindScript("PycExamples/boundScript/sayHello.py", ["World!"])
    
    zombie.setProperty("boundScript", "prefix", 123);