import com.codeshaper.ms3.api as ms3
import sys
from com.codeshaper.ms3.api import itemUtils
import math

class Test(ms3.BoundObject):
    
    #def __init__(self, e):
    #    super(Test, self).__init__(e)
    #    print "__init__(self, e)"
        
    def onTick(self):
        print "onTick(self)"
        
    def onTick(self):
        print self.getPrefix()
        
    def spam(self):
        print "spam"

def onBind(world, entity):
    print "onBind()"

def execute(world, sender):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.executor.Executor)
    
    print "execute()"
    
    from ms3util import mathUtils
    print mathUtils.distance(0, 0, 0, 10, 10, 10)
    
        
    
def unused():
    #ms3.util.printObjectType(ms3)
    
    #ms3.__dict__['spam'] = "HELLO!"
    #print ms3.spam
    w = ms3.__dict__['world']
    print w
    i = ms3.__dict__['__name__']
    print i.__dict__
    print ms3.__dict__
            
def onClick(world, clickedEntity, player):
    assert isinstance(world, ms3.world.World)
    assert isinstance(clickedEntity, ms3.entity.EntityBase)
    assert isinstance(player, ms3.entity.Player)    
            
    #world.spawnEntity(ms3.entityList.ZOMBIE, sender.getX(), sender.getY(), sender.getZ(), "{IsBaby:1}")
    #world.playSound("ambient.cave", "master", sender.getX(), sender.getY(), sender.getZ(), 1, 1)