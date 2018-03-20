import random

import com.codeshaper.ms3.api as ms3
import com.codeshaper.ms3.api.formattingCode as cc

def pickRandomTrade(theEntity):
    """ Picks a new random trade and stores it as a property. """
    assert isinstance(theEntity, ms3.entity.Zombie)
    
    trades = (
        # Item they want        Range wanted  Gold nuggets per item given
        (ms3.items.PORKCHOP,       (1,4),  4),
        (ms3.items.BEEF,           (3,5),  3),
        (ms3.items.RABBIT,         (1,2),  6),
        (ms3.items.MUTTON,         (2,4),  4),
        (ms3.items.CHICKEN,        (3,6),  3),
        (ms3.items.FISH,           (1,3),  4),
        (ms3.items.ROTTEN_FLESH,   (6,12), 1),
        )
    
    trade = random.choice(trades)
    
    theEntity.setSlotContents(ms3.equipmentSlot.MAINHAND, (trade[0],))
    
    theEntity.setProperty("meatTrader.wants", trade[0])
    theEntity.setProperty("meatTrader.quantity", random.randint(trade[1][0], trade[1][1]))
    theEntity.setProperty("meatTrader.nuggetsPerItem", trade[2])


def onBind(world, theEntity):
    assert isinstance(world, ms3.world.World)
    assert isinstance(theEntity, ms3.entity.Zombie)
        
    theEntity.setCustomNameVisible(True)
    theEntity.setCustomName(cc.DARK_RED + "Meat Trader")
    theEntity.setInvulnerable(True)
    
    pickRandomTrade(theEntity)
    

def onClick(world, clickedEntity, player):
    assert isinstance(world, ms3.world.World)
    assert isinstance(clickedEntity, ms3.entity.EntityBase)
    assert isinstance(player, ms3.entity.Player)
        
    tradeItemWanted = clickedEntity.getProperty("meatTrader.wants")
    tradeQuantWanted = clickedEntity.getProperty("meatTrader.quantity")
    tradeNugsGiven = clickedEntity.getProperty("meatTrader.nuggetsPerItem")
    
    playerStack = player.getHeldStack()
    
    if playerStack != None and playerStack[0] == tradeItemWanted and playerStack[1] >= tradeQuantWanted:
        player.setInventoryStack(player.getHeldIndex(), (playerStack[0], playerStack[1] - tradeQuantWanted, playerStack[2]))
        player.addItemStack((ms3.items.GOLD_NUGGET, tradeNugsGiven * tradeQuantWanted))
        print cc.YELLOW + "Yum, thanks for doing business"
        pickRandomTrade(clickedEntity)            
    else:
        print cc.YELLOW + "I love raw meat!  Why don't you bring me " + str(tradeQuantWanted) + " " + ms3.translations.getLocalizedName(tradeItemWanted, 0) + "?"