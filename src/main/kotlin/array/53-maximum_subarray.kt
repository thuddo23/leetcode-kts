package org.example.array

fun maxSubArray(nums: IntArray): Int {
    var currentSum = Int.MIN_VALUE
    var max = Int.MIN_VALUE
    for (num in nums) {
        if (currentSum < 0) {
            currentSum = num
            if (num > max) {
                max = num
            }
            continue
        }
        currentSum += num
        if (max < currentSum) {
            max = currentSum
        }
    }
    return max
}