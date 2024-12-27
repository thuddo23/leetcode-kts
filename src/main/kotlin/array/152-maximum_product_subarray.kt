package org.example.array

import kotlin.math.max

fun maxProduct(nums: IntArray): Int {
    var firstNev: Int? = null
    var lastNev: Int? = null
    var current = 1
    var max = Int.MIN_VALUE
    for (num in nums) {
        if (num == 0) {
            firstNev = null
            lastNev = null
            current = 1
            max = max.coerceAtLeast(0)
            continue
        }
        current *= num
        max = kotlin.math.max(max, current)
        if (num > 0 && lastNev != null) {
            lastNev *= num
        }
        if (num < 0) {
            if (firstNev == null) {
                firstNev = current
            } else {
                lastNev = num
            }
        }
    }
    if (current < 0 && firstNev != null) {
        if (lastNev != null) {
            current = kotlin.math.max(current / firstNev, current / lastNev)
        } else {
            current/=firstNev
        }
    }
    return kotlin.math.max(current, max)
}

fun main() {
    print(maxProduct(intArrayOf(-2, 0, -1)))
}