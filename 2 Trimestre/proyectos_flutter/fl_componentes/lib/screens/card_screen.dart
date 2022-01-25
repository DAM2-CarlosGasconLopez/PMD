import 'package:fl_componentes/widgets/widgets.dart';
import 'package:flutter/material.dart';

class CardScreen extends StatelessWidget {
   
  const CardScreen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.blueGrey,
      appBar: AppBar(
        title: const Text("Targetas"),

        ),
      body: ListView(
        padding: const EdgeInsets.symmetric(vertical: 20,horizontal: 10),
        children: [

          const TargetaTipo1(),
          const SizedBox(height: 7,),
          TargetaTipo2(txtImagen: "Plaza Cantavieja", urlImagen: "https://www.turismodearagon.com/wp-content/uploads/2018/10/Cantavieja-3.jpg" ),
          const SizedBox(height: 7,),
          const TargetaTipo1(),
          const SizedBox(height: 7,),
          TargetaTipo2(txtImagen: "Paisaje Cantavieja", urlImagen: "https://espanafascinante.com/wp-content/uploads/principal_que-ver-en_arag%C3%B3n_teruel_cantavieja.jpg"),
          const SizedBox(height: 7,),
          const TargetaTipo1(),
          const SizedBox(height: 7,),
          TargetaTipo2(urlImagen: "https://espanafascinante.com/wp-content/uploads/principal_que-ver-en_arag%C3%B3n_teruel_cantavieja.jpg"),
          const SizedBox(height: 7,),
          const TargetaTipo1(),
          const SizedBox(height: 7,),
          TargetaTipo2(urlImagen: "https://www.turismodearagon.com/wp-content/uploads/2018/10/Cantavieja-3.jpg"),
          const SizedBox(height: 7,),
          
          
        ],
      )
    );
  }
}

