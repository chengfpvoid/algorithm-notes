package org.cheng.algo01.queue.lc641;

/**
 * 设计循环双端队列
 *
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。
 */
public class MyCircularDeque {
    private int size;

    private int front;

    private int tail;

    private int a[];
    /**
     * 构造双端队列的大小为k
     * @param k 容量为k
     */
    public MyCircularDeque(int k) {
        size = k + 1;
        front = 0;
        tail = 0;
        a = new int[size];

    }

    /**
     * 将一个元素添加到双端队列头部。如果操作成功返回 true。
     * @param value 插入的元素
     * @return
     */
    public boolean insertFront(int value) {
        // 队头向前移动，然后在队头插入
        if (isFull()) {
            return false;
        }
        front = (front - 1 + size) % size;
        a[front] = value;
        return true;

    }

    /**
     * 将一个元素添加到双端队列尾部。如果操作成功返回 true。
     * @param value 插入的元素
     * @return
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        a[tail] = value;
        tail = (tail + 1) % size;
        return true;
    }

    /**
     * 从双端队列头部删除一个元素。 如果操作成功返回 true。
     * @return
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % size;
        return true;

    }

    /**
     * 从双端队列尾部删除一个元素。如果操作成功返回 true。
     * @return
     */
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }
        tail = (tail - 1 + size) % size;
        return true;

    }

    /**
     * 从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
     * @return
     */
    public int getFront() {
        if (isEmpty()) {
            return - 1;
        }
        return a[front];

    }

    /**
     * 从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
     * @return
     */
    public int getRear() {
        if (isEmpty()) {
            return - 1;
        }
        return a[(tail-1 + size) % size];

    }

    /**
     * 检查双端队列是否为空。
     * @return
     */
    public boolean isEmpty() {
        return front == tail;

    }

    /**
     * 检查双端队列是否为空。
     * @return
     */
    public boolean isFull() {
        return (tail + 1)% size == front;

    }
}
