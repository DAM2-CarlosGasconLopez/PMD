//import 'package:fl_componentes/themes/app_theme.dart';

import 'screens/screens.dart';
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner:
          false, // Quitar la marca de agua de arriba derecha

      title: 'Material App',
      //home: HomeScreen(),
      //theme: AppTheme.lightTheme,
      initialRoute: 'home',
      routes: {
        'home': (BuildContext context) => const HomeScreen(),
      },
    );
  }
}
