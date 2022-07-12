/*The Inventory Class stores an array of Items and provides the updateQuality method 
to pass items through a day in the lifecycle of the Guilded Rose project.*/
public class Inventory {

    private Item[] items;

    public Inventory(Item[] items) {
        super();
        this.items = items;
    }

    public void updateQuality() {    	
        for (int i = 0; i < items.length; i++) {
        	boolean flag = true;			
        	boolean isConjured =  false;
        	if (!items[i].getName().toUpperCase().contains("Sulfuras".toUpperCase())) {
  				if (items[i].getName().toUpperCase().contains("Conjured".toUpperCase()))
            		isConjured = true;        		
        		if (items[i].getName().toUpperCase().contains("Aged Brie".toUpperCase())) {
        			if (items[i].getQuality() < 50) {        			 
        				items[i].setQuality(items[i].getQuality() + 1);
        				if(isConjured)
        					items[i].setQuality(items[i].getQuality() + 1);
        				if (items[i].getSellIn() < 0) {         				 
        					items[i].setQuality(items[i].getQuality() + 1);
        					if(isConjured)
        						items[i].setQuality(items[i].getQuality() + 1);
        				}
        			}
        			flag = false;
        		}
        		if(items[i].getName().toUpperCase().contains("Backstage passes".toUpperCase())) {
        			if (items[i].getQuality() < 50) { 
        				items[i].setQuality(items[i].getQuality() + 1);
        				if(isConjured && items[i].getQuality() < 50)
    						items[i].setQuality(items[i].getQuality() + 1);
        			}

        			if (items[i].getSellIn() < 11) {        				
        				if (items[i].getQuality() < 50) { 
                    		items[i].setQuality(items[i].getQuality() + 1);
                    		if(isConjured && items[i].getQuality() < 50)
        						items[i].setQuality(items[i].getQuality() + 1);
        				}
        				if (items[i].getSellIn() < 6) {
        					if (items[i].getQuality() < 50) {                    	
        						items[i].setQuality(items[i].getQuality() + 1);
        						if(isConjured && items[i].getQuality() < 50)
            						items[i].setQuality(items[i].getQuality() + 1);
        					}
        					if (items[i].getSellIn() < 0) {
        						if (items[i].getQuality() > 0)   {   
        							items[i].setQuality(items[i].getQuality()- items[i].getQuality());
        						}
        					}	
        					
        				}
        			}
        			flag = false;
        		}

        		if (items[i].getName().toUpperCase().contains("X")){
            		
        		}
        		if (flag) {
        			if (items[i].getQuality() > 0) {        			 
        				items[i].setQuality(items[i].getQuality() - 1);
        				if(isConjured)
        					items[i].setQuality(items[i].getQuality() - 1);
        			}
	        		if(items[i].getSellIn() < 1) {
	        			items[i].setQuality(items[i].getQuality() - 1);
	        			if(isConjured)
	        				items[i].setQuality(items[i].getQuality() - 1);
	        		}
            		flag = false;
            	}
                
                items[i].setSellIn(items[i].getSellIn() - 1);
                
        		}else{
        			
        			flag = false;
        		} 
        }
    }
}


    
    /*public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName() != "Aged Brie"
                    && items[i].getName() != "Backstage passes") {
                if (items[i].getQuality() > 0) {
                    if (items[i].getName() != "Sulfuras") {
                        items[i].setQuality(items[i].getQuality() - 1);
                    }
                }
            } else {
                if (items[i].getQuality() < 50) {
                    items[i].setQuality(items[i].getQuality() + 1);

                    if (items[i].getName() == "Backstage passes") {
                        if (items[i].getSellIn() < 11) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        }

                        if (items[i].getSellIn() < 6) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (items[i].getName() != "Sulfuras") {
                items[i].setSellIn(items[i].getSellIn() - 1);
            }

            if (items[i].getSellIn() < 0) {
                if (items[i].getName() != "Aged Brie") {
                    if (items[i].getName() != "Backstage passes") {
                        if (items[i].getQuality() > 0) {
                            if (items[i].getName() != "Sulfuras") {
                                items[i].setQuality(items[i].getQuality() - 1);
                            }
                        }
                    } else {
                        items[i].setQuality(items[i].getQuality()
                                - items[i].getQuality());
                    }
                } else {
                    if (items[i].getQuality() < 50) {
                        items[i].setQuality(items[i].getQuality() + 1);
                    }
                }
            }
        }
    }
    */
