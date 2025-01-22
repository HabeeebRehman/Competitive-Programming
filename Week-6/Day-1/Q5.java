import java.util.*;

public class Q5 {
    public double getMaxValue(int W, Item[] items) {
        Arrays.sort(items, (a, b) -> Double.compare(b.value / (double)b.weight, a.value / (double)a.weight));
        
        double totalValue = 0.0;
        
        for (Item item : items) {
            if (W == 0) break;
            
            if (item.weight <= W) {
                totalValue += item.value;
                W -= item.weight;
            } else {
                totalValue += item.value * ((double)W / item.weight);
                break;
            }
        }
        
        return totalValue;
    }
    
    class Item {
        int value, weight;
        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
