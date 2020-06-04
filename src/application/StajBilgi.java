package application;


public class StajBilgi {

	 String Gunluk;
	 int Date,OgrNo;
	 

	public String getGunluk() {
		return Gunluk;
	}

	public void setGunluk(String gunluk) {
		Gunluk = gunluk;
	}

	
	 public int getDate() {
		return Date;
	}

	public void setDate(int date) {
		Date = date;
	}

	public int getOgrNo() {
		return OgrNo;
	}

	public void setOgrNo(int ogrNo) {
		OgrNo = ogrNo;
	}

	public StajBilgi(int date,String gunluk,int ogrno) {
		 this.Gunluk=gunluk;
		 this.Date=date;
		 this.OgrNo=ogrno; 
	 }
	
}
