package org.example.array

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        if (nums.size <= 1) throw IllegalArgumentException("size of nums has to be greater than 2!")
        val result = IntArray(nums.size) { 1 }
        var cache = nums.first()

        // Forward pass: Calculate the prefix product
        for ((index, num) in nums.withIndex()) {
            if (index == 0) continue
            result[index] = result[index - 1] * cache
            cache = num
        }

        // Backward pass: Calculate the suffix product and multiply
        for (index in nums.lastIndex - 1 downTo 0) {
            result[index] = result[index] * cache
            cache *= nums[index]
        }

        return result
    }
}