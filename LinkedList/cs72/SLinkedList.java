package eg.edu.alexu.csd.datastructure.linkedList.cs72;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class SLinkedList implements ILinkedList {

    Nodes header = null;

    @Override
    public final void add(final int index, final Object element) {
        Nodes newNode = new Nodes();
        newNode.obj = element;
        if (element == null) {
            throw new RuntimeException();
        } else if (index > size() || index < 0) {
            throw new RuntimeException();

        } else if (index == 0) {
            newNode.ref = header;
            header = newNode;

        } else {
            Nodes ind = header;
            for (int i = 0; i < index - 1; i++) {
                ind = ind.ref;
            }

            newNode.ref = ind.ref;
            ind.ref = newNode;
        }
    }

    @Override
    public final void add(final Object element) {
        add(size(), element);
    }

    @Override
    public final Object get(final int index) {
        Nodes ind = header;
        if (index >= size() || index < 0) {
            throw new RuntimeException();
        } else {

            for (int i = 0; i < index; i++) {
                ind = ind.ref;
            }
            return ind.obj;
        }
    }

    @Override
    public final void set(final int index, final Object element) {
        if (index >= size() || index < 0) {
            throw new RuntimeException();
        } else {
            add(index, element);
            remove(index + 1);
        }
    }

    @Override
    public final void clear() {
        header = null;

    }

    @Override
    public final boolean isEmpty() {
        if (header == null) {
            return true;
        }
        return false;
    }

    @Override
    public final void remove(final int index) {
        if (index >= size() || index < 0) {
            throw new RuntimeException();
        } else if (index == 0) {
            header = header.ref;

        } else {
            Nodes ind = header;
            for (int i = 0; i < index - 1; i++) {
                ind = ind.ref;
            }
            Nodes drift = ind.ref;
            ind.ref = drift.ref;

        }
    }

    @Override
    public final int size() {
        Nodes index = header;
        if (isEmpty()) {
            return 0;
        } else {
            int count = 0;
            while (index.ref != null) {
                index = index.ref;
                count++;
            }
            return count + 1;

        }
    }

    @Override
    public final ILinkedList sublist(final int fromIndex, final int toIndex) {
        Nodes i = header;
        ILinkedList inter = new SLinkedList();
        int count = 0;
        if (fromIndex > toIndex) {
            throw new RuntimeException();
        }

        while (count != fromIndex) {
            i = i.ref;
            count++;

        }
        while (count != toIndex) {
            inter.add(i.obj);
            i = i.ref;

            count++;

        }
        inter.add(i.obj);

        return inter;
    }

    @Override
    public final boolean contains(final Object o) {
        Nodes i = header;

        while (i != null) {
            if (i.obj.equals(o)) {
                return true;
            }
            i = i.ref;

        }

        return false;

    }

    public final void print() {
        Nodes i = header;
        while (i != null) {
            System.out.print(i.obj + "   ");
            i = i.ref;

        }
        System.out.println();
    }
}