public class BST {
private Movie root; //جذر الشجرة 


// إدراج فيلم جديد في الشجرة
public void insert(Movie newMovie){
     root = insertRecursive(root, newMovie);
     System.out.println("Movie inserted: " + newMovie.getTitle() + " successfully");
}
// طريقة مساعدة لإدراج فيلم بشكل تكراري
private Movie insertRecursive(Movie current, Movie newMovie){
     if (current == null) {
          return newMovie;
     }
     if (newMovie.getID() < current.getID()) {
          current.left = insertRecursive(current.left, newMovie);
     } else if (newMovie.getID() > current.getID()) {
          current.right = insertRecursive(current.right, newMovie);
     } else {
          return current;
     }
     return current;
}

// عرض الأفلام بترتيب تصاعدي حسب ID
public String toString() {
     StringBuilder sb = new StringBuilder();
     inOrderTraversal(root, sb);
     return sb.toString();
}

// Traversal in-order لعرض الأفلام بترتيب تصاعدي حسب ID
private void inOrderTraversal(Movie current, StringBuilder sb) {
     if (current == null) {
          return;
     }
     inOrderTraversal(current.left, sb);
     sb.append(current.getTitle()).append("\n");
     inOrderTraversal(current.right, sb);
}

// طريقة لحذف فيلم من الشجرة حسب ID
public void delete(int id){
     root = deleteRecursive(root, id);
     System.out.println("Movie with ID " + id + " deleted successfully");

}
// طريقة مساعدة لحذف فيلم بشكل تكراري
private Movie deleteRecursive(Movie current, int id) {
     if (current == null) {
          return null;
     }
     // البحث عن الفيلم المراد حذفه
     if(current.getID()==id){

     }
     if (id < current.getID()) {
          current.left = deleteRecursive(current.left, id);
     } else if (id > current.getID()) {
          current.right = deleteRecursive(current.right, id);
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
          current.right = deleteRecursive(current.right, successor.getID());
     }
     return current;

}

// طريقة للبحث عن أصغر قيمة في الشجرة
private Movie findMin(Movie current) {
     if (current == null) {
          return null;
     }
     while (current.left != null) {
          current = current.left;
     }
     return current;
}
// طريقة للبحث عن فيلم في الشجرة حسب ID
public Movie search(int id) {
     return searchRecursive(root, id);
}
private Movie searchRecursive(Movie current, int id) {
     if (current == null || current.getID() == id) {
          return current;
     }
     if (id < current.getID()) {
          return searchRecursive(current.left, id);
     } else {
          return searchRecursive(current.right, id);
     }
}
}