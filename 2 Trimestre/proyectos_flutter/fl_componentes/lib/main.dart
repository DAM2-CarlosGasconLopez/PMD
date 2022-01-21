
import 'screens/screens.dart';
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false, // Quitar la marca de agua de arriba derecha

      title: 'Material App',
      //home: HomeScreen(),
      theme: ThemeData.light().copyWith(
        primaryColor: Colors.green,
        appBarTheme: const AppBarTheme(
          elevation: 0,
          backgroundColor: Colors.yellow,
        )
      ),
      initialRoute: 'home',
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