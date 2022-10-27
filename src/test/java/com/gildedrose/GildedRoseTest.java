package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class GildedRoseTest {

    @Test
    void updateQuality() throws Exception {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void itemQuality_cannot_be_null() {
        try {
            Item[] items = null;
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            fail();
        } catch (Exception e) {
            assertEquals("Items cannot be null", e.getMessage());
        }
    }

    @Test
    void normalItemQuality_sell_date_has_passed_thus_degrade_2x_faster() throws Exception {
        int quality = 8;
        int sellIn = -1;
        Item[] items = new Item[]{new Item("", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality, app.items[0].quality);
        assertEquals(sellIn, app.items[0].sellIn);
    }

    @Test
    void itemQuality_can_never_be_negative() {
        try {
            Item[] items = new Item[]{new Item("", 4, -1)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            fail();
        } catch (Exception e) {
            assertEquals("item quality cannot be negative", e.getMessage());
        }
    }

    @Test
    void agedBrieQuality() throws Exception {
        int quality = 1;
        int sellIn = 1;
        Item[] items = new Item[]{new Item("Aged Brie", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality, app.items[0].quality);
        assertEquals(sellIn, app.items[0].sellIn);
    }

    @Test
    void itemsQuality_cannot_be_greater_then_50() throws Exception {
        try {
            Item[] items = new Item[]{new Item("", 1, 51)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            fail();
        } catch (Exception e) {
            assertEquals("The Quality of an item is never more than 50", e.getMessage());
        }
    }


    @Test
    void sulfurasQuality_cannot_decrease() throws Exception {
        int quality = 80;
        int sellIn = 0;
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality, app.items[0].quality);
        assertEquals(sellIn, app.items[0].sellIn);
    }

    @Test
    void sulfuras_cannot_be_sold() throws Exception {
        try {
            Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 80)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            fail();
        } catch (Exception e) {
            assertEquals("Sulfuras cannot be sold", e.getMessage());
        }
    }


    @Test
    void backstagePassesQuality_Increase_By_2() throws Exception {
        int quality = 3;
        int sellIn = 9;
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality, app.items[0].quality);
        assertEquals(sellIn, app.items[0].sellIn);
    }

    @Test
    void backstagePassesQuality_Increase_By_3() throws Exception {
        int quality = 4;
        int sellIn = 2;
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 3, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality, app.items[0].quality);
        assertEquals(sellIn, app.items[0].sellIn);
    }

    @Test
    void conjuredQuality() throws Exception {
        int quality = 4;
        int sellIn = 2;
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 3, 6)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality, app.items[0].quality);
        assertEquals(sellIn, app.items[0].sellIn);
    }
}
