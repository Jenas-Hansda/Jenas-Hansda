/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    const result = {};
    
    // First, populate the result with the objects from arr1
    for (let i = 0; i < arr1.length; i++) {
        result[arr1[i].id] = arr1[i];
    }

    // Then, iterate through arr2 and merge the objects
    for (let i = 0; i < arr2.length; i++) {
        if (result[arr2[i].id]) {
            // If the id already exists in result, merge the objects
            for (const key in arr2[i]) {
                result[arr2[i].id][key] = arr2[i][key];
            }
        } else {
            // If the id does not exist in result, add the object from arr2
            result[arr2[i].id] = arr2[i];
        }
    }

    // Return the merged result as an array of objects
    return Object.values(result);
};
