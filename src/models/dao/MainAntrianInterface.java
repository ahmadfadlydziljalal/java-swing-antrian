/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.util.List;
import models.MainAntrian;

/**
 *
 * @author tmsdzil
 */
public interface  MainAntrianInterface {
    public void create(MainAntrian mainAntrian);
    
    public void update(MainAntrian mainAntrian);
    
    public void delete(int id);
    
    public List<MainAntrian> getAntrian(int id);
    
    public List<MainAntrian> getAntrianByDate(String date);
    
    public List<MainAntrian> getAllAntrian();
}
