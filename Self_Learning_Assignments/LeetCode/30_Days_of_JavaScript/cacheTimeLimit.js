var TimeLimitedCache = function() {
    this.cache = new Map();
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    const alreadyEx = this.cache.get(key);  // Check if the key already exists in cache
    if (alreadyEx) {
        clearTimeout(alreadyEx.timeoutId); // Clear any previous timeout for this key
    }
    
    // Set a new timeout to remove the key after the duration
    const timeoutId = setTimeout(() => {
        this.cache.delete(key);
    }, duration);
    
    // Store the value along with the timeoutId to manage expiration
    this.cache.set(key, { value, timeoutId });

    // Return true if the key already existed before, else false
    return Boolean(alreadyEx);
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    if (this.cache.has(key)) {
        return this.cache.get(key).value;  // Return the value if the key exists
    }
    return -1;  // Return -1 if the key doesn't exist or has expired
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    let count = 0;
    // Count how many items in the cache are not expired
    for (let [key, value] of this.cache) {
        // If the key is expired, it will be removed by the timeout handler
        if (value.timeoutId._idleTimeout > 0) {
            count++;
        }
    }
    return count;
};


const timeLimitedCache = new TimeLimitedCache();
