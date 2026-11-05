public class AVL {
    private Movie root;

   // دالة لحساب ارتفاع العقدة
    public int height(Movie node) {
        return (node == null) ? 0 : node.height;
    }
   // دالة لحساب توازن العقدة
    public int getBalance(Movie node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }
    // دوال التدوير (اليمين واليسار)
    public Movie rightRotate(Movie y) {
        Movie x = y.left;
        Movie T2 = x.right;
        x.right = y;
        y.left = T2;
        // تحديث الارتفاعات بعد التدوير 
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1; 
        return x;
    }
  // دالة التدوير اليساري
    public Movie leftRotate(Movie x) {
        Movie y = x.right;
        Movie T2 = y.left;
        y.left = x;
        x.right = T2;
        // تحديث الارتفاعات بعد التدوير
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public void insert(Movie movie) {
        root = insertRecursive(root, movie);
    }
     // طريقة مساعدة لإدراج فيلم بشكل تكراري
    private Movie insertRecursive(Movie current, Movie movie) {
        if (current == null) {
            movie.height = 1;
            return movie;
        }

      // مقارنة العناوين لترتيب الأفلام في الشجرة
        int compareResult = movie.getTitle().compareTo(current.getTitle());

        if (compareResult < 0)
            current.left = insertRecursive(current.left, movie);
        else if (compareResult > 0)
            current.right = insertRecursive(current.right, movie);
        else
            return current; // لا يسمح بإدراج أفلام بنفس العنوان


        // 1. تحديث ارتفاع العقدة الحالية
        current.height = 1 + Math.max(height(current.left), height(current.right));

        // 2. فحص التوازن
        int balance = getBalance(current);

       // 3. التعامل مع حالات عدم التوازن
        if (balance > 1 && movie.getTitle().compareTo(current.left.getTitle()) < 0)
            return rightRotate(current);

        if (balance < -1 && movie.getTitle().compareTo(current.right.getTitle()) > 0)
            return leftRotate(current);

        if (balance > 1 && movie.getTitle().compareTo(current.left.getTitle()) > 0) {
            current.left = leftRotate(current.left);
            return rightRotate(current);
        }

        if (balance < -1 && movie.getTitle().compareTo(current.right.getTitle()) < 0) {
            current.right = rightRotate(current.right);
            return leftRotate(current);
        }
        return current;
    }

    // طريقة لحذف فيلم من الشجرة حسب title
    public void delete(String title) {
        root = deleteRecursive(root, title);
        System.out.println("Movie with title " + title + " deleted successfully");
    }
    // طريقة مساعدة لحذف فيلم بشكل تكراري
    private Movie deleteRecursive(Movie current, String title) {  
        if (current == null) {
            return null;
        }
        // البحث عن الفيلم المراد حذفه
        if (current.getTitle().equals(title)) {

        }
        if (title.compareTo(current.getTitle()) < 0) {
            current.left = deleteRecursive(current.left, title);
        } else if (title.compareTo(current.getTitle()) > 0) {
            current.right = deleteRecursive(current.right, title);
        } else {
            // حالة 1: لا يوجد أبناء
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }
            // حالة 2: يوجد ابن واحد
            Movie successor = findMin(current.right);
            current.setTitle(successor.getTitle());
            current.setID(successor.getID());
            current.right = deleteRecursive(current.right, successor.getTitle());
        }
        return current;
    }
    // طريقة للبحث عن أصغر قيمة في الشجرة
    public Movie findMin(Movie node) {
        if (node == null)
            return null;
        while (node.left != null)
            node = node.left;
        return node;
    }
// طريقة للبحث عن فيلم في الشجرة حسب title
    public Movie searchByTitle(String title) {
        return searchRecursive(root, title);
    }

    private Movie searchRecursive(Movie node, String title) {
        if (node == null || node.getTitle().equalsIgnoreCase(title))
            return node;

        if (title.compareToIgnoreCase(node.getTitle()) < 0)
            return searchRecursive(node.left, title);
        
        return searchRecursive(node.right, title);
 
    }

}