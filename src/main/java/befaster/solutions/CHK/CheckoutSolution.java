package befaster.solutions.CHK;
import java.util.HashMap;
import java.util.Map;
import befaster.runner.SolutionNotImplementedException;

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
        total += calculatePrice(itemCounts, 'A', 50, 3,130);
        total += calculatePrice(itemCounts, 'B', 30, 2,45);
        total += calculatePrice(itemCounts, 'C', 20, 0,0);
        total += calculatePrice(itemCounts, 'D', 15, 0,0);

        return total;
    }


    private int calculatePrice(Map<Character, Integer> itemCounts, char item, int unitPrice, int specialQuantity, int specialPrice)
    {
        int count = itemCounts.getOrDefault(item, 0);
        if (specialQuantity > 0 && count >= specialQuantity)
        {
            int specialCount = count/ specialQuantity;
            int remainder = count % specialQuantity;
            return specialCount * specialPrice + remainder * unitPrice;
        }else
        {
            return count * unitPrice;

        }
    }
}
