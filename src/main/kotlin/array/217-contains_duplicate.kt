package org.example.array

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val seen = HashSet<Int>(nums.size) // Preallocate capacity for better performance
        for (num in nums) {
            if (!seen.add(num)) return true // `add` returns false if the element already exists
        }
        return false
    }
}