class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val reachedNumbers = mutableMapOf<Value, Index>()
        for ((index, num) in nums.withIndex()) {
            val remainNumber = target - num
            if (reachedNumbers.contains(remainNumber)) {
                return intArrayOf(
                    reachedNumbers[remainNumber]!!,
                    index,
                )
            }
            reachedNumbers[num] = index // Map the current number to its index
        }
        throw IllegalArgumentException("No solution found") // Add error handling
    }
}

typealias Index = Int
typealias Value = Int