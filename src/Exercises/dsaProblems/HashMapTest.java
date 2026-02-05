package Exercises.dsaProblems;

//import api.*;
import java.util.*;

public class HashMapTest {


//    public Solution(APICaller api) {
//        this.api = api;
//        System.out.println("Press run code to see this in the console!");
//        // You can initiate and calculate things here
//    }

    /**
     * Return the day which you buy silver. The first day has number zero.
     * This method is called first, and only once.
     */

    List<Integer> price = Arrays.asList(7, 12, 5, 3, 11, 6, 10, 2, 9);
    List<Integer> day = Arrays.asList(0,1, 2, 3, 4,5,6,7,8);

    public int getBuyDay() {

        int buyDay = -1;
        int minPrice = Integer.MAX_VALUE; // Initialize min price to a large value
        int maxProfit = 0; // Initialize the max profit as 0, which means no profit yet

        // Loop through all days to determine the best day to buy
        for (int i = 0; i < day.size(); i++) {
            int p = price.get(i);

            // If we find a lower price, update the buy day and min price
            if (p < minPrice) {
                minPrice = p;
                buyDay = i;
            }
        }

        int profit = 0, currentDay = day.size() - 1;
        int minDay = currentDay;
        // Start from the last day
        while (currentDay > 0)
        {
            int day = currentDay - 1;
            // Traverse and keep adding the
            // profit until a day with
            // price of stock higher
            // than currentDay is obtained
            while (day >= 0 &&
                    (price.get(currentDay) > price.get(day)))
            {
                profit += (price.get(currentDay) - price.get(day));
                minDay = day;
                day--;
            }
            // Set this day as currentDay
            // with maximum cost of stock
            // currently
            currentDay = day;
        }


        return minDay;
    }

    /**
     * Return the day to sell silver on. This day has to be after (greater
     * than) the buy day. The first day has number zero (although this is not
     * a valid sell day). This method is called second, and only once.
     */
    public int getSellDay() {
        int buyDay = getBuyDay(); // Get the best day to buy from the first method
        int maxProfit = 0; // Start with no profit
        int sellDay = -1; // Initialize sell day

        // If buy day is invalid or there's no opportunity to sell, return -3 for both days
        if (buyDay == -1) {
            return -3;
        }

        int buyPrice = price.get(buyDay);

        // Loop through all days after the buy day to find the best day to sell
        for (int i = buyDay + 1; i < day.size(); i++) {
            int sellPrice = price.get(i);
            int profit = sellPrice - buyPrice;

            // If selling on this day gives a higher profit, update sell day
            if (profit > maxProfit) {
                maxProfit = profit;
                sellDay = i;
            }
        }

        // If no profit can be made, return -3 for both days
        if (maxProfit <= 0) {
            return -3;
        }

        int profit = 0, currentDay = day.size() - 1;
        int minDay = currentDay;
        int maxProfitDay = currentDay;
        // Start from the last day
        while (currentDay > 0)
        {
            int day = currentDay - 1;
            // Traverse and keep adding the
            // profit until a day with
            // price of stock higher
            // than currentDay is obtained
            while (day >= 0 &&
                    (price.get(currentDay) > price.get(day)))
            {
                profit += (price.get(currentDay) - price.get(day));
                minDay = day;
                day--;
            }
            // Set this day as currentDay
            // with maximum cost of stock
            // currently
            currentDay = day;
        }

        return sellDay;
    }

    public static void main(String[] args) {
        HashMapTest s = new HashMapTest();
        int buy = s.getBuyDay();
        int sell =  s.getSellDay();

        System.out.println(buy  + sell);
    }
}