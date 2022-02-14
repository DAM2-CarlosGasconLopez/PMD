//import 'package:fl_componentes/themes/app_theme.dart';
import 'package:flutter/material.dart';

class CustomInputFormField extends StatelessWidget {
  final String? hintText;
  final String? labelText;
  final String? helperText;
  final IconData? iconData;
  final IconData? sufixIcon;
  final TextInputType? textInputType;
  final bool obscureText;

  // Recibimos el nombre del input que va a modificar  este valor
  final String formPropierty;

  // Propiedad que mantiene todos los valores de un formulario
  final Map<String, String> formValues;

  const CustomInputFormField({
    Key? key,
    this.hintText,
    this.labelText,
    this.helperText,
    this.iconData,
    this.sufixIcon,
    this.textInputType,
    this.obscureText = false,
    required this.formPropierty,
    required this.formValues,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return TextFormField(
      style: TextStyle(color: Colors.white),
      autofocus: false,
      keyboardType: textInputType,
      obscureText: obscureText,
      // initialValue: "Alberto",
      onChanged: (valor) => formValues[formPropierty] =
          valor, // capturar el valor que se esta introduciendo en el txto
      validator: (valor) {
        // Validamos que el campo TextFormField, este rellenado,

        //if( valor == "") return "Este campo es REQUERIDO";  // el text no puede ser 'NULL'

        if (valor == null)
          return "Este campo es REQUERIDO"; // Aqui puede ser nulo
        return valor.length < 6 ? 'Minimo de seis letras' : null;
      },
      // Le decimos cuando tiene que evaluar esto
      autovalidateMode: AutovalidateMode.onUserInteraction,
      decoration: InputDecoration(
          fillColor: Colors.white,
          border: OutlineInputBorder(
            borderRadius: BorderRadius.circular(15.0),
            borderSide: const BorderSide(color: Colors.white, width: 2.0),
          ),
          hintStyle: TextStyle(color: Colors.white),
          hintText: hintText,
          labelStyle: TextStyle(color: Colors.white),
          labelText: labelText,
          helperStyle: TextStyle(color: Colors.white),
          helperText: helperText,
          // counterText: 'Quedan 3 letras'
          suffixIconColor: Colors.white,
          suffixIcon: Icon(sufixIcon),
          // prefixIcon: Icon(Icons.accessible_forward)
          icon: iconData == null ? null : Icon(iconData)

          // border: OutlineInputBorder(
          //   borderRadius : BorderRadius.only(
          //       bottomLeft : Radius.circular(10),
          //       topRight   : Radius.circular(10)
          //   )
          // )

          ),
    );
  }
}
