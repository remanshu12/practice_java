class MedianFinder {

    PriorityQueue<Integer> right_min;
    PriorityQueue<Integer> left_max;

    public MedianFinder() {
    right_min = new PriorityQueue<>();
    left_max = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        if(left_max.isEmpty() || num< left_max.peek()){
            left_max.add(num);
        }else{
            right_min.add(num);
        }

        if(left_max.size()-right_min.size() >1 ){
            right_min.add(left_max.poll());
        }else if(left_max.size()<right_min.size()){
            left_max.add(right_min.poll());
        }
    }
    
    public double findMedian() {
        if(left_max.size()==right_min.size()){
            double mean=(left_max.peek()+right_min.peek())/2.0;
            return mean;
        }
        return left_max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */