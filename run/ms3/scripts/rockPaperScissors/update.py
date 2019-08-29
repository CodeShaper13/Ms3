import sys
import random
import com.codeshaper.ms3.api as ms3

def execute(world, sender):
    assert isinstance(world, ms3.world.World)
    assert isinstance(sender, ms3.executor.Executor)
    
    i = sys.argv[1]
    if i > 0:
        sender.showSenderMessage(ms3.formattingCode.AQUA + str(i) + "...")
    else:
        player = sender.asEntity()
        assert isinstance(player, ms3.entity.Player)
        
        item = player.getHeldStack()[0]
        if item == ms3.items.COBBLESTONE:
            pass
        elif item == ms3.items.PAPER:
            pass
        elif item == ms3.items.SHEARS:
            pass
        else:
            sender.showSenderMessage(ms3.formattingCode.AQUA + "You must pick rock, paper, or scissors!")
            return
        
        if random.randint(0, 1) == 0:
            sender.showSenderMessage(ms3.formattingCode.AQUA + "You lost!")
        else:
            sender.showSenderMessage(ms3.formattingCode.AQUA + "You won!")