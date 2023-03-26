import java.util.Arrays;
import java.util.Comparator;

/*
 * Container to hold the value and weight of an item
 */
class Item {
    int value, weight;
    Item(int value, int weight){
        this.value = value;
        this.weight = weight;
    }
}

/**
 * Comparator to sort the items based on their 
 * value per weight in descending order.
 */
class ValueComparator implements Comparator<Item>{ 
    @Override
    public int compare(Item o1, Item o2) {
        // Calculate the value per weight
        double v1 = (double) o1.value / (double)o1.weight; 
        double v2 = (double) o2.value / (double)o2.weight; 
        if(v1 < v2) return 1;
        else if(v1 > v2) return -1;
        else return 0;
    }
}
class FractionalKnapsack {
    public static void main(String[] args) {
        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };

        int weight = 50;
        int n = items.length;
        System.out.println(fractionalKnapsack(weight, items, n));
    }

    /**
     * Method to get the maximum total value in the knapsack.
     * @param W the total capacity of the knapsack
     * @param arr array of items
     * @param n the total number of items
     * @return total value of the knapsack 
     */
    static double fractionalKnapsack(int W, Item arr[], int n){
        // Sort the items array based on value per weight
        // in descending order.
        Arrays.sort(arr, new ValueComparator());
        // Variable to hold the totalValue of the knapsack
        double totalValue = 0.0;
        // Variable contains the weight currently filled
        int currentWeight = 0;
        for (int i = 0; i < n; i++) {
            // If the current item can be put into the knapsack
            if(currentWeight + arr[i].weight <= W){
                // Add the current item's value to totalValue
                totalValue += arr[i].value;
                // Add the current item's weight to currentWeight
                currentWeight += arr[i].weight;
            }else{
                // If the whole item cannot be put into knapsack,
                // calculate the remaining weight of the knapsack
                int remainingWeight = W - currentWeight;
                // Get the value of item per weight and multiply by 
                // remaining weight
                // totalValue += ((double)arr[i].value / (double)arr[i].weight) * (double)remainingWeight;
                totalValue += ((double)arr[i].value / (double)arr[i].weight) * (double)remainingWeight;
               
                currentWeight += remainingWeight;
                // Break the loop because the knapsack is completely filled.
                // break;
            }
        }
        // Return the total value of the knapsack
        return totalValue;
    }
}
