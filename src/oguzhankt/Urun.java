package oguzhankt;

import java.io.Serializable;
import java.util.ArrayList;

public class Urun implements Serializable {

    private String marka;
    private String model;
    private int miktar;
    private double maliyeti;
    private double satisFiyati;
    private ArrayList<String> urunAciklamasi;

    public Urun(String marka, String model, int miktar, double maliyeti, double satisFiyati, ArrayList<String> urunAciklamasi) {
        this.marka = marka;
        this.model = model;
        this.miktar = miktar;
        this.maliyeti = maliyeti;
        this.satisFiyati = satisFiyati;
        this.urunAciklamasi = urunAciklamasi;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public double getMaliyeti() {
        return maliyeti;
    }

    public void setMaliyeti(double maliyeti) {
        this.maliyeti = maliyeti;
    }

    public double getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(double satisFiyati) {
        this.satisFiyati = satisFiyati;
    }

    public ArrayList<String> getUrunAciklamasi() {
        return urunAciklamasi;
    }

    public void setUrunAciklamasi(ArrayList<String> urunAciklamasi) {
        this.urunAciklamasi = urunAciklamasi;
    }

    @Override
    public String toString() {
        return "Urun{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", miktar=" + miktar +
                ", maliyeti=" + maliyeti +
                ", satisFiyati=" + satisFiyati +
                ", urunAciklamasi=" + urunAciklamasi +
                '}';
    }
}
