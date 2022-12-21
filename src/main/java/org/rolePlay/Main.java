package org.rolePlay;

public class Main {
    public static void main(String[] args) {

        Calisan calisan = new Calisan(1, "mehmet", "akgul", 22000, "VINCOPERATORU");
        calisan.ehliyetTuru = new EhliyetTuru();
        calisan.ehliyetTuru.ucret = calisan.maas;
        calisan.ehliyetTuru.vardiya = "GECE";
        calisan.ehliyetTuru.sinifi = "VINCOPERATORU";
        calisan.ehliyetTuru.calismaSuresi = 15;

        Calisan calisan2 = new Calisan(2, "Eymen", "akgul", 22000, "KAMYONSURUCUSU");
        calisan2.tasimaTuru = new TasimaTuru();
        calisan2.tasimaTuru.km = 100;
        calisan2.tasimaTuru.aracCinsi = "KAMYON";
        calisan2.tasimaTuru.miktar = 20;

        System.out.println("=============== Ehliyet Turune Gore Calisan Maliyetinin Hesaplanmasi===============");
        System.out.println(calisan.toString());
        System.out.println("Toplam Maliyet" + calisan.ehliyetTuru.hesapla());

        System.out.println("=============== Tasima Turune Gore Arac Maliyetinin Hesaplanmasi===============");
        System.out.println(calisan2.toString());
        System.out.println("Toplam Maliyet" + calisan2.tasimaTuru.hesapla());
    }
}

class Calisan {
    int id;
    String name;
    String surname;
    double maas;
    String pozisyon;
    TasimaTuru tasimaTuru;
    EhliyetTuru ehliyetTuru;

    public Calisan(int id, String name, String surname, double maas, String pozisyon) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.maas = maas;
        this.pozisyon = pozisyon;
    }

    @Override
    public String toString() {
        return "Adi='" + name + '\'' + ", Soyadi='" + surname + '\'' + ", maasi=" + maas + ", pozisyon='" + pozisyon;
    }
}

class TasimaTuru extends Hesapla {
    double miktar;
    String aracCinsi;
    double km;
    private double kmfiyati;
    private double miktarfiyati;

    @Override
    public double hesapla() {

        if (this.aracCinsi.equals("KAMYON")) {
            kmfiyati = this.km * 53.87;
            miktarfiyati = this.miktar * 103.33;

        }
        if (this.aracCinsi.equals("TIR")) {
            kmfiyati = this.km * 62.33;
            miktarfiyati = this.miktar * 111.62;

        }

        return kmfiyati + miktarfiyati;
    }
}

class EhliyetTuru extends Hesapla {


    double calismaSuresi;
    String vardiya;
    String sinifi;

    private double hesaplanmisUcret;
    double ucret;


    @Override
    public double hesapla() {
        if (this.sinifi.equals("KAMYONSURUCUSU")) {
            hesaplanmisUcret = ucret;
            if (this.vardiya.equals("GUNDUZ") && this.calismaSuresi > 12) {
                hesaplanmisUcret = ucret * 1.21;
            }
            if (this.vardiya.equals("GECE")) {
                hesaplanmisUcret = ucret * 1.2533;
            }
        }
        if (this.sinifi.equals("VINCOPERATORU")) {
            hesaplanmisUcret = ucret * 1.55;
            if (this.vardiya.equals("GUNDUZ") && this.calismaSuresi > 12) {
                hesaplanmisUcret = ucret * 1.1925;
            }
            if (this.vardiya.equals("GECE")) {
                hesaplanmisUcret = ucret * 1.2742;
            }
        }
        return hesaplanmisUcret;
    }
}

abstract class Hesapla {
    public abstract double hesapla();

}



