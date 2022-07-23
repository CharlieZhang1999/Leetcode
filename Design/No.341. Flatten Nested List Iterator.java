/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> l1;
    int cur = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        l1 = new ArrayList<Integer>();
        for(NestedInteger integer: nestedList){
            helper(integer);
        }
    }

    @Override
    public Integer next() {
        return l1.get(cur++);
    }

    @Override
    public boolean hasNext() {
        return cur < l1.size();
    }
    
    public void helper(NestedInteger integer){
        if(integer.isInteger()){
            l1.add(integer.getInteger());
        }
        else{
            for(NestedInteger element: integer.getList()){
                helper(element);
            }
        }
                       
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */


/*
思路：
其实NestedInteger无非就是两种情况的分解, 定义一个helper function来处理一个NestedInteger： 
1\目前这个nestedInteger element是个Integer, 可以直接加入list中
2\目前这个nestedInteger element是个nested list，需要再recursion一步 来for each这个list里面的每个element并且helper(element)
*/