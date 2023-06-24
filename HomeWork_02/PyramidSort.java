// Урок 2. Структуры данных. Массивы. Алгоритмы массивов.
// Задание 1. Реализовать алгоритм пирамидальной сортировки (сортировка кучей).

public class PyramidSort {
    /**
     * Метод запуска сортировки массива
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {124, 4, 5, 2, 1, -3, 0, 76, 558, 91, 27,2, 2444};
        printArray(arr);
        heapSort(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println();

    }

    /**
     * Метод создания дерева массива
     * @param arr
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        for(int i  = n / 2 - 1; i >= 0; i--)
            heapify(arr, i , n);

        for (int i = n - 1; i >= 0; i--){

            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, 0, i);
        }
    }

    /**
     * Главный метод в котором будет меняться структура данных
     * так чтоб родитель был максимальны элементом по сравнению
     * со своими детьми в дереве
     * @param arr
     * @param i
     * @param n
     */
    private static void heapify(int[] arr, int i, int n) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;

        if(l < n && arr[l] > arr[largest])
            largest = l;

        if(r < n && arr[r] > arr[largest])
            largest = r;

        if (i != largest){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, largest, n);
        }
    }
}