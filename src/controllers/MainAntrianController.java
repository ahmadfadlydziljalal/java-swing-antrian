/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import javax.swing.JTable;
import models.MainAntrian;
import models.dao.MainAntrianDAO;
import models.dao.MainAntrianInterface;
import models.table.TableModelAntrian;

/**
 *
 * @author tmsdzil
 */
public class MainAntrianController {

    private final JTable table;
    private List<MainAntrian> list;
    private final MainAntrianInterface antrianInterface;

    public MainAntrianController(JTable jTableMainAntrian) {
        this.table = jTableMainAntrian;
        antrianInterface = new MainAntrianDAO();
        list = antrianInterface.getAllAntrian();
    }

    public void getAll() {
        list = antrianInterface.getAllAntrian();        
        table.setModel(new TableModelAntrian(list));
    }
}
