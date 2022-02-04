//State class
import 'package:curved_navigation_bar/curved_navigation_bar.dart';
import 'package:flutter/material.dart';

class Carlos extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => widgetCarlosScreen();
}

class widgetCarlosScreen extends State<Carlos> {
  int _page = 0;
  final GlobalKey<CurvedNavigationBarState> _bottomNavigationKey = GlobalKey();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        bottomNavigationBar: CurvedNavigationBar(
          key: _bottomNavigationKey,
          backgroundColor: Colors.orange,
          items: const <Widget>[
            Icon(Icons.add, size: 30),
            Icon(Icons.list, size: 30),
            Icon(Icons.compare_arrows, size: 30),
          ],
          onTap: (index) {
            setState(() {
              _page = index;
            });
          },
        ),
        body: Container(
          color: Colors.orange,
          child: Center(
            child: Column(
              children: <Widget>[
                Text(
                  _page.toString(),
                  textScaleFactor: 11.0,
                  style: const TextStyle(color: Colors.white),
                ),
                ElevatedButton(
                  child: Text('Volver a Home'),
                  style: ElevatedButton.styleFrom(primary: Colors.grey),
                  onPressed: () {
                    Navigator.pushNamed(context, 'home');
                  },
                )
              ],
            ),
          ),
        ));
  }
}
