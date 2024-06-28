package assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.c2lbiz.symbiosys.systemcommon.util.DateUtil;

public class registeration {

	public void register(partyDO userObj) throws ParseException, noSuchRecordFoundException {
		Scanner sc = new Scanner(System.in);
		String response;


		System.out.println("Choose Party Type: \n 1. Individual \n 2. Organization ");

		while (true) {
			int partyType = sc.nextInt();
			if (partyType == 1) {
				userObj.setPartyTypeCd("Individual");
				break;
			} else if (partyType == 2) {
				userObj.setPartyTypeCd("Organization");
				break;
			} else {
				System.out.println("Enter a valid choice.");
			}
		}

		System.out.print("Your Party Sequence is: ");
		userObj.setPartySeq(Integer.toString(sequenceGenerator.getPartySeqObj().partySequence++));
		System.out.println(userObj.getPartySeq());

		System.out.println("Choose title: \n 1. MR \n 2. MS \n 3. MRS");

		while (true) {
			int title = sc.nextInt();
			if (title == 1) {
				userObj.setTitle("MR");
				break;
			} else if (title == 2) {
				userObj.setTitle("MS");
				break;
			} else if (title == 3) {
				userObj.setTitle("MRS");
				break;
			} else {
				System.out.println("Enter a valid choice.");
			}
		}

		System.out.println("Enter First Name: ");
		while (true) {
			String firstname = sc.next();
			if (nameValidator(firstname)) {
				userObj.setFirstName(firstname);
				break;
			} else {
				System.out.println("Enter only alphabets:");
			}
		}

		System.out.println("Enter Last Name: ");
		while (true) {
			String lastname = sc.next();
			if (nameValidator(lastname)) {
				userObj.setLastName(lastname);
				break;
			} else {
				System.out.println("Enter only alphabets:");
			}
		}

		System.out.println("Enter Gender: \n 1. Male \n 2. Female \n 3. Transgender");
		while (true) {
			int genderCd = sc.nextInt();
			if (genderCd == 1) {
				userObj.setGenderCd("Male");
				break;
			} else if (genderCd == 2) {
				userObj.setGenderCd("Female");
				break;
			} else if (genderCd == 3) {
				userObj.setGenderCd("Transgender");
				break;
			} else {
				System.out.println("Enter a valid choice.");
			}
		}

		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Date today = new Date();
	    Date birthDate = null;
	    boolean validDate = false;

	    while (!validDate) {
	        try {
	            System.out.println("Enter Birth Date (dd/MM/yyyy): ");
	            String inputDate = sc.next();
	            birthDate = sdf.parse(inputDate);

	            if (birthDate.after(today)) {
	                throw new noSuchRecordFoundException("Birth Date cannot be a future date.");
	            }

	            int age = DateUtil.getAge(birthDate, today);
	            if (age < 18) {
	                throw new noSuchRecordFoundException("User must be at least 18 years old.");
	            }

	            validDate = true;
	        } catch (ParseException e) {
	            System.out.println("Invalid date format. Please enter date in format dd/MM/yyyy.");
	        } catch (noSuchRecordFoundException e) {
	            System.out.println(e.getMessage());
	        }
	    }


	    userObj.birthDate = sdf.format(birthDate);
	    userObj.age = DateUtil.getAge(birthDate, today);

		while (userObj.getPartyAddressDOList().isEmpty() || userObj.getPartyContactDOList().isEmpty()) {
			if (userObj.getPartyAddressDOList().isEmpty()) {
				System.out.println("Enter Primary Address:");
				addAddress(sc, userObj);
			}
			if (userObj.getPartyContactDOList().isEmpty()) {
				System.out.println("Enter Primary Contact Number:");
				addContact(sc, userObj);
			}
		}

		boolean addMoreAddresses = true;
		while (addMoreAddresses) {
			System.out.println("Add another address? (yes or no)");
			response = sc.next();
			if (response.equalsIgnoreCase("yes")) {
				addAddress(sc, userObj);
			} else {
				addMoreAddresses = false;
				checkPrimary(userObj);
			}
		}

		boolean addMoreContact = true;
		while (addMoreContact) {
			System.out.println("Add another contact? (yes or no)");
			response = sc.next();
			if (response.equalsIgnoreCase("yes")) {
				addContact(sc, userObj);
			} else {
				addMoreContact = false;
			}
		}

		System.out.println("User details are: " + userObj);
		System.out.println("Entered Address:");
		for (PartyAddressDO addresses : userObj.getPartyAddressDOList()) {
			System.out.println(addresses.partySeq + ". " + addresses);
		}

		System.out.println("Entered Contact:");
		for (PartyContactDO contact : userObj.getPartyContactDOList()) {
			System.out.println(contact);
		}
	}

