package com.example.bilgiiyarismasii;

public class Sorular {
    public Sorular(int id, String soru, String dogru) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public String getSoru() {
        return soru;
    }

    public String getDogru() {
        return dogru;
    }

    public void setDogru(String dogru) {
        this.dogru = dogru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    String soru;
    String dogru;

}
