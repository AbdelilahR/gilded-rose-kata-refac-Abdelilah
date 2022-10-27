package com.gildedrose;

public class Conjured extends ItemType{
    @Override
    public void update(Item[] items, int i) {
        if (items[i].quality > 0) {
            items[i].quality -= 2;
            if (items[i].sellIn < 0) {
                items[i].quality -= 2;
            }
            if (items[i].quality < 0) {
                items[i].quality = 0;
            }
        }
    }
}
