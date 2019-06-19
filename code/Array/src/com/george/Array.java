package com.george;

public class Array {
    private int[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参的构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中元素的个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;

    }

    /**
     * 向所有元素后添加一个新元素
     *
     * @param e
     */
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 在数组的第一个位置插入元素
     *
     * @param e 元素
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在index个位置插入一个e
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("add failed,Array is full.");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed,Require index >=0 and index <size.");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取数组中指定索引的元素值
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed,Require index >=0 and index <size.");
        }
        return data[index];
    }

    /**
     * 修改指定数组中索引的值
     *
     * @param index 索引
     * @param e     元素
     */
    public void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed,Require index >=0 and index <size.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     *
     * @param e 元素
     * @return true 存在 false 不存在
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，返回-1
     *
     * @param e
     * @return
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array:size = %d, capacity = %d\n", size, data.length));
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
