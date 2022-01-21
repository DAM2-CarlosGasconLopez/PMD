
import 'package:contador_app/screens/contador_screen.dart';
//import 'package:contador_app/screens/home_screen.dart';
import 'package:flutter/material.dart';

void main() {
  runApp( MyApp() );
  
}

class MyApp extends StatelessWidget{

  @override
  Widget build(BuildContext context) {
    
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: ContadorScreen()
      
    );
  }

}