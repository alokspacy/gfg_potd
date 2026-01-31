//Implement k Queues in a Single Array

class kQueues {
    int[] arr;      // Array to store elements
    int[] front;    // Front indices of queues
    int[] rear;     // Rear indices of queues
    int[] next;     // Next array to manage links
    int free;       // Beginning index of free list
    int n, k;

    // Constructor
    kQueues(int n, int k) {
        this.n = n;
        this.k = k;
        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        next = new int[n];

        // Initialize all queues as empty
        for (int i = 0; i < k; i++) {
            front[i] = -1;
            rear[i] = -1;
        }

        // Initialize free list
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        free = 0;
    }

    // Enqueue element x into queue i
    void enqueue(int x, int i) {
        if (isFull()) return; // No space left

        int insertAt = free;       // Get free index
        free = next[insertAt];     // Update free to next slot

        if (front[i] == -1) {
            front[i] = insertAt;   // First element in queue
        } else {
            next[rear[i]] = insertAt; // Link new element at rear
        }

        next[insertAt] = -1;       // End of queue
        rear[i] = insertAt;        // Update rear
        arr[insertAt] = x;         // Store element
    }

    // Dequeue element from queue i
    int dequeue(int i) {
        if (isEmpty(i)) return -1;

        int frontIndex = front[i];
        int result = arr[frontIndex];

        front[i] = next[frontIndex]; // Move front to next
        if (front[i] == -1) {
            rear[i] = -1; // Queue became empty
        }

        // Add this index back to free list
        next[frontIndex] = free;
        free = frontIndex;

        return result;
    }

    // Check if queue i is empty
    boolean isEmpty(int i) {
        return front[i] == -1;
    }

    // Check if array is full
    boolean isFull() {
        return free == -1;
    }
}
