import 'package:flutter/material.dart';

class AppTheme{

  static const Color primary1 = Colors.orange;
  static const Color primary2 = Colors.blue;

  static final ThemeData lightTheme = ThemeData.light().copyWith(

        primaryColor: primary1,

        // Estilo del AppBar
        appBarTheme: const AppBarTheme(
        elevation: 0,
        backgroundColor: primary1,
        ),

        // Estilo de los TextButton
        textButtonTheme: TextButtonThemeData(
          style: TextButton.styleFrom(primary: primary1)
        ),

        //FloatingActionButtons

        floatingActionButtonTheme: const FloatingActionButtonThemeData(
          backgroundColor: primary1,
          elevation: 5
        ),

        //ElevatedButtons

        elevatedButtonTheme: ElevatedButtonThemeData(
            style: ElevatedButton.styleFrom(
            primary: primary1,
            elevation: 0,
            shape: const StadiumBorder()
            ),
        ),

        // Estilo de los Icons
         iconTheme: const IconThemeData(color: primary1)
        
      );

    static final ThemeData oscuroTheme = ThemeData.dark().copyWith(

        primaryColor: primary2,

        // Estilo del AppBar
        appBarTheme: const AppBarTheme(
        elevation: 0,
        backgroundColor: primary2,
        ),

        // Estilo de los TextButton
        textButtonTheme: TextButtonThemeData(
          style: TextButton.styleFrom(primary: primary2)
        ),
        scaffoldBackgroundColor:  Colors.black,

        //FloatingActionButtons

        floatingActionButtonTheme: const FloatingActionButtonThemeData(
          backgroundColor: primary2,
          elevation: 5
        ),

        //ElevatedButtons

        elevatedButtonTheme: ElevatedButtonThemeData(
            style: ElevatedButton.styleFrom(
            primary: primary2,
            elevation: 0,
            shape: const StadiumBorder()
            ),
        ),
    
    
        // Estilo de los Icons

          iconTheme: const IconThemeData(color: primary2,)

    );
}