import 'package:fl_componentes/themes/app_theme.dart';
import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text("Home Screen"),
        ),
        body: ListView(
          children: [
            ListTile(
              title: const Text("Lista Tipo 1"),
              leading: const Icon(
                Icons.list_alt,
              ),
              trailing: const Icon(Icons.arrow_back_ios_outlined),
              onTap: () => Navigator.pushNamed(context, 'lista1'),
            ),
            const Divider(),
            ListTile(
              title: const Text("Lista Tipo 2"),
              leading: const Icon(Icons.list_alt_sharp),
              trailing: const Icon(Icons.arrow_back_ios_outlined),
              onTap: () => Navigator.pushNamed(context, 'lista2'),
            ),
            const Divider(),
            ListTile(
              title: const Text("Alerta"),
              leading: const Icon(Icons.align_vertical_bottom),
              trailing: const Icon(Icons.arrow_back_ios_outlined),
              onTap: () => Navigator.pushNamed(context, 'alerta'),
            ),
            const Divider(),
            ListTile(
              title: const Text("Card"),
              leading: const Icon(Icons.card_giftcard),
              trailing: const Icon(Icons.arrow_back_ios_outlined),
              onTap: () => Navigator.pushNamed(context, 'card'),
            ),
            const Divider(),
            ListTile(
              title: const Text("Formulario"),
              leading: const Icon(Icons.face_outlined),
              trailing: const Icon(Icons.arrow_back_ios_outlined),
              onTap: () => Navigator.pushNamed(context, 'form'),
            ),
            const Divider(),
            ListTile(
              title: const Text("Widget"),
              leading: const Icon(Icons.widgets),
              trailing: const Icon(Icons.arrow_back_ios_outlined),
              onTap: () => Navigator.pushNamed(context, 'miwidget'),
            ),
          ],
        ));
  }
}
