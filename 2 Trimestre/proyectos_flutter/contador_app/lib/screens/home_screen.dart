import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {

  final tamano30 = const TextStyle(fontSize: 30, fontWeight: FontWeight.bold);

  int contador = 15;


  @override
  Widget build(BuildContext context) {
    return  Scaffold(
      appBar:  AppBar(
        title: const Text("App Contador"), // Titulo de la app
        elevation: 10, // Degradado en la parte de arriba (sombra)
      ),
      backgroundColor: Colors.white, // Color de fondo
        body: Center( // Forma de alinear a lo ancho de la pantalla
          child: Column( // Cuerpo constituido por una columna
            mainAxisAlignment: MainAxisAlignment.center, // Forma de alinear la columna a lo largo

            children: [
              const Text("Numero de Taps:", style: TextStyle(fontSize: 45 /* Tamaño letra*/ ),),
              
              Text( "$contador", style: tamano30),

            ],),
        ),
        

        
        floatingActionButton: FloatingActionButton( // Punto de control abajo derecha

          child: const Icon(Icons.add),        
          onPressed: (){
            
            contador++;
           },
        ),
        
        floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,

      );
  }
}