package ru.geekbrains.ads.lesson7;

import java.util.Stack;

public class Lesson_7_DZ {

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Тамбов");
        graph.addVertex("Липецк");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdges("Москва","Тула");
        graph.addEdges("Москва","Калуга");
        graph.addEdges("Москва","Рязань");
        graph.addEdges("Тула","Липецк");
        graph.addEdges("Рязань","Тамбов");
        graph.addEdges("Калуга","Орел");
        graph.addEdges("Липецк","Воронеж");
        graph.addEdges("Тамбов","Саратов");
        graph.addEdges("Орел","Курск");
        graph.addEdges("Саратов","Воронеж");
        graph.addEdges("Курск","Воронеж");

//        Stack<String> path = graph.findShortPathViaBfs("Москва", "Воронеж");
//        Stack<String> path = graph.findShortPathViaBfs("Москва", "Саратов");
//        Stack<String> path = graph.findShortPathViaBfs("Липецк", "Тамбов");
        Stack<String> path = graph.findShortPathViaBfs("Рязань", "Курск");
        System.out.println("\n The shortest path:");
        showShortPath(path);
    }

    private static void showShortPath(Stack<String> path) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        while ( !path.isEmpty() ) {
            if (!isFirst) {
                sb.append(" -> ");
            }
            isFirst = false;
            sb.append(path.pop());
        }

        System.out.println(sb);
    }

}