package assignment;

public class sequenceGenerator {

	int partySequence;
	int partyAddressSequence;
	int partyContactSequence;
	int policySequence;
	int agentID;

	private sequenceGenerator() {
		partySequence = 1;
		partyAddressSequence = 1;
		partyContactSequence = 1;
		policySequence = 1;
		agentID = 1;
	}

	static sequenceGenerator seqObj;


	public static sequenceGenerator getPartySeqObj() {
		if (seqObj != null) {
			return seqObj;
		} else {
			seqObj = new sequenceGenerator();
			return seqObj;
		}
	}




}
