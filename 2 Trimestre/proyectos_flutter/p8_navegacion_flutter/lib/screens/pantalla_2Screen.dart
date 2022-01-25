import 'package:flutter/material.dart';

class pantalla_2Screen extends StatelessWidget {
   
  const pantalla_2Screen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
       appBar: AppBar(title: const Text("Pantalla 2"),),
      body:  ListView(
        children: [
          ListTile(
            title    : const Text("Ir a la Pantalla 5"),
            leading  : const Icon(Icons.screenshot_outlined),
            trailing : const Icon(Icons.keyboard_arrow_right_sharp),
            onTap: () => Navigator.pushNamed(context, 'pantalla5'),
          ),
        ]
      )
    );
  }
}