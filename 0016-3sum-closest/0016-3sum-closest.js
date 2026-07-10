/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function(nums, target) {
    //sort array
    nums.sort((a,b)=>a-b)

    //3 number sum closest
    let closestSum=nums[0]+nums[1]+nums[2]

    for(let i=0;i<nums.length-2;i++){
        let left=i+1
        let right=nums.length-1

        while(left<right){
            const currSum=nums[i]+nums[left]+nums[right]

            //perfect match tai jay to return
            if(currSum===target){
                return currSum
            }

            //currsum nano hoy to update karo
            if(Math.abs(currSum-target)<Math.abs(closestSum-target)) closestSum=currSum

            //pointer 
            if(currSum<target) left++ 
            else right--
        }
    }    
    return closestSum
};