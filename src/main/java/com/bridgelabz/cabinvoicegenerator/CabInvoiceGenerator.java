package com.bridgelabz.cabinvoicegenerator;

public class CabInvoiceGenerator {
	private static final double MIN_COST_PER_KILOMETER = 10;
    private static final double COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;

    public double calculateFare(double distance, double time) {
        double cost = distance * MIN_COST_PER_KILOMETER + time * COST_PER_TIME;
        if (cost < MINIMUM_FARE)
            return MINIMUM_FARE ;
        return cost;
    }
    public static void main(String[] args) {
    	CabInvoiceGenerator cab = new CabInvoiceGenerator();
    	System.out.println("Cost of fare: "+cab.calculateFare(25, 10));
	}
}
