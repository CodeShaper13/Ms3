# Example for delayed script execution.

import com.codeshaper.ms3.api as ms3

def execute(world, sender):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.executor.Executor)        
        
    scriptName = "PycExamples\getArgsExample.py"
        
    try:
        ms3.ms3.executeDelayedScript(
            scriptName, # Path to the script from the /scripts folder.
            40, #Number of ticks until the script is executed.
            sender, # An instance of pyapi.executor.Executor.
            ["arg1", "arg2"]) # Args can only be strings.
        
    except ms3.exception.missingScriptException:
        print "Script \"" + scriptName + "\" could not be found!"
        