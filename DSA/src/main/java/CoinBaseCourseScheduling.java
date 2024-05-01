
import java.util.*;

public class CoinBaseCourseScheduling {
    public static void main(String[] argv) {
        String[][] prereqsCourses1 = {
                {"Foundations of Computer Science", "Operating Systems"},
                {"Data Structures", "Algorithms"},
                {"Computer Networks", "Computer Architecture"},
                {"Algorithms", "Foundations of Computer Science"},
                {"Computer Architecture", "Data Structures"},
                {"Software Design", "Computer Networks"}
        };

        String[][] prereqsCourses2 = {
                {"Data Structures", "Algorithms"},
                {"Algorithms", "Foundations of Computer Science"},
                {"Foundations of Computer Science", "Logic"}
        };

        String[][] prereqsCourses3 = {
                {"Data Structures", "Algorithms"}
        };


        String output = findTheMidCourse(prereqsCourses3);
        System.out.println(output);
    }

    private static String findTheMidCourse(String[][] prereqsCourses) {

        Map<String, String> depedencyGraph = new HashMap<>();
        Map<String, Integer> indgree = new HashMap<>();

        for(String[] coursesList: prereqsCourses) {
            String courseNeedToBeCompleted = coursesList[1];
            String courseItDependesOn = coursesList[0];
            indgree.put(courseNeedToBeCompleted, 0);
            indgree.put(courseItDependesOn, 0);
        }


        for(String[] coursesList: prereqsCourses) {

            String courseNeedToBeCompleted = coursesList[1];
            String courseItDependesOn = coursesList[0];
            depedencyGraph.put(courseItDependesOn, courseNeedToBeCompleted);
            indgree.put(courseNeedToBeCompleted, indgree.get(courseNeedToBeCompleted)+1);
        }

        //find the starting point
        String startingCourse = "";
        for(String[] coursesList: prereqsCourses) {
            String course = coursesList[0];
            if(indgree.get(course) == 0) {
                startingCourse = course;
            }
        }

        List<String> sequenceOfCourses = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startingCourse);

        while(!queue.isEmpty()) {

            String course = queue.poll();
            sequenceOfCourses.add(course);
            //find all the course which can start after the above course is done
            String courseCanStartNow = depedencyGraph.get(course);

            if(courseCanStartNow!=null)
            queue.add(courseCanStartNow);
        }

        //FIND THE MID ONE
        //if even, find the f
        int mid = 0;
        if(sequenceOfCourses.size()%2 != 0 ) {

            mid = sequenceOfCourses.size()/2;

        } else {
            mid = sequenceOfCourses.size()/2 -1;
        }

        //return the mid index course
        for(int i=0; i<sequenceOfCourses.size(); i++) {
            if(i == mid) {
                return sequenceOfCourses.get(i);
            }
        }
        return "";
    }
}
