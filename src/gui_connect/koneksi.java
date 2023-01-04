/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author didik
 */
public class koneksi {

    Connection kon;

    private final String driver = "com.mysql.jdbc.Driver";
    private String url="";
    private String username="";
    private String password="";
    int error;
    

    //method untuk melakukan koneksi ke server database
    public void logon(String url,String username,String password, String db) {
        this.url="jdbc:mysql://"+url+"/"+db;
        this.username=username;
        this.password=password;
        try {
            Class.forName(driver).newInstance();
            kon = DriverManager.getConnection(this.url, this.username, this.password);

        } catch (Exception e) {
           if(e==null){
                error=0;
           }
           else if(e!=null){
                error=1;
           }
        }
    }

    //untuk mendapatkan status error tidaknya koneksi
    public int getErrorStatus(){
        return error;
    }

    //fungsi logoff,memutus koneksi
    public void logoff() {
        try {
            kon.close();
        } catch (Exception e) {
        }
    }

    public Connection conn(){
        return kon;
    }
}
