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

public class updateLogicForExistingPartyDO {

	public void updateDO(LinkedHashMap<String, partyDO> userDetails) throws ParseException {
		Scanner sc = new Scanner(System.in);

		boolean updateMore = true;

		LinkedHashMap<Integer, String> inputFieldsMap = new LinkedHashMap<Integer, String>();
		inputFieldsMap.put(1, "Party Type");
		inputFieldsMap.put(2, "Title");
		inputFieldsMap.put(3, "First Name");
		inputFieldsMap.put(4, "Last Name");
		inputFieldsMap.put(5, "Gender");
		inputFieldsMap.put(6, "Birth Date");
		inputFieldsMap.put(7, "Update Address");
		inputFieldsMap.put(8, "Update Contact");
		inputFieldsMap.put(9, "Add Address");
		inputFieldsMap.put(10, "Add Contact");
		inputFieldsMap.put(11, "Exit");

		while (updateMore) {
			System.out.println("Enter Party Sequence to Update:");
			String partySeqToUpdate = sc.next();

			if (userDetails.containsKey(partySeqToUpdate)) {
				partyDO user = userDetails.get(partySeqToUpdate);
				updatePartyFields(userDetails, user, sc);
				System.out.println("Updated user details: " + user);
			} else {
				System.out.println("Party Sequence not found. Please enter a valid Party Sequence.");
			}

			System.out.println("Do you want to update another user? (yes/no)");
			String choice = sc.next();
			if (!choice.equalsIgnoreCase("yes")) {
				updateMore = false;
			}
		}
	}


