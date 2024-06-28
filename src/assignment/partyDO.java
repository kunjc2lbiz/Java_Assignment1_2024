package assignment;
import java.util.ArrayList;

public class partyDO {
	String partyTypeCd;
	String partySeq;
	String title;
	String firstName;
	String lastName;
	String genderCd;
	String birthDate;
	int age;
	ArrayList<PartyAddressDO> partyAddressDOList=new ArrayList<PartyAddressDO>();
	ArrayList<PartyContactDO> partyContactDOList= new ArrayList<PartyContactDO>();

	public String toString() {
		return "\n Party Type : " + partyTypeCd
				+ "\n Party Sequence : " + partySeq + "\n Title : " + title
				+ "\n First Name : " + firstName + "\n Last Name : " + lastName
				+ "\n Gender : " + genderCd + "\n Birth Date: " + birthDate
				+ "\n Age : " + age + " years";
	}

	public String getPartyTypeCd() {
		return partyTypeCd;
	}
	public void setPartyTypeCd(String partyTypeCd) {
		this.partyTypeCd = partyTypeCd;
	}
	public String getPartySeq() {
		return partySeq;
	}
	public void setPartySeq(String partySeq) {
		this.partySeq = partySeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getGenderCd() {
		return genderCd;
	}
	public void setGenderCd(String genderCd) {
		this.genderCd = genderCd;
	}


	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ArrayList<PartyAddressDO> getPartyAddressDOList() {
		return partyAddressDOList;
	}
	public void setPartyAddressDOList(ArrayList<PartyAddressDO> partyAddressDOList) {
		this.partyAddressDOList = partyAddressDOList;
	}
	public ArrayList<PartyContactDO> getPartyContactDOList() {
		return partyContactDOList;
	}
	public void setPartyContactDOList(ArrayList<PartyContactDO> partyContactDOList) {
		this.partyContactDOList = partyContactDOList;
	}

}
