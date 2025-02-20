/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
    obj = {
        toBe(val1){
            if(val===val1) {
                return true;
            } else {
                throw new Error("Not Equal");
            }
        },
        notToBe(val1){
            if(val!==val1) {
                return true;
            } else {
                throw new Error("Equal");
            }
        }
        

        }
        return obj;
    };