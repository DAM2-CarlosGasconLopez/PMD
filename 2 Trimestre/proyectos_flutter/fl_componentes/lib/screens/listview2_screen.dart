import 'package:flutter/material.dart';

class Listview2Screen extends StatelessWidget {
   
  final opciones = ['Ferrari','Audi','Seat Panda','Mercedes Benz','Ford','VolksWagen'];

  Listview2Screen({Key? key}) : super(key: key);

  // const Listview1Screen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.indigo,
      appBar: AppBar(title: const Text("Lista de Elementos 2"), centerTitle: true, elevation: 10,), // Barra del titulo, centrado y con sombra
      body: ListView.separated(
        // 
        itemBuilder: (context, index) { 
          return ListTile(
            title: Text(opciones[index]), 
            trailing: const Icon(Icons.arrow_forward_ios_outlined),
            onTap: () {
              var marca = opciones[index];
              print(marca);
            },
            ); 
          
          
        }, 
        // Me esta pidiendo el widget que quiere que use como separador
        separatorBuilder: ( _ , __) => const Divider(),
        // Numero de elementos en la lista. Los elementos NO SE RENDERIZAN de manera instantanea
        itemCount: opciones.length)

    );
  }
}



