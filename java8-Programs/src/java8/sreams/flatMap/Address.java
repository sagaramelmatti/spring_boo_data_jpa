package java8.sreams.flatMap;

public class Address {
	
	String address;
	
	String city;
	
	String pinCode;

	public Address() {
		super();
	}

	public Address(String address, String city, String pinCode) {
		super();
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + ", city=" + city + ", pinCode=" + pinCode + "]";
	}

}
