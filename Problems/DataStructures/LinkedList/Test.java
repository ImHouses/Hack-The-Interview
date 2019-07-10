import java.util.Random;

class Test {

    public static void main(String[] args) {
        LinkedList<Integer> list = getLinkedList();
        System.out.println(list.toString());
        System.out.println("Getting last element...");
        int last = list.getElementAt(9);
        System.out.println(last);
        System.out.println("Getting first element...");
        int first = list.getElementAt(0);
        System.out.println(first);
        System.out.println("Removing element at index 5...");
        list.removeAtIndex(5);
        System.out.println(list.toString());
        System.out.println("Removing element at index 0...");
        list.removeAtIndex(0);
        System.out.println(list.toString());
        System.out.println("Adding 0.");
        list.addElementAt(0, 0);
        System.out.println(list.toString());
        System.out.println("Adding 5.");
        list.addElementAt(5, 5);
        System.out.println(list.toString());
        // Add Start
        list.addStart(20);
        System.out.println(list.toString());
        // Add End
        list.addEnd(20);
        System.out.println(list.toString());
        // Contains Element
        System.out.println("Contains 4: " + list.containsElement(4));
        // Pop Start
        System.out.println("Pop Start");
        System.out.println(list.toString());
        list.popStart();
        System.out.println(list.toString());
        // Pop End
        System.out.println("Pop End");
        System.out.println(list.toString());
        list.popEnd();
        System.out.println(list.toString());
        list.clear();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(1);
        System.out.println(list.toString());
        System.out.println("Remove all 1\'s");
        list.removeAllOccurences(1);
        System.out.println(list.toString());

    }

    private static LinkedList<Integer> getLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return list;
    }
}