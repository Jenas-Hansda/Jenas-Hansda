var cancellable = function(fn, args, t) {
    // Define the cancel function to clear the timeout
    const cancelFn = function() {
        clearTimeout(timer);
    }

    // Set up the timer to execute the function after 't' milliseconds
    const timer = setTimeout(() => {
        fn(...args);
    }, t);

    // Return the cancel function that can be called to cancel the timeout
    return cancelFn;
}
