import 'package:fl_componentes/widgets/widgets.dart';
import 'package:flutter/material.dart';

class FormularioScreen extends StatelessWidget {


  // Necesito usar las keys
  // Las keys son usadas para matener la referemncia al widget 
  final GlobalKey<FormState> myFormKey = GlobalKey<FormState>();


  final Map<String, String> formvalues = {
    'nombre'     : 'Alberto',
    'apellido1'  : 'Rodriguez',
    'apellido2'  : 'aaaaaaaaaaa',
    'email'      : 'alberto@gmail.com',
    'password'   : '1212',
    'rol'        : 'Admin'
  };
   
   FormularioScreen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return  Scaffold(
      appBar: AppBar(title: const Text("Formulario"),),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.symmetric(vertical: 10,horizontal: 20),
          child: Form(
            key: myFormKey,
            child: Column(
              children: [
                 CustomInputFormField(formPropierty: 'nombre', formValues: formvalues, hintText: 'Nombre de usuario', labelText: 'Nombre', helperText: "Introudce tu nombre",),
                const SizedBox(height: 20,),
                 CustomInputFormField(formPropierty: 'apellido1', formValues: formvalues, hintText: 'Primer apellido', labelText: '1º Apellido', helperText: "Introudce el primer apellido",),
                const SizedBox(height: 20,),
                 CustomInputFormField(formPropierty: 'apellido2', formValues: formvalues, hintText: 'Segundo apellido', labelText: '2º Apellido', helperText: "Introudce el segundo apellido",),
                const SizedBox(height: 20,),
                 CustomInputFormField(formPropierty: 'email', formValues: formvalues, hintText: 'E-Mail', labelText: 'Correo Electrónico', helperText: "Introudce el E-Mail", sufixIcon: Icons.mail,textInputType: TextInputType.emailAddress,),
                const SizedBox(height: 20,),
                 CustomInputFormField(formPropierty: 'password', formValues: formvalues,hintText: '*********', labelText: 'Contraseña', helperText: "Introudce tu contra", sufixIcon: Icons.password_sharp, textInputType: TextInputType.number,obscureText: true,),
                const SizedBox(height: 20,),
                 DropdownButtonFormField<String>(
                   items: const [
                     DropdownMenuItem(child: Text("Administrador"), value: "Admin",),
                     DropdownMenuItem(child: Text("Gerente"),       value: "Gerente",),
                     DropdownMenuItem(child: Text("Programador Sr"),value: "ProSR",),
                     DropdownMenuItem(child: Text("Programador Jr"),value: "ProJR",),
                   ],
                   onChanged: ( valor ){

                     formvalues['rol'] = valor!;
                   },
                   ),
                const SizedBox(height: 20,),
                ElevatedButton(
                  onPressed: (){
                    // Quitar teclado de pantalla
                    FocusScope.of(context).requestFocus(FocusNode());
                    if (!myFormKey.currentState!.validate()) {
                        print("Fomulario no valido");
                        return;
                      
                    }
                    print(formvalues);
                  }, 
                  child: const SizedBox(
                    width: double.infinity,
                    child: Center(
                      child: Text('Guardar'),
                    ),
                  ))
                
          
          
          
              ],
              ),
          ),
        ),
      )
    );
  }
}

