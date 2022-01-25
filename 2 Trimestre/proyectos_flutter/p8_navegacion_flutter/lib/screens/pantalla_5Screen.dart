import 'package:flutter/material.dart';
import 'package:p8_navegacion_flutter/screens/pantalla_1Screen.dart';

class pantalla_5Screen extends StatelessWidget {
   
  const pantalla_5Screen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
     appBar: AppBar(title: const Text("Pantalla 5"),),
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

           const Divider(),

          ListTile(
            title    : const Text("Pantalla 4"),
            leading  : const Icon(Icons.screenshot_outlined),
            trailing : const Icon(Icons.keyboard_arrow_right_sharp),
            onTap: () => Navigator.pushNamed(context, 'pantalla4'),
          ),

           const Divider(),

          ListTile(
            title    : const Text("Eliminar pantallas y volver a INICIO"),
            leading  : const Icon(Icons.screenshot_outlined),
            trailing : const Icon(Icons.keyboard_arrow_right_sharp),
            onTap: () => Navigator.of(context).pushAndRemoveUntil(MaterialPageRoute(builder: (context) => const pantalla_1Screen()), (Route<dynamic> route) => false),
          ),

        ],
      )
    );
  }
}