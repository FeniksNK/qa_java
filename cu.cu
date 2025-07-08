#include <cuda_runtime.h>
#include <iostream>

#define N 10  // Размер таблицы

__global__ void initializeTable(int *table, int size) {
    int i = threadIdx.x;
    if (i < size) {
        table[i] = i * i;  // Пример инициализации: квадрат индекса
    }
}

int main() {
    int h_table[N];         // Таблица на хосте (CPU)
    int *d_table;           // Таблица на устройстве (GPU)

    // Выделение памяти на устройстве
    cudaMalloc(&d_table, N * sizeof(int));

    // Инициализация таблицы на GPU
    initializeTable<<<1, N>>>(d_table, N);

    // Копирование данных обратно на хост
    cudaMemcpy(h_table, d_table, N * sizeof(int), cudaMemcpyDeviceToHost);

    // Вывод результата
    std::cout << "Таблица (квадраты чисел):" << std::endl;
    for (int i = 0; i < N; ++i) {
        std::cout << h_table[i] << " ";
    }

    // Освобождение памяти
    cudaFree(d_table);

    return 0;
}

