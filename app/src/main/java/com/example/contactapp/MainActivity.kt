package com.example.contactapp
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
        class MainActivity : AppCompatActivity() {
lateinit var conn:Connection
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                conn=DBConnection.createConnection()

                                try {
                                    if (conn != null) {

                                        Toast.makeText(
                                            this,
                                            "Connection establsished sucessfully",
                                            Toast.LENGTH_LONG
                                        ).show()


                                    } else {
                                        Toast.makeText(
                                            this,
                                            "Connection not establsished sucessfully",
                                            Toast.LENGTH_LONG
                                        ).show()


                                    }
                                }catch (E: SQLException){
                                    E.message?.let { Log.e("Error in main", it, ) }
                                }


            }


        }

