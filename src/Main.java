class Main {
    public static void main(String[] args) {
        MyGraph<Integer> myGraph = new MyGraph<>();
        myGraph.addVertex(12);
        myGraph.addVertex(1);
        myGraph.addVertex(5);
        myGraph.addVertex(10);
        myGraph.addVertex(9);

        myGraph.addEdge(1,5);
        myGraph.addEdge(5,6);
        myGraph.addEdge(6,7);
        myGraph.addEdge(7,10);
        myGraph.addEdge(10,9);

        myGraph.printGraph();
    }
}