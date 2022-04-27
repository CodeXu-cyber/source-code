/**
 * @ClassName MyLinkList
 * @Author xuwei
 * @DATE 2022/4/26
 */
public class MyLinkList<T> {
    public static void main(String[] args) {
        MyLinkList<Integer> integerMyLinkList = new MyLinkList<>();
        for (int i=0;i<10;i++){
            integerMyLinkList.add(i);
        }
        integerMyLinkList.forEach();
        System.out.println(integerMyLinkList.size());
        integerMyLinkList.remove(9);
        integerMyLinkList.forEach();
        System.out.println(integerMyLinkList.size());
    }
    static class Node<T>{
        public T val;
        public Node<T> next;
        public Node(){

        }
        public Node(T val){
            this.val = val;
        }
    }
    private Node<T> first;
    private Node<T> last;
    private int size = 0;
    public void add(T t){
        if (first==null){
            first = new Node<>(t);
            ++size;
            last = first;
        }else {
            last.next = new Node<>(t);
            ++size;
            last = last.next;
        }
    }
    public void forEach(){
        Node<T> node = first;
        while (node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }
    public int size(){
        return size;
    }
    public int index(T t){
        int index = -1;
        Node<T> node = first;
        boolean isSearched = false;
        while (node!=null){
            ++index;
            if (node.val.equals(t)){
                isSearched = true;
                break;
            }
            node = node.next;
        }
        return isSearched?index:-1;
    }
    public void remove(T t){
        if (index(t)==-1){
            return;
        }
        --size;
        Node<T> node = first;
        for (int i=0;i<index(t)-1;i++){
            node = node.next;
        }
        Node<T> next = node.next;
        node.next = next.next;
    }
}
