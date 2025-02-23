var cancellable = function(fn, args, t) {
    return new Promise((resolve, reject) => {
        // Create a timeout that will reject the promise after `t` milliseconds
        const timer = setTimeout(() => {
            reject("Time Limit Exceeded");
        }, t);

        // Call the function and handle its promise
        fn(...args).then((result) => {
            clearTimeout(timer); // Clear the timeout if the function resolves
            resolve(result); // Resolve the promise with the result of the function
        }).catch((error) => {
            clearTimeout(timer); // Clear the timeout if the function rejects
            reject(error); // Reject the promise with the error from the function
        });
    });
};
