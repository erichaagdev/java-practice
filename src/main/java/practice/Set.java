package practice;

class Set {

    private int size = 0;
    private Object[] items = new Object[10];

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object itemToAdd) {
        if (!contains(itemToAdd)) {
            items[size] = itemToAdd;
            size = size + 1;
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(Object itemToCheck) {
        for (int i = 0; i < size; i++) {
            if (items[i] == itemToCheck) {
                return true;
            }
        }
        return false;
    }

    public void remove(Object itemToRemove) {
        Set newSet = new Set();
        for (int i = 0; i < size; i++) {
            if (items[i] != itemToRemove) {
                newSet.add(items[i]);
            }
        }
        items = newSet.items;
        size = newSet.size;
    }
}
