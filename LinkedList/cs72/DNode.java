package eg.edu.alexu.csd.datastructure.linkedList.cs72;

public class DNode {
]
    private Object element;

    private DNode prev, next;

    /**
     * create. a new double. linked list.
     * @param e element.
     * @param p point to the previous node.
     * @param n point to the next node.
     */
    public DNode(final Object e, final DNode p, final DNode n) {

        element = e;
        prev = p;
        next = n;
    }

    /** Returns the element of this node.
     *@return element return it.
     */
     public final Object getElement() {
        return element;
    }

    /** Sets the element of this node.
     *@param newElem new element.
     */
    public final void setElement(final Object newElem) {
        element = newElem;
    }

    /** Returns the previous node of this node.
     *@return prev retrun previous.
     */
    public final DNode getPrev() {
        return prev;
    }

    /** Returns the next node of this node.
     *@return next give me the next node.
     */
    public final DNode getNext() {
        return next;
    }

    /** Sets the previous node of this node.
     *@param newPrev a new prev node.
     */
    public final void setPrev(final DNode newPrev) {
        prev = newPrev;
    }

    /** Sets the next node of this node.
     *@param newNext new next node.
     */
    public final void setNext(final DNode newNext) {
        next = newNext;
    }
}
