import 'package:flutter/material.dart';

class ContadorScreen extends StatefulWidget {

  @override
  State<ContadorScreen> createState() => _ContadorScreenState();
}

class _ContadorScreenState extends State<ContadorScreen> {
  final tamano30 = const TextStyle(fontSize: 30, fontWeight: FontWeight.bold);

  int contador = 15;

  @override
  Widget build(BuildContext context) {
    return  Scaffold(
      appBar:  AppBar(
        title: const Text("Contador DAM-2"), // Titulo de la app
        elevation: 10, // Degradado en la parte de arriba (sombra)
        backgroundColor: Colors.black,
      ),
      
      backgroundColor: Colors.yellow, // Color de fondo
        body: Center( // Forma de alinear a lo ancho de la pantalla
          child: Column( // Cuerpo constituido por una columna
            mainAxisAlignment: MainAxisAlignment.center, // Forma de alinear la columna a lo largo

            children: [
              const Text("Numero de Taps:", style: TextStyle(fontSize: 45 /* Tamaño letra*/ ),),
              
              Text( "$contador", style: tamano30),

            ],),
        ),
        


        // Botones en la misma fila    
        floatingActionButton: Row(

          mainAxisAlignment: MainAxisAlignment.spaceEvenly, //Alineamos los botones

          children: [
            
            FloatingActionButton( // Punto de control abajo derecha
              child: const Icon(Icons.remove),  
              backgroundColor: Colors.black, 
                   
              onPressed: (){
                
                contador--;
                setState(() { /* contador++;  */  /* Llamamos al setState para refrescar el estado de la app, el contador++, puede estar fuera, o dentro del set state*/ }); 
                
               },
            ),
            
            //const SizedBox(width: 20,),  separacion entre botones

            FloatingActionButton( // Punto de control abajo derecha
              child: const Icon(Icons.restore), 
              backgroundColor: Colors.black,  
                   
              onPressed: (){
                
                contador = 0;
                setState(() { /* contador++;  */  /* Llamamos al setState para refrescar el estado de la app, el contador++, puede estar fuera, o dentro del set state*/ }); 
                
               },
            ),

            FloatingActionButton( // Punto de control abajo derecha
              child: const Icon(Icons.add),   
              backgroundColor: Colors.black,
                   
              onPressed: (){
                
                contador++;
                setState(() { /* contador++;  */  /* Llamamos al setState para refrescar el estado de la app, el contador++, puede estar fuera, o dentro del set state*/ }); 
                
               },
            ),
          ],
        ),
        
        // floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,

      );
  }
}