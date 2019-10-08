/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.EfectivoDAO;
import DAO.TCDAO;
import DAO.TDDAO;
import DAO.gastoDAO;
import com.google.gson.Gson;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class Negocio{
    gastoDAO daogasto = new gastoDAO();
    EfectivoDAO daoefectivo = new EfectivoDAO();
    TCDAO daoTC = new TCDAO();
    TDDAO daoTD = new TDDAO();
    public void guardarGasto(String json) throws SQLException{
        Gasto gasto = convertGastoFromJson(json);
        daogasto.insertar(gasto);
    }
    public void guardarEfectivo(String json) throws SQLException {
        Efectivo efectivo = convertEfectivoFromJson(json);
        daoefectivo.insertar(efectivo);
        
    }
    public void guardarTC(String json) throws SQLException {
        TarjetaCredito TC = convertTCFromJason(json);
        daoTC.insertar(TC);
    }
    public void guardarTD(String json) throws SQLException {
        TarjetaDebito TD = convertTDFromJson(json);
        daoTD.insertar(TD); 
    }
    private Gasto convertGastoFromJson(String json){
        Gson gson = new Gson();
        Gasto gasto = gson.fromJson(json, Gasto.class);
        System.out.println(gasto.getDescripcion());
        return gasto;
    }

    private Efectivo convertEfectivoFromJson(String json) {
        Gson gson = new Gson();
        Efectivo efectivo = gson.fromJson(json, Efectivo.class);
        return efectivo;
    }

    private TarjetaDebito convertTDFromJson(String json) {
        Gson gson = new Gson();
        TarjetaDebito TD = gson.fromJson(json, TarjetaDebito.class);
        return TD;
    }

    private TarjetaCredito convertTCFromJason(String json) {
        Gson gson = new Gson();
        TarjetaCredito TC = gson.fromJson(json, TarjetaCredito.class);
        return TC;
    }

    
}
