import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {
   
  const HomeScreen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return  Scaffold(
      appBar: AppBar(title: const Text("Home Screen"),),
      body:  ListView(
        children: [
          ListTile(
            title    : const Text("Lista Tipo 1"),
            leading  : const Icon(Icons.list),
            trailing : const Icon(Icons.arrow_back_ios_outlined),
            onTap: () => Navigator.pushNamed(context, 'lista1'),
          ),
         const Divider(),

         ListTile(
            title    : const Text("Lista Tipo 2"),
            leading  : const Icon(Icons.list),
            trailing : const Icon(Icons.arrow_back_ios_outlined),
            onTap: () => Navigator.pushNamed(context, 'lista2'),
          ),
         const Divider(),

         ListTile(
            title    : const Text("Alerta"),
            leading  : const Icon(Icons.list),
            trailing : const Icon(Icons.arrow_back_ios_outlined),
            onTap: () => Navigator.pushNamed(context, 'alerta'),
          ),
         const Divider(),

         ListTile(
            title    : const Text("Card"),
            leading  : const Icon(Icons.list),
            trailing : const Icon(Icons.arrow_back_ios_outlined),
            onTap: () => Navigator.pushNamed(context, 'card'),
          ),
         const Divider(),
         
        ],
      )
    );
  }
}