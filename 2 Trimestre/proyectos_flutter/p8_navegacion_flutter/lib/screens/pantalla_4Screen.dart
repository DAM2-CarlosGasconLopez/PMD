import 'package:flutter/material.dart';

class pantalla_4Screen extends StatelessWidget {
   
  const pantalla_4Screen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Pantalla 4"),),
      body:  ListView(
        children: [
          ListTile(
            title    : const Text("Ir a Pantalla 3"),
            leading  : const Icon(Icons.screenshot_outlined),
            trailing : const Icon(Icons.keyboard_arrow_right_sharp),
            onTap: () => Navigator.pushNamed(context, 'pantalla3'),
          ),

          const Divider(),

          ListTile(
            title    : const Text("Ir a Pantalla 5"),
            leading  : const Icon(Icons.screenshot_outlined),
            trailing : const Icon(Icons.keyboard_arrow_right_sharp),
            onTap: () => Navigator.pushNamed(context, 'pantalla5'),
          ),

        ],
      )
    );
  }
}