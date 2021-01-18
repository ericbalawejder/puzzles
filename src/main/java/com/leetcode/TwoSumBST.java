package com.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumBST {

    public static void main(String[] args) {

    }

    Set<Integer> inHashSet(TreeNode node, int target, Set<Integer> set) {
        if (node == null) {
            return set;
        }
        inHashSet(node.left, target, set);
        set.add(target - node.value);
        inHashSet(node.right, target, set);
        return set;
    }

    boolean inCheck(TreeNode r, Set<Integer> s) {
        if (r == null) return false;
        return inCheck(r.left, s) || s.contains(r.value) || inCheck(r.right, s);
    }

    boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = inHashSet(root1, target, new HashSet());
        return inCheck(root2, set);
    }

    List<Integer> inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        inorder(root.left, list);
        list.add(root.value);
        inorder(root.right, list);
        return list;
    }

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.value = x;
        }
    }
}
