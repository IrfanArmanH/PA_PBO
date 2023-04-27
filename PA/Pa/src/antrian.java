import java.io.ObjectInputFilter.Status;

public class antrian implements AntrianBank{
    private Integer antri;
    private String status;
    private String StatusAntri;
    private long noRek ;


    public void setNoRek(long noRek) {
        this.noRek =noRek;
    }
    public long getNoRek() {
        return noRek;
    }

    public long getAntrian() {
        return antri;
    }

    public void setAntri(Integer antri) {
        this.antri = antri;
    } 

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    } 

    public String cekStatusAntrian() {
        if (antri == 0) {
            StatusAntri = "Tidak Ada Antrian";
        } else if (antri <= 3) {
            StatusAntri = "Antrian Sedikit";
        } else {
            StatusAntri = "Antrian Banyak";
        }
        return StatusAntri;
    }

    public antrian(String status,Integer antri,long noRek)  {
        this.antri = antri ;
        this.status = status;
    }

    public String toString(){
        return status + "\t" + antri + "\t" + noRek+"\t" + "\n";
    }
}