public class admin extends dataNasabah{
    public String getNamaNasabah() {
        return namaNasabah;
    }
    
    public void setNamaNasabah(String namaNasabah) {
        this.namaNasabah = namaNasabah;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }


    public void setNoRek(long noRek) {
        this.noRek =noRek;
    }
    public long getNoRek() {
        return noRek;
    }

    public void setPin(int pin) {
        this.pin =pin;
    }
    public int getPin() {
        return pin;
    }

    public double getsaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    } 
    
    
    public admin(String namaNasabah,int pin,String alamat,long noRek,double saldo)  {
        super(namaNasabah,pin,alamat,noRek,saldo);

    }
}
