import java.util.*;

class Item {
    int value, weight;
    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    static class ItemComparator implements Comparator<Item> {
        public int compare(Item a, Item b) {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1);  // descending
        }
    }

    public static double getMaxValue(Item[] items, int capacity) {
        Arrays.sort(items, new ItemComparator());

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                totalValue += item.value * ((double) capacity / item.weight);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter value and weight for each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " value: ");
            int value = sc.nextInt();
            System.out.print("Item " + (i + 1) + " weight: ");
            int weight = sc.nextInt();

            if (weight <= 0) {
                System.out.println("Weight must be greater than 0. Try again.");
                i--;
                continue;
            }

            items[i] = new Item(value, weight);
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        double maxValue = getMaxValue(items, capacity);
        System.out.printf("Maximum value in knapsack = %.2f\n", maxValue);

        sc.close();
    }
}
