""" This script contains trace statements for all of the event functions used by Ms3."""

# Import the api
import com.codeshaper.ms3.api as ms3
import com.codeshaper.ms3.api.formattingCode as fc
import sys
    
    
# Used to perform the main logic of the script.
# Called from /script run <name> or util.executeDelayedScript()
def execute(world, sender):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.executor.Executor)
    
    print fc.ITALIC + "execute()"
    
    
# Returns arguments to suggest with tab when executing the script
# with /script run <name>.
def getArgs(world, sender):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.executor.Executor)
    
    print fc.ITALIC + "getArgs()"
    
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