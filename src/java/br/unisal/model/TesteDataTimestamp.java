/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pensadorx
 */
    public class TesteDataTimestamp {

    public static void main(String args[]) {
        Date paraFormatar = new Date();
        System.out.println("Antes: " + paraFormatar.toString());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");//formato esperado para Timestamp
        String dataParaInserirNoBd = dateFormat.format(paraFormatar);
        Date d = Timestamp.valueOf(dataParaInserirNoBd);
        System.out.println("Depois: " + d);
    }
}
