package me.zairacelis.unabshop

import android.util.Patterns

//returnar un true si es valido y un false si no es valido
//tambien retorne una cadena de texto que diga que paso si no es valido
fun validateEmail(email: String): Pair<Boolean, String> {
    return when {
        email.isEmpty() -> Pair(false, "El correo electronico no puede estar vacio")
        !Patterns.EMAIL_ADDRESS.matcher(email).matches()-> Pair(false, "El correo es invalido")
        !email.endsWith("@test.com") -> Pair(false, "Ese email no es corporativo")
        else -> Pair(true, "")
    }
}

fun validatePassword(password: String): Pair<Boolean, String>{
    return when{
        password.isEmpty() -> Pair(false, "La contraseña es requerida")
        password.length < 8 -> Pair(false, "La contraseña debe tener al menos 8 caracteres")
        !password.any { it.isDigit()} -> Pair(false, "La contraseña debe tener al menos un numero.")
        else -> Pair(true, "")
    }
}

fun validateName (name: String): Pair<Boolean, String>{
    return when{
        name.isEmpty() -> Pair(false, "La contraseña es requerida")
        name.length < 3 -> Pair(false, "La contraseña debe tener al menos 3 caracteres")
        else -> Pair(true, "")
    }
}

fun validateConfirmPassword (password: String, confirmPassword: String): Pair<Boolean, String>{
    return when{
        confirmPassword.isEmpty() -> Pair(false, "La contraseña es requerida")
        confirmPassword != password -> Pair(false, "Las contraseñas no coinciden")
        else -> Pair(true, "")
    }
}