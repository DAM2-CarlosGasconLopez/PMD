import 'package:flutter/material.dart';

class pantalla_1Screen extends StatelessWidget {
   
  const pantalla_1Screen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return  Scaffold(
      appBar: AppBar(title: const Text("Pantalla Inicio"),),
      body:  ListView(
        children: [
          ListTile(
            title    : const Text("Pantalla 3"),
            leading  : const Icon(Icons.screenshot_outlined),
            trailing : const Icon(Icons.arrow_back_ios_outlined),
            onTap: () => Navigator.pushNamed(context, 'pantalla3'),
          ),

          const Divider(),

          ListTile(
            title    : const Text("Pantalla 4"),
            leading  : const Icon(Icons.screenshot_outlined),
            trailing : const Icon(Icons.arrow_back_ios_outlined),
            onTap: () => Navigator.pushNamed(context, 'pantalla4'),
          ),

        ],
      )
    );
  }
}