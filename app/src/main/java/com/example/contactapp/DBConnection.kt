
package com.example.contactapp

import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


object DBConnection {

   lateinit var con: Connection

   fun  createConnection() : Connection {
       val ip= "204.93.178.157"
       val port="1433"
       val db="sayed123_elec"
       val un="sayed123_elec"
       val pass="elec@12345"


        val policy=StrictMode.ThreadPolicy.Builder().permitAll().build()
StrictMode.setThreadPolicy(policy)

       try {
           Class.forName("net.sourceforge.jtds.jdbc.Driver")
           val url =
               "jdbc:jtds:sqlserver://$ip:$port;databasename=$db;user=$un;password=$pass;"
             con = DriverManager.getConnection(url)
       }
       catch (e: SQLException) {
           e.message?.let { Log.e("Error1", it, ) }
       }catch (e: ClassNotFoundException) {
           // Handle Class.forName exceptions
           e.message?.let { Log.e("Errorclass", it, ) }
       }

return con

    }
}

