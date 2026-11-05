public class Main {
    public static void main(String[] args) {
        BST movieBST = new BST();
        // إنشاء 10 أفلام مختلفة
        Movie movie1 = new Movie(1, "Inception", "Christopher Nolan", 8.8, 2010);
        Movie movie2 = new Movie(2, "The Matrix", "Lana Wachowski, Lilly Wachowski", 8.7, 1999);
        Movie movie3 = new Movie(3, "Interstellar", "Christopher Nolan", 8.6, 2014);
        Movie movie4 = new Movie(4, "The Dark Knight", "Christopher Nolan", 9.0, 2008);
        Movie movie5 = new Movie(5, "Pulp Fiction", "Quentin Tar antino", 8.9, 1994);
        Movie movie6 = new Movie(6, "The Shawshank Redemption", "Frank Darabont", 9.3, 1994);
        Movie movie7 = new Movie(7, "The Godfather", "Francis Ford Coppola", 9.2, 1972);
        Movie movie8 = new Movie(8, "The Godfather: Part II", "Francis Ford Coppola", 9.0, 1974);
        Movie movie9 = new Movie(9, "The Lord of the Rings: The Return of the King", "Peter Jackson", 8.9, 2003);
        Movie movie10 = new Movie(10, "The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", 8.8, 2001);
        System.out.println("**************************************************************************************************************************");
        // (BST) إدراج الأفلام في شجرة 
        movieBST.insert(movie1);
        movieBST.insert(movie2);
        movieBST.insert(movie3);
        movieBST.insert(movie4);
        movieBST.insert(movie5);
        movieBST.insert(movie6);
        movieBST.insert(movie7);
        movieBST.insert(movie8);
        movieBST.insert(movie9);
        movieBST.insert(movie10);
        movieBST.delete(1);


        System.out.println("Movies in the BST after deletion:");
        System.err.println(movieBST.toString());
    }
}
