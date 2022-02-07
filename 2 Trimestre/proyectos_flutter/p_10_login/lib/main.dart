import 'package:flutter/material.dart';
import 'package:p_10_login/pantallas/login_pantalla.dart';
import 'package:p_10_login/pantallas/pantalla_vista.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    
    
    return MaterialApp(
      
      debugShowCheckedModeBanner: false, // Quitar la marca de agua de arriba derecha
      title: 'Material App',
      
      //home: HomeScreen(),
      //theme: AppTheme.lightTheme,
      initialRoute: 'login_page',
      routes: {
        'login_page' : (BuildContext context) => LoginPage(),       
      }
      
    );
    
  }
}
