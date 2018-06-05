import com.codeshaper.ms3.api as ms3
import sys

def execute(world, sender):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.executor.Executor)
        
    print "Value of sys.argv:"
        
    i = 0
    for arg in sys.argv:        
        print str(i) + ":    " + arg
        i += 1
    
def getArgs(world, sender):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.executor.Executor) 
    
    i = len(sys.argv)
            
    # First argument is the path to this file, like always,

    if i == 1: # One argument already
        return "one"
    elif i == 2:
        return ["two", "dos", "2",] # Note, numbers are in quotes
    elif i == 3 or i == 4:
        returnList = ["three"]
        if sys.argv[2] == "dos":
            returnList.append("Tres")
        return returnList
    
    # None can be returned, as it is implied here, to suggest nothing on TAB.
    
def getHelpText():
    print "pre"
    return "Help text HERE 123456"