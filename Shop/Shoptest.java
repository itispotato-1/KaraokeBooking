import store.*;

public class Shoptest{

    private static int passedCount = 0;
    private static int failedCount = 0;

    private static void check(String testName, boolean condition) {
        if (condition) {
            System.out.println("PASSED: " + testName);
            passedCount++;
        } else {
            System.out.println("FAILED: " + testName);
            failedCount++;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Starting E-commerce System Tests (with Exception Handling) ---");
        
        Product fried_rice = new Product("F001", "fried rice", 40.0);
        Product Holy_basil_rice = new Product("F002", "Holy basil rice", 50.0);
        Product Noodles = new Product("F003", "Noodles", 40.0);

        ProductCatalog Food = new ProductCatalog();
        Food.addProduct(fried_rice);
        Food.addProduct(Holy_basil_rice);
        Food.addProduct(Noodles);

        PricingService pricingService = new PricingService();
        ShoppingCart cart = new ShoppingCart(pricingService, Food);
        
        System.out.println("\n--- Testing Normal Operations ---");
        try {
            cart.addItem("F001", 2,"Riceup"); 
            cart.addItem("F002", 1,"Special");
            check("Add valid items", cart.getItemCount() == 2);
            check("Calculate total price correctly", cart.getTotalPrice() == (100.0 + 65.0)); 
            
            cart.removeItem("F001");
            check("Remove existing item", cart.getItemCount() == 1);
            check("Price updates after removal", cart.getTotalPrice() == 65.0);

        } catch (Exception e) {
            failedCount += 4; 
            System.out.println("FAILED: Normal operations should not throw exception: " + e.getMessage());
        }

        System.out.println("\n--- Testing Exception Handling ---");
        
        boolean caughtNotFound = false;
        try {
            cart.addItem("F999", 1,"Default");
        } catch (ProductNotFoundException e) {
            caughtNotFound = true;
            System.out.println("  -> Info: Correctly caught expected exception: " + e.getMessage());
        } catch (Exception e) {
        }
        check("addItem throws ProductNotFoundException for unknown product", caughtNotFound);

        boolean caughtInvalidOp = false;
        try {
            cart.removeItem("F001");
        } catch (InvalidOperationException e) {
            caughtInvalidOp = true;
            System.out.println("  -> Info: Correctly caught expected exception: " + e.getMessage());
        } catch (Exception e) {
        }
        check("removeItem throws InvalidOperationException for item not in cart", caughtInvalidOp);


        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}