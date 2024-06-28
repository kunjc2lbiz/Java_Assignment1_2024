package assignment;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.c2lbiz.symbiosys.systemcommon.util.FileUtil;

public class downloadUserDetails {

	
	public static void downloadUserDetails(LinkedHashMap<String, partyDO> userDetails, Scanner sc) {
		System.out.println("Enter Party Sequence for which you want to download user: ");

		for(Map.Entry<String, partyDO> key: userDetails.entrySet()){
			System.out.println(key.getKey());
		}
		String partySequence = sc.next();

		for(Map.Entry<String, partyDO> key: userDetails.entrySet()){
			if(partySequence.equalsIgnoreCase((String) key.getKey())){
				try {
					FileUtil.createFile("D:\\Jar Testing\\generated files\\",
							"userDetails.pdf", convertLHMtoString(userDetails));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		if(userDetails.size() == 0){
			System.out.println("No users details to download. Please Register!!");
		}else if(userDetails.size() == 1){
			System.out.println("Only one user detail to display: \n"
					+ convertLHMtoString(userDetails));
		}

	}
	
	static String convertLHMtoString(LinkedHashMap<String, partyDO> userDetails) {
		return "";
	}

}
