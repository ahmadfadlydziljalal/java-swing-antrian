/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


/**
 *
 * @author tmsdzil
 */
public class MainAntrian {
    
    private int id;
    private String date;
    private int counter_id;
    private int antrian_dilayani;
    private String counter_name;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCounter_name() {
        return counter_name;
    }

    public void setCounter_name(String counter_name) {
        this.counter_name = counter_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCounter_id() {
        return counter_id;
    }

    public void setCounter_id(int counter_id) {
        this.counter_id = counter_id;
    }

    public int getAntrian_dilayani() {
        return antrian_dilayani;
    }

    public void setAntrian_dilayani(int antrian_dilayani) {
        this.antrian_dilayani = antrian_dilayani;
    }
}
