public class Main {
    public static void main(String[] args) {

        AdjacencyGraph graph=new AdjacencyGraph();

        Vertex eskildstrup  = new Vertex("Eskildstrup");
        Vertex haslev = new Vertex("Haslev");
        Vertex holbæk = new Vertex( "Holbæk");
        Vertex jægerspris = new Vertex("Jægerspris");
        Vertex kalundborg = new Vertex("Kalundborg");
        Vertex korsør = new Vertex( "Korsør");
        Vertex køge = new Vertex("Køge");
        Vertex maribo = new Vertex("Maribo");
        Vertex nakskov = new Vertex("Nakskov");
        Vertex nykøbingF = new Vertex("Nykøbing F");
        Vertex næstved = new Vertex("Næstved");
        Vertex ringsted = new Vertex("Ringsted");
        Vertex roskilde = new Vertex("Roskilde");
        Vertex slagelse = new Vertex("Slagelse");
        Vertex sorø = new Vertex("Sorø");
        Vertex vordingborg = new Vertex("Vordingborg");


        graph.addVertex(eskildstrup);    //0
        graph.addVertex(haslev);         //1
        graph.addVertex(holbæk);         //2
        graph.addVertex(jægerspris);     //3
        graph.addVertex(kalundborg);     //4
        graph.addVertex(korsør);         //5
        graph.addVertex(køge);           //6
        graph.addVertex(maribo);         //7
        graph.addVertex(nakskov);        //8
        graph.addVertex(nykøbingF);      //9
        graph.addVertex(næstved);        //10
        graph.addVertex(ringsted);       //11
        graph.addVertex(roskilde);       //12
        graph.addVertex(slagelse);       //13
        graph.addVertex(sorø);           //14
        graph.addVertex(vordingborg);    //15

// https://www.geeksforgeeks.org/prims-mst-for-adjacency-list-representation-greedy-algo-6/
        graph.newEdge(eskildstrup, maribo, 28);
        graph.newEdge(eskildstrup, nykøbingF, 13);
        graph.newEdge(eskildstrup, vordingborg, 24);

        graph.newEdge(haslev, korsør, 60);
        graph.newEdge(haslev, køge, 24);
        graph.newEdge(haslev, næstved, 25);
        graph.newEdge(haslev, ringsted, 19);
        graph.newEdge(haslev, roskilde, 47);
        graph.newEdge(haslev, slagelse, 48);
        graph.newEdge(haslev, sorø, 34);
        graph.newEdge(haslev, vordingborg, 40);

        graph.newEdge(holbæk, jægerspris, 34);
        graph.newEdge(holbæk, kalundborg, 44);
        graph.newEdge(holbæk, korsør, 66);
        graph.newEdge(holbæk, ringsted, 36);
        graph.newEdge(holbæk, roskilde, 32);
        graph.newEdge(holbæk, slagelse, 46);
        graph.newEdge(holbæk, sorø, 34);

        graph.newEdge(jægerspris, korsør, 95);
        graph.newEdge(jægerspris, køge, 58);
        graph.newEdge(jægerspris, ringsted, 56);
        graph.newEdge(jægerspris, roskilde, 33);
        graph.newEdge(jægerspris, slagelse, 74);
        graph.newEdge(jægerspris, sorø, 63);

        graph.newEdge(kalundborg, ringsted, 62);
        graph.newEdge(kalundborg, roskilde, 70);
        graph.newEdge(kalundborg, slagelse, 39);
        graph.newEdge(kalundborg, sorø, 51);

        graph.newEdge(korsør, næstved, 45);
        graph.newEdge(korsør, slagelse, 20);

        graph.newEdge(køge, næstved, 45);
        graph.newEdge(køge, ringsted, 28);
        graph.newEdge(køge, roskilde, 25);
        graph.newEdge(køge, vordingborg, 60);

        graph.newEdge(maribo, nakskov, 27);
        graph.newEdge(maribo, nykøbingF, 26);

        graph.newEdge(næstved, roskilde, 57);
        graph.newEdge(næstved, ringsted, 26);
        graph.newEdge(næstved, slagelse, 37);
        graph.newEdge(næstved, sorø, 32);
        graph.newEdge(næstved, vordingborg, 28);

        graph.newEdge(ringsted, roskilde, 31);
        graph.newEdge(ringsted, sorø, 15);
        graph.newEdge(ringsted, vordingborg, 58);

        graph.newEdge(slagelse, sorø, 14);

        //graph.printGraph();
        graph.MSTPrims();
        graph.printMST();
    }
}


