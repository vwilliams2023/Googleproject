package googleFinancePack;

public class TestExecutor {

    public static void main(String[] args) throws InterruptedException {
        GoogleFinanceTest test = new GoogleFinanceTest(); // Create an instance of the GoogleFinanceTest class
        test.setUp();                                 // call setup method from GFT page
        test.testGoogleFinance();                     // call testGoogleFinance method
        test.closeBrowser();                         // call closeBrowser method 
    }
}

  