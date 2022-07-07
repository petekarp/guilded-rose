# The PICA Gilded Rose

This is a Java version of the Gilded Rose Kata, adapted for PICA.

There are plenty of solutions for this out there, but we are interested in *yours*.


# Original Description of the Gilded Rose

Hi and welcome to team Gilded Rose. We buy and sell items. Unfortunately, our goods are constantly degrading in quality
as they approach their "sell by" date. We have a system in place that updates our inventory for us. Your task is to add 
some new features to our system. First an introduction to our system:

- All items have a SellIn value which denotes the number of days we have to sell the item
- All items have a Quality value which denotes how valuable the item is
- At the end of each day our system lowers both values for every item

Pretty simple, right? Well this is where it gets interesting:

  - Once the sell by date has passed, Quality degrades twice as fast
  - The Quality of an item is never negative
  - "Aged Brie" actually increases in Quality the older it gets
  - The Quality of an item is never more than 50
  - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
  - "Backstage passes", like aged brie, increases in Quality as it's SellIn value approaches. Quality increases by 2
  when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert

(Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a legendary item and
as such its Quality is 80, and it never alters.)

We require a couple of updates to our system:

- Items that contain "Conjured" change their Quality twice as fast as they would otherwise.
- Items with an "x" or "X" in the name only change their quality once every two days. This change will require that the inventory
know what day it is. The simplest workable solution is fine.

## Why yes, we know this code might be offensive!

We realize that the code in this application is a mess. It obviously was not test-driven, has no real structure, 
is hard to read, and is even harder to maintain. We try and keep code like this out of production in the real world. To 
implement these features, we want you to refactor the existing code first (to make it easy to change), then make the 
changes. Spend as much time on this as you like, ideally getting us to a place where we can easily make 
modifications in the future.  If there are any requirements you're unclear on, proceed making an assumption that seems reasonable to you.

Feel free to make any changes to the UpdateQuality method and add any new code as long as everything still works
correctly. Refactor things. Make new classes. Implement patterns. Help the next person understand this code.

There are only two rules: 

1. Do not alter the Item class or Items property

2. If you change something, you must have a functionally equivalent test that still passes.

We would be interested in seeing how the solution evolved by a commit history in git. An ideal solution is comprised of
small, logical, chunks of work with helpful messages.

You can also complete this exercise in Groovy (or a mix of Java and Groovy) if you'd like.  Simply uncomment the commented out section that says
"Uncomment this to use groovy", and you should be good to go.