import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuffer;

class PrintItemTable {

    static class Item {
        String name;
        Item(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("This is an article."));
        items.add(new Item("New Books."));
        items.add(new Item("ANOTHER ARTICLE."));
        items.add(new Item("THIS is a proof of handling characters and strings."));
        System.out.println(getNameColumn(items));
    }

    static String getNameColumn(List<Item> items) {
        int columnSize = 0;
        for (Item item : items) {
            if (item.name.length() > columnSize) {
                columnSize = item.name.length();
            }
        }
        columnSize += 5;
        StringBuffer result = new StringBuffer();
        char[] delimiterCharacters = new char[columnSize];
        for (int i = 0; i < delimiterCharacters.length-1; i++) {
            if (i == 0 || i == delimiterCharacters.length-2) {
                delimiterCharacters[i] = '+';
            } else {
                delimiterCharacters[i] = '-';
            }
        }
        delimiterCharacters[columnSize-1] = '\n';
        String itemDelimiter = new String(delimiterCharacters);
        result.append(itemDelimiter);
        for (int itemIndex = 0; itemIndex < items.size(); itemIndex++) {
            Item item = items.get(itemIndex);
            char[] itemRow = new char[columnSize];
            int nameIndex = 0;
            for (int i = 0; i < itemRow.length-1; i++) {
                if (i == 0 || i == itemRow.length-2) {
                    itemRow[i] = '|';
                } else if (i == 1 || nameIndex >= item.name.length()) {
                    itemRow[i] = ' ';
                } else {
                    itemRow[i] = item.name.charAt(nameIndex);
                    nameIndex++;
                }
            }
            itemRow[columnSize-1] = '\n';
            result.append(new String(itemRow));
            if (itemIndex < items.size()-1) {
                result.append(itemDelimiter);
            } else {
                delimiterCharacters[columnSize-1] = Character.MIN_VALUE;
                result.append(new String(delimiterCharacters));
            }
        }
        return result.toString();
    }
}