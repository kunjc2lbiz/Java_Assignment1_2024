package assignment;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class MainConsole {

	public static void main(String[] args) throws ParseException,
	noSuchRecordFoundException {
		LinkedHashMap<String, partyDO> listOfUsers = new LinkedHashMap<String, partyDO>();

		LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>> userInsurances = new LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>>();

		LinkedHashMap<String, AgentDO> listOfAgents = new LinkedHashMap<String, AgentDO>();

		Scanner sc = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			System.out.println("Enter:");
			System.out.println("1. To Register User");
			System.out.println("2. To Update User");
			System.out.println("3. To Delete User");
			System.out.println("4. To Search User");
			System.out.println("5. To Display Users");
			System.out.println("6. To Buy Insurance");
			System.out.println("7. To Search Policies");
			System.out.println("8. To Increase Premium Charge");
			System.out.println("9. To Register Agent");
			System.out.println("10. To Update Agent Details");
			System.out.println("11. To Display all Agents");
			System.out.println("12. Agent Client Summary");
			System.out.println("13. Search User by Country Name");
			System.out.println("14. Search User by State Name");
			System.out.println("15. To Exit");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				partyDO newUserData = new partyDO();
				registeration getData = new registeration();
				try {
					getData.register(newUserData);
				} catch (ParseException e) {
					System.out.println("Error parsing date: " + e.getMessage());
				} catch (noSuchRecordFoundException e) {
					System.out.println("Invalid user details: " + e.getMessage());
				}

				listOfUsers.put(newUserData.getPartySeq(), newUserData);
				break;

			case 2:
				updateLogicForExistingPartyDO updateData = new updateLogicForExistingPartyDO();
				if (listOfUsers.isEmpty()) {
					System.out.println("Please register a user first.");
				} else {
					updateData.updateDO(listOfUsers);
				}
				break;

			case 3:
				// delete removeUser = new delete();
				if (listOfUsers.isEmpty()) {
					System.out.println("Please register a user first.");
				} else {
					delete.deleteUserAddress(listOfUsers, sc);
				}
				break;

			case 4:
				// searchUser Search = new searchUser();
				if (listOfUsers.isEmpty()) {
					System.out.println("Please register a user first.");
				} else {
					searchUser.search(listOfUsers, sc);
				}
				break;

			case 5:
				if (listOfUsers.isEmpty()) {
					System.out.println("No Users to display.");
				} else {
					Set<String> keys = listOfUsers.keySet();
					for (String key : keys) {
						System.out.println(key + " -- " + listOfUsers.get(key));
					}
				}
				break;

			case 6:
				buyInsurance buy = new buyInsurance();
				System.out.println("Enter Party Sequence to buy insurance:");
				String partySeqToBuyInsurance = sc.next();
				if(listOfUsers.containsKey(partySeqToBuyInsurance)){
					buy.purchaseInsurance(partySeqToBuyInsurance, listOfAgents, userInsurances);
				} else {
					System.out.println("Please Register First!!");
				}
				break;

			case 7:
				buyInsurance search = new buyInsurance();
				System.out.println("Enter Party Sequence to search policies:");
				String partySeqToSearch = sc.next();
				search.searchPolicies(partySeqToSearch, userInsurances);
				break;
			case 8:
				buyInsurance upgrade = new buyInsurance();
				if (!listOfUsers.isEmpty()) {
					upgrade.incrementPremiumAccount(userInsurances);
				} else {
					System.out.println("No users exists in the system.");
				}
				break;
			case 9:
				AgentDO newAgent = new AgentDO();
				agentRegisteration getData1 = new agentRegisteration();
				try {
					getData1.registerAgent(newAgent);
				} catch (Exception e) {
					System.out.println("Invalid agent details: " + e.getMessage());
				}
				listOfAgents.put(newAgent.getAgentId(), newAgent);
				break;
			case 10:
				if (listOfAgents.isEmpty()) {
					System.out.println("Please register an agent first.");
				} else {
					updateAgentDetails.updateAgent(listOfAgents);
				}
				break;
			case 11:
				if (listOfAgents.isEmpty()) {
					System.out.println("No agents to display.");
				} else {
					Set<String> agentKeys = listOfAgents.keySet();
					for (String key : agentKeys) {
						System.out.println(key + " -- " + listOfAgents.get(key));
					}
				}
				break;
			case 12:
				if (listOfAgents.isEmpty()) {
					System.out.println("No agents to display.");
				}else{
					agentClientSummary summary = new agentClientSummary();
					summary.summary(listOfUsers, userInsurances);

				}
				break;

			case 13:
				if (listOfUsers.isEmpty()) {
					System.out.println("Please register a user first.");
				} else {
					searchUser.searchByCountry(listOfUsers, sc);
				}
				break;
			case 14:
				if (listOfUsers.isEmpty()) {
					System.out.println("Please register a user first.");
				} else {
					searchUser.searchByState(listOfUsers, sc);
				}
				break;
			case 15:
				exit = true;
				System.out.println("Thank you!!");
				break;


			default:
				System.out.println("Enter a valid number between 1 and 7");
				break;
			}
		}

		sc.close();
	}





}


