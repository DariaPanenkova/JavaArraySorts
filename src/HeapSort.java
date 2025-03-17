public class HeapSort {
    // Реализация пирамидальной сортировки на Java
    public void sort(int arr[])
    {
        int arrLength = arr.length;

        // Построение кучи (перегруппируем массив)
        for (int i = arrLength / 2 - 1; i >= 0; i--)
            heapify(arr, arrLength, i);

        // Один за другим извлекаем элементы из кучи
        for (int heapSize = arrLength-1; heapSize >= 0; heapSize--)
        {
            // Перемещаем текущий корень (0-ой элемент) в конец
            int temp = arr[0];
            arr[0] = arr[heapSize];
            arr[heapSize] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, heapSize, 0);
        }
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом curRoot, что является
    // индексом в arr[]. heapSize - размер кучи
    void heapify(int arr[], int heapSize, int curRoot)
    {
        int largest = curRoot; // Инициализируем наибольший элемент как корень
        int leftChild = 2*curRoot + 1; // левый = 2*i + 1
        int rightChild = 2*curRoot + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (leftChild < heapSize && arr[leftChild] > arr[largest])
            largest = leftChild;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && arr[rightChild] > arr[largest])
            largest = rightChild;

        // Если самый большой элемент не корень
        if (largest != curRoot)
        {
            int swap = arr[curRoot];
            arr[curRoot] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, heapSize, largest);
        }
    }

    /* Вспомогательная функция для вывода на экран массива размера n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Управляющая программа
    public static void main(String args[])
    {
        int arr[] = {8,3,2,7,9,1,4};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
