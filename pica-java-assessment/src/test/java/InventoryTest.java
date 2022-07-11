import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

//Inventory Test provides JUnit testing for each piece of functionality of the Guilded Rose project
public class InventoryTest {

	//tests that Sulfuras  never change their quality despite their age 
    @Test
    public void should_never_changes_quailty_of_Sulfuras() throws Exception {
        Item sulfuras = new Item("Sulfuras", 0, 80);

        Inventory sut = new Inventory(new Item[]{sulfuras});
        sut.updateQuality();

        assertEquals(80, sulfuras.getQuality());
    }
    //tests that Sulfuras  never change their sellIn despite their age 
    @Test
    public void should_never_changes_sellIn_of_Sulfuras() throws Exception {
        Item sulfuras = new Item("Sulfuras", 0, 80);

        Inventory sut = new Inventory(new Item[]{sulfuras});
        sut.updateQuality();

        assertEquals(0, sulfuras.getSellIn());
    }
    //tests that the sellIn value is lowered by 1 for one call to updateQuality for a normal item
    @Test
    public void should_lower_the_sellIn_by_one_for_normal_items() throws Exception {
        Item normalItem = new Item("Vest", 10, 20);

        Inventory sut = new Inventory(new Item[]{normalItem});
        sut.updateQuality();

        assertEquals(9, normalItem.getSellIn());
    }
    //tests that the quality value is lowered by 1 for one call to updateQuality for a normal item
    @Test
    public void should_lower_the_quality_by_one_for_normal_items() throws Exception {
        Item normalItem = new Item("Vest", 10, 20);

        Inventory sut = new Inventory(new Item[]{normalItem});
        sut.updateQuality();

        assertEquals(19, normalItem.getQuality());
    }
    /*tests that the quality value is not lowered below 0 for one call to 
    updateQuality for a normal item*/
    @Test
    public void should_not_lower_the_quality_below_zero() throws Exception {
        Item normalItem = new Item("Vest", 10, 0);

        Inventory sut = new Inventory(new Item[]{normalItem});
        sut.updateQuality();

        assertEquals(0, normalItem.getQuality());
    }
    /*tests that the quality value is lowered by 2 for one call to updateQuality for a normal 
     * item when the sellIn date is passed*/
    @Test
    public void should_lower_the_quality_twice_as_fast_once_the_sell_in_date_has_passed() throws Exception {
        Item normalItem = new Item("Vest", -1, 25);

        Inventory sut = new Inventory(new Item[]{normalItem});
        sut.updateQuality();

        assertEquals(23, normalItem.getQuality());
    }
    //tests that the quality value is increased by 1 for one call to updateQuality on Aged Brie
    @Test
    public void should_increase_the_quality_of_aged_brie_as_it_gets_older() throws Exception {
        Item agedBrie = new Item("Aged Brie", 10, 25);

        Inventory sut = new Inventory(new Item[]{agedBrie});
        sut.updateQuality();

        assertEquals(26, agedBrie.getQuality());
    }
    /*tests that the quality value is NOT increased for one call to updateQuality on Aged Brie 
    with a quality at 50*/
    @Test
    public void should_not_increase_the_quality_of_aged_brie_over_50() throws Exception {
        Item agedBrie = new Item("Aged Brie", 10, 50);

        Inventory sut = new Inventory(new Item[]{agedBrie});
        sut.updateQuality();

        assertEquals(50, agedBrie.getQuality());
    }
    /*tests that the quality value is lowered to 0 for one call to updateQuality on Backstage passes
    with a sellIn value -1*/
    @Test
    public void should_lower_backstage_passes_to_zero_quality_once_concert_has_happened() throws Exception {
        Item backStagePass = new Item("Backstage passes", -1, 20);

        Inventory sut = new Inventory(new Item[]{backStagePass});
        sut.updateQuality();

        assertEquals(0, backStagePass.getQuality());
    }
    /*tests that the quality value is increased by 1 for one call to updateQuality on Backstage passes
    with a sellIn value greater than 10*/
    @Test
    public void should_increase_backstage_passes_quality_by_1_when_the_concert_is_more_than_10_days_away() throws Exception {
        Item backStagePass = new Item("Backstage passes", 11, 20);

        Inventory sut = new Inventory(new Item[]{backStagePass});
        sut.updateQuality();

        assertEquals(21, backStagePass.getQuality());
    }
    /*tests that the quality value is increased by 2 for one call to updateQuality on Backstage 
    passes with a sellIn value equal to or less than 10*/
    @Test
    public void should_increase_backstage_passes_quality_by_2_when_the_concert_is_10_days_or_less_away() throws Exception {
        Item backStagePass = new Item("Backstage passes", 10, 27);

        Inventory sut = new Inventory(new Item[]{backStagePass});
        sut.updateQuality();

        assertEquals(29, backStagePass.getQuality());
    }
    /*tests that the quality value is increased by 3 for one call to updateQuality on Backstage passes
    with a sellIn value equal to or less than 5*/
    @Test
    public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away() throws Exception {
        Item backStagePass = new Item("Backstage passes", 5, 44);

        Inventory sut = new Inventory(new Item[]{backStagePass});
        sut.updateQuality();

        assertEquals(47, backStagePass.getQuality());
    }
    /*tests that the quality value is NOT increased for one call to updateQuality on Backstage passes
   	beyond 50*/
    @Test
    public void should_not_increase_backstage_passes_above_a_quality_of_50() throws Exception {
        Item backStagePassMoreThan10DaysAway = new Item("Backstage passes", 15, 50);

        Item backStagePass10DaysAway = new Item("Backstage passes", 5, 49);
        Item backStagePass5DaysAway = new Item("Backstage passes", 5, 48);

        Inventory sut = new Inventory(new Item[]{backStagePassMoreThan10DaysAway, backStagePass10DaysAway, backStagePass5DaysAway});

        sut.updateQuality();

        assertEquals(50, backStagePassMoreThan10DaysAway.getQuality());
        assertEquals(50, backStagePass10DaysAway.getQuality());
        assertEquals(50, backStagePass5DaysAway.getQuality());
    }
    
