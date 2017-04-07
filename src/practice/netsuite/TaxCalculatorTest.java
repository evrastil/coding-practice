package practice.netsuite;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculatorTest {
    @Test
    public void testIt() {
        ArrayList<Rate> rates = new ArrayList<>();
        rates.add(new Rate(1000, 0.9));
        rates.add(new Rate(2000, 0.8));
        rates.add(new Rate(Integer.MAX_VALUE, 0.7));
        TaxCalculator taxCalculator = new TaxCalculator(rates);
        double netIncome = taxCalculator.calculate(2100);
        System.out.println(netIncome);
        Assert.assertTrue(1780 == netIncome);
    }

    class TaxCalculator {
        List<Rate> rates;
        TaxCalculator(List<Rate> rates) {
            this.rates = rates;
        }
        public double calculate(double grossIncome) {
            double totalNetResult = 0;
            double calcReminder = grossIncome;
            int rateIndex = 0;
            while (calcReminder > 0) {
                Rate rate = rates.get(rateIndex);
                double taxableRange = Math.min(calcReminder, rate.amount);
                totalNetResult += taxableRange * rate.tax;
                calcReminder -= taxableRange;
                rateIndex++;
            }
            return totalNetResult;
        }
    }
    class Rate {
        double amount;
        double tax;
        Rate(double amount, double tax) {
            this.amount = amount;
            this.tax = tax;
        }
    }
}
