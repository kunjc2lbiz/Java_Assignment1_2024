package assignment;

public class TermInsurance extends BasePolicyDO {

	String policySeq;
	Double premiumAmount;
	Double sumAssured;
	
	@Override
	public String toString() {
		return " policySeq: " + policySeq + ", premiumAmount: "
				+ premiumAmount + ", sumAssured: " + sumAssured;
	}

	public TermInsurance(String partySeq, String agentID, Double sumAssured) {
		super(partySeq, agentID);
		this.sumAssured = sumAssured;
		premiumAmount = premiumCalculationDO.premiumCalTermIns(sumAssured);
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
}
