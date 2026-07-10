/**
 * @param {number} n
 * @param {number[]} nums
 * @param {number} maxDiff
 * @param {number[][]} queries
 * @return {number[]}
 */
var pathExistenceQueries = function(n, nums, maxDiff, queries) {
    const sorted = Array.from(new Set(nums)).sort((a, b) => a - b);
    const m = sorted.length;
    
    const valToIdx = new Map();
    for (let i = 0; i < m; i++) {
        valToIdx.set(sorted[i], i);
    }
    
    const LOG = 20;
    const up = Array.from({length: m}, () => new Int32Array(LOG));
    
    let r = 0;
    for (let l = 0; l < m; l++) {
        while (r + 1 < m && sorted[r + 1] - sorted[l] <= maxDiff) {
            r++;
        }
        up[l][0] = r; 
    }
    
    for (let j = 1; j < LOG; j++) {
        for (let i = 0; i < m; i++) {
            up[i][j] = up[up[i][j - 1]][j - 1];
        }
    }
    
    const ans = [];
    for (const [u, v] of queries) {
        if (u === v) {
            ans.push(0);
            continue;
        }
        
        let valU = nums[u];
        let valV = nums[v];
        
        if (valU === valV) {
            ans.push(1);
            continue;
        }
        
        if (valU > valV) {
            let temp = valU;
            valU = valV;
            valV = temp;
        }
        
        let idxU = valToIdx.get(valU);
        let idxV = valToIdx.get(valV);
        
        if (up[idxU][LOG - 1] < idxV) {
            ans.push(-1); 
            continue;
        }
        
        let curr = idxU;
        let jumps = 0;
        
        for (let j = LOG - 1; j >= 0; j--) {
            if (up[curr][j] < idxV) {
                curr = up[curr][j];
                jumps += (1 << j); 
            }
        }
        
        ans.push(jumps + 1);
    }
    
    return ans;
};