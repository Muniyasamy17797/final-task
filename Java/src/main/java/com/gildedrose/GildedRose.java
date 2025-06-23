package com.gildedrose;

/**
 * The GildedRose class manages an array of items and updates their quality using the Strategy pattern.
 */
class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * Updates the quality and sellIn of all items using their respective strategies.
     */
    public void updateQuality() {
        for (Item item : items) {
            getStrategy(item).update(item);
        }
    }

    /**
     * Selects the appropriate update strategy for the given item.
     * @param item The item to update
     * @return The update strategy
     */
    private UpdateStrategy getStrategy(Item item) {
        if (item.name.equals("Aged Brie")) {
            return new AgedBrieStrategy();
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePassStrategy();
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new SulfurasStrategy();
        } else if (item.name.toLowerCase().contains("conjured")) {
            return new ConjuredStrategy();
        } else {
            return new DefaultStrategy();
        }
    }
}
