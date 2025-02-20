public class Main {
    public static void main(String[] args) {

        var reverseGrade = new GradeComparator().reversed();
        // TODO: create your age Comparator here call it age here.

        // TODO: make your list of students.
        // TODO: sort then using reverseGrade.thenComparing(age)
        students.sort(reverseGrade.andThenComparing(age));

        // TODO: print out the list.


    }
}
