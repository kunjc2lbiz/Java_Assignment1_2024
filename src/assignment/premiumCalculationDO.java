package assignment;

public class premiumCalculationDO {

	static Double premiumCalTermIns(Double sumAssured) {
		return sumAssured * 0.0001;
	}

	static Double premiumCalTermHealthIns(Double sumAssured) {
		return (sumAssured * (0.0001 * 1.25));
	}
}
