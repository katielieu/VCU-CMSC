/**
 * CustomList.java - a subclass of CMSC256 that modifies the functionality of a linked list
 *
 * @modified on 10/12/24 by Katie Lieu
 * CMSC 256 Section 901
 */

package cmsc256;

import java.util.Arrays;

public class CustomList<T> extends CMSC256LinkedList<T> {
    public static void main(String[] args) {
        CustomList<Integer> list = new CustomList<>();
        list.add(23);
        list.add(34);
        list.add(98);
        list.add(22);
        list.add(12);
        list.add(76);
        list.add(81);
        list.add(101);
        list.add(23);
        list.add(12);
        list.add(23);

        System.out.println("Middle element: " + list.getMiddleElement());
        System.out.println("First half list: " + Arrays.toString(list.getFirstHalf().toArray()));
        System.out.println("Last half list: " + Arrays.toString(list.getLastHalf().toArray()));
        System.out.println("Every four elements list: " + Arrays.toString(list.getEveryFourthElement().toArray()));
        System.out.println("Duplicate? " + list.hasDuplicates());
        System.out.println("Multiples list: " + Arrays.toString(list.getAllMultiples().toArray()));
        list.removeAllDuplicates();
        System.out.println("After removing duplicates: " + Arrays.toString(list.toArray()));
        System.out.println("Removed Nth node: " + list.removeNthNodeFromEnd(1));
        System.out.println("Final array: " + Arrays.toString(list.toArray()));

        System.out.println("List 1\n");

        CustomList<Integer> list1 = new CustomList<>();
        list1.add(1);
        //list1.add(2);

        System.out.println("Middle element: " + list1.getMiddleElement());
        System.out.println("First half list: " + Arrays.toString(list1.getFirstHalf().toArray()));
        System.out.println("Last half list: " + Arrays.toString(list1.getLastHalf().toArray()));
        System.out.println("Every four elements list: " + Arrays.toString(list1.getEveryFourthElement().toArray()));
        System.out.println("Duplicate? " + list1.hasDuplicates());
        System.out.println("Multiples list: " + Arrays.toString(list1.getAllMultiples().toArray()));
        list.removeAllDuplicates();
        System.out.println("After removing duplicates: " + Arrays.toString(list1.toArray()));
        System.out.println("Removed Nth node: " + list1.removeNthNodeFromEnd(1));
        System.out.println("Final array: " + Arrays.toString(list1.toArray()));
    }
    public CustomList() {
        super();
    }
    /**
     *  Returns the middle element of the
     *  If the number of elements in the list is even, there will be two middle nodes,
     *  so return the second one.
     *  For example, if the list contains [23, 34, 98, 22, 12, 76, 81], the
     *  method returns 22
     *  If the list contains [23, 34, 98, 22, 12, 76, 81, 101], the
     *  method returns 12
     * @throws  IllegalStateException if the list is empty or null
     * @return an instance T
     */
    public T getMiddleElement() {
        //throw exception if list is empty
        if (isEmpty()) {
            throw new IllegalStateException();
        } else {
            //return the element that is in the middle + 1 bc index is 1-based
            return getEntry((getLength()/ 2) + 1);
        }
    }

    /**
     * Returns the first half of the list.
     * If the number of elements in the list is odd, include the extra element.
     * For example if the list contains [23, 34, 98, 22, 12, 76, 81], the
     * method returns a list [23, 34, 98, 22]
     *
     * @return an instance of a class that implements the ListInterface
     * */
    public ListInterface<T> getFirstHalf() {
        //create the list that will store the result
        CustomList<T> finalList = new CustomList<>();
        //instantiate a ListIterator object that passes in the current list
        ListIterator<T> iterator = new ListIterator<>(this);

        if (isEmpty()) {
            throw new IllegalStateException();
        } else {
            //create a variable to store the midpoint, so we know where to stop
            int midpoint = (getLength() + 1) / 2;
            int currentNode = 0;
            //while there are still next elements and the current node is less than midpoint, add the next element to finalList and increment currentNode
            while (iterator.hasNext() && currentNode < midpoint) {
                finalList.add(iterator.next());
                currentNode++;
            }
            return finalList;
        }
    }

    /**
     * Returns the last half of the list.
     * If the number of elements in the list is odd, exclude the extra element.
     * For example if the list contains [23, 34, 98, 22, 12, 76, 81], the
     * method returns a list containing [12, 76, 81]
     *
     * @return an instance of a class that implements the ListInterface
     * */
    public ListInterface<T> getLastHalf() {
        //create the list that will store the result
        CustomList<T> finalList = new CustomList<>();
        //instantiate a ListIterator object that passes in the current list
        ListIterator<T> iterator = new ListIterator<>(this);

        if (isEmpty()) {
            throw new IllegalStateException();
        } else {
            int currentNode = 0;
            int midpoint = (getLength() + 1) / 2;
            //get the currentNode to the middle of the list
            while (iterator.hasNext() && currentNode < midpoint) {
                iterator.next();
                currentNode++;
            }

            //while there are still next elements in the list, add the next element to finalList and increment currentNode
            while (iterator.hasNext()) {
                finalList.add(iterator.next());
                currentNode++;
            }
            return finalList;
        }
    }

