package tree;

import java.util.*;

public class FlattenNestedListIterator_341 {

}

class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> stack = new ArrayDeque<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        pushStack(nestedList);
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushStack(stack.pop().getList());
        }
        return !stack.isEmpty();
    }

    private void pushStack(List<NestedInteger> nestedList) {
        Collections.reverse(nestedList);
        for (NestedInteger x : nestedList) {
            stack.push(x);
        }
    }
}


interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedIterator2 implements Iterator<Integer> {
    LinkedList<Integer> resList = new LinkedList<>();
    public NestedIterator2(List<NestedInteger> nestedList) {
        dfsGetLeaves(nestedList);
    }

    @Override
    public Integer next() {
        return resList.pollFirst();
    }

    @Override
    public boolean hasNext() {
        return !resList.isEmpty();
    }

    private void dfsGetLeaves(List<NestedInteger> nestedList) {
        for (NestedInteger x : nestedList) {
            if (x.isInteger()) {
                resList.add(x.getInteger());
            } else {
                dfsGetLeaves(x.getList());
            }
        }
    }
}
