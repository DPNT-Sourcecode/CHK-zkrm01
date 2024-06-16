package befaster.solutions.CHK;
import java.util.HashMap;
import java.util.Map;
import befaster.runner.SolutionNotImplementedException;
import com.sun.source.tree.ReturnTree;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        if (skus == null)
        {
            return -1;
        }
        Map<Character, Integer> itemCounts = new HashMap<>();
        for (char sku : skus.toCharArray()){
            if (sku != 'A' && sku != 'B' && sku != 'C' && sku != 'D' && sku != 'E'){
                return -1; //invalid input
            }
            itemCounts.put(sku, itemCounts.getOrDefault(sku, 0) + 1);
        }
        int total = 0;
        total += calculatePrice(itemCounts, 'A', 50, new int[]{5,3}, new int[]{200, 130});
        total += calculatePrice(itemCounts, 'B', 30, new int[]{2}, new int[]{45});
        total += calculatePrice(itemCounts, 'C', 20, new int[]{}, new int[]{});
        total += calculatePrice(itemCounts, 'D', 15, new int[]{}, new int[]{});
        total += calculatePriceWithFreeItem(itemCounts, 'E',40,2,'B');
        return total;
    }


    private int calculatePrice(Map<Character, Integer> itemCounts, char item, int unitPrice, int[] specialQuantities, int[] specialPrices) {
        int count = itemCounts.getOrDefault(item, 0);
        int total = 0;
        for (int i = 0; i < specialQuantities.length; i++) {
            int specialCount = count / specialQuantities[i];
            total += specialCount * specialPrices[i];
        }
        total += count * unitPrice;
        return total;

    }

    private int calculatePriceWithFreeItem(Map<Character, Integer> itemCounts, char item, int unitPrice, int offerQuantity,char freeItem ){
        int count = itemCounts.getOrDefault(item, 0);
        int freeItemCount = itemCounts.getOrDefault(freeItem, 0);

        int freeItemsToAdd = count / freeItemCount;
        freeItemCount = Math.max(0,freeItemCount - freeItemsToAdd);

        itemCounts.put(freeItem,freeItemCount);

        return count * unitPrice;

    }

}

