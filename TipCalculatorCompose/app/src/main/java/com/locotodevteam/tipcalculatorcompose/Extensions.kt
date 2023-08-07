package com.locotodevteam.tipcalculatorcompose


fun Float.showPercentage(): String {
    return String.format("%.1f", this * 100) + "%"
}

val Float.money: String
    get() = "$" + String.format("%.2f", this)