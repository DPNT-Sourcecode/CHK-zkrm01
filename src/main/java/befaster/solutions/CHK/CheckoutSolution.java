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
            if (sku != 'A')

        }


    }
}

