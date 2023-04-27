

public abstract class dataNasabah {
    protected String namaNasabah,alamat;
    protected long noRek ;
    protected int pin ;
    protected double saldo;
    
    dataNasabah(String namaNasabah,int pin,String alamat,long noRek,double saldo)  {
        this.namaNasabah = namaNasabah;
        this.pin = pin;
        this.alamat = alamat;
        this.noRek = noRek;
        this.saldo = saldo;
    }

    abstract void setNamaNasabah(String namaNasabah);
    abstract void setAlamat(String alamat);
    abstract void setNoRek(long noRek);
    abstract void setSaldo(double saldo);
    abstract void setPin(int pin);
    abstract String getNamaNasabah();
    abstract long getNoRek();
    abstract int getPin();
    abstract String getAlamat();
    abstract double getsaldo();
    public String toString(){
        return "\t" + noRek+"\t"+namaNasabah+"\t"+pin+"\t"+alamat+"\t"+saldo+"\n";
    }
    
    
    
}
