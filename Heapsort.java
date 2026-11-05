public class Heapsort {
    public static void sort(Movie[] movies) {
        int n = movies.length;

        // بناء الهيب (Heap)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(movies, n, i);
        }

        // استخراج العناصر من الهيب واحدًا تلو الآخر
        for (int i = n - 1; i >= 0; i--) {
            // نقل الجذر الحالي إلى نهاية المصفوفة
            Movie temp = movies[0];
            movies[0] = movies[i];
            movies[i] = temp;

            // استدعاء heapify على الهيب المتبقي
            heapify(movies, i, 0);
        }
    }

    // دالة مساعدة لإعادة ترتيب الهيب
    private static void heapify(Movie[] movies, int n, int i) {
        int largest = i; // الجذر
        int left = 2 * i + 1; // الابن الأيسر
        int right = 2 * i + 2; // الابن الأيمن

        // إذا كان الابن الأيسر أكبر من الجذر
        if (left < n && movies[left].getRating() > movies[largest].getRating()) {
            largest = left;
        }

        // إذا كان الابن الأيمن أكبر من الأكبر حتى الآن
        if (right < n && movies[right].getRating() > movies[largest].getRating()) {
            largest = right;
        }

        // إذا لم يكن الجذر هو الأكبر، قم بالتبديل واستدعاء heapify بشكل متكرر
        if (largest != i) {
            Movie swap = movies[i];
            movies[i] = movies[largest];
            movies[largest] = swap;

            heapify(movies, n, largest);
        }
    }

    
}
