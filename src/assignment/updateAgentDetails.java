package assignment;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class updateAgentDetails {

	public static void updateAgent(LinkedHashMap<String, AgentDO> agentDetails) {
		Scanner sc = new Scanner(System.in);

		boolean updateMore = true;

		while (updateMore) {
			System.out.println("Enter Agent ID to Update:");
			String agentIdToUpdate = sc.next();

			if (agentDetails.containsKey(agentIdToUpdate)) {
				AgentDO agent = agentDetails.get(agentIdToUpdate);
				updateAgentFields(agentDetails, agent, sc);
				System.out.println("Updated agent details: " + agent);
			} else {
				System.out.println("Agent ID not found. Please enter a valid Agent ID.");
			}

			System.out.println("Do you want to update another agent? (yes/no)");
			String choice = sc.next();
			if (!choice.equalsIgnoreCase("yes")) {
				updateMore = false;
			}
		}
	}

	private static void updateAgentFields(LinkedHashMap<String, AgentDO> agentDetails, AgentDO agent, Scanner sc) {
		boolean updateMore = true;

		while (updateMore) {
			System.out.println("Choose the field to update:");
			System.out.println("1. First Name");
			System.out.println("2. Last Name");
			System.out.println("3. Email");
			System.out.println("4. Phone Number");
			System.out.println("5. Exit");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				if (agent.getFirstName() != null) {
					System.out.println("Enter new first name:");
					String firstName = sc.next();
					agent.setFirstName(firstName);
					System.out.println("First Name updated successfully.");
				} else {
					System.out.println("Please register the agent first!!");
				}
				break;
			case 2:
				if (agent.getLastName() != null) {
					System.out.println("Enter new last name:");
					String lastName = sc.next();
					agent.setLastName(lastName);
					System.out.println("Last Name updated successfully.");
				} else {
					System.out.println("Please register the agent first!!");
				}
				break;
			case 3:
				if (agent.getEmail() != null) {
					System.out.println("Enter new email:");
					String email = sc.next();
					agent.setEmail(email);
					System.out.println("Email updated successfully.");
				} else {
					System.out.println("Please register the agent first!!");
				}
				break;
			case 4:
				if (agent.getContactNumber() != null) {
					System.out.println("Enter new contact number:");
					String contactNumber = sc.next();
					agent.setContactNumber(contactNumber);
					System.out.println("Phone Number updated successfully.");
				} else {
					System.out.println("Please register the agent first!!");
				}
				break;
			case 5:
				updateMore = false;
				break;
			default:
				System.out.println("Invalid choice. Please choose a valid option between 1 to 5.");
			}
		}
	}

}