    /*this series of tests test that the quality value is modified by twice as much as it otherwise would be with one call to updateQuality on 
    items containing the substring Conjured*/
    
    @Test
    public void should_never_changes_quailty_of_Sulfuras_Conjured() throws Exception {
        Item sulfuras = new Item("Sulfuras Conjured", 0, 80);

        Inventory sut = new Inventory(new Item[]{sulfuras});
        sut.updateQuality();

        assertEquals(80, sulfuras.getQuality());
    }

    @Test
    public void should_never_changes_sellIn_of_Sulfuras_Conjured() throws Exception {
        Item sulfuras = new Item("Sulfuras Conjured", 0, 80);

        Inventory sut = new Inventory(new Item[]{sulfuras});
        sut.updateQuality();

        assertEquals(0, sulfuras.getSellIn());
    }

    @Test
    public void should_lower_the_sellIn_by_one_for_normal_items_Conjured() throws Exception {
        Item normalItem = new Item("Vest Conjured", 10, 20);

        Inventory sut = new Inventory(new Item[]{normalItem});
        sut.updateQuality();

        assertEquals(9, normalItem.getSellIn());
    }

    @Test
    public void should_lower_the_quality_by_two_for_normal_items_Conjured() throws Exception {
        Item normalItem = new Item("Vest", 10, 20);

        Inventory sut = new Inventory(new Item[]{normalItem});
        sut.updateQuality();

        assertEquals(18, normalItem.getQuality());
    }

    @Test
    public void should_not_lower_the_quality_below_zero_Conjured() throws Exception {
        Item normalItem = new Item("Vest Conjured", 10, 0);

        Inventory sut = new Inventory(new Item[]{normalItem});
        sut.updateQuality();

        assertEquals(0, normalItem.getQuality());
    }

    @Test
    public void should_lower_the_quality_four_times_as_fast_once_the_sell_in_date_has_passed_Conjured() throws Exception {
        Item normalItem = new Item("Vest Conjured", -1, 25);

        Inventory sut = new Inventory(new Item[]{normalItem});
        sut.updateQuality();

        assertEquals(21, normalItem.getQuality());
    }

    @Test
    public void should_increase_the_quality_of_aged_brie_as_it_gets_older_Conjured() throws Exception {
        Item agedBrie = new Item("Aged Brie Conjured", 10, 25);

        Inventory sut = new Inventory(new Item[]{agedBrie});
        sut.updateQuality();

        assertEquals(27, agedBrie.getQuality());
    }

    @Test
    public void should_not_increase_the_quality_of_aged_brie_over_50_Conjured() throws Exception {
        Item agedBrie = new Item("Aged Brie Conjured", 10, 50);

        Inventory sut = new Inventory(new Item[]{agedBrie});
        sut.updateQuality();

        assertEquals(50, agedBrie.getQuality());
    }
    
    @Test
    public void should_lower_backstage_passes_to_zero_quality_once_concert_has_happened_Conjured() throws Exception {
        Item backStagePass = new Item("Backstage passes Conjured", -1, 20);

        Inventory sut = new Inventory(new Item[]{backStagePass});
        sut.updateQuality();

        assertEquals(0, backStagePass.getQuality());
    }

    @Test
    public void should_increase_backstage_passes_quality_by_2_when_the_concert_is_more_than_10_days_away_Conjured() throws Exception {
        Item backStagePass = new Item("Backstage passes Conjured", 11, 20);

        Inventory sut = new Inventory(new Item[]{backStagePass});
        sut.updateQuality();

        assertEquals(22, backStagePass.getQuality());
    }

    @Test
    public void should_increase_backstage_passes_quality_by_4_when_the_concert_is_10_days_or_less_away_Conjured() throws Exception {
        Item backStagePass = new Item("Backstage passes Conjured", 10, 27);

        Inventory sut = new Inventory(new Item[]{backStagePass});
        sut.updateQuality();

        assertEquals(31, backStagePass.getQuality());
    }

    @Test
    public void should_increase_backstage_passes_quality_by_6_when_the_concert_is_5_days_or_less_away_Conjured() throws Exception {
        Item backStagePass = new Item("Backstage passes Conjured", 5, 44);

        Inventory sut = new Inventory(new Item[]{backStagePass});
        sut.updateQuality();

        assertEquals(50, backStagePass.getQuality());
    }

    @Test
    public void should_not_increase_backstage_passes_above_a_quality_of_50_Conjured() throws Exception {
        Item backStagePassMoreThan10DaysAway = new Item("Backstage passes Conjured", 15, 50);

        Item backStagePass10DaysAway = new Item("Backstage passes Conjured", 5, 49);
        Item backStagePass5DaysAway = new Item("Backstage passes Conjured", 5, 48);

        Inventory sut = new Inventory(new Item[]{backStagePassMoreThan10DaysAway, backStagePass10DaysAway, backStagePass5DaysAway});

        sut.updateQuality();

        assertEquals(50, backStagePassMoreThan10DaysAway.getQuality());
        assertEquals(50, backStagePass10DaysAway.getQuality());
        assertEquals(50, backStagePass5DaysAway.getQuality());
    }
    
    
}
