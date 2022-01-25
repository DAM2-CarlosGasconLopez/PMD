import 'package:flutter/material.dart';
import 'screens/screens.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Material App',
      // home: HomeScreen(),
      theme: ThemeData.light().copyWith(
        primaryColor: Colors.green,
        appBarTheme: const AppBarTheme(
          elevation: 0,
          backgroundColor: Colors.green,
        )
      ),
      initialRoute: 'home',
      routes: {
        'pantalla1' : ( BuildContext context ) => pantalla_1Screen(),
        'pantalla2' : ( BuildContext context ) => pantalla_2Screen(),
        'pantalla3' : ( BuildContext context ) => pantalla_3Screen(),
        'pantalla4' : ( BuildContext context ) => pantalla_4Screen(),
        'pantalla5' : ( BuildContext context ) => pantalla_5Screen(),
      },
    );
  }
}