function memoize(fn) {
    let cache = {};
    return function(...args) {
        let n = JSON.stringify(args)
        if(n in cache){
            return cache[n];
        } else {
            let result = fn.apply(this, args)
            cache[n] =result;
            return result;
        }
    }
}