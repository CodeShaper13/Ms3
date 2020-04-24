"""
Spawns a Zombie Meat Trader that will trade meat for gold nuggets.

Script Usage:
    /script run examples/meatTrader.py [x] [y] [z]
    
    This will spawn a meat trader.  If the position is not passed,
    the position of the command executor will be used.
"""

import sys
import random

import com.codeshaper.ms3.api as ms3
import com.codeshaper.ms3.api.formattingCode as cc
from ms3util import argumentHelper

class MeatTrader(ms3.BoundObject):
    
    def onConstruct(self):
        '@type zombie: ms3.entity.Zombie'
        zombie = self.getEntity()
        zombie.setCustomNameVisible(True)
        zombie.setCustomName(cc.DARK_RED + "Meat Trader")
        zombie.setInvulnerable(True)
        zombie.setNoAi(True)
        zombie.setIsBaby(True)
        
        self.pickRandomTrade()
        
        # Make the Zombie have a white chestplate on.
        zombie.setSlotContents(ms3.equipmentSlot.CHEST, ms3.itemStack(ms3.items.LEATHER_CHESTPLATE, 1, 0, "{display:{color:14540253}}"))
        
        
    def onClick(self, clickingPlayer):
        '@type clickingPlayer: ms3.entity.Player'
    
        '@type playerStack: ms3.itemStack'
        playerStack = clickingPlayer.getHeldStack()
        
        if playerStack != None and playerStack.getItem() == self.itemWanted and playerStack.getCount() >= self.quantityWanted:        
            clickingPlayer.setInventoryStack(clickingPlayer.getHeldIndex(), ms3.itemStack(playerStack.getItem(), playerStack.getCount() - self.quantityWanted, playerStack.getMeta()))
            clickingPlayer.addItemStack(ms3.itemStack(ms3.items.GOLD_NUGGET, self.nuggetsGiven * self.quantityWanted))
            print cc.YELLOW + "Yum, thanks for doing business"
            self.pickRandomTrade()            
        else:
            print cc.YELLOW + "I love raw meat!  Why don't you bring me " + str(self.quantityWanted) + " " + ms3.translations.getLocalizedName(self.itemWanted, 0) + "?"


    def onTick(self):
        zombie = self.getEntity()        
        player = self.getWorld().getClosestEntity(zombie.getX(), zombie.getY(), zombie.getZ(), 5, ms3.entityList.PLAYER)
        if player != None:
            zombie.lookAt(player.getPosition(), 100, 100)


    def onLoad(self):
        self.itemWanted = self.getProperty("itemWanted")
        self.quantityWanted = self.getProperty("quantityWanted")
        self.nuggetsGiven = self.getProperty("nuggetsPerItem")        

    def onSave(self):
        self.setProperty("itemWanted", self.itemWanted)
        self.setProperty("quantityWanted", self.quantityWanted)
        self.setProperty("nuggetsPerItem", self.nuggetsGiven)
        
    
    def pickRandomTrade(self):
        """ Picks a new random trade. """
        
        possibleTrades = (
            # Item they want           Range wanted   Gold nuggets per item given
            (ms3.items.PORKCHOP,       (1,4),         4),
            (ms3.items.BEEF,           (3,5),         3),
            (ms3.items.RABBIT,         (1,2),         6),
            (ms3.items.MUTTON,         (2,4),         4),
            (ms3.items.CHICKEN,        (3,6),         3),
            (ms3.items.FISH,           (1,3),         4),
            (ms3.items.ROTTEN_FLESH,   (6,12),        1),
            )
        
        tradeData = random.choice(possibleTrades)
        
        self.itemWanted = tradeData[0]
        self.quantityWanted = random.randint(tradeData[1][0], tradeData[1][1])
        self.nuggetsGiven = tradeData[2]
        
        # Set the entity to hold the item they want.
        zombie = self.getEntity()
        zombie.setSlotContents(ms3.equipmentSlot.MAIN_HAND, ms3.itemStack(self.itemWanted))
        

def execute(world, sender):
    '@type world: ms3.world.World'
    '@type sender: ms3.executor.Executor'

    '@type zombie: ms3.entity.Zombie'    
    zombie = None
    if len(sys.argv) < 4:
        zombie = world.spawnEntity(ms3.entityList.ZOMBIE, sender.getX(), sender.getY(), sender.getZ(), None)
    else :
        zombie = world.spawnEntity(ms3.entityList.ZOMBIE, float(sys.argv[1]), float(sys.argv[2]), float(sys.argv[3]), None)
    
    zombie.bindScript("examples/meatTrader")
    
    
def getArgs(world, sender):
    return argumentHelper.getPositionArgs(sender)