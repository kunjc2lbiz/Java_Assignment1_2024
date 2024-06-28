package assignment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.c2lbiz.symbiosys.systemcommon.util.DateUtil;

public class searchUser {

	public static void search(LinkedHashMap<String, partyDO> userDetails, Scanner sc){
		try{
			System.out.println("Enter Party Sequence for which you want to search user: ");

			for(Map.Entry<String, partyDO> key: userDetails.entrySet()){
				System.out.println(key.getKey());
			}
			String partySequence = sc.next();

			for(Map.Entry<String, partyDO> key: userDetails.entrySet()){
				if(partySequence.equalsIgnoreCase((String) key.getKey())){
					System.out.println("User Details with associated Party Sequence: " + partySequence + "is ");
					System.out.println(userDetails);
				} else {
					System.out.println("No user found.");
				}
			}
			throw new noSuchRecordFoundException("Party Sequence: " + partySequence + " is invalid");
		}catch(Exception e){
			System.out.println("Error: " + e);
		}	
	}

	public static void searchByName(LinkedHashMap<String, partyDO> userDetails, Scanner sc) {
		try {
			System.out.println("Enter the name of the user you want to search:");

			String firstName = sc.next();
			boolean userFound = false;

			for (Map.Entry<String, partyDO> userEntry : userDetails.entrySet()) {
				partyDO user = userEntry.getValue();
				if (firstName.equalsIgnoreCase(user.getFirstName())) {
					System.out.println("User Details with first name: " + firstName + " are ");
					System.out.println(user);
					userFound = true;
				}
			}

			if (!userFound) {
				System.out.println("No user found with the name: " + firstName);
				throw new noSuchRecordFoundException("Name: " + firstName + " is invalid");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	public static void searchByPartyType(LinkedHashMap<String, partyDO> userDetails, Scanner sc) {
		try {
			System.out.println("Enter the party type of the user you want to search:");
			System.out.println("1. Individual");
			System.out.println("2. Organization");

			int choice = sc.nextInt();
			String partyType;

			switch (choice) {
			case 1:
				partyType = "Individual";
				break;
			case 2:
				partyType = "Organization";
				break;
			default:
				System.out.println("Invalid choice.");
				return;
			}

			boolean userFound = false;
			for (partyDO user : userDetails.values()) {
				if (partyType.equalsIgnoreCase(user.getPartyTypeCd())) {
					System.out.println("User Details with Party Type: " + partyType + " are ");
					System.out.println(user);
					userFound = true;
				}
			}

			if (!userFound) {
				System.out.println("No users found with the party type: " + partyType);
				throw new noSuchRecordFoundException("Party Type: " + partyType + " is invalid");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}



	public static void searchByGender(LinkedHashMap<String, partyDO> userDetails, Scanner sc) {
		try {
			System.out.println("Enter the gender of the user you want to search:");
			System.out.println("1. Male");
			System.out.println("2. Female");
			System.out.println("3. Transgender");

			int choice = sc.nextInt();
			String gender = "";
			switch (choice) {
			case 1:
				gender = "Male";
				break;
			case 2:
				gender = "Female";
				break;
			case 3:
				gender = "Transgender";
				break;
			default:
				System.out.println("Invalid choice.");
				return;
			}

			boolean userFound = false;

			for (Map.Entry<String, partyDO> userEntry : userDetails.entrySet()) {
				partyDO user = userEntry.getValue();
				if (gender.equalsIgnoreCase(user.getGenderCd())) {
					System.out.println("User Details with the gender: " + gender + " are ");
					System.out.println(user);
					userFound = true;
				}
			}

			if (!userFound) {
				System.out.println("No user found with the gender: " + gender);
				throw new noSuchRecordFoundException("Gender: " + gender + " is invalid");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}


	public static void searchByAge(LinkedHashMap<String, partyDO> userDetails, Scanner sc) {
		try {
			System.out.println("Enter the age criteria to search users:");
			System.out.println("1. Age > 18");
			System.out.println("2. Age > 21");
			System.out.println("3. Age > 25");
			System.out.println("4. Age > 30");

			int choice = sc.nextInt();
			int ageCriteria;

			switch (choice) {
			case 1:
				ageCriteria = 18;
				break;
			case 2:
				ageCriteria = 21;
				break;
			case 3:
				ageCriteria = 25;
				break;
			case 4:
				ageCriteria = 30;
				break;
			default:
				System.out.println("Invalid choice.");
				return;
			}

			boolean userFound = false;
			SimpleDateFormat sdf = new SimpleDateFormat();
			Date today = new Date();

			for (partyDO user : userDetails.values()) {
				if (DateUtil.getAge(sdf.parse(user.getBirthDate()), today) > ageCriteria) {
					System.out.println("User Details with age > " + ageCriteria + " are ");
					System.out.println(user);
					userFound = true;
				}
			}

			if (!userFound) {
				System.out.println("No user found with the specified age criteria.");
				throw new noSuchRecordFoundException("No user found with age > " + ageCriteria);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}


	public static void searchByAddress(LinkedHashMap<String, partyDO> userDetails, Scanner sc) {
		try {
			System.out.println("Enter the address detail to search users:");
			String addressDetail = sc.next().toLowerCase();
			boolean userFound = false;

			for (Map.Entry<String, partyDO> userEntry : userDetails.entrySet()) {
				partyDO user = userEntry.getValue();
				for (PartyAddressDO address : user.getPartyAddressDOList()) {
					if (address.getAddressDetails().toLowerCase().indexOf(addressDetail)>-1) {
						System.out.println("User Details with address containing: " + addressDetail + " are ");
						System.out.println(user);
						userFound = true;
					}
				}
			}

			if (!userFound) {
				System.out.println("No user found with the address detail: " + addressDetail);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}




	public static void searchByContactNumber(LinkedHashMap<String, partyDO> userDetails, Scanner sc) {
		try {
			System.out.println("Enter the contact number to search users:");
			String contactNumber = sc.next();
			boolean userFound = false;

			for (Map.Entry<String, partyDO> userEntry : userDetails.entrySet()) {
				partyDO user = userEntry.getValue();
				for (PartyContactDO contact : user.getPartyContactDOList()) {
					if (contact.getContactNum().equals(contactNumber)) {
						System.out.println("User Details with contact number: " + contactNumber + " are ");
						System.out.println(user);
						userFound = true;
					}
				}
			}

			if (!userFound) {
				System.out.println("No user found with the contact number: " + contactNumber);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	public static void searchByCountry(LinkedHashMap<String, partyDO> userDetails, Scanner sc) {
		try {
			if(!userDetails.isEmpty()){
				System.out.println("Enter the country name from which you want to search users:");
				String countryName = sc.next();
				boolean userFound = false;

				for (Map.Entry<String, partyDO> userEntry : userDetails.entrySet()) {
					partyDO user = userEntry.getValue();
					for (PartyAddressDO country : user.getPartyAddressDOList()) {
						if (country.getCountryCd().equalsIgnoreCase(countryName)) {
							System.out.println("User Details with country name: " + countryName + " are ");
							System.out.println(user);
							userFound = true;
						}
					}
				}

				if (!userFound) {
					System.out.println("No user found with the country name: " + countryName);
				}
			} else {
				System.out.println("There are no users available to search from. Please Register First!!");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	public static void searchByState(LinkedHashMap<String, partyDO> userDetails, Scanner sc) {
		try {
			if(!userDetails.isEmpty()){
				System.out.println("Enter the state name from which you want to search users:");
				String stateName = sc.next();
				boolean userFound = false;

				for (Map.Entry<String, partyDO> userEntry : userDetails.entrySet()) {
					partyDO user = userEntry.getValue();
					for (PartyAddressDO state : user.getPartyAddressDOList()) {
						if (state.getStateCd().equalsIgnoreCase(stateName)) {
							System.out.println("User Details with state name: " + stateName + " are ");
							System.out.println(user);
							userFound = true;
						}
					}
				}

				if (!userFound) {
					System.out.println("No user found with the country name: " + stateName);
				}
			} else {
				System.out.println("There are no users available to search from. Please Register First!!");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}



}