	private void updatePartyFields(LinkedHashMap<String, partyDO> userDetails, partyDO userObj, Scanner sc) {
		boolean updateMore = true;

		while (updateMore) {
			System.out.println("Choose the field to update:");
			System.out.println("1. Party Type");
			System.out.println("2. Title");
			System.out.println("3. First Name");
			System.out.println("4. Last Name");
			System.out.println("5. Gender");
			System.out.println("6. Birth Date");
			System.out.println("7. Update Address");
			System.out.println("8. Update Contact");
			System.out.println("9. Add Address");
			System.out.println("10. Add Contact");
			System.out.println("11. Exit");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				if (userObj.getPartyTypeCd() != null) {
					System.out.println("Choose Party Type: \n 1. "+ (userObj.getPartyTypeCd().equalsIgnoreCase("Individual") ? "Organization" : "Individual"));
					int partyType = sc.nextInt();
					if (partyType == 1) {
						userObj.setPartyTypeCd(userObj.getPartyTypeCd().equalsIgnoreCase("Individual") ? "Organization" : "Individual");
						System.out.println("Updated Party Type: " + userObj.getPartyTypeCd());
						// userDetails.put(userObj.getPartySeq(),
						// userObj.getPartyTypeCd());
					} else {
						System.out.println("Enter Valid Choice.");
					}
				} else {
					System.out.println("The Party Type doesn't exist. Please Register!!");
				}
				break;

			case 2:
				if (userObj.getTitle() != null) {
					System.out.println("Choose title: ");

					if (userObj.getTitle().equalsIgnoreCase("MR")) {
						System.out.println("1. MS \n2. MRS");

						while (true) {
							int titleChoice = sc.nextInt();
							switch (titleChoice) {
							case 1:
								userObj.setTitle("MS");
								System.out.println("Updated Title: " + userObj.getTitle());
								break;
							case 2:
								userObj.setTitle("MRS");
								System.out.println("Updated Title: " + userObj.getTitle());
								break;
							default:
								System.out.println("Enter Valid Choice.");
								continue;
							}
							break;
						}

					} else if (userObj.getTitle().equalsIgnoreCase("MS")) {
						System.out.println("1. MR \n2. MRS");

						while (true) {
							int titleChoice = sc.nextInt();
							switch (titleChoice) {
							case 1:
								userObj.setTitle("MR");
								System.out.println("Updated Title: " + userObj.getTitle());
								break;
							case 2:
								userObj.setTitle("MRS");
								System.out.println("Updated Title: " + userObj.getTitle());
								break;
							default:
								System.out.println("Enter Valid Choice.");
								continue;
							}
							break;
						}

					} else if (userObj.getTitle().equalsIgnoreCase("MRS")) {
						System.out.println("1. MR \n2. MS");

						while (true) {
							int titleChoice = sc.nextInt();
							switch (titleChoice) {
							case 1:
								userObj.setTitle("MR");
								System.out.println("Updated Title: " + userObj.getTitle());
								break;
							case 2:
								userObj.setTitle("MS");
								System.out.println("Updated Title: " + userObj.getTitle());
								break;
							default:
								System.out.println("Enter Valid Choice.");
								continue;
							}
							break;
						}
					}
				} else {
					System.out.println("Title is not initialized. Please Register!!");
				}
				break;

			case 3:
				if (userObj.getFirstName() != null) {
					System.out.println("Enter new First Name: ");
					String newFirstName = sc.next();
					if (!newFirstName.equals(userObj.getFirstName())) {
						userObj.setFirstName(newFirstName);
						System.out.println("Updated First Name: " + userObj.getFirstName());
					} else {
						System.out.println("The first name is the same as before. Please enter a new first name.");
					}
				} else {
					System.out.println("The first name is not initialized. Please Register!!");
				}
				break;

			case 4:
				if (userObj.getLastName() != null) {
					System.out.println("Enter new Last Name: ");
					String newLastName = sc.next();
					if (!newLastName.equals(userObj.getLastName())) {
						userObj.setLastName(newLastName);
						System.out.println("Updated Last Name: " + userObj.getLastName());
					} else {
						System.out.println("The last name is the same as before. Please enter a new last name.");
					}
				} else {
					System.out.println("The last name is not initialized. Please Register!!");
				}
				break;

			case 5:
				if (userObj.getGenderCd() != null) {
					System.out.println("Choose Gender: ");

					if (userObj.getGenderCd().equalsIgnoreCase("Male")) {
						System.out.println("1. Female \n2. Transgender");

						while (true) {
							int genderChoice = sc.nextInt();
							switch (genderChoice) {
							case 1:
								userObj.setGenderCd("Female");
								System.out.println("Updated Gender: Female");
								break;
							case 2:
								userObj.setGenderCd("Transgender");
								System.out.println("Updated Gender: Transgender");
								break;
							default:
								System.out.println("Enter Valid Choice.");
								continue;
							}
							break;
						}

					} else if (userObj.getGenderCd().equalsIgnoreCase("Female")) {
						System.out.println("1. Male \n2. Transgender");

						while (true) {
							int genderChoice = sc.nextInt();
							switch (genderChoice) {
							case 1:
								userObj.setGenderCd("Male");
								System.out.println("Updated Gender: Male");
								break;
							case 2:
								userObj.setGenderCd("Transgender");
								System.out.println("Updated Gender: Transgender");
								break;
							default:
								System.out.println("Enter Valid Choice.");
								continue;
							}
							break;
						}

					} else if (userObj.getGenderCd().equalsIgnoreCase("Transgender")) {
						System.out.println("1. Male \n2. Female");

						while (true) {
							int genderChoice = sc.nextInt();
							switch (genderChoice) {
							case 1:
								userObj.setGenderCd("Male");
								System.out.println("Updated Gender: Male");
								break;
							case 2:
								userObj.setGenderCd("Female");
								System.out.println("Updated Gender: Female");
								break;
							default:
								System.out.println("Enter Valid Choice.");
								continue;
							}
							break;
						}
					}
				} else {
					System.out.println("Gender is not initialized. Please Register!!");
				}
				break;

			case 6:
				if (userObj.getBirthDate() != null) {
					boolean validDate = false;
					Date newBirthDate = null;
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

					while (!validDate) {
						System.out.println("Enter new Birth Date (dd/MM/yyyy): ");
						String newBirthDateStr = sc.next();

						try {
							newBirthDate = sdf.parse(newBirthDateStr);

							if (newBirthDateStr.equals(userObj.getBirthDate())) {
								System.out.println("You entered the same birth date as before. Please enter a different one.");
								continue;
							}

							Date today = new Date();
							if (newBirthDate.after(today)) {
								System.out.println("Birth date cannot be in the future. Please enter again.");
							} else {
								if (DateUtil.getAge(newBirthDate, today) < 18) {
									System.out.println("You must be 18 years or older to register. Please enter again.");
								} else {
									validDate = true;
									userObj.setBirthDate(newBirthDateStr); // Update birth date string
									userObj.setAge(DateUtil.getAge(newBirthDate, today)); // Update age based on new birth date
								}
							}
						} catch (ParseException e) {
							System.out.println("Invalid date format. Please enter in dd/MM/yyyy format.");
						}
					}
				} else {
					System.out.println("Birth date is not initialized. Please Register!!");
				}
				break;


			case 7:
				updateAddress(userObj, sc);
				break;

			case 8:
				updateContact(userObj, sc);
				break;
			case 9:
				registeration.addAddress(sc, userObj);
				boolean addMoreAddresses = true;
				while (addMoreAddresses) {
					System.out.println("Add another address ? (yes or no)");
					String response = sc.next();
					if (response.equalsIgnoreCase("yes")) {
						System.out.println("YES ADD ADDRESS.");
						registeration.addAddress(sc, userObj);
					} else {
						addMoreAddresses = false;
						registeration.checkPrimary(userObj);
					}
				}
				break;
			case 10:
				registeration.addContact(sc, userObj);
				boolean addMoreContact = true;
				while (addMoreContact) {
					System.out.println("Add another contact? (yes or no)");
					String response = sc.next();
					if (response.equalsIgnoreCase("yes")) {
						registeration.addContact(sc, userObj);
					} else {
						addMoreContact = false;
					}
				}
			case 11:
				updateMore = false;
				break;

			default:
				System.out.println("Enter valid number between 1 to 10");
			}
		}


	}


	public static void updateAddress(partyDO userObj, Scanner sc) {
		LinkedHashMap<Integer, PartyAddressDO> addressMap = new LinkedHashMap<Integer, PartyAddressDO>();

		List<PartyAddressDO> addressList = userObj.getPartyAddressDOList();
		for (int i = 0; i < addressList.size(); i++) {
			addressMap.put(i + 1, addressList.get(i));
		}

		LinkedHashMap<Integer, String> partyAddressFieldsMap = new LinkedHashMap<Integer, String>();
		partyAddressFieldsMap.put(1, "Address Type");
		partyAddressFieldsMap.put(2, "Country & State");
		partyAddressFieldsMap.put(3, "Address Details");
		partyAddressFieldsMap.put(4, "Pin Code");
		partyAddressFieldsMap.put(5, "Primary Address");
		partyAddressFieldsMap.put(6, "Exit");

		System.out.println("Select the address you want to update: ");

		for (Map.Entry<Integer, PartyAddressDO> entry : addressMap.entrySet()) {
			System.out.println(entry.getKey() + ". " + entry.getValue());
		}

		int addressChoice = sc.nextInt();
		if (addressChoice < 1 || addressChoice > addressMap.size()) {
			System.out.println("Invalid choice");
			return;
		}

		PartyAddressDO address = addressMap.get(addressChoice);

		boolean updateMore = true;
		while (updateMore) {
			System.out.println("Which address field would you like to update?");
			for (Map.Entry<Integer, String> field : partyAddressFieldsMap.entrySet()) {
				System.out.println(field.getKey() + ". " + field.getValue());
			}

			int choice = sc.nextInt();
			if (partyAddressFieldsMap.containsKey(choice)) {
				switch (choice) {

				case 1:
					System.out.println("Choose Address Type:");
					System.out.println("1. Residential");
					int addressTypeChoice = sc.nextInt();
					if (addressTypeChoice == 1) {
						address.setAddressType("Residential".equalsIgnoreCase(address.getAddressType()) ? "Office" : "Residential");
						System.out.println("Updated Address Type: " + address.getAddressType());
					} else {
						System.out.println("Enter Valid Choice.");
					}
					break;
				case 2:
					updateCountryAndState(userObj, sc);
					break;
				case 3:
					System.out.println("Enter new Address Details:");
					String newAddressDetails = sc.next();
					address.setAddressDetails(newAddressDetails);
					System.out.println("Updated Address Details: " + address.getAddressDetails());
					break;
				case 4:
					System.out.println("Enter new Pin Code:");
					String newPinCode = sc.next();
					address.setPinCode(newPinCode);
					System.out.println("Updated Pin Code: " + address.getPinCode());
					break;
				case 5:
					updatePrimaryAddress(userObj, sc);
					break;
				case 6:
					updateMore = false;
					break;
				default:
					System.out.println("Enter valid number between 1 to 6");
				}
			} else {
				System.out.println("Invalid choice");
			}
		}

		System.out.println("Updated address : ");
		for (Map.Entry<Integer, PartyAddressDO> entry : addressMap.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	private static void updateCountryAndState(partyDO userObj, Scanner sc) {
		Map<String, List<String>> countryStates = new LinkedHashMap<String, List<String>>();
		countryStates.put("India", Arrays.asList("Maharashtra", "Gujarat", "Rajasthan"));
		countryStates.put("USA", Arrays.asList("New York", "California", "Texas"));
		countryStates.put("Canada", Arrays.asList("Ontario", "Quebec", "British Columbia"));

		System.out.println("Select your Country:");
		int index = 1;
		for (String country : countryStates.keySet()) {
			System.out.println(index + ". " + country);
			index++;
		}

		int countryChoice = sc.nextInt();
		String selectedCountry = null;
		index = 1;
		for (String country : countryStates.keySet()) {
			if (index == countryChoice) {
				selectedCountry = country;
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
		int stateChoice = sc.nextInt();
		String selectedState = null;
		index = 1;
		for (String state : states) {
			if (index == stateChoice) {
				selectedState = state;
				break;
			}
			index++;
		}

		if (!userObj.getPartyAddressDOList().isEmpty()) {
			PartyAddressDO address = userObj.getPartyAddressDOList().get(0);
			address.setCountryCd(selectedCountry);
			address.setStateCd(selectedState);
		} else {
			System.out.println("No addresses found to update.");
		}
	}

	private static void updatePrimaryAddress(partyDO userObj, Scanner sc) {
		List<PartyAddressDO> addressList = userObj.getPartyAddressDOList();

		if (addressList.size() == 1) {
			System.out.println("Current Address: " + addressList.get(0).getAddressDetails());
			System.out.println("This address must remain primary as it is the only one.");
			addressList.get(0).setPrimaryAddress("YES");
			System.out.println("Address set as primary.");
			return;
		}

		// If there are multiple addresses, allow the user to update primary status
		System.out.println("Select the address to set or unset as primary:");
		for (int i = 0; i < addressList.size(); i++) {
			System.out.println((i + 1) + ". " + addressList.get(i).getAddressDetails() + " (Primary: " + addressList.get(i).getPrimaryAddress() + ")");
		}

		int choice = sc.nextInt();
		if (choice < 1 || choice > addressList.size()) {
			System.out.println("Invalid choice");
			return;
		}

		PartyAddressDO selectedAddress = addressList.get(choice - 1);
		String currentPrimaryStatus = selectedAddress.getPrimaryAddress();

		System.out.println("Current Primary Status: " + currentPrimaryStatus);
		System.out.println("Do you want to change this address's primary status? (yes/no)");
		String updateChoice = sc.next().trim().toLowerCase();

		if (updateChoice.equals("yes")) {
			selectedAddress.setPrimaryAddress("YES");
		} else if (updateChoice.equals("no")) {
			selectedAddress.setPrimaryAddress("NO");
		} else {
			System.out.println("Invalid input. No changes made.");
			return;
		}

		boolean hasPrimary = false;
		for (PartyAddressDO address : addressList) {
			if ("YES".equalsIgnoreCase(address.getPrimaryAddress())) {
				hasPrimary = true;
				break;
			}
		}

		if (!hasPrimary) {
			System.out.println("You should have at least one primary address. Please select an address to set as primary:");
			for (int i = 0; i < addressList.size(); i++) {
				System.out.println((i + 1) + ". " + addressList.get(i).getAddressDetails());
			}

			int newChoice = sc.nextInt();
			if (newChoice < 1 || newChoice > addressList.size()) {
				System.out.println("Invalid choice. Setting the first address as primary.");
				addressList.get(0).setPrimaryAddress("YES");
			} else {
				addressList.get(newChoice - 1).setPrimaryAddress("YES");
			}
		}

		System.out.println("Updated Addresses:");
		for (PartyAddressDO address : addressList) {
			System.out.println(address.getPartySeq() + " (Primary: " + address.getPrimaryAddress() + ")");
		}
	}

	private void updateContact(partyDO userObj, Scanner sc) {
		LinkedHashMap<Integer, PartyContactDO> contactMap = new LinkedHashMap<Integer, PartyContactDO>();

		List<PartyContactDO> contactList = userObj.getPartyContactDOList();
		for (int i = 0; i < contactList.size(); i++) {
			contactMap.put(i + 1, contactList.get(i));
		}

		LinkedHashMap<Integer, String> partyContactFieldsMap = new LinkedHashMap<Integer, String>();
		partyContactFieldsMap.put(1, "Contact Type");
		partyContactFieldsMap.put(2, "Contact Number");
		partyContactFieldsMap.put(3, "Exit");


		System.out.println("Select the contact you want to update: ");

		for (Map.Entry<Integer, PartyContactDO> entry : contactMap.entrySet()) {
			System.out.println(entry.getKey() + ". " + entry.getValue());
		}

		int addressChoice = sc.nextInt();
		if (addressChoice < 1 || addressChoice > contactMap.size()) {
			System.out.println("Invalid choice");
			return;
		}

		PartyContactDO contact = contactMap.get(addressChoice);

		boolean updateMore = true;
		while (updateMore) {
			System.out.println("Which contact field would you like to update?");
			for (Map.Entry<Integer, String> field : partyContactFieldsMap.entrySet()) {
				System.out.println(field.getKey() + ". " + field.getValue());
			}

			int choice = sc.nextInt();
			if (partyContactFieldsMap.containsKey(choice)) {
				switch (choice) {
				case 1:
					if (contact.getContactType()!= null) {
						System.out.println("Choose Contact Type: ");

						if (contact.getContactType().equalsIgnoreCase("Mobile")) {
							System.out.println("1. Residential \n2. Office");

							while (true) {
								int contactTypeChoice = sc.nextInt();
								switch (contactTypeChoice) {
								case 1:
									contact.setContactType("Residential");
									System.out.println("Updated Contact Type: " + contact.getContactType());
									break;
								case 2:
									contact.setContactType("Office");
									System.out.println("Updated Contact Type: " + contact.getContactType());
									break;
								default:
									System.out.println("Enter Valid Choice.");
									continue;
								}
								break;
							}

						} else if (contact.getContactType().equalsIgnoreCase("Residential")) {
							System.out.println("1. Mobile \n2. Office");

							while (true) {
								int contactTypeChoice = sc.nextInt();
								switch (contactTypeChoice) {
								case 1:
									contact.setContactType("Mobile");
									System.out.println("Updated Contact Type: " + contact.getContactType());
									break;
								case 2:
									contact.setContactType("Office");
									System.out.println("Updated Contact Type: " + contact.getContactType());
									break;
								default:
									System.out.println("Enter Valid Choice.");
									continue;
								}
								break;
							}

						} else if (contact.getContactType().equalsIgnoreCase("Office")) {
							System.out.println("1. Mobile \n2. Residential");

							while (true) {
								int contactTypeChoice = sc.nextInt();
								switch (contactTypeChoice) {
								case 1:
									contact.setContactType("Mobile");
									System.out.println("Updated Contact Type: " + contact.getContactType());
									break;
								case 2:
									contact.setContactType("Residential");
									System.out.println("Updated Contact Type: " + contact.getContactType());
									break;
								default:
									System.out.println("Enter Valid Choice.");
									continue;
								}
								break;
							}
						}
					} else {
						System.out.println("Contact is not initialized. Please Register!!");
					}
					break;

				case 2:
					System.out.println("Enter new Contact Number:");
					String newContactNumber = sc.next();
					contact.setContactNum(newContactNumber);
					System.out.println("Updated Contact Number: " + contact.getContactNum());
					break;
				case 3:
					updateMore = false;
					break;
				default:
					System.out.println("Enter valid number between 1 to 3");
				}
			} else {
				System.out.println("enter valid choice");
			}
		}
	}


	public static boolean nameValidator(String str) {
		String expression = "^[a-zA-Z\\s]+";
		return str.matches(expression);
	}
}






