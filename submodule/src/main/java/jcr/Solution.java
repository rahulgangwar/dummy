package jcr;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {
    public static void main(String[] args) {
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();
        sharedQueue.add(1);
        sharedQueue.add(2);
        sharedQueue.add(3);
        sharedQueue.add(4);
        System.out.println(sharedQueue.poll());
        System.out.println(sharedQueue);
    }
}
