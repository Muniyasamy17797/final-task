package com.gildedrose;

/**
 * Default update strategy for normal items.
 */
public class DefaultStrategy implements UpdateStrategy {
    @Override
    public void update(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
        item.sellIn--;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }
}
