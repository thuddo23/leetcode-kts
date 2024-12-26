package org.example.array

fun maxSubArray(nums: IntArray): Int {
    var start = 0
    var end = 0
    var currentSum = Int.MIN_VALUE
    var max = Int.MIN_VALUE
    for ((index, num) in nums.withIndex()) {
        if (currentSum < 0) {
            currentSum = num
            if (num > max) {
                max = num
            }
            start = index
            end = index
            continue
        }
        currentSum += num
        if (max < currentSum) {
            end = index
            max = currentSum
        }
    }
    return kotlin.math.max(max, nums.first())
}