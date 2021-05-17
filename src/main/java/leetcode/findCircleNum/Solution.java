package leetcode.findCircleNum;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by luyan on 2018/6/10.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println("asdf");
        Solution solution = new Solution();
        //        System.out.println(solution.findCircleNum(new int[][] {
        //
        //                { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
        //
        //        System.out.println(
        //                solution.findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } }));
        System.out.println(solution.findCircleNum(
                new int[][] { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } }));
    }

    class quickUnion{
        int[] qu;
        int[] sz;
        int size;
        int components;
        public quickUnion(int n){
            qu = new int[n];
            sz = new int[n];
            for(int i = 0; i < n; i ++){
                qu[i] = i;
                sz[i] = 1;
            }
            size = n;
            components = n;
        }
        public int root(int i){
            while(i != qu[i]){
                qu[i] = qu[qu[i]];
                i = qu[i];
            }
            return i;
        }
        public void union(int p, int q){
            if(connected(p,q)) return;
            int proot = root(p);
            int qroot = root(q);
            if(sz[proot] > sz[qroot]){
                qu[qroot] = qu[proot];
                sz[proot] += sz[qroot];
            }else{
                qu[proot] = qu[qroot];
                sz[qroot] += sz[proot];
            }
            components --;
        }
        public boolean connected(int p, int q){
            int proot = root(p);
            int qroot = root(q);
            return qroot == proot;
        }
    }
    public int findCircleNum(int[][] M) {
        quickUnion wqupc = new quickUnion(M.length);
        for(int i = 0; i < wqupc.size; i ++){
            for(int j = i + 1; j < wqupc.size; j ++){
                if(M[i][j] == 1 && !wqupc.connected(i,j)){
                    wqupc.union(i,j);
                }
            }
        }
        return wqupc.components;
    }
}
