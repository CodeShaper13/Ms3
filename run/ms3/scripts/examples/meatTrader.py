import random

import com.codeshaper.ms3.api as ms3
import com.codeshaper.ms3.api.formattingCode as cc

def pickRandomTrade(theEntity):
    """ Picks a new random trade and stores it as a series of properties. """
    assert isinstance(theEntity, ms3.entity.Zombie)
    
    trades = (
        # Item they want     Range wanted  Gold nuggets per item given
        (ms3.items.PORKCHOP,       (1,4),  4),
        (ms3.items.BEEF,           (3,5),  3),
        (ms3.items.RABBIT,         (1,2),  6),
        (ms3.items.MUTTON,         (2,4),  4),
        (ms3.items.CHICKEN,        (3,6),  3),
        (ms3.items.FISH,           (1,3),  4),
        (ms3.items.ROTTEN_FLESH,   (6,12), 1),
        )
    
    trade = random.choice(trades)
    
    # Set them to hold the item they want.
    theEntity.setSlotContents(ms3.equipmentSlot.MAINHAND, ms3.itemStack(trade[0]))
    
    theEntity.setProperty("meatTrader.wants", trade[0])
    theEntity.setProperty("meatTrader.quantity", random.randint(trade[1][0], trade[1][1]))
    theEntity.setProperty("meatTrader.nuggetsPerItem", trade[2])
    theEntity.setSlotContents(ms3.equipmentSlot.CHEST, ms3.itemStack(ms3.items.LEATHER_CHESTPLATE, 1, 0, "{display:{color:14540253}}"))


def onBind(world, theEntity):
    assert isinstance(world, ms3.world.World)
    assert isinstance(theEntity, ms3.entity.Zombie)
        
    theEntity.setCustomNameVisible(True)
    theEntity.setCustomName(cc.DARK_RED + "Meat Trader")
    theEntity.setInvulnerable(True)
        
    pickRandomTrade(theEntity)
    

def execute(world, sender):
    '@type world: ms3.world.World'
    '@type sender: ms3.executor.Executor'

    '@type zombie: ms3.entity.Zombie'    
    zombie = None
    if len(sys.argv) < 4:
        zombie = world.spawnEntity(ms3.entityList.ZOMBIE, sender.getX(), sender.getY(), sender.getZ(), None)
    else :
        zombie = world.spawnEntity(ms3.entityList.ZOMBIE, float(sys.argv[1]), float(sys.argv[2]), float(sys.argv[3]), None)
    
    zombie.bindScript("")
    

def onClick(world, clickedEntity, player):
    assert isinstance(world, ms3.world.World)
    assert isinstance(clickedEntity, ms3.entity.Base)
    assert isinstance(player, ms3.entity.Player)
        
    tradeItemWanted = clickedEntity.getProperty("meatTrader.wants")
    tradeQuantWanted = clickedEntity.getProperty("meatTrader.quantity")
    tradeNugsGiven = clickedEntity.getProperty("meatTrader.nuggetsPerItem")
    
    playerStack = player.getHeldStack()
    assert isinstance(playerStack, ms3.itemStack)
    
    if playerStack != None and playerStack.getItem() == tradeItemWanted and playerStack.getCount() >= tradeQuantWanted:        
        player.setInventoryStack(player.getHeldIndex(), ms3.itemStack(playerStack.getItem(), playerStack.getCount() - tradeQuantWanted, playerStack.getMeta()))
        player.addItemStack(ms3.itemStack(ms3.items.GOLD_NUGGET, tradeNugsGiven * tradeQuantWanted))
        print cc.YELLOW + "Yum, thanks for doing business"
        pickRandomTrade(clickedEntity)            
    else:
        print cc.YELLOW + "I love raw meat!  Why don't you bring me " + str(tradeQuantWanted) + " " + ms3.translations.getLocalizedName(tradeItemWanted, 0) + "?"