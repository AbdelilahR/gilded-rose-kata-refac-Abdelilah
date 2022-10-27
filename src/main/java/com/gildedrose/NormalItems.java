package com.gildedrose;

public class NormalItems extends ItemType {
    @Override
    public void update(Item[] items, int i) {
        if (items[i].quality > 0) {
            items[i].quality -= 1;
            if (items[i].sellIn < 0) {
                items[i].quality -= 1;
            }
            if (items[i].quality < 0) {
                items[i].quality = 0;
            }
        }
    }
}