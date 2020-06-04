package application;

public class Users {

	int id;
	String username,surname,ogrNo,fakulte,bolum,stajTur,red,onay;
	public Users(int id, String username, String surname, String ogrNo, String fakulte, String bolum, String stajTur,
			String red, String onay) {
		
		this.id = id;
		this.username = username;
		this.surname = surname;
		this.ogrNo = ogrNo;
		this.fakulte = fakulte;
		this.bolum = bolum;
		this.stajTur = stajTur;
		this.red = red;
		this.onay = onay;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getOgrNo() {
		return ogrNo;
	}
	public void setOgrNo(String ogrNo) {
		this.ogrNo = ogrNo;
	}
	public String getFakulte() {
		return fakulte;
	}
	public void setFakulte(String fakulte) {
		this.fakulte = fakulte;
	}
	public String getBolum() {
		return bolum;
	}
	public void setBolum(String bolum) {
		this.bolum = bolum;
	}
	public String getStajTur() {
		return stajTur;
	}
	public void setStajTur(String stajTur) {
		this.stajTur = stajTur;
	}
	public String getRed() {
		return red;
	}
	public void setRed(String red) {
		this.red = red;
	}
	public String getOnay() {
		return onay;
	}
	public void setOnay(String onay) {
		this.onay = onay;
	}
	
	
	
}
