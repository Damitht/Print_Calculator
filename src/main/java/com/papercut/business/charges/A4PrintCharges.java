package com.papercut.business.charges;

public class A4PrintCharges implements PrintCharges{

	/**
	 * A4 specific charges
	 */
	
	@Override
	public double blackNWhiteSingleCharge() {
		return 0.15;
	}

	@Override
	public double blackNWhiteDoubleCharge() {
		return 0.10;
	}

	@Override
	public double coloredSingleCharge() {
		return 0.25;
	}

	@Override
	public double coloredDoubleCharge() {
		return 0.20;
	}
}
