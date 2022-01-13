package pl.emil;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Point pointA = new Point("A", 1, 1);
        Point pointB = new Point("B", 3, 1);
        Point pointC = new Point("C", 5, 3);
        Point pointD = new Point("D", 2, 8);
        Point pointE = new Point("E", 8, 8);

//        Point pointA = new Point("E", 2,3);
//        Point pointB = new Point("B", 5,1);
//        Point pointC = new Point("D", 4,7);
//        Point pointD = new Point("C", 7,7);
//        Point pointE = new Point("A", 7,3);

        pointB.putDistance(pointA);
        pointB.putDistance(pointC);
        pointB.putDistance(pointD);
        pointB.putDistance(pointE);

        pointA.putDistance(pointB);
        pointA.putDistance(pointC);
        pointA.putDistance(pointD);
        pointA.putDistance(pointE);

        pointC.putDistance(pointB);
        pointC.putDistance(pointA);
        pointC.putDistance(pointD);
        pointC.putDistance(pointE);

        pointD.putDistance(pointB);
        pointD.putDistance(pointC);
        pointD.putDistance(pointA);
        pointD.putDistance(pointE);

        pointE.putDistance(pointA);
        pointE.putDistance(pointB);
        pointE.putDistance(pointC);
        pointE.putDistance(pointD);

        pointB.pathsToB(pointA);
        pointB.pathsToB(pointC);
        pointB.pathsToB(pointD);
        pointB.pathsToB(pointE);

        System.out.println("Pary: ");
        System.out.println("Odległości od A: ");
        for (var entry : pointA.mapDistances.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
        System.out.println("Odległości od B: ");
        for (var entry : pointB.mapDistances.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
        System.out.println("Odległości od C: ");
        for (var entry : pointC.mapDistances.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
        System.out.println("Odległości od D: ");
        for (var entry : pointD.mapDistances.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
        System.out.println("Odległości od E: ");
        for (var entry : pointE.mapDistances.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
        System.out.println("Odległości do B: ");
        for (var entry : pointB.pathsToB.entrySet()) {
            System.out.println(pointB.getName() + " -> " + entry.getKey() + " : " + entry.getValue());
        }

        String startPoint = "B";

        Map<String, Point> pointMap = new HashMap<>();

        pointMap.put(pointA.getName(), pointA);
        pointMap.put(pointB.getName(), pointB);
        pointMap.put(pointC.getName(), pointC);
        pointMap.put(pointD.getName(), pointD);
        pointMap.put(pointE.getName(), pointE);

        for (var key : pointMap.keySet()) {
            System.out.println(key);
        }

        List<String> shortestPathList = new ArrayList<>();


        String actualPoint = startPoint;
        String previousPoint;
        Point temporaryPoint = pointMap.get(actualPoint);

        double totalDistance = 0.0;

        System.out.println("temporaryPoint: " + temporaryPoint.getName());


        for (int i = pointMap.size(); i > 1; i--) {
            shortestPathList.add(temporaryPoint.getName());
            pointMap.remove(actualPoint);
            Point.removeFromPathsToB(actualPoint);
            System.out.println();
            System.out.println("mapa punktów po usunięciu aktualnego punktu: ");
            for (var entry : pointMap.entrySet()) {
                System.out.println(entry.getKey());
            }
            previousPoint = actualPoint;
            System.out.println("actualPoint: " + actualPoint);
            System.out.println("temporaryPoint: " + temporaryPoint.getName());
            actualPoint = temporaryPoint.findClosestPoint();
            System.out.println("actualPoint2: " + actualPoint);
            totalDistance = totalDistance + temporaryPoint.getClosestDistance(actualPoint);
            System.out.println("totalny przebyty dystans: " + totalDistance);
            temporaryPoint = pointMap.get(actualPoint);
            System.out.println("temporary point: " + temporaryPoint.getName());
            System.out.println("previous point: " + previousPoint);
            if (temporaryPoint != null) {
                if (temporaryPoint.getMapDistances().size() > 0) {
                    temporaryPoint.removePointFromMapDistances(previousPoint);
                }
            } else {
                for(var key : pointMap.keySet()){
                    String firstPoint = pointMap.get();
                }
        }

        shortestPathList.add(temporaryPoint.getName());

        System.out.print("The shortest way is: ");
        for (String s : shortestPathList) {
            System.out.print(s + " > ");
        }
        System.out.println(startPoint);

        totalDistance = totalDistance + temporaryPoint.getClosestDistance(startPoint);
        System.out.println("Total distance= " + totalDistance);

    }
}