    /**
     * Returns a List that consists of all and only the elements
     * in every fourth positions (i.e., fourth, eighth, and so on) in
     * the current string, in the same order as the current list.
     *  If the list contains [23, 34, 98, 22, 12, 76, 81, 101], the
     *  method returns [22, 101]
     * @return an instance of a class that implements the ListInterface
     */
    public ListInterface<T> getEveryFourthElement() {
        CustomList<T> finalList = new CustomList<>();
        ListIterator<T> iterator = new ListIterator<>(this);

        //throw exception if list is empty
        if (isEmpty()) {
            throw new IllegalStateException();
        } else {
            //set currentNode to 1 bc 1 based index
            int currentNode = 1;
            //while list has a next element
            while (iterator.hasNext()) {
                //add to final list if the current node's position is divisible by 4
                if (currentNode % 4 == 0){
                    finalList.add(iterator.next());
                } else {
                    iterator.next(); //otherwise move onto the next element
                }
                currentNode++; //increment this to keep track
            }
            return finalList;
        }
    }

    /**
     * @return true if there are any elements in the list that occur twice
     *           false otherwise
     *           Note: if an element occurs more that twice, do not include it
     *  If the list contains [23, 34, 98, 22, 12, 76, 81, 101, 12, 23, 33, 23], the
     *  method returns true
     */
    public boolean hasDuplicates() {
        //create an outer iterator for the outer loop
        ListIterator<T> outerIterator = new ListIterator<>(this);

        while (outerIterator.hasNext()) {
            T outerElement = outerIterator.next();
            //create an inner iterator that resets each time the outer loop finishes
            ListIterator<T> innerIterator = new ListIterator<>(this);
            //use a counter to track duplicate occurrences
            int count = 0;
            //nest a while loop to compare all inner elements to the current outer element
            while (innerIterator.hasNext()) {
                T innerElement = innerIterator.next();
                if (outerElement.equals(innerElement)) {
                    count++; //increment count if a match is found
                }
            }
            //return true if count is 2
            if (count == 2) {
                return true;
            }
        }
        return false; //return false if no duplicates were found
    }

    /**
     * @return an instance of a class that implements the ListInterface that
     *           contains those elements in this list that appear more than once.
     *  If the list contains [23, 34, 98, 22, 12, 76, 81, 101, 12, 23, 33, 23], the
     *  method returns [23, 12]
     * */
    public ListInterface<T> getAllMultiples() {
        CustomList<T> multiplesList = new CustomList<>();
        //create an outer iterator for the outer loop
        ListIterator<T> outerIterator = new ListIterator<>(this);

        while (outerIterator.hasNext()) {
            T outerElement = outerIterator.next();
            //create an inner iterator that resets each time the outer loop finishes
            ListIterator<T> innerIterator = new ListIterator<>(this);
            //use a counter to track duplicate occurrences
            int count = 0;
            //nest a while loop to compare all inner elements to the current outer element
            while (innerIterator.hasNext()) {
                T innerElement = innerIterator.next();
                if (outerElement.equals(innerElement)) {
                    count++; //increment count if a match is found
                }
            }
            //if count is greater than 1
            if (count > 1) {
                //check that the outer element is in not already in the list
                if (!multiplesList.contains(outerElement)) {
                    multiplesList.add(outerElement); //add the outer element into the list
                }
            }
        }
        return multiplesList;
    }

    /**
     * Alters the list by deleting any elements that occur twice in the list.
     * Elements that occur more than 2 times remain in the list.
     *  If the list contains [23, 34, 98, 22, 12, 76, 81, 101, 12, 23, 33, 23], the
     *  method removes 12 and the list becomes [34, 98, 22, 76, 81, 101, 23, 33, 23]
     */
    public void removeAllDuplicates() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        //outer loop starting at the first element
        for (int i = 1; i <= getLength(); i++) {
            T outerElement = getEntry(i); //get element at position i
            boolean foundDuplicate = false; //flag to track if a duplicate has been found

            //inner loop to compare with all elements after the current outerElement
            for (int j = i + 1; j <= getLength(); j++) { //start at i + 1 to compare only subsequent elements
                T innerElement = getEntry(j); //get element at position j

                //if duplicate is found, remove the duplicate element at j
                if (outerElement.equals(innerElement)) {
                    remove(j); //remove the element at position j
                    foundDuplicate = true; //update flag
                    j--; //adjust j since the list shifted after removal
                }
            }

            //if a duplicate was found, remove the original element at i
            if (foundDuplicate) {
                remove(i); //remove the element at position i
                i--; //adjust i since the list shifted after removal
            }
        }
    }


    /**
     * Removes the nth node from the end of the list
     * For example, if the list contains [43, 68, 11, 5, 69, 37, 70] and 1 is passed to the method
     * a value of 70 is returned and the list becomes [43, 68, 11, 5, 69, 37]
     * @return the element from the position that was removed
     * */
    public T removeNthNodeFromEnd(int n) {
        //if list is empty, n is greater than length, or n is less than 1, throw exception
        if (isEmpty() || n > getLength() || n < 1) {
            throw new IllegalStateException();
        } else {
            int removeIndex = getLength() - n + 1; //subtract n from the end of the list and + 1 to get the position of where to remove
            T removedNode = getEntry(removeIndex); //store the entry at that position
            remove(removeIndex); //remove entry at removeIndex position
            return removedNode; //return the removed node
        }
    }
}
