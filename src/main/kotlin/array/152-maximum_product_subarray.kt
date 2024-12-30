package org.example.array

import kotlin.math.max

fun maxProduct(nums: IntArray): Int {
    var firstNev: Int? = null
    var lastNev: Int? = null
    var current = 1
    var count = 0
    var max = Int.MIN_VALUE

    var getMax = {
        if (current < 0 && firstNev != null && count > 1) {
            if (lastNev != null) {
                current = kotlin.math.max(current / firstNev!!, current / lastNev!!)
            } else {
                current/=firstNev!!
            }
        }
        if (count == 0) {
            max
        } else {
            kotlin.math.max(current, max)
        }
    }
    for (num in nums) {
        if (num == 0) {
            max = max.coerceAtLeast(0)
            max = getMax()
            firstNev = null
            lastNev = null
            current = 1
            count = 0
            continue
        }
        current *= num
        count++
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
    return getMax()
}

fun main() {
    print(maxProduct(intArrayOf(-1, -2, -3, 0)))
}