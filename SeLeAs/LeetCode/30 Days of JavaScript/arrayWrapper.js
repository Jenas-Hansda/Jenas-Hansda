/**
 * @param {number[]} nums
 * @return {void}
 */
var ArrayWrapper = function(nums) {
    this.array = nums;
};

/**
 * @return {number}
 */
ArrayWrapper.prototype.valueOf = function() {
    // Returns the sum of the elements in the array
    return this.array.reduce((sum, num) => (sum + num), 0);
};

/**
 * @return {string}
 */
ArrayWrapper.prototype.toString = function() {
    // Converts the array to a string with the format "[element1, element2, ...]"
    return `[${this.array.join(",")}]`;
};

/**
 * Example Usage:
 * const obj1 = new ArrayWrapper([1, 2]);
 * const obj2 = new ArrayWrapper([3, 4]);
 * console.log(obj1 + obj2); // 10
 * console.log(String(obj1)); // "[1,2]"
 * console.log(String(obj2)); // "[3,4]"
 */
