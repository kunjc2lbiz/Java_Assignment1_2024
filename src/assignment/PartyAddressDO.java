package assignment;

public class PartyAddressDO {

	String partyAddressSeq;
	String partySeq;
	String addressType;
	String countryCd;
	String stateCd;
	String addressDetails;
	String pinCode;
	String primaryAddress;

	public String toString() {
		return "PartyAddressSeq : " + partyAddressSeq + "\n PartySeq : "
				+ partySeq + "\n Address Type : " + addressType + "\n Country : "
				+ countryCd + "\n State : " + stateCd + "\n AddressDetails : " + addressDetails + "\n Pin Code : "
				+ pinCode + "\nIs Primary Address ? : " + primaryAddress;
	}

	public String getPartyAddressSeq() {
		return partyAddressSeq;
	}
	public void setPartyAddressSeq(String partyAddressSeq) {
		this.partyAddressSeq = partyAddressSeq;
	}
	public String getPartySeq() {
		return partySeq;
	}
	public void setPartySeq(String partySeq) {
		this.partySeq = partySeq;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getCountryCd() {
		return countryCd;
	}
	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}
	public String getStateCd() {
		return stateCd;
	}
	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}
	public String getAddressDetails() {
		return addressDetails;
	}
	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getPrimaryAddress() {
		return primaryAddress;
	}
	public void setPrimaryAddress(String primaryAddress) {
		this.primaryAddress = primaryAddress;
	}
	
	
}
