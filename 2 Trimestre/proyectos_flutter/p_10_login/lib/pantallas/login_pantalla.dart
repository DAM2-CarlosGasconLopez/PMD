import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';

import 'package:firebase_auth/firebase_auth.dart';
import 'package:p_10_login/pantallas/pantalla_vista.dart';
import 'package:p_10_login/widgets/CustomInputFormField.dart';

class LoginPage extends StatefulWidget {
  @override
  State<LoginPage> createState() => _LoginPageState();
}

final GlobalKey<FormState> myFormKey = GlobalKey<FormState>();

final Map<String, String> formvalues = {
  'email': '',
  'password': '',
};

class _LoginPageState extends State<LoginPage> {
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: Container(
          decoration: const BoxDecoration(
            image: DecorationImage(
              image: AssetImage("assets/fondo.jpg"),
              fit: BoxFit.cover,
            ),
          ),
          child: Center(
            child: Padding(
              padding: const EdgeInsets.symmetric(vertical: 5, horizontal: 20),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Flexible(
                    child: Image.asset(
                      'assets/flutter-icon.png',
                      height: 150.0,
                    ),
                  ),
                  const SizedBox(
                    height: 50.0,
                  ),
                  CustomInputFormField(
                    formPropierty: 'email',
                    formValues: formvalues,
                    hintText: 'ejemplo@correo.com',
                    labelText: 'E-Mail',
                    sufixIcon: Icons.email,
                    textInputType: TextInputType.emailAddress,
                  ),
                  const SizedBox(
                    height: 15.0,
                  ),
                  CustomInputFormField(
                    formPropierty: 'password',
                    formValues: formvalues,
                    hintText: '************',
                    labelText: 'Contrase??a',
                    sufixIcon: Icons.lock,
                    obscureText: true,
                  ),
                  const SizedBox(
                    height: 20.0,
                  ),
                  ElevatedButton(
                      onPressed: () async {
                        try {
                          //WidgetsFlutterBinding.ensureInitialized();

                          // Creamos una instancia de firebase
                          //await Firebase.initializeApp();
                          FirebaseAuth auth = FirebaseAuth.instance;

                          UserCredential userCredential = await FirebaseAuth
                              .instance
                              .signInWithEmailAndPassword(
                                  email: formvalues['email']!,
                                  password: formvalues['password']!);

                          Navigator.push(
                              context,
                              MaterialPageRoute(
                                  builder: (context) => PantallaVistaScreen(
                                        usuario: formvalues['email']!,
                                        contrasena: formvalues['password']!,
                                      )));
                        } catch (e) {
                          print(e);
                          ScaffoldMessenger.of(context).showSnackBar(
                              const SnackBar(content: Text("Algo ha fallado")));
                        }

                        //Navigator.pushNamed(context, 'pantalla_vista');
                        // Quitar teclado de pantalla
                        FocusScope.of(context).requestFocus(FocusNode());

                        // if (!myFormKey.currentState!.validate()) {
                        //   print("Fomulario no valido");
                        //   return;
                        // }
                        print(formvalues);
                      },
                      style: ElevatedButton.styleFrom(
                          primary: Colors.amber,
                          elevation: 0,
                          shape: const StadiumBorder()),
                      child: const SizedBox(
                        width: double.infinity,
                        child: Center(
                          child: Text('Iniciar Sesion'),
                        ),
                      ))
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
