package com.tree;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class TreeTraversal {

    public static void main(String[] args) {

    }

    static List<Integer> depthFirstSearch(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        final List<Integer> leftValue = depthFirstSearch(root.getLeft());
        final List<Integer> rightValue = depthFirstSearch(root.getRight());
        final List<Integer> nodes = Stream.concat(leftValue.stream(), rightValue.stream()).toList();
        return Stream.concat(Stream.of(root.getValue()), nodes.stream()).toList();
    };

}

/*
class Node {
  constructor(val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

const depthFirstIterative = (root) => {
  if (root === null) return [];

  const values = [];
  const stack = [root];

  while (stack.length > 0) {
    const node = stack.pop();
    values.push(node.val);
    if (node.right !== null) stack.push(node.right);
    if (node.left !== null) stack.push(node.left);
  }
  return values;
};


const depthFirst = (root) => {
  if (root === null) return [];

  const leftVal = depthFirst(root.left)
  const rightVal = depthFirst(root.right)
  return [root.val, ...leftVal, ...rightVal]
};

const a = new Node('a');
const b = new Node('b');
const c = new Node('c');
const d = new Node('d');
const e = new Node('e');
const f = new Node('f');
const g = new Node('g');

a.left = b;
a.right = c;
b.left = d;
b.right = e;
c.right = f;
e.left = g;

//    a
//   /  \
//  b
console.log(depthFirstIterative(a))
console.log(depthFirst(a)); //[ 'a', 'b', 'd', 'e', 'c', 'f' ]

// tree sum
// Write a function, treeSum, that takes in the root of a binary tree that contains number values. The function should return the total sum of all values in the tree.
class Node {
  constructor(val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
};

const dfs = root => {
  const fringe = [ root ];
  let sum = 0;

  while (fringe.length) {
    const node = fringe.pop();

    // Add the value to our total.
    sum += node.val;

    // Store child nodes.
    node.left && fringe.push(node.left);
    node.right && fringe.push(node.right);
  }

  return sum;
};

const dfsr = root => {
  if (root) {
    return root.val +
      dfsr(root.left) +
      dfsr(root.right);
  }
  else {
    return 0;
  }
};

const a = new Node(1);
const b = new Node(6);
const c = new Node(0);
const d = new Node(3);
const e = new Node(-6);
const f = new Node(2);
const g = new Node(2);
const h = new Node(2);

a.left = b;
a.right = c;
b.left = d;
b.right = e;
c.right = f;
e.left = g;
f.right = h;

//      1
//    /   \
//   6     0
//  / \     \
// 3   -6    2
//    /       \
//   2         2

console.log(dfs(a)); // -> 10
console.log(dfsr(a));

----------
// all tree paths
// Write a function, allTreePaths, that takes in the root of a binary tree. The function should return a 2-Dimensional array where each subarray represents a root-to-leaf path in the tree.

// The order within an individual path must start at the root and end at the leaf, but the relative order among paths in the outer array does not matter.

// You may assume that the input tree is non-empty.
class Node {
  constructor(val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}




function allTreePaths(root) {
  // 1: 2 base cases

  [b, d]

  [b, e]

  [[a, b,d],[a, b,e]]


  // Base case 1.
  if (!root) {
    return [];
  }

  // Base case 2: leaf.
  if (!root.left && !root.right) {
    // path.push(root.val);
    return [root.val];
  }
  const path = []

  // Case 3: middle node.
  const left = allTreePaths(root.left, path);
  left.forEach(child => {
    path.push([root.val, ...child]);
  });

  const right = allTreePaths(root.right, path);
  right.forEach(child => {
    path.push([root.val, ...child]);
  });

  return path;
}

const a = new Node('a');
const b = new Node('b');
const c = new Node('c');
const d = new Node('d');
const e = new Node('e');
const f = new Node('f');

a.left = b;
a.right = c;
b.left = d;
b.right = e;
c.right = f;

//      a
//    /   \
//   b     c
//  / \     \
// d   e     f

console.log(allTreePaths(a)); // ->
// [
//   [ 'a', 'b', 'd' ],
//   [ 'a', 'b', 'e' ],
//   [ 'a', 'c', 'f' ]
// ]



// function allTreePaths(root, path = []) {
//   // Base case 1.
//   if (!root) {
//     return path;
//   }

//   // Base case 2: leaf.
//   if (!root.left && !root.right) {
//     path.push(root.val);
//     return path;
//   }

//   // Case 3: middle node.
//   const left = allTreePaths(root.left, path);
//   left.forEach(child => {
//     leftPath.push([root.val, ...child])
//   });

//   const right = allTreePaths(root.right, path);
//   right.forEach(child => {
//     rightPath.push([root.val, ...child])
//   });

//   return path
// }



/*function allTreePaths(root) {
  const fringe = [ root ];

  while (fringe.length) {
    let node = fringe.pop();
    const path = [];

    while (node.left) {
      path.push(node.val);

      // Move on to the child.
      fringe.push(node.left);
      node = node.left;
    }

    path.push(node.val);
    console.log(path);
  }
}*/
