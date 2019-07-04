import java.util.Random;

class Test {

    public static void main(String[] args) {
        Random r = new Random();
        int capacity = 9;
        int[] testingArray = new int[capacity];
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Filling an array with " + capacity + " elements...");
        for (int i = 0; i < capacity; i++) {
            int newElement = r.nextInt(100);
            testingArray[i] = newElement;
            list.push(newElement);
        }
        String listString = list.toString();
        System.out.println("List: " + listString);
        boolean sizeEqual = list.size() == capacity;
        System.out.println("[TEST] SIZE TEST: " + sizeEqual);
        if (!sizeEqual) {
            printError("SIZE IS NOT THE SAME.");
            printError("EXPECTED SIZE: " + capacity);
            printError("LIST SIZE: " + list.size());
            System.exit(1);
        }
        printLog("STARTING EQUAL TEST.");
        boolean areEqual = true;
        for (int i = 0; i < capacity; i++) {
            areEqual &= testingArray[i] == list.elementAt(i);
        }
        if (!areEqual) {
            printError("THE LIST AND THE ARRAY DOES NOT HAVE THE SAME CONTENTS.");
            System.exit(1);
        }
        printLog("EQUAL TEST: " + areEqual);
        printLog("INSERT TEST");
        boolean insertTestSuccess = true;
        for (int i = 3; i < 10; i++) {
            list.insert(i, 1);
            System.out.println(list.toString());
        }
        printLog("INSERT TEST: " + insertTestSuccess);
        boolean popTest = true;
        printLog("POP TEST");
        list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            int newElement = r.nextInt(100);
            testingArray[i] = newElement;
            list.push(newElement);
        }
        int index = testingArray.length-1;
        for (int i = 0; i < list.size(); i++) {
            int previousSize = list.size();
            int removedElement = list.pop();
            popTest &= removedElement == testingArray[index] && previousSize - list.size() == 1; 
            index--;
        }
        printLog("POP TEST RESULT: " + popTest);
        printLog("DELETE TEST");
        boolean deleteTest = true;
        list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            int newElement = r.nextInt(100);
            testingArray[i] = newElement;
            list.push(newElement);
        }
        System.out.println(list.toString());
        for (int i = 2; i < capacity; i++) {
            list.delete(2);
            System.out.println(list.toString());
        }
        removeTest();
    }

    private static void printError(String text) {
        System.err.println("[ERROR] " + text);
    }

    private static void printLog(String text) {
        System.out.println("[TEST] " + text);
    }

    private static void removeTest() {
        printLog("REMOVE TEST");
        ArrayList<Integer> list = new ArrayList<>();
        list.push(10);
        list.push(1);
        list.push(2);
        list.push(2);
        list.push(2);
        list.push(1);
        list.push(5);
        list.push(2);
        list.push(8);
        System.out.println(list.toString());
        System.out.println("Removing 2...");
        list.remove(2);
        System.out.println(list.toString());
        System.out.println("Size assert: " + (list.size() == 5));
    }
}