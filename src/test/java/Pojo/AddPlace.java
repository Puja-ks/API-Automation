package Pojo;
import java.util.*;

public class AddPlace {
	private Location location ;
	private String  accuracy;
	private String name;
	private String phone_numbe;
	private String addresss;
	private String website;
	private String language;
	private List<String> types ;
	
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_numbe() {
		return phone_numbe;
	}
	public void setPhone_numbe(String phone_numbe) {
		this.phone_numbe = phone_numbe;
	}
	public String getAddresss() {
		return addresss;
	}
	public void setAddresss(String addresss ) {
		this.addresss = addresss;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
