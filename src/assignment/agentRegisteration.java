package assignment;

import java.util.Scanner;

public class agentRegisteration {

	public static boolean nameValidator(String str) {
		String expression = "^[a-zA-Z\\s]+$";
		return str.matches(expression);
	}

	public static boolean emailValidator(String email) {
		String expression = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		return email.matches(expression);
	}

	public static boolean contactNumberValidator(String contactNumber) {
		String expression = "^[0-9]{10}$";
		return contactNumber.matches(expression);
	}

	public void registerAgent(AgentDO agentObj) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Your Agent ID is: ");
		agentObj.setAgentId(Integer.toString(sequenceGenerator.getPartySeqObj().agentID++));
		System.out.println(agentObj.getAgentId());

		System.out.print("Enter First Name: ");
		while (true) {
			String firstname = sc.next();
			if (nameValidator(firstname)) {
				agentObj.setFirstName(firstname);
				break;
			} else {
				System.out.println("Enter only alphabets:");
			}
		}

		System.out.print("Enter Last Name: ");
		while (true) {
			String lastname = sc.next();
			if (nameValidator(lastname)) {
				agentObj.setLastName(lastname);
				break;
			} else {
				System.out.println("Enter only alphabets:");
			}
		}

		System.out.print("Enter Email: ");
		while (true) {
			String email = sc.next();
			if (emailValidator(email)) {
				agentObj.setEmail(email);
				break;
			} else {
				System.out.println("Enter correct email:");
			}
		}

		System.out.print("Enter Contact Number: ");
		while (true) {
			String contactNumber = sc.next();
			if (contactNumberValidator(contactNumber)) {
				agentObj.setContactNumber(contactNumber);
				break;
			} else {
				System.out.println("Enter correct contact number:");
			}
		}

		System.out.println("Agent details are: " + agentObj);
	}
}
