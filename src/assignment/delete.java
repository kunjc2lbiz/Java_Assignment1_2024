package assignment;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class delete {

	public static void deleteUserAddress(LinkedHashMap<String, partyDO> userDetails, Scanner sc) {
		System.out.println("Enter Party Sequence for which you want to remove user: ");

		for(Map.Entry<String, partyDO> key: userDetails.entrySet()){
			System.out.println(key.getKey());
		}
		String partySequence = sc.next();

		for(Map.Entry<String, partyDO> key: userDetails.entrySet()){
			if(partySequence.equalsIgnoreCase((String) key.getKey())){
				userDetails.remove(partySequence);
			}
		}

		if(userDetails.size() == 0){
			System.out.println("No users to display. Please Register!!");
		}else if(userDetails.size() == 1){
			System.out.println("Only one user available to display: \n" + userDetails);
		}

	}
}
