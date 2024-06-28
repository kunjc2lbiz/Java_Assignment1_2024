package assignment;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class agentClientSummary {

	public void summary(LinkedHashMap<String, partyDO> listOfUsers,
			LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>> userInsurances) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter agent id to get summary of their clients: ");
		String agentID = sc.next();

		for(Map.Entry<String, LinkedHashMap<String, BasePolicyDO>> insurance : userInsurances.entrySet()){
			String partySeq = insurance.getKey();
			if (!userInsurances.containsKey(partySeq)) {
				System.out.println("User with Party Sequence " + partySeq + " is not registered.");
				return;
			}
			LinkedHashMap<String, BasePolicyDO> policyLHM = insurance.getValue();
			for(Map.Entry<String, BasePolicyDO> policy : policyLHM.entrySet()){
				String agentId = policy.getValue().getAgentID();

				if (agentId.equalsIgnoreCase(agentID)) {
					partyDO user = (partyDO) listOfUsers.get(partySeq);
					System.out.println(user.toString());
				}

			}
		}
	}
}
