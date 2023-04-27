
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Login{
    
    private static final List<admin> adm = new ArrayList<admin>();
    private static final List<antrian> antr = new ArrayList<antrian>();
    private static int jumlahAntri = 0;

    public static void  clear(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    public static void pause(){
        System.out.println("Press enter to continue");
        new Scanner(System.in).nextLine();
    }

    public static void menuAdmin(){
        int inputUser;
        Scanner inputInt = new Scanner(System.in);
    
        do{
        System.out.println("\t\t\t  1.Lihat Antrian nasabah ");
        System.out.println("\t\t\t  2.Create data nasabah ");
        System.out.println("\t\t\t  3.Read data nasabah ");
        System.out.println("\t\t\t  4.Update(ubah) data nasabah ");
        System.out.println("\t\t\t  5.Delete data nasabah ");
        System.out.println("\t\t\t  6.Cari data nasabah ");
        System.out.println("\t\t\t  7.Back to menu Login ");
        System.out.println("\t\t\t  8.Exit\n");
        System.out.print("Masukan nomor program yang ingin di jalankan :");
        inputUser = inputInt.nextInt();
        switch(inputUser){
            case 1:
                lihatAntrianNasabah();
                break;
            case 2 :
                tambahDataNasabah();
                break;
            case 3 :
                lihatdataNasabah();
                break;
            case 4 :
                updateDataNasabah();
                break;
            case 5 :
                deleteDataNasabah();
                break;
            case 6 :
                cariDataNasabah();
                break;
            case 7 :
                Login log = new Login();
                clear();
                log.MenuLogin();
            case 8 :

                System.exit(0);
            default:
                System.out.println("nomor yang anda masukan salah !!!!");
        }


        }while(inputUser != 0);

    }

    public static void tambahDataNasabah(){
        String nama,alm;;
        long nomerRek;;
        int pin;;
        double saldo;;
        
        Scanner inputStr = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);

        System.out.print("Masukan Nama Nasabah : ");
        nama = inputStr.nextLine();
        System.out.print("Masukan PIN Nasabah : ");
        while (true) {
            try {
                // meminta input dari user
                pin = inputInt.nextInt();
                
                // keluar dari loop jika input adalah integer
                break;
                
            } catch (Exception e) {
                System.out.println("Maaf, input harus berupa angka.");
                System.out.print("Masukan PIN : ");
                inputInt.nextLine(); // membersihkan buffer input
            }
        }
        //membuat angka acak berjumlah 11 untuk no 
        ThreadLocalRandom random = ThreadLocalRandom.current();
        nomerRek = random.nextLong(10_000_000L, 100_000_000L);
        System.out.print("Masukan Alamat Nasabah : ");
        alm = inputStr.nextLine();
        saldo = 0;

        adm.add(new admin(nama,pin,alm,nomerRek,saldo));
        pause();
        clear();
    }

    public static void lihatdataNasabah(){
        Iterator<admin> i = adm.iterator();
                    System.out.println("\t\t\t\t~~~~~~ Data Nasabah ~~~~~~");
                    System.out.println("\tNo Rek     \tNama     \tPIN     \tAlamat     \tSaldo");
                    while(i.hasNext()){
                        admin adm = i.next();
                        System.out.print(adm);
                    }
        pause();
        clear();
    }

    public static void updateDataNasabah(){
        String nama,alm;;
        long nomerRek;;
        double saldo;;
        Scanner inputInt = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);

        clear();
        //lihat data nasabah
        Iterator<admin> i = adm.iterator();
                    System.out.println("\t\t\t\t~~~~~~ Data Nasabah ~~~~~~");
                    System.out.println("\tNo Rek     \tNama     \tPIN     \tAlamat     \tSaldo");
                    while(i.hasNext()){
                        admin adm = i.next();
                        System.out.print("\t\t"+adm);
                    }
        //proses update data
        System.out.print("\nMasukan no rekening data nasabah yang ingin di ubah(update) : ");
        nomerRek = inputInt.nextLong();
        ListIterator<admin> li = adm.listIterator();
                    
        while(li.hasNext()){
            admin admins = li.next();
            if(admins.getNoRek() == nomerRek){
                System.out.print("Masukan nama baru : ");
                nama = inputStr.nextLine();
                System.out.print("Masukan PIN baru : ");
                int pin = inputInt.nextInt();
                System.out.print("Masukan alamat baru : ");
                alm = inputStr.nextLine();
                saldo = admins.getsaldo();
                li.set(new admin(nama,pin,alm,nomerRek,saldo));
                
                System.out.println("data berhasil diubah !!!");
                pause();
                clear();
            }else{
                System.out.println("No Rekening yang anda masukan salah !!");
                pause();
                clear();
            }
        }
    }

    public static void deleteDataNasabah(){
        Scanner inputInt = new Scanner(System.in);

        clear();
        //lihat data nasabah
        Iterator<admin> i = adm.iterator();
                    System.out.println("\t\t\t\t~~~~~~ Data Nasabah ~~~~~~");
                    System.out.println("\tNo Rek     \tNama     \tPIN     \tAlamat     \tSaldo");
                    while(i.hasNext()){
                        admin adm = i.next();
                        System.out.print("\t\t"+adm);
                    }
        System.out.print("Masukan No Rekening nasabah yang ingin dihapus : ");
        Long nomerRek = inputInt.nextLong();
        i = adm.iterator();
                    while(i.hasNext()){
                        admin admins = i.next();
                        if(admins.getNoRek()== nomerRek){
                            i.remove();
                            System.out.println("Data Berhasil di Hapus");
                            pause();
                            clear();
                        }else{
                            System.out.println("nomor seri yang anda masukan salah!!!");
                            pause();
                            clear();
                        }
                    }

    }

    public static void cariDataNasabah(){
        
    }

    public static void lihatAntrianNasabah(){
        Iterator<antrian> i = antr.iterator();
                    System.out.println("\t\t\t\t~~~~~~ Data Nasabah ~~~~~~");
                    System.out.println("\tNo Antri     \tNo Rek     \tNama     \tPIN     \tAlamat     \tSaldo");
                    while(i.hasNext()){
                        antrian antr = i.next();
                        System.out.print("\t\t"+antr);
                    }
    }

    public static void tambahAntrian(long norek) {
        jumlahAntri++;
        String status;
        long noRek;
        Scanner input = new Scanner(System.in );
                            System.out.println("\t\t\tMenu Antrian");
                            System.out.println("\t\t1.Buka tabungan");
                            System.out.println("\t\t2.Update data rekening");
                            System.out.println("\t\t3.Hapus/tutup tabungan");
                            while (true) {
                                try {
                                    // meminta input dari user
                                    System.out.print("masukan pilihan menu antrian : ");
                                int pilMenAntr = input.nextInt();
                                switch(pilMenAntr){
                                    case 1 :
                                        status = "buka tabungan";
                                        antr.add(new antrian(status,jumlahAntri,0));
                                        break;
                                    case 2 :
                                        status = "update tabungan";
                                        System.out.println("Masukan Nomor Rekening : ");
                                        noRek = input.nextLong();
                                        antr.add(new antrian(status,jumlahAntri,noRek));
                                        break;
                                    case 3:
                                        status = "tutup tabungan";
                                        System.out.println("Masukan Nomor Rekening : ");
                                        noRek = input.nextLong();
                                        antr.add(new antrian(status,jumlahAntri,noRek));
                                        break;

                            }
                            

                                    
                                    // keluar dari loop jika input adalah integer
                                    break;
                                    
                                } catch (Exception e) {
                                    System.out.println("Maaf, input harus berupa angka.");
                                    input.nextLine(); // membersihkan buffer input
                                }
                            }
                            
                        
                    
        System.out.println("Antrian berhasil di tambahhkan");
                
    }
    
    // public void hapus() {
    //     if (antr.isEmpty()) {
    //         System.out.println("Antrian kosong.");
    //     } else {
    //         int nomor = antr.remove(0);
    //         System.out.println("Nomor antrian " + nomor + " telah dihapus dari antrian.");
    //     }
    // }
    
    public void tampilkan() {
        if (antr.isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Isi antrian:");
            for (int i = 0; i < antr.size(); i++) {
                System.out.println((i + 1) + ". Nomor antrian " + antr.get(i));
            }
        }
    }

    public static void menuNasabah(long nomerek){
        int inputUser;
        Scanner inputInt = new Scanner(System.in);
    
        do{
        System.out.println("\t\t\t  1.Ambil Antrian ");
        System.out.println("\t\t\t  2.Lihat Data");
        System.out.println("\t\t\t  3.Setor");
        System.out.println("\t\t\t  4.Tarik");
        System.out.println("\t\t\t  5.Back to menu Login ");
        System.out.println("\t\t\t  6.Exit\n");
        while (true) {
            try {
                // meminta input dari user
                System.out.print("Masukan nomor program yang ingin di jalankan :");
        inputUser = inputInt.nextInt();
        switch(inputUser){
            case 1 :
            clear();
                tambahAntrian(nomerek);
                pause();
                clear();
                break;
            case 2 :
                lihatData(nomerek);
                pause();
                clear();
                break;
            case 3 :
                setor(nomerek);
                break;
            case 4 :
                tarik(nomerek);
                break;
            case 5 :
                Login log = new Login();
                clear();
                log.MenuLogin();
                break;
            case 6 :
                System.exit(0);
            default:
                System.out.println("nomor yang anda masukan salah !!!!");
        }
                
                // keluar dari loop jika input adalah integer
                break;
                
            } catch (Exception e) {
                System.out.println("input harus berupa angka.");
                inputInt.nextLine(); // membersihkan buffer input
                pause();
                
            }
        
        }

        }while(inputUser != 0);
    }
    

    // public static void ambilAntrian(){
    //     for (int x = 1 ; x <= jumlahAntri ; x++){
            
    //     }
    // }

    public static void lihatData(long nomerek){
        Iterator<admin> i = adm.iterator();
                    System.out.println("\t\t\t\t~~~~~~ Data Nasabah ~~~~~~");
                    System.out.println("\tNo Rek     \tNama     \tPIN     \tAlamat     \tSaldo");
                    while(i.hasNext()){
                        admin adm = i.next();
                        if(adm.getNoRek() == nomerek){
                            System.out.print("\t\t"+adm);
                        }
                        
                    }
    }

    public static void setor(long nomerek){
        Scanner input = new Scanner(System. in);
        Iterator<admin> i = adm.iterator();
        while (true) {
            try {
                // meminta input dari user
                System.out.print("Masukan PIN : ");
                int pin = input.nextInt();
                i = adm.iterator();
                    while(i.hasNext()){
                        admin admins = i.next();
                        if(admins.getNoRek() == nomerek){      
                            if(admins.getPin() == pin){
                                System.out.print("Masukkan Jumlah Uang yang mau di setor : ");
                                Double jmlSetor = input.nextDouble();
                                double newSaldo = admins.getsaldo() + jmlSetor;
                                admins.setSaldo(newSaldo);
                                pause();
                                clear();
                            }     
                    }else{
                        System.out.println("pin yang anda masukan salah");
                    }
                }
                
                // keluar dari loop jika input adalah integer
                break;
                
            } catch (Exception e) {
                System.out.println("Maaf, input harus berupa angka.");
                input.nextLine(); // membersihkan buffer input
            }
        }

    }

    public static void tarik(long nomerek){
        Scanner input = new Scanner(System. in);
        Iterator<admin> i = adm.iterator();
        while (true) {
            try {
                // meminta input dari user
                System.out.print("Masukan PIN : ");
                int pin = input.nextInt();
                i = adm.iterator();
                    while(i.hasNext()){
                        admin admins = i.next();
                        if(admins.getNoRek() == nomerek){      
                            if(admins.getPin() == pin){
                                System.out.print("Masukkan Jumlah Uang yang mau di tarik : ");
                                double jmlTarik = input.nextDouble();
                                if(jmlTarik > admins.getsaldo()){
                                    System.out.println("Jumlah Saldo anda tidak mencukupi");
                                }else{
                                    double newSaldo = admins.getsaldo() - jmlTarik;
                                    admins.setSaldo(newSaldo);
                                }
                                pause();
                                clear();
                            }     
                    }else{
                        System.out.println("pin yang anda masukan salah");
                    }
                }
                
                // keluar dari loop jika input adalah integer
                break;
                
            } catch (Exception e) {
                System.out.println("Maaf, input harus berupa angka.");
                input.nextLine(); // membersihkan buffer input
            }
        }

    }
    

    

    public final void MenuLogin(){
        
        final int inputUser;
        long nomerREK = 0 ;
                int PIN = 0 ;
        Scanner inputInt = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);
        Login login = new Login();
        login.validasi("login");
        System.out.println("  Menu Awal");
        System.out.println("  1.Login Admin");
        System.out.println("  2.Login Nasabah");
        System.out.println("  3.Tambah Antrian\n");
        System.out.print("  Masukan Pilihan anda(1/2) : ");
        inputUser = inputInt.nextInt();
        
        switch(inputUser){
            case 1 :
                System.out.print("  Masukan Nama : ");
                String usernameA = inputStr.nextLine();
                System.out.print("  Masukan Password : ");
                String passwordA = inputStr.nextLine();
                cek(usernameA,passwordA);
                break;
            case 2 :
                cek(nomerREK, PIN);
                break;
            case 3 :
                tambahAntrian(nomerREK);
                break;
            default :
                System.out.println("Pilihan yang anda masukan salah !!!");
        }
    }

    //overloading
    public void cek(String usnm,String pw){
        if (usnm.equals("admin") ){
            if(pw.equals("admin")){  
                System.out.print("  Masukan Nama Admin : ");
                Scanner inputStr = new Scanner(System.in);
                String nama = inputStr.nextLine();
                clear();
                Login Admin = new Admin();
                Admin.validasi(usnm);
                Login log = new Login();
                log.identity(nama);
                menuAdmin();
            }else{
                System.out.println("Password salah!!!");
                pause();
                clear();
                MenuLogin();
            }
        }else{
            clear();
            System.out.println("Username salah!!");
            pause();
            clear();
            MenuLogin();
        }
    }
    //overloading
    public void cek(long nomerekNasabah,int pinNasabah){
        Scanner input = new Scanner(System.in );
        while (true) {
            try {
                // meminta input dari user
                System.out.print("  Masukan Nomer Rekening : ");
                nomerekNasabah = input.nextLong();
                System.out.print("  Masukan PIN : ");
                pinNasabah = input.nextInt();
                Iterator<admin> i = adm.iterator();
                i = adm.iterator();
                    while(i.hasNext()){
                        admin admins = i.next();
                        if(admins.getNoRek()== nomerekNasabah){
                            if(admins.getPin()== pinNasabah){
                                System.out.println("Login Nasabah Berhasil !!!");
                                System.out.print("Masukan nama : ");
                                String nama = input.nextLine();
                                Login customer = new customer();
                                customer.validasi(nama);
                                Login log = new Login();
                                log.identity(nomerekNasabah);
                                menuNasabah(nomerekNasabah);
                            }else{
                                System.out.println("Pin yang anda masukan salah !!!");
                                pause();
                                clear();
                                MenuLogin();
                            }
                            
                        }else{
                            System.out.println("nomor rekening yang anda masukan salah!!!");
                            pause();
                            clear();
                            MenuLogin();
                        }
                    }
                
                // keluar dari loop jika input adalah long
                break;
                
            } catch (Exception e) {
                System.out.println("  Maaf, input harus berupa angka.");
                input.nextLine(); // membersihkan buffer input
            }
        }
                
                }
            
               
    //overloading
    public void identity(String nama){
        
        System.out.println("\tNama Admin : "+nama);
    }
    //overloading
    public void identity(Long norek){
        System.out.println("Nomor Rekekning : "+norek);
    }
    
    public void validasi(String Username){
            System.out.println(" ->Menu Login");
        }  

class customer extends Login{
    @Override
    public void validasi(String Username){
        
        System.out.println("\t\t\t\t~~~~~ Sistem Manajemen Data Nasabah ~~~~~");
        System.out.println("\t\t\t\t~~~~~ Selamat Datang Di Menu Nasabah ~~~~~\n");
        System.out.println("\tUser : "+Username);
    }
    
}

class Admin extends Login{
    @Override
    public void validasi(String Username){
       
        System.out.println("\t\t\t\t~~~~~ Sistem Manajemen Data Nasabah ~~~~~");
        System.out.println("\t\t\t~~~~~ Selamat Datang Di Menu Admin ~~~~~\n");
        System.out.println("\tUser : "+Username);
    }
}
}





public final class Main {
    
    public static void main(String[] args) {
    Login log = new Login();
    log.MenuLogin();
        
    
    
    }
    
}


