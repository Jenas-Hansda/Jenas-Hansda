/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function(functions) {
    return new Promise((resolve, reject) => {
        let results = new Array(functions.length);
        let waitFor = functions.length;

        for (let i = 0; i < functions.length; i++) {
            functions[i]().then((result) => {
                results[i] = result;
                waitFor--;
                if (waitFor === 0) resolve(results);
            }).catch(reject);
        }
    });
};

// Example usage:
const promise = promiseAll([() => new Promise(resolve => resolve(42))]);
promise.then(console.log); // [42]

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */