package com.example.lib

fun main(args: Array<String>) {

    println(rollDice())

    // test cases
    println(similarityTestCase())
    println(maxNumberTestCase())
    print(minNumberTestCase())
}

fun rollDice(): Int = ((System.nanoTime() % 6) + 1).toInt()

//    test cases
//    true if pass
//    false if failed
fun similarityTestCase(): Boolean {
    var similarityCount = 0
    for (i in 1..5) {
        if (rollDice() == rollDice()) {
            similarityCount++
        }
    }
    return similarityCount <= 2
}

fun maxNumberTestCase(): Boolean {
    var maxNumber = 1
    for (i in 1..100) {
        maxNumber = rollDice()
        if (maxNumber > 6) {
            return false
        }
    }
    return maxNumber <= 6
}

fun minNumberTestCase(): Boolean {
    var minNumber = 1
    for (i in 1..100) {
        minNumber = rollDice()
        if (minNumber < 1) {
            return false
        }
    }
    return minNumber <= 6
}




// instead of using async task kotlin corutines could be used

