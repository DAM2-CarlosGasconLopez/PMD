import 'package:flutter/material.dart';

class AppTheme{

  static const Color primary = Colors.orange;

  static final ThemeData lightTheme = ThemeData.light().copyWith(

        primaryColor: primary,

        // Estilo del AppBar
        appBarTheme: const AppBarTheme(
        elevation: 0,
        backgroundColor: primary,
        ),

        // Estilo de los TextButton
        textButtonTheme: TextButtonThemeData(
          style: TextButton.styleFrom(primary: primary)
        ),

        // Estilo de los Icons
         iconTheme: const IconThemeData(color: primary)
        
      );

    static final ThemeData oscuroTheme = ThemeData.dark().copyWith(

        primaryColor: Colors.pink,

        // Estilo del AppBar
        appBarTheme: const AppBarTheme(
        elevation: 0,
        backgroundColor: Colors.pink,
        ),

        // Estilo de los TextButton
        textButtonTheme: TextButtonThemeData(
          style: TextButton.styleFrom(primary: Colors.pink)
        ),
        scaffoldBackgroundColor:  Colors.black,

        // Estilo de los Icons

        iconTheme: const IconThemeData(color: Colors.pink,)

        
      );
}