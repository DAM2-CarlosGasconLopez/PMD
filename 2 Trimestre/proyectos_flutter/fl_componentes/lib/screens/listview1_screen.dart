import 'package:flutter/material.dart';

class Listview1Screen extends StatelessWidget {
   
  final opciones = ['Ferrari','Audi','Seat Panda','Mercedes Benz','Ford','VolksWagen'];

  Listview1Screen({Key? key}) : super(key: key);

  // const Listview1Screen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Lista de Elementos"), centerTitle: true, elevation: 10,), // Barra del titulo, centrado y con sombra
      body: ListView(
        children:  [
          
          // El operador spread extrae cada uno de los elementos 
          // y devuelve un nuevo elemento
          ...opciones.map(
            (marca) => ListTile(
              title: Text(marca),
              leading: const Icon(Icons.car_repair),
              trailing: const Icon(Icons.arrow_forward_ios_outlined),
              onTap: () {
                print("Hola Carlos");
              }
              ),
            ).toList() 

             


          // ListTile(
          //   title: Text("Hola a DAM"),
          //   leading: Icon(Icons.car_repair),
          //   trailing: Icon(Icons.arrow_forward_ios_outlined),
          //   onTap: () {
          //   }
          // ),

          // Divider(color: Colors.blue,),

          // ListTile(
          //   title: Text("Hola a DAM"),
          //   leading: Icon(Icons.car_repair),
          //   trailing: Icon(Icons.arrow_forward_ios_outlined),
          // ),   

          // Divider(color: Colors.blue,),

        ],
      )
    );
  }
}