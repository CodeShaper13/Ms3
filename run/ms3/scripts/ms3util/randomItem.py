import random

import com.codeshaper.ms3.api as ms3

"""Helper functions for getting random armor.  The lists can be added to for mod item support."""

BOOTS = [ms3.items.LEATHER_BOOTS,
         ms3.items.CHAINMAIL_BOOTS,
         ms3.items.IRON_BOOTS,
         ms3.items.GOLDEN_BOOTS,
         ms3.items.DIAMOND_BOOTS]

LEGGINGS = [ms3.items.LEATHER_LEGGINGS,
         ms3.items.CHAINMAIL_LEGGINGS,
         ms3.items.IRON_LEGGINGS,
         ms3.items.GOLDEN_LEGGINGS,
         ms3.items.DIAMOND_LEGGINGS]

CHESTPLATES = [ms3.items.LEATHER_CHESTPLATE,
         ms3.items.CHAINMAIL_CHESTPLATE,
         ms3.items.IRON_CHESTPLATE,
         ms3.items.GOLDEN_CHESTPLATE,
         ms3.items.DIAMOND_CHESTPLATE]

HELMETS = [ms3.items.LEATHER_HELMET,
         ms3.items.CHAINMAIL_HELMET,
         ms3.items.IRON_HELMET,
         ms3.items.GOLDEN_HELMET,
         ms3.items.DIAMOND_HELMET]

def randomBoots():
    """Returns a random pair of boots."""
    return random.choice(BOOTS)
    
def randomLeggings():
    """Returns a random pair of leggings."""
    return random.choice(LEGGINGS)
    
def randomChestplate():
    """Returns a random chestplate."""
    return random.choice(CHESTPLATES)
    
def randomHelmet():
    """Returns a random helmet."""
    return random.choice(HELMETS)
    
    