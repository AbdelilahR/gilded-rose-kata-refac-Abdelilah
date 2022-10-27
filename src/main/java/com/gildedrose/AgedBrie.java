package com.gildedrose;

public class AgedBrie extends ItemType {
    @Override
    public void update(Item[] items, int i) {
            items[i].quality += 1;
            if (items[i].sellIn < 0) {
                items[i].quality += 1;
            }
        }
    }
