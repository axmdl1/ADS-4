class Main {
    public static void main(String[] args) {
        MyGraph<String> graph = new MyGraph<>();

        graph.addVertex("Almaty");
        graph.addVertex("Astana");
        graph.addVertex("Shymkent");
        graph.addVertex("Pavlodar");
        graph.addVertex("Oral");
        graph.addVertex("Kyzylorda");

        graph.addEdge("Almaty","Astana");
        graph.addEdge("Almaty","Shymkent");
        graph.addEdge("Astana","Pavlodar");
        graph.addEdge("Astana","Oral");
        graph.addEdge("Astana","Kyzylorda");

        System.out.println(graph.getNeighbors("Almaty"));
        graph.printGraph();
        System.out.println(" ---------------- ");
        graph.removeEdge("Astana", "Oral");
        graph.removeVertex("Oral");
        graph.printGraph();
        System.out.println(graph.countVertices());
    }
}