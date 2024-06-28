package assignment;

public class BasePolicyDO {

	String partySeq;
	String agentID;

	BasePolicyDO(String partySeq, String agentID) {
		this.partySeq = partySeq;
		this.agentID = agentID;
	}

	public String getPartySeq() {
		return partySeq;
	}

	public void setPartySeq(String partySeq) {
		this.partySeq = partySeq;
	}

	public String getAgentID() {
		return agentID;
	}

	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}


}
