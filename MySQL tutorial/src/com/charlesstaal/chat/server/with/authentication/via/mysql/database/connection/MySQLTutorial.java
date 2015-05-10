/* 
 * Copyright (C) 2015 Charles
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.charlesstaal.chat.server.with.authentication.via.mysql.database.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Charles
 */
public class MySQLTutorial {

    /**
     * @param args the command line arguments
     */
    private static final Logger log = LoggerFactory.getLogger(MySQLTutorial.class);
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
        String url = "jdbc:mysql://localhost:3306/MySQL";
        String user = "root";
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter password [IM NOT HARD CODING IT, GITHUB BOTS! :");
        String password = sc.nextLine();
        
        try{
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("SELECT VERSION()");
            
            if(rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch(SQLException ex){
            log.error("Connection not established.", ex);
        }
    }
    
}
