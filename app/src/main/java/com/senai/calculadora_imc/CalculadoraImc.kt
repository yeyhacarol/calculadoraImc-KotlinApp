package com.senai.calculadora_imc

fun calcularImc(peso: Double, altura: Double): Double {
    var imc = peso / (altura * altura)

    return imc
}

fun estadoFisico(imc: Double): String {

    return if (imc < 18.5) {
        return "Você está abaixo do peso!"
    } else if (imc > 18.5 && imc < 24.9) {
        return "Você está no peso ideal!"
    } else if (imc > 25 && imc < 29.9) {
        return "Você está sobrepeso!"
    } else if (imc > 30 && imc < 39.9) {
        "Você está obeso!"
    } else if (imc > 35 && imc < 39.9) {
        return "Você está com obesidade grau II!"
    } else {
        return "Você está obeso mórbido!"
    }
}