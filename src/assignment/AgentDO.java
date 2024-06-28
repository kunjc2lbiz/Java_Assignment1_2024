package assignment;

import java.util.LinkedHashMap;

public class AgentDO {
	String agentId;
	String firstName;
	String lastName;
	String email;
	String contactNumber;
	LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>> assignedPolicies = new LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>>();

	public String toString() {
		return "\n Agent ID: " + agentId + "\n First Name: " + firstName
				+ "\n Last Name: " + lastName + "\n Email: " + email
				+ "\n Contact Number: " + contactNumber;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>> getAssignedPolicies() {
		return assignedPolicies;
	}

	public void setAssignedPolicies(
			LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>> assignedPolicies) {
		this.assignedPolicies = assignedPolicies;
	}
}
