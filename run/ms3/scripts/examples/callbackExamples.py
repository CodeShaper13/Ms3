# Doc string is used to provide a help message for the script when /script help <name>.
""" """

# Import the api
import com.codeshaper.ms3.api as ms3
import com.codeshaper.ms3.api.formattingCode as cc
import sys


# Used to initialize an entity or set properties.
# Called whenever a script is bound to an entity with the command
# /bindScript or when the bindScript function is called on an entity.
def onBind(world, theEntity):
    assert isinstance(world, ms3.world.World)
    assert isinstance(theEntity, ms3.entity.EntityBase)
    
    print ms3.formattingCode.ITALIC + "onBind()"
    
    
# Used to perform the main logic of the script.
# Called from /script run <name> util.executeDelayedScript() or repeatedly
# after a script has been bound with.
def execute(world, sender):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.executor.Executor)
    
    print ms3.formattingCode.ITALIC + "execute()"
    

# Called when an entity is clicked on and this script has been bound to it.
def onClick(world, clickedEntity, player):
    assert isinstance(world, ms3.world.World)
    # Clicked entity will refer to the entity that is clicked, thus the entity
    # that this script is bound to.
    assert isinstance(clickedEntity, ms3.entity.EntityBase)
    assert isinstance(player, ms3.entity.Player)
    
    print ms3.formattingCode.ITALIC + "onClick()"
    
    
# Returns arguments to suggest with tab when executing the script
# with /script run <name>.
def getArgs(world, sender):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.executor.Executor)
    
    print ms3.formattingCode.ITALIC + "getArgs()"
    
    # Use sys.argv to access the scripts arguments.
    i = len(sys.argv)
            
    # Note, the first argument is the path to this file, like always.

    if i == 1: # One argument already, the path, so we are onto the first command arg.
        # All args must be strings, so numbers are in quotes.
        return "one"
    elif i == 2:
        # A tuple or list can be returned for multiple args to be suggested.
        return ["two", "dos", "2",]
    
    # None can be returned, as it is implied here, to suggest nothing for TAB.