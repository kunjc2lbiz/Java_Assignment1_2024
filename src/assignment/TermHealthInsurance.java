package assignment;

public class TermHealthInsurance extends BasePolicyDO {

	String policySeq;
	Double premiumAmount;
	Double sumAssured;
	Double healthCover;

	@Override
	public String toString() {
		return " policySeq: " + policySeq + ", premiumAmount=" + premiumAmount
				+ ", sumAssured: " + sumAssured + ", healthCover: "
				+ healthCover;
	}

	public TermHealthInsurance(String partySeq, String agentID, Double sumAssured){
		super(partySeq, agentID);
		this.sumAssured = sumAssured;
		premiumAmount = premiumCalculationDO.premiumCalTermIns(sumAssured);
		healthCover = sumAssured * 0.05;
		this.policySeq = Integer.toString(sequenceGenerator.getPartySeqObj().policySequence++);
		System.out.println("Agent id is: " + agentID);
	}
	
	public String getPolicySeq() {
		return policySeq;
	}

	public void setPolicySeq(String policySeq) {
		this.policySeq = policySeq;
	}

	public Double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public Double getSumAssured() {
		return sumAssured;
	}

	public void setSumAssured(Double sumAssured) {
		this.sumAssured = sumAssured;
	}

	public Double getHealthCover() {
		return healthCover;
	}

	public void setHealthCover(Double healthCover) {
		this.healthCover = healthCover;
	}
}
