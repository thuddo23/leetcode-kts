package org.example.array

// My first solution
/*fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var stop = 0
    while(stop < prices.lastIndex) {
        var maxPrice = 0
        var maxIndex = 0
        for (i in stop until prices.size) {
            val price = prices[i]
            if (price > maxPrice) {
                maxPrice = price
                maxIndex = i
            }
        }
        if (stop == maxIndex || maxIndex == 0) {
            stop++
            continue
        }
        for (i in stop until maxIndex) {
            val newProfit = prices[maxIndex] - prices[i]
            maxProfit = maxOf(maxProfit, newProfit)
        }
        stop = maxIndex + 1
    }
    return maxProfit
}*/

fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var minPrice = Int.MAX_VALUE

    for (price in prices) {
        if (price < minPrice) {
            minPrice = price
        } else {
            maxProfit = maxOf(maxProfit, price - minPrice)
        }
    }
    return maxProfit
}

/** testing section*/
fun main() {
    // Test case 1
    var prices = intArrayOf(7, 1, 5, 3, 6, 4)
    var expected = 5
    var result = maxProfit(prices)
    println("Test case 1 - Expected: $expected, Result: $result")
    assert(expected == result)

    // Test case 2
    prices = intArrayOf(7, 6, 4, 3, 1)
    expected = 0
    result = maxProfit(prices)
    println("Test case 2 - Expected: $expected, Result: $result")
    assert(expected == result)

    // Test case 3
    prices = intArrayOf(1, 2)
    expected = 1
    result = maxProfit(prices)
    println("Test case 3 - Expected: $expected, Result: $result")
    assert(expected == result)

    // Test case 4
    prices = intArrayOf(2, 4, 1)
    expected = 2
    result = maxProfit(prices)
    println("Test case 4 - Expected: $expected, Result: $result")
    assert(expected == result)

    // Test case 5
    prices = intArrayOf(3, 2, 6, 5, 0, 3)
    expected = 4
    result = maxProfit(prices)
    println("Test case 5 - Expected: $expected, Result: $result")
    assert(expected == result)

    // Test case 6
    prices = intArrayOf(1, 2, 4, 2, 5, 7, 2, 4, 9, 0)
    expected = 8
    result = maxProfit(prices)
    println("Test case 6 - Expected: $expected, Result: $result")
    assert(expected == result)

    // Test case 7
    prices = intArrayOf(1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9)
    expected = 9
    result = maxProfit(prices)
    println("Test case 7 - Expected: $expected, Result: $result")
    assert(expected == result)

    // Test case 8
    prices = intArrayOf(1, 2)
}