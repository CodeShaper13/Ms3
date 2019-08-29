import com.codeshaper.ms3.api as ms3
import random

# Bind this script to an entity.

def onBind(world, theEntity):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.entity.Base)
    
    if isinstance(theEntity, ms3.entity.Living):
        assert isinstance(theEntity, ms3.entity.Living)
        
        theEntity.setSlotContents(ms3.equipmentSlot.MAINHAND, None) # Make sure they're not holding anything.
        theEntity.setCustomNameVisible(True)
        theEntity.setCustomName("Tic-Tac-Toe!")
    else:
        raise Exception("Script can only be bound to a living entity!")
    

def execute(world, sender):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.executor.Executor)
    
    theEntity = sender.asEntity()
    assert isinstance(theEntity, ms3.entity.Living)
        
    prop = theEntity.getProperty("ticTacToe", "opponent")
        
    if prop is not None:
        assert isinstance(prop, ms3.entity.Player)
            
        if not prop.isAlive():
            prop = None
        else:
            pass
        
    else:
        # No opponent, find a new one.
        prop = world.getClosestEntity(sender.getX(), sender.getY(), sender.getZ(), 4, ms3.entityList.PLAYER)
            
            
    theEntity.setProperty("ticTacToe", "opponent", prop);
                
        
        
    
    
    player = world.getClosestEntity(sender.getX(), sender.getY(), sender.getZ(), 256, ms3.entityList.PLAYER)
    assert isinstance(player, ms3.entity.Player)
    
    player.setInventoryStack(0, (ms3.items.COBBLESTONE, 1))
    player.setInventoryStack(1, (ms3.items.PAPER, 1))
    player.setInventoryStack(2, (ms3.items.SHEARS, 1))
    
    # print works with coloring codes, sendMessage does not
    player.sendMessage(ms3.formattingCode.YELLOW + "Pick rock paper or scissors!");
        
    ms3.util.executeDelayedScript("PycExampled/rockPaperScissors/update.py", 20, player, [3])
    ms3.util.executeDelayedScript("PycExampled/rockPaperScissors/update.py", 40, player, [2])
    ms3.util.executeDelayedScript("PycExampled/rockPaperScissors/update.py", 60, player, [1])
    ms3.util.executeDelayedScript("PycExampled/rockPaperScissors/update.py", 80, player, [0, sender])

def scrambleItem(entity):
    '''Picks and sets a random item in the Entity's hand.'''
    assert isinstance(entity, ms3.entity.Living)
    
    item = random.choice((ms3.items.COBBLESTONE, ms3.items.PAPER, ms3.items.SHEARS))
    entity.setSlotContents(ms3.equipmentSlot.MAINHAND, (item, 0, 1))