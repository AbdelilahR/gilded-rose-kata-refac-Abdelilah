package com.gildedrose;

import static com.gildedrose.ItemNames.*;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() throws Exception {
        validateItems(items);
        for (int i = 0; i < items.length; i++) {
            if (checkLegendaries(i)) {
                items[i].sellIn = items[i].sellIn - 1;
                performQualityCheck(i);
            }
        }
    }

    private void performQualityCheck(int i) {
        switch (getItemName(items[i].name)) {
            case AGED_BRIE:
                new AgedBrie().update(items, i);
                break;
            case BACKSTAGE_PASSES:
                new BackstagePasses().update(items, i);
                break;
            case CONJURED:
                new Conjured().update(items, i);
                break;
            default:
                new NormalItems().update(items, i);
                break;
        }
    }

    private void validateItems(Item[] items) throws Exception {
        if (items == null) {
            throw new Exception("Items cannot be null");
        }
        for (Item item : items) {
            if (item.quality < 0) {
                throw new Exception("item quality cannot be negative");
            } else if (item.quality > 50 && !item.name.contains(SULFURAS.itemDescription)) {
                throw new Exception("The Quality of an item is never more than 50");
            }
        }
    }
    /**
     * A legendary item, never has to be sold or decreases in Quality
     *
     * @param i
     * @return
     */
    private boolean checkLegendaries(int i) throws Exception {
        if (items[i].name.contains(SULFURAS.itemDescription)) {
            if (items[i].sellIn > 0) {
                throw new Exception("Sulfuras cannot be sold");
            }
            return false;
        } else {
            return true;
        }
    }
    private ItemNames getItemName(String desc) {
        for (ItemNames item : ItemNames.values()) {
            if (item.itemDescription.equals(desc)) {
                return item;
            }
        }
        return ItemNames.DEFAULT;
    }
}
