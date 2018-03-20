# A script that prints out a friendly message about what the player is holding.  Maybe a village would say this when a player get's close...

import random

import com.codeshaper.ms3.api as ms3
import com.codeshaper.ms3.api.formattingCode as cc

def firstWord():
    i = random.randint(0, 2)
    if i == 0:
        return "My"
    elif i == 1:
        return "Wow"
    else:
        return "Good golly"
        
def getCount(count):
    if count == 1:
        return ""
    elif count <= 16:
        return "handful of "
    elif count <= 32:
        return "bunch of "
    elif count <= 63:
        return "collection of "
    else:
        return "stack of "

def execute(world, sender):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.executor.Executor)
    
    player = world.getClosestEntity(sender.getX(), sender.getY(), sender.getZ(), 6, ms3.entityList.PLAYER)
    if player != None:
        assert isinstance(player, ms3.entity.Player)
    
        stack = player.getHeldStack();
    
        if stack == None:
            print cc.YELLOW + "Why don't you bring me something..."
        else:
            blockName = stack[0]
            count = stack[1]
            meta = stack[2]
            print cc.YELLOW + firstWord() + ", that is a nice looking " + getCount(count) + blockName.title().replace("_", " ") + " there!"