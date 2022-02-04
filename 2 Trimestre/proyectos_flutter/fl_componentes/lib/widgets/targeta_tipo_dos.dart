import 'package:flutter/material.dart';

class TargetaTipo2 extends StatelessWidget {
  final String urlImagen;
  String? txtImagen;

  TargetaTipo2({Key? key, required this.urlImagen, this.txtImagen})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      elevation: 5,
      shadowColor: Colors.white.withOpacity(0.5),
      clipBehavior: Clip.antiAlias,
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(17)),
      child: Column(
        children: [
          FadeInImage(
            image: NetworkImage(urlImagen),
            placeholder: const AssetImage("assets/jar-loading.gif"),
            width: double.infinity,
            height: 230,
            fit: BoxFit.cover,
            fadeInDuration: const Duration(milliseconds: 2000),
          ),
          if (txtImagen != null)
            Container(
              alignment: AlignmentDirectional.centerEnd,
              padding: const EdgeInsets.only(right: 20, top: 10, bottom: 10),
              child:
                  Text(txtImagen!), // Te seguro por mis huevos que sale texto
            )
        ],
      ),
    );
  }
}
