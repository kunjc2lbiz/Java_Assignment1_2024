package assignment;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class buyInsurance {

	public void purchaseInsurance(String partySeq,LinkedHashMap<String, AgentDO> listOfAgents,
			LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>> userInsurances) {

		Scanner sc = new Scanner(System.in);

		LinkedHashMap<String, BasePolicyDO> policies;

		if (userInsurances.containsKey(partySeq)) {
			policies = userInsurances.get(partySeq);
		} else {
			policies = new LinkedHashMap<String, BasePolicyDO>();
		}

		LinkedHashMap<Integer, String> insuranceMap = new LinkedHashMap<Integer, String>();
		insuranceMap.put(1, "Term Insurance");
		insuranceMap.put(2, "Term Health Insurance");
		insuranceMap.put(3, "Exit");

		boolean buyMore = true;

		while (buyMore) {
			System.out.println("Choose an insurance type to buy:");
			for (int key : insuranceMap.keySet()) {
				System.out.println(key + ". " + insuranceMap.get(key));
			}

			int choice = sc.nextInt();

			BasePolicyDO newInsurance = null;

			switch (choice) {
			case 1:
				if (policies.containsKey("TermInsurance")) { // if existing user has policy
					System.out.println("You already have Term Insurance. Would you like to upgrade it? (yes/no)");
					String upgradeChoice = sc.next();
					if ("yes".equalsIgnoreCase(upgradeChoice)) {
						System.out.println("Enter new sum assured for Term Insurance:");
						Double newSumAssuredTerm = sc.nextDouble();
						TermInsurance existingPolicy = (TermInsurance) policies.get("TermInsurance");
						existingPolicy.setSumAssured(newSumAssuredTerm);
						existingPolicy.setPremiumAmount(premiumCalculationDO.premiumCalTermIns(newSumAssuredTerm));
						System.out.println("Policy upgraded. New premium amount is: " + existingPolicy.getPremiumAmount());
					} else {
						System.out.println("No changes made to your existing Term Insurance.");
					}
				} else { // if fresh user buy new policy
					System.out.println("Enter sum assured for Term Insurance:");
					Double sumAssuredTerm = sc.nextDouble();
					System.out.println("Enter Agent ID to associate agent with the policy: ");
					String agentID = sc.next();
					if(listOfAgents.containsKey(agentID)){
						newInsurance = new TermInsurance(partySeq, agentID, sumAssuredTerm);
						policies.put("TermInsurance", newInsurance);
						TermInsurance tempObj = (TermInsurance) newInsurance;
						System.out.println("The premium amount is: " + tempObj.getPremiumAmount());
					} else{
						System.out.println("There is no agent with Agent Id: " + agentID);
					}

				}
				break;

			case 2:
				if (policies.containsKey("TermHealthInsurance")) {
					System.out.println("You already have Term Health Insurance. Would you like to upgrade it? (yes/no)");
					String upgradeChoice = sc.next();
					if ("yes".equalsIgnoreCase(upgradeChoice)) {
						System.out.println("Enter new sum assured for Term Health Insurance:");
						Double newSumAssuredHealth = sc.nextDouble();
						TermHealthInsurance existingPolicy = (TermHealthInsurance) policies.get("TermHealthInsurance");
						existingPolicy.setSumAssured(newSumAssuredHealth);
						existingPolicy.setPremiumAmount(premiumCalculationDO.premiumCalTermHealthIns(newSumAssuredHealth));
						existingPolicy.setHealthCover(newSumAssuredHealth * 0.05);
						System.out.println("Policy upgraded. New premium amount is: " + existingPolicy.getPremiumAmount());
					} else {
						System.out.println("No changes made to your existing Term Health Insurance.");
					}
				} else {

					System.out.println("Enter sum assured for Term Health Insurance:");
					Double sumAssuredHealth = sc.nextDouble();
					System.out.println("Enter Agent ID to associate agent with the policy: ");
					String agentID = sc.next();
					if(listOfAgents.containsKey(agentID)){
						newInsurance = new TermHealthInsurance(partySeq, agentID, sumAssuredHealth);
						policies.put("TermHealthInsurance", newInsurance);
						TermHealthInsurance tempObj2 = (TermHealthInsurance) newInsurance;
						System.out.println("The premium amount is: " + tempObj2.getPremiumAmount());
					} else {
						System.out.println("There is no agent with Agent Id: " + agentID);
					}

				}
				break;

			case 3:
				buyMore = false;
				break;

			default:
				System.out.println("Invalid choice. Please enter again.");
				continue;
			}

			if (newInsurance != null) {
				System.out.println("Insurance Purchase Successful");
			}
		}

		userInsurances.put(partySeq, policies);
		System.out.println("User Insurances: " + userInsurances);
	}


	public void searchPolicies(String partySeq,
			LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>> userInsurances) {

		if (userInsurances.containsKey(partySeq)) {
			LinkedHashMap<String, BasePolicyDO> policies = userInsurances.get(partySeq);
			System.out.println("Policies for partySeq " + partySeq + " is: ");
			for (BasePolicyDO policy : policies.values()) {
				System.out.println(policy);
			}
		} else {
			System.out.println("No policies found for partySeq " + partySeq);
		}
	}


	public void incrementPremiumAccount(LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>> userInsurances){

		if(userInsurances == null || userInsurances.isEmpty()){
			System.out.println("No user insurances available to upgrade premium account");
			return;
		}
		for(Map.Entry<String, LinkedHashMap<String, BasePolicyDO>> users : userInsurances.entrySet()){
			if(users == null || users.getValue() == null){
				System.out.println("Skipping user as it is giving null value");
				continue;
			}

			LinkedHashMap<String, BasePolicyDO> policies = users.getValue();

			for(Map.Entry<String, BasePolicyDO> policy : policies.entrySet()){
				if(policy == null || policy.getValue() == null){
					System.out.println("Skipping policy as it is giving null value");
					continue;
				}
				BasePolicyDO insurance = policy.getValue();
				if(insurance instanceof TermInsurance){
					TermInsurance tempObj = (TermInsurance) insurance;
					System.out.println("Old premium TI: "+tempObj.getPremiumAmount());
					tempObj.setPremiumAmount(tempObj.getPremiumAmount() * 1.05);
					System.out.println("New premium TI: "+tempObj.getPremiumAmount());
				}
				if(insurance instanceof TermHealthInsurance){
					TermHealthInsurance tempObj = (TermHealthInsurance) insurance;
					System.out.println("Old premium THI: "+tempObj.getPremiumAmount());
					tempObj.setPremiumAmount(tempObj.getPremiumAmount() * 1.07);
					System.out.println("New premium THI: "+tempObj.getPremiumAmount());
				}
			}

		}




	}

}


