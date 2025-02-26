/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    // Base case: If depth is 0, return the array as it is
    if (n === 0) {
        return arr.slice();
    }
    
    let flatArr = [];

    // Loop through the array and handle nesting
    for (let i = 0; i < arr.length; i++) {
        if (Array.isArray(arr[i])) {
            // Recursively flatten the nested array
            const nested = flat(arr[i], n - 1);
            flatArr.push(...nested);
        } else {
            flatArr.push(arr[i]);
        }
    }
    return flatArr;
};
