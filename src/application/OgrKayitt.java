package application;

public class OgrKayitt {
	 int id ;
	    String username, surname, email , ogrno,s�n�f,cinsiyet,stajDurum,bolum,fakulte;

	    public void setId(int id) {
	        this.id = id;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public void setSurname(String surname) {
	        this.surname = surname;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public void setOgrno(String type) {
	        this.ogrno = type;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public String getSurname() {
	        return surname;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getOgrno() {
	        return ogrno;
	    }

	    public String getS�n�f() {
			return s�n�f;
		}

		public void setS�n�f(String s�n�f) {
			this.s�n�f = s�n�f;
		}
		

		public String getCinsiyet() {
			return cinsiyet;
		}

		public void setCinsiyet(String cinsiyet) {
			this.cinsiyet = cinsiyet;
		}
		


		public String getStajDurum() {
			return stajDurum;
		}

		public void setStajDurum(String stajDurum) {
			this.stajDurum = stajDurum;
		}

		
		
		public String getBolum() {
			return bolum;
		}

		public void setBolum(String bolum) {
			this.bolum = bolum;
		}

		public String getFakulte() {
			return fakulte;
		}

		public void setFakulte(String fakulte) {
			this.fakulte = fakulte;
		}

		public OgrKayitt(int id, String username, String surname, String email, String ogrno,String s�n�f,String cinsiyet,String staj,String Bolum,String Fakulte) {
	        this.id = id;
	        this.username = username;
	        this.surname = surname;
	        this.email = email;
	        this.ogrno = ogrno;
	        this.s�n�f=s�n�f;
	        this.cinsiyet=cinsiyet;
	        this.stajDurum=staj;
	        this.bolum=Bolum;
	        this.fakulte=Fakulte;
	    }
	    
	}

