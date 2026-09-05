class MedianFinder {

    PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        maxQueue.add(num);
        minQueue.add(maxQueue.poll());
        if(minQueue.size() > maxQueue.size()){
            maxQueue.add(minQueue.poll());
        }
    }
    
    public double findMedian() {
        System.out.println(maxQueue);
        System.out.println(minQueue);
        
        if(maxQueue.size() == minQueue.size()){
            System.out.println(maxQueue.peek()+":"+minQueue.peek());
            System.out.println();
            return (maxQueue.peek()+minQueue.peek())/2.0;
        }else {
            System.out.println(minQueue.peek());
            System.out.println();
            return (minQueue.size()>maxQueue.size()?minQueue.peek():maxQueue.peek());
        }
    }
}
