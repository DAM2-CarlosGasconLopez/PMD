
//import 'package:fl_componentes/screens/listview1_screen.dart';
import 'package:fl_componentes/screens/alert_screen.dart';
import 'package:fl_componentes/screens/card_screen.dart';
import 'package:fl_componentes/screens/home_screen.dart';
import 'package:fl_componentes/screens/listview1_screen.dart';
import 'package:fl_componentes/screens/listview2_screen.dart';
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false, // Quitar la marca de agua de arriba derecha

      title: 'Material App',
      home: Listview2Screen(),
      routes: {
        'home'  : (BuildContext context ) => const HomeScreen(),
        'lista1': (BuildContext context ) =>  Listview1Screen(),
        'lista2': (BuildContext context ) =>  Listview2Screen(),
        'alerta': (BuildContext context ) => const AlertScreen(),
        'card'  : (BuildContext context ) => const CardScreen(),
      },
    );
  }
}