package com.msk.structure;

/**
 * 单链表
 */
public class SingleList {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node node1 = new Node(1, "name1", null);
        Node node2 = new Node(2, "name2", null);
        Node node3 = new Node(3, "name3", null);
        singleLinkedList.addNode(node1);
        singleLinkedList.addNode(node2);
        singleLinkedList.addNode(node3);

        singleLinkedList.printNodes();

        Node node = singleLinkedList.queryNodeById(3);
        System.out.println(node);
        System.out.println("====================");
        singleLinkedList.removeNodeById(2);
        singleLinkedList.printNodes();
        System.out.println("====================");
        Node node222 = new Node(2, "name222", null);
        singleLinkedList.modifyNodeById(node222);
        singleLinkedList.printNodes();
        System.out.println(singleLinkedList.size());
    }

}

/**
 * 单链表类
 */
class SingleLinkedList {

    /**
     * 单链表的头节点
     */
    public Node head;

    /**
     * 初始化单链表
     */
    public SingleLinkedList() {
        this.head = new Node(0, null, null);
    }

    /**
     * 添加单链表
     * @param node
     */
    public void addNode(Node node) {
        //循环遍历找到最后一个节点，
        //把node放到最后一个节点的next中
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                //将node放入链表的尾部
                temp.next = node;
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
    public Node queryNodeById(int id) {
        Node temp = head;
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
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("未找到节点信息");
                break;
            }
            if (temp.next.id == id) {
                //删除节点
                //要删除的节点的前一个节点指向要删除的节点的后一个节点
                temp.next = temp.next.next;
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
    public void modifyNodeById(Node node) {
        Node temp = head;
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
     * 获取单链表长度
     * @return
     */
    public int size() {
        int size = 0;
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                return size;
            }
            size++;
            temp = temp.next;
        }
    }

    /**
     * 打印单链表所有节点
     */
    public void printNodes() {
        Node temp = head;
        //循环遍历打印每个节点信息
        while (true) {
            //判断是否为最后一个节点，如果是则终止循环
            if (temp.next == null) {
                break;
            }
            System.out.println(temp.next.toString());
            temp = temp.next;
        }
    }
}

/**
 * 单链表的节点对象
 */
class Node {

    public int id;

    public String name;

    /**
     * 指向下一个节点
     */
    public Node next;

    public Node(int id, String name, Node next) {
        this.id = id;
        this.name = name;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}
