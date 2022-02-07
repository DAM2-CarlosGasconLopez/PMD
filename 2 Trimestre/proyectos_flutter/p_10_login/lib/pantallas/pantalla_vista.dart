import 'package:flutter/material.dart';

class PantallaVistaScreen extends StatelessWidget {
  final String usuario;
  final String contrasena;

  const PantallaVistaScreen(
      {Key? key, required this.usuario, required this.contrasena})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.grey,
      body: Center(
        child: Padding(
          padding: const EdgeInsets.symmetric(vertical: 10, horizontal: 20),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text("Usuario:"),
              Text(
                usuario,
                style: TextStyle(
                  fontSize: 24, 
                  fontWeight: 
                  FontWeight.bold
                ),
              ),
              const SizedBox(
                height: 50.0,
              ),
              Text("Contraseña:"),
              Text(contrasena),
              const SizedBox(
                height: 50.0,
              ),
            ],
          ),
        ),
      ),
    );
  }
}
