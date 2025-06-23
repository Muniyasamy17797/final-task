package com.gildedrose;

/**
 * Update strategy for Conjured items (degrade in quality twice as fast).
 */
public class ConjuredStrategy implements UpdateStrategy {
    @Override
    public void update(Item item) {
        if (item.quality > 0) {
            item.quality -= 2;
            if (item.quality < 0) item.quality = 0;
        }
        item.sellIn--;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 2;
            if (item.quality < 0) item.quality = 0;
        }
    }
}
