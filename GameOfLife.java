public class GameOfLife {
    private static final int ROWS = 40; // Количество строк
    private static final int COLS = 100; // Количество столбцов
    private static boolean[][] grid = new boolean[ROWS][COLS]; // Игровая сетка
    private static final int DELAY = 500; // Задержка между шагами (в миллисекундах)

    public static void main(String[] args) throws InterruptedException {
        // Инициализация сетки (начальное состояние)
        initializeGrid();

        System.out.println("Начальное состояние:");
        printGrid();

        // Основной цикл игры
        while (true) {
            Thread.sleep(DELAY); // Задержка между шагами
            nextGeneration(); // Переход к следующему поколению
            printGrid(); // Вывод текущего состояния
        }
    }

    // Инициализация начального состояния сетки
    private static void initializeGrid() {
        // Пример начального состояния (можно изменить)
        grid[1][2] = true;
        grid[2][3] = true;
        grid[3][1] = true;
        grid[3][2] = true;
        grid[3][3] = true;
    }

    // Вывод текущего состояния сетки
    private static void printGrid() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(grid[i][j] ? "O " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Переход к следующему поколению
    private static void nextGeneration() {
        boolean[][] newGrid = new boolean[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);

                if (grid[i][j]) {
                    // Правило 1 и 2: клетка умирает, если соседей меньше 2 или больше 3
                    newGrid[i][j] = liveNeighbors == 2 || liveNeighbors == 3;
                } else {
                    // Правило 3: клетка рождается, если соседей ровно 3
                    newGrid[i][j] = liveNeighbors == 3;
                }
            }
        }

        // Обновление сетки
        grid = newGrid;
    }

    // Подсчет живых соседей для клетки
    private static int countLiveNeighbors(int row, int col) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Пропустить саму клетку

                int newRow = row + i;
                int newCol = col + j;

                // Проверка границ сетки
                if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS) {
                    if (grid[newRow][newCol]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}