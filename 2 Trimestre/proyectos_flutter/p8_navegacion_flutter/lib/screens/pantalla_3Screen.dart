import 'package:flutter/material.dart';

class pantalla_3Screen extends StatelessWidget {
   
  const pantalla_3Screen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
     appBar: AppBar(title: const Text("Pantalla 3"),),
      body:  ListView(
        children: [
          ListTile(
            title    : const Text("Pantalla 1"),
            leading  : const Icon(Icons.screenshot_outlined),
            trailing : const Icon(Icons.keyboard_arrow_right_sharp),
            onTap: () => Navigator.pushNamed(context, 'pantalla1'),
          ),

          const Divider(),

          ListTile(
            title    : const Text("Pantalla 2"),
            leading  : const Icon(Icons.screenshot_outlined),
            trailing : const Icon(Icons.keyboard_arrow_right_sharp),
            onTap: () => Navigator.pushNamed(context, 'pantalla2'),
          ),

        ],
      )
    );
  }
}