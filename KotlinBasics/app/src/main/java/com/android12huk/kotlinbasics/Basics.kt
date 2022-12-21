package com.android12huk.kotlinbasics

fun main(){
    var myCar = Car()
    println("My brand is : ${myCar.myBrand}")
    myCar.maxSpeed = 8
    println("Maxspeed is ${myCar.maxSpeed}")
    println("Model is ${myCar.myModel}")

}


class Car(){
    lateinit var owner : String

    val myBrand: String = "BmW"
    get() {
        return field.lowercase()
    }

    var maxSpeed: Int = 230
        get() = field
        set(value) {
            field = if(value > 0) value else throw IllegalArgumentException ("SMOKE ROCKS BRO!")
        }

    var myModel : String = "brokenBOYRIDE"
        private set

}