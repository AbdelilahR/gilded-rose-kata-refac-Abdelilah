package com.gildedrose;

public class BackstagePasses extends ItemType{
    @Override
    public void update(Item[] items, int i) {
        if (items[i].sellIn < 0) {
            items[i].quality = 0;
        } else if (items[i].sellIn < 6) {
            items[i].quality += 3;
        } else if (items[i].sellIn < 11) {
            items[i].quality += 2;
        } else {
            items[i].quality += 1;
        }
        if (items[i].quality > 50) {
            items[i].quality = 50;
        }
    }
}
