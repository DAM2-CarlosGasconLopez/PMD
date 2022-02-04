
import 'package:fl_componentes/themes/app_theme.dart';
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
      autofocus: false,
      keyboardType: textInputType,
      obscureText: obscureText,
      textCapitalization: TextCapitalization.words,
      // initialValue: "Alberto",
      onChanged: ( valor ) => formValues[formPropierty] = valor, // capturar el valor que se esta introduciendo en el txto
      validator: ( valor ) { // Validamos que el campo TextFormField, este rellenado, 

        // if( valor == "") return "Este campo es REQUERIDO";  // el text no puede ser 'NULL'

        if( valor == null) return "Este campo es REQUERIDO";  // Aqui puede ser nulo
        return valor.length < 3
        ? 'Minimo de tres letras'
        : null;               
      },
      // Le decimos cuando tiene que evaluar esto
      autovalidateMode: AutovalidateMode.onUserInteraction,
      decoration: InputDecoration(
        hintText: hintText,
        labelText: labelText,
        helperText: helperText,
        // counterText: 'Quedan 3 letras'
        suffixIcon: Icon(sufixIcon),
        // prefixIcon: Icon(Icons.accessible_forward)
        icon: iconData == null ? null : Icon (iconData)

        

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