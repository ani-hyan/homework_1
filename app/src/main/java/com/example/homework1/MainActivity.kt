package com.example.homework1

import android.annotation.SuppressLint
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import java.util.*

@SuppressLint("NewApi")
fun main() {
    // 1. Declare an array and a list of your choice, initialize them with values,
    // and print the elements.
    val array = arrayOf(1, 2, 3, 4)
    val list = listOf("a", "b", "c", "d")
    println("Array: ${array.contentToString()}")
    println("List: ${list.joinToString()}")

//     2. Create a string variable and perform various string manipulations
//     such as concatenation, substring extraction, and changing case,
//     then print the modified string.
    val str = "String"
    println("Concatenated String: $str" + " concatenation")
    println("Substring: ${str.substring(3)}")
    println("Lowercase: ${str.lowercase()}")
    println("Uppercase: ${str.uppercase()}")

//     3.Declare a map with key-value pairs and iterate through it to print both keys and values.
    val map = mapOf("1" to "a", "2" to "b", "3" to "c")
    map.forEach { (key, value) -> println("Key: $key, Value: $value") }

//     4.	Write a function that takes an integer as input
//     and returns a string indicating whether it's positive, negative, or zero.
    fun numberSign(number: Int): String {
        return if(number > 0)
            "Positive"
        else if (number < 0)
            "Negative"
        else
            "Zero"
    }
    val number1 = 0
    val number2 = -1
    val number3 = 1
    println("Number 1: ${numberSign(number1)}")
    println("Number 2: ${numberSign(number2)}")
    println("Number 3: ${numberSign(number3)}")

    //5.	Create a program that asks the user for their name and age,
    // then prints a personalized greeting with their name and a message based on their age.
    val scanner = Scanner(System.`in`)
    print("Enter your name: ")
    val name = scanner.nextLine()
    print("Enter your age: ")
    val age = scanner.nextInt()
    println("Hello, $name! You are $age years old.")

    //6 a function that takes two numbers as input and divides them.
    // Implement error handling to handle division by zero and print an appropriate message.
    fun divide(a: Int, b: Int): String {
        return try {
            if (b == 0) {
                throw ArithmeticException("Division by zero is not allowed.")
            } else {
                (a / b).toString()
            }
        } catch (e: ArithmeticException) {
            e.message ?: "Error"
        }
    }
    val result1 = divide(10, 2)
    val result2 = divide(5, 0)
    println("Result 1: $result1")
    println("Result 2: $result2")

    // 7. Current date and time
    println("Current Date: ${LocalDate.now()}")
    println("Current Date with time: ${LocalDateTime.now()
                                        .format(DateTimeFormatter
                                            .ofPattern("yyyy-MM-dd HH:mm"))}")


    //8
    class Person(val name: String, val age: Int){
        override fun toString(): String {
            return "Name: $name, Age: $age"
        }

        //9.
        fun lifeStage(age: Int): String {
            return if(age <= 12)
                "Life stage: Child"
            else if(age in 13 .. 17)
                "Life stage: Teenager"
            else
              "Life stage: Adult"
        }
    }
    val person = Person("A", 24)
    println(person)
    println(person.lifeStage(person.age))


    //10
    fun evenNumbers(list: List<Int>): List<Int>{
        return list.filter { it % 2 == 0 }
    }

    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("Even Numbers: ${evenNumbers(numbers).joinToString()}")
}
