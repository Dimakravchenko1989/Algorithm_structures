// Урок 3. Структуры данных. Связный список.
// Задание 1. Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        SingleLinkList<Contact> List = new SingleLinkList<>();

        List.addToEnd(new Contact(111));
        List.addToEnd(new Contact(222));
        List.addToEnd(new Contact(333));
        List.addToEnd(new Contact(444));
        List.addToEnd(new Contact(555));

        for (Object contact : List) {
            System.out.println(contact);
        }
        List.reverse();

        System.out.println("-------------------------");

        for (Object contact : List) {
            System.out.println(contact);
        }
    }

    static class Contact {

        int id;

        public Contact(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "id = " + id ;
        }
    }

    /**
     * Класс списка
     *
     * @param <T>
     */
    public static class SingleLinkList<T> implements Iterable {

        ListItem<T> head;
        ListItem<T> tail;

        @Override
        public Iterator iterator() {
            return new Iterator<T>() {
                ListItem<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        /**
         * Класс отдельного элемента
         *
         * @param <T>
         */
        private static class ListItem<T> {

            T data;
            ListItem<T> next;
        }

        //Голова пустая
        public boolean isEmpty() {
            return head == null;
        }

        // Метод заполнения списка
        public void addToEnd(T item) {

            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;

            if (isEmpty()) {
                head = newItem;
                tail = newItem;
            } else {
                tail.next = newItem;
                tail = newItem;
            }
        }

        //Метод разворота списка
        public void reverse() {
            if (!isEmpty() && head.next != null) {
                tail = head;
                ListItem<T> current = head.next;
                head.next = null;
                while (current != null) {
                    ListItem<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}