	public static void addAddress(Scanner sc, partyDO userObj) {
		PartyAddressDO address = new PartyAddressDO();
		boolean hasPrimaryAddress = false;
		String response;

		Map<String, List<String>> countryStates = new LinkedHashMap<String, List<String>>();
		countryStates.put("India", Arrays.asList("Maharashtra", "Gujarat", "Rajasthan"));
		countryStates.put("USA", Arrays.asList("New York", "California", "Texas"));
		countryStates.put("Canada", Arrays.asList("Ontario", "Quebec", "British Columbia"));

		System.out.print("Your Party Address Sequence is: ");
		address.setPartyAddressSeq(Integer.toString(sequenceGenerator.getPartySeqObj().partyAddressSequence++));
		System.out.println(address.getPartyAddressSeq());


		address.setPartySeq(userObj.getPartySeq());

		System.out.println("Enter Address Type: \n 1. Residential \n 2. Office");
		while (true) {
			int addressType = sc.nextInt();
			if (addressType == 1) {
				address.setAddressType("Residential");
				break;
			} else if (addressType == 2) {
				address.setAddressType("Office");
				break;
			} else {
				System.out.println("Enter a valid choice.");
			}
		}

		System.out.println("Select your Country:");
		int index = 1;
		for (String country : countryStates.keySet()) {
			System.out.println(index + ". " + country);
			index++;
		}

		System.out.print("Enter your choice corresponding to your country: ");
		int countryChoice = sc.nextInt();
		String selectedCountry = null;
		index = 1;
		for (String country : countryStates.keySet()) {
			if (index == countryChoice) {
				selectedCountry = country;
				address.setCountryCd(selectedCountry);
				break;
			}
			index++;
		}

		System.out.println("Select your State:");
		List<String> states = countryStates.get(selectedCountry);
		index = 1;
		for (String state : states) {
			System.out.println(index + ". " + state);
			index++;
		}
		System.out.print("Enter your choice corresponding to your state: ");
		int stateChoice = sc.nextInt();
		String selectedState = null;
		index = 1;
		for (String state : states) {
			if (index == stateChoice) {
				selectedState = state;
				address.setStateCd(selectedState);
				break;
			}
			index++;
		}

		System.out.println("Enter Address Details: ");
		address.addressDetails = sc.next();

		System.out.println("Enter Pin Code: ");
		address.pinCode = sc.next();

		System.out.println("Do you want to make this address as Primary Address? (yes or no): ");
		response = sc.next();
		if (response.equalsIgnoreCase("yes")) {
			address.setPrimaryAddress("YES");
			hasPrimaryAddress = true;
		} else {
			address.setPrimaryAddress("NO");
		}

		userObj.getPartyAddressDOList().add(address);
	}

	public static void addContact(Scanner sc, partyDO userObj) {
		PartyContactDO contact = new PartyContactDO();

		System.out.print("Your Party Contact Sequence is: ");
		contact.setPartyContactSeq(Integer.toString(sequenceGenerator.getPartySeqObj().partyContactSequence++));
		System.out.println(contact.getPartyContactSeq());

		System.out.println("Enter Contact Type: \n 1. Mobile \n 2. Residential \n 3. Office");
		while (true) {
			int contactType = sc.nextInt();
			if (contactType == 1) {
				contact.setContactType("Mobile");
				break;
			} else if (contactType == 2) {
				contact.setContactType("Residential");
				break;
			} else if (contactType == 3) {
				contact.setContactType("Office");
				break;
			} else {
				System.out.println("Enter a valid choice.");
			}
		}

		System.out.println("Enter Contact Number: ");
		contact.contactNum = sc.next();

		userObj.getPartyContactDOList().add(contact);
	}

	public static void checkPrimary(partyDO userObj) {
		boolean hasPrimaryAddress = false;

		for (PartyAddressDO addresses : userObj.getPartyAddressDOList()) {
			if (addresses.getPrimaryAddress().equalsIgnoreCase("yes")) {
				hasPrimaryAddress = true;
				break;
			}
		}
		if (!hasPrimaryAddress) {
			setPrimary(userObj);
		}
	}

	public static void setPrimary(partyDO userObj) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please make at least one address as primary address!!");
		System.out.println("Which Party Address Sequence do you want to make Primary?");
		for (PartyAddressDO addresses : userObj.getPartyAddressDOList()) {
			System.out.println(addresses);
		}
		while (true) {
			String sequence = sc.nextLine();
			boolean hasPrimaryAddress = false;

			for (PartyAddressDO address : userObj.getPartyAddressDOList()) {
				if (address.getPartyAddressSeq().equalsIgnoreCase(sequence)) {
					hasPrimaryAddress = true;
					address.setPrimaryAddress("YES");
				}
			}

			if (!hasPrimaryAddress) {
				System.out.println("Enter a valid sequence number");
			} else {
				break;
			}
		}
	}

	public static boolean nameValidator(String str) {
		String expression = "^[a-zA-Z\\s]+$";
		return str.matches(expression);
	}
}
