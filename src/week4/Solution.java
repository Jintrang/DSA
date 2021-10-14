package week4;

import java.io.IOException;
import java.util.List;

public class Solution {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
            if (this.head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
    }

    static class result {
        /**
         * print all node of list.
         *
         * @param head
         */
        static void printLinkedList(SinglyLinkedListNode head) {
            SinglyLinkedListNode node = head;
            while (node != null) {
                System.out.println(head.data);
                node = node.next;
            }
        }

        /**
         * them node khi khong có tail
         *
         * @param head
         * @param data
         * @return a the head Node of SinglyLinkedListNode
         */
        public static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            if (head == null) {
                head = node;
            } else {
                SinglyLinkedListNode nodeRun = head;
                while (nodeRun.next != null) {
                    nodeRun = nodeRun.next;
                }
                nodeRun.next = node;
            }
            return head;
        }

        /**
         * them mot node vao dau danh sach
         *
         * @param llist
         * @param data
         * @return
         */
        public static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            if (llist != null) {
                node.next = llist;
            }
            llist = node;
            return llist;
        }

        /**
         * them node vao vi tri position.
         *
         * @param llist
         * @param data
         * @param position
         * @return node dau
         */
        public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
            // Write your code here
            SinglyLinkedListNode nodeRun = llist;
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            if (llist == null) {
                return node;
            }
            if (position == 0) {
                node.next = llist;
                llist = node;
            } else {
                for (int i = 0; i < position - 1; i++) {
                    nodeRun = nodeRun.next;
                }
                node.next = nodeRun.next;
                nodeRun.next = node;
            }
            return llist;

        }

        /**
         * xoa mot node o vi tri position.
         *
         * @param llist
         * @param position
         * @return node dau
         */
        public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
            // Write your code here
            SinglyLinkedListNode nodeRun = llist;
            if (position == 0) {
                return llist.next;
            }
            for (int i = 0; i < position - 1; i++) {
                nodeRun = nodeRun.next;
                position--;
            }
            nodeRun.next = nodeRun.next.next;
            return llist;
        }

        /**
         * in nguoc mot linked list
         *
         * @param llist
         */
        public static void reversePrint(SinglyLinkedListNode llist) {
            // Write your code here
            if (llist == null) {
                return;
            } else {
                reversePrint(llist.next);
                System.out.println(llist.data);
            }
        }

        /**
         * dao nguoc danh sach lien ket
         *
         * @param llist
         * @return reversed linked list
         */
        public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
            // Write your code here
            SinglyLinkedListNode rLlist = new SinglyLinkedListNode(llist.data);
            SinglyLinkedListNode nodeRun = llist.next;
            while (nodeRun != null) {
                SinglyLinkedListNode node = new SinglyLinkedListNode(nodeRun.data);
                node.next = rLlist;
                rLlist = node;
                nodeRun = nodeRun.next;
            }
            return rLlist;
        }

        /**
         * so sanh 2  linked list.
         *
         * @param head1
         * @param head2
         * @return boolean
         */
        static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
            if (head1 == null && head2 == null) {
                return true;
            }
            if (head1.data == head2.data) {
                return compareLists(head1.next, head2.next);
            }
            return false;
        }

        /**
         * nối 2 linked list
         *
         * @param head1
         * @param head2
         * @return a merged linked list
         */
        static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
            if (head1 == null) return head2;
            if (head2 == null) return head1;
            SinglyLinkedListNode head3 = null;
            if (head1.data < head2.data) {
                head3 = head1;
                head3.next = mergeLists(head1.next, head2);
            } else {
                head3 = head2;
                head3.next = mergeLists(head2.next, head1);
            }
            return head3;
        }

        /**
         * tra ve gia tri của node cách tail 1 gia trị
         *
         * @param llist
         * @param positionFromTail
         * @return the value of node
         */
        public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
            // Write your code here
            SinglyLinkedListNode prev = llist;
            SinglyLinkedListNode cur = llist;
            for (int i = 0; i < positionFromTail; i++) {
                cur = cur.next;
            }
            while (cur.next != null) {
                prev = prev.next;
                cur = cur.next;
            }
            return prev.data;
        }
    }

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int n = q.size();
        int sum = 0;
        for (int i = n - 1; i > 0; i--) {
            if (q.get(i) != i + 1) {
                if (i >= 1 && q.get(i - 1) == i + 1) {
                    sum++;
                    q.add(i - 1, q.get(i));
                    q.remove(i + 1);
                } else if (i >= 2 && q.get(i - 2) == i + 1) {
                    sum += 2;
                    q.add(q.get(i) - 2, q.get(i));
                    q.remove(i + 1);
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(sum);
    }
}
