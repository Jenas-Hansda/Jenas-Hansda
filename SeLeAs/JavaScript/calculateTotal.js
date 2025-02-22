function calculateTotal(init, nums, fn) {
    let total = init;
    for (let i = 0; i < nums.length; i++) {
        total = fn(total, nums[i]);
    }
    return total;
}
