import 'package:fl_componentes/themes/app_theme.dart';
import 'package:flutter/material.dart';

class TargetaTipo1 extends StatelessWidget {
  const TargetaTipo1({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Column(
        children: [
          const ListTile(
            leading: Icon(Icons.photo_album_outlined,),
            title: Text("Titulo"),
            subtitle: Text("Al contrario del pensamiento popular, el texto de Lorem Ipsum no es simplemente texto aleatorio." 
                           "Tiene sus raices en una pieza clasica de la literatura del Latin, que data del año 45 antes de Cristo, "),
          ),
          Padding(
            padding: const EdgeInsets.only(right: 5),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.end,
              children: [

                TextButton(
                  onPressed: (){}, 
                  child: const Text("Ok")
                  ),
                
                TextButton(
                  onPressed: (){}, 
                  child: const Text("Cancelar")
                  ),
              ],
            ),
          )
        ],
      ),
    );
  }
}