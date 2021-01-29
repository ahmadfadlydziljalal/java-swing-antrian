/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import config.db;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import models.MainAntrian;
import utils.DateHelper;
import java.sql.PreparedStatement;

/**
 *
 * @author tmsdzil
 */
public class MainAntrianDAO implements MainAntrianInterface {

    private List<MainAntrian> list;

    @Override
    public void create(MainAntrian antrian) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(MainAntrian antrian) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MainAntrian> getAntrian(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MainAntrian> getAntrianByDate(String date) {
//          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        list = new ArrayList<MainAntrian>();

        try {

            // CHECK APAKAH ADA RECORD UNTUK TANGGAL AKTIF ?
            PreparedStatement ps = db.getConnection().prepareStatement("SELECT COUNT(*) as count FROM antrian WHERE antrian.date =?");
            ps.setString(1, DateHelper.todayFormatYYYYMMDD());
            ResultSet resultCount = ps.executeQuery();
            int count = resultCount.getInt("count");
           
            if (count == 0) {
                
                // Panggil semua data counter kasir
                // Cek perbedaan konter_id  Insert data yang baru
                MainAntrian mainAntrian = new MainAntrian();
                    
            }
            resultCount.close();

            Statement statement = db.getConnection().createStatement();
            ResultSet result2 = statement.executeQuery("SELECT counter.name as counter_name, antrian_dilayani FROM antrian INNER JOIN counter ON counter.id = antrian.counter_id");
            while (result2.next()) {
                MainAntrian mainAntrian = new MainAntrian();
                mainAntrian.setCounter_name(result2.getString("counter_name"));
                mainAntrian.setAntrian_dilayani(Integer.parseInt(result2.getString("antrian_dilayani")));
                list.add(mainAntrian);
            }

            statement.close();
            result2.close();
            return list;
        } catch (SQLException ex) {
            //Logger.getLogger(AntrianDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<MainAntrian> getAllAntrian() {
        list = new ArrayList<MainAntrian>();
        try {

            Statement statement = db.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT counter.name as counter_name, antrian_dilayani FROM antrian INNER JOIN counter ON counter.id = antrian.counter_id");
            
            
            

            while (result.next()) {

                MainAntrian mainAntrian = new MainAntrian();

                mainAntrian.setCounter_name(result.getString("counter_name"));
                mainAntrian.setAntrian_dilayani(Integer.parseInt(result.getString("antrian_dilayani")));
                list.add(mainAntrian);
            }

            statement.close();
            result.close();
            return list;
        } catch (SQLException ex) {
            //Logger.getLogger(AntrianDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
