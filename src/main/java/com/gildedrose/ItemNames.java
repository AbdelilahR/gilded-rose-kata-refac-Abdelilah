package com.gildedrose;


public enum ItemNames {
    AGED_BRIE("Aged Brie"), SULFURAS("Sulfuras, Hand of Ragnaros"), BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED("Conjured Mana Cake"), DEFAULT("");

    public String itemDescription;

    ItemNames(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
