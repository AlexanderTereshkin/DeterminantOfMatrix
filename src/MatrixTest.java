public class MatrixTest {
    public static void main(String[] args) {
        Determinant det = new Determinant(10, 20, 7);
        det.displayMatrix();
        System.out.println("Determinant of this matrix is " + det.countDeterminant(det.getArray()));
    }
}
