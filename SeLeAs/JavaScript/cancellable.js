var cancellable = function(fn, args, t) {
    // Immediately invoke the function with the provided arguments
    fn(...args);

    // Set up the interval to call the function repeatedly at the specified time `t`
    let timer = setInterval(() => {
        fn(...args);
    }, t);

    // Create the cancel function to clear the interval when needed
    let cancelFn = () => clearInterval(timer);

    // Return the cancel function so it can be invoked later to stop the interval
    return cancelFn;
};
