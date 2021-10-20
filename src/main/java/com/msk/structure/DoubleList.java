package com.msk.structure;

/**
 * 双链表
 */
public class DoubleList {

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        DoubleNode node1 = new DoubleNode(1, "name1", null, null);
        DoubleNode node2 = new DoubleNode(2, "name2", null, null);
        DoubleNode node3 = new DoubleNode(3, "name3", null, null);
        doubleLinkedList.addNode(node1);
        doubleLinkedList.addNode(node2);
        doubleLinkedList.addNode(node3);
        doubleLinkedList.printNodes();
        System.out.println("====================");

        DoubleNode node = doubleLinkedList.queryNodeById(3);
        System.out.println(node);
        System.out.println("====================");

        doubleLinkedList.removeNodeById(2);
        doubleLinkedList.printNodes();
        System.out.println("====================");

        DoubleNode node222 = new DoubleNode(2, "name222", null, null);
        doubleLinkedList.modifyNodeById(node222);
        doubleLinkedList.printNodes();
        System.out.println(doubleLinkedList.size());
    }

}

/**
 * 双链表类
 */
class DoubleLinkedList {

    /**
     * 双链表的头节点
     */
    public DoubleNode head;

    /**
     * 初始化双链表
     */
    public DoubleLinkedList() {
        this.head = new DoubleNode(0, null, null, null);
    }

    /**
     * 添加双链表
     * @param node
     */
    public void addNode(DoubleNode node) {
        //循环遍历找到最后一个节点，
        //把node放到最后一个节点的next中
        DoubleNode temp = head;
        while (true) {
            if (temp.next == null) {
                //将node放入链表的尾部
                temp.next = node;
                //设置节点的头结点
                node.pre = temp;
                break;
            }
            //非尾部节点 temp往后移动
            temp = temp.next;
        }
    }

    /**
     * 根据ID查询Node信息
     * @param id
     * @return
     */
    public DoubleNode queryNodeById(int id) {
        DoubleNode temp = head;
        //遍历查找每个Node节点，匹配id
        while (true) {
            if (temp.next == null) {
                System.out.println("未找到对应的节点信息");
                return null;
            }
            if (temp.next.id == id) {
                return temp.next;
            }
            temp = temp.next;
        }
    }

    /**
     * 根据id删除Node
     * @param id
     */
    public void removeNodeById(int id) {
        DoubleNode temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("未找到节点信息");
                break;
            }
            if (temp.next.id == id) {
                //删除节点
                //需要删除节点为 temp.next
                //要先设置删除节点的后一个节点的前指针域为删除节点的前一个节点
                temp.next.next.pre = temp.next.pre;
                temp.next.pre.next = temp.next.next;
                break;
            }
            //前一个节点指向当前节点，当前节点为后一个节点
            temp = temp.next;
        }
    }

    /**
     * 根据ID修改Node信息
     * @param node
     */
    public void modifyNodeById(DoubleNode node) {
        DoubleNode temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("未找到节点信息");
                break;
            }
            if (temp.next.id == node.id) {
                temp.next.name = node.name;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 获取双链表长度
     * @return
     */
    public int size() {
        int size = 0;
        DoubleNode temp = head;
        while (true) {
            if (temp.next == null) {
                return size;
            }
            size++;
            temp = temp.next;
        }
    }

    /**
     * 打印双链表所有节点
     */
    public void printNodes() {
        DoubleNode temp = head;
        System.out.println(temp.next.toString());
    }
}

/**
 * 双链表的节点类
 */
class DoubleNode {

    public int id;

    public String name;

    /**
     * 指向上一个节点
     */
    public DoubleNode pre;

    /**
     * 指向下一个节点
     */
    public DoubleNode next;

    public DoubleNode(int id, String name, DoubleNode pre, DoubleNode next) {
        this.id = id;
        this.name = name;
        this.pre = pre;
        this.next = next;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pre=" + pre.name +
                ", next=" + next +
                '}';
    }
}
