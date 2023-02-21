package com.bridgelabz.cabinvoicegenerator;

public class CabInvoiceGenerator {
	private static final double MIN_COST_PER_KILOMETER = 10;
	private static final double COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;
	private static final double AVERAGE_FARE = 2.0;
	private RideRepository rideRepository;

	public double calculateFare(double distance, double time) {
		double cost = distance * MIN_COST_PER_KILOMETER + time * COST_PER_TIME;
		if (cost < MINIMUM_FARE)
			return MINIMUM_FARE;
		return cost;
	}

	public double calculateFareForMultipleRides(Ride[] rides) {
		double cost = 0;
		for (Ride ride : rides) {
			cost = cost + this.calculateFare(ride.distance, ride.time);
		}
		return cost;
	}

	public InvoiceDescription calculateFareDescription(Ride[] rides) {
		double cost = 0;
		for (Ride ride : rides) {
			cost = cost + this.calculateFare(ride.distance, ride.time);
		}
		return new InvoiceDescription(rides.length, cost, AVERAGE_FARE);
	}

	public InvoiceDescription getInvoiceDescription(String userId) {
		return this.calculateFareDescription(rideRepository.getRides(userId));
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRides(userId, rides);
	}
}
