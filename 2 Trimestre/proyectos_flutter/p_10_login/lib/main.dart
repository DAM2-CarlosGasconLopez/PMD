import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:p_10_login/pantallas/login_pantalla.dart';
import 'dart:async';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();

  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner:
            false, // Quitar la marca de agua de arriba derecha
        title: 'Material App',

        //home: HomeScreen(),
        //theme: AppTheme.lightTheme,
        initialRoute: 'login_page',
        routes: {
          'login_page': (BuildContext context) => LoginPage(),
        });
  }
}
